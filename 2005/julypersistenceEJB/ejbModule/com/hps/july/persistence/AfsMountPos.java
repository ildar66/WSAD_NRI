package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: AfsMountPos
 */
public interface AfsMountPos extends com.hps.july.persistence.InternalWayBillPosition, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * Getter method for az_ant
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getAz_ant() throws java.rmi.RemoteException;
/**
 * Getter method for az_variation
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAz_variation() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getDdk() throws java.rmi.RemoteException;
/**
 * Getter method for docpostype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDocpostype() throws java.rmi.RemoteException;
/**
 * Getter method for groundcnt
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getGroundcnt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getGroundresource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getGroundresourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for h_set1
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getH_set1() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getHas_buster() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getHas_flt() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getHas_lna() throws java.rmi.RemoteException;
/**
 * Getter method for input_power
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getInput_power() throws java.rmi.RemoteException;
/**
 * Getter method for kind_ant
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getKind_ant() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getKsvn1800() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getKsvn2000() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getKsvn800() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getKsvn900() throws java.rmi.RemoteException;
/**
 * Getter method for kswn
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getKswn() throws java.rmi.RemoteException;
/**
 * Getter method for len_cable
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLen_cable() throws java.rmi.RemoteException;
/**
 * Getter method for nakl
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNakl() throws java.rmi.RemoteException;
/**
 * Getter method for nakl_variation
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNakl_variation() throws java.rmi.RemoteException;
/**
 * Getter method for num_ant
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNum_ant() throws java.rmi.RemoteException;
/**
 * Getter method for parentdocpos
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getParentdocpos() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorA() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorB() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorC() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorD() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorE() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorF() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorG() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorH() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorO() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSectorO1800() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetGroundresourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException;
/**
 * Setter method for az_ant
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setAz_ant(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for az_variation
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAz_variation(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newDdk java.lang.Boolean
 * @exception String The exception description.
 */
void setDdk(java.lang.Boolean newDdk) throws java.rmi.RemoteException;
/**
 * Setter method for docpostype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDocpostype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for groundcnt
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setGroundcnt(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException;
/**
 * Setter method for h_set1
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setH_set1(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newHas_buster java.lang.Boolean
 * @exception String The exception description.
 */
void setHas_buster(java.lang.Boolean newHas_buster) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newHas_flt java.lang.Boolean
 * @exception String The exception description.
 */
void setHas_flt(java.lang.Boolean newHas_flt) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newHas_lna java.lang.Boolean
 * @exception String The exception description.
 */
void setHas_lna(java.lang.Boolean newHas_lna) throws java.rmi.RemoteException;
/**
 * Setter method for input_power
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setInput_power(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for kind_ant
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setKind_ant(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setKsvn1800(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setKsvn2000(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setKsvn800(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setKsvn900(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for kswn
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setKswn(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for len_cable
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLen_cable(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nakl
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNakl(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nakl_variation
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNakl_variation(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for num_ant
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNum_ant(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for parentdocpos
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setParentdocpos(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorA java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorA(java.lang.Boolean newSectorA) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorB java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorB(java.lang.Boolean newSectorB) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorC java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorC(java.lang.Boolean newSectorC) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorD java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorD(java.lang.Boolean newSectorD) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorE java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorE(java.lang.Boolean newSectorE) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorF java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorF(java.lang.Boolean newSectorF) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorG java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorG(java.lang.Boolean newSectorG) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorH java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorH(java.lang.Boolean newSectorH) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorO java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorO(java.lang.Boolean newSectorO) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSectorO1800 java.lang.Boolean
 * @exception String The exception description.
 */
void setSectorO1800(java.lang.Boolean newSectorO1800) throws java.rmi.RemoteException;
}
