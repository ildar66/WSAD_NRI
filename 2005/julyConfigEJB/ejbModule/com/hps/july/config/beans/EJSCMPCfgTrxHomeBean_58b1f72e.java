package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgTrxHomeBean_58b1f72e
 */
public class EJSCMPCfgTrxHomeBean_58b1f72e extends EJSHome {
	/**
	 * EJSCMPCfgTrxHomeBean_58b1f72e
	 */
	public EJSCMPCfgTrxHomeBean_58b1f72e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgTrx postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgTrx) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgTrx create(int argSavconfigid, int argEquipment, int argTrxid, int argResource, int argStandid, java.lang.String argObjectstatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgTrx _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgTrxBean bean = (com.hps.july.config.beans.CfgTrxBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSavconfigid, argEquipment, argTrxid, argResource, argStandid, argObjectstatus);
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
	public com.hps.july.config.beans.CfgTrx findByPrimaryKey(com.hps.july.config.beans.CfgTrxKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgTrxBean_58b1f72e) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.config.beans.CfgTrxBean tmpEJB = (com.hps.july.config.beans.CfgTrxBean) generalEJB;
		com.hps.july.config.beans.CfgTrxKey keyClass = new com.hps.july.config.beans.CfgTrxKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.trxid = tmpEJB.trxid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgTrxKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgTrxKey keyClass = new com.hps.july.config.beans.CfgTrxKey();
		keyClass.savconfigid = f0;
		keyClass.trxid = f1;
		return keyClass;
	}
}
