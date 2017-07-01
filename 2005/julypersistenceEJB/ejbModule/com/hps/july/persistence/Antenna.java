package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Antenna extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntena2sectors() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAntennaWorkBands() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for azant
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getAzant() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getAzvariation() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getByhand() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CableResource getCableres() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getCableresKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDatasource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getElectricalTilt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.EquipmentSet getEquipment() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getEquipmentKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getGroundcnt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getGroundresource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getGroundresourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for hset1
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getHset1() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdanten() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getInputpower() throws java.rmi.RemoteException;
/**
 * Getter method for kindant
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getKindant() throws java.rmi.RemoteException;
/**
 * Getter method for kswn
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getKswn() throws java.rmi.RemoteException;
/**
 * Getter method for lencable
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLencable() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getLocationtype() throws java.rmi.RemoteException;
/**
 * Getter method for nakl
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNakl() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNaklvariation() throws java.rmi.RemoteException;
/**
 * Getter method for numant
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNumant() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Operator getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OperatorKey getOperatorKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getPlanfacttype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRepiters() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AntennaResource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getStoragecard() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCableresKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetEquipmentKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetGroundresourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntena2sectors(com.hps.july.persistence.Antena2sector anAntena2sectors) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAntennaWorkBands(com.hps.july.persistence.AntennaWorkBand anAntennaWorkBands) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antena2sector2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntena2sectors(com.hps.july.persistence.Antena2sector anAntena2sectors) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaWorkBand2antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAntennaWorkBands(com.hps.july.persistence.AntennaWorkBand anAntennaWorkBands) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRepiters(com.hps.july.persistence.Repiter aRepiters) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCableres(com.hps.july.persistence.CableResource aCableres) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.AntennaResource aResource) throws java.rmi.RemoteException;
/**
 * Setter method for azant
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setAzant(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setAzvariation(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setByhand(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2cableres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCableres(com.hps.july.persistence.CableResource aCableres) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setDatasource(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setElectricalTilt(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setGroundcnt(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setGroundresource(com.hps.july.persistence.Resource aGroundresource) throws java.rmi.RemoteException;
/**
 * Setter method for hset1
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setHset1(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setInputpower(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for kindant
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setKindant(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for kswn
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setKswn(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for lencable
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLencable(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setLocationtype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nakl
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNakl(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNaklvariation(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for numant
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumant(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setPlanfacttype(int newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.AntennaResource aResource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setStoragecard(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
