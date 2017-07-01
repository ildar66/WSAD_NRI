package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeasePaymentHomeBean_ca59e9e2
 */
public class EJSCMPLeasePaymentHomeBean_ca59e9e2 extends EJSHome {
	/**
	 * EJSCMPLeasePaymentHomeBean_ca59e9e2
	 */
	public EJSCMPLeasePaymentHomeBean_ca59e9e2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePayment) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer leaseRule, java.sql.Date startDate, java.sql.Date finishDate, java.lang.Boolean isSource, java.lang.String source) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePaymentBean)persister).findByQBE2(leaseRule, startDate, finishDate, isSource, source));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeasePayment findByPrimaryKey(com.hps.july.persistence.LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeasePaymentBean_ca59e9e2) persister).findByPrimaryKey(key);
	}
	/**
	 * findByLeaseContract
	 */
	public java.util.Enumeration findByLeaseContract(java.lang.Integer argContract) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePaymentBean)persister).findByLeaseContract(argContract));	}
	/**
	 * findByQBE5
	 */
	public java.util.Enumeration findByQBE5(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isDocposvid, java.lang.String[] docposvid, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePaymentBean)persister).findByQBE5(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, isDocposvid, docposvid, order));	}
	/**
	 * findLeasePaymentByLeaseRule
	 */
	public java.util.Enumeration findLeasePaymentByLeaseRule(com.hps.july.persistence.LeaseRuleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePaymentBean)persister).findLeasePaymentByLeaseRule(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeasePayment create(int argLeaseDocPosition, java.sql.Date argDate, java.lang.Integer argLeaseContract, java.lang.String argSource, java.lang.String argVid, java.sql.Date argSDate, java.sql.Date argEDate, java.lang.Integer argResource, java.math.BigDecimal argSumm, java.lang.Integer argCurrency, java.math.BigDecimal argSumNds, java.lang.String argPaymentType, java.lang.String argPaymentState, java.lang.String argIsSchetFakt) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePayment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePaymentBean bean = (com.hps.july.persistence.LeasePaymentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocPosition, argDate, argLeaseContract, argSource, argVid, argSDate, argEDate, argResource, argSumm, argCurrency, argSumNds, argPaymentType, argPaymentState, argIsSchetFakt);
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
	public com.hps.july.persistence.LeasePayment create(int argLeaseDocPosition, java.sql.Date argDate, java.lang.Integer argLeaseContract, java.lang.String argSource, java.lang.String argVid, java.sql.Date argSDate, java.sql.Date argEDate, java.lang.Integer argResource, java.math.BigDecimal argSumm, java.lang.Integer argCurrency, java.math.BigDecimal argSumNds, java.lang.String argPaymentType, java.lang.String argPaymentState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePayment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePaymentBean bean = (com.hps.july.persistence.LeasePaymentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocPosition, argDate, argLeaseContract, argSource, argVid, argSDate, argEDate, argResource, argSumm, argCurrency, argSumNds, argPaymentType, argPaymentState);
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
	 * findByQBE4
	 */
	public java.util.Enumeration findByQBE4(java.lang.Integer contract, java.lang.Boolean isStartDate, java.sql.Date actStartDate, java.lang.Boolean isEndDate, java.sql.Date actEndDate, java.lang.Boolean isRemainder, java.math.BigDecimal remainder, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isCalcPosOnly, java.lang.Boolean isAutoRUR, java.lang.Boolean autoRUR) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePaymentBean)persister).findByQBE4(contract, isStartDate, actStartDate, isEndDate, actEndDate, isRemainder, remainder, isResource, resource, isCalcPosOnly, isAutoRUR, autoRUR));	}
	/**
	 * findByQBE3
	 */
	public java.util.Enumeration findByQBE3(java.lang.Integer leaseContract, java.lang.Integer resource, java.sql.Date startInterval, java.sql.Date finishInterval) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePaymentBean)persister).findByQBE3(leaseContract, resource, startInterval, finishInterval));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePaymentBean)persister).findByQBE(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeasePaymentBean tmpEJB = (com.hps.july.persistence.LeasePaymentBean) generalEJB;
		com.hps.july.persistence.LeaseDocPositionKey keyClass = new com.hps.july.persistence.LeaseDocPositionKey();
		keyClass.leaseDocPosition = tmpEJB.leaseDocPosition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseDocPositionKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseDocPositionKey keyClass = new com.hps.july.persistence.LeaseDocPositionKey();
		keyClass.leaseDocPosition = f0;
		return keyClass;
	}
}
