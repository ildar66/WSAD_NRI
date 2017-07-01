package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseDNOP
 */
public class EJSRemoteCMPLeaseDNOP extends com.hps.july.persistence.EJSRemoteCMPLeaseDNOP_93b75ce3 implements LeaseDNOP {
	/**
	 * EJSRemoteCMPLeaseDNOP
	 */
	public EJSRemoteCMPLeaseDNOP() throws java.rmi.RemoteException {
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
