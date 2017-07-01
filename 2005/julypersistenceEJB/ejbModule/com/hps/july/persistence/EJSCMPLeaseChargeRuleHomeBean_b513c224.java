package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseChargeRuleHomeBean_b513c224
 */
public class EJSCMPLeaseChargeRuleHomeBean_b513c224 extends EJSHome {
	/**
	 * EJSCMPLeaseChargeRuleHomeBean_b513c224
	 */
	public EJSCMPLeaseChargeRuleHomeBean_b513c224() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseChargeRule postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseChargeRule) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeaseChargeRuleByResource
	 */
	public java.util.Enumeration findLeaseChargeRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseChargeRuleBean)persister).findLeaseChargeRuleByResource(inKey));	}
	/**
	 * findLeaseChargeRuleByCurency
	 */
	public java.util.Enumeration findLeaseChargeRuleByCurency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseChargeRuleBean)persister).findLeaseChargeRuleByCurency(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseChargeRule findByPrimaryKey(com.hps.july.persistence.LeaseRuleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseChargeRuleBean_b513c224) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseChargeRule create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseChargeRule _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseChargeRuleBean bean = (com.hps.july.persistence.LeaseChargeRuleBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
	 * findByLeaseDocumentAndResource
	 */
	public java.util.Enumeration findByLeaseDocumentAndResource(java.lang.Integer leaseDocument, java.lang.Integer argResource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseChargeRuleBean)persister).findByLeaseDocumentAndResource(leaseDocument, argResource, order));	}
	/**
	 * findByLeaseDocument
	 */
	public java.util.Enumeration findByLeaseDocument(java.lang.Integer leaseDocument, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseChargeRuleBean)persister).findByLeaseDocument(leaseDocument, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseChargeRule create(java.lang.Integer argLeaseRule, java.lang.Integer argLeaseDocument, java.lang.Integer argResource, java.lang.Integer argCurrency, java.math.BigDecimal argSum, java.lang.String argChargePeriod, java.lang.String argChargeDateRule) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseChargeRule _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseChargeRuleBean bean = (com.hps.july.persistence.LeaseChargeRuleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseRule, argLeaseDocument, argResource, argCurrency, argSum, argChargePeriod, argChargeDateRule);
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
	public com.hps.july.persistence.LeaseChargeRule create(int argLeaseRule) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseChargeRule _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseChargeRuleBean bean = (com.hps.july.persistence.LeaseChargeRuleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseRule);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeaseRule);
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
		com.hps.july.persistence.LeaseChargeRuleBean tmpEJB = (com.hps.july.persistence.LeaseChargeRuleBean) generalEJB;
		com.hps.july.persistence.LeaseRuleKey keyClass = new com.hps.july.persistence.LeaseRuleKey();
		keyClass.leaseRule = tmpEJB.leaseRule;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseRuleKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseRuleKey keyClass = new com.hps.july.persistence.LeaseRuleKey();
		keyClass.leaseRule = f0;
		return keyClass;
	}
}
