package com.hps.july.persistence;

/**
 * EJSRemoteCMPSuperRegion
 */
public class EJSRemoteCMPSuperRegion extends com.hps.july.persistence.EJSRemoteCMPSuperRegion_2c43a25d implements SuperRegion {
	/**
	 * EJSRemoteCMPSuperRegion
	 */
	public EJSRemoteCMPSuperRegion() throws java.rmi.RemoteException {
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
