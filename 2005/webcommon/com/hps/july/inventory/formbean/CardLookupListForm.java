package com.hps.july.inventory.formbean;

import javax.ejb.ObjectNotFoundException;
import java.util.Enumeration;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма выбора экземпляра оборудования.
 * форма позволяет выбирать оборудование различным типом учёта
 * серийным, партионным и смешенным.
 *
 * При указании кода документа выбираются только такие экземпляры которые отсутствуют
 * в строках документа (для акта замены это не верно).
 *
 * Форма так же позволяет выбирать части из агрегата при указании кода агрегата.
 */
public class CardLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private Integer storage;
	private String storagename;
	private String storagetype;
	private Integer agregate;
	private String agregatename;
	private Integer resource;
	private String resourcename;
	private String policy;
	private Integer owner;
	private String ownername;
	private String pagetype;
	private Integer worker;

	private Boolean isResourcetype;
	private StringAndIntegerProperty resourcetype;
	private String resourcetypename;
	private StringAndIntegerProperty resourcesubtype;
	private String resourcesubtypename;
	private Boolean isSign;
	private String sign;
	private Boolean isName;
	private String name;
	private Boolean isManufacturer;
	private StringAndIntegerProperty manufacturer;
	private String manufacturername;
	private Boolean isManucode;
	private String manucode;
	private Integer brokentype;
	private Integer documentkey;
	private boolean isInside;

	private Boolean isSer;
	private String serialnum;
	private java.lang.Integer organization;
public CardLookupListForm() {
//	this.setFinderMethodName( "findStorageCardByQBE3" );
	this.setFinderMethodName( "findStorageCards" );
	storage = null;
	agregate = null;
	resource = null;
	owner = null;
	policy = "";
	resourcetype = new StringAndIntegerProperty();
	resourcesubtype = new StringAndIntegerProperty();
	manufacturer = new StringAndIntegerProperty();
	isResourcetype = Boolean.FALSE;
	isManucode = Boolean.FALSE;
	isManufacturer = Boolean.FALSE;
	isName = Boolean.FALSE;
	isSign = Boolean.FALSE;
}
public Object constructRowModelBean(Object o) {
	return o;
	/*
	try {
		return new com.hps.july.inventory.valueobject.StorageCardValue(o,getDocumentkey(),getIsInside());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
	*/
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getAgregate() {
	return agregate;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAgregatename() {
	return agregatename;
}
public String getAgregateserial() {
	return "";
}
public int getAppState() {
	return com.hps.july.inventory.APPStates.CRDLOOKUP;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getBrokentype() {
	return brokentype;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getDocumentkey() {
	return documentkey;
}
public java.lang.Object[] getFilterParams() {
	Integer storagecard = null;
	if(documentkey != null && documentkey.intValue() > 0) {
		try {
			I13nActAccessBean b = new I13nActAccessBean();
			b.setInitKey_document(documentkey.intValue());
			b.refreshCopyHelper();
			storagecard = new Integer(b.getAgregate().getStoragecard());
		} catch(Exception e) {
		}
		try {
			AssemblingActAccessBean b = new AssemblingActAccessBean();
			b.setInitKey_document(documentkey.intValue());
			b.refreshCopyHelper();
			storagecard = new Integer(b.getAgregat().getStoragecard());
		} catch(Exception e) {
		}
	}
	Boolean usep = Boolean.FALSE;
	String p = "";
	if("2".equals(pagetype)) {
		usep = Boolean.TRUE;
		p = "S";
	} else if("3".equals(pagetype)) {
		usep = Boolean.TRUE;
		p = "P";
	} else if("4".equals(pagetype)) {
		usep = Boolean.TRUE;
		p = "B";
	}
/*
System.out.println("CRL: storage:"+storage);
System.out.println("CRL: owner:"+owner);
System.out.println("CRL: agregate:"+agregate);
System.out.println("CRL: resource:"+resource);
System.out.println("CRL: isRt:"+isResourcetype.booleanValue()+" resourcesubtype:"+resourcesubtype.getInteger());
System.out.println("CRL: isSign:"+isSign.booleanValue()+" sign:"+sign);
System.out.println("CRL: isName:"+isName.booleanValue()+" name:"+sign);
System.out.println("CRL: isManu:"+isManucode.booleanValue()+" manucode:"+manucode);
System.out.println("CRL: isAgregate:"+((agregate != null)?Boolean.FALSE:Boolean.TRUE));
System.out.println("CRL: brokentype:"+brokentype);
System.out.println("CRL: document:"+documentkey);
System.out.println("CRL: storagecard:"+storagecard);
System.out.println("CRL: usep:"+usep+" p:"+p);
*/
	return new Object[] {
		(storage != null)?storage:new Integer(0),
		(owner != null)?Boolean.TRUE:Boolean.FALSE, (owner == null)?new Integer(0):owner,
		(agregate != null)?Boolean.TRUE:Boolean.FALSE, (agregate == null)?new Integer(0):agregate,
		(resource != null)?Boolean.TRUE:Boolean.FALSE, (resource == null)?new Integer(0):resource,
		(isResourcetype.booleanValue())?Boolean.TRUE:Boolean.FALSE, (resourcesubtype.getInteger() == null)?new Integer(0):resourcesubtype.getInteger(), // subtype
		(isSign.booleanValue())?Boolean.TRUE:Boolean.FALSE, (sign == null)?"":sign, // model
		(isName.booleanValue())?Boolean.TRUE:Boolean.FALSE, (name == null)?"":name, // name
		(isManufacturer.booleanValue())?Boolean.TRUE:Boolean.FALSE, (manufacturer.getInteger() == null)?new Integer(0):manufacturer.getInteger(), // manufacturer
		(isManucode.booleanValue())?Boolean.TRUE:Boolean.FALSE, (manucode == null)?"":manucode, // manucode
		(isSer != null && isSer.booleanValue())?Boolean.TRUE:Boolean.FALSE, (serialnum == null)?"":serialnum,
		(agregate != null)?Boolean.FALSE:Boolean.TRUE,
		(brokentype == null)?new Integer(0):brokentype,
		(documentkey == null)?new Integer(0):documentkey,
		(storagecard != null)?Boolean.TRUE:Boolean.FALSE,(storagecard != null)?storagecard:new Integer(0),
		usep, p,
		new Integer(1)
	};
}
public java.lang.String getFinderMethodName() {
	return super.getFinderMethodName();
}
public boolean getIsInside() {
	return isInside;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManucode() {
	return isManucode;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManufacturer() {
	return isManufacturer;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsName() {
	return isName;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsResourcetype() {
	return isResourcetype;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSer() {
	return isSer;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSign() {
	return isSign;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManucode() {
	return manucode;
}
public Integer getManufacturer() {
	return manufacturer.getInteger();
}
public String getManufacturercode() {
	return manufacturer.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufacturername() {
	return manufacturername;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2005 11:08:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrganization() {
	return organization;
}
public java.lang.Integer getOwner() {
	return owner;
}
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPagetype() {
	return pagetype;
}
public java.lang.String getPolicy() {
	return policy;
}
public Integer getResource() {
	return resource;
}
public java.lang.String getResourcename() {
	return resourcename;
}
public java.lang.Integer getResourcesubtype() {
	return resourcesubtype.getInteger();
}
public java.lang.String getResourcesubtypecode() {
	return resourcesubtype.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcesubtypename() {
	return resourcesubtypename;
}
public java.lang.Integer getResourcetype() {
	return resourcetype.getInteger();
}
public java.lang.String getResourcetypecode() {
	return resourcetype.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSerialnum() {
	return serialnum;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSign() {
	return sign;
}
public java.lang.Integer getStorage() {
	return storage;
}
public java.lang.String getStoragename() {
	return storagename;
}
public java.lang.String getStoragetype() {
	return storagetype;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getWorker() {
	return worker;
}
/**
 * 
 * @return boolean
 */
public boolean isIsInside() {
	return isInside;
}
public void setAgregate(java.lang.Integer newAgregate) {
	agregate = newAgregate;
}
/**
 * 
 * @param newAgregatename java.lang.String
 */
public void setAgregatename(java.lang.String newAgregatename) {
	agregatename = newAgregatename;
}
public void setAgregateserial(String newAgregateserial) {
	if(newAgregateserial != null && !"".equals(newAgregateserial.trim())) {
		try {
			StorageCardAccessBean scb = new StorageCardAccessBean();
			StorageCardAccessBean scbagr = scb.findBySerial(newAgregateserial);
			agregate = new Integer(scbagr.getStoragecard());
		} catch(Exception e) {
			e.printStackTrace(System.out);
			agregate = null;
		}
	} else {
		agregate = null;
	}
}
/**
 * 
 * @param newBrokentype java.lang.Integer
 */
public void setBrokentype(java.lang.Integer newBrokentype) {
	brokentype = newBrokentype;
}
/**
 * 
 * @param newDocumentkey java.lang.Integer
 */
public void setDocumentkey(java.lang.Integer newDocumentkey) {
	documentkey = newDocumentkey;
}
public void setIsInside(boolean newIsInside) {
	isInside = newIsInside;
}
/**
 * 
 * @param newIsManucode java.lang.Boolean
 */
public void setIsManucode(java.lang.Boolean newIsManucode) {
	isManucode = newIsManucode;
}
/**
 * 
 * @param newIsManufacturer java.lang.Boolean
 */
public void setIsManufacturer(java.lang.Boolean newIsManufacturer) {
	isManufacturer = newIsManufacturer;
}
/**
 * 
 * @param newIsName java.lang.Boolean
 */
public void setIsName(java.lang.Boolean newIsName) {
	isName = newIsName;
}
/**
 * 
 * @param newIsResourcetype java.lang.Boolean
 */
public void setIsResourcetype(java.lang.Boolean newIsResourcetype) {
	isResourcetype = newIsResourcetype;
}
/**
 * 
 * @param newIsSer java.lang.Boolean
 */
public void setIsSer(java.lang.Boolean newIsSer) {
	isSer = newIsSer;
}
/**
 * 
 * @param newIsSign java.lang.Boolean
 */
public void setIsSign(java.lang.Boolean newIsSign) {
	isSign = newIsSign;
}
/**
 * 
 * @param newManucode java.lang.String
 */
public void setManucode(java.lang.String newManucode) {
	manucode = newManucode;
}
public void setManufacturer(Integer newManufacturer) {
	manufacturer.setInteger(newManufacturer);
}
public void setManufacturercode(String newManufacturer) {
	manufacturer.setString(newManufacturer);
}
/**
 * 
 * @param newManufacturername java.lang.String
 */
public void setManufacturername(java.lang.String newManufacturername) {
	manufacturername = newManufacturername;
}
/**
 * 
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Данные по подрядчику (организации).
 * Creation date: (07.06.2005 11:08:12)
 * @param newOrganization java.lang.Integer
 */
public void setOrganization(java.lang.Integer newOrganization) {
	organization = newOrganization;
	if(organization != null) {
		setStorage(new Integer(0));
		try {
			ExpeditionAccessBean ex = new ExpeditionAccessBean();
			Enumeration en = ex.findExpeditionByOrganization(new OrganizationKey(organization.intValue()));
			if(en.hasMoreElements()) {
				ExpeditionAccessBean exn = (ExpeditionAccessBean)en.nextElement();
				setStorage(new Integer(exn.getStorageplace()));
				setStoragename(exn.getOrganization().getName());
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
}
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * 
 * @param newPagetype java.lang.String
 */
public void setPagetype(java.lang.String newPagetype) {
	pagetype = newPagetype;
}
public void setPolicy(java.lang.String newPolicy) {
	policy = newPolicy;
}
public void setResource(Integer newResource) {
	resource = newResource;
}
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setResourcesubtype(java.lang.Integer newResourcesubtype) {
	resourcesubtype.setInteger(newResourcesubtype);
}
public void setResourcesubtypecode(java.lang.String newResourcesubtype) {
	resourcesubtype.setString(newResourcesubtype);
}
/**
 * 
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcesubtypename(java.lang.String newResourcesubtypename) {
	resourcesubtypename = newResourcesubtypename;
}
public void setResourcetype(java.lang.Integer newResourcetype) {
	resourcetype.setInteger(newResourcetype);
}
public void setResourcetypecode(java.lang.String newResourcetype) {
	resourcetype.setString(newResourcetype);
}
/**
 * 
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
/**
 * 
 * @param newSerialnum java.lang.String
 */
public void setSerialnum(java.lang.String newSerialnum) {
	serialnum = newSerialnum;
}
/**
 * 
 * @param newSign java.lang.String
 */
public void setSign(java.lang.String newSign) {
	sign = newSign;
}
public void setStorage(java.lang.Integer newStorage) {
	storage = newStorage;
}
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
public void setStoragetype(java.lang.String newStoragetype) {
	storagetype = newStoragetype;
}
public void setWorker(java.lang.Integer newWorker) {
	worker = newWorker;
	if(worker != null) {
		setStorage(new Integer(0));
		try {
			ExpeditionAccessBean ex = new ExpeditionAccessBean();
			Enumeration en = ex.findExpeditionByExpeditor(new WorkerKey(worker.intValue()));
			if(en.hasMoreElements()) {
				ExpeditionAccessBean exn = (ExpeditionAccessBean)en.nextElement();
				setStorage(new Integer(exn.getStorageplace()));
				
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		if(getStorage() == null || getStorage().intValue() == 0) {
			try {
				WorkerAccessBean b = new WorkerAccessBean();
				b.setInitKey_worker(worker.intValue());
				b.refreshCopyHelper();
				setStoragename(b.getMan().getFullName());
			} catch(Exception e) {}
		}
	}
}
}
