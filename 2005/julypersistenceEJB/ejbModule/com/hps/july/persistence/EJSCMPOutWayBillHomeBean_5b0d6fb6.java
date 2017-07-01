package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOutWayBillHomeBean_5b0d6fb6
 */
public class EJSCMPOutWayBillHomeBean_5b0d6fb6 extends EJSHome {
	/**
	 * EJSCMPOutWayBillHomeBean_5b0d6fb6
	 */
	public EJSCMPOutWayBillHomeBean_5b0d6fb6() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OutWayBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OutWayBill) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findOutWayBillsByCurrency
	 */
	public java.util.Enumeration findOutWayBillsByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOutWayBillBean)persister).findOutWayBillsByCurrency(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.OutWayBill create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, int argCurrency, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OutWayBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OutWayBillBean bean = (com.hps.july.persistence.OutWayBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argCurrency, argProcessSource, argProcessDestination);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isDate, java.sql.Date dateFrom, java.sql.Date dateTo, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isStorage, java.lang.Integer storage, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOutWayBillBean)persister).findByQBE(isDate, dateFrom, dateTo, isOwner, owner, isStorage, storage, isContragent, contragent, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.OutWayBill create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argState, int argCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OutWayBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OutWayBillBean bean = (com.hps.july.persistence.OutWayBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argBlankDate, argBlankindex, argState, argCurrency);
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
	public com.hps.july.persistence.OutWayBill findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPOutWayBillBean_5b0d6fb6) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.OutWayBill create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OutWayBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OutWayBillBean bean = (com.hps.july.persistence.OutWayBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argDocument);
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
		com.hps.july.persistence.OutWayBillBean tmpEJB = (com.hps.july.persistence.OutWayBillBean) generalEJB;
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = tmpEJB.document;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.DocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentKey keyClass = new com.hps.july.persistence.DocumentKey();
		keyClass.document = f0;
		return keyClass;
	}
}
