package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeaseAbonentBANHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentBAN
 * @param argLeaseDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseAbonentBAN create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentBAN
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
 * @param argBan int
 * @param argFlagWorkPIE boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseAbonentBAN create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.String argContractType, java.lang.String argContractState, java.lang.Integer argOrgCustomer, java.lang.Integer argOrgExecutor, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.String argExtendType, java.lang.String argReportPeriod, java.lang.String agrCustname, java.lang.String argExecname, int argBan, boolean argFlagWorkPIE) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentBAN
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByBAN(Integer argBan) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentBAN
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByFlagWorkPIE(String argFlagWorkPIE) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentBAN
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseAbonentBAN findByPrimaryKey(LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
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
java.util.Enumeration findByQBE(String contractType, Boolean isOrgCustomer, Integer orgCustomer, Boolean isOrgExecutor, Integer orgExecutor, Boolean isMainEconomist, Integer mainEconomist, Boolean isDocNumber, String docNumber, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
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
java.util.Enumeration findByQBE2(
    Boolean isCustomerName, String customerName,
    Boolean isCustomerInn, String customerInn,
    Boolean isBan, String ban,
    Integer order)

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
java.util.Enumeration findByQBE3(
    Boolean isCustomerName, String customerName,
    Boolean isCustomerInn, String customerInn,
    Boolean isBan, String ban,
    Boolean isContractState, String contractState,
    Integer order)

 throws java.rmi.RemoteException, javax.ejb.FinderException;
}
