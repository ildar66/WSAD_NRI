package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseAbonentPhoneHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentPhone
 * @param argLeasedocument int
 * @param argPhonenumber java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseAbonentPhone create(int argLeasedocument, java.lang.String argPhonenumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByLeaseDocumentOrderByPhoneNumberAsc(Integer leaseDocument)
 throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseAbonentPhone
 * @param key com.hps.july.persistence.LeaseAbonentPhoneKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseAbonentPhone findByPrimaryKey(com.hps.july.persistence.LeaseAbonentPhoneKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseAbonentPhonesByPhone2ban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
