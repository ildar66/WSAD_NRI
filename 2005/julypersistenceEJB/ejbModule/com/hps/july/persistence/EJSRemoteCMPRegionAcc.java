package com.hps.july.persistence;

/**
 * EJSRemoteCMPRegionAcc
 */
public class EJSRemoteCMPRegionAcc extends com.hps.july.persistence.EJSRemoteCMPRegionAcc_7d950a32 implements RegionAcc {
	/**
	 * EJSRemoteCMPRegionAcc
	 */
	public EJSRemoteCMPRegionAcc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return new com.ibm.ejs.container.EJSDeployedSupport();
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		return;
	}
}
