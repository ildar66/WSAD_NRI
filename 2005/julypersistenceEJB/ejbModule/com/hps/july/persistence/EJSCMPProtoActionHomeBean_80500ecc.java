package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProtoActionHomeBean_80500ecc
 */
public class EJSCMPProtoActionHomeBean_80500ecc extends EJSHome {
	/**
	 * EJSCMPProtoActionHomeBean_80500ecc
	 */
	public EJSCMPProtoActionHomeBean_80500ecc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProtoAction postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProtoAction) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findProtoActionsByProjectActionType
	 */
	public java.util.Enumeration findProtoActionsByProjectActionType(com.hps.july.persistence.ProjectActionTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProtoActionBean)persister).findProtoActionsByProjectActionType(inKey));	}
	/**
	 * findStepsBeforeOrderByOrderAsc
	 */
	public java.util.Enumeration findStepsBeforeOrderByOrderAsc(java.lang.Integer argProjectType, java.lang.Integer argProjectAction) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProtoActionBean)persister).findStepsBeforeOrderByOrderAsc(argProjectType, argProjectAction));	}
	/**
	 * findProtoActionsByProjectType
	 */
	public java.util.Enumeration findProtoActionsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProtoActionBean)persister).findProtoActionsByProjectType(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProtoAction findByPrimaryKey(com.hps.july.persistence.ProtoActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProtoActionBean_80500ecc) persister).findByPrimaryKey(key);
	}
	/**
	 * findByProjectactiontypeOrderByOrderAsc
	 */
	public java.util.Enumeration findByProjectactiontypeOrderByOrderAsc(java.lang.Integer projectactiontype) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProtoActionBean)persister).findByProjectactiontypeOrderByOrderAsc(projectactiontype));	}
	/**
	 * findByProjecttypeOrderByOrderAsc
	 */
	public java.util.Enumeration findByProjecttypeOrderByOrderAsc(java.lang.Integer projecttype) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProtoActionBean)persister).findByProjecttypeOrderByOrderAsc(projecttype));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ProtoAction create(int argProjectaction, int argOrder, int argProjecttype, int argProjectactiontype, int argDuration) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProtoAction _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProtoActionBean bean = (com.hps.july.persistence.ProtoActionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjectaction, argOrder, argProjecttype, argProjectactiontype, argDuration);
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
		com.hps.july.persistence.ProtoActionBean tmpEJB = (com.hps.july.persistence.ProtoActionBean) generalEJB;
		com.hps.july.persistence.ProtoActionKey keyClass = new com.hps.july.persistence.ProtoActionKey();
		keyClass.projectaction = tmpEJB.projectaction;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProtoActionKey keyFromFields(int f0) {
		com.hps.july.persistence.ProtoActionKey keyClass = new com.hps.july.persistence.ProtoActionKey();
		keyClass.projectaction = f0;
		return keyClass;
	}
}
