package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEPayLink
 */
public class EJSRemoteCMPPIEPayLink extends com.hps.july.persistence.EJSRemoteCMPPIEPayLink_415658e8 implements PIEPayLink {
	/**
	 * EJSRemoteCMPPIEPayLink
	 */
	public EJSRemoteCMPPIEPayLink() throws java.rmi.RemoteException {
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
