package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: AfsMountAct
 */
public interface AfsMountAct extends com.hps.july.persistence.InternalWayBill, com.ibm.ivj.ejb.runtime.CopyHelper {


/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getAfstype() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setAfstype(java.lang.String newValue) throws java.rmi.RemoteException;
}
