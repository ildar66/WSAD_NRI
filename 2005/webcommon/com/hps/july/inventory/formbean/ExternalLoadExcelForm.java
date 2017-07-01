package com.hps.july.inventory.formbean;

import java.math.BigDecimal;
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
 * Форма загрузки строк документа "Внешний приходный ордер" из файла Excel
 */
public class ExternalLoadExcelForm extends com.hps.july.web.util.EditForm {
	private int doc;
	private String documentState;
	private String options;
	private Vector data;
	private FormFile psiondataFrm;
public ExternalLoadExcelForm() {
	options = "1";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	InWayBillPositionAccessBean dp = new InWayBillPositionAccessBean();
	InWayBillPositionAccessBean dpindoc = null;
	DocumentAccessBean d = new DocumentAccessBean();
	d.setInitKey_document(doc);
	d.refreshCopyHelper();

	int owner = d.getOwner().getOrganization();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

	int docposition;
	int resource = 0;

	StorageCardAccessBean cardfind = new StorageCardAccessBean();
	StorageCardAccessBean card;
	ResourceAccessBean resfind = new ResourceAccessBean();
	ResourceAccessBean r;
	java.math.BigDecimal price;

	Hashtable ht = new Hashtable();
	Vector v = new Vector();
	Enumeration en = data.elements();
	String[] item;

	while(en.hasMoreElements())
	{
		item = (String[])en.nextElement();
		if(item[0] != null) {
			if(ht.containsKey(item[0])) {
				v = (Vector)ht.get(item[0]);
			} else {
				v = new Vector();
				ht.put(item[0],v);
			}
			v.add(item[1]);
		}
	}

	int order;
	try {
		order = (new OuterDocPositionAccessBean()).findMaxOrderPosition(new Integer(doc)).getOrder() + 1;
	} catch(Exception e) {
		order = 1;
	}
	
	
	en = ht.keys();
	while(en.hasMoreElements()) {
		String key = (String)en.nextElement();
		v = (Vector)ht.get(key);
		Enumeration ev = v.elements();
		// find resource
		Enumeration renv = resfind.findResourcesByQBE2(
			Boolean.FALSE, new ResourceSubTypeKey(0),
			Boolean.FALSE, "", Boolean.FALSE, "",
			Boolean.FALSE, new Integer(0),
			Boolean.TRUE, key, new Integer(1)
		);
		if(renv.hasMoreElements()) {
			r = (ResourceAccessBean)renv.nextElement();
			resource = r.getResource();
		}
		if(resource > 0) {
			// create outerdocposition
			OuterDocPositionAccessBean odp = new OuterDocPositionAccessBean();
			Enumeration odpen = odp.findByDocumentResource(new Integer(doc), new Integer(resource));
			if(odpen.hasMoreElements()) {
				odp = (OuterDocPositionAccessBean)odpen.nextElement();
				odp.setOuterQty(odp.getOuterQty().add(new BigDecimal(v.size())));
				odp.commitCopyHelper();
			} else {
				odp = new OuterDocPositionAccessBean(
					keyGen.getNextKey("tables.outerdocpositions"),
					new Integer(resource),
					new Integer(doc)
				);
				odp.setOrder(order++);
				odp.setOuterPrice(new BigDecimal("0.0"));
				odp.setOuterQty(new BigDecimal(v.size()));
				odp.commitCopyHelper();
			}
			
			//System.out.println("Resource code: "+key);
			//System.out.println("  Number of resources: "+v.size());
			int neworder = 1;
			try {
				neworder = (dp.findMaxOrderPosition(new Integer(odp.getOuterDocPosition()))).getOrder() + 1;
			} catch(Exception e) {
			}
			while(ev.hasMoreElements()) {
				String sn = (String)ev.nextElement();
				// create docposition
				dp = new InWayBillPositionAccessBean(
					keyGen.getNextKey("tables.docpositions"),
					new Integer(resource),
					new Integer(owner),
					new Integer(doc),
					neworder++,
					new BigDecimal("1.0"),
					new BigDecimal("0.0"),
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					new Integer(odp.getOuterDocPosition()),
					new BigDecimal("0.0")
				);
				dp.setSerialnumber(sn);
				dp.commitCopyHelper();
			}
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
	return com.hps.july.inventory.APPStates.EOLOADEXCEL;
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
		st.wordChars((int)'0',(int)':');
		st.wordChars((int)'_',(int)'z');
		st.wordChars((int)'A',(int)'Z');
		st.wordChars(0x00A0,0x00FF);

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
				try{ dpindoc = dp.findByDocumentSerialnum(new Integer(doc),item[1]); }
				catch(javax.ejb.ObjectNotFoundException onfe) {	dpindoc = null; }
				if( dpindoc != null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.allreadyentered",new Integer(lineno)));
				} else {
					try {
						card = cardfind.findBySerial(item[1]);
					} catch(ObjectNotFoundException e) {
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
							}
//							else {
//								errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.serialnotfound",new Integer(lineno),item[1]));
//							}
						} else {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.serialnotfound",new Integer(lineno),item[1]));
						}
					}
				}
			}
		} catch(java.text.ParseException e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.badformat"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadpsion.fileisnull"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
