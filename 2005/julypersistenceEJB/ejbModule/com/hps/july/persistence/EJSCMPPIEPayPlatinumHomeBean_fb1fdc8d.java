package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d
 */
public class EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d extends EJSHome {
	/**
	 * EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d
	 */
	public EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPayPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPayPlatinum) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEPayPlatinum create(java.lang.String argIdpayplatinum, int argIdDogovorNri, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, java.lang.String argFlagWorkNri, java.lang.String argPurpose, int argPayStatePlatinum, java.lang.String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEPayPlatinum _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEPayPlatinumBean bean = (com.hps.july.persistence.PIEPayPlatinumBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdpayplatinum, argIdDogovorNri, argSumm, argSummNds, argValute, argSummRub, argSummNdsRub, argDate, argFlagWorkNri, argPurpose, argPayStatePlatinum, argDocNumber);
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
	public com.hps.july.persistence.PIEPayPlatinum create(java.lang.String argIdpayplatinum, int argOwner, int argIdDogovorNri, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, java.lang.String argFlagWorkNri, java.lang.String argPurpose, int argPayStatePlatinum, java.lang.String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEPayPlatinum _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEPayPlatinumBean bean = (com.hps.july.persistence.PIEPayPlatinumBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdpayplatinum, argOwner, argIdDogovorNri, argSumm, argSummNds, argValute, argSummRub, argSummNdsRub, argDate, argFlagWorkNri, argPurpose, argPayStatePlatinum, argDocNumber);
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
	public com.hps.july.persistence.PIEPayPlatinum findByPrimaryKey(com.hps.july.persistence.PIEPayPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEPayPlatinumBean_fb1fdc8d) persister).findByPrimaryKey(key);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isDateStart, java.sql.Date argDateStart, java.lang.Boolean isDateEnd, java.sql.Date argDateEnd, java.lang.Boolean isIdDogovNri, java.lang.Integer argIdDogovNri, java.lang.Boolean isFlagWorkNri, java.lang.String argFlagWorkNri, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEPayPlatinumBean)persister).findByQBE(isDateStart, argDateStart, isDateEnd, argDateEnd, isIdDogovNri, argIdDogovNri, isFlagWorkNri, argFlagWorkNri, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEPayPlatinumBean tmpEJB = (com.hps.july.persistence.PIEPayPlatinumBean) generalEJB;
		com.hps.july.persistence.PIEPayPlatinumKey keyClass = new com.hps.july.persistence.PIEPayPlatinumKey();
		keyClass.owner = tmpEJB.owner;
		keyClass.idpayplatinum = tmpEJB.idpayplatinum;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEPayPlatinumKey keyFromFields(int f0, java.lang.String f1) {
		com.hps.july.persistence.PIEPayPlatinumKey keyClass = new com.hps.july.persistence.PIEPayPlatinumKey();
		keyClass.owner = f0;
		keyClass.idpayplatinum = f1;
		return keyClass;
	}
}
