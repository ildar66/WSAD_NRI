package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPUserRequestsHomeBean_1c968d68
 */
public class EJSCMPUserRequestsHomeBean_1c968d68 extends EJSHome {
	/**
	 * EJSCMPUserRequestsHomeBean_1c968d68
	 */
	public EJSCMPUserRequestsHomeBean_1c968d68() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.UserRequests postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.UserRequests) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.UserRequests findByPrimaryKey(com.hps.july.persistence2.UserRequestsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPUserRequestsBean_1c968d68) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.UserRequests create(int argRequest, java.sql.Date argDatetimein, int argRequesttype, int argFilialtype, int argWorker, int argModule, java.lang.String argDescr, java.lang.String argStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.UserRequests _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.UserRequestsBean bean = (com.hps.july.persistence2.UserRequestsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRequest, argDatetimein, argRequesttype, argFilialtype, argWorker, argModule, argDescr, argStatus);
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
		com.hps.july.persistence2.UserRequestsBean tmpEJB = (com.hps.july.persistence2.UserRequestsBean) generalEJB;
		com.hps.july.persistence2.UserRequestsKey keyClass = new com.hps.july.persistence2.UserRequestsKey();
		keyClass.request = tmpEJB.request;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.UserRequestsKey keyFromFields(int f0) {
		com.hps.july.persistence2.UserRequestsKey keyClass = new com.hps.july.persistence2.UserRequestsKey();
		keyClass.request = f0;
		return keyClass;
	}
}
