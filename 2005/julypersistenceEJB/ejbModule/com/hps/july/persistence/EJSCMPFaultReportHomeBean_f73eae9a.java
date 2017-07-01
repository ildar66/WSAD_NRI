package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPFaultReportHomeBean_f73eae9a
 */
public class EJSCMPFaultReportHomeBean_f73eae9a extends EJSHome {
	/**
	 * EJSCMPFaultReportHomeBean_f73eae9a
	 */
	public EJSCMPFaultReportHomeBean_f73eae9a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.FaultReport postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.FaultReport) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findFaultReports2ByStoragecardFrom
	 */
	public java.util.Enumeration findFaultReports2ByStoragecardFrom(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderFaultReportBean)persister).findFaultReports2ByStoragecardFrom(inKey));	}
	/**
	 * findFaultReportByTechStuff
	 */
	public java.util.Enumeration findFaultReportByTechStuff(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderFaultReportBean)persister).findFaultReportByTechStuff(inKey));	}
	/**
	 * findFaultReportByEquipment
	 */
	public java.util.Enumeration findFaultReportByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderFaultReportBean)persister).findFaultReportByEquipment(inKey));	}
	/**
	 * findFaultReportByDivision
	 */
	public java.util.Enumeration findFaultReportByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderFaultReportBean)persister).findFaultReportByDivision(inKey));	}
	/**
	 * findFaultReports1ByOldagregate
	 */
	public java.util.Enumeration findFaultReports1ByOldagregate(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderFaultReportBean)persister).findFaultReports1ByOldagregate(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.FaultReport findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPFaultReportBean_f73eae9a) persister).findByPrimaryKey(key);
	}
	/**
	 * findDocumentByQBE
	 */
	public java.util.Enumeration findDocumentByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorageFrom, java.lang.Integer storageFrom, java.lang.Boolean isStorageTo, java.lang.Integer storageTo) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderFaultReportBean)persister).findDocumentByQBE(isDate, datefrom, dateto, isOrganization, organization, isStorageFrom, storageFrom, isStorageTo, storageTo));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.FaultReport create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.FaultReport _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.FaultReportBean bean = (com.hps.july.persistence.FaultReportBean) beanO.getEnterpriseBean();
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
	 * create
	 */
	public com.hps.july.persistence.FaultReport create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argDivision, java.lang.Integer argTechStuff, java.lang.String argEqPlace, java.lang.String argOldSerial) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.FaultReport _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.FaultReportBean bean = (com.hps.july.persistence.FaultReportBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination, argDivision, argTechStuff, argEqPlace, argOldSerial);
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
	public java.util.Enumeration findByQBE(java.lang.Boolean useDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean useOwner, java.lang.Integer owner, java.lang.Boolean useDivision, java.lang.Integer division, java.lang.Boolean useWorker, java.lang.Integer worker, java.lang.Boolean usePosition, java.lang.Integer position, java.lang.Boolean useResource, java.lang.Integer resource, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderFaultReportBean)persister).findByQBE(useDate, datefrom, dateto, useOwner, owner, useDivision, division, useWorker, worker, usePosition, position, useResource, resource, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.FaultReport create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.FaultReport _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.FaultReportBean bean = (com.hps.july.persistence.FaultReportBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.FaultReportBean tmpEJB = (com.hps.july.persistence.FaultReportBean) generalEJB;
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
