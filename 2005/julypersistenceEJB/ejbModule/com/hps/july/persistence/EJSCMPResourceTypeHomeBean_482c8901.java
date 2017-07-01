package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceTypeHomeBean_482c8901
 */
public class EJSCMPResourceTypeHomeBean_482c8901 extends EJSHome {
	/**
	 * EJSCMPResourceTypeHomeBean_482c8901
	 */
	public EJSCMPResourceTypeHomeBean_482c8901() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ResourceType create(int argResourcetype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceTypeBean bean = (com.hps.july.persistence.ResourceTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResourcetype);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResourcetype);
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
	public com.hps.july.persistence.ResourceType create(int argResourcetype, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceTypeBean bean = (com.hps.july.persistence.ResourceTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResourcetype, argName);
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
	 * findAll
	 */
	public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceTypeBean)persister).findAll());	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ResourceType findByPrimaryKey(com.hps.july.persistence.ResourceTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPResourceTypeBean_482c8901) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ResourceTypeBean tmpEJB = (com.hps.july.persistence.ResourceTypeBean) generalEJB;
		com.hps.july.persistence.ResourceTypeKey keyClass = new com.hps.july.persistence.ResourceTypeKey();
		keyClass.resourcetype = tmpEJB.resourcetype;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceTypeKey keyClass = new com.hps.july.persistence.ResourceTypeKey();
		keyClass.resourcetype = f0;
		return keyClass;
	}
}
