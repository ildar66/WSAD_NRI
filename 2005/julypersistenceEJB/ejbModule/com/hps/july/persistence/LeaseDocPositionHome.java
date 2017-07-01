package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseDocPositionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseDocPosition
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
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseDocPosition create(int argLeaseDocPosition, java.sql.Date argDate, java.lang.Integer argLeaseContract, java.lang.String argSource, java.lang.String argVid, java.sql.Date argSDate, java.sql.Date argEDate, java.lang.Integer argResource, java.math.BigDecimal argSumm, java.lang.Integer argCurrency, java.math.BigDecimal argSumNds) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseDocPosition
 * @param key com.hps.july.persistence.LeaseDocPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseDocPosition findByPrimaryKey(com.hps.july.persistence.LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(Boolean isLeaseContract, Integer leaseContract,
            Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, 
            Boolean isResource, Integer resource,
            Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE2(Integer leaseContract, Integer resource, java.sql.Date date, String docposvid) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE5(Boolean isLeaseContract, Integer leaseContract,
            Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, 
            Boolean isResource, Integer resource,
            Boolean isDocposvid, String[] docposvid, 
            Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseDocPositionByLeaseContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseDocPositionsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseDocPositionsByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseDocPositionsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
