package com.hps.july.persistence;

/**
 * EJSFinderChangeLogBean
 */
public interface EJSFinderChangeLogBean {
	/**
	 * findChangeLogsByPeople
	 */
	public com.ibm.ejs.persistence.EJSFinder findChangeLogsByPeople(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isObjtype, java.lang.Short objtype, java.lang.Boolean isObjid, java.lang.Integer objid, java.lang.Boolean isPeriod, java.sql.Timestamp dateStart, java.sql.Timestamp dateEnd, java.lang.Boolean isMan, java.lang.Integer man, java.lang.Boolean isEventtype, java.lang.String eventtype, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
