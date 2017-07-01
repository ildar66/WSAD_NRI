package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseMutualContracts
 */
public class EJSRemoteCMPLeaseMutualContracts extends com.hps.july.persistence.EJSRemoteCMPLeaseMutualContracts_0dc94a49 implements LeaseMutualContracts {
	/**
	 * EJSRemoteCMPLeaseMutualContracts
	 */
	public EJSRemoteCMPLeaseMutualContracts() throws java.rmi.RemoteException {
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
