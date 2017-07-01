package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgBasestationHomeBean_711824dd
 */
public class EJSCMPCfgBasestationHomeBean_711824dd extends EJSHome {
	/**
	 * EJSCMPCfgBasestationHomeBean_711824dd
	 */
	public EJSCMPCfgBasestationHomeBean_711824dd() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgBasestation postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgBasestation) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgBasestation findByPrimaryKey(com.hps.july.config.beans.CfgBasestationKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgBasestationBean_711824dd) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.config.beans.CfgBasestation create(int argSavconfigid, int argEquipment, java.lang.String argType, boolean argRepeater, int argNumber, java.lang.String argName, java.lang.String argObjectStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgBasestation _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgBasestationBean bean = (com.hps.july.config.beans.CfgBasestationBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSavconfigid, argEquipment, argType, argRepeater, argNumber, argName, argObjectStatus);
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
		com.hps.july.config.beans.CfgBasestationBean tmpEJB = (com.hps.july.config.beans.CfgBasestationBean) generalEJB;
		com.hps.july.config.beans.CfgBasestationKey keyClass = new com.hps.july.config.beans.CfgBasestationKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.equipment = tmpEJB.equipment;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgBasestationKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgBasestationKey keyClass = new com.hps.july.config.beans.CfgBasestationKey();
		keyClass.savconfigid = f0;
		keyClass.equipment = f1;
		return keyClass;
	}
}
