package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectActionTypeHomeBean_c8c0ae31
 */
public class EJSCMPProjectActionTypeHomeBean_c8c0ae31 extends EJSHome {
	/**
	 * EJSCMPProjectActionTypeHomeBean_c8c0ae31
	 */
	public EJSCMPProjectActionTypeHomeBean_c8c0ae31() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectActionType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectActionType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ProjectActionType findByPrimaryKey(com.hps.july.persistence.ProjectActionTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectActionTypeBean_c8c0ae31) persister).findByPrimaryKey(key);
	}
	/**
	 * findProjectActionTypesByResponsibilitytype
	 */
	public java.util.Enumeration findProjectActionTypesByResponsibilitytype(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionTypeBean)persister).findProjectActionTypesByResponsibilitytype(inKey));	}
	/**
	 * findByProjecttypeOrderByCodeAsc
	 */
	public java.util.Enumeration findByProjecttypeOrderByCodeAsc(java.lang.Integer argProjectType, java.lang.Integer argProjectActionType) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionTypeBean)persister).findByProjecttypeOrderByCodeAsc(argProjectType, argProjectActionType));	}
	/**
	 * findProjectActionTypesByAction2division
	 */
	public java.util.Enumeration findProjectActionTypesByAction2division(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionTypeBean)persister).findProjectActionTypesByAction2division(inKey));	}
	/**
	 * findAllOrderByCodeAsc
	 */
	public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectActionTypeBean)persister).findAllOrderByCodeAsc());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ProjectActionType create(int argProjectactiontype, int argDivision, java.lang.String argName, java.lang.String argResult, java.lang.String argEquiptype, int argResponsibilitytype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectActionType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectActionTypeBean bean = (com.hps.july.persistence.ProjectActionTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjectactiontype, argDivision, argName, argResult, argEquiptype, argResponsibilitytype);
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
	public com.hps.july.persistence.ProjectActionType create(int argProjectactiontype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectActionType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectActionTypeBean bean = (com.hps.july.persistence.ProjectActionTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjectactiontype);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argProjectactiontype);
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
		com.hps.july.persistence.ProjectActionTypeBean tmpEJB = (com.hps.july.persistence.ProjectActionTypeBean) generalEJB;
		com.hps.july.persistence.ProjectActionTypeKey keyClass = new com.hps.july.persistence.ProjectActionTypeKey();
		keyClass.projectactiontype = tmpEJB.projectactiontype;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectActionTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.ProjectActionTypeKey keyClass = new com.hps.july.persistence.ProjectActionTypeKey();
		keyClass.projectactiontype = f0;
		return keyClass;
	}
}
