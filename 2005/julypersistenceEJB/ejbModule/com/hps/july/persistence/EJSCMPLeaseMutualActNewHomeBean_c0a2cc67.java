package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMutualActNewHomeBean_c0a2cc67
 */
public class EJSCMPLeaseMutualActNewHomeBean_c0a2cc67 extends EJSHome {
	/**
	 * EJSCMPLeaseMutualActNewHomeBean_c0a2cc67
	 */
	public EJSCMPLeaseMutualActNewHomeBean_c0a2cc67() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualActNew postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualActNew) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.Integer argLeaseMutualReglament, java.lang.String argState, java.sql.Date actstartdate, java.sql.Date actenddate, boolean argIsTemp, java.lang.Boolean argIsSchetFakt) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualActNew _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualActNewBean bean = (com.hps.july.persistence.LeaseMutualActNewBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument, argDocDate, argDocNumber, argLeaseMutualReglament, argState, actstartdate, actenddate, argIsTemp, argIsSchetFakt);
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
	 * findLeaseMutualActNewByLeaseMutualReglament
	 */
	public java.util.Enumeration findLeaseMutualActNewByLeaseMutualReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualActNewBean)persister).findLeaseMutualActNewByLeaseMutualReglament(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.Integer argLeaseMutualReglament, java.lang.String argState, java.sql.Date actstartdate, java.sql.Date actenddate, boolean argIsTemp) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualActNew _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualActNewBean bean = (com.hps.july.persistence.LeaseMutualActNewBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument, argDocDate, argDocNumber, argLeaseMutualReglament, argState, actstartdate, actenddate, argIsTemp);
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
	public com.hps.july.persistence.LeaseMutualActNew findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMutualActNewBean_c0a2cc67) persister).findByPrimaryKey(key);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isMutualReglament, java.lang.Integer mutualReglament, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualActNewBean)persister).findByQBE(isMutualReglament, mutualReglament, isDate, fromDate, toDate, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualActNew _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualActNewBean bean = (com.hps.july.persistence.LeaseMutualActNewBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeaseDocument);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeaseDocument);
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
	public java.util.Enumeration findByQBE2(java.lang.Integer mutualReglament, java.lang.Boolean isEdit, java.lang.Boolean isRun, java.lang.Boolean isClose, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualActNewBean)persister).findByQBE2(mutualReglament, isEdit, isRun, isClose, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseMutualActNewBean tmpEJB = (com.hps.july.persistence.LeaseMutualActNewBean) generalEJB;
		com.hps.july.persistence.LeaseDocumentKey keyClass = new com.hps.july.persistence.LeaseDocumentKey();
		keyClass.leaseDocument = tmpEJB.leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseDocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseDocumentKey keyClass = new com.hps.july.persistence.LeaseDocumentKey();
		keyClass.leaseDocument = f0;
		return keyClass;
	}
}
