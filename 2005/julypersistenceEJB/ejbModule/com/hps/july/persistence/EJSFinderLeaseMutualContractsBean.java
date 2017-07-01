package com.hps.july.persistence;

/**
 * EJSFinderLeaseMutualContractsBean
 */
public interface EJSFinderLeaseMutualContractsBean {
	/**
	 * findLeaseArendaAgreementsByReglament
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseArendaAgreementsByReglament(java.lang.Integer argReglament) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMutualContractsByReglament
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualContractsByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMutualContractsByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualContractsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseMutualContractsByContract
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualContractsByContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
