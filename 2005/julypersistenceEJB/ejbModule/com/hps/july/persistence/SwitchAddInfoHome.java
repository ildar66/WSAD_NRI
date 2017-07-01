package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SwitchAddInfoHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.SwitchAddInfo
 * @param argEquipment java.lang.Integer
 * @param argAct_date java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SwitchAddInfo create(java.lang.Integer argEquipment, java.sql.Date argAct_date) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByEquipmentOrderByActdateAsc(Integer equipment) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SwitchAddInfo
 * @param key com.hps.july.persistence.SwitchAddInfoKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SwitchAddInfo findByPrimaryKey(com.hps.july.persistence.SwitchAddInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findSwitchAddInfosBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
