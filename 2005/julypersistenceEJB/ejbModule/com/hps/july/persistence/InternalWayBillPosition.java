package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: InternalWayBillPosition
 */
public interface InternalWayBillPosition extends com.hps.july.persistence.DocumentPosition, com.ibm.ivj.ejb.runtime.CopyHelper {


/**
 * Getter method for docQty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDocQty() throws java.rmi.RemoteException;
/**
 * Setter method for docQty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDocQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
