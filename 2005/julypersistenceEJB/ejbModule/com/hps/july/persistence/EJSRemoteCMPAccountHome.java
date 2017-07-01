package com.hps.july.persistence;

/**
 * EJSRemoteCMPAccountHome
 */
public class EJSRemoteCMPAccountHome extends com.hps.july.persistence.EJSRemoteCMPAccountHome_d70748de implements com.hps.july.persistence.AccountHome {
	/**
	 * EJSRemoteCMPAccountHome
	 */
	public EJSRemoteCMPAccountHome() throws java.rmi.RemoteException {
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
