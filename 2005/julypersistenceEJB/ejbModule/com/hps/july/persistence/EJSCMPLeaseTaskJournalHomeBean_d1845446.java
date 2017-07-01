package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseTaskJournalHomeBean_d1845446
 */
public class EJSCMPLeaseTaskJournalHomeBean_d1845446 extends EJSHome {
	/**
	 * EJSCMPLeaseTaskJournalHomeBean_d1845446
	 */
	public EJSCMPLeaseTaskJournalHomeBean_d1845446() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseTaskJournal postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseTaskJournal) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer taskStart, java.lang.Boolean isError, java.lang.Boolean isWarning, java.lang.Boolean isSuccess, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskJournalBean)persister).findByQBE(taskStart, isError, isWarning, isSuccess, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseTaskJournal findByPrimaryKey(com.hps.july.persistence.LeaseTaskJournalKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseTaskJournalBean_d1845446) persister).findByPrimaryKey(key);
	}
	/**
	 * findByTaskStartOrderByJrndateAscAndTaskjournalAsc
	 */
	public java.util.Enumeration findByTaskStartOrderByJrndateAscAndTaskjournalAsc(java.lang.Integer taskStart, java.lang.Boolean isError, java.lang.Boolean isWarning, java.lang.Boolean isSuccess) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskJournalBean)persister).findByTaskStartOrderByJrndateAscAndTaskjournalAsc(taskStart, isError, isWarning, isSuccess));	}
	/**
	 * findByTaskStartType
	 */
	public java.util.Enumeration findByTaskStartType(java.lang.Integer taskStart, java.lang.Boolean isJrnType, java.lang.String jrnType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskJournalBean)persister).findByTaskStartType(taskStart, isJrnType, jrnType, order));	}
	/**
	 * findStart2journalByJournal2start
	 */
	public java.util.Enumeration findStart2journalByJournal2start(com.hps.july.persistence.LeaseTaskStartKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskJournalBean)persister).findStart2journalByJournal2start(inKey));	}
	/**
	 * findByTaskStartOrderByJrnDate
	 */
	public java.util.Enumeration findByTaskStartOrderByJrnDate(java.lang.Integer taskStart, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskJournalBean)persister).findByTaskStartOrderByJrnDate(taskStart, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseTaskJournal create(int argTaskJournal, int argTaskStart, java.sql.Timestamp argJrnDate, int argJrnAction, java.lang.String argJrnType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseTaskJournal _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseTaskJournalBean bean = (com.hps.july.persistence.LeaseTaskJournalBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTaskJournal, argTaskStart, argJrnDate, argJrnAction, argJrnType);
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
	public com.hps.july.persistence.LeaseTaskJournal create(int argTaskjournal) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseTaskJournal _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseTaskJournalBean bean = (com.hps.july.persistence.LeaseTaskJournalBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTaskjournal);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argTaskjournal);
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
		com.hps.july.persistence.LeaseTaskJournalBean tmpEJB = (com.hps.july.persistence.LeaseTaskJournalBean) generalEJB;
		com.hps.july.persistence.LeaseTaskJournalKey keyClass = new com.hps.july.persistence.LeaseTaskJournalKey();
		keyClass.taskjournal = tmpEJB.taskjournal;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseTaskJournalKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseTaskJournalKey keyClass = new com.hps.july.persistence.LeaseTaskJournalKey();
		keyClass.taskjournal = f0;
		return keyClass;
	}
}
