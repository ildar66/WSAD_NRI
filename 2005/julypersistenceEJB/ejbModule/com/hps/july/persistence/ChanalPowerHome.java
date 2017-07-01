package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ChanalPowerHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ChanalPower
 * @param argEquipment int
 * @param argChanal int
 * @param argPolarization java.lang.String
 * @param argPower int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ChanalPower create(int argEquipment, int argChanal, java.lang.String argPolarization, int argPower) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ChanalPower
 * @param argEquipment int
 * @param argChanal int
 * @param argPolarization java.lang.String
 * @param argBand int
 * @param argPower int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ChanalPower create(int argEquipment, int argChanal, java.lang.String argPolarization, int argBand, int argPower) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ChanalPower
 * @param key com.hps.july.persistence.ChanalPowerKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ChanalPower findByPrimaryKey(com.hps.july.persistence.ChanalPowerKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findChanalPowersByBasestation(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
