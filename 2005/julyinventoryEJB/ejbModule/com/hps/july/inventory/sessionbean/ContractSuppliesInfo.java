package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ContractSuppliesInfo extends javax.ejb.EJBObject {

/**
 * 
 * @return java.math.BigDecimal
 * @param argContract java.lang.Integer
 * @exception String The exception description.
 */
java.math.BigDecimal getSuppliesSum(java.lang.Integer argContract) throws java.rmi.RemoteException;
}
