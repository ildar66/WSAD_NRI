package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPI13nActHomeBean_90887391
 */
public class EJSCMPI13nActHomeBean_90887391 extends EJSHome {
	/**
	 * EJSCMPI13nActHomeBean_90887391
	 */
	public EJSCMPI13nActHomeBean_90887391() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nAct postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nAct) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findI13nActByQBE
	 */
	public java.util.Enumeration findI13nActByQBE(java.lang.Boolean isDate, java.sql.Date argDateFrom, java.sql.Date argDateTo, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isStorage, java.lang.Integer argStorage, java.lang.Boolean isStorageType, java.lang.String storageType, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nActBean)persister).findI13nActByQBE(isDate, argDateFrom, argDateTo, isOrganization, argOrganization, isStorage, argStorage, isStorageType, storageType, order));	}
	/**
	 * findFullByStorageAfterDate
	 */
	public com.hps.july.persistence.I13nAct findFullByStorageAfterDate(java.lang.Integer storage, java.sql.Date date, java.lang.Integer butDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nActBean_90887391)persister).findFullByStorageAfterDate(storage, date, butDocument);	}
	/**
	 * findI13nActByAgregate
	 */
	public java.util.Enumeration findI13nActByAgregate(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nActBean)persister).findI13nActByAgregate(inKey));	}
	/**
	 * findI13nActTechByTechStuff
	 */
	public java.util.Enumeration findI13nActTechByTechStuff(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nActBean)persister).findI13nActTechByTechStuff(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.I13nAct findByPrimaryKey(com.hps.july.persistence.DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nActBean_90887391) persister).findByPrimaryKey(key);
	}
	/**
	 * findAssortimentByStorageProductAfterDate
	 */
	public com.hps.july.persistence.I13nAct findAssortimentByStorageProductAfterDate(java.lang.Integer storage, java.lang.Integer product, java.sql.Date date, java.lang.Integer butDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nActBean_90887391)persister).findAssortimentByStorageProductAfterDate(storage, product, date, butDocument);	}
	/**
	 * findAgregateByStorageSerialAfterDate
	 */
	public com.hps.july.persistence.I13nAct findAgregateByStorageSerialAfterDate(java.lang.String serial, java.sql.Date date, java.lang.Integer butDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nActBean_90887391)persister).findAgregateByStorageSerialAfterDate(serial, date, butDocument);	}
	/**
	 * create
	 */
	public com.hps.july.persistence.I13nAct create(int argDocument, java.lang.Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nActBean bean = (com.hps.july.persistence.I13nActBean) beanO.getEnterpriseBean();
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
	public com.hps.july.persistence.I13nAct create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Integer argStorageManager, java.lang.String argType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nActBean bean = (com.hps.july.persistence.I13nActBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, argState, argStorageManager, argType);
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
	public com.hps.july.persistence.I13nAct create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nAct _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nActBean bean = (com.hps.july.persistence.I13nActBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.I13nActBean tmpEJB = (com.hps.july.persistence.I13nActBean) generalEJB;
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
