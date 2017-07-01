package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectAction extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectActionDocuments(com.hps.july.persistence.ProjectActionDocument aProjectActionDocuments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * Getter method for agreement
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getAgreement() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getCompleted() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.EquipmentSet getEquipment() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getEquipmentKey() throws java.rmi.RemoteException;
/**
 * Getter method for factdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getFactdate() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getHasproblems() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsNewplandate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNotes() throws java.rmi.RemoteException;
/**
 * Getter method for order
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOrder() throws java.rmi.RemoteException;
/**
 * Getter method for plandate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getPlandate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Project getProject() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getProjectaction() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getProjectActionComments() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectActionDocuments() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectActionType getProjectactiontype() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectActionTypeKey getProjectactiontypeKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectKey getProjectKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSiteDocs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getSuggplandate() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean isComplete() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetEquipmentKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjectactiontypeKey(com.hps.july.persistence.ProjectActionTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjectKey(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddProjectActionComments(com.hps.july.persistence.ProjectActionComments aProjectActionComments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectActionDocuments(com.hps.july.persistence.ProjectActionDocument aProjectActionDocuments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveProjectActionComments(com.hps.july.persistence.ProjectActionComments aProjectActionComments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectActionDocuments(com.hps.july.persistence.ProjectActionDocument aProjectActionDocuments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProject(com.hps.july.persistence.Project aProject) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProjectactiontype(com.hps.july.persistence.ProjectActionType aProjectactiontype) throws java.rmi.RemoteException;
/**
 * Setter method for agreement
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setAgreement(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setCompleted(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException;
/**
 * Setter method for factdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setFactdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setHasproblems(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsNewplandate(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNotes(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for order
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOrder(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for plandate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setPlandate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProject(com.hps.july.persistence.Project aProject) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProjectactiontype(com.hps.july.persistence.ProjectActionType aProjectactiontype) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setSuggplandate(java.sql.Date newValue) throws java.rmi.RemoteException;
}
