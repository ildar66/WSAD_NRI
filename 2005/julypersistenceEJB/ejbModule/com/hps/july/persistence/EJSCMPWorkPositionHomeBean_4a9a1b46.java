package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPWorkPositionHomeBean_4a9a1b46
 */
public class EJSCMPWorkPositionHomeBean_4a9a1b46 extends EJSHome {
	/**
	 * EJSCMPWorkPositionHomeBean_4a9a1b46
	 */
	public EJSCMPWorkPositionHomeBean_4a9a1b46() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.WorkPosition postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.WorkPosition) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.WorkPosition create(int argWorkposition, java.lang.Boolean argIsactive) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.WorkPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.WorkPositionBean bean = (com.hps.july.persistence.WorkPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argWorkposition, argIsactive);
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
	public com.hps.july.persistence.WorkPosition findByPrimaryKey(com.hps.july.persistence.WorkPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPWorkPositionBean_4a9a1b46) persister).findByPrimaryKey(key);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkPositionBean)persister).findByQBE(isIsActive, isActive, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.WorkPosition create(int argWorkposition, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.WorkPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.WorkPositionBean bean = (com.hps.july.persistence.WorkPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argWorkposition, argName);
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
	public com.hps.july.persistence.WorkPosition create(int argWorkposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.WorkPosition _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.WorkPositionBean bean = (com.hps.july.persistence.WorkPositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argWorkposition);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argWorkposition);
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
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkPositionBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.WorkPositionBean tmpEJB = (com.hps.july.persistence.WorkPositionBean) generalEJB;
		com.hps.july.persistence.WorkPositionKey keyClass = new com.hps.july.persistence.WorkPositionKey();
		keyClass.workposition = tmpEJB.workposition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.WorkPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.WorkPositionKey keyClass = new com.hps.july.persistence.WorkPositionKey();
		keyClass.workposition = f0;
		return keyClass;
	}
}
