package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgEquipObjectsCfgHomeBean_087e3fc2
 */
public class EJSCMPCfgEquipObjectsCfgHomeBean_087e3fc2 extends EJSHome {
	/**
	 * EJSCMPCfgEquipObjectsCfgHomeBean_087e3fc2
	 */
	public EJSCMPCfgEquipObjectsCfgHomeBean_087e3fc2() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfg postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgEquipObjectsCfg) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgEquipObjectsCfg findByPrimaryKey(com.hps.july.config.beans.CfgEquipObjectsCfgKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgEquipObjectsCfgBean_087e3fc2) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfg create(int savconfigid, int objcfgid, int equipment, java.lang.String objectstatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgEquipObjectsCfg _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgEquipObjectsCfgBean bean = (com.hps.july.config.beans.CfgEquipObjectsCfgBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, objcfgid, equipment, objectstatus);
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
		com.hps.july.config.beans.CfgEquipObjectsCfgBean tmpEJB = (com.hps.july.config.beans.CfgEquipObjectsCfgBean) generalEJB;
		com.hps.july.config.beans.CfgEquipObjectsCfgKey keyClass = new com.hps.july.config.beans.CfgEquipObjectsCfgKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.objcfgid = tmpEJB.objcfgid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfgKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgEquipObjectsCfgKey keyClass = new com.hps.july.config.beans.CfgEquipObjectsCfgKey();
		keyClass.savconfigid = f0;
		keyClass.objcfgid = f1;
		return keyClass;
	}
}
