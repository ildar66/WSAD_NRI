package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEPayLinkHomeBean_415658e8
 */
public class EJSCMPPIEPayLinkHomeBean_415658e8 extends EJSHome {
	/**
	 * EJSCMPPIEPayLinkHomeBean_415658e8
	 */
	public EJSCMPPIEPayLinkHomeBean_415658e8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPayLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPayLink) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEPayLink create(java.lang.String argIdPayPlatinum, int argDocposition, java.lang.String argFlagMain) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEPayLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEPayLinkBean bean = (com.hps.july.persistence.PIEPayLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdPayPlatinum, argDocposition, argFlagMain);
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
	public com.hps.july.persistence.PIEPayLink findByPrimaryKey(com.hps.july.persistence.PIEPayLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEPayLinkBean_415658e8) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEPayLink create(java.lang.String argIdPayPlatinum, int argOwner, int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEPayLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEPayLinkBean bean = (com.hps.july.persistence.PIEPayLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdPayPlatinum, argOwner, argDocposition);
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
	 * findPIEPayLinksByPiepayplatinum
	 */
	public java.util.Enumeration findPIEPayLinksByPiepayplatinum(com.hps.july.persistence.PIEPayPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEPayLinkBean)persister).findPIEPayLinksByPiepayplatinum(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEPayLinkBean tmpEJB = (com.hps.july.persistence.PIEPayLinkBean) generalEJB;
		com.hps.july.persistence.PIEPayLinkKey keyClass = new com.hps.july.persistence.PIEPayLinkKey();
		keyClass.docposition = tmpEJB.docposition;
		keyClass.piepayplatinum_idpayplatinum = tmpEJB.piepayplatinum_idpayplatinum;
		keyClass.piepayplatinum_owner = tmpEJB.piepayplatinum_owner;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEPayLinkKey keyFromFields(int f0, java.lang.String f1, java.lang.Integer f2) {
		com.hps.july.persistence.PIEPayLinkKey keyClass = new com.hps.july.persistence.PIEPayLinkKey();
		keyClass.docposition = f0;
		keyClass.piepayplatinum_idpayplatinum = f1;
		keyClass.piepayplatinum_owner = f2;
		return keyClass;
	}
}
