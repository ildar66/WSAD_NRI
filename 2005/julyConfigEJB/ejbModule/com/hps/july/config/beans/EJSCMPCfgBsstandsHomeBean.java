package com.hps.july.config.beans;

/**
 * EJSCMPCfgBsstandsHomeBean
 */
public class EJSCMPCfgBsstandsHomeBean extends com.hps.july.config.beans.EJSCMPCfgBsstandsHomeBean_90a7017d {
	/**
	 * EJSCMPCfgBsstandsHomeBean
	 */
	public EJSCMPCfgBsstandsHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgBsstands postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgBsstands) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
