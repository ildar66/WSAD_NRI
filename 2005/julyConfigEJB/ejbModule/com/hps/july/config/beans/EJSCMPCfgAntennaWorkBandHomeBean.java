package com.hps.july.config.beans;

/**
 * EJSCMPCfgAntennaWorkBandHomeBean
 */
public class EJSCMPCfgAntennaWorkBandHomeBean extends com.hps.july.config.beans.EJSCMPCfgAntennaWorkBandHomeBean_60f3800a {
	/**
	 * EJSCMPCfgAntennaWorkBandHomeBean
	 */
	public EJSCMPCfgAntennaWorkBandHomeBean() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBand postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.config.beans.CfgAntennaWorkBand) super.postCreate(beanO, ejsKey);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
	}
}
