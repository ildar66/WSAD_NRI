package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseCalcRateHomeBean_be50a3fb
 */
public class EJSCMPLeaseCalcRateHomeBean_be50a3fb extends EJSHome {
	/**
	 * EJSCMPLeaseCalcRateHomeBean_be50a3fb
	 */
	public EJSCMPLeaseCalcRateHomeBean_be50a3fb() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseCalcRate postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseCalcRate) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findBy_Hand_LeaseDocPosition
	 */
	public java.util.Enumeration findBy_Hand_LeaseDocPosition(java.lang.String argByHand, java.lang.Integer argDocPosition) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseCalcRateBean)persister).findBy_Hand_LeaseDocPosition(argByHand, argDocPosition));	}
	/**
	 * findLeaseCalcRatesByDocposition
	 */
	public java.util.Enumeration findLeaseCalcRatesByDocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseCalcRateBean)persister).findLeaseCalcRatesByDocposition(inKey));	}
	/**
	 * findLeaseCalcRatesByCurrency
	 */
	public java.util.Enumeration findLeaseCalcRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseCalcRateBean)persister).findLeaseCalcRatesByCurrency(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseCalcRate findByPrimaryKey(com.hps.july.persistence.LeaseCalcRateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseCalcRateBean_be50a3fb) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseCalcRatesByAct
	 */
	public java.util.Enumeration findLeaseCalcRatesByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseCalcRateBean)persister).findLeaseCalcRatesByAct(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseCalcRate create(java.lang.Integer argDocPosition, java.lang.Integer argCurrency, java.math.BigDecimal argRate, java.lang.Boolean argByHand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseCalcRate _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseCalcRateBean bean = (com.hps.july.persistence.LeaseCalcRateBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocPosition, argCurrency, argRate, argByHand);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseCalcRateBean tmpEJB = (com.hps.july.persistence.LeaseCalcRateBean) generalEJB;
		com.hps.july.persistence.LeaseCalcRateKey keyClass = new com.hps.july.persistence.LeaseCalcRateKey();
		keyClass.docposition_leaseDocPosition = tmpEJB.docposition_leaseDocPosition;
		keyClass.currency_currency = tmpEJB.currency_currency;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseCalcRateKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.LeaseCalcRateKey keyClass = new com.hps.july.persistence.LeaseCalcRateKey();
		keyClass.docposition_leaseDocPosition = f0;
		keyClass.currency_currency = f1;
		return keyClass;
	}
}
