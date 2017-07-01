package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIESerialResLink
 */
public class EJSRemoteCMPPIESerialResLink extends com.hps.july.persistence.EJSRemoteCMPPIESerialResLink_1a05d9b3 implements PIESerialResLink {
	/**
	 * EJSRemoteCMPPIESerialResLink
	 */
	public EJSRemoteCMPPIESerialResLink() throws java.rmi.RemoteException {
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
