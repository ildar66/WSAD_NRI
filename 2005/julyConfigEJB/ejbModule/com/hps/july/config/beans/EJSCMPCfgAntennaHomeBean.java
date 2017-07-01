package com.hps.july.config.beans;

/**
 * EJSCMPCfgAntennaHomeBean
 */
public class EJSCMPCfgAntennaHomeBean extends com.hps.july.config.beans.EJSCMPCfgAntennaHomeBean_245fb73a {
	/**
	 * EJSCMPCfgAntennaHomeBean
	 */
	public EJSCMPCfgAntennaHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAntenna postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAntenna) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
