package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCountryHomeBean_26349d7e
 */
public class EJSCMPCountryHomeBean_26349d7e extends EJSHome {
	/**
	 * EJSCMPCountryHomeBean_26349d7e
	 */
	public EJSCMPCountryHomeBean_26349d7e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Country postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Country) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.Country create(int argCountry, java.lang.String argName, java.math.BigDecimal argCCode) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Country _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.CountryBean bean = (com.hps.july.persistence2.CountryBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argCountry, argName, argCCode);
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
	public com.hps.july.persistence2.Country findByPrimaryKey(com.hps.july.persistence2.CountryKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPCountryBean_26349d7e) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.CountryBean tmpEJB = (com.hps.july.persistence2.CountryBean) generalEJB;
		com.hps.july.persistence2.CountryKey keyClass = new com.hps.july.persistence2.CountryKey();
		keyClass.country = tmpEJB.country;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.CountryKey keyFromFields(int f0) {
		com.hps.july.persistence2.CountryKey keyClass = new com.hps.july.persistence2.CountryKey();
		keyClass.country = f0;
		return keyClass;
	}
}
