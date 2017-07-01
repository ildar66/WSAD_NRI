package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Photo extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for date
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDate() throws java.rmi.RemoteException;
/**
 * Getter method for description
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDescription() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getPhoto() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getPhotographer() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getPhotographerKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPhotographerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetPhotographer(com.hps.july.persistence.Worker aPhotographer) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * Setter method for date
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for description
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDescription(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newPhoto int
 * @exception String The exception description.
 */
void setPhoto(int newPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setPhotographer(com.hps.july.persistence.Worker aPhotographer) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
}
