package com.hps.july.config.beans;

/**
 * EJSCMPCfgBasestationHomeBean
 */
public class EJSCMPCfgBasestationHomeBean extends com.hps.july.config.beans.EJSCMPCfgBasestationHomeBean_711824dd {
	/**
	 * EJSCMPCfgBasestationHomeBean
	 */
	public EJSCMPCfgBasestationHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgBasestation postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgBasestation) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
