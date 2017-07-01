package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgAnten2SectorHomeBean_80c3a519
 */
public class EJSCMPCfgAnten2SectorHomeBean_80c3a519 extends EJSHome {
	/**
	 * EJSCMPCfgAnten2SectorHomeBean_80c3a519
	 */
	public EJSCMPCfgAnten2SectorHomeBean_80c3a519() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAnten2Sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAnten2Sector) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgAnten2Sector create(int savconfigid, int id_anten, int id_sect, int datasource, java.lang.String objectStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgAnten2Sector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgAnten2SectorBean bean = (com.hps.july.config.beans.CfgAnten2SectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, id_anten, id_sect, datasource, objectStatus);
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
	public com.hps.july.config.beans.CfgAnten2Sector findByPrimaryKey(com.hps.july.config.beans.CfgAnten2SectorKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgAnten2SectorBean_80c3a519) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.config.beans.CfgAnten2SectorBean tmpEJB = (com.hps.july.config.beans.CfgAnten2SectorBean) generalEJB;
		com.hps.july.config.beans.CfgAnten2SectorKey keyClass = new com.hps.july.config.beans.CfgAnten2SectorKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.id_anten = tmpEJB.id_anten;
		keyClass.id_sect = tmpEJB.id_sect;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgAnten2SectorKey keyFromFields(int f0, int f1, int f2) {
		com.hps.july.config.beans.CfgAnten2SectorKey keyClass = new com.hps.july.config.beans.CfgAnten2SectorKey();
		keyClass.savconfigid = f0;
		keyClass.id_anten = f1;
		keyClass.id_sect = f2;
		return keyClass;
	}
}
