package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPEquipManufacturerHomeBean_e49c88d8
 */
public class EJSCMPEquipManufacturerHomeBean_e49c88d8 extends EJSHome {
	/**
	 * EJSCMPEquipManufacturerHomeBean_e49c88d8
	 */
	public EJSCMPEquipManufacturerHomeBean_e49c88d8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.EquipManufacturer postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.EquipManufacturer) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.EquipManufacturer findByPrimaryKey(java.lang.Integer primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPEquipManufacturerBean_e49c88d8) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.EquipManufacturer create(java.lang.Integer manufid, java.lang.String name, java.lang.String shortname) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.EquipManufacturer _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.EquipManufacturerBean bean = (com.hps.july.persistence2.EquipManufacturerBean) beanO.getEnterpriseBean();
			bean.ejbCreate(manufid, name, shortname);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.EquipManufacturerBean tmpEJB = (com.hps.july.persistence2.EquipManufacturerBean) generalEJB;
		return tmpEJB.manufid;
	}
	/**
	 * keyFromFields
	 */
	public java.lang.Integer keyFromFields(java.lang.Integer f0) {
		return f0;
	}
}
