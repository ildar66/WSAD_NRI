package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPhotoHomeBean_b9c81ce3
 */
public class EJSCMPPhotoHomeBean_b9c81ce3 extends EJSHome {
	/**
	 * EJSCMPPhotoHomeBean_b9c81ce3
	 */
	public EJSCMPPhotoHomeBean_b9c81ce3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Photo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Photo) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findPhotoByPhotographer
	 */
	public java.util.Enumeration findPhotoByPhotographer(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPhotoBean)persister).findPhotoByPhotographer(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Photo findByPrimaryKey(com.hps.july.persistence.PhotoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPhotoBean_b9c81ce3) persister).findByPrimaryKey(key);
	}
	/**
	 * findPhotoByPosition
	 */
	public java.util.Enumeration findPhotoByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPhotoBean)persister).findPhotoByPosition(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Photo create(int argPhoto, java.lang.Integer argPosition, java.lang.String argDescription, java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Photo _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PhotoBean bean = (com.hps.july.persistence.PhotoBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argPhoto, argPosition, argDescription, argDate);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPhoto
	 */
	public java.util.Enumeration findPhoto(java.lang.Integer storageplace, java.lang.Boolean isDate, java.sql.Date startDate, java.sql.Date stopDate, java.lang.Boolean isPhotographer, java.lang.Integer photographerId) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPhotoBean)persister).findPhoto(storageplace, isDate, startDate, stopDate, isPhotographer, photographerId));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PhotoBean tmpEJB = (com.hps.july.persistence.PhotoBean) generalEJB;
		com.hps.july.persistence.PhotoKey keyClass = new com.hps.july.persistence.PhotoKey();
		keyClass.photo = tmpEJB.photo;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PhotoKey keyFromFields(int f0) {
		com.hps.july.persistence.PhotoKey keyClass = new com.hps.july.persistence.PhotoKey();
		keyClass.photo = f0;
		return keyClass;
	}
}
