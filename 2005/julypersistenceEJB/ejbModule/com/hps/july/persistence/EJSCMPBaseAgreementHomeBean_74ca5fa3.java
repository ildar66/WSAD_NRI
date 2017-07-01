package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBaseAgreementHomeBean_74ca5fa3
 */
public class EJSCMPBaseAgreementHomeBean_74ca5fa3 extends EJSHome {
	/**
	 * EJSCMPBaseAgreementHomeBean_74ca5fa3
	 */
	public EJSCMPBaseAgreementHomeBean_74ca5fa3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.BaseAgreement postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.BaseAgreement) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.BaseAgreement findByPrimaryKey(com.hps.july.persistence.BaseAgreementKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPBaseAgreementBean_74ca5fa3) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.BaseAgreement create(int argBaseagreement, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.BaseAgreement _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.BaseAgreementBean bean = (com.hps.july.persistence.BaseAgreementBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argBaseagreement, argName);
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
	 * findAllOrderByNameDesc
	 */
	public java.util.Enumeration findAllOrderByNameDesc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderBaseAgreementBean)persister).findAllOrderByNameDesc());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.BaseAgreement create(int argBaseagreement) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.BaseAgreement _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.BaseAgreementBean bean = (com.hps.july.persistence.BaseAgreementBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argBaseagreement);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argBaseagreement);
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
return super.getEnumeration(((com.hps.july.persistence.EJSFinderBaseAgreementBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.BaseAgreementBean tmpEJB = (com.hps.july.persistence.BaseAgreementBean) generalEJB;
		com.hps.july.persistence.BaseAgreementKey keyClass = new com.hps.july.persistence.BaseAgreementKey();
		keyClass.baseagreement = tmpEJB.baseagreement;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.BaseAgreementKey keyFromFields(int f0) {
		com.hps.july.persistence.BaseAgreementKey keyClass = new com.hps.july.persistence.BaseAgreementKey();
		keyClass.baseagreement = f0;
		return keyClass;
	}
}
