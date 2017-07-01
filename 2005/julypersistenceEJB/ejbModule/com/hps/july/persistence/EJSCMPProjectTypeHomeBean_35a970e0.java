package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectTypeHomeBean_35a970e0
 */
public class EJSCMPProjectTypeHomeBean_35a970e0 extends EJSHome {
	/**
	 * EJSCMPProjectTypeHomeBean_35a970e0
	 */
	public EJSCMPProjectTypeHomeBean_35a970e0() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ProjectType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ProjectType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ProjectType create(int argProjecttype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectTypeBean bean = (com.hps.july.persistence.ProjectTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjecttype);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argProjecttype);
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
	public com.hps.july.persistence.ProjectType create(int argProjecttype, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ProjectType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ProjectTypeBean bean = (com.hps.july.persistence.ProjectTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argProjecttype, argName);
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
	 * findAllOrderByCodeAsc
	 */
	public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderProjectTypeBean)persister).findAllOrderByCodeAsc());	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ProjectType findByPrimaryKey(com.hps.july.persistence.ProjectTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPProjectTypeBean_35a970e0) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ProjectTypeBean tmpEJB = (com.hps.july.persistence.ProjectTypeBean) generalEJB;
		com.hps.july.persistence.ProjectTypeKey keyClass = new com.hps.july.persistence.ProjectTypeKey();
		keyClass.projecttype = tmpEJB.projecttype;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ProjectTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.ProjectTypeKey keyClass = new com.hps.july.persistence.ProjectTypeKey();
		keyClass.projecttype = f0;
		return keyClass;
	}
}
