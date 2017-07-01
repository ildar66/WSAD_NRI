package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOfficeMemoTargetHomeBean_d1f1d09e
 */
public class EJSCMPOfficeMemoTargetHomeBean_d1f1d09e extends EJSHome {
	/**
	 * EJSCMPOfficeMemoTargetHomeBean_d1f1d09e
	 */
	public EJSCMPOfficeMemoTargetHomeBean_d1f1d09e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.OfficeMemoTarget postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.OfficeMemoTarget) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.OfficeMemoTarget create(int argIdtarget, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.OfficeMemoTarget _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.OfficeMemoTargetBean bean = (com.hps.july.persistence2.OfficeMemoTargetBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdtarget, argName);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence2.OfficeMemoTarget findByPrimaryKey(com.hps.july.persistence2.OfficeMemoTargetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPOfficeMemoTargetBean_d1f1d09e) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.OfficeMemoTargetBean tmpEJB = (com.hps.july.persistence2.OfficeMemoTargetBean) generalEJB;
		com.hps.july.persistence2.OfficeMemoTargetKey keyClass = new com.hps.july.persistence2.OfficeMemoTargetKey();
		keyClass.idtarget = tmpEJB.idtarget;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.OfficeMemoTargetKey keyFromFields(int f0) {
		com.hps.july.persistence2.OfficeMemoTargetKey keyClass = new com.hps.july.persistence2.OfficeMemoTargetKey();
		keyClass.idtarget = f0;
		return keyClass;
	}
}
