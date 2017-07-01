package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPI13nDateSavingHomeBean_85b3cc12
 */
public class EJSCMPI13nDateSavingHomeBean_85b3cc12 extends EJSHome {
	/**
	 * EJSCMPI13nDateSavingHomeBean_85b3cc12
	 */
	public EJSCMPI13nDateSavingHomeBean_85b3cc12() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.I13nDateSaving postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.I13nDateSaving) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.I13nDateSaving create(java.lang.Integer argDocument, java.lang.Integer argStorageCard, java.sql.Date oldDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nDateSaving _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nDateSavingBean bean = (com.hps.july.persistence.I13nDateSavingBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDocument, argStorageCard, oldDate);
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
	public com.hps.july.persistence.I13nDateSaving findByPrimaryKey(com.hps.july.persistence.I13nDateSavingKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPI13nDateSavingBean_85b3cc12) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.I13nDateSaving create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.I13nDateSaving _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.I13nDateSavingBean bean = (com.hps.july.persistence.I13nDateSavingBean) beanO.getEnterpriseBean();
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
	 * findI13nDateSavingByI13nAct
	 */
	public java.util.Enumeration findI13nDateSavingByI13nAct(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nDateSavingBean)persister).findI13nDateSavingByI13nAct(inKey));	}
	/**
	 * findI13nDateSavingByStorageCard
	 */
	public java.util.Enumeration findI13nDateSavingByStorageCard(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderI13nDateSavingBean)persister).findI13nDateSavingByStorageCard(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.I13nDateSavingBean tmpEJB = (com.hps.july.persistence.I13nDateSavingBean) generalEJB;
		com.hps.july.persistence.I13nDateSavingKey keyClass = new com.hps.july.persistence.I13nDateSavingKey();
		keyClass.i13nAct_document = tmpEJB.i13nAct_document;
		keyClass.storageCard_storagecard = tmpEJB.storageCard_storagecard;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.I13nDateSavingKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.I13nDateSavingKey keyClass = new com.hps.july.persistence.I13nDateSavingKey();
		keyClass.i13nAct_document = f0;
		keyClass.storageCard_storagecard = f1;
		return keyClass;
	}
}
