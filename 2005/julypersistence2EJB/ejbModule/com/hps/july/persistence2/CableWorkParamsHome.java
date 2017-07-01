package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface CableWorkParamsHome extends javax.ejb.EJBHome {
/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence2.CableWorkParams
 * @param argBand short
 * @param argId_anten int
 * @param argId_cable int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence2.CableWorkParams create(short argBand, int argId_anten, int argId_cable) throws javax.ejb.CreateException, java.rmi.RemoteException;
	java.util.Enumeration findByCable(Integer argCableId) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.CableWorkParams
 * @param key com.hps.july.persistence2.CableWorkParamsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.CableWorkParams findByPrimaryKey(com.hps.july.persistence2.CableWorkParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
