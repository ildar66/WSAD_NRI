package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAbonentPaymentHomeBean_a0239318
 */
public class EJSCMPAbonentPaymentHomeBean_a0239318 extends EJSHome {
	/**
	 * EJSCMPAbonentPaymentHomeBean_a0239318
	 */
	public EJSCMPAbonentPaymentHomeBean_a0239318() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonentPayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonentPayment) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByBANDate
	 */
	public java.util.Enumeration findByBANDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentPaymentBean)persister).findByBANDate(argBan, argStartDate));	}
	/**
	 * findAbonentPaymentsByLeaseabonentban
	 */
	public java.util.Enumeration findAbonentPaymentsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentPaymentBean)persister).findAbonentPaymentsByLeaseabonentban(inKey));	}
	/**
	 * findByFlagWorkNRI
	 */
	public java.util.Enumeration findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentPaymentBean)persister).findByFlagWorkNRI(argFlagWorkNRI));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonentPayment create(int argPaypos, int argLeaseDocument, boolean argNeedPay, java.math.BigDecimal argSumPayUSD, boolean argByHand, boolean argFlagWorkNRI, java.lang.String argRecordStatus, java.sql.Date argPayDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonentPayment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonentPaymentBean bean = (com.hps.july.persistence.AbonentPaymentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argPaypos, argLeaseDocument, argNeedPay, argSumPayUSD, argByHand, argFlagWorkNRI, argRecordStatus, argPayDate);
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
	 * findByDocumentQBE2
	 */
	public java.util.Enumeration findByDocumentQBE2(java.lang.Integer argDocument, java.lang.Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.Boolean isNeedPay, java.lang.Boolean needPay, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentPaymentBean)persister).findByDocumentQBE2(argDocument, isDatePeriod, argStartDate, argEndDate, isNeedPay, needPay, order));	}
	/**
	 * findByDocumentQBE
	 */
	public java.util.Enumeration findByDocumentQBE(java.lang.Integer argDocument, java.lang.Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentPaymentBean)persister).findByDocumentQBE(argDocument, isDatePeriod, argStartDate, argEndDate, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonentPayment findByPrimaryKey(com.hps.july.persistence.AbonentPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAbonentPaymentBean_a0239318) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AbonentPaymentBean tmpEJB = (com.hps.july.persistence.AbonentPaymentBean) generalEJB;
		com.hps.july.persistence.AbonentPaymentKey keyClass = new com.hps.july.persistence.AbonentPaymentKey();
		keyClass.paypos = tmpEJB.paypos;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AbonentPaymentKey keyFromFields(int f0) {
		com.hps.july.persistence.AbonentPaymentKey keyClass = new com.hps.july.persistence.AbonentPaymentKey();
		keyClass.paypos = f0;
		return keyClass;
	}
}
