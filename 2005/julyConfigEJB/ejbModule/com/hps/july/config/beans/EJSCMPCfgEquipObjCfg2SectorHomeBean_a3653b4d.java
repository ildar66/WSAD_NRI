package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgEquipObjCfg2SectorHomeBean_a3653b4d
 */
public class EJSCMPCfgEquipObjCfg2SectorHomeBean_a3653b4d extends EJSHome {
	/**
	 * EJSCMPCfgEquipObjCfg2SectorHomeBean_a3653b4d
	 */
	public EJSCMPCfgEquipObjCfg2SectorHomeBean_a3653b4d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgEquipObjCfg2Sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgEquipObjCfg2Sector) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgEquipObjCfg2Sector create(int savconfigid, int objcfgid, int id_sect, java.lang.String objectStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgEquipObjCfg2Sector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgEquipObjCfg2SectorBean bean = (com.hps.july.config.beans.CfgEquipObjCfg2SectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, objcfgid, id_sect, objectStatus);
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
	public com.hps.july.config.beans.CfgEquipObjCfg2Sector findByPrimaryKey(com.hps.july.config.beans.CfgEquipObjCfg2SectorKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgEquipObjCfg2SectorBean_a3653b4d) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.config.beans.CfgEquipObjCfg2SectorBean tmpEJB = (com.hps.july.config.beans.CfgEquipObjCfg2SectorBean) generalEJB;
		com.hps.july.config.beans.CfgEquipObjCfg2SectorKey keyClass = new com.hps.july.config.beans.CfgEquipObjCfg2SectorKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.objcfgid = tmpEJB.objcfgid;
		keyClass.id_sect = tmpEJB.id_sect;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgEquipObjCfg2SectorKey keyFromFields(int f0, int f1, int f2) {
		com.hps.july.config.beans.CfgEquipObjCfg2SectorKey keyClass = new com.hps.july.config.beans.CfgEquipObjCfg2SectorKey();
		keyClass.savconfigid = f0;
		keyClass.objcfgid = f1;
		keyClass.id_sect = f2;
		return keyClass;
	}
}
