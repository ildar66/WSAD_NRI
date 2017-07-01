package com.hps.july.config.beans;

/**
 * EJSCMPCfgAnten2SectorHomeBean
 */
public class EJSCMPCfgAnten2SectorHomeBean extends com.hps.july.config.beans.EJSCMPCfgAnten2SectorHomeBean_80c3a519 {
	/**
	 * EJSCMPCfgAnten2SectorHomeBean
	 */
	public EJSCMPCfgAnten2SectorHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAnten2Sector postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAnten2Sector) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
