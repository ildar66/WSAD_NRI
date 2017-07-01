package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMutualPhoneHomeBean_a18d2f5c
 */
public class EJSCMPLeaseMutualPhoneHomeBean_a18d2f5c extends EJSHome {
	/**
	 * EJSCMPLeaseMutualPhoneHomeBean_a18d2f5c
	 */
	public EJSCMPLeaseMutualPhoneHomeBean_a18d2f5c() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualPhone postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualPhone) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseMutualPhone findByPrimaryKey(com.hps.july.persistence.LeaseMutualPhoneKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMutualPhoneBean_a18d2f5c) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseMutualPhoneByLeaseDocument
	 */
	public java.util.Enumeration findLeaseMutualPhoneByLeaseDocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualPhoneBean)persister).findLeaseMutualPhoneByLeaseDocument(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualPhone create(java.lang.Integer argDocument, java.lang.String argPhone) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualPhone _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualPhoneBean bean = (com.hps.july.persistence.LeaseMutualPhoneBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argPhone);
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
	public com.hps.july.persistence.LeaseMutualPhone create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualPhone _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualPhoneBean bean = (com.hps.july.persistence.LeaseMutualPhoneBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
		com.hps.july.persistence.LeaseMutualPhoneBean tmpEJB = (com.hps.july.persistence.LeaseMutualPhoneBean) generalEJB;
		com.hps.july.persistence.LeaseMutualPhoneKey keyClass = new com.hps.july.persistence.LeaseMutualPhoneKey();
		keyClass.phone = tmpEJB.phone;
		keyClass.leaseDocument_leaseDocument = tmpEJB.leaseDocument_leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseMutualPhoneKey keyFromFields(java.lang.String f0, java.lang.Integer f1) {
		com.hps.july.persistence.LeaseMutualPhoneKey keyClass = new com.hps.july.persistence.LeaseMutualPhoneKey();
		keyClass.phone = f0;
		keyClass.leaseDocument_leaseDocument = f1;
		return keyClass;
	}
}
