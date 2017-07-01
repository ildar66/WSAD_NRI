package com.hps.july.siteinfo.actionbean;

/**
 * Класс-контейнер с информацией о служащем организации. 
 * Используется при выводе карты прохода.
 */
public class WorkerValueObject {
	private int worker;
	private String lastname;
	private String firstname;
	private String middlename;
	private String passportser;
	private java.sql.Date passportdate;
	private String passportwhom;

	private String orgname;
public WorkerValueObject() {
	super();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFirstname() {
	return firstname;
}
public java.lang.String getFullname()
{
	StringBuffer result = new StringBuffer();
	if(lastname != null) {
		result.append(lastname.trim()); 
		if(firstname != null) {
			result.append(" ");
			result.append(firstname.trim());
			if(middlename != null) {
				result.append(" ");
				result.append(lastname.trim());
			}
		}
	}
	return result.toString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getMiddlename() {
	return middlename;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getPassportdate() {
	return passportdate;
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
/**
 * 
 * @return int
 */
public int getWorker() {
	return worker;
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
/**
 * 
 * @param newMiddlename java.lang.String
 */
public void setMiddlename(java.lang.String newMiddlename) {
	middlename = newMiddlename;
}
/**
 * 
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
/**
 * 
 * @param newPassportdate java.sql.Date
 */
public void setPassportdate(java.sql.Date newPassportdate) {
	passportdate = newPassportdate;
}
/**
 * 
 * @param newPassportser java.lang.String
 */
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
/**
 * 
 * @param newWorker int
 */
public void setWorker(int newWorker) {
	worker = newWorker;
}
}
