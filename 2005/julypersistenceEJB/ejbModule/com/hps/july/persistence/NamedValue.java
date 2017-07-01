package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface NamedValue extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for charvalue
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCharvalue() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getDatevalue() throws java.rmi.RemoteException;
/**
 * Getter method for decimalvalue
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDecimalvalue() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getId() throws java.rmi.RemoteException;
/**
 * Getter method for intvalue
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIntvalue() throws java.rmi.RemoteException;
/**
 * Setter method for charvalue
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCharvalue(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setDatevalue(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for decimalvalue
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDecimalvalue(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newId java.lang.String
 * @exception String The exception description.
 */
void setId(java.lang.String newId) throws java.rmi.RemoteException;
/**
 * Setter method for intvalue
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIntvalue(int newValue) throws java.rmi.RemoteException;
}
