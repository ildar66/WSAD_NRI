package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseVPaymentHomeBean_86f8b53d
 */
public class EJSCMPLeaseVPaymentHomeBean_86f8b53d extends EJSHome {
	/**
	 * EJSCMPLeaseVPaymentHomeBean_86f8b53d
	 */
	public EJSCMPLeaseVPaymentHomeBean_86f8b53d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseVPayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseVPayment) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseVPayment create(java.lang.Integer argAct, java.lang.Integer argDebetContract, java.lang.Integer argCreditContract, java.math.BigDecimal argSumm) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseVPayment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseVPaymentBean bean = (com.hps.july.persistence.LeaseVPaymentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAct, argDebetContract, argCreditContract, argSumm);
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
	public com.hps.july.persistence.LeaseVPayment findByPrimaryKey(com.hps.july.persistence.LeaseVPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseVPaymentBean_86f8b53d) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseVPayment create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseVPayment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseVPaymentBean bean = (com.hps.july.persistence.LeaseVPaymentBean) beanO.getEnterpriseBean();
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
	 * findLeaseVPaymentsByAct
	 */
	public java.util.Enumeration findLeaseVPaymentsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseVPaymentBean)persister).findLeaseVPaymentsByAct(inKey));	}
	/**
	 * findLeaseVPaymentDsByDebetcontract
	 */
	public java.util.Enumeration findLeaseVPaymentDsByDebetcontract(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseVPaymentBean)persister).findLeaseVPaymentDsByDebetcontract(inKey));	}
	/**
	 * findLeaseVPaymentCsByCreditcontract
	 */
	public java.util.Enumeration findLeaseVPaymentCsByCreditcontract(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseVPaymentBean)persister).findLeaseVPaymentCsByCreditcontract(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseVPaymentBean tmpEJB = (com.hps.july.persistence.LeaseVPaymentBean) generalEJB;
		com.hps.july.persistence.LeaseVPaymentKey keyClass = new com.hps.july.persistence.LeaseVPaymentKey();
		keyClass.creditcontract_leaseDocument = tmpEJB.creditcontract_leaseDocument;
		keyClass.debetcontract_leaseDocument = tmpEJB.debetcontract_leaseDocument;
		keyClass.act_leaseDocument = tmpEJB.act_leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseVPaymentKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1, java.lang.Integer f2) {
		com.hps.july.persistence.LeaseVPaymentKey keyClass = new com.hps.july.persistence.LeaseVPaymentKey();
		keyClass.creditcontract_leaseDocument = f0;
		keyClass.debetcontract_leaseDocument = f1;
		keyClass.act_leaseDocument = f2;
		return keyClass;
	}
}
