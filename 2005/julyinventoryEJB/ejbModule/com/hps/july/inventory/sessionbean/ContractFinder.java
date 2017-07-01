package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ContractFinder extends javax.ejb.EJBObject {

/**
 * 
 * @return java.lang.Integer
 * @param party java.lang.String
 * @exception String The exception description.
 */
java.lang.Integer findContractByParty(java.lang.String party) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @param serial java.lang.String
 * @exception String The exception description.
 */
java.lang.Integer findContractBySerial(java.lang.String serial) throws java.rmi.RemoteException;
}
