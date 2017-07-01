package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRoles2TasksHomeBean_76e15e86
 */
public class EJSCMPRoles2TasksHomeBean_76e15e86 extends EJSHome {
	/**
	 * EJSCMPRoles2TasksHomeBean_76e15e86
	 */
	public EJSCMPRoles2TasksHomeBean_76e15e86() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Roles2Tasks postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Roles2Tasks) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findRoles2TasksByRoleString
	 */
	public java.util.Enumeration findRoles2TasksByRoleString(java.lang.String role) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRoles2TasksBean)persister).findRoles2TasksByRoleString(role));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Roles2Tasks create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Roles2Tasks _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.Roles2TasksBean bean = (com.hps.july.persistence.Roles2TasksBean) beanO.getEnterpriseBean();
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
	 * findTasksByRole
	 */
	public java.util.Enumeration findTasksByRole(com.hps.july.persistence.RoleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRoles2TasksBean)persister).findTasksByRole(inKey));	}
	/**
	 * findRoleByTask
	 */
	public java.util.Enumeration findRoleByTask(com.hps.july.persistence.TaskKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRoles2TasksBean)persister).findRoleByTask(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Roles2Tasks findByPrimaryKey(com.hps.july.persistence.Roles2TasksKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRoles2TasksBean_76e15e86) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Roles2Tasks create(java.lang.String argRole, java.lang.Integer argTask) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Roles2Tasks _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.Roles2TasksBean bean = (com.hps.july.persistence.Roles2TasksBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRole, argTask);
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
		com.hps.july.persistence.Roles2TasksBean tmpEJB = (com.hps.july.persistence.Roles2TasksBean) generalEJB;
		com.hps.july.persistence.Roles2TasksKey keyClass = new com.hps.july.persistence.Roles2TasksKey();
		keyClass.task_task = tmpEJB.task_task;
		keyClass.role_role = tmpEJB.role_role;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.Roles2TasksKey keyFromFields(java.lang.Integer f0, java.lang.String f1) {
		com.hps.july.persistence.Roles2TasksKey keyClass = new com.hps.july.persistence.Roles2TasksKey();
		keyClass.task_task = f0;
		keyClass.role_role = f1;
		return keyClass;
	}
}
