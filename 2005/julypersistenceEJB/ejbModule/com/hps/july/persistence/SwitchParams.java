package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SwitchParams extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for param_level
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getParam_level() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getParam_type() throws java.rmi.RemoteException;
/**
 * Getter method for param_value
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getParam_value() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getParamid() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SwitchAddInfo getSwitchaddinfo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SwitchAddInfoKey getSwitchaddinfoKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSwitchaddinfoKey(com.hps.july.persistence.SwitchAddInfoKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSwitchaddinfo(com.hps.july.persistence.SwitchAddInfo aSwitchaddinfo) throws java.rmi.RemoteException;
/**
 * Setter method for param_level
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setParam_level(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setParam_type(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for param_value
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setParam_value(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSwitchaddinfo(com.hps.july.persistence.SwitchAddInfo aSwitchaddinfo) throws java.rmi.RemoteException;
}
