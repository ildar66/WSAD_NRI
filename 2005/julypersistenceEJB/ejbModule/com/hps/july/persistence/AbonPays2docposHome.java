package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AbonPays2docposHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.AbonPays2docpos
 * @param argLeaseDocposition int
 * @param argPayPos int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AbonPays2docpos create(int argLeaseDocposition, int argPayPos) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonPays2docpos findAbonPays2docposByLeasedocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAbonPays2docposesByPaypos(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AbonPays2docpos
 * @param key com.hps.july.persistence.AbonPays2docposKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AbonPays2docpos findByPrimaryKey(com.hps.july.persistence.AbonPays2docposKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
