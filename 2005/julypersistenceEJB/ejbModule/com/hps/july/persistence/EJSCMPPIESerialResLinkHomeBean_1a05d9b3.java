package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIESerialResLinkHomeBean_1a05d9b3
 */
public class EJSCMPPIESerialResLinkHomeBean_1a05d9b3 extends EJSHome {
	/**
	 * EJSCMPPIESerialResLinkHomeBean_1a05d9b3
	 */
	public EJSCMPPIESerialResLinkHomeBean_1a05d9b3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIESerialResLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIESerialResLink) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIESerialResLink create(int argStoragecard, int argOwner, java.lang.String argSerial) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIESerialResLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIESerialResLinkBean bean = (com.hps.july.persistence.PIESerialResLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStoragecard, argOwner, argSerial);
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
	 * create
	 */
	public com.hps.july.persistence.PIESerialResLink create(int argStoragecard, int argOwner, java.lang.String argSerial, java.lang.String argIdResPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIESerialResLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIESerialResLinkBean bean = (com.hps.july.persistence.PIESerialResLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStoragecard, argOwner, argSerial, argIdResPlatinum);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIESerialResLink findByPrimaryKey(com.hps.july.persistence.PIESerialResLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIESerialResLinkBean_1a05d9b3) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIESerialResLinkBean tmpEJB = (com.hps.july.persistence.PIESerialResLinkBean) generalEJB;
		com.hps.july.persistence.PIESerialResLinkKey keyClass = new com.hps.july.persistence.PIESerialResLinkKey();
		keyClass.storagecard = tmpEJB.storagecard;
		keyClass.owner = tmpEJB.owner;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIESerialResLinkKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence.PIESerialResLinkKey keyClass = new com.hps.july.persistence.PIESerialResLinkKey();
		keyClass.storagecard = f0;
		keyClass.owner = f1;
		return keyClass;
	}
}
