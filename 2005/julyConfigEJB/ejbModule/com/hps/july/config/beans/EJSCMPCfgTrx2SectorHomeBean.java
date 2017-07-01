package com.hps.july.config.beans;

/**
 * EJSCMPCfgTrx2SectorHomeBean
 */
public class EJSCMPCfgTrx2SectorHomeBean extends com.hps.july.config.beans.EJSCMPCfgTrx2SectorHomeBean_d03b763f {
	/**
	 * EJSCMPCfgTrx2SectorHomeBean
	 */
	public EJSCMPCfgTrx2SectorHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgTrx2Sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgTrx2Sector) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
