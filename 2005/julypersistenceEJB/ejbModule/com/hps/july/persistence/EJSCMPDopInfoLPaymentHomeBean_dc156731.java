package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDopInfoLPaymentHomeBean_dc156731
 */
public class EJSCMPDopInfoLPaymentHomeBean_dc156731 extends EJSHome {
	/**
	 * EJSCMPDopInfoLPaymentHomeBean_dc156731
	 */
	public EJSCMPDopInfoLPaymentHomeBean_dc156731() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.DopInfoLPayment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.DopInfoLPayment) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.DopInfoLPayment create(int argLeasedocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.DopInfoLPayment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.DopInfoLPaymentBean bean = (com.hps.july.persistence.DopInfoLPaymentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeasedocposition);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeasedocposition);
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
	public com.hps.july.persistence.DopInfoLPayment findByPrimaryKey(com.hps.july.persistence.DopInfoLPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPDopInfoLPaymentBean_dc156731) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.DopInfoLPaymentBean tmpEJB = (com.hps.july.persistence.DopInfoLPaymentBean) generalEJB;
		com.hps.july.persistence.DopInfoLPaymentKey keyClass = new com.hps.july.persistence.DopInfoLPaymentKey();
		keyClass.leasedocposition = tmpEJB.leasedocposition;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DopInfoLPaymentKey keyFromFields(int f0) {
		com.hps.july.persistence.DopInfoLPaymentKey keyClass = new com.hps.july.persistence.DopInfoLPaymentKey();
		keyClass.leasedocposition = f0;
		return keyClass;
	}
}
