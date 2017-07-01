package com.hps.july.persistence;

/**
 * EJSRemoteCMPRegion
 */
public class EJSRemoteCMPRegion extends com.hps.july.persistence.EJSRemoteCMPRegion_e2bb4e3f implements Region {
	/**
	 * EJSRemoteCMPRegion
	 */
	public EJSRemoteCMPRegion() throws java.rmi.RemoteException {
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
