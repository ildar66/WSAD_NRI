package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPhotoBlobHomeBean_e4daa2aa
 */
public class EJSCMPPhotoBlobHomeBean_e4daa2aa extends EJSHome {
	/**
	 * EJSCMPPhotoBlobHomeBean_e4daa2aa
	 */
	public EJSCMPPhotoBlobHomeBean_e4daa2aa() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PhotoBlob postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PhotoBlob) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PhotoBlob create(int argPhoto) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PhotoBlob _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PhotoBlobBean bean = (com.hps.july.persistence.PhotoBlobBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argPhoto);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argPhoto);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PhotoBlob findByPrimaryKey(com.hps.july.persistence.PhotoBlobKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPhotoBlobBean_e4daa2aa) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PhotoBlobBean tmpEJB = (com.hps.july.persistence.PhotoBlobBean) generalEJB;
		com.hps.july.persistence.PhotoBlobKey keyClass = new com.hps.july.persistence.PhotoBlobKey();
		keyClass.photo = tmpEJB.photo;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PhotoBlobKey keyFromFields(int f0) {
		com.hps.july.persistence.PhotoBlobKey keyClass = new com.hps.july.persistence.PhotoBlobKey();
		keyClass.photo = f0;
		return keyClass;
	}
}
