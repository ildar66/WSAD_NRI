package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface ComEquipmentHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ComEquipment
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ComEquipment create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ComEquipment
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ComEquipment create(int argStorageplace, Integer argDivision, String argName, String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ComEquipment
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ComEquipment create(int argStorageplace, Integer argDivision, String argName, String argAddress, Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return java.util.Enumeration
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByPositionType(Integer argPosition, String argType, Integer argOrder) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.ComEquipment
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ComEquipment findByPrimaryKey(StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findComEquipmentsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
