package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAbonentBillPosHomeBean_5236dd9f
 */
public class EJSCMPAbonentBillPosHomeBean_5236dd9f extends EJSHome {
	/**
	 * EJSCMPAbonentBillPosHomeBean_5236dd9f
	 */
	public EJSCMPAbonentBillPosHomeBean_5236dd9f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AbonentBillPos postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AbonentBillPos) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findAbonentBillPosesByPos2resource
	 */
	public java.util.Enumeration findAbonentBillPosesByPos2resource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillPosBean)persister).findAbonentBillPosesByPos2resource(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonentBillPos create(int argBillPos, int argLeaseBill, int argResource, java.math.BigDecimal argQty, int argCurrency, java.math.BigDecimal argSummPure, java.math.BigDecimal argSumPureNRI, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNRI, java.math.BigDecimal argNDSSumm, java.math.BigDecimal argNDSSummNRI, java.math.BigDecimal argNSPSumm, java.math.BigDecimal argNSPSummNRI, java.lang.String argRecordStatus, boolean argSumByHand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonentBillPos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonentBillPosBean bean = (com.hps.july.persistence.AbonentBillPosBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argBillPos, argLeaseBill, argResource, argQty, argCurrency, argSummPure, argSumPureNRI, argSumm, argSummNRI, argNDSSumm, argNDSSummNRI, argNSPSumm, argNSPSummNRI, argRecordStatus, argSumByHand);
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
	 * findByLeaseBill
	 */
	public java.util.Enumeration findByLeaseBill(java.lang.Integer leaseBill) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillPosBean)persister).findByLeaseBill(leaseBill));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AbonentBillPos findByPrimaryKey(com.hps.july.persistence.AbonentBillPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAbonentBillPosBean_5236dd9f) persister).findByPrimaryKey(key);
	}
	/**
	 * findAbonentBillPosesByPos2currency
	 */
	public java.util.Enumeration findAbonentBillPosesByPos2currency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillPosBean)persister).findAbonentBillPosesByPos2currency(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AbonentBillPos create(int argBillpos) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AbonentBillPos _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AbonentBillPosBean bean = (com.hps.july.persistence.AbonentBillPosBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argBillpos);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argBillpos);
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
	 * findAbonentBillPosesByPos2bill
	 */
	public java.util.Enumeration findAbonentBillPosesByPos2bill(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAbonentBillPosBean)persister).findAbonentBillPosesByPos2bill(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AbonentBillPosBean tmpEJB = (com.hps.july.persistence.AbonentBillPosBean) generalEJB;
		com.hps.july.persistence.AbonentBillPosKey keyClass = new com.hps.july.persistence.AbonentBillPosKey();
		keyClass.billpos = tmpEJB.billpos;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AbonentBillPosKey keyFromFields(int f0) {
		com.hps.july.persistence.AbonentBillPosKey keyClass = new com.hps.july.persistence.AbonentBillPosKey();
		keyClass.billpos = f0;
		return keyClass;
	}
}
