package com.hps.july.inventory.formbean;

import java.math.BigDecimal;
import com.hps.july.inventory.valueobject.INVParser;
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
 * ‘орма загрузки строк документа "јкт инвентаризации на позиции" из файла INV
 * ‘айлы типа INV €вл€ютс€ текстовыми файлами с результатами опроса оборудовани€ на позиции
 */
public class InvLoadInvForm extends com.hps.july.web.util.EditForm {
	private int doc;
	private String docState;
	private Vector data;
	private FormFile dataFrm;
public InvLoadInvForm() {
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	/*
//	I13nActAccessBean d = new I13nActAccessBean();
//	d.setInitKey_document(doc);
//	d.refreshCopyHelper();
	DocumentPositionAccessBean pos = new DocumentPositionAccessBean();
	ResourceAccessBean res = new ResourceAccessBean();
	I13nActPositionAccessBean invpos = new I13nActPositionAccessBean();
	I13nActAccessBean act = new I13nActAccessBean();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	try {
		act.setInitKey_document(doc);
		act.refreshCopyHelper();
	} catch(Exception e) {
		throw new Exception();
	}
	
	if(!"A".equals(act.getType())) {
		throw new Exception();
	}

	if(data != null) {
		// Check manucode for each data item
		boolean create = false;
		Integer resource = null;
		int owner = act.getOwner().getOrganization();
		BigDecimal argQty;
		BigDecimal argPrice;
		Boolean boxed = Boolean.FALSE;
		Boolean closed = Boolean.FALSE;
		Boolean broken = Boolean.FALSE;
		String oldPlace = null;
		StorageCardAccessBean card;
		for(int i=0; i<data.size(); i++) {
			String[] item = (String[])data.get(i);
			// item[0] is mnemonic;
			// item[1] is serialnumber
			// item[2] is manucode
			Enumeration en = res.findResourcesByQBE2(
				Boolean.FALSE, new ResourceSubTypeKey(0),
				Boolean.FALSE, "", Boolean.FALSE, "",
				Boolean.FALSE, new Integer(0),
				Boolean.TRUE, item[2], new Integer(1)
			);
			if(en.hasMoreElements()) {
				try {
					ResourceAccessBean r = (ResourceAccessBean)en.nextElement();
					resource = new Integer(r.getResource());
					create = true;
				} catch(Exception e) {
					resource = null;
				}
			}
			// create position
			if(create) {
			}
		}
	}
	*/
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return null;
}
public String createPosition(int doc, int owner, int newId, int order, Integer resource, String serial, String newPlace)
{
	StorageCardAccessBean card = null;
	BigDecimal argPrice = new BigDecimal("0.00");
	Boolean boxed = Boolean.FALSE;
	Boolean broken = Boolean.FALSE;
	Boolean closed = Boolean.FALSE;
	boolean fser = false;
	String oldPlace = "";
	if(serial != null && !"".equals(serial.trim())) {
		try {
			card = (new StorageCardAccessBean()).findBySerial(serial);
			resource = new Integer(card.getResource().getResource());
			owner = card.getOwner().getOrganization();
			argPrice = card.getPrice();
			boxed = card.getBoxed();
			broken = card.getBroken();
			closed = card.getClosed();
			fser = card.getIsfictserial();
			oldPlace = card.getPlace();
		} catch(Exception e) {
//			card = null;
//			argPrice = new BigDecimal("0.00");
		}
	}
	try {
		I13nActPositionAccessBean invpos = new I13nActPositionAccessBean(
			newId, // keyGen.getNextKey("tables.docpositions")
			resource,
			new Integer(owner),
			new Integer(doc),
			order, 
			new BigDecimal("1"),
			argPrice,
			boxed,
			boxed,
			broken,
			broken,
			"N",
			closed,
			closed
		);
		invpos.setIsfictserial(fser);
		if(fser) {
			invpos.setSerialnumber(null);
		} else {
			invpos.setSerialnumber(serial);
		}
		invpos.setRealserial(null);
		invpos.setManufserial(serial);
		invpos.setNewplace(newPlace);
		invpos.setOldplace(oldPlace);
		invpos.commitCopyHelper();
		return null;
	} catch(Exception e) {
		return "error.loadinv.cantcratev";
	}
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		DocumentAccessBean d = (DocumentAccessBean)bean;
		docState = d.getDocumentState();
	} catch(Exception e) {
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
{
	return null;
}
/**
 * 
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getDataFrm() {
	return dataFrm;
}
public int getDoc() {
	return doc;
}
public java.lang.String getDocState() {
	return docState;
}
public int getNextOrder() {
	try {
		DocumentPositionAccessBean dp = (new DocumentPositionAccessBean()).findMaxOrderPosition(new Integer(doc));
		return dp.getOrder() + 1;
	} catch(Exception e) {
		return 1;
	}
}
public int getState() {
	return com.hps.july.inventory.APPStates.INVLOADINV;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
}
public void parseFile()
	throws Exception
{
	/*
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
		st.wordChars((int)' ',(int)' ');
		st.wordChars((int)'0',(int)'9');
		st.wordChars((int)'a',(int)'z');
		st.wordChars((int)'A',(int)'Z');
		st.wordChars(0x00A0,0x00FF);

		try {
			int token;
			int arr = 0;
			String[] arrval = new String[3];
			while((token = st.nextToken()) != StreamTokenizer.TT_EOF) {
				switch(token) {
					case 34: // "
					case 39: // '
					case StreamTokenizer.TT_WORD:
						if(arr < 3 && arrval[arr] == null && st.sval != null) {
							arrval[arr] = st.sval.trim();
						}
					break;
					case StreamTokenizer.TT_EOL:
						arr++;
						data.add(arrval);
						arrval = new String[3];
						if(arr > 2) {
							arr = 0;
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
	*/
}
/**
 * 
 * @param newDataFrm org.apache.struts.upload.FormFile
 */
public void setDataFrm(org.apache.struts.upload.FormFile newDataFrm) {
	dataFrm = newDataFrm;
}
public void setDoc(int newDoc) {
	doc = newDoc;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	boolean haserrors = false;
	ArrayList createData = new ArrayList();
	
	DocumentPositionAccessBean pos = new DocumentPositionAccessBean();
	ResourceAccessBean res = new ResourceAccessBean();
	I13nActPositionAccessBean invpos = new I13nActPositionAccessBean();
	I13nActAccessBean act = new I13nActAccessBean();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	try {
		act.setInitKey_document(doc);
		act.refreshCopyHelper();
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.docisnotset"));
		throw new ValidationException();
	}
	
	if(!"A".equals(act.getType())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.invalidact"));
		throw new ValidationException();
	}

	if(dataFrm != null) {
		String filename = dataFrm.getFileName();
		// TZ 1
		INVParser parser = new INVParser(dataFrm.getInputStream());
		if(parser.isErrors()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.errors",filename));
			Vector eee = parser.getErrors();
			for(int j = 0; j < eee.size(); j++) {
				String[] erli = (String[])eee.get(j);
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.errorline",erli[0],erli[1]));
			}
			throw new ValidationException();
		}
		try {
			if(parser.getSid() > 0) {
				// TZ 2
				StoragePlaceAccessBean _a = act.getTo();
				_a.refreshCopyHelper();
				EquipmentSetAccessBean equ = new EquipmentSetAccessBean(_a.getEJBRef());
				if(equ.getPosition().getGsmid() == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.sourcegsmnull"));
					throw new ValidationException();
				}
				if(equ.getPosition().getGsmid().intValue() != parser.getSid()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.gsmidmismatch",filename));
					throw new ValidationException();
				}
				// TZ 3
				if(act.getAgregate() == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.agregatenotset"));
					throw new ValidationException();
				}
				if(!parser.getHeadSerialnumber().equals(act.getAgregate().getSerialnumber())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.agregateinvalid",
						filename,parser.getHeadSerialnumber(),act.getAgregate().getSerialnumber()));
					throw new ValidationException();
				}
				// TZ 4
				data = parser.getData();
				if(data != null) {
					// Check manucode for each data item
					boolean create = false;
					Integer resource = null;
					StorageCardAccessBean card;
					Iterator it = data.iterator();
					// item[0] is mnemonic;
					// item[1] is serialnumber
					// item[2] is manucode
					while(it.hasNext()) {
						String[] item = (String[])it.next();
						Enumeration en = res.findResourcesByQBE2(
							Boolean.FALSE, new ResourceSubTypeKey(0),
							Boolean.FALSE, "", Boolean.FALSE, "",
							Boolean.FALSE, new Integer(0),
							Boolean.TRUE, item[2], new Integer(1)
						);
						if(!en.hasMoreElements()) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.noresource",item[4],item[2],item[0]));
						} else {
							try {
								ResourceAccessBean r = (ResourceAccessBean)en.nextElement();
								r.refreshCopyHelper();
								resource = new Integer(r.getResource());
								if("S".equals(r.getCountpolicy())) {
									create = true;
									if(item[1] == null || "".equals(item[1])) {
										errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.serialabsent",item[4],item[0]));
									} else {
										try {
											//System.out.println("*#* Check for DOC:"+doc+", serial:"+item[1]);
											pos.findByDocumentSerialnum(new Integer(doc),item[1]);
											it.remove();
											create = false;
											// errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.serialexist",item[4],item[1]));
											// set skip to this item
										} catch(Exception e) {
//											e.printStackTrace(System.out);
										}
									}
								}
							} catch(Exception e) {
								resource = null;
							}
						}

						if(resource == null) {
							create = false;
							haserrors = true;
						}
						// add info for position creation
						if(create) {
							createData.add(new Object[] {
								new Integer(doc),
								new Integer(act.getOwner().getOrganization()),
								resource,
								item[1],
								item[3]
							});
						}
					}	
						// create position
					if(!createData.isEmpty() && !haserrors) {
						Iterator icd = createData.iterator();
						
						while(icd.hasNext()) {
							Object[] os = (Object[])icd.next();
							
							String s = createPosition(
									((Integer)os[0]).intValue(),
									((Integer)os[1]).intValue(),
									keyGen.getNextKey("tables.docpositions"),
									getNextOrder(),
									(Integer)os[2],
									(String)os[3],
									(String)os[4]
								);
							if(s != null) {
								errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(s));
							}
						}
					}
				} else {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.noblocks"));
//					throw new ValidationException();
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.loadinv.sidnotfound",filename));
			}
		} catch(Exception e) {
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
