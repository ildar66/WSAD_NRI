package com.hps.july.security.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
 * Форма ввода работника от которой будут наследоваться работники подразделения, службы, и т.д.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public class AbstractWorkerForm extends com.hps.july.web.util.EditForm {
	private int worker;
	private java.lang.String lotusaddress;
	private java.lang.String email;
	private java.lang.String phone1;
	private java.lang.String phone2;
	private java.lang.String localphone;
	private java.lang.String fax;
	private java.lang.String mobilephone;
	private int platinumcode;
	private java.lang.Boolean active;
	private StringAndIntegerProperty companycode;
	private java.lang.String companyname;
	private java.lang.Integer workposition;
	private java.lang.String workpositionname;
	private java.lang.Integer mancode;
	private java.lang.String manname;
	private com.hps.july.persistence.CompanyAccessBean companies;
	private com.hps.july.persistence.PeopleAccessBean people;
	private com.hps.july.persistence.WorkPositionAccessBean workpositions;
	private com.hps.july.persistence.DivisionAccessBean	divisions;
	private StringAndIntegerProperty divisioncode;
	private java.lang.String divisionname;
	private java.lang.Boolean isservicestuff;
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:06:47)
 */
public AbstractWorkerForm() {
	companycode = null;
	companyname = "";
	divisioncode = new StringAndIntegerProperty();
	companycode = new StringAndIntegerProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	WorkerListForm aform = (WorkerListForm)request.getSession().getAttribute( "WorkerListForm" );
	//setMancode(new Integer( aform.getMan() ));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setWorker(keyGen.getNextKey("tables.workers"));
    WorkerAccessBean bean = new WorkerAccessBean( getWorker(), getMancode(),
    	getWorkposition() );	
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
		if (!companycode.isEmpty() && companycode.isOk()) {
			companies = new CompanyAccessBean();
			companies.setInitKey_company(getCompanycode().intValue());
			companies.refreshCopyHelper();
		}
	}
	return companies;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public DivisionAccessBean constructDivision() throws Exception {

	if (divisions == null) {	
		// Construct Division bean
		if (!divisioncode.isEmpty() && divisioncode.isOk()) {
			divisions = new DivisionAccessBean();
			divisions.setInitKey_division(divisioncode.getInteger().intValue());
			divisions.refreshCopyHelper();
		}
	}
	return divisions;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public PeopleAccessBean constructPeople() throws Exception {

	if (people == null) {	
		// Construct People bean
		if (getMancode() != null) {
			people = new PeopleAccessBean();
			people.setInitKey_man(getMancode().intValue());
			people.refreshCopyHelper();
		}
	}
	return people;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public WorkPositionAccessBean constructWorkpositions() throws Exception {

	if (workpositions == null) {	
		// Construct workpositions bean
		if (getWorkposition() != null) {
			workpositions = new WorkPositionAccessBean();
			workpositions.setInitKey_workposition(getWorkposition().intValue());
			workpositions.refreshCopyHelper();
		}
	}
	return workpositions;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:03:25)
 * @return java.lang.String
 */
public java.lang.Boolean getActive() {
	return active;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SECURITY;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:10:49)
 * @return com.hps.july.security.persistence.CompaniesAccessBean
 */
public com.hps.july.persistence.Company getCompany() throws Exception {
	if (getDivision() == null) {
		CompanyAccessBean bean = constructCompanies();
		if (bean != null)
		  return (Company)bean.getEJBRef();
		else
		  return null;
	}
	else
		return null;
		
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getCompanycode() {
	return companycode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:37)
 * @return java.lang.Integer
 */
public java.lang.String getCompanycodeFrm() {
	return companycode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:52)
 * @return java.lang.String
 */
public java.lang.String getCompanyname() {
	return companyname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker( getWorker() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:57)
 * @return com.hps.july.security.persistence.GroupsAccessBean
 */
public Division getDivision() throws Exception {
	DivisionAccessBean bean = constructDivision();
	if (bean != null)
	  return (Division)bean.getEJBRef();
	else
	  return null;
	  
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 11:45:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getDivisioncode() {
	return divisioncode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 11:45:12)
 * @return java.lang.Integer
 */
public java.lang.String getDivisioncodeFrm() {
	return divisioncode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 11:45:28)
 * @return java.lang.String
 */
public java.lang.String getDivisionname() {
	return divisionname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:00:22)
 * @return java.lang.String
 */
public java.lang.String getEmail() {
	return email;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:01:56)
 * @return java.lang.String
 */
public java.lang.String getFax() {
	return fax;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2003 11:38:37)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsservicestuff() {
	return isservicestuff;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:01:43)
 * @return java.lang.String
 */
public java.lang.String getLocalphone() {
	return localphone;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:00:04)
 * @return java.lang.String
 */
public java.lang.String getLotusaddress() {
	return lotusaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:29:25)
 * @return com.hps.july.security.persistence.PeopleAccessBean
 */
public com.hps.july.persistence.People getMan() throws Exception {
	PeopleAccessBean bean = constructPeople();
	if (bean != null)
	  return (People)bean.getEJBRef();
	else
	  return null;

}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:48:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getMancode() {
	return mancode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:48:23)
 * @return java.lang.String
 */
public java.lang.String getManname() {
	return manname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:02:18)
 * @return java.lang.String
 */
public java.lang.String getMobilephone() {
	return mobilephone;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:00:51)
 * @return java.lang.String
 */
public java.lang.String getPhone1() {
	return phone1;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:01:16)
 * @return java.lang.String
 */
public java.lang.String getPhone2() {
	return phone2;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:02:55)
 * @return int
 */
public int getPlatinumcode() {
	return platinumcode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:29:52)
 * @return com.hps.july.security.persistence.WorkpositionsAccessBean
 */
public com.hps.july.persistence.WorkPosition getPosition() throws Exception {
	WorkPositionAccessBean bean = constructWorkpositions();
	if (bean != null)
	  return (WorkPosition)bean.getEJBRef();
	else
	  return null;

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWRK;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 13:53:34)
 * @return int
 */
public int getWorker() {
	return worker;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:45:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorkposition() {
	return workposition;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:45:45)
 * @return java.lang.String
 */
public java.lang.String getWorkpositionname() {
	return workpositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setActive(new java.lang.Boolean("true"));
	setIsservicestuff(new Boolean(true));
	}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:03:25)
 * @param newIsactive java.lang.String
 */
public void setActive(java.lang.Boolean newIsactive) {
	active = newIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:10:49)
 * @param newCompanies com.hps.july.security.persistence.CompaniesAccessBean
 */
public void setCompany(com.hps.july.persistence.CompanyAccessBean newCompanies) throws Exception {
	if (newCompanies != null) {
		companycode.setInteger(new Integer(newCompanies.getCompany()));
		companyname = newCompanies.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:37)
 * @param newCompany java.lang.Integer
 */
public void setCompanycode(java.lang.Integer newCompany) {
	companycode.setInteger(newCompany);
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:37)
 * @param newCompany java.lang.Integer
 */
public void setCompanycodeFrm(java.lang.String newCompany) {
	companycode.setString(newCompany);
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:52)
 * @param newCompanyname java.lang.String
 */
public void setCompanyname(java.lang.String newCompanyname) {
	companyname = newCompanyname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:57)
 * @param newGroups com.hps.july.security.persistence.GroupsAccessBean
 */
public void setDivision(DivisionAccessBean newDivision) throws Exception {
	if (newDivision == null) {
		divisioncode.setString(null);
		divisionname = "";
	}
	else {
		divisioncode.setInteger(new Integer(newDivision.getDivision()));
		divisionname = newDivision.getName();
		
		Division bean = (Division)newDivision.getEJBRef();
		if (bean instanceof Group)
		  setCompany(new CompanyAccessBean(bean.getParent().getParent().getParent().getCompany()));
		else if (bean instanceof Department)
		  setCompany(new CompanyAccessBean(bean.getParent().getParent().getCompany()));
		else if (bean instanceof Service)
		  setCompany(new CompanyAccessBean(bean.getParent().getCompany()));
		else if (bean instanceof Direction)
		  setCompany(new CompanyAccessBean(bean.getCompany()));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:48:10)
 * @param newMan java.lang.Integer
 */
public void setDivisioncode(java.lang.Integer newDivision) {
	divisioncode.setInteger(newDivision);
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:48:10)
 * @param newMan java.lang.Integer
 */
public void setDivisioncodeFrm(java.lang.String newDivision) {
	divisioncode.setString(newDivision);
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 11:45:28)
 * @param newDivisionname java.lang.String
 */
public void setDivisionname(java.lang.String newDivisionname) {
	divisionname = newDivisionname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:00:22)
 * @param newEmail java.lang.String
 */
public void setEmail(java.lang.String newEmail) {
	email = newEmail;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:01:56)
 * @param newFax java.lang.String
 */
public void setFax(java.lang.String newFax) {
	fax = newFax;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2003 11:38:37)
 * @param newIsservicestuff java.lang.Boolean
 */
public void setIsservicestuff(java.lang.Boolean newIsservicestuff) {
	isservicestuff = newIsservicestuff;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:01:43)
 * @param newLocalphone java.lang.String
 */
public void setLocalphone(java.lang.String newLocalphone) {
	localphone = newLocalphone;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:00:04)
 * @param newLotusaddress java.lang.String
 */
public void setLotusaddress(java.lang.String newLotusaddress) {
	lotusaddress = newLotusaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:29:25)
 * @param newPeople com.hps.july.security.persistence.PeopleAccessBean
 */
public void setMan(com.hps.july.persistence.PeopleAccessBean newPeople) throws Exception {
	if (newPeople == null) {
		mancode = null;
		manname = "";
	}
	else {
		mancode = new Integer(newPeople.getMan());
		manname = newPeople.getFullName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:48:10)
 * @param newMan java.lang.Integer
 */
public void setMancode(java.lang.Integer newMan) {
	mancode = newMan;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:48:23)
 * @param newManname java.lang.String
 */
public void setManname(java.lang.String newManname) {
	manname = newManname;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:02:18)
 * @param newMobilephone java.lang.String
 */
public void setMobilephone(java.lang.String newMobilephone) {
	mobilephone = newMobilephone;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:00:51)
 * @param newPhone1 java.lang.String
 */
public void setPhone1(java.lang.String newPhone1) {
	phone1 = newPhone1;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:01:16)
 * @param newPhone2 java.lang.String
 */
public void setPhone2(java.lang.String newPhone2) {
	phone2 = newPhone2;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 14:02:55)
 * @param newPlatinumcode int
 */
public void setPlatinumcode(int newPlatinumcode) {
	platinumcode = newPlatinumcode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:29:52)
 * @param newWorkpositions com.hps.july.security.persistence.WorkpositionsAccessBean
 */
public void setPosition(com.hps.july.persistence.WorkPositionAccessBean newWorkpositions) throws Exception {
	if (newWorkpositions == null) {
		workposition = null;
		workpositionname = "";
	}
	else {
		workposition = new Integer(newWorkpositions.getWorkposition());
		workpositionname = newWorkpositions.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2002 13:53:34)
 * @param newWorker int
 */
public void setWorker(int newWorker) {
	worker = newWorker;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:45:25)
 * @param newWorkposition java.lang.Integer
 */
public void setWorkposition(java.lang.Integer newWorkposition) {
	workposition = newWorkposition;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:45:45)
 * @param newWorkpositionname java.lang.String
 */
public void setWorkpositionname(java.lang.String newWorkpositionname) {
	workpositionname = newWorkpositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if (getMancode() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.worker.man"));

	if (getWorkposition() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.worker.workposition"));

	if (getActive() == null)
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.worker.isactive"));

	try {
		
		if (getMancode() != null)
			constructPeople();
	} catch (Exception ex) {
		if (ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.worker.people"));
	}
	
	try {
		
		if (getWorkposition() != null)
			constructWorkpositions();
	} catch (Exception ex) {
		if (ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.worker.workposition"));
	}
	
	if (!companycode.isEmpty())
		if (companycode.isOk()) {
			try {
					constructCompanies();
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.worker.company"));
			}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.worker.company"));
		}
	
	if (!divisioncode.isEmpty())
		if (divisioncode.isOk()) {
			try {
				constructDivision();
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.worker.division"));
			}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.worker.division"));
		}

	// Check if worker duplicated
	if (errors.empty() && "Add".compareTo(getAction()) == 0) {
		WorkerAccessBean bean = new WorkerAccessBean();
		java.util.Enumeration en = bean.findWorkersByMan(new PeopleKey(getMancode().intValue()));
		while (en.hasMoreElements()) {
			WorkerAccessBean wrk = (WorkerAccessBean)javax.rmi.PortableRemoteObject.narrow(en.nextElement(), WorkerAccessBean.class);
			if (wrk.getPosition().getWorkposition() == getWorkposition().intValue()) {
		  		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.dup.worker"));
		  		break;
			}
		}
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
