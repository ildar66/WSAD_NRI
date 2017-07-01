package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRateTypeHomeBean_d51efcee
 */
public class EJSCMPRateTypeHomeBean_d51efcee extends EJSHome {
	/**
	 * EJSCMPRateTypeHomeBean_d51efcee
	 */
	public EJSCMPRateTypeHomeBean_d51efcee() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RateType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RateType) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.RateType create(int argRatetype, java.lang.String argName, java.lang.Integer argBaseCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RateType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RateTypeBean bean = (com.hps.july.persistence.RateTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRatetype, argName, argBaseCurrency);
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
	public com.hps.july.persistence.RateType findByPrimaryKey(com.hps.july.persistence.RateTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRateTypeBean_d51efcee) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.RateType create(int argRatetype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RateType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RateTypeBean bean = (com.hps.july.persistence.RateTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRatetype);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argRatetype);
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
	 * findRateTypeByBasecurrency
	 */
	public java.util.Enumeration findRateTypeByBasecurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRateTypeBean)persister).findRateTypeByBasecurrency(inKey));	}
	/**
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRateTypeBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.RateTypeBean tmpEJB = (com.hps.july.persistence.RateTypeBean) generalEJB;
		com.hps.july.persistence.RateTypeKey keyClass = new com.hps.july.persistence.RateTypeKey();
		keyClass.ratetype = tmpEJB.ratetype;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.RateTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.RateTypeKey keyClass = new com.hps.july.persistence.RateTypeKey();
		keyClass.ratetype = f0;
		return keyClass;
	}
}
