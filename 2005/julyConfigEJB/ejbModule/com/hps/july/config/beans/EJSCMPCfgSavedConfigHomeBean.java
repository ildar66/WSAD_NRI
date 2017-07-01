package com.hps.july.config.beans;

/**
 * EJSCMPCfgSavedConfigHomeBean
 */
public class EJSCMPCfgSavedConfigHomeBean extends com.hps.july.config.beans.EJSCMPCfgSavedConfigHomeBean_6e49ac1d {
	/**
	 * EJSCMPCfgSavedConfigHomeBean
	 */
	public EJSCMPCfgSavedConfigHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgSavedConfig postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgSavedConfig) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
