package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: Switch
 */
public interface Switch extends com.hps.july.persistence.EquipmentSet, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addBaseStation(com.hps.july.persistence.BaseStation aBaseStation) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addController(com.hps.july.persistence.Controller aController) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getBaseStation() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getComment() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getController() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getE1_bss() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getE1_hlr() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getE1_nss() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getE1_qty_total() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getE1_use_percent() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getMaxvlr() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getMscid() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getNumber() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getQty_tkgroute_nss() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getQtyconhlr() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getQtyshell() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getSs7_hlrin() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getSs7bss() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getSs7nss() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSwitchAddInfos() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getSwitchType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddBaseStation(com.hps.july.persistence.BaseStation aBaseStation) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddController(com.hps.july.persistence.Controller aController) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSwitchAddInfos(com.hps.july.persistence.SwitchAddInfo aSwitchAddInfos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named BaseStation2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveBaseStation(com.hps.july.persistence.BaseStation aBaseStation) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2Switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveController(com.hps.july.persistence.Controller aController) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SwitchAddInfo2switch.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSwitchAddInfos(com.hps.july.persistence.SwitchAddInfo aSwitchAddInfos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setComment(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setE1_bss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setE1_hlr(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setE1_nss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setE1_qty_total(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setE1_use_percent(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setMaxvlr(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setMscid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setNumber(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setQty_tkgroute_nss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setQtyconhlr(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setQtyshell(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setSs7_hlrin(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setSs7bss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setSs7nss(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSwitchType java.lang.String
 * @exception String The exception description.
 */
void setSwitchType(java.lang.String newSwitchType) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: capacityused
	 */
	public java.lang.Integer getCapacityused() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: capacityused
	 */
	public void setCapacityused(java.lang.Integer newCapacityused)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: capacityplan
	 */
	public java.lang.Integer getCapacityplan() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: capacityplan
	 */
	public void setCapacityplan(java.lang.Integer newCapacityplan)
		throws java.rmi.RemoteException;
}
