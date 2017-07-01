package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeaseContractHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseContract
 * @param argLeaseDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseContract create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseContract
 * @param argLeaseDocument int
 * @param argDocDate java.sql.Date
 * @param argDocNumber java.lang.String
 * @param argContractType java.lang.String
 * @param argContractState java.lang.String
 * @param argOrgCustomer java.lang.Integer
 * @param argOrgExecutor java.lang.Integer
 * @param argStartDate java.sql.Date
 * @param argEndDate java.sql.Date
 * @param argExtendType java.lang.String
 * @param argReportPeriod java.lang.String
 * @param agrCustname java.lang.String
 * @param argExecname java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseContract create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argContractType, java.lang.String argContractState, java.lang.Integer argOrgCustomer, java.lang.Integer argOrgExecutor, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.String argExtendType, java.lang.String argReportPeriod, java.lang.String agrCustname, java.lang.String argExecname) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseContract
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseContract findByPrimaryKey(LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2OrgExecutor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE( String contractType,
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseContract2ByCurrency2(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseContractByCurrency1(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseContractEconomistByEconomist(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseContractsByManager(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findLeaseContractsByReglamentOrderByCodeAsc(Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration findLeaseContractExecutorByOrgExecutor(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Enumeration findLeaseContractCustomerByOrgCustomer(com.hps.july.persistence.OrganizationNfsKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
