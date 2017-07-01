package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface ControllerHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Controller
 * @param argStorageplace int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Controller create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Controller
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Controller create(int argStorageplace, Integer argDivision, String argName, String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Controller
 * @param argStorageplace int
 * @param argDivision java.lang.Integer
 * @param argName java.lang.String
 * @param argAddress java.lang.String
 * @param argPosition java.lang.Integer
 * @param argNumber java.lang.Integer
 * @param argCName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Controller create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.Integer argNumber, java.lang.String argCName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return java.util.Enumeration
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return com.hps.july.persistence.Controller
 * @param key com.hps.july.persistence.StoragePlaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Controller findByPrimaryKey(StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE( Boolean isNumber, Integer argNumber, Boolean isName, String argName,
	Boolean isSwitch, Integer argSwitch, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findControllerBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findControllersByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
