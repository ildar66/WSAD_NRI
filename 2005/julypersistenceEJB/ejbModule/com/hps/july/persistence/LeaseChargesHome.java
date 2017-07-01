package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeaseChargesHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseCharges
 * @param argLeaseDocPosition int
 * @param argDate java.sql.Date
 * @param argLeaseContract java.lang.Integer
 * @param argSource java.lang.String
 * @param argVid java.lang.String
 * @param argSDate java.sql.Date
 * @param argEDate java.sql.Date
 * @param argResource java.lang.Integer
 * @param argSumm java.math.BigDecimal
 * @param argCurrency java.lang.Integer
 * @param argSumNds java.math.BigDecimal
 * @param argRemainderSum java.math.BigDecimal
 * @param argByHandRateRur java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseCharges create(int argLeaseDocPosition, java.sql.Date argDate, java.lang.Integer argLeaseContract, java.lang.String argSource, java.lang.String argVid, java.sql.Date argSDate, java.sql.Date argEDate, java.lang.Integer argResource, java.math.BigDecimal argSumm, java.lang.Integer argCurrency, java.math.BigDecimal argSumNds, java.math.BigDecimal argRemainderSum, java.lang.Boolean argByHandRateRur) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByLeaseContract(Integer argContract) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.LeaseCharges
 * @param key com.hps.july.persistence.LeaseDocPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseCharges findByPrimaryKey(LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(Boolean isLeaseContract, Integer leaseContract,
            Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, 
            Boolean isResource, Integer resource,
            Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCharges2OrgExecutor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE2(Integer leaseRule,
    java.sql.Date startDate, 	java.sql.Date finishDate, // диапазон дат для date
    Boolean isSource, String source) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE3(Integer leaseContract, Integer resource, 
	java.sql.Date startInterval, java.sql.Date finishInterval)
 throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE4(
        Integer contract, 
        Boolean isStartDate, java.sql.Date actStartDate, 
        Boolean isEndDate, java.sql.Date actEndDate,
        Boolean isRemainder, java.math.BigDecimal remainder,
        Boolean isResource, Integer resource,
        Boolean isCalcPosOnly,
        Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE5(Boolean isLeaseContract, Integer leaseContract,
            Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, 
            Boolean isResource, Integer resource,
            Boolean isDocposvid, String[] docposvid, 
            Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCharges2LeaseChargeRules.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseChargesByLeaseRule(com.hps.july.persistence.LeaseRuleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
