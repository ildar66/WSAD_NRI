package com.hps.july.config.beans;

/**
 * EJSCMPCfgAntennaCableHomeBean
 */
public class EJSCMPCfgAntennaCableHomeBean extends com.hps.july.config.beans.EJSCMPCfgAntennaCableHomeBean_7712f699 {
	/**
	 * EJSCMPCfgAntennaCableHomeBean
	 */
	public EJSCMPCfgAntennaCableHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAntennaCable postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAntennaCable) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
