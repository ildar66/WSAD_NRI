package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface WLANHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.WLAN
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.WLAN create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.WLAN
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.WLAN create(int argStorageplace, Integer argDivision, String argName, String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.WLAN
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.WLAN create(int argStorageplace, Integer argDivision, String argName, String argAddress, Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.WLAN
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @param argNumber int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.WLAN create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, int argNumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
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
 * @param position java.lang.Integer
 * @param owner java.lang.Integer
 * @param state java.lang.String
 * @param order java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByPlatinumAndStatus(Integer position, Integer owner, String state, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.WLAN
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.WLAN findByPrimaryKey(StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
