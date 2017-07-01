package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * ‘орма редактировани€ сотрудника организации (юр. лица)
 */
public class OrgworkerForm extends com.hps.july.web.util.EditForm {
	private StringAndIntegerProperty organizationcode;
	private String organizationname;
	
	private StringAndIntegerProperty worker;
	private StringAndIntegerProperty man;
	
	private String firstname;
	private String lastname;
	private String middlename;
	private String passportser;
	private StringAndSqlDateProperty passportdate;
	private String passportwhom;
	private Boolean active;
	private int peoplecode;
public OrgworkerForm() {
	organizationcode = new StringAndIntegerProperty();
	worker = new StringAndIntegerProperty();
	man = new StringAndIntegerProperty();
	passportdate = new StringAndSqlDateProperty();
}
/**
 * ћетод вызываетс€ после удалени€ основной записи.
 * Creation date: (13.02.2002 10:17:44)
 */
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception  {
	PeopleAccessBean people = new PeopleAccessBean();
	people.setInitKey_man(peoplecode);
	people.refreshCopyHelper();
	people.getEJBRef().remove();
}
public void beforeDelete(AbstractEntityAccessBean bean,	HttpServletRequest request)
	throws Exception
{
	try {
		WorkerAccessBean wb = (WorkerAccessBean)bean;
		PeopleAccessBean people = wb.getMan();
		if(people != null) {
			peoplecode = people.getMan();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.orgworker.partialremove");
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	try {
		WorkerAccessBean wb = (WorkerAccessBean)bean;
//		wb.setOrganization(getOrganization());
		wb.setOrganization(getOrg());
		wb.setActive(getActive()==null?Boolean.TRUE:getActive());
		wb.setIsour(Boolean.FALSE);
		wb.setIsservicestuff(Boolean.TRUE);

		PeopleAccessBean people = wb.getMan();
//		if("Edit".equals(getAction())) {
			people.setLastname(getLastname());
			people.setFirstname(getFirstname());
			people.setMiddlename(getMiddlename());
			people.setPassportser(getPassportser());
			people.setIsActive(getActive());
//		}
		people.setPassportDate(getPassportdate());
		people.setPassportWhom(getPassportwhom());
		people.commitCopyHelper();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.orgworker.partialrecordupdate");
	}
/*
	Ёти пол€ не устанавливаютс€
	
	wb.setCompany(null);
	wb.setDivision(null);
	wb.setLotusaddress(null);
	wb.setEmail(null);
	wb.setPhone1(null);
	wb.setPhone2(null);
	wb.setLocalphone(null);
	wb.setFax(null);
	wb.setMobilephone(null);
*/
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	OrgworkersListForm aform = (OrgworkersListForm)request.getSession().getAttribute( "OrgworkersListForm" );
	//setMancode(new Integer( aform.getMan() ));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

	setMankey(keyGen.getNextKey("tables.people"));
	PeopleAccessBean people = new PeopleAccessBean(
		getMankey(), getFirstname(), getMiddlename(), getLastname(), getPassportser(), getActive()
	);
	people.setPassportDate(getPassportdate());
	people.setPassportWhom(getPassportwhom());
	people.commitCopyHelper();
	
	setWorker(keyGen.getNextKey("tables.workers"));
    WorkerAccessBean bean = new WorkerAccessBean(
		getWorker(), // int argWorker,
		getMancode(), // Integer argMan,
		new Integer(getWorkposition()), // Integer argPosition,
	    Boolean.FALSE, // Boolean argIsour = (Y - —вой, N - „ужой)
		Boolean.TRUE // Boolean argIsservicestuff (Y - ¬ыездной, N - Ќе выездной)
    );
	return bean;
}
public OrganizationAccessBean constructOrganization()
	throws Exception
{
	OrganizationAccessBean o = null;
	if (organizationcode.getInteger() != null) {
		o = new OrganizationAccessBean();
		o.setInitKey_organization(getOrganizationcode().intValue());
		o.refreshCopyHelper();
	} else {
		throw new NullPointerException("ORGWORKER: Organization is null!");
	}
	return o;
}
public WorkPositionAccessBean constructWorkpositions()
	throws Exception
{
	WorkPositionAccessBean wp = new WorkPositionAccessBean();
	wp.setInitKey_workposition(getWorkposition());
	wp.refreshCopyHelper();
	return wp;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		WorkerAccessBean wb = (WorkerAccessBean)bean;
		setActive(wb.getActive());
		setOrganization(wb.getOrganization());

		PeopleAccessBean p = wb.getMan();
		if(p != null) {
			setMankey(p.getMan());
			setLastname(p.getLastname());
			setFirstname(p.getFirstname());
			setMiddlename(p.getMiddlename());
			setPassportser(p.getPassportser());
			setPassportdate(p.getPassportDate());
			setPassportwhom(p.getPassportWhom());
		} else {
			System.out.println("OW: People in NULL!!! A-A-A!!!");
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public java.lang.Boolean getActive() {
	return active;
}
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	WorkerAccessBean bean = new WorkerAccessBean();
	bean.setInitKey_worker( getWorker() );
	return bean;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFirstname() {
	return firstname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
public Integer getMancode() {
	return man.getInteger();
}
public int getMankey() {
	if(man.getInteger() != null) {
		return man.getInteger().intValue();
	} else {
		return 0;
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getMiddlename() {
	return middlename;
}
public com.hps.july.persistence.Organization getOrg()
	throws Exception
{
	OrganizationAccessBean bean = constructOrganization();
	if (bean != null)
		return (Organization)bean.getEJBRef();
	else
		return null;
		
}
public java.lang.Integer getOrganizationcode() {
	return organizationcode.getInteger();
}
public java.lang.String getOrganizationcodeFrm() {
	return organizationcode.getString();
}
public java.lang.String getOrganizationname() {
	return organizationname;
}
public java.sql.Date getPassportdate() {
	return passportdate.getSqlDate();
}
public String getPassportdateFrm() {
	return passportdate.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPassportser() {
	return passportser;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPassportwhom() {
	return passportwhom;
}
public com.hps.july.persistence.WorkPosition getPosition() throws Exception {
	WorkPositionAccessBean bean = constructWorkpositions();
	if (bean != null)
	  return (WorkPosition)bean.getEJBRef();
	else
	  return null;

}
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITORGW;
}
public int getWorker() {
	if(worker.getInteger() != null) {
		return worker.getInteger().intValue();
	} else {
		return 0;
	}
}
/*
 * ¬озвращает код должности дл€ подр€дных организаций.
 * “.к. данна€ форма используетс€ дл€ ввода "чужих" сотрудников
 * то дл€ дл€ указани€ об€зательного пол€ должность используетс€
 * код должности котора€ заведена в базе и называетс€ "–аботник подр€дной организации".
 * Ётот код можно узнать запросив константу "Outer_WorkPositionCode" (case sensitive)
 *
 * ћетод getWorkposition в этой форме всегда возвращает должность "–аботник подр€дной организации"
 * по коду из константы "Outer_WorkPositionCode"
 */
public int getWorkposition()
	throws Exception
{
	return AppUtils.getNamedValueInt("Outer_WorkPositionCode");
}
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setActive(Boolean.TRUE);
	OrgworkersListForm aform = (OrgworkersListForm)request.getSession().getAttribute( "OrgworkersListForm" );
	setOrganizationcode(new Integer(aform.getOrganization()));
	setOrganization(constructOrganization());
//	setOrganizationname(aform.getOrganizationname());
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
 * 
 * @param newFirstname java.lang.String
 */
public void setFirstname(java.lang.String newFirstname) {
	firstname = newFirstname;
}
/**
 * 
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
public void setMancode(java.lang.Integer newMan) {
	man.setInteger(newMan);
}
public void setMankey(int newMan) {
	man.setInteger(new Integer(newMan));
}
public void setMiddlename(java.lang.String newMiddlename) {
	middlename = newMiddlename;
}
public void setOrganization(com.hps.july.persistence.OrganizationAccessBean newOrg) throws Exception {
	if (newOrg != null) {
		organizationcode.setInteger(new Integer(newOrg.getOrganization()));
		organizationname = newOrg.getName();
	} else {
		organizationname = "";
	}
}
public void setOrganizationcode(java.lang.Integer newOrg) {
	organizationcode.setInteger(newOrg);
}
public void setOrganizationcodeFrm(java.lang.String newOrg) {
	organizationcode.setString(newOrg);
}
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
public void setPassportdate(java.sql.Date newPassportdate) {
	passportdate.setSqlDate(newPassportdate);
}
public void setPassportdateFrm(String newPassportdate) {
	passportdate.setString(newPassportdate);
}
public void setPassportser(java.lang.String newPassportser) {
	passportser = newPassportser;
}
/**
 * 
 * @param newPassportwhom java.lang.String
 */
public void setPassportwhom(java.lang.String newPassportwhom) {
	passportwhom = newPassportwhom;
}
public void setWorker(int newWorker) {
	worker.setInteger(new Integer(newWorker));
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if(organizationcode.getInteger() == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.organization.empty"));
		throw new ValidationException();
	} else {
		try {
			constructOrganization();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.organization.invalid"));
			throw new ValidationException();
		}
	}

//@TODO: check worker duplication
	
	// checkString(getFirstname(), 80, true, "firstname", errors);
	if(getFirstname() == null || "".equals(getFirstname())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.firstname.empty"));
	} else if(getFirstname().length() > 80) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.firstname.length"));
	}

	// checkString(getLastname(), 80, true, "lastname", errors);
	if(getLastname() == null || "".equals(getLastname())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.lastname.empty"));
	} else if(getLastname().length() > 80) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.lastname.length"));
	}

	// checkString(getMiddlename(), 80, true, "middlename", errors);
	if(getMiddlename() == null || "".equals(getMiddlename())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.middlename.empty"));
	} else if(getMiddlename().length() > 80) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.middlename.length"));
	}

	// checkString(getPassportser(), 80, true, "passportser", errors);
	if(getPassportser() == null || "".equals(getPassportser())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.passportser.empty"));
	} else if(getMiddlename().length() > 80) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.passportser.length"));
	}

	// checkDate(passportdate, false, "passportdate", errors);
	if(!passportdate.isEmpty()) {
		if(!passportdate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.passportdate.invalid"));
		}
	}

	// checkString(getPassportser(), 80, false, "passportwhom", errors);
	if(getPassportwhom() != null && !"".equals(getPassportwhom())) {
		if(getPassportwhom().length() > 80) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.passportwhom.length"));
		}
	}

	if(getActive() == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.orgworker.active.empty"));
	}

	if (!errors.empty()) throw new ValidationException();
}
}
