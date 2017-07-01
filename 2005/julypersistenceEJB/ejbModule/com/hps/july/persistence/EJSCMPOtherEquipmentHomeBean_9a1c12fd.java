package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPOtherEquipmentHomeBean_9a1c12fd
 */
public class EJSCMPOtherEquipmentHomeBean_9a1c12fd extends EJSHome {
	/**
	 * EJSCMPOtherEquipmentHomeBean_9a1c12fd
	 */
	public EJSCMPOtherEquipmentHomeBean_9a1c12fd() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.OtherEquipment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.OtherEquipment) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.OtherEquipment create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition, java.lang.String argType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OtherEquipment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OtherEquipmentBean bean = (com.hps.july.persistence.OtherEquipmentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argDivision, argName, argAddress, argPosition, argType);
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
	public com.hps.july.persistence.OtherEquipment create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OtherEquipment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OtherEquipmentBean bean = (com.hps.july.persistence.OtherEquipmentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argDivision, argName, argAddress);
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
	public com.hps.july.persistence.OtherEquipment findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPOtherEquipmentBean_9a1c12fd) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.OtherEquipment create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.OtherEquipment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.OtherEquipmentBean bean = (com.hps.july.persistence.OtherEquipmentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argStorageplace);
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
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderOtherEquipmentBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.OtherEquipmentBean tmpEJB = (com.hps.july.persistence.OtherEquipmentBean) generalEJB;
		com.hps.july.persistence.StoragePlaceKey keyClass = new com.hps.july.persistence.StoragePlaceKey();
		keyClass.storageplace = tmpEJB.storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.StoragePlaceKey keyFromFields(int f0) {
		com.hps.july.persistence.StoragePlaceKey keyClass = new com.hps.july.persistence.StoragePlaceKey();
		keyClass.storageplace = f0;
		return keyClass;
	}
}
