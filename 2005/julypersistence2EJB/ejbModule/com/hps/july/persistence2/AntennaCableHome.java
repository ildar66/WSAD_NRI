package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AntennaCableHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.AntennaCable
 * @param argIdcable int
 * @param argIdAntenna int
 * @param argCableRes int
 * @param argLenCable java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.AntennaCable create(int argIdcable, int argIdAntenna, int argCableRes, java.math.BigDecimal argLenCable) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.AntennaCable
 * @param key com.hps.july.persistence2.AntennaCableKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByAnten(Integer argAntenId) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.AntennaCable
 * @param key com.hps.july.persistence2.AntennaCableKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.AntennaCable findByPrimaryKey(com.hps.july.persistence2.AntennaCableKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
