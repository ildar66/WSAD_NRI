package com.hps.july.persistence;

/**
 * EJSRemoteCMPSuperRegionAcc
 */
public class EJSRemoteCMPSuperRegionAcc extends com.hps.july.persistence.EJSRemoteCMPSuperRegionAcc_7cebb5ee implements SuperRegionAcc {
	/**
	 * EJSRemoteCMPSuperRegionAcc
	 */
	public EJSRemoteCMPSuperRegionAcc() throws java.rmi.RemoteException {
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
