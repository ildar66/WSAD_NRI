package com.hps.july.persistence;

/**
 * EJSFinderContractBean
 */
public interface EJSFinderContractBean {
	/**
	 * findControlledContractByController
	 */
	public com.ibm.ejs.persistence.EJSFinder findControlledContractByController(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findContractBySupplyType
	 */
	public com.ibm.ejs.persistence.EJSFinder findContractBySupplyType(com.hps.july.persistence.SupplyTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findContractByCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findContractByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findContractByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findContractByQBE2(java.lang.Boolean isSupplyType, java.lang.Integer sypplyType, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.String matchName, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findContractByQBE3
	 */
	public com.ibm.ejs.persistence.EJSFinder findContractByQBE3(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argBlankDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findWorkedContractByWorker
	 */
	public com.ibm.ejs.persistence.EJSFinder findWorkedContractByWorker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findContractByBaseAgreement
	 */
	public com.ibm.ejs.persistence.EJSFinder findContractByBaseAgreement(com.hps.july.persistence.BaseAgreementKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findContractByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findContractByQBE(java.lang.Integer argSupplyType, java.lang.Boolean isBaseAgreement, java.lang.Integer argBaseAgreement, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isContragent, java.lang.Integer argContragent, java.sql.Date argStartDate, java.sql.Date argFinishDate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
