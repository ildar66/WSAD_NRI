package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOfficeMemoHeaderHomeBean_7991c071
 */
public class EJSCMPOfficeMemoHeaderHomeBean_7991c071 extends EJSHome {
	/**
	 * EJSCMPOfficeMemoHeaderHomeBean_7991c071
	 */
	public EJSCMPOfficeMemoHeaderHomeBean_7991c071() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OfficeMemoHeader postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OfficeMemoHeader) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.OfficeMemoHeader findByPrimaryKey(com.hps.july.persistence2.OfficeMemoHeaderKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPOfficeMemoHeaderBean_7991c071) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.OfficeMemoHeader create(int argIdheader, int argAbonentContract, java.lang.String argNumber, java.sql.Date argDate, int argMan, java.lang.String argType, int argTarget) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.OfficeMemoHeader _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.OfficeMemoHeaderBean bean = (com.hps.july.persistence2.OfficeMemoHeaderBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdheader, argAbonentContract, argNumber, argDate, argMan, argType, argTarget);
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
		com.hps.july.persistence2.OfficeMemoHeaderBean tmpEJB = (com.hps.july.persistence2.OfficeMemoHeaderBean) generalEJB;
		com.hps.july.persistence2.OfficeMemoHeaderKey keyClass = new com.hps.july.persistence2.OfficeMemoHeaderKey();
		keyClass.idheader = tmpEJB.idheader;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.OfficeMemoHeaderKey keyFromFields(int f0) {
		com.hps.july.persistence2.OfficeMemoHeaderKey keyClass = new com.hps.july.persistence2.OfficeMemoHeaderKey();
		keyClass.idheader = f0;
		return keyClass;
	}
}
