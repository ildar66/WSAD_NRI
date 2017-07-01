package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseDNOPHomeBean_93b75ce3
 */
public class EJSCMPLeaseDNOPHomeBean_93b75ce3 extends EJSHome {
	/**
	 * EJSCMPLeaseDNOPHomeBean_93b75ce3
	 */
	public EJSCMPLeaseDNOPHomeBean_93b75ce3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseDNOP postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseDNOP) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByLeaseChargeSource
	 */
	public java.util.Enumeration findByLeaseChargeSource(java.lang.Integer argLeaseCharge, java.lang.String argSource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findByLeaseChargeSource(argLeaseCharge, argSource));	}
	/**
	 * findLeaseDNOPByLeaseCharge
	 */
	public java.util.Enumeration findLeaseDNOPByLeaseCharge(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findLeaseDNOPByLeaseCharge(inKey));	}
	/**
	 * findByActAndHand
	 */
	public java.util.Enumeration findByActAndHand(java.lang.Integer argAct, java.lang.String argHand) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findByActAndHand(argAct, argHand));	}
	/**
	 * findByActAndSource
	 */
	public java.util.Enumeration findByActAndSource(java.lang.Integer argAct, java.lang.String argSource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findByActAndSource(argAct, argSource));	}
	/**
	 * findLeaseDNOPPayByLeasePayment
	 */
	public java.util.Enumeration findLeaseDNOPPayByLeasePayment(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findLeaseDNOPPayByLeasePayment(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseDNOP create(java.lang.Integer argLeaseCharge, java.lang.Integer argLeasePayment, java.math.BigDecimal argChargeSum, java.math.BigDecimal argPayRurSum, java.lang.String argSource, java.lang.Boolean argByHandChargeRateRur) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseDNOP _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseDNOPBean bean = (com.hps.july.persistence.LeaseDNOPBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseCharge, argLeasePayment, argChargeSum, argPayRurSum, argSource, argByHandChargeRateRur);
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
	public com.hps.july.persistence.LeaseDNOP findByPrimaryKey(com.hps.july.persistence.LeaseDNOPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseDNOPBean_93b75ce3) persister).findByPrimaryKey(key);
	}
	/**
	 * findByLeasePaymentSource
	 */
	public java.util.Enumeration findByLeasePaymentSource(java.lang.Integer argLeasePayment, java.lang.String argSource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findByLeasePaymentSource(argLeasePayment, argSource));	}
	/**
	 * findLeaseDNOPsByAct
	 */
	public java.util.Enumeration findLeaseDNOPsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findLeaseDNOPsByAct(inKey));	}
	/**
	 * findByLeaseChargeOrderByLeasePayment
	 */
	public java.util.Enumeration findByLeaseChargeOrderByLeasePayment(java.lang.Integer leaseCharge) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseDNOPBean)persister).findByLeaseChargeOrderByLeasePayment(leaseCharge));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseDNOPBean tmpEJB = (com.hps.july.persistence.LeaseDNOPBean) generalEJB;
		com.hps.july.persistence.LeaseDNOPKey keyClass = new com.hps.july.persistence.LeaseDNOPKey();
		keyClass.leaseCharge_leaseDocPosition = tmpEJB.leaseCharge_leaseDocPosition;
		keyClass.leasePayment_leaseDocPosition = tmpEJB.leasePayment_leaseDocPosition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseDNOPKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.LeaseDNOPKey keyClass = new com.hps.july.persistence.LeaseDNOPKey();
		keyClass.leaseCharge_leaseDocPosition = f0;
		keyClass.leasePayment_leaseDocPosition = f1;
		return keyClass;
	}
}
