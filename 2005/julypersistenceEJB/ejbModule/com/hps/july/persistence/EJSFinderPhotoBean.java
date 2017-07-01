package com.hps.july.persistence;

/**
 * EJSFinderPhotoBean
 */
public interface EJSFinderPhotoBean {
	/**
	 * findPhotoByPhotographer
	 */
	public com.ibm.ejs.persistence.EJSFinder findPhotoByPhotographer(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPhotoByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findPhotoByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPhoto
	 */
	public com.ibm.ejs.persistence.EJSFinder findPhoto(java.lang.Integer storageplace, java.lang.Boolean isDate, java.sql.Date startDate, java.sql.Date stopDate, java.lang.Boolean isPhotographer, java.lang.Integer photographerId) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
