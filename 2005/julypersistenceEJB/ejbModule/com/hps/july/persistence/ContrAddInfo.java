package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ContrAddInfo extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addContrParams(com.hps.july.persistence.ContrParams aContrParams) throws java.rmi.RemoteException;
/**
 * Getter method for acc_load
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getAcc_load() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getAct_date() throws java.rmi.RemoteException;
/**
 * Getter method for bad_cunsr_percent
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getBad_cunsr_percent() throws java.rmi.RemoteException;
/**
 * Getter method for bad_cunssr_percent
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getBad_cunssr_percent() throws java.rmi.RemoteException;
/**
 * Getter method for cap_use_percent
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getCap_use_percent() throws java.rmi.RemoteException;
/**
 * Getter method for conn_lost_avg
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getConn_lost_avg() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrAddInfo2controllers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Controller getController() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ContrAddInfo2controllers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getControllerKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getContrParams() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for koef_kk
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getKoef_kk() throws java.rmi.RemoteException;
/**
 * Getter method for load_aint_percent
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLoad_aint_percent() throws java.rmi.RemoteException;
/**
 * Getter method for load_max_day
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLoad_max_day() throws java.rmi.RemoteException;
/**
 * Getter method for load_max_hour
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLoad_max_hour() throws java.rmi.RemoteException;
/**
 * Getter method for ss7_load_avg
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSs7_load_avg() throws java.rmi.RemoteException;
/**
 * Getter method for traf_aint
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTraf_aint() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddContrParams(com.hps.july.persistence.ContrParams aContrParams) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveContrParams(com.hps.july.persistence.ContrParams aContrParams) throws java.rmi.RemoteException;
/**
 * Setter method for acc_load
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setAcc_load(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bad_cunsr_percent
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setBad_cunsr_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for bad_cunssr_percent
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setBad_cunssr_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for cap_use_percent
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setCap_use_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for conn_lost_avg
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setConn_lost_avg(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for koef_kk
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setKoef_kk(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_aint_percent
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_aint_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_max_day
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_max_day(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_max_hour
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_max_hour(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for ss7_load_avg
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSs7_load_avg(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for traf_aint
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTraf_aint(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
