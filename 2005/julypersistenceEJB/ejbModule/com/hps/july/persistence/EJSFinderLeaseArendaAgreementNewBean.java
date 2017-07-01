package com.hps.july.persistence;

/**
 * EJSFinderLeaseArendaAgreementNewBean
 */
public interface EJSFinderLeaseArendaAgreementNewBean {
	/**
	 * findByQBE4
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE4(java.lang.Boolean isEconomist, java.lang.Integer economist) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByContractAndResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByContractAndResource(java.lang.Integer contract, java.lang.Integer resource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseArendaAgreementNewsByMainposition
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseArendaAgreementNewsByMainposition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Boolean isState, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE3
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE3(java.lang.Boolean isEndDate, java.sql.Date startEndDate, java.sql.Date finishEndDate, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Boolean isContractState, java.lang.String ContractState, java.lang.Boolean isExtendType, java.lang.String ExtendType, java.lang.Boolean isEconomist, java.lang.Integer economist) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE5
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE5(java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Boolean isState, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Integer mainLeaseDocument, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Boolean isContractState, java.lang.String contractState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
