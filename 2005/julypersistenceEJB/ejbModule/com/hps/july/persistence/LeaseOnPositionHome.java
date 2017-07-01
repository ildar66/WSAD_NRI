package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseOnPositionHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseOnPosition
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseOnPosition create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseOnPosition
 * @param argDocument java.lang.Integer
 * @param argPosition java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseOnPosition create(java.lang.Integer argDocument, java.lang.Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseOnPosition
 * @param key com.hps.july.persistence.LeaseOnPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseOnPosition findByPrimaryKey(com.hps.july.persistence.LeaseOnPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseOnPositionByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseonpositionsByLeaseArendaAgreementNew(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
