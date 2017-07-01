package com.hps.july.config.beans;

/**
 * EJSCMPCfgStoragecardHomeBean
 */
public class EJSCMPCfgStoragecardHomeBean extends com.hps.july.config.beans.EJSCMPCfgStoragecardHomeBean_0467109e {
	/**
	 * EJSCMPCfgStoragecardHomeBean
	 */
	public EJSCMPCfgStoragecardHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgStoragecard postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgStoragecard) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
