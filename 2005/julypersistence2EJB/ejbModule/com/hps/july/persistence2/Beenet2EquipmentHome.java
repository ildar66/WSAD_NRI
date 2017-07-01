package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Beenet2EquipmentHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence2.Beenet2Equipment
 * @param argBeenetid java.lang.String
 * @param argEquipment int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence2.Beenet2Equipment create(java.lang.String argBeenetid, int argEquipment) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByBeenetid(String beenetid) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.Beenet2Equipment
 * @param key com.hps.july.persistence2.Beenet2EquipmentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.Beenet2Equipment findByPrimaryKey(com.hps.july.persistence2.Beenet2EquipmentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
