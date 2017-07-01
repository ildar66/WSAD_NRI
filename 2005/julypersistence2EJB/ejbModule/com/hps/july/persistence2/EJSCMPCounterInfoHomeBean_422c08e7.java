package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCounterInfoHomeBean_422c08e7
 */
public class EJSCMPCounterInfoHomeBean_422c08e7 extends EJSHome {
	/**
	 * EJSCMPCounterInfoHomeBean_422c08e7
	 */
	public EJSCMPCounterInfoHomeBean_422c08e7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.CounterInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.CounterInfo) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.CounterInfo create(int argId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.CounterInfo _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.CounterInfoBean bean = (com.hps.july.persistence2.CounterInfoBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argId);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argId);
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
	public com.hps.july.persistence2.CounterInfo findByPrimaryKey(com.hps.july.persistence2.CounterInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPCounterInfoBean_422c08e7) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.CounterInfoBean tmpEJB = (com.hps.july.persistence2.CounterInfoBean) generalEJB;
		com.hps.july.persistence2.CounterInfoKey keyClass = new com.hps.july.persistence2.CounterInfoKey();
		keyClass.id = tmpEJB.id;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.CounterInfoKey keyFromFields(int f0) {
		com.hps.july.persistence2.CounterInfoKey keyClass = new com.hps.july.persistence2.CounterInfoKey();
		keyClass.id = f0;
		return keyClass;
	}
}
