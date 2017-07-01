package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSurplusActHomeBean_ae43edd4
 */
public class EJSCMPSurplusActHomeBean_ae43edd4 extends EJSHome {
	/**
	 * EJSCMPSurplusActHomeBean_ae43edd4
	 */
	public EJSCMPSurplusActHomeBean_ae43edd4() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SurplusAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SurplusAct) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.SurplusAct create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SurplusAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SurplusActBean bean = (com.hps.july.persistence.SurplusActBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocument);
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
	public com.hps.july.persistence.SurplusAct findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSurplusActBean_ae43edd4) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SurplusAct create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SurplusAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SurplusActBean bean = (com.hps.july.persistence.SurplusActBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argBlankDate, argBlankindex, argState);
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
	public com.hps.july.persistence.SurplusAct create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SurplusAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SurplusActBean bean = (com.hps.july.persistence.SurplusActBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination);
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
		com.hps.july.persistence.SurplusActBean tmpEJB = (com.hps.july.persistence.SurplusActBean) generalEJB;
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = tmpEJB.document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = f0;
		return keyClass;
	}
}
