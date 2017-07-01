package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPContrAddInfoHomeBean_bfd683b7
 */
public class EJSCMPContrAddInfoHomeBean_bfd683b7 extends EJSHome {
	/**
	 * EJSCMPContrAddInfoHomeBean_bfd683b7
	 */
	public EJSCMPContrAddInfoHomeBean_bfd683b7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ContrAddInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ContrAddInfo) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ContrAddInfo create(java.lang.Integer argEquipment, java.sql.Date argAct_date) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ContrAddInfo _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ContrAddInfoBean bean = (com.hps.july.persistence.ContrAddInfoBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argEquipment, argAct_date);
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
	 * findContrAddInfosByController
	 */
	public java.util.Enumeration findContrAddInfosByController(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContrAddInfoBean)persister).findContrAddInfosByController(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ContrAddInfo findByPrimaryKey(com.hps.july.persistence.ContrAddInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPContrAddInfoBean_bfd683b7) persister).findByPrimaryKey(key);
	}
	/**
	 * findByEquipmentOrderByActdateAsc
	 */
	public java.util.Enumeration findByEquipmentOrderByActdateAsc(java.lang.Integer equipment) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContrAddInfoBean)persister).findByEquipmentOrderByActdateAsc(equipment));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ContrAddInfoBean tmpEJB = (com.hps.july.persistence.ContrAddInfoBean) generalEJB;
		com.hps.july.persistence.ContrAddInfoKey keyClass = new com.hps.july.persistence.ContrAddInfoKey();
		keyClass.act_date = tmpEJB.act_date;
		keyClass.controller_storageplace = tmpEJB.controller_storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ContrAddInfoKey keyFromFields(java.sql.Date f0, java.lang.Integer f1) {
		com.hps.july.persistence.ContrAddInfoKey keyClass = new com.hps.july.persistence.ContrAddInfoKey();
		keyClass.act_date = f0;
		keyClass.controller_storageplace = f1;
		return keyClass;
	}
}
