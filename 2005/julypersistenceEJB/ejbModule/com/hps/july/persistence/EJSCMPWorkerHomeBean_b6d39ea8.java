package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPWorkerHomeBean_b6d39ea8
 */
public class EJSCMPWorkerHomeBean_b6d39ea8 extends EJSHome {
	/**
	 * EJSCMPWorkerHomeBean_b6d39ea8
	 */
	public EJSCMPWorkerHomeBean_b6d39ea8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Worker postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Worker) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Worker findByPrimaryKey(com.hps.july.persistence.WorkerKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPWorkerBean_b6d39ea8) persister).findByPrimaryKey(key);
	}
	/**
	 * findWorkersByMan
	 */
	public java.util.Enumeration findWorkersByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findWorkersByMan(inKey));	}
	/**
	 * findWorkersByDivision
	 */
	public java.util.Enumeration findWorkersByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findWorkersByDivision(inKey));	}
	/**
	 * findByLastNameOrderByLastNameAsc
	 */
	public java.util.Enumeration findByLastNameOrderByLastNameAsc(java.lang.String name) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findByLastNameOrderByLastNameAsc(name));	}
	/**
	 * findAlienWorkers
	 */
	public java.util.Enumeration findAlienWorkers(java.lang.Integer organization, java.lang.String family) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findAlienWorkers(organization, family));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Worker create(int argWorker, java.lang.Integer argMan, java.lang.Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Worker _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.WorkerBean bean = (com.hps.july.persistence.WorkerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argWorker, argMan, argPosition);
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
	public com.hps.july.persistence.Worker create(int argWorker, java.lang.Integer argMan, java.lang.Integer argPosition, java.lang.Boolean argIsour, java.lang.Boolean argIsservicestuff) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Worker _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.WorkerBean bean = (com.hps.july.persistence.WorkerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argWorker, argMan, argPosition, argIsour, argIsservicestuff);
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
	 * findWorkersByPosition
	 */
	public java.util.Enumeration findWorkersByPosition(com.hps.july.persistence.WorkPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findWorkersByPosition(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isDivision, java.lang.Integer argDivision, java.lang.Boolean isLastName, java.lang.String argLastName, java.lang.Boolean isActive, java.lang.Boolean argActive, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findByQBE(isDivision, argDivision, isLastName, argLastName, isActive, argActive, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Worker create(int argWorker) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Worker _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.WorkerBean bean = (com.hps.july.persistence.WorkerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argWorker);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argWorker);
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
	 * findWorkersByOrganization
	 */
	public java.util.Enumeration findWorkersByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findWorkersByOrganization(inKey));	}
	/**
	 * findWorkersByCompany
	 */
	public java.util.Enumeration findWorkersByCompany(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderWorkerBean)persister).findWorkersByCompany(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.WorkerBean tmpEJB = (com.hps.july.persistence.WorkerBean) generalEJB;
		com.hps.july.persistence.WorkerKey keyClass = new com.hps.july.persistence.WorkerKey();
		keyClass.worker = tmpEJB.worker;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.WorkerKey keyFromFields(int f0) {
		com.hps.july.persistence.WorkerKey keyClass = new com.hps.july.persistence.WorkerKey();
		keyClass.worker = f0;
		return keyClass;
	}
}
