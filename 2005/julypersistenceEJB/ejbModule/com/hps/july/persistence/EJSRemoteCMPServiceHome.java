package com.hps.july.persistence;

/**
 * EJSRemoteCMPServiceHome
 */
public class EJSRemoteCMPServiceHome extends com.hps.july.persistence.EJSRemoteCMPServiceHome_5badf6ae implements com.hps.july.persistence.ServiceHome {
	/**
	 * EJSRemoteCMPServiceHome
	 */
	public EJSRemoteCMPServiceHome() throws java.rmi.RemoteException {
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
