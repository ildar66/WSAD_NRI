package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTaskHomeBean_316560a8
 */
public class EJSCMPTaskHomeBean_316560a8 extends EJSHome {
	/**
	 * EJSCMPTaskHomeBean_316560a8
	 */
	public EJSCMPTaskHomeBean_316560a8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Task postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Task) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Task create(int argTask) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Task _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.TaskBean bean = (com.hps.july.persistence.TaskBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTask);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argTask);
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
	public com.hps.july.persistence.Task create(int argTask, java.lang.String argName, java.lang.String ctx) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Task _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.TaskBean bean = (com.hps.july.persistence.TaskBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTask, argName, ctx);
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
	public com.hps.july.persistence.Task findByPrimaryKey(com.hps.july.persistence.TaskKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPTaskBean_316560a8) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.TaskBean tmpEJB = (com.hps.july.persistence.TaskBean) generalEJB;
		com.hps.july.persistence.TaskKey keyClass = new com.hps.july.persistence.TaskKey();
		keyClass.task = tmpEJB.task;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.TaskKey keyFromFields(int f0) {
		com.hps.july.persistence.TaskKey keyClass = new com.hps.july.persistence.TaskKey();
		keyClass.task = f0;
		return keyClass;
	}
}
