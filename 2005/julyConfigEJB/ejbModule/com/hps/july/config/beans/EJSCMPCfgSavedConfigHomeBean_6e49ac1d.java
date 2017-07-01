package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgSavedConfigHomeBean_6e49ac1d
 */
public class EJSCMPCfgSavedConfigHomeBean_6e49ac1d extends EJSHome {
	/**
	 * EJSCMPCfgSavedConfigHomeBean_6e49ac1d
	 */
	public EJSCMPCfgSavedConfigHomeBean_6e49ac1d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgSavedConfig postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgSavedConfig) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgSavedConfig create(int savconfigid, java.lang.String name) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgSavedConfig _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgSavedConfigBean bean = (com.hps.july.config.beans.CfgSavedConfigBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, name);
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
	public com.hps.july.config.beans.CfgSavedConfig findByPrimaryKey(com.hps.july.config.beans.CfgSavedConfigKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgSavedConfigBean_6e49ac1d) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.config.beans.CfgSavedConfigBean tmpEJB = (com.hps.july.config.beans.CfgSavedConfigBean) generalEJB;
		com.hps.july.config.beans.CfgSavedConfigKey keyClass = new com.hps.july.config.beans.CfgSavedConfigKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgSavedConfigKey keyFromFields(int f0) {
		com.hps.july.config.beans.CfgSavedConfigKey keyClass = new com.hps.july.config.beans.CfgSavedConfigKey();
		keyClass.savconfigid = f0;
		return keyClass;
	}
}
