package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeasePayRuleHomeBean_0016f96c
 */
public class EJSCMPLeasePayRuleHomeBean_0016f96c extends EJSHome {
	/**
	 * EJSCMPLeasePayRuleHomeBean_0016f96c
	 */
	public EJSCMPLeasePayRuleHomeBean_0016f96c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePayRule postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePayRule) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeasePayRuleByCurrency
	 */
	public java.util.Enumeration findLeasePayRuleByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePayRuleBean)persister).findLeasePayRuleByCurrency(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeasePayRule create(java.lang.Integer argLeaseRule, java.lang.Integer argLeaseDocument, java.lang.Integer argCurrency, java.math.BigDecimal argSum, java.lang.String argPayType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePayRule _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePayRuleBean bean = (com.hps.july.persistence.LeasePayRuleBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseRule, argLeaseDocument, argCurrency, argSum, argPayType);
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
	 * findLeasePayRuleByResource
	 */
	public java.util.Enumeration findLeasePayRuleByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePayRuleBean)persister).findLeasePayRuleByResource(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeasePayRule findByPrimaryKey(com.hps.july.persistence.LeaseRuleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeasePayRuleBean_0016f96c) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeasePayRule create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePayRule _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePayRuleBean bean = (com.hps.july.persistence.LeasePayRuleBean) beanO.getEnterpriseBean();
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
	 * findLeasePayRule4orgtopayByOrgToPay
	 */
	public java.util.Enumeration findLeasePayRule4orgtopayByOrgToPay(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePayRuleBean)persister).findLeasePayRule4orgtopayByOrgToPay(inKey));	}
	/**
	 * findByLeasedocumentResourcePaytype
	 */
	public java.util.Enumeration findByLeasedocumentResourcePaytype(java.lang.Integer leaseDocument, java.lang.Integer resource, java.lang.String paytype) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePayRuleBean)persister).findByLeasedocumentResourcePaytype(leaseDocument, resource, paytype));	}
	/**
	 * findByLeaseDocument
	 */
	public java.util.Enumeration findByLeaseDocument(java.lang.Integer leaseDocument, java.lang.Boolean isPpType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePayRuleBean)persister).findByLeaseDocument(leaseDocument, isPpType, order));	}
	/**
	 * findLeasePayRule4OrgAccByOrgAcc
	 */
	public java.util.Enumeration findLeasePayRule4OrgAccByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePayRuleBean)persister).findLeasePayRule4OrgAccByOrgAcc(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeasePayRule create(int argLeaseRule) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePayRule _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePayRuleBean bean = (com.hps.july.persistence.LeasePayRuleBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.LeasePayRuleBean tmpEJB = (com.hps.july.persistence.LeasePayRuleBean) generalEJB;
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
