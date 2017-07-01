package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCurrencyHomeBean_bce2196f
 */
public class EJSCMPCurrencyHomeBean_bce2196f extends EJSHome {
	/**
	 * EJSCMPCurrencyHomeBean_bce2196f
	 */
	public EJSCMPCurrencyHomeBean_bce2196f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Currency postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Currency) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Currency create(int argCurrency, java.lang.String argName, java.lang.String argShortName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Currency _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CurrencyBean bean = (com.hps.july.persistence.CurrencyBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCurrency, argName, argShortName);
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
	public com.hps.july.persistence.Currency findByPrimaryKey(com.hps.july.persistence.CurrencyKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPCurrencyBean_bce2196f) persister).findByPrimaryKey(key);
	}
	/**
	 * findByConnectedOrderByNameAsc
	 */
	public java.util.Enumeration findByConnectedOrderByNameAsc(java.lang.Integer argConnected) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCurrencyBean)persister).findByConnectedOrderByNameAsc(argConnected));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Currency create(int argCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Currency _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CurrencyBean bean = (com.hps.july.persistence.CurrencyBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCurrency);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argCurrency);
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
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCurrencyBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.CurrencyBean tmpEJB = (com.hps.july.persistence.CurrencyBean) generalEJB;
		com.hps.july.persistence.CurrencyKey keyClass = new com.hps.july.persistence.CurrencyKey();
		keyClass.currency = tmpEJB.currency;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.CurrencyKey keyFromFields(int f0) {
		com.hps.july.persistence.CurrencyKey keyClass = new com.hps.july.persistence.CurrencyKey();
		keyClass.currency = f0;
		return keyClass;
	}
}
