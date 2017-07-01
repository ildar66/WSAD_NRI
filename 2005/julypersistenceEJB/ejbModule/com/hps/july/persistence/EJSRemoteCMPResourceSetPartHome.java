package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceSetPartHome
 */
public class EJSRemoteCMPResourceSetPartHome extends com.hps.july.persistence.EJSRemoteCMPResourceSetPartHome_6281eecd implements com.hps.july.persistence.ResourceSetPartHome {
	/**
	 * EJSRemoteCMPResourceSetPartHome
	 */
	public EJSRemoteCMPResourceSetPartHome() throws java.rmi.RemoteException {
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
