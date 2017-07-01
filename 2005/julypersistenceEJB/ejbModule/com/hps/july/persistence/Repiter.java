package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Repiter extends com.hps.july.persistence.EquipmentSet {
/**
 * Getter method for bandwidth
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getBandwidth() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate_assemb_afs() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate_connect() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate_onair() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Antenna getDonor_ant() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AntennaKey getDonor_antKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Sector getDonor_sect() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SectorKey getDonor_sectKey() throws java.rmi.RemoteException;
/**
 * Getter method for donor_type
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDonor_type() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getNumber() throws java.rmi.RemoteException;
/**
 * Getter method for numchanals
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getNumchanals() throws java.rmi.RemoteException;
/**
 * Getter method for repiter_class
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRepiter_class() throws java.rmi.RemoteException;
/**
 * Getter method for reppower
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getReppower() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.RepiterRes getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDonor_antKey(com.hps.july.persistence.AntennaKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDonor_sectKey(com.hps.july.persistence.SectorKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDonor_ant(com.hps.july.persistence.Antenna aDonor_ant) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDonor_sect(com.hps.july.persistence.Sector aDonor_sect) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetResource(com.hps.july.persistence.RepiterRes aResource) throws java.rmi.RemoteException;
/**
 * Setter method for bandwidth
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setBandwidth(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate_assemb_afs(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate_connect(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate_onair(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Antenna.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDonor_ant(com.hps.july.persistence.Antenna aDonor_ant) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2Sector.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDonor_sect(com.hps.july.persistence.Sector aDonor_sect) throws java.rmi.RemoteException;
/**
 * Setter method for donor_type
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDonor_type(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setNumber(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for numchanals
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumchanals(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for repiter_class
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRepiter_class(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for reppower
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setReppower(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Repiter2RepiterRes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.RepiterRes aResource) throws java.rmi.RemoteException;
}
