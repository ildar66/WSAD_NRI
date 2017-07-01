package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface ContractHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Contract
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Contract create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Contract
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankindex int
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @param argCurrency java.lang.Integer
 * @param argName java.lang.String
 * @param argWorker java.lang.Integer
 * @param argController java.lang.Integer
 * @param argStartDate java.sql.Date
 * @param argFinishDate java.sql.Date
 * @param argSum java.math.BigDecimal
 * @param argSupplyType java.lang.Integer
 * @param argBaseAgreement java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Contract create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Integer argCurrency, java.lang.String argName, java.lang.Integer argWorker, java.lang.Integer argController, java.sql.Date argStartDate, java.sql.Date argFinishDate, java.math.BigDecimal argSum, java.lang.Integer argSupplyType, java.lang.Integer argBaseAgreement) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Contract
 * @param key com.hps.july.persistence.DocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Contract findByPrimaryKey(DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2BaseAgreement.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findContractByBaseAgreement(com.hps.july.persistence.BaseAgreementKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findContractByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findContractByQBE( Integer argSupplyType, Boolean isBaseAgreement, 
	Integer argBaseAgreement, Boolean isOrganization, Integer argOrganization, 
	Boolean isContragent, Integer argContragent, java.sql.Date argStartDate, java.sql.Date argFinishDate,
	Boolean isState, String argState, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findContractByQBE2(Boolean isSupplyType, Integer sypplyType,
Boolean isOwner, Integer owner, Boolean isContragent, Integer contragent,
String matchName, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findContractByQBE3( Integer argSupplyType, Boolean isBaseAgreement, 
	Integer argBaseAgreement, Boolean isOrganization, Integer argOrganization, 
	Boolean isContragent, Integer argContragent, java.sql.Date argBlankDate, java.sql.Date argFinishDate,
	Boolean isState, String argState, Integer order ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findContractBySupplyType(com.hps.july.persistence.SupplyTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findControlledContractByController(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findWorkedContractByWorker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
