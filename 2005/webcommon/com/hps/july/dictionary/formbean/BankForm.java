package com.hps.july.dictionary.formbean;

import com.ibm.ivj.ejb.runtime.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования данных о банке
 */
public class BankForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private int organization;
	private java.lang.String legaladdress;
	private java.lang.String zip;
	private java.lang.String swift;
	private java.lang.String bik;
	private java.lang.String koraccount;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	if (isConst()) {
		throw new UpdateValidationException("error.bank.syncnriplatinarenda.true");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) 
  throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setOrganization(keyGen.getNextKey("tables.organizations"));
    OrganizationAccessBean bean = new OrganizationAccessBean(getOrganization(),
	    getName(), new java.lang.Boolean(false), new java.lang.Boolean(false), new java.lang.Boolean(false), 
	    new java.lang.Boolean(true) );  
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:23:32)
 * @return java.lang.String
 */
public java.lang.String getBik() {
	return bik;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	OrganizationAccessBean bean = new OrganizationAccessBean();
	bean.setInitKey_organization( getOrganization() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:23:48)
 * @return java.lang.String
 */
public java.lang.String getKoraccount() {
	return koraccount;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:54:17)
 * @return java.lang.String
 */
public java.lang.String getLegaladdress() {
	return legaladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:09)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:32:34)
 * @return int
 */
public int getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITBANK;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:23:21)
 * @return java.lang.String
 */
public java.lang.String getSwift() {
	return swift;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:10:28)
 * @return java.lang.String
 */
public java.lang.String getZip() {
	return zip;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2003 18:27:13)
 * @return boolean
 */
private boolean isConst() throws Exception {
	NamedValueAccessBean nvBean = new NamedValueAccessBean();
	nvBean.setInitKey_id("SYNCNRIPLATINARENDA");
	nvBean.refreshCopyHelper();
	
	return nvBean.getIntvalue() == 1 ? true : false;
}
public void setAction(String newAction)
{
	if(AppUtils.getNamedValueInt("SYNCNRIPLATINARENDA") == 0) {
		super.setAction(newAction);
	} else {
		super.setAction("View");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:23:32)
 * @param newBik java.lang.String
 */
public void setBik(java.lang.String newBik) {
	bik = newBik;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:23:48)
 * @param newKoraccount java.lang.String
 */
public void setKoraccount(java.lang.String newKoraccount) {
	koraccount = newKoraccount;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:54:17)
 * @param newLegaladdress java.lang.String
 */
public void setLegaladdress(java.lang.String newLegaladdress) {
	legaladdress = newLegaladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:09)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:32:34)
 * @param newOrganization int
 */
public void setOrganization(int newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:23:21)
 * @param newSwift java.lang.String
 */
public void setSwift(java.lang.String newSwift) {
	swift = newSwift;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:10:28)
 * @param newZip java.lang.String
 */
public void setZip(java.lang.String newZip) {
	zip = newZip;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (isConst()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.bank.syncnriplatinarenda.true"));
	}
	
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.bank.name"));

	if ((getBik() == null) || (getBik().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.bank.bik"));
	else {
		// Check for unique BIK
		OrganizationAccessBean abean = new OrganizationAccessBean();
		Enumeration en = abean.findBanksByQBE(Boolean.FALSE, "", Boolean.TRUE, getBik(), new Integer(1));
		if (en.hasMoreElements()) {
			abean = (OrganizationAccessBean)en.nextElement();
			if (abean.getOrganization() != getOrganization())
	  			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.bank.bikdup"));
		}
	}
	  
	if (!errors.empty())
		throw new ValidationException();
}
}
