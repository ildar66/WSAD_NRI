package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseSaldoHome
 */
public class EJSRemoteCMPLeaseSaldoHome extends com.hps.july.persistence.EJSRemoteCMPLeaseSaldoHome_6f33cd6c implements com.hps.july.persistence.LeaseSaldoHome {
	/**
	 * EJSRemoteCMPLeaseSaldoHome
	 */
	public EJSRemoteCMPLeaseSaldoHome() throws java.rmi.RemoteException {
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
