package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceSubTypeHomeBean_fc97d1dd
 */
public class EJSCMPResourceSubTypeHomeBean_fc97d1dd extends EJSHome {
	/**
	 * EJSCMPResourceSubTypeHomeBean_fc97d1dd
	 */
	public EJSCMPResourceSubTypeHomeBean_fc97d1dd() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceSubType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceSubType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ResourceSubType create(int argResourcesubtype, java.lang.String argName, java.lang.Integer argResourceType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceSubType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceSubTypeBean bean = (com.hps.july.persistence.ResourceSubTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResourcesubtype, argName, argResourceType);
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
	public com.hps.july.persistence.ResourceSubType create(int argResourcesubtype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceSubType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceSubTypeBean bean = (com.hps.july.persistence.ResourceSubTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResourcesubtype);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResourcesubtype);
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
	public com.hps.july.persistence.ResourceSubType findByPrimaryKey(com.hps.july.persistence.ResourceSubTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPResourceSubTypeBean_fc97d1dd) persister).findByPrimaryKey(key);
	}
	/**
	 * findResourceSubTypeByResourcetype
	 */
	public java.util.Enumeration findResourceSubTypeByResourcetype(com.hps.july.persistence.ResourceTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceSubTypeBean)persister).findResourceSubTypeByResourcetype(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ResourceSubTypeBean tmpEJB = (com.hps.july.persistence.ResourceSubTypeBean) generalEJB;
		com.hps.july.persistence.ResourceSubTypeKey keyClass = new com.hps.july.persistence.ResourceSubTypeKey();
		keyClass.resourcesubtype = tmpEJB.resourcesubtype;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceSubTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceSubTypeKey keyClass = new com.hps.july.persistence.ResourceSubTypeKey();
		keyClass.resourcesubtype = f0;
		return keyClass;
	}
}
