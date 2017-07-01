package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Region extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPositions(com.hps.july.persistence.Position aPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RegionAcc2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getFullarendainfo() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getHasmap() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPositions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named RegionAcc2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRegionAccs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getRegionid() throws java.rmi.RemoteException;
/**
 * Getter method for regname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRegname() throws java.rmi.RemoteException;
/**
 * Getter method for sectorprefix
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSectorprefix() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SuperRegion getSuperregion() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SuperRegionKey getSuperregionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSuperregionKey(com.hps.july.persistence.SuperRegionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPositions(com.hps.july.persistence.Position aPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RegionAcc2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePositions(com.hps.july.persistence.Position aPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RegionAcc2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRegionAccs(com.hps.july.persistence.RegionAcc aRegionAccs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSuperregion(com.hps.july.persistence.SuperRegion aSuperregion) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setFullarendainfo(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setHasmap(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for regname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRegname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sectorprefix
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSectorprefix(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Region2superregion.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSuperregion(com.hps.july.persistence.SuperRegion aSuperregion) throws java.rmi.RemoteException;
}
