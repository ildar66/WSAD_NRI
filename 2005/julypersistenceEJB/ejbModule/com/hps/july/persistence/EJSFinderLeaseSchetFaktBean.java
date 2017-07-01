package com.hps.july.persistence;

/**
 * EJSFinderLeaseSchetFaktBean
 */
public interface EJSFinderLeaseSchetFaktBean {
	/**
	 * findLeaseSchetFaktsByIdAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseSchetFaktsByIdAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdActOrderByNumberSchetFaktAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdActOrderByNumberSchetFaktAsc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseSchetFaktsByIdContract
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseSchetFaktsByIdContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdContractOrderByDateSchetFaktAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdContractOrderByDateSchetFaktAsc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdContractOrderByDateSchetFaktDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdContractOrderByDateSchetFaktDesc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdContractOrderByNumberSchetFaktDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdContractOrderByNumberSchetFaktDesc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdActOrderByDateSchetFaktDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdActOrderByDateSchetFaktDesc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdActOrderByDateSchetFaktAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdActOrderByDateSchetFaktAsc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer idAct, java.lang.Boolean isContractType, java.lang.String typeContract, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdContractOrderByNumberSchetFaktAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdContractOrderByNumberSchetFaktAsc(java.lang.Integer idContract) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseSchetFaktsByIdCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseSchetFaktsByIdCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByIdActOrderByNumberSchetFaktDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdActOrderByNumberSchetFaktDesc(java.lang.Integer idAct) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
