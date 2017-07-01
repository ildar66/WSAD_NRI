package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeaseMutualReglamentHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseMutualReglament
 * @param argLeaseDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseMutualReglament create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseMutualReglament
 * @param argLeaseDocument int
 * @param argDocDate java.sql.Date
 * @param argDocNumber java.lang.String
 * @param argMutualPeriod java.lang.String
 * @param argMainCurrency java.lang.Integer
 * @param argCommonRate java.lang.Boolean
 * @param argActType java.lang.String
 * @param argMutstate java.lang.String
 * @param argDutyraterule java.lang.String
 * @param argStartDate java.sql.Date
 * @param argEndDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseMutualReglament create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argMutualPeriod, java.lang.Integer argMainCurrency, java.lang.Boolean argCommonRate, java.lang.String argActType, java.lang.String argMutstate, java.lang.String argDutyraterule, java.sql.Date argStartDate, java.sql.Date argEndDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2OrgExecutor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByLeaseDocumentOrderByDocumentNumberAsc(Integer leaseDocument)
throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.LeaseMutualReglament
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseMutualReglament findByPrimaryKey(LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(
	java.lang.Boolean isDocDate, 			java.sql.Date docDate, 
	java.lang.Boolean isBlank, 				String blank, 
    java.lang.Boolean isLeaseContract, 		Integer leaseContract, 
    java.lang.Boolean isMutStateEdit, 
    java.lang.Boolean isMutStateRun, 
    java.lang.Boolean isMutStateClose, 
    java.lang.Boolean isActType, 			String actType, 
    java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByResourceContractDates(Integer resource, Integer contract, 
	java.sql.Date startDate, java.sql.Date finishDate) 
		throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByResourceContractMaxDateStart(Integer resource, Integer contract) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findConcurentReglamentsByReglament(Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseMutualReglamentsAddByAdditionalCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseMutualReglamentsMainByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;

}
