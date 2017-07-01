package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCounterHomeBean_b1595563
 */
public class EJSCMPCounterHomeBean_b1595563 extends EJSHome {
	/**
	 * EJSCMPCounterHomeBean_b1595563
	 */
	public EJSCMPCounterHomeBean_b1595563() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Counter postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Counter) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.Counter findByPrimaryKey(com.hps.july.persistence2.CounterKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPCounterBean_b1595563) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.Counter create(int argCounterid, int argCounterInfoId, int argPositionId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Counter _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.CounterBean bean = (com.hps.july.persistence2.CounterBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCounterid, argCounterInfoId, argPositionId);
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
		com.hps.july.persistence2.CounterBean tmpEJB = (com.hps.july.persistence2.CounterBean) generalEJB;
		com.hps.july.persistence2.CounterKey keyClass = new com.hps.july.persistence2.CounterKey();
		keyClass.counterid = tmpEJB.counterid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.CounterKey keyFromFields(int f0) {
		com.hps.july.persistence2.CounterKey keyClass = new com.hps.july.persistence2.CounterKey();
		keyClass.counterid = f0;
		return keyClass;
	}
}
