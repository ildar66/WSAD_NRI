package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseContractBLOBHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseContractBLOB
 * @param argLeaseDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseContractBLOB create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseContractBLOB
 * @param key com.hps.july.persistence.LeaseContractBLOBKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseContractBLOB findByPrimaryKey(com.hps.july.persistence.LeaseContractBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
