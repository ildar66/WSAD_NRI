package com.hps.july.persistence2;

/**
 * EJSRemoteCMPUserRequests
 */
public class EJSRemoteCMPUserRequests extends com.hps.july.persistence2.EJSRemoteCMPUserRequests_1c968d68 implements UserRequests {
	/**
	 * EJSRemoteCMPUserRequests
	 */
	public EJSRemoteCMPUserRequests() throws java.rmi.RemoteException {
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
