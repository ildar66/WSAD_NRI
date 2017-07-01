package com.hps.july.persistence;

/**
 * EJSFinderLeaseMRCntPriorBean
 */
public interface EJSFinderLeaseMRCntPriorBean {
	/**
	 * findLeaseMRCntPriors2ByContract2
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMRCntPriors2ByContract2(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMRCntPriors1ByContract1
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMRCntPriors1ByContract1(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByReglamentContractOrderbyPriorityAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByReglamentContractOrderbyPriorityAsc(java.lang.Integer reglament, java.lang.Integer contract1, java.lang.Integer contract2) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMRCntPriorsByReglament
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMRCntPriorsByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
