package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseAbonentBENHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentBEN
 * @param argLeaseDocument int
 * @param argBen short
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseAbonentBEN create(int argLeaseDocument, short argBen) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByBen(Short argBen) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByLeasedocumentOrderByBenAsc(Integer argLeasedocument) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseAbonentBEN
 * @param key com.hps.july.persistence.LeaseAbonentBENKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseAbonentBEN findByPrimaryKey(com.hps.july.persistence.LeaseAbonentBENKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseAbonentBENsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
