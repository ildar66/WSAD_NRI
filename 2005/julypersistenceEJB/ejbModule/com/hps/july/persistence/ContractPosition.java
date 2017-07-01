package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: ContractPosition
 */
public interface ContractPosition extends com.hps.july.persistence.DocumentPosition, com.ibm.ivj.ejb.runtime.CopyHelper {


/**
 * Getter method for contractPositionOrder
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getContractPositionOrder() throws java.rmi.RemoteException;
/**
 * Setter method for contractPositionOrder
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setContractPositionOrder(java.lang.String newValue) throws java.rmi.RemoteException;
}
