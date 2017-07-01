package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ChangeActPositionHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.ChangeActPosition
 * @param argCode int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ChangeActPosition create(int argCode) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ChangeActPosition
 * @param argCode int
 * @param argOldSerial java.lang.String
 * @param argNewSerial java.lang.String
 * @param argChangeAct java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ChangeActPosition create(int argCode, java.lang.String argOldSerial, java.lang.String argNewSerial, java.lang.Integer argChangeAct) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByDocNewSerial(Integer argDoc, String argSerial) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ChangeActPosition
 * @param key com.hps.july.persistence.ChangeActPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ChangeActPosition findByPrimaryKey(com.hps.july.persistence.ChangeActPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findChangeActPositionByChangeAct(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findChangeActPositionsByNewresource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
