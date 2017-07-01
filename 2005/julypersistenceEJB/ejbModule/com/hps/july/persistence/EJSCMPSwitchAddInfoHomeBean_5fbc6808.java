package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSwitchAddInfoHomeBean_5fbc6808
 */
public class EJSCMPSwitchAddInfoHomeBean_5fbc6808 extends EJSHome {
	/**
	 * EJSCMPSwitchAddInfoHomeBean_5fbc6808
	 */
	public EJSCMPSwitchAddInfoHomeBean_5fbc6808() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SwitchAddInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SwitchAddInfo) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.SwitchAddInfo findByPrimaryKey(com.hps.july.persistence.SwitchAddInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSwitchAddInfoBean_5fbc6808) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SwitchAddInfo create(java.lang.Integer argEquipment, java.sql.Date argAct_date) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SwitchAddInfo _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SwitchAddInfoBean bean = (com.hps.july.persistence.SwitchAddInfoBean) beanO.getEnterpriseBean();
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
	 * findSwitchAddInfosBySwitch
	 */
	public java.util.Enumeration findSwitchAddInfosBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchAddInfoBean)persister).findSwitchAddInfosBySwitch(inKey));	}
	/**
	 * findByEquipmentOrderByActdateAsc
	 */
	public java.util.Enumeration findByEquipmentOrderByActdateAsc(java.lang.Integer equipment) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchAddInfoBean)persister).findByEquipmentOrderByActdateAsc(equipment));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SwitchAddInfoBean tmpEJB = (com.hps.july.persistence.SwitchAddInfoBean) generalEJB;
		com.hps.july.persistence.SwitchAddInfoKey keyClass = new com.hps.july.persistence.SwitchAddInfoKey();
		keyClass.act_date = tmpEJB.act_date;
		keyClass.switch_storageplace = tmpEJB.switch_storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SwitchAddInfoKey keyFromFields(java.sql.Date f0, java.lang.Integer f1) {
		com.hps.july.persistence.SwitchAddInfoKey keyClass = new com.hps.july.persistence.SwitchAddInfoKey();
		keyClass.act_date = f0;
		keyClass.switch_storageplace = f1;
		return keyClass;
	}
}
