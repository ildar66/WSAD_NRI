package com.hps.july.commonbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Organizer extends javax.ejb.EJBObject {

/**
 * 
 * @return com.hps.july.organizer.valueobject.OperatorTask []
 * @param operator java.lang.String
 * @exception String The exception description.
 */
com.hps.july.organizer.valueobject.OperatorTask [] getOperatorTasks(java.lang.String operator) throws java.rmi.RemoteException;
}
