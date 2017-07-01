package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Controller extends com.hps.july.persistence.EquipmentSet {
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addBaseStation(com.hps.july.persistence.BaseStation aBaseStation) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAint_qty() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAtr_qty() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAtr_qty_max() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getBaseStation() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getCommentctrl() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrAddInfo2controllers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getContrAddInfos() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getContype() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getHway_qty_grps() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getHway_qty_voice() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getLac_numbers() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getMfs_num() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOmcr_num() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getQtyshell() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Switch getSwitch() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getSwitchKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getTrx_use_percent() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getTrxfr_qty() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getTrxfr_qty_max() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getTrxhr_qty() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getVerpo() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSwitchKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddBaseStation(com.hps.july.persistence.BaseStation aBaseStation) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrAddInfo2controllers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddContrAddInfos(com.hps.july.persistence.ContrAddInfo aContrAddInfos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named BaseStation2Controller.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveBaseStation(com.hps.july.persistence.BaseStation aBaseStation) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrAddInfo2controllers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveContrAddInfos(com.hps.july.persistence.ContrAddInfo aContrAddInfos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSwitch(com.hps.july.persistence.Switch aSwitch) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAint_qty(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAtr_qty(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAtr_qty_max(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setCommentctrl(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setContype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setHway_qty_grps(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setHway_qty_voice(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setLac_numbers(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setMfs_num(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setOmcr_num(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setQtyshell(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSwitch(com.hps.july.persistence.Switch aSwitch) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setTrx_use_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setTrxfr_qty(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setTrxfr_qty_max(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setTrxhr_qty(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setVerpo(java.lang.String newValue) throws java.rmi.RemoteException;
}
