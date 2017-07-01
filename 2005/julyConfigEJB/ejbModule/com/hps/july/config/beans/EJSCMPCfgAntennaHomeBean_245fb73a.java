package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgAntennaHomeBean_245fb73a
 */
public class EJSCMPCfgAntennaHomeBean_245fb73a extends EJSHome {
	/**
	 * EJSCMPCfgAntennaHomeBean_245fb73a
	 */
	public EJSCMPCfgAntennaHomeBean_245fb73a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAntenna postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAntenna) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgAntenna create(int savconfigid, int id_anten, int resource, java.lang.String num_ant, java.lang.String kind_ant, java.math.BigDecimal nakl, java.math.BigDecimal az_ant, java.math.BigDecimal h_set1, java.math.BigDecimal len_cable, int equipment, boolean byhand, java.lang.String locationtype, int datasource, java.lang.String objectstatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgAntenna _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgAntennaBean bean = (com.hps.july.config.beans.CfgAntennaBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, id_anten, resource, num_ant, kind_ant, nakl, az_ant, h_set1, len_cable, equipment, byhand, locationtype, datasource, objectstatus);
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
	public com.hps.july.config.beans.CfgAntenna findByPrimaryKey(com.hps.july.config.beans.CfgAntennaKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgAntennaBean_245fb73a) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.config.beans.CfgAntennaBean tmpEJB = (com.hps.july.config.beans.CfgAntennaBean) generalEJB;
		com.hps.july.config.beans.CfgAntennaKey keyClass = new com.hps.july.config.beans.CfgAntennaKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.id_anten = tmpEJB.id_anten;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgAntennaKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgAntennaKey keyClass = new com.hps.july.config.beans.CfgAntennaKey();
		keyClass.savconfigid = f0;
		keyClass.id_anten = f1;
		return keyClass;
	}
}
