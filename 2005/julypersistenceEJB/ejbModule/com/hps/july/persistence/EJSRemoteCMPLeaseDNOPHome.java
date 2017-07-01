package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseDNOPHome
 */
public class EJSRemoteCMPLeaseDNOPHome extends com.hps.july.persistence.EJSRemoteCMPLeaseDNOPHome_93b75ce3 implements com.hps.july.persistence.LeaseDNOPHome {
	/**
	 * EJSRemoteCMPLeaseDNOPHome
	 */
	public EJSRemoteCMPLeaseDNOPHome() throws java.rmi.RemoteException {
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
