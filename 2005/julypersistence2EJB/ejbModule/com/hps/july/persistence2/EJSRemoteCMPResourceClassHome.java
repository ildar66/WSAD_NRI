package com.hps.july.persistence2;

/**
 * EJSRemoteCMPResourceClassHome
 */
public class EJSRemoteCMPResourceClassHome extends com.hps.july.persistence2.EJSRemoteCMPResourceClassHome_1f74a117 implements com.hps.july.persistence2.ResourceClassHome {
	/**
	 * EJSRemoteCMPResourceClassHome
	 */
	public EJSRemoteCMPResourceClassHome() throws java.rmi.RemoteException {
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
