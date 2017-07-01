package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAbonentBillHomeBean_75fa4e4f
 */
public class EJSCMPAbonentBillHomeBean_75fa4e4f extends EJSHome {
	/**
	 * EJSCMPAbonentBillHomeBean_75fa4e4f
	 */
	public EJSCMPAbonentBillHomeBean_75fa4e4f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonentBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonentBill) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.AbonentBill create(int argLeaseBill, int argLeaseDocument, java.lang.String argBenSource, boolean argFlagWorkNRI, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonentBillBean bean = (com.hps.july.persistence.AbonentBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseBill, argLeaseDocument, argBenSource, argFlagWorkNRI, argRecordStatus);
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
	 * findByBen
	 */
	public java.util.Enumeration findByBen(java.lang.Short argBen) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillBean)persister).findByBen(argBen));	}
	/**
	 * findByFlagWorkNRI
	 */
	public java.util.Enumeration findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillBean)persister).findByFlagWorkNRI(argFlagWorkNRI));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillBean)persister).findByQBE(isLeaseDocument, leaseDocument, isBillDate, fromBillDate, toBillDate, isBillType, billType, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonentBill create(int argLeaseBill, int argLeaseDocument, java.lang.String argBenSource, boolean argFlagWorkNRI) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonentBillBean bean = (com.hps.july.persistence.AbonentBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseBill, argLeaseDocument, argBenSource, argFlagWorkNRI);
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
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Boolean isUseinNRI, java.lang.Boolean useInNRI, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillBean)persister).findByQBE2(isLeaseDocument, leaseDocument, isBillDate, fromBillDate, toBillDate, isBillType, billType, isUseinNRI, useInNRI, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonentBill findByPrimaryKey(com.hps.july.persistence.AbonentBillKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAbonentBillBean_75fa4e4f) persister).findByPrimaryKey(key);
	}
	/**
	 * findByBanStartServDate
	 */
	public java.util.Enumeration findByBanStartServDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillBean)persister).findByBanStartServDate(argBan, argStartDate));	}
	/**
	 * findAbonentBillsByLeaseabonentban
	 */
	public java.util.Enumeration findAbonentBillsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillBean)persister).findAbonentBillsByLeaseabonentban(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonentBill create(int argLeasebill) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonentBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonentBillBean bean = (com.hps.july.persistence.AbonentBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeasebill);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeasebill);
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
		com.hps.july.persistence.AbonentBillBean tmpEJB = (com.hps.july.persistence.AbonentBillBean) generalEJB;
		com.hps.july.persistence.AbonentBillKey keyClass = new com.hps.july.persistence.AbonentBillKey();
		keyClass.leasebill = tmpEJB.leasebill;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AbonentBillKey keyFromFields(int f0) {
		com.hps.july.persistence.AbonentBillKey keyClass = new com.hps.july.persistence.AbonentBillKey();
		keyClass.leasebill = f0;
		return keyClass;
	}
}
