package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface SwitchHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Switch
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Switch create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Switch
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Switch create(int argStorageplace, Integer argDivision, String argName, String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Switch
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @param argType java.lang.String
 * @param argNumber java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Switch create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.String argType, java.lang.Integer argNumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return java.util.Enumeration
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.Switch
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Switch findByPrimaryKey(StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.Switch
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
public java.util.Enumeration findByQBE( Boolean isNumber, Integer argNumber, Boolean isType, String argType, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.Switch
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
public java.util.Enumeration findByQBE2( Boolean isNumber, Integer argNumber, 
	Boolean isType, String argType,
	Boolean isPlanState, String argPlanState,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSwitchesByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
