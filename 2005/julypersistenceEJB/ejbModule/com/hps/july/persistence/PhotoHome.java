package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PhotoHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Photo
 * @param argPhoto int
 * @param argPosition java.lang.Integer
 * @param argDescription java.lang.String
 * @param argDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Photo create(int argPhoto, java.lang.Integer argPosition, java.lang.String argDescription, java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Photo
 * @param key com.hps.july.persistence.PhotoKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Photo findByPrimaryKey(com.hps.july.persistence.PhotoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPhoto(
			Integer storageplace,
			Boolean isDate, java.sql.Date startDate, java.sql.Date stopDate,
			Boolean isPhotographer, Integer photographerId
			) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Photo2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPhotoByPhotographer(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPhotoByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
