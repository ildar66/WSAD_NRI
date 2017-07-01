package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseMRCntPriorHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseMRCntPrior
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseMRCntPrior create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseMRCntPrior
 * @param argReglament java.lang.Integer
 * @param argContract1 java.lang.Integer
 * @param argContract2 java.lang.Integer
 * @param argPriority java.lang.Short
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseMRCntPrior create(java.lang.Integer argReglament, java.lang.Integer argContract1, java.lang.Integer argContract2, java.lang.Short argPriority) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseMRCntPrior
 * @param key com.hps.july.persistence.LeaseMRCntPriorKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseMRCntPrior findByPrimaryKey(com.hps.july.persistence.LeaseMRCntPriorKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByReglamentContractOrderbyPriorityAsc(Integer reglament, Integer contract1, Integer contract2)
 throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseMRCntPriors1ByContract1(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseMRCntPriors2ByContract2(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseMRCntPriorsByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
