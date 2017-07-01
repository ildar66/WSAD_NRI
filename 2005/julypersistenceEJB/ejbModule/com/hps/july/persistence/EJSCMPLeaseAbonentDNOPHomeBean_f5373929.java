package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseAbonentDNOPHomeBean_f5373929
 */
public class EJSCMPLeaseAbonentDNOPHomeBean_f5373929 extends EJSHome {
	/**
	 * EJSCMPLeaseAbonentDNOPHomeBean_f5373929
	 */
	public EJSCMPLeaseAbonentDNOPHomeBean_f5373929() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentDNOP postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentDNOP) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPayPos
	 */
	public java.util.Enumeration findByPayPos(java.lang.Integer argPayPos) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentDNOPBean)persister).findByPayPos(argPayPos));	}
	/**
	 * findByPayPosLeaseBill
	 */
	public java.util.Enumeration findByPayPosLeaseBill(java.lang.Integer argPayPos, java.lang.Integer argLeaseBill) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentDNOPBean)persister).findByPayPosLeaseBill(argPayPos, argLeaseBill));	}
	/**
	 * findByFlagWorkNRI
	 */
	public java.util.Enumeration findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentDNOPBean)persister).findByFlagWorkNRI(argFlagWorkNRI));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseAbonentDNOP create(int argIdabonentdnop, int argLeaseBill, int argPayPos, java.math.BigDecimal argSumLinkUSD, boolean argFlagWorkNRI, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseAbonentDNOP _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseAbonentDNOPBean bean = (com.hps.july.persistence.LeaseAbonentDNOPBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdabonentdnop, argLeaseBill, argPayPos, argSumLinkUSD, argFlagWorkNRI, argRecordStatus);
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
	public com.hps.july.persistence.LeaseAbonentDNOP findByPrimaryKey(com.hps.july.persistence.LeaseAbonentDNOPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseAbonentDNOPBean_f5373929) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseAbonentDNOPsByAbonentbill
	 */
	public java.util.Enumeration findLeaseAbonentDNOPsByAbonentbill(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentDNOPBean)persister).findLeaseAbonentDNOPsByAbonentbill(inKey));	}
	/**
	 * findLeaseAbonentDNOPsByAbonentpayment
	 */
	public java.util.Enumeration findLeaseAbonentDNOPsByAbonentpayment(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentDNOPBean)persister).findLeaseAbonentDNOPsByAbonentpayment(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseAbonentDNOPBean tmpEJB = (com.hps.july.persistence.LeaseAbonentDNOPBean) generalEJB;
		com.hps.july.persistence.LeaseAbonentDNOPKey keyClass = new com.hps.july.persistence.LeaseAbonentDNOPKey();
		keyClass.idabonentdnop = tmpEJB.idabonentdnop;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseAbonentDNOPKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseAbonentDNOPKey keyClass = new com.hps.july.persistence.LeaseAbonentDNOPKey();
		keyClass.idabonentdnop = f0;
		return keyClass;
	}
}
