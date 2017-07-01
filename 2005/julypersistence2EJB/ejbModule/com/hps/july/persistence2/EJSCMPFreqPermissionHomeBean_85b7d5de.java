package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPFreqPermissionHomeBean_85b7d5de
 */
public class EJSCMPFreqPermissionHomeBean_85b7d5de extends EJSHome {
	/**
	 * EJSCMPFreqPermissionHomeBean_85b7d5de
	 */
	public EJSCMPFreqPermissionHomeBean_85b7d5de() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.FreqPermission postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.FreqPermission) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.FreqPermission create(int argFreqpermid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.FreqPermission _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.FreqPermissionBean bean = (com.hps.july.persistence2.FreqPermissionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argFreqpermid);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argFreqpermid);
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
	public com.hps.july.persistence2.FreqPermission findByPrimaryKey(com.hps.july.persistence2.FreqPermissionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPFreqPermissionBean_85b7d5de) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.FreqPermissionBean tmpEJB = (com.hps.july.persistence2.FreqPermissionBean) generalEJB;
		com.hps.july.persistence2.FreqPermissionKey keyClass = new com.hps.july.persistence2.FreqPermissionKey();
		keyClass.freqpermid = tmpEJB.freqpermid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.FreqPermissionKey keyFromFields(int f0) {
		com.hps.july.persistence2.FreqPermissionKey keyClass = new com.hps.july.persistence2.FreqPermissionKey();
		keyClass.freqpermid = f0;
		return keyClass;
	}
}
