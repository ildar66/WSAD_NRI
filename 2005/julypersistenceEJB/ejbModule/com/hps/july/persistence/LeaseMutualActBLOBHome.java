package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseMutualActBLOBHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseMutualActBLOB
 * @param argLeasedocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseMutualActBLOB create(int argLeasedocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseMutualActBLOB
 * @param key com.hps.july.persistence.LeaseMutualActBLOBKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseMutualActBLOB findByPrimaryKey(com.hps.july.persistence.LeaseMutualActBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
