package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPComEquipmentHomeBean_f7643898
 */
public class EJSCMPComEquipmentHomeBean_f7643898 extends EJSHome {
	/**
	 * EJSCMPComEquipmentHomeBean_f7643898
	 */
	public EJSCMPComEquipmentHomeBean_f7643898() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ComEquipment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ComEquipment) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPositionType
	 */
	public java.util.Enumeration findByPositionType(java.lang.Integer argPosition, java.lang.String argType, java.lang.Integer argOrder) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderComEquipmentBean)persister).findByPositionType(argPosition, argType, argOrder));	}
	/**
	 * findComEquipmentsByResource
	 */
	public java.util.Enumeration findComEquipmentsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderComEquipmentBean)persister).findComEquipmentsByResource(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ComEquipment create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ComEquipment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ComEquipmentBean bean = (com.hps.july.persistence.ComEquipmentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argDivision, argName, argAddress, argPosition);
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
	public com.hps.july.persistence.ComEquipment create(int argStorageplace, java.lang.Integer argDivision, java.lang.String argName, java.lang.String argAddress) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ComEquipment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ComEquipmentBean bean = (com.hps.july.persistence.ComEquipmentBean) beanO.getEnterpriseBean();
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
	public com.hps.july.persistence.ComEquipment findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPComEquipmentBean_f7643898) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ComEquipment create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ComEquipment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ComEquipmentBean bean = (com.hps.july.persistence.ComEquipmentBean) beanO.getEnterpriseBean();
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
return super.getEnumeration(((com.hps.july.persistence.EJSFinderComEquipmentBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ComEquipmentBean tmpEJB = (com.hps.july.persistence.ComEquipmentBean) generalEJB;
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
