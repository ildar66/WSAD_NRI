package com.hps.july.persistence;

/**
 * EJSRemoteCMPAccount
 */
public class EJSRemoteCMPAccount extends com.hps.july.persistence.EJSRemoteCMPAccount_d70748de implements Account {
	/**
	 * EJSRemoteCMPAccount
	 */
	public EJSRemoteCMPAccount() throws java.rmi.RemoteException {
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
