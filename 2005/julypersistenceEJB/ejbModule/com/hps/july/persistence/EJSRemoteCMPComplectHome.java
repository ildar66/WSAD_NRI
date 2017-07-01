package com.hps.july.persistence;

/**
 * EJSRemoteCMPComplectHome
 */
public class EJSRemoteCMPComplectHome extends com.hps.july.persistence.EJSRemoteCMPComplectHome_a8aaa080 implements com.hps.july.persistence.ComplectHome {
	/**
	 * EJSRemoteCMPComplectHome
	 */
	public EJSRemoteCMPComplectHome() throws java.rmi.RemoteException {
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
