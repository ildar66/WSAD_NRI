package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeasePayOrderHomeBean_45cd0b0b
 */
public class EJSCMPLeasePayOrderHomeBean_45cd0b0b extends EJSHome {
	/**
	 * EJSCMPLeasePayOrderHomeBean_45cd0b0b
	 */
	public EJSCMPLeasePayOrderHomeBean_45cd0b0b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePayOrder postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePayOrder) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeasePayOrder findByPrimaryKey(com.hps.july.persistence.LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeasePayOrderBean_45cd0b0b) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeasePayOrder create(int argLeaseDocPosition, java.sql.Date argDate, java.lang.Integer argLeaseContract, java.lang.String argSource, java.lang.String argVid, java.sql.Date argSDate, java.sql.Date argEDate, java.lang.Integer argResource, java.math.BigDecimal argSumm, java.lang.Integer argCurrency, java.math.BigDecimal argSumNds, java.lang.String argPaymentType, java.lang.String argPaymentState, java.lang.Integer argOrgAcc, java.lang.String argPayPurpoise, java.lang.String argppType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePayOrder _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePayOrderBean bean = (com.hps.july.persistence.LeasePayOrderBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocPosition, argDate, argLeaseContract, argSource, argVid, argSDate, argEDate, argResource, argSumm, argCurrency, argSumNds, argPaymentType, argPaymentState, argOrgAcc, argPayPurpoise, argppType);
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
	 * findLeasePayOrderByOrgAcc
	 */
	public java.util.Enumeration findLeasePayOrderByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePayOrderBean)persister).findLeasePayOrderByOrgAcc(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeasePayOrderBean tmpEJB = (com.hps.july.persistence.LeasePayOrderBean) generalEJB;
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
