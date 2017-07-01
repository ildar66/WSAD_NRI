package com.hps.july.dictionary.formbean;

import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Ѕазова€ форма редактировани€ организации
 */
public class AbstractOrganizationForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private java.lang.String shortname;
	private Integer companycode;
	private java.lang.String companyname;
	private com.hps.july.persistence.CompanyAccessBean companies;
	private int organization;
	private java.lang.Boolean issupplier;
	private java.lang.Boolean isprovider;
	private java.lang.Boolean isrenter;
	private java.lang.String okonh;
	private java.lang.String okpo;
	private java.lang.String inn;
	private java.lang.String accountmanagerfio;
	private java.lang.String directorfio;
	private java.lang.String phisicaladdress;
	private java.lang.String legaladdress;
	private java.lang.String phone;
	private java.lang.String fax;
	private com.hps.july.persistence.DivisionAccessBean division;
	private java.lang.String bossPosition;
	private java.lang.String organizationType;
	private java.lang.String zip;
	private java.lang.String contactList;
	private java.lang.String oldinn;
	private java.lang.String kpp;
	private java.lang.Boolean ischannalrenter;
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
	    getName(), getIssupplier(), getIsprovider(), getIsrenter(), getIschannalrenter(), new java.lang.Boolean("false") );  
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public CompanyAccessBean constructCompanies() throws Exception {

	if (companies == null) {	
		// Construct workers bean
		if (getCompanycode() != null) {
			companies = new CompanyAccessBean();
			companies.setInitKey_company(getCompanycode().intValue());
			companies.refreshCopyHelper();
		}
	}
	return companies;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:53:00)
 * @return java.lang.String
 */
public java.lang.String getAccauntmanagerinfo() {
	return accountmanagerfio;
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
 * Creation date: (17.05.2002 16:02:24)
 * @return java.lang.String
 */
public java.lang.String getBossPosition() {
	return bossPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Company getCompany() throws Exception {

	CompanyAccessBean bean = constructCompanies();
	if (bean != null)
	  return (Company)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:35:48)
 * @return int
 */
public Integer getCompanycode() {
	return companycode;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:24:47)
 * @return java.lang.String
 */
public java.lang.String getCompanyname() {
	return companyname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:15:27)
 * @return java.lang.String
 */
public java.lang.String getContactList() {
	return contactList;
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
 * Creation date: (28.02.2002 15:53:27)
 * @return java.lang.String
 */
public java.lang.String getDirectorinfo() {
	return directorfio;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:54:54)
 * @return java.lang.String
 */
public java.lang.String getFax() {
	return fax;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:52:33)
 * @return java.lang.String
 */
public java.lang.String getInn() {
	return inn;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:51:06)
 * @return java.lang.String
 */
public java.lang.Boolean getIsprovider() {
	return isprovider;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:51:31)
 * @return java.lang.String
 */
public java.lang.Boolean getIsrenter() {
	return isrenter;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:50:44)
 * @return java.lang.String
 */
public java.lang.Boolean getIssupplier() {
	return issupplier;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2003 15:11:10)
 * @return java.lang.String
 */
public java.lang.String getKpp() {
	return kpp;
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
 * Creation date: (28.02.2002 15:51:54)
 * @return java.lang.String
 */
public java.lang.String getOkonh() {
	return okonh;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:52:14)
 * @return java.lang.String
 */
public java.lang.String getOkpo() {
	return okpo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 19:49:59)
 * @return java.lang.String
 */
public java.lang.String getOldinn() {
	return oldinn;
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
 * Creation date: (17.05.2002 16:05:14)
 * @return java.lang.String
 */
public java.lang.String getOrganizationType() {
	return organizationType;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:53:55)
 * @return java.lang.String
 */
public java.lang.String getPhisicaladdress() {
	return phisicaladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:54:41)
 * @return java.lang.String
 */
public java.lang.String getPhone() {
	return phone;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:34)
 * @return java.lang.String
 */
public java.lang.String getShortname() {
	return shortname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITORGM;
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
 * Creation date: (28.02.2002 15:53:00)
 * @param newAccountmanagerfio java.lang.String
 */
public void setAccauntmanagerinfo(java.lang.String newAccountmanagerfio) {
	accountmanagerfio = newAccountmanagerfio;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:02:24)
 * @param newBossPosition java.lang.String
 */
public void setBossPosition(java.lang.String newBossPosition) {
	bossPosition = newBossPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setCompany(com.hps.july.persistence.CompanyAccessBean newCompanies) throws Exception {
	if (newCompanies == null) {
		companycode = null;
		companyname = "";
	}
	else {
		companycode = new Integer(newCompanies.getCompany());
		companyname = newCompanies.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:35:48)
 * @param newCompany int
 */
public void setCompanycode(Integer newCompany) {
	companycode = newCompany;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:24:47)
 * @param newCompanyname java.lang.String
 */
public void setCompanyname(java.lang.String newCompanyname) {
	companyname = newCompanyname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:15:27)
 * @param newContactList java.lang.String
 */
public void setContactList(java.lang.String newContactList) {
	contactList = newContactList;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:53:27)
 * @param newDirectorfio java.lang.String
 */
public void setDirectorinfo(java.lang.String newDirectorfio) {
	directorfio = newDirectorfio;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:54:54)
 * @param newFax java.lang.String
 */
public void setFax(java.lang.String newFax) {
	fax = newFax;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:52:33)
 * @param newInn java.lang.String
 */
public void setInn(java.lang.String newInn) {
	inn = newInn;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:51:06)
 * @param newIsprovider java.lang.String
 */
public void setIsprovider(java.lang.Boolean newIsprovider) {
	isprovider = newIsprovider;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:51:31)
 * @param newIsrenter java.lang.String
 */
public void setIsrenter(java.lang.Boolean newIsrenter) {
	isrenter = newIsrenter;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:50:44)
 * @param newIssupplier java.lang.String
 */
public void setIssupplier(java.lang.Boolean newIssupplier) {
	issupplier = newIssupplier;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2003 15:11:10)
 * @param newKpp java.lang.String
 */
public void setKpp(java.lang.String newKpp) {
	kpp = newKpp;
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
 * Creation date: (28.02.2002 15:51:54)
 * @param newOkonh java.lang.String
 */
public void setOkonh(java.lang.String newOkonh) {
	okonh = newOkonh;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:52:14)
 * @param newOkpo java.lang.String
 */
public void setOkpo(java.lang.String newOkpo) {
	okpo = newOkpo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 19:49:59)
 * @param newOldinn java.lang.String
 */
public void setOldinn(java.lang.String newOldinn) {
	oldinn = newOldinn;
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
 * Creation date: (17.05.2002 16:05:14)
 * @param newOrganizationType java.lang.String
 */
public void setOrganizationType(java.lang.String newOrganizationType) {
	organizationType = newOrganizationType;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:53:55)
 * @param newPhisicaladdress java.lang.String
 */
public void setPhisicaladdress(java.lang.String newPhisicaladdress) {
	phisicaladdress = newPhisicaladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (28.02.2002 15:54:41)
 * @param newPhone java.lang.String
 */
public void setPhone(java.lang.String newPhone) {
	phone = newPhone;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:34)
 * @param newShortname java.lang.String
 */
public void setShortname(java.lang.String newShortname) {
	shortname = newShortname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.05.2002 16:10:28)
 * @param newZip java.lang.String
 */
public void setZip(java.lang.String newZip) {
	zip = newZip;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getShortname() == null) || (getShortname().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.organization.shortname"));
	}
	
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.organization.name"));
	
	if (getIssupplier() == null)
		setIssupplier(new java.lang.Boolean(false));
		//setIssupplier("N");
	if (getIsprovider() == null)
		setIsprovider(new java.lang.Boolean(false));
		//setIsprovider("N");
	if (getIsrenter() == null)
		setIsrenter(new java.lang.Boolean(false));
		//setIsrenter("N");
	if (getIschannalrenter() == null)
		setIschannalrenter(new java.lang.Boolean(false));
		//setIschannalrenter("N");		

	try {
	
		if (getCompanycode() != null)
			constructCompanies();
	} catch (Exception ex) {
		if (ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.organization.company"));
	}
	
	if (getKpp() == null || getKpp().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.organization.kpp"));
	}
	
	if ((getInn() == null) || (getInn().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.organization.inn"));
	else {
		// Check for unique INN
		/*OrganizationAccessBean abean = new OrganizationAccessBean();
		Enumeration en = abean.findByInnOrderByInnAsc(getInn());
		if (en.hasMoreElements()) {
			abean = (OrganizationAccessBean)en.nextElement();
			if (abean.getOrganization() != getOrganization())
	  			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.organization.inndup"));
		}*/
	}
	
	if ((getDirectorinfo() == null) || (getDirectorinfo().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.organization.directorfio"));
	  
	if ((getBossPosition() == null) || (getBossPosition().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.organization.bossposition"));
	
	if ((getLegaladdress() == null) || (getLegaladdress().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.organization.legaladdress"));
	
	
	if (!errors.empty())
		throw new ValidationException();
}
	/**
	 * @return
	 */
	public java.lang.Boolean getIschannalrenter() {
		return ischannalrenter;
	}

	/**
	 * @param boolean1
	 */
	public void setIschannalrenter(java.lang.Boolean boolean1) {
		ischannalrenter = boolean1;
	}

}
