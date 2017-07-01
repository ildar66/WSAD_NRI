package com.hps.july.persistence;

/**
 * EJSRemoteCMPInventoryNumbers
 */
public class EJSRemoteCMPInventoryNumbers extends com.hps.july.persistence.EJSRemoteCMPInventoryNumbers_bc436f0d implements InventoryNumbers {
	/**
	 * EJSRemoteCMPInventoryNumbers
	 */
	public EJSRemoteCMPInventoryNumbers() throws java.rmi.RemoteException {
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
