package com.hps.july.config.beans;

/**
 * EJSCMPCfgSectorHomeBean
 */
public class EJSCMPCfgSectorHomeBean extends com.hps.july.config.beans.EJSCMPCfgSectorHomeBean_30c46d37 {
	/**
	 * EJSCMPCfgSectorHomeBean
	 */
	public EJSCMPCfgSectorHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgSector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgSector) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
