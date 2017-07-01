package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOperators2RolesHomeBean_a0bb30ab
 */
public class EJSCMPOperators2RolesHomeBean_a0bb30ab extends EJSHome {
	/**
	 * EJSCMPOperators2RolesHomeBean_a0bb30ab
	 */
	public EJSCMPOperators2RolesHomeBean_a0bb30ab() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Operators2Roles postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Operators2Roles) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Operators2Roles findByPrimaryKey(com.hps.july.persistence.Operators2RolesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPOperators2RolesBean_a0bb30ab) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Operators2Roles create(java.lang.Integer argOperator, java.lang.String argRole) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Operators2Roles _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.Operators2RolesBean bean = (com.hps.july.persistence.Operators2RolesBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOperator, argRole);
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
	 * findOperators2RolesByRole
	 */
	public java.util.Enumeration findOperators2RolesByRole(com.hps.july.persistence.RoleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOperators2RolesBean)persister).findOperators2RolesByRole(inKey));	}
	/**
	 * findOperators2RolesByOperator
	 */
	public java.util.Enumeration findOperators2RolesByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOperators2RolesBean)persister).findOperators2RolesByOperator(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Operators2Roles create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Operators2Roles _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.Operators2RolesBean bean = (com.hps.july.persistence.Operators2RolesBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
		com.hps.july.persistence.Operators2RolesBean tmpEJB = (com.hps.july.persistence.Operators2RolesBean) generalEJB;
		com.hps.july.persistence.Operators2RolesKey keyClass = new com.hps.july.persistence.Operators2RolesKey();
		keyClass.operator_operator = tmpEJB.operator_operator;
		keyClass.role_role = tmpEJB.role_role;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.Operators2RolesKey keyFromFields(java.lang.Integer f0, java.lang.String f1) {
		com.hps.july.persistence.Operators2RolesKey keyClass = new com.hps.july.persistence.Operators2RolesKey();
		keyClass.operator_operator = f0;
		keyClass.role_role = f1;
		return keyClass;
	}
}
