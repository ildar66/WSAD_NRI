package com.hps.july.persistence2;

/**
 * EJSRemoteCMPResourceSetClassHome
 */
public class EJSRemoteCMPResourceSetClassHome extends com.hps.july.persistence2.EJSRemoteCMPResourceSetClassHome_ec9cb440 implements com.hps.july.persistence2.ResourceSetClassHome {
	/**
	 * EJSRemoteCMPResourceSetClassHome
	 */
	public EJSRemoteCMPResourceSetClassHome() throws java.rmi.RemoteException {
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
