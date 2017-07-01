package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResponsibilityTypeHomeBean_d47ca10c
 */
public class EJSCMPResponsibilityTypeHomeBean_d47ca10c extends EJSHome {
	/**
	 * EJSCMPResponsibilityTypeHomeBean_d47ca10c
	 */
	public EJSCMPResponsibilityTypeHomeBean_d47ca10c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResponsibilityType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResponsibilityType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ResponsibilityType create(int argResponsibilityType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResponsibilityType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResponsibilityTypeBean bean = (com.hps.july.persistence.ResponsibilityTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResponsibilityType);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResponsibilityType);
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
	public com.hps.july.persistence.ResponsibilityType create(int argResponsibilityType, java.lang.String argName, java.lang.Boolean argIsPrint) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResponsibilityType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResponsibilityTypeBean bean = (com.hps.july.persistence.ResponsibilityTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResponsibilityType, argName, argIsPrint);
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
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResponsibilityTypeBean)persister).findAllOrderByCodeAsc());	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ResponsibilityType findByPrimaryKey(com.hps.july.persistence.ResponsibilityTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPResponsibilityTypeBean_d47ca10c) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ResponsibilityTypeBean tmpEJB = (com.hps.july.persistence.ResponsibilityTypeBean) generalEJB;
		com.hps.july.persistence.ResponsibilityTypeKey keyClass = new com.hps.july.persistence.ResponsibilityTypeKey();
		keyClass.responsibilityType = tmpEJB.responsibilityType;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResponsibilityTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.ResponsibilityTypeKey keyClass = new com.hps.july.persistence.ResponsibilityTypeKey();
		keyClass.responsibilityType = f0;
		return keyClass;
	}
}
