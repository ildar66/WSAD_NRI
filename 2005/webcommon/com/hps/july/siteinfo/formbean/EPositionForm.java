package com.hps.july.siteinfo.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма редактирвоания дополнительных характеристик позиции
 */
public class EPositionForm 
	extends com.hps.july.web.util.EditForm 
{
	private int storageplace;
	private java.lang.String contactPhonest;
	private java.lang.String servicePhones;
	private java.lang.String engenering;
	private java.lang.String equipmentPlaces;
	private java.lang.String pathType;
	private com.hps.july.web.util.StringAndSqlDateProperty accesslistexp;
	private byte[] accessList;
	private org.apache.struts.upload.FormFile accessListFrm;
	private java.lang.String accessListFileName;
	private java.lang.String posname;
	private java.lang.String posid;
	private java.lang.String posAddr;
	private java.lang.String details;
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 12:36:30)
 */
public EPositionForm() {
	accesslistexp = new com.hps.july.web.util.StringAndSqlDateProperty();
	accessListFileName = "";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(
    AbstractEntityAccessBean bean,
    javax.servlet.http.HttpServletRequest request)
    throws Exception {
    try {

        DebugSupport.printlnTest(
            "EPositionForm afterUpdate getStorageplace()=" + getStorageplace());

        PositionAccessBean pbean = new PositionAccessBean();
        pbean.setInitKey_storageplace(getStorageplace());
        pbean.refreshCopyHelper();

        DebugSupport.printlnTest(
            "EPositionForm afterUpdate getAccesslistexp()=" + getAccesslistexp());

        pbean.setAccesslistexp(getAccesslistexp());
        pbean.commitCopyHelper();
    } catch (Exception ex) {
        //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.position.name"));
        DebugSupport.printlnError(ex);
        ex.printStackTrace(System.out);
        throw ex;
    }

    DebugSupport.printlnTest(
        "EPositionForm afterUpdate getAccessListFrm()=" + getAccessListFrm());

    try {
        if ((getAccessListFrm()!=null&&getAccessListFrm().getFileName() != null)
            && (getAccessListFrm().getFileName().length() > 0)) {
            	
            /*
            PositionBLOBAccessBean abean = (PositionBLOBAccessBean) bean;

            DebugSupport.printlnTest(
                "EPositionForm afterUpdate getAccessListFrm().getFileData()="
                    + getAccessListFrm().getFileData());
            abean.setAccessListFileName(getAccessListFrm().getFileName());
            abean.setAccessList(getAccessListFrm().getFileData());
            abean.commitCopyHelper();
            */
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	PositionAccessBean pbean = new PositionAccessBean();
	pbean.setInitKey_storageplace( getStorageplace() );
	try {
		setAccesslistexp(pbean.getAccesslistexp());
		posid = "";
		if (pbean.getGsmid() != null)
			posid = "D" + pbean.getGsmid() + " ";
		if (pbean.getDampsid() != null)
			posid = posid + "A" + pbean.getDampsid();
			
		posname = pbean.getName();
		if ((pbean.getDampsname() != null) && (pbean.getDampsname().length() > 0) )
			posname = posname + " / " + pbean.getDampsname();

		setPosAddr(pbean.getAddress());
		setDetails(pbean.getDetails());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:28:12)
 * @return byte
 */
public byte[] getAccessList() {
	return accessList;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:49:14)
 * @return java.sql.Date
 */
public java.sql.Date getAccesslistexp() {
	return accesslistexp.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:49:36)
 * @return java.lang.String
 */
public java.lang.String getAccesslistexpFrm() {
	return accesslistexp.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:28:58)
 * @return java.lang.String
 */
public java.lang.String getAccessListFileName() {
	return accessListFileName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:28:38)
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getAccessListFrm() {
	return accessListFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:26:20)
 * @return java.lang.String
 */
public java.lang.String getContactPhonest() {
	return contactPhonest;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	/*
	PositionBLOBAccessBean bean = new PositionBLOBAccessBean();
	bean.setInitKey_storagePlace( getStorageplace() );
	try {
		bean.refreshCopyHelper();
		setAccessList(bean.getAccessList());
		setAccessListFileName(bean.getAccessListFileName());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return bean;
	*/
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 9:34:49)
 * @return java.lang.String
 */
public java.lang.String getDetails() {
	return details;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:27:13)
 * @return java.lang.String
 */
public java.lang.String getEngenering() {
	return engenering;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:27:41)
 * @return java.lang.String
 */
public java.lang.String getEquipmentPlaces() {
	return equipmentPlaces;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:28:47)
 * @return java.lang.String
 */
public java.lang.String getPathType() {
	return pathType;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 15:35:26)
 * @return java.lang.String
 */
public java.lang.String getPosAddr() {
	return posAddr;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:51)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:37)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:26:45)
 * @return java.lang.String
 */
public java.lang.String getServicePhones() {
	return servicePhones;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.EDITEPOS;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:28:12)
 * @param newAccessList byte
 */
public void setAccessList(byte[] newAccessList) {
	accessList = newAccessList;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:49:14)
 * @param newAccesslistexp java.sql.Date
 */
public void setAccesslistexp(java.sql.Date newAccesslistexp) {
	accesslistexp.setSqlDate(newAccesslistexp);
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:49:36)
 * @param newAccesslistexpFrm java.lang.String
 */
public void setAccesslistexpFrm(java.lang.String newAccesslistexpFrm) {
	accesslistexp.setString(newAccesslistexpFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:28:58)
 * @param newAccessListFileName java.lang.String
 */
public void setAccessListFileName(java.lang.String newAccessListFileName) {
	accessListFileName = newAccessListFileName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:28:38)
 * @param newAccessListFrm org.apache.struts.upload.FormFile
 */
public void setAccessListFrm(org.apache.struts.upload.FormFile newAccessListFrm) {
	accessListFrm = newAccessListFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:26:20)
 * @param newContactPhonest java.lang.String
 */
public void setContactPhonest(java.lang.String newContactPhonest) {
	contactPhonest = newContactPhonest;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2002 9:34:49)
 * @param newDetails java.lang.String
 */
public void setDetails(java.lang.String newDetails) {
	details = newDetails;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:27:13)
 * @param newEngenering java.lang.String
 */
public void setEngenering(java.lang.String newEngenering) {
	engenering = newEngenering;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:27:41)
 * @param newEquipmentPlaces java.lang.String
 */
public void setEquipmentPlaces(java.lang.String newEquipmentPlaces) {
	equipmentPlaces = newEquipmentPlaces;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:28:47)
 * @param newPathType java.lang.String
 */
public void setPathType(java.lang.String newPathType) {
	pathType = newPathType;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 15:35:26)
 * @param newPosAddr java.lang.String
 */
public void setPosAddr(java.lang.String newPosAddr) {
	posAddr = newPosAddr;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:51)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2002 11:57:37)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 11:26:45)
 * @param newServicePhones java.lang.String
 */
public void setServicePhones(java.lang.String newServicePhones) {
	servicePhones = newServicePhones;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	  
	if (!errors.empty())
		throw new ValidationException();
}
}
