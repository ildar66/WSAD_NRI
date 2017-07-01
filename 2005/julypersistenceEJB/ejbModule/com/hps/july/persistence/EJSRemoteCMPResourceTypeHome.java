package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceTypeHome
 */
public class EJSRemoteCMPResourceTypeHome extends com.hps.july.persistence.EJSRemoteCMPResourceTypeHome_482c8901 implements com.hps.july.persistence.ResourceTypeHome {
	/**
	 * EJSRemoteCMPResourceTypeHome
	 */
	public EJSRemoteCMPResourceTypeHome() throws java.rmi.RemoteException {
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
