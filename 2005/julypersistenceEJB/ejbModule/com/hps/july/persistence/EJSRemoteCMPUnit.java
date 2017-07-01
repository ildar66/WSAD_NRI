package com.hps.july.persistence;

/**
 * EJSRemoteCMPUnit
 */
public class EJSRemoteCMPUnit extends com.hps.july.persistence.EJSRemoteCMPUnit_7609fbf2 implements Unit {
	/**
	 * EJSRemoteCMPUnit
	 */
	public EJSRemoteCMPUnit() throws java.rmi.RemoteException {
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
