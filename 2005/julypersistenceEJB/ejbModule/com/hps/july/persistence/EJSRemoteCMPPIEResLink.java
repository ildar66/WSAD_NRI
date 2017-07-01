package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEResLink
 */
public class EJSRemoteCMPPIEResLink extends com.hps.july.persistence.EJSRemoteCMPPIEResLink_3d13a75a implements PIEResLink {
	/**
	 * EJSRemoteCMPPIEResLink
	 */
	public EJSRemoteCMPPIEResLink() throws java.rmi.RemoteException {
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
