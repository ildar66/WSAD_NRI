package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeaseArendaAgreementNewHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseArendaAgreementNew
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseArendaAgreementNew findByPrimaryKey(LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;


java.util.Enumeration findByContractAndResource(Integer contract, Integer resource, Integer order)
	 throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * 
 * @return java.util.Enumeration
 * @param contractType java.lang.String
 * @param isOrgCustomer java.lang.Boolean
 * @param orgCustomer java.lang.Integer
 * @param isOrgExecutor java.lang.Boolean
 * @param orgExecutor java.lang.Integer
 * @param isMainEconomist java.lang.Boolean
 * @param mainEconomist java.lang.Integer
 * @param isDocNumber java.lang.Boolean
 * @param docNumber java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByQBE(
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isPosition, 			java.lang.Integer position, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber,
	java.lang.Boolean isState, 				java.lang.String state, // состояние базового договора
	java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;

java.util.Enumeration findByQBE2( java.lang.Integer mainLeaseDocument, 
	java.lang.Boolean isIsActive, 		Boolean isActive, 
	java.lang.Boolean isContractState,  String contractState,
	java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;

java.util.Enumeration findByQBE3(Boolean isEndDate, java.sql.Date startEndDate, java.sql.Date finishEndDate,
        Boolean isIsActive, Boolean isActive,
        Boolean isContractState, String ContractState,
        Boolean isExtendType, String ExtendType,
        Boolean isEconomist, Integer economist) throws java.rmi.RemoteException, javax.ejb.FinderException;

java.util.Enumeration findByQBE4(Boolean isEconomist, Integer economist)  
	throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * 
 * @return java.util.Enumeration
 * @param contractType java.lang.String
 * @param isOrgCustomer java.lang.Boolean
 * @param orgCustomer java.lang.Integer
 * @param isOrgExecutor java.lang.Boolean
 * @param orgExecutor java.lang.Integer
 * @param isMainEconomist java.lang.Boolean
 * @param mainEconomist java.lang.Integer
 * @param isDocNumber java.lang.Boolean
 * @param docNumber java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByQBE5(
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isPosition, 			java.lang.Integer position, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber,
	java.lang.Boolean isState, 				java.lang.String state, // состояние базового договора
	java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseArendaAgreementNewsByMainposition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argLeaseDocument int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew create(
		int argLeaseDocument,
		java.sql.Date argDocDate,
		String argDocNumber,
		String argContractType,
		String argContractState,
		Integer argOrgCustomer,
		Integer argOrgExecutor,
		java.sql.Date argStartDate,
		java.sql.Date argEndDate,
		String argExtendType,
		String argReportPeriod,
		Boolean argIsActive,
		String argHowGivePhones,
		String argCalcElectroType,
		Boolean argIsDogElectro,
		String agrCustname,
		String argExecname,
		Integer argMainDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
