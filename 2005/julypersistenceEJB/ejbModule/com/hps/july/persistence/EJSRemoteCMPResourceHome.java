package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceHome
 */
public class EJSRemoteCMPResourceHome extends com.hps.july.persistence.EJSRemoteCMPResourceHome_5b81bc6d implements com.hps.july.persistence.ResourceHome {
	/**
	 * EJSRemoteCMPResourceHome
	 */
	public EJSRemoteCMPResourceHome() throws java.rmi.RemoteException {
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
