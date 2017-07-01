package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEValutesHomeBean_ef13060b
 */
public class EJSCMPPIEValutesHomeBean_ef13060b extends EJSHome {
	/**
	 * EJSCMPPIEValutesHomeBean_ef13060b
	 */
	public EJSCMPPIEValutesHomeBean_ef13060b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEValutes postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEValutes) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEValutes findByPrimaryKey(com.hps.july.persistence.PIEValutesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEValutesBean_ef13060b) persister).findByPrimaryKey(key);
	}
	/**
	 * findByidvalutenriOrderByCodeAsc
	 */
	public java.util.Enumeration findByidvalutenriOrderByCodeAsc(java.lang.Integer argCurrency) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEValutesBean)persister).findByidvalutenriOrderByCodeAsc(argCurrency));	}
	/**
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEValutesBean)persister).findAllOrderByNameAsc());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEValutes create(java.lang.String argIdvaluteplatinum, java.lang.String argPStatus, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEValutes _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEValutesBean bean = (com.hps.july.persistence.PIEValutesBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdvaluteplatinum, argPStatus, argName);
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
		com.hps.july.persistence.PIEValutesBean tmpEJB = (com.hps.july.persistence.PIEValutesBean) generalEJB;
		com.hps.july.persistence.PIEValutesKey keyClass = new com.hps.july.persistence.PIEValutesKey();
		keyClass.idvaluteplatinum = tmpEJB.idvaluteplatinum;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEValutesKey keyFromFields(java.lang.String f0) {
		com.hps.july.persistence.PIEValutesKey keyClass = new com.hps.july.persistence.PIEValutesKey();
		keyClass.idvaluteplatinum = f0;
		return keyClass;
	}
}
