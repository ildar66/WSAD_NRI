package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseTaskStartHomeBean_4ec6dba1
 */
public class EJSCMPLeaseTaskStartHomeBean_4ec6dba1 extends EJSHome {
	/**
	 * EJSCMPLeaseTaskStartHomeBean_4ec6dba1
	 */
	public EJSCMPLeaseTaskStartHomeBean_4ec6dba1() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseTaskStart postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseTaskStart) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeaseTaskStartsByLeasedocument
	 */
	public java.util.Enumeration findLeaseTaskStartsByLeasedocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskStartBean)persister).findLeaseTaskStartsByLeasedocument(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isStartDate, java.sql.Date beginStartDate, java.sql.Date endStartDate, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Boolean isTaskType, java.lang.String taskType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskStartBean)persister).findByQBE(isStartDate, beginStartDate, endStartDate, isWorker, worker, isTaskType, taskType, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseTaskStart create(int argTaskStart, java.sql.Timestamp argStartDate, int argWorker, java.lang.String argTaskType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseTaskStart _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseTaskStartBean bean = (com.hps.july.persistence.LeaseTaskStartBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTaskStart, argStartDate, argWorker, argTaskType);
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
	public com.hps.july.persistence.LeaseTaskStart findByPrimaryKey(com.hps.july.persistence.LeaseTaskStartKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseTaskStartBean_4ec6dba1) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseTaskStartsByStartOperator
	 */
	public java.util.Enumeration findLeaseTaskStartsByStartOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskStartBean)persister).findLeaseTaskStartsByStartOperator(inKey));	}
	/**
	 * findLeaseTaskStartEconomistsByEconomistWorker
	 */
	public java.util.Enumeration findLeaseTaskStartEconomistsByEconomistWorker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskStartBean)persister).findLeaseTaskStartEconomistsByEconomistWorker(inKey));	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isTaskType, java.lang.String taskType, java.lang.Boolean isDocument, java.lang.Integer document, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseTaskStartBean)persister).findByQBE2(isTaskType, taskType, isDocument, document, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseTaskStart create(int argTaskstart) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseTaskStart _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseTaskStartBean bean = (com.hps.july.persistence.LeaseTaskStartBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTaskstart);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argTaskstart);
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
		com.hps.july.persistence.LeaseTaskStartBean tmpEJB = (com.hps.july.persistence.LeaseTaskStartBean) generalEJB;
		com.hps.july.persistence.LeaseTaskStartKey keyClass = new com.hps.july.persistence.LeaseTaskStartKey();
		keyClass.taskstart = tmpEJB.taskstart;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseTaskStartKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseTaskStartKey keyClass = new com.hps.july.persistence.LeaseTaskStartKey();
		keyClass.taskstart = f0;
		return keyClass;
	}
}
