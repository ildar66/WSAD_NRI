package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectActionHomeBean_8e9b9227
 */
public class EJSCMPProjectActionHomeBean_8e9b9227 extends EJSHome {
	/**
	 * EJSCMPProjectActionHomeBean_8e9b9227
	 */
	public EJSCMPProjectActionHomeBean_8e9b9227() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectAction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectAction) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByProjectAndOrder
	 */
	public java.util.Enumeration findByProjectAndOrder(java.lang.Integer Project, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionBean)persister).findByProjectAndOrder(Project, order));	}
	/**
	 * findProjectActionsByProjectactiontype
	 */
	public java.util.Enumeration findProjectActionsByProjectactiontype(com.hps.july.persistence.ProjectActionTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionBean)persister).findProjectActionsByProjectactiontype(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectAction findByPrimaryKey(com.hps.july.persistence.ProjectActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectActionBean_8e9b9227) persister).findByPrimaryKey(key);
	}
	/**
	 * findProjectActionsByProject
	 */
	public java.util.Enumeration findProjectActionsByProject(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionBean)persister).findProjectActionsByProject(inKey));	}
	/**
	 * findProjectActionsByEquipment
	 */
	public java.util.Enumeration findProjectActionsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionBean)persister).findProjectActionsByEquipment(inKey));	}
	/**
	 * findByProjectOrderByOrderAsc
	 */
	public java.util.Enumeration findByProjectOrderByOrderAsc(java.lang.Integer project) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionBean)persister).findByProjectOrderByOrderAsc(project));	}
	/**
	 * findByProjectAndProjectActionType
	 */
	public java.util.Enumeration findByProjectAndProjectActionType(java.lang.Integer project, java.lang.Integer projectActionType) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionBean)persister).findByProjectAndProjectActionType(project, projectActionType));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ProjectAction create(int argProjectaction, int argProject, int argProjectactiontype, int argOrder, boolean argHasproblems) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectAction _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectActionBean bean = (com.hps.july.persistence.ProjectActionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjectaction, argProject, argProjectactiontype, argOrder, argHasproblems);
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
		com.hps.july.persistence.ProjectActionBean tmpEJB = (com.hps.july.persistence.ProjectActionBean) generalEJB;
		com.hps.july.persistence.ProjectActionKey keyClass = new com.hps.july.persistence.ProjectActionKey();
		keyClass.projectaction = tmpEJB.projectaction;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectActionKey keyFromFields(int f0) {
		com.hps.july.persistence.ProjectActionKey keyClass = new com.hps.july.persistence.ProjectActionKey();
		keyClass.projectaction = f0;
		return keyClass;
	}
}
