package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface InventoryNumbersHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.InventoryNumbers
 * @param argSerid int
 * @param serdate java.sql.Date
 * @param serend java.lang.String
 * @param serprefix java.lang.String
 * @param serstart java.lang.String
 * @param serworker java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.InventoryNumbers create(int argSerid, java.sql.Date serdate, java.lang.String serend, java.lang.String serprefix, java.lang.String serstart, java.lang.Integer serworker) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.InventoryNumbers
 * @param key com.hps.july.persistence.InventoryNumbersKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.InventoryNumbers findByPrimaryKey(com.hps.july.persistence.InventoryNumbersKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInventoryNumbersBySerworker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOrderBySerprefixAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOrderBySerprefixDesc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOrderBySerstartAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findOrderBySerstartDesc() throws java.rmi.RemoteException, javax.ejb.FinderException;
}
