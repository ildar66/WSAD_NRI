package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEDopInfoContrHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.PIEDopInfoContr
 * @param argLeasedocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.PIEDopInfoContr create(int argLeasedocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEDopInfoContr
 * @param key com.hps.july.persistence.PIEDopInfoContrKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEDopInfoContr findByPrimaryKey(com.hps.july.persistence.PIEDopInfoContrKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
