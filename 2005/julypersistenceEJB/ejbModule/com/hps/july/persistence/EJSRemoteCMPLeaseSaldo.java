package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseSaldo
 */
public class EJSRemoteCMPLeaseSaldo extends com.hps.july.persistence.EJSRemoteCMPLeaseSaldo_6f33cd6c implements LeaseSaldo {
	/**
	 * EJSRemoteCMPLeaseSaldo
	 */
	public EJSRemoteCMPLeaseSaldo() throws java.rmi.RemoteException {
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
