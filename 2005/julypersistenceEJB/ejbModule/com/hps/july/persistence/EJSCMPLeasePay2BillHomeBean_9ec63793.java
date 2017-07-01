package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeasePay2BillHomeBean_9ec63793
 */
public class EJSCMPLeasePay2BillHomeBean_9ec63793 extends EJSHome {
	/**
	 * EJSCMPLeasePay2BillHomeBean_9ec63793
	 */
	public EJSCMPLeasePay2BillHomeBean_9ec63793() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeasePay2Bill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeasePay2Bill) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeasePay2Bill create(int argLeasemutualact, int argLeaseContract, java.math.BigDecimal argSumUSD, boolean argFlagWorkPIE, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeasePay2Bill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeasePay2BillBean bean = (com.hps.july.persistence.LeasePay2BillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeasemutualact, argLeaseContract, argSumUSD, argFlagWorkPIE, argRecordStatus);
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
	 * findByAct
	 */
	public java.util.Enumeration findByAct(java.lang.Integer argAct) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePay2BillBean)persister).findByAct(argAct));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeasePay2Bill findByPrimaryKey(com.hps.july.persistence.LeasePay2BillKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeasePay2BillBean_9ec63793) persister).findByPrimaryKey(key);
	}
	/**
	 * findByFlagWorkPIE
	 */
	public java.util.Enumeration findByFlagWorkPIE(java.lang.String argFlagWorkPIE) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeasePay2BillBean)persister).findByFlagWorkPIE(argFlagWorkPIE));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeasePay2BillBean tmpEJB = (com.hps.july.persistence.LeasePay2BillBean) generalEJB;
		com.hps.july.persistence.LeasePay2BillKey keyClass = new com.hps.july.persistence.LeasePay2BillKey();
		keyClass.leasemutualact = tmpEJB.leasemutualact;
		keyClass.leasecontract = tmpEJB.leasecontract;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeasePay2BillKey keyFromFields(int f0, int f1) {
		com.hps.july.persistence.LeasePay2BillKey keyClass = new com.hps.july.persistence.LeasePay2BillKey();
		keyClass.leasemutualact = f0;
		keyClass.leasecontract = f1;
		return keyClass;
	}
}
