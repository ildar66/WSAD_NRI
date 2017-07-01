package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRateHomeBean_317b6ef3
 */
public class EJSCMPRateHomeBean_317b6ef3 extends EJSHome {
	/**
	 * EJSCMPRateHomeBean_317b6ef3
	 */
	public EJSCMPRateHomeBean_317b6ef3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Rate postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Rate) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByTypeDate
	 */
	public java.util.Enumeration findByTypeDate(java.lang.Integer type, java.sql.Date date) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRateBean)persister).findByTypeDate(type, date));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Rate create(com.hps.july.persistence.CurrencyKey argCurrency, com.hps.july.persistence.RateTypeKey argType, java.sql.Date argDate, java.math.BigDecimal argValue) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Rate _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RateBean bean = (com.hps.july.persistence.RateBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCurrency, argType, argDate, argValue);
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
	 * findRateByType
	 */
	public java.util.Enumeration findRateByType(com.hps.july.persistence.RateTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRateBean)persister).findRateByType(inKey));	}
	/**
	 * findByTypeAndCurrencyOrderByDateDesc
	 */
	public java.util.Enumeration findByTypeAndCurrencyOrderByDateDesc(java.lang.Integer argType, java.lang.Integer argCurrency) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRateBean)persister).findByTypeAndCurrencyOrderByDateDesc(argType, argCurrency));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Rate create(java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Rate _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RateBean bean = (com.hps.july.persistence.RateBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDate);
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
	 * findRatesByCurrency
	 */
	public java.util.Enumeration findRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRateBean)persister).findRatesByCurrency(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Rate findByPrimaryKey(com.hps.july.persistence.RateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRateBean_317b6ef3) persister).findByPrimaryKey(key);
	}
	/**
	 * findByTypeCurrencyForDate
	 */
	public com.hps.july.persistence.Rate findByTypeCurrencyForDate(java.lang.Integer type, java.lang.Integer currency, java.sql.Date date) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPRateBean_317b6ef3)persister).findByTypeCurrencyForDate(type, currency, date);	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.RateBean tmpEJB = (com.hps.july.persistence.RateBean) generalEJB;
		com.hps.july.persistence.RateKey keyClass = new com.hps.july.persistence.RateKey();
		keyClass.date = tmpEJB.date;
		keyClass.type_ratetype = tmpEJB.type_ratetype;
		keyClass.currency_currency = tmpEJB.currency_currency;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.RateKey keyFromFields(java.sql.Date f0, java.lang.Integer f1, java.lang.Integer f2) {
		com.hps.july.persistence.RateKey keyClass = new com.hps.july.persistence.RateKey();
		keyClass.date = f0;
		keyClass.type_ratetype = f1;
		keyClass.currency_currency = f2;
		return keyClass;
	}
}
