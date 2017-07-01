package com.hps.july.persistence;

/**
 * EJSFinderLeaseMutualReglamentBean
 */
public interface EJSFinderLeaseMutualReglamentBean {
	/**
	 * findByLeaseDocumentOrderByDocumentNumberAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseDocumentOrderByDocumentNumberAsc(java.lang.Integer leaseDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDocDate, java.sql.Date docDate, java.lang.Boolean isBlank, java.lang.String blank, java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isMutStateEdit, java.lang.Boolean isMutStateRun, java.lang.Boolean isMutStateClose, java.lang.Boolean isActType, java.lang.String actType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMutualReglamentsMainByMaincurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualReglamentsMainByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByResourceContractDates
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResourceContractDates(java.lang.Integer resource, java.lang.Integer contract, java.sql.Date startDate, java.sql.Date finishDate) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByResourceContractMaxDateStart
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResourceContractMaxDateStart(java.lang.Integer resource, java.lang.Integer contract) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findConcurentReglamentsByReglament
	 */
	public com.ibm.ejs.persistence.EJSFinder findConcurentReglamentsByReglament(java.lang.Integer argReglament) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMutualReglamentsAddByAdditionalCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualReglamentsAddByAdditionalCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
