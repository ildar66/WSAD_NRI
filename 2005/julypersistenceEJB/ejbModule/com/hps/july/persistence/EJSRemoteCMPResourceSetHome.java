package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceSetHome
 */
public class EJSRemoteCMPResourceSetHome extends com.hps.july.persistence.EJSRemoteCMPResourceSetHome_bc3c01ac implements com.hps.july.persistence.ResourceSetHome {
	/**
	 * EJSRemoteCMPResourceSetHome
	 */
	public EJSRemoteCMPResourceSetHome() throws java.rmi.RemoteException {
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
