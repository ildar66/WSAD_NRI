package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgTrx2SectorHomeBean_d03b763f
 */
public class EJSCMPCfgTrx2SectorHomeBean_d03b763f extends EJSHome {
	/**
	 * EJSCMPCfgTrx2SectorHomeBean_d03b763f
	 */
	public EJSCMPCfgTrx2SectorHomeBean_d03b763f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgTrx2Sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgTrx2Sector) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgTrx2Sector findByPrimaryKey(com.hps.july.config.beans.CfgTrx2SectorKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgTrx2SectorBean_d03b763f) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.config.beans.CfgTrx2Sector create(int savconfigid, int trxid, int id_sect, java.lang.String objectstatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgTrx2Sector _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgTrx2SectorBean bean = (com.hps.july.config.beans.CfgTrx2SectorBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, trxid, id_sect, objectstatus);
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
		com.hps.july.config.beans.CfgTrx2SectorBean tmpEJB = (com.hps.july.config.beans.CfgTrx2SectorBean) generalEJB;
		com.hps.july.config.beans.CfgTrx2SectorKey keyClass = new com.hps.july.config.beans.CfgTrx2SectorKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.trxid = tmpEJB.trxid;
		keyClass.id_sect = tmpEJB.id_sect;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgTrx2SectorKey keyFromFields(int f0, int f1, int f2) {
		com.hps.july.config.beans.CfgTrx2SectorKey keyClass = new com.hps.july.config.beans.CfgTrx2SectorKey();
		keyClass.savconfigid = f0;
		keyClass.trxid = f1;
		keyClass.id_sect = f2;
		return keyClass;
	}
}