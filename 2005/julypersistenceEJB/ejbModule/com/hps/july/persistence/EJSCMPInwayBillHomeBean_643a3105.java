package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPInwayBillHomeBean_643a3105
 */
public class EJSCMPInwayBillHomeBean_643a3105 extends EJSHome {
	/**
	 * EJSCMPInwayBillHomeBean_643a3105
	 */
	public EJSCMPInwayBillHomeBean_643a3105() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.InwayBill postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.InwayBill) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findInwayBilltechstufByDActTechStuf
	 */
	public java.util.Enumeration findInwayBilltechstufByDActTechStuf(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInwayBillBean)persister).findInwayBilltechstufByDActTechStuf(inKey));	}
	/**
	 * findInwayBillByCurrency
	 */
	public java.util.Enumeration findInwayBillByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInwayBillBean)persister).findInwayBillByCurrency(inKey));	}
	/**
	 * findInwayBillstorManagersByDActStorManager
	 */
	public java.util.Enumeration findInwayBillstorManagersByDActStorManager(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInwayBillBean)persister).findInwayBillstorManagersByDActStorManager(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.InwayBill findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPInwayBillBean_643a3105) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.InwayBill create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InwayBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InwayBillBean bean = (com.hps.july.persistence.InwayBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination, argCurrency);
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
	public com.hps.july.persistence.InwayBill create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InwayBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InwayBillBean bean = (com.hps.july.persistence.InwayBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argBlankDate, argBlankindex, argState);
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
	 * findInwayBillsByRepresentative
	 */
	public java.util.Enumeration findInwayBillsByRepresentative(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInwayBillBean)persister).findInwayBillsByRepresentative(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isStorage, java.lang.Integer storage, java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isCordocnum, java.lang.String cordocnum, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isSupplier, java.lang.Integer supplier, java.lang.Boolean isDActOnly, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderInwayBillBean)persister).findByQBE(isStorage, storage, startDate, endDate, isCordocnum, cordocnum, isOwner, owner, isSupplier, supplier, isDActOnly, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.InwayBill create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argCurrency, java.lang.String argRepresentativeType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InwayBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InwayBillBean bean = (com.hps.july.persistence.InwayBillBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination, argCurrency, argRepresentativeType);
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
	public com.hps.july.persistence.InwayBill create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.InwayBill _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.InwayBillBean bean = (com.hps.july.persistence.InwayBillBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.InwayBillBean tmpEJB = (com.hps.july.persistence.InwayBillBean) generalEJB;
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
