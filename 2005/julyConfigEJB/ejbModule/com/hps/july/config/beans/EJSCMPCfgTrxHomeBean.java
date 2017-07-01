package com.hps.july.config.beans;

/**
 * EJSCMPCfgTrxHomeBean
 */
public class EJSCMPCfgTrxHomeBean extends com.hps.july.config.beans.EJSCMPCfgTrxHomeBean_58b1f72e {
	/**
	 * EJSCMPCfgTrxHomeBean
	 */
	public EJSCMPCfgTrxHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgTrx postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgTrx) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
