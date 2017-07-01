package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SwitchAddInfo extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSwitchParams(com.hps.july.persistence.SwitchParams aSwitchParams) throws java.rmi.RemoteException;
/**
 * Getter method for abon_act_bss
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getAbon_act_bss() throws java.rmi.RemoteException;
/**
 * Getter method for abon_qty_bss
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getAbon_qty_bss() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getAct_date() throws java.rmi.RemoteException;
/**
 * Getter method for koeff_kn
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getKoeff_kn() throws java.rmi.RemoteException;
/**
 * Getter method for load_all_percent
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLoad_all_percent() throws java.rmi.RemoteException;
/**
 * Getter method for load_event_percent
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLoad_event_percent() throws java.rmi.RemoteException;
/**
 * Getter method for load_max_day
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLoad_max_day() throws java.rmi.RemoteException;
/**
 * Getter method for load_max_hour_all
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLoad_max_hour_all() throws java.rmi.RemoteException;
/**
 * Getter method for load_max_hour_bss
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLoad_max_hour_bss() throws java.rmi.RemoteException;
/**
 * Getter method for load_max_hour_nss
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLoad_max_hour_nss() throws java.rmi.RemoteException;
/**
 * Getter method for load_mobile
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLoad_mobile() throws java.rmi.RemoteException;
/**
 * Getter method for load_sms_percent
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLoad_sms_percent() throws java.rmi.RemoteException;
/**
 * Getter method for load_transit
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getLoad_transit() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Switch getSwitch() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getSwitchKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSwitchParams() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for traf_all
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTraf_all() throws java.rmi.RemoteException;
/**
 * Getter method for traf_bss_all
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTraf_bss_all() throws java.rmi.RemoteException;
/**
 * Getter method for traf_bss_bss
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTraf_bss_bss() throws java.rmi.RemoteException;
/**
 * Getter method for traf_nss_all
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTraf_nss_all() throws java.rmi.RemoteException;
/**
 * Getter method for traf_nss_nss
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTraf_nss_nss() throws java.rmi.RemoteException;
/**
 * Getter method for tryqty_mobile_all
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTryqty_mobile_all() throws java.rmi.RemoteException;
/**
 * Getter method for tryqty_sms_all
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTryqty_sms_all() throws java.rmi.RemoteException;
/**
 * Getter method for tryqty_transit_all
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getTryqty_transit_all() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSwitchParams(com.hps.july.persistence.SwitchParams aSwitchParams) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchParams2addinfo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSwitchParams(com.hps.july.persistence.SwitchParams aSwitchParams) throws java.rmi.RemoteException;
/**
 * Setter method for abon_act_bss
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setAbon_act_bss(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for abon_qty_bss
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setAbon_qty_bss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for koeff_kn
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setKoeff_kn(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_all_percent
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_all_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_event_percent
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_event_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_max_day
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_max_day(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_max_hour_all
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_max_hour_all(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_max_hour_bss
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_max_hour_bss(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_max_hour_nss
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_max_hour_nss(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_mobile
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_mobile(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_sms_percent
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_sms_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for load_transit
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setLoad_transit(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for traf_all
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTraf_all(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for traf_bss_all
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTraf_bss_all(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for traf_bss_bss
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTraf_bss_bss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for traf_nss_all
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTraf_nss_all(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for traf_nss_nss
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTraf_nss_nss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for tryqty_mobile_all
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTryqty_mobile_all(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for tryqty_sms_all
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTryqty_sms_all(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for tryqty_transit_all
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setTryqty_transit_all(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
