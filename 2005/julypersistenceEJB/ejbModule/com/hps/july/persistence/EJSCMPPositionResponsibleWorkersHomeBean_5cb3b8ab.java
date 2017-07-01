package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPositionResponsibleWorkersHomeBean_5cb3b8ab
 */
public class EJSCMPPositionResponsibleWorkersHomeBean_5cb3b8ab extends EJSHome {
	/**
	 * EJSCMPPositionResponsibleWorkersHomeBean_5cb3b8ab
	 */
	public EJSCMPPositionResponsibleWorkersHomeBean_5cb3b8ab() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PositionResponsibleWorkers postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PositionResponsibleWorkers) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPosition
	 */
	public java.util.Enumeration findByPosition(java.lang.Integer argStoragePlace) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findByPosition(argStoragePlace));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PositionResponsibleWorkers create(java.lang.Integer argType, java.lang.Integer argWorker, java.lang.Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PositionResponsibleWorkers _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PositionResponsibleWorkersBean bean = (com.hps.july.persistence.PositionResponsibleWorkersBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argType, argWorker, argPosition);
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
	public java.util.Enumeration findByQBE(java.lang.Boolean isStorageplace, java.lang.Integer storageplace, java.lang.Boolean isType, java.lang.Integer type, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findByQBE(isStorageplace, storageplace, isType, type, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PositionResponsibleWorkers findByPrimaryKey(com.hps.july.persistence.PositionResponsibleWorkersKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPositionResponsibleWorkersBean_5cb3b8ab) persister).findByPrimaryKey(key);
	}
	/**
	 * findPositionResponsibleWorkerByOrganization
	 */
	public java.util.Enumeration findPositionResponsibleWorkerByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findPositionResponsibleWorkerByOrganization(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PositionResponsibleWorkers create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PositionResponsibleWorkers _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PositionResponsibleWorkersBean bean = (com.hps.july.persistence.PositionResponsibleWorkersBean) beanO.getEnterpriseBean();
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
	 * create
	 */
	public com.hps.july.persistence.PositionResponsibleWorkers create(java.lang.Integer argType, java.lang.Integer argPosition, java.lang.String argResptype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PositionResponsibleWorkers _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PositionResponsibleWorkersBean bean = (com.hps.july.persistence.PositionResponsibleWorkersBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argType, argPosition, argResptype);
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
	 * findPositionResponsibleWorkersByType
	 */
	public java.util.Enumeration findPositionResponsibleWorkersByType(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findPositionResponsibleWorkersByType(inKey));	}
	/**
	 * findPositionResponsibleWorkersByPosition
	 */
	public java.util.Enumeration findPositionResponsibleWorkersByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findPositionResponsibleWorkersByPosition(inKey));	}
	/**
	 * findByPositionResptype
	 */
	public java.util.Enumeration findByPositionResptype(java.lang.Integer argStoragePlace, java.lang.String argResptype) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findByPositionResptype(argStoragePlace, argResptype));	}
	/**
	 * findAllOrderByCodeAsc
	 */
	public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findAllOrderByCodeAsc());	}
	/**
	 * findPositionResponsibleWorkersByWorker
	 */
	public java.util.Enumeration findPositionResponsibleWorkersByWorker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findPositionResponsibleWorkersByWorker(inKey));	}
	/**
	 * findByPositionResponseType
	 */
	public java.util.Enumeration findByPositionResponseType(java.lang.Integer argStoragePlace, java.lang.Integer argRespType) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionResponsibleWorkersBean)persister).findByPositionResponseType(argStoragePlace, argRespType));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PositionResponsibleWorkersBean tmpEJB = (com.hps.july.persistence.PositionResponsibleWorkersBean) generalEJB;
		com.hps.july.persistence.PositionResponsibleWorkersKey keyClass = new com.hps.july.persistence.PositionResponsibleWorkersKey();
		keyClass.resptype = tmpEJB.resptype;
		keyClass.type_responsibilityType = tmpEJB.type_responsibilityType;
		keyClass.position_storageplace = tmpEJB.position_storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PositionResponsibleWorkersKey keyFromFields(java.lang.String f0, java.lang.Integer f1, java.lang.Integer f2) {
		com.hps.july.persistence.PositionResponsibleWorkersKey keyClass = new com.hps.july.persistence.PositionResponsibleWorkersKey();
		keyClass.resptype = f0;
		keyClass.type_responsibilityType = f1;
		keyClass.position_storageplace = f2;
		return keyClass;
	}
}
