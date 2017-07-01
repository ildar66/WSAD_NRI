package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface MSUser extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for mspassword
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getMspassword() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getMsucode() throws java.rmi.RemoteException;
/**
 * Getter method for msuser
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getMsuser() throws java.rmi.RemoteException;
/**
 * Setter method for mspassword
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setMspassword(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for msuser
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setMsuser(java.lang.String newValue) throws java.rmi.RemoteException;
}
