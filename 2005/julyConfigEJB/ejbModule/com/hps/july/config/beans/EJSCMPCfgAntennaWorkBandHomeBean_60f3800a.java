package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgAntennaWorkBandHomeBean_60f3800a
 */
public class EJSCMPCfgAntennaWorkBandHomeBean_60f3800a extends EJSHome {
	/**
	 * EJSCMPCfgAntennaWorkBandHomeBean_60f3800a
	 */
	public EJSCMPCfgAntennaWorkBandHomeBean_60f3800a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAntennaWorkBand) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgAntennaWorkBand findByPrimaryKey(com.hps.july.config.beans.CfgAntennaWorkBandKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgAntennaWorkBandBean_60f3800a) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBand create(int savconfigid, int idanten, short band, java.lang.String objectStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgAntennaWorkBand _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgAntennaWorkBandBean bean = (com.hps.july.config.beans.CfgAntennaWorkBandBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, idanten, band, objectStatus);
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
		com.hps.july.config.beans.CfgAntennaWorkBandBean tmpEJB = (com.hps.july.config.beans.CfgAntennaWorkBandBean) generalEJB;
		com.hps.july.config.beans.CfgAntennaWorkBandKey keyClass = new com.hps.july.config.beans.CfgAntennaWorkBandKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.idanten = tmpEJB.idanten;
		keyClass.band = tmpEJB.band;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBandKey keyFromFields(int f0, int f1, short f2) {
		com.hps.july.config.beans.CfgAntennaWorkBandKey keyClass = new com.hps.july.config.beans.CfgAntennaWorkBandKey();
		keyClass.savconfigid = f0;
		keyClass.idanten = f1;
		keyClass.band = f2;
		return keyClass;
	}
}
