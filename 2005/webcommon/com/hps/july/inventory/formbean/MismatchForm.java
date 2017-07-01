package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;

/**
 * Форма ввода и редактирования акта рассогласования прикрепляемого к
 * документу "Внешний приходный ордер".
 * Форма вызывается только из списка актов рассогласования
 */
public class MismatchForm extends com.hps.july.web.util.EditForm {
	private String ownername;
	private String storagename;
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private StringAndSqlDateProperty blankdate;
	private String cordocnum;
	private StringAndSqlDateProperty cordocdate;
	private String suppliername;
	private String stateOfDocument; // values: '1','2'
	
	private String dActNumber;
	private StringAndSqlDateProperty dActDate;
	private String dActRepresentative;
	private StringAndIntegerProperty dActStorManagercode;
	private String dActStorManagername;
	private String dActStorManagertitle;
	private StringAndIntegerProperty dActTechStufcode;
	private String dActTechStufname;
	private String dActTechStuftitle;
	private String dActFileName;
	private Boolean dActFileDelete;

	private StringAndIntegerProperty document;
	private byte[] dActText;
	private org.apache.struts.upload.FormFile dActTextFrm;
public MismatchForm() {
	ownername = "";
	storagename = "";
	blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	cordocnum = "";
	cordocdate = new StringAndSqlDateProperty();
	suppliername = "";

	document = new StringAndIntegerProperty();
	
	dActNumber = "";
	dActDate = new StringAndSqlDateProperty();
	dActDate.setSqlDate(new java.sql.Date((new java.util.Date()).getTime()));
	dActRepresentative = "";
	dActStorManagercode = new StringAndIntegerProperty();
	dActStorManagername = "";
	dActStorManagertitle = "";
	dActTechStufcode = new StringAndIntegerProperty();
	dActTechStufname = "";
	dActTechStuftitle = "";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	InwayBillAccessBean abean = (InwayBillAccessBean)bean;
	InWayBillBLOBAccessBean blob;

	//System.out.println("*#M* dActFileDelete:"+dActFileDelete);
	if(dActFileDelete != null && dActFileDelete.booleanValue()) {
			try {
				blob = new InWayBillBLOBAccessBean();
				blob.setInitKey_document(document.getInteger().intValue());
				blob.refreshCopyHelper();
				blob.setDActText(null);
				blob.setDActTextFileName("");
				blob.commitCopyHelper();
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
	} else {
		if ((dActFileName == null || "".equals(dActFileName)) && getdActTextFrm() != null ) {
			try {
				blob = new InWayBillBLOBAccessBean();
				blob.setInitKey_document(document.getInteger().intValue());
				blob.refreshCopyHelper();
			} catch(Exception e) {
				blob = new InWayBillBLOBAccessBean(document.getInteger().intValue());
			}
			blob.setDActTextFileName(getdActTextFrm().getFileName());
			blob.setDActText(getdActTextFrm().getFileData());
			blob.commitCopyHelper();
		}
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return getDataBean(request);
}
public void fillRecord(AbstractEntityAccessBean bean) {
	InwayBillAccessBean ab = (InwayBillAccessBean)bean;
	try {
		OrganizationAccessBean o = ab.getContragent();
		if(o != null) {
			suppliername = o.getName();
		}
		o = ab.getOwner();
		if(o != null) {
			ownername = o.getName();
		}
		StoragePlaceAccessBean s = ab.getTo();
		if(s != null) {
			storagename = s.getName();
		}
		WorkerAccessBean w = ab.getDActStorManager();
		if(w != null) {
			dActStorManagercode.setInteger(new Integer(w.getWorker()));
			dActStorManagername = w.getMan().getFullName();
			dActStorManagertitle = w.getPosition().getName();
		}
		w = ab.getDActTechStuf();
		if(w != null) {
			dActTechStufcode.setInteger(new Integer(w.getWorker()));
			dActTechStufname = w.getMan().getFullName();
			dActTechStuftitle = w.getPosition().getName();
		}
	} catch(Exception e) {
	}
	try {
		InWayBillBLOBAccessBean blob = new InWayBillBLOBAccessBean();
		blob.setInitKey_document(document.getInteger().intValue());
		blob.refreshCopyHelper();
		setdActFileName(blob.getDActTextFileName());
	} catch(Exception e) {
		setdActFileName("");
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
public String getBlankdatestr() {
	return blankdate.getString();
}
public int getBlankindex() {
	if(!blankindex.isEmpty() && blankindex.isOk())
		return blankindex.getInteger().intValue();
	else
		return 0;
}
public String getBlankindexFrm() {
	return blankindex.getString();
}
public String getBlanknumberr() {
	return blanknumber;
}
public String getCordocdatestr() {
	return cordocdate.getString();
}
public String getCordocnumr() {
	return cordocnum;
}
public java.sql.Date getdActDate() {
	return dActDate.getSqlDate();
}
public java.sql.Date getDActDate() {
	return dActDate.getSqlDate();
}
public String getdActDatestr() {
	return dActDate.getString();
}
public String getDActDatestr() {
	return getdActDatestr();
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDActFileDelete() {
	return dActFileDelete;
}
public java.lang.String getdActFileName() {
	return dActFileName;
}
public String getdActNumber() {
	return dActNumber;
}
public String getDActNumber() {
	return getdActNumber();
}
public java.lang.String getdActRepresentative() {
	return dActRepresentative;
}
public java.lang.String getDActRepresentative() {
	return getdActRepresentative();
}
public Worker getdActStorManager() {
	try {
		WorkerAccessBean bean = new WorkerAccessBean();
		bean.setInitKey_worker(dActStorManagercode.getInteger().intValue());
		bean.refreshCopyHelper();
		return (Worker)bean.getEJBRef();
	} catch(Exception e) {
	}
	return null;
}
public Worker getDActStorManager() {
	return getdActStorManager();
}
public String getdActStorManagercode() {
	return dActStorManagercode.getString();
}
public String getDActStorManagercode() {
	return getdActStorManagercode();
}
public java.lang.String getdActStorManagername() {
	return dActStorManagername;
}
public java.lang.String getDActStorManagername() {
	return getdActStorManagername();
}
public java.lang.String getdActStorManagertitle() {
	return dActStorManagertitle;
}
public java.lang.String getDActStorManagertitle() {
	return getdActStorManagertitle();
}
public Worker getdActTechStuf() {
	try {
		WorkerAccessBean bean = new WorkerAccessBean();
		bean.setInitKey_worker(dActTechStufcode.getInteger().intValue());
		bean.refreshCopyHelper();
		return (Worker)bean.getEJBRef();
	} catch(Exception e) {
	}
	return null;
}
public Worker getDActTechStuf() {
	return getdActTechStuf();
}
public String getdActTechStufcode() {
	return dActTechStufcode.getString();
}
public String getDActTechStufcode() {
	return getdActTechStufcode();
}
public java.lang.String getdActTechStufname() {
	return dActTechStufname;
}
public java.lang.String getDActTechStufname() {
	return getdActTechStufname();
}
public java.lang.String getdActTechStuftitle() {
	return dActTechStuftitle;
}
public java.lang.String getDActTechStuftitle() {
	return getdActTechStuftitle();
}
public byte[] getdActText() {
	return dActText;
}
public org.apache.struts.upload.FormFile getdActTextFrm() {
	return dActTextFrm;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	if(document.getInteger() != null) {
		InwayBillAccessBean bean = new InwayBillAccessBean();
		bean.setInitKey_document(document.getInteger().intValue());
		return bean;
	} else
		return null;
}
public String getDocumentstr() {
	return document.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:38:46)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITMIS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:38:46)
 * @return java.lang.String
 */
public java.lang.String getStateOfDocument() {
	return stateOfDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:38:46)
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
public String getSuppliername() {
	return suppliername;
}
public void initRecord(javax.servlet.http.HttpServletRequest request) {
	try {
		InwayBillAccessBean ab = new InwayBillAccessBean();
		ab.setInitKey_document(document.getInteger().intValue());
		ab.refreshCopyHelper();

		com.hps.july.util.BeanUtils.copyProperties(this,ab);

		fillRecord(ab);
	} catch(Exception e) {
		e.printStackTrace();
	}
}
public void setBlankdate(java.sql.Date newDate) {
	blankdate.setSqlDate(newDate);
}
public void setBlankdatestr(String newBlankdate) {
	blankdate.setString(newBlankdate);
}
public void setBlankindex(int newBlankindex) {
	blankindex.setInteger(new Integer(newBlankindex));
}
public void setBlankindexFrm(String newBlankindex) {
	blankindex.setString(newBlankindex);
}
public void setBlanknumber(String newNumber) {
	blanknumber = newNumber;
}
public void setCordocdate(java.sql.Date newDate) {
	cordocdate.setSqlDate(newDate);
}
public void setCordocdatestr(String newDate) {
	cordocdate.setString(newDate);
}
public void setCordocnum(String newNumber) {
	cordocnum = newNumber;
}
public void setdActDate(java.sql.Date newDate) {
	dActDate.setSqlDate(newDate);
}
public void setDActDate(java.sql.Date newDate) {
	setdActDate(newDate);
}
public void setdActDatestr(String newDate) {
	dActDate.setString(newDate);
}
/**
 * 
 * @param newDActFileDelete java.lang.Boolean
 */
public void setDActFileDelete(java.lang.Boolean newDActFileDelete) {
	dActFileDelete = newDActFileDelete;
}
public void setdActFileName(String newName) {
	dActFileName = newName;
}
public void setdActNumber(String newNumber) {
	dActNumber = newNumber;
}
public void setDActNumber(String newNumber) {
	setdActNumber(newNumber);
}
public void setdActRepresentative(java.lang.String newDActRepresentative) {
	dActRepresentative = newDActRepresentative;
}
public void setDActRepresentative(java.lang.String newDActRepresentative) {
	setdActRepresentative(newDActRepresentative);
}
public void setdActStorManagercode(String newNumber) {
	dActStorManagercode.setString(newNumber);
}
public void setDActStorManagercode(String newNumber) {
	setdActStorManagercode(newNumber);
}
public void setdActStorManagername(java.lang.String newDActStorManagername) {
	dActStorManagername = newDActStorManagername;
}
public void setDActStorManagername(java.lang.String newDActStorManagername) {
	setdActStorManagername(newDActStorManagername);
}
public void setdActStorManagertitle(java.lang.String newDActStorManagertitle) {
	dActStorManagertitle = newDActStorManagertitle;
}
public void setDActStorManagertitle(java.lang.String newDActStorManagertitle) {
	setdActStorManagertitle(newDActStorManagertitle);
}
public void setdActTechStufcode(String newNumber) {
	dActTechStufcode.setString(newNumber);
}
public void setDActTechStufcode(String newNumber) {
	setdActTechStufcode(newNumber);
}
public void setdActTechStufname(java.lang.String newDActTechStufname) {
	dActTechStufname = newDActTechStufname;
}
public void setDActTechStufname(java.lang.String newDActTechStufname) {
	setdActTechStufname(newDActTechStufname);
}
public void setdActTechStuftitle(java.lang.String newDActTechStuftitle) {
	dActTechStuftitle = newDActTechStuftitle;
}
public void setDActTechStuftitle(java.lang.String newDActTechStuftitle) {
	setdActTechStuftitle(newDActTechStuftitle);
}
public void setdActText(byte[] newDActText) {
	dActText = newDActText;
}
public void setdActTextFrm(org.apache.struts.upload.FormFile newActTextFrm) {
	dActTextFrm = newActTextFrm;
}
public void setDocumentstr(String newDocument) {
	document.setString(newDocument);
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:38:46)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:38:46)
 * @param newStateOfDocument java.lang.String
 */
public void setStateOfDocument(java.lang.String newStateOfDocument) {
	stateOfDocument = newStateOfDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2002 12:38:46)
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
public void setSuppliername(String newName) {
	suppliername = newName;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (dActNumber == null || "".equals(dActNumber)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mismatch.dactnumber"));
	} else
	if (dActNumber.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mismatch.dactnumber"));
	}

	if (dActDate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mismatch.dactdate"));
	} else
	if (!dActDate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mismatch.dactdate"));
	}

	if (dActRepresentative == null || "".equals(dActRepresentative)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mismatch.representative"));
	} else
	if (dActRepresentative.length() > 50) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mismatch.representative"));
	}

	if (dActStorManagercode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mismatch.storman"));
	} else
	if (!dActStorManagercode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mismatch.storman"));
	} else {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(dActStorManagercode.getInteger().intValue());
			bean.refreshCopyHelper();
			dActStorManagername = bean.getMan().getFullName();
			dActStorManagertitle = bean.getPosition().getName();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.mismatch.storman"));
		}
	}
	
	if (dActTechStufcode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mismatch.techstuff"));
	} else
	if (!dActTechStufcode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mismatch.techstuff"));
	} else {
		try {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(dActTechStufcode.getInteger().intValue());
			bean.refreshCopyHelper();
			dActTechStufname = bean.getMan().getFullName();
			dActTechStuftitle = bean.getPosition().getName();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.mismatch.techstuff"));
		}
	}

//	System.out.println("*#M#* fileDelete:"+dActFileDelete);
//	System.out.println("*#M#* fileName:"+dActFileName);
//	System.out.println("*#M#* fileDelete:"+dActTextFrm.getFileSize());
	
//	if(dActFileDelete != null && !dActFileDelete.booleanValue()) {
//		if((dActFileName == null || "".equals(dActFileName)) && dActTextFrm.getFileSize() <= 0) {
//			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mismatch.text"));
//		}
//	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
