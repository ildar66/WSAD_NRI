package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgAntennaCableHomeBean_7712f699
 */
public class EJSCMPCfgAntennaCableHomeBean_7712f699 extends EJSHome {
	/**
	 * EJSCMPCfgAntennaCableHomeBean_7712f699
	 */
	public EJSCMPCfgAntennaCableHomeBean_7712f699() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAntennaCable postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAntennaCable) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgAntennaCable create(int argSavconfigid, int argIdCable, int argIdAnten, int argCableres, java.math.BigDecimal argCableLen, int argDataSource, java.lang.String argObjectStatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgAntennaCable _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgAntennaCableBean bean = (com.hps.july.config.beans.CfgAntennaCableBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSavconfigid, argIdCable, argIdAnten, argCableres, argCableLen, argDataSource, argObjectStatus);
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
	public com.hps.july.config.beans.CfgAntennaCable findByPrimaryKey(com.hps.july.config.beans.CfgAntennaCableKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgAntennaCableBean_7712f699) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.config.beans.CfgAntennaCableBean tmpEJB = (com.hps.july.config.beans.CfgAntennaCableBean) generalEJB;
		com.hps.july.config.beans.CfgAntennaCableKey keyClass = new com.hps.july.config.beans.CfgAntennaCableKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.idCable = tmpEJB.idCable;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgAntennaCableKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgAntennaCableKey keyClass = new com.hps.july.config.beans.CfgAntennaCableKey();
		keyClass.savconfigid = f0;
		keyClass.idCable = f1;
		return keyClass;
	}
}
