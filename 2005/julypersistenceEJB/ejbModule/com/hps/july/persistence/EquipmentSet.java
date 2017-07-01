package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface EquipmentSet extends com.hps.july.persistence.StoragePlace, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDatasource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDateassemb() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDatebldbeg() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDatepr() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDatetest() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getEquipcomment() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getEquipmentState() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getFaultReport() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectActions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPwrcat() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPwrrescat() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getPwrreserve() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getPwrval() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Antenna2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
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
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDateassemb(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDatebldbeg(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDatepr(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDatetest(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setEquipcomment(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setEquipmentState(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPwrcat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPwrrescat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setPwrreserve(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setPwrval(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
