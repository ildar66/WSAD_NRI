package com.hps.july.inventory.formbean;

import javax.ejb.ObjectNotFoundException;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import org.apache.struts.upload.*;
import java.io.*;
import java.util.*;

/**
 * Форма загрузки строк документа "Внутренний приходный ордер" из Excel
 */
public class InternalLoadExcelForm extends com.hps.july.web.util.EditForm {
	private int doc;
	private String documentState;
	private String options;
	private Vector data;
	private FormFile psiondataFrm;
public InternalLoadExcelForm() {
	options = "1";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	InternalWayBillPositionAccessBean dp = new InternalWayBillPositionAccessBean();
	InternalWayBillPositionAccessBean dpindoc = null;
	InternalWayBillAccessBean d = new InternalWayBillAccessBean();
	d.setInitKey_document(doc);
	d.refreshCopyHelper();

	int owner = d.getOwner().getOrganization();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

	int docposition;
	int resource = 0;
	int order = 1;

	StorageCardAccessBean cardfind = new StorageCardAccessBean();
	StorageCardAccessBean card;
	ResourceAccessBean resfind = new ResourceAccessBean();
	ResourceAccessBean r;
	java.math.BigDecimal price;
	Boolean sourceBoxed;
	Boolean resultBoxed;
	Boolean sourceBroken;
	Boolean resultBroken;
	Boolean sourceClosed;
	Boolean resultClosed;

	try {
		dpindoc = dp.findMaxOrderPosition(new Integer(doc));
		order = dpindoc.getOrder()+1;
	} catch(Exception e) {
		order = 1;
	}

	for(int i = 0; i < data.size(); i++) {
		String[] item = (String[])data.get(i);
		docposition = keyGen.getNextKey("tables.docpositions");
		price = new java.math.BigDecimal("0.00");
		resource = 0;
		try {
			/*
			try {
			card = cardfind.findBySerialAndCode(item[1],new Boolean("1".equals(option)),item[0]);
			} catch(ObjectNotFoundException e) {
				if("1".equals(option)) {
					// Не найдена карточка или серийный номер
				} else {
					// Не найден серийный номер
				}
			}
			*/
			card = cardfind.findBySerial(item[1]);
			resource = card.getResource().getResource();
			price = card.getPrice();
			owner = card.getOwner().getOrganization();
			sourceBoxed = card.getBoxed();
			sourceBroken = new Boolean(card.getBroken().booleanValue() | d.getFixing().booleanValue());
			sourceClosed = card.getClosed();

			if("1".equals(options)) {
				Enumeration en = resfind.findResourcesByQBE2(
					Boolean.FALSE, new ResourceSubTypeKey(0),
					Boolean.FALSE, "", Boolean.FALSE, "",
					Boolean.FALSE, new Integer(0),
					Boolean.TRUE, item[0], new Integer(1)
				);
				if(en.hasMoreElements()) {
					r = (ResourceAccessBean)en.nextElement();
					resource = r.getResource();
				}
			}
		
			if(resource > 0) {		
				dp = new InternalWayBillPositionAccessBean(
					docposition,
					new Integer(resource),
					new Integer(owner),
					new Integer(doc),
					order++,
					new java.math.BigDecimal("1.0"),
					price,
					sourceBoxed,
					Boolean.FALSE,
					sourceBroken,
					Boolean.FALSE,
					sourceClosed,
					Boolean.FALSE
				);
				dp.setDocQty(new java.math.BigDecimal("1.0"));
				dp.setSerialnumber(item[1]);
				dp.commitCopyHelper();
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}

	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	/*
	DocumentAccessBean bean = new DocumentAccessBean();
	bean.setInitKey_document(getDoc());
	return bean;
	*/
	return null;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
{
	return null;
}
public int getDoc() {
	return doc;
}
public java.lang.String getDocumentState() {
	return documentState;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOptions() {
	return options;
}
/**
 * 
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getPsiondataFrm() {
	return psiondataFrm;
}
public int getState() {
	return com.hps.july.inventory.APPStates.IOLOADEXCEL;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 17:53:26)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	// gets document and fillin data with it
}
public void parseFile()
	throws Exception
{
	if(data == null) {
		data = new Vector();
	} else {
		data.clear();
	}
	if(psiondataFrm == null)
		throw new Exception();
	try {
		//System.out.println("LOAD CSV File ct:"+psiondataFrm.getContentType());
		Reader r = new BufferedReader(new InputStreamReader(psiondataFrm.getInputStream()));
		StreamTokenizer st = new StreamTokenizer(r);
		st.resetSyntax();
		st.eolIsSignificant(true);
		st.quoteChar('"');
		st.quoteChar('\'');
		st.wordChars((int)' ',(int)'!');
		st.wordChars((int)'#',(int)'+');
		st.wordChars((int)'<',(int)'?');
		st.wordChars((int)'-',(int)'/');
		st.wordChars((int)'0',(int)'9');
		st.wordChars((int)'_',(int)'z');
		st.wordChars((int)'A',(int)'Z');
		st.wordChars(0x00A0,0x00FF);
		st.ordinaryChar(',');
		st.ordinaryChar(';');

		try {
			int token;
			int arr = 0;
			String[] arrval = new String[3];
			boolean parsing = true;
			while(parsing) {
				token = st.nextToken();
				switch(token) {
					case 34: // "
					case 39: // '
					case StreamTokenizer.TT_WORD:
						if(arr < 3 && arrval[arr] == null && st.sval != null) {
							arrval[arr] = st.sval.trim();
						}
					break;
					case StreamTokenizer.TT_EOL:
					case StreamTokenizer.TT_EOF:
						arr++;
						data.add(arrval);
						arrval = new String[3];
						if(arr > 2) {
							arr = 0;
						}
						if(StreamTokenizer.TT_EOF == token) {
							parsing = false;
						}
					break;
					default: // any ordinary char
						arr++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		r.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
public void setDoc(int newDoc) {
	doc = newDoc;
}
public void setDocumentState(java.lang.String newDocumentState) {
	documentState = newDocumentState;
}
/**
 * 
 * @param newOptions java.lang.String
 */
public void setOptions(java.lang.String newOptions) {
	options = newOptions;
}
/**
 * 
 * @param newPsiondataFrm org.apache.struts.upload.FormFile
 */
public void setPsiondataFrm(org.apache.struts.upload.FormFile newPsiondataFrm) {
	psiondataFrm = newPsiondataFrm;
}
public void validateValues(ActionErrors errors) throws Exception 
{
//	System.out.println("Psion.Validation");
	DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
	DocumentPositionAccessBean dpindoc = null;
	DocumentAccessBean d = new DocumentAccessBean();
	d.setInitKey_document(doc);
	try {
		d.refreshCopyHelper();
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.docisnotset"));
		throw new ValidationException();
	}
	StorageCardAccessBean cardfind = new StorageCardAccessBean();
	StorageCardAccessBean card;
	ResourceAccessBean resfind = new ResourceAccessBean();
	ResourceAccessBean r;

	if(psiondataFrm != null) {
		if("application/octet-stream".equals(psiondataFrm.getContentType()) || "text/plain".equals(psiondataFrm.getContentType())) {
		try {
			parseFile();
			int lineno = 0;
			Iterator it = data.iterator();
			while(it.hasNext()) {
				lineno++;
				String[] item = (String[])it.next();
				// check here for rights
				if(item[1] == null) {
					it.remove();
					continue;
				}
				// check here for rights
				try{
					dpindoc = dp.findByDocumentSerialnum(new Integer(doc),item[1]); }
				catch(javax.ejb.ObjectNotFoundException onfe) {
					dpindoc = null;
				}
				if( dpindoc != null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.allreadyentered",new Integer(lineno)));
				} else {
					try {
						card = cardfind.findBySerial(item[1]);
						if("1".equals(options)) {
							if(item[0] == null || "".equals(item[0])) {
								it.remove();
								continue;
							}
							Enumeration en = resfind.findResourcesByQBE2(
								Boolean.FALSE, new ResourceSubTypeKey(0),
								Boolean.FALSE, "", Boolean.FALSE, "",
								Boolean.FALSE, new Integer(0),
								Boolean.TRUE, item[0], new Integer(1)
							);
							if(!en.hasMoreElements()) {
								errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.resourcenotfound",new Integer(lineno),item[0]));
							} else {
								r = (ResourceAccessBean)en.nextElement();
								if(card.getResource().getResource() != r.getResource()) {
									errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.resourcemismatch",new Integer(lineno),item[0],item[1]));
								}
							}
						}
					} catch(ObjectNotFoundException e) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.serialnotfound",new Integer(lineno),item[1]));
					}
				}
			}
		} catch(java.text.ParseException e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.badformat"));
		}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.badmime"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.fileisnull"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
