package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AbonBillpos2docposHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.AbonBillpos2docpos
 * @param argLeaseDocposition int
 * @param argBillPos int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AbonBillpos2docpos create(int argLeaseDocposition, int argBillPos) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonBillpos2docpos findAbonBillpos2docposByLeasedocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAbonBillpos2docposesByBillpos(com.hps.july.persistence.AbonentBillPosKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AbonBillpos2docpos
 * @param key com.hps.july.persistence.AbonBillpos2docposKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AbonBillpos2docpos findByPrimaryKey(com.hps.july.persistence.AbonBillpos2docposKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
