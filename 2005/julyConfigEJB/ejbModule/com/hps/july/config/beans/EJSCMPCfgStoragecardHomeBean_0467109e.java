package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgStoragecardHomeBean_0467109e
 */
public class EJSCMPCfgStoragecardHomeBean_0467109e extends EJSHome {
	/**
	 * EJSCMPCfgStoragecardHomeBean_0467109e
	 */
	public EJSCMPCfgStoragecardHomeBean_0467109e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgStoragecard postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgStoragecard) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgStoragecard findByPrimaryKey(com.hps.july.config.beans.CfgStoragecardKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgStoragecardBean_0467109e) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.config.beans.CfgStoragecard create(int savconfigid, int storagecard, int resource, java.sql.Date dateopened, int owner, java.lang.String policy, java.lang.String closed, java.math.BigDecimal qty, java.math.BigDecimal price, boolean isfictserial, boolean isapproved, java.lang.String objectstatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgStoragecard _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgStoragecardBean bean = (com.hps.july.config.beans.CfgStoragecardBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, storagecard, resource, dateopened, owner, policy, closed, qty, price, isfictserial, isapproved, objectstatus);
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
		com.hps.july.config.beans.CfgStoragecardBean tmpEJB = (com.hps.july.config.beans.CfgStoragecardBean) generalEJB;
		com.hps.july.config.beans.CfgStoragecardKey keyClass = new com.hps.july.config.beans.CfgStoragecardKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.storagecard = tmpEJB.storagecard;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgStoragecardKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgStoragecardKey keyClass = new com.hps.july.config.beans.CfgStoragecardKey();
		keyClass.savconfigid = f0;
		keyClass.storagecard = f1;
		return keyClass;
	}
}
