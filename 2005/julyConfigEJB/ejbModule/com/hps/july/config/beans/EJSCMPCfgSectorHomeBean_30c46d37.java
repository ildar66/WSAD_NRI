package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgSectorHomeBean_30c46d37
 */
public class EJSCMPCfgSectorHomeBean_30c46d37 extends EJSHome {
	/**
	 * EJSCMPCfgSectorHomeBean_30c46d37
	 */
	public EJSCMPCfgSectorHomeBean_30c46d37() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgSector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgSector) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgSector findByPrimaryKey(com.hps.july.config.beans.CfgSectorKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgSectorBean_30c46d37) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.config.beans.CfgSector create(int savconfigid, int id_sect, int equipment, java.lang.String name_sect, short band, java.lang.String num_sect, int datasource, java.lang.String objectstatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgSector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgSectorBean bean = (com.hps.july.config.beans.CfgSectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, id_sect, equipment, name_sect, band, num_sect, datasource, objectstatus);
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
		com.hps.july.config.beans.CfgSectorBean tmpEJB = (com.hps.july.config.beans.CfgSectorBean) generalEJB;
		com.hps.july.config.beans.CfgSectorKey keyClass = new com.hps.july.config.beans.CfgSectorKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.id_sect = tmpEJB.id_sect;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgSectorKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgSectorKey keyClass = new com.hps.july.config.beans.CfgSectorKey();
		keyClass.savconfigid = f0;
		keyClass.id_sect = f1;
		return keyClass;
	}
}
