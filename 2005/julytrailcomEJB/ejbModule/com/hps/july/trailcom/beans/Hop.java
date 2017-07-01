package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Hop extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException;
/**
 * Getter method for abis_number
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAbis_number() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getBeenetid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getCreated() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getCreatedby() throws java.rmi.RemoteException;
/**
 * Getter method for equipmentid_enda
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getEquipmentid_enda() throws java.rmi.RemoteException;
/**
 * Getter method for equipmentid_endb
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getEquipmentid_endb() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getExpindate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getExpoutdate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getHopLabels() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getHopsid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getHopstate() throws java.rmi.RemoteException;
/**
 * Getter method for hopstype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getHopstype() throws java.rmi.RemoteException;
/**
 * Getter method for lease_info
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLease_info() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getModified() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getModifiedby() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OpticalHop2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.OpticalHop getOpticalHop() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPermstatus() throws java.rmi.RemoteException;
/**
 * Getter method for rezerv
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRezerv() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RRLHops2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.RRLHops2 getRrlHops2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSitedoc2Hops() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for siteid_enda
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getSiteid_enda() throws java.rmi.RemoteException;
/**
 * Getter method for siteid_endb
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getSiteid_endb() throws java.rmi.RemoteException;
/**
 * Getter method for speed
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSpeed() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSitedoc2Hops(com.hps.july.trailcom.beans.Sitedoc2Hops aSitedoc2Hops) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSitedoc2Hops(com.hps.july.trailcom.beans.Sitedoc2Hops aSitedoc2Hops) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OpticalHop2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOpticalHop(com.hps.july.trailcom.beans.OpticalHop anOpticalHop) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RRLHops2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetRrlHops2(com.hps.july.trailcom.beans.RRLHops2 aRrlHops2) throws java.rmi.RemoteException;
/**
 * Setter method for abis_number
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAbis_number(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setBeenetid(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setCreated(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setCreatedby(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for equipmentid_enda
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setEquipmentid_enda(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for equipmentid_endb
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setEquipmentid_endb(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setExpindate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setExpoutdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setHopstate(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for hopstype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setHopstype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for lease_info
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLease_info(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setModified(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setModifiedby(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPermstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for rezerv
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRezerv(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for siteid_enda
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setSiteid_enda(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for siteid_endb
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setSiteid_endb(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for speed
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSpeed(java.lang.String newValue) throws java.rmi.RemoteException;
}
