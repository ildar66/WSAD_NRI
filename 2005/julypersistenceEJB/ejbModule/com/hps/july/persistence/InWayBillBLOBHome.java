package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface InWayBillBLOBHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.InWayBillBLOB
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.InWayBillBLOB create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.InWayBillBLOB
 * @param key com.hps.july.persistence.InWayBillBLOBKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.InWayBillBLOB findByPrimaryKey(com.hps.july.persistence.InWayBillBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
