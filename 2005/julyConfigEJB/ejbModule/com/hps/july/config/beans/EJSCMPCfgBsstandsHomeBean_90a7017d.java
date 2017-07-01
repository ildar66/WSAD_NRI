package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCfgBsstandsHomeBean_90a7017d
 */
public class EJSCMPCfgBsstandsHomeBean_90a7017d extends EJSHome {
	/**
	 * EJSCMPCfgBsstandsHomeBean_90a7017d
	 */
	public EJSCMPCfgBsstandsHomeBean_90a7017d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgBsstands postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgBsstands) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.config.beans.CfgBsstands findByPrimaryKey(com.hps.july.config.beans.CfgBsstandsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.config.beans.EJSJDBCPersisterCMPCfgBsstandsBean_90a7017d) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.config.beans.CfgBsstands create(int savconfigid, int standid, int equipment, java.lang.String objectstatus) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.config.beans.CfgBsstands _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.config.beans.CfgBsstandsBean bean = (com.hps.july.config.beans.CfgBsstandsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(savconfigid, standid, equipment, objectstatus);
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
		com.hps.july.config.beans.CfgBsstandsBean tmpEJB = (com.hps.july.config.beans.CfgBsstandsBean) generalEJB;
		com.hps.july.config.beans.CfgBsstandsKey keyClass = new com.hps.july.config.beans.CfgBsstandsKey();
		keyClass.savconfigid = tmpEJB.savconfigid;
		keyClass.standid = tmpEJB.standid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.config.beans.CfgBsstandsKey keyFromFields(int f0, int f1) {
		com.hps.july.config.beans.CfgBsstandsKey keyClass = new com.hps.july.config.beans.CfgBsstandsKey();
		keyClass.savconfigid = f0;
		keyClass.standid = f1;
		return keyClass;
	}
}
