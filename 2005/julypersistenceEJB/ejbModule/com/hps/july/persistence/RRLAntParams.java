package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface RRLAntParams extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for amplifkoeff
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getAmplifkoeff() throws java.rmi.RemoteException;
/**
 * Getter method for antdiam
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getAntdiam() throws java.rmi.RemoteException;
/**
 * Getter method for dnangleh
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDnangleh() throws java.rmi.RemoteException;
/**
 * Getter method for dnanglew
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDnanglew() throws java.rmi.RemoteException;
/**
 * Getter method for resource
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getResource() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getRrlantid() throws java.rmi.RemoteException;
/**
 * Setter method for amplifkoeff
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setAmplifkoeff(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for antdiam
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setAntdiam(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dnangleh
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDnangleh(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dnanglew
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDnanglew(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for resource
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setResource(int newValue) throws java.rmi.RemoteException;
}
