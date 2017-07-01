package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPContainerHomeBean_91f4bd0b
 */
public class EJSCMPContainerHomeBean_91f4bd0b extends EJSHome {
	/**
	 * EJSCMPContainerHomeBean_91f4bd0b
	 */
	public EJSCMPContainerHomeBean_91f4bd0b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Container postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Container) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.Container findByPrimaryKey(com.hps.july.persistence2.ContainerKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPContainerBean_91f4bd0b) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.Container create(int argContainer, int argStoragePlace, int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Container _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.ContainerBean bean = (com.hps.july.persistence2.ContainerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argContainer, argStoragePlace, argResource);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.ContainerBean tmpEJB = (com.hps.july.persistence2.ContainerBean) generalEJB;
		com.hps.july.persistence2.ContainerKey keyClass = new com.hps.july.persistence2.ContainerKey();
		keyClass.container = tmpEJB.container;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.ContainerKey keyFromFields(int f0) {
		com.hps.july.persistence2.ContainerKey keyClass = new com.hps.july.persistence2.ContainerKey();
		keyClass.container = f0;
		return keyClass;
	}
}
