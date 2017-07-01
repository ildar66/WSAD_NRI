package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRoleHomeBean_745b5a02
 */
public class EJSCMPRoleHomeBean_745b5a02 extends EJSHome {
	/**
	 * EJSCMPRoleHomeBean_745b5a02
	 */
	public EJSCMPRoleHomeBean_745b5a02() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Role postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Role) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Role create(java.lang.String argRole, java.lang.String argRoleName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Role _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RoleBean bean = (com.hps.july.persistence.RoleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRole, argRoleName);
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
	public com.hps.july.persistence.Role findByPrimaryKey(com.hps.july.persistence.RoleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRoleBean_745b5a02) persister).findByPrimaryKey(key);
	}
	/**
	 * findAll
	 */
	public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRoleBean)persister).findAll());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Role create(java.lang.String argRole) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Role _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RoleBean bean = (com.hps.july.persistence.RoleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRole);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argRole);
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
		com.hps.july.persistence.RoleBean tmpEJB = (com.hps.july.persistence.RoleBean) generalEJB;
		com.hps.july.persistence.RoleKey keyClass = new com.hps.july.persistence.RoleKey();
		keyClass.role = tmpEJB.role;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.RoleKey keyFromFields(java.lang.String f0) {
		com.hps.july.persistence.RoleKey keyClass = new com.hps.july.persistence.RoleKey();
		keyClass.role = f0;
		return keyClass;
	}
}
