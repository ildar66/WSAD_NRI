package com.hps.july.persistence;

/**
 * EJSRemoteCMPCurrency
 */
public class EJSRemoteCMPCurrency extends com.hps.july.persistence.EJSRemoteCMPCurrency_bce2196f implements Currency {
	/**
	 * EJSRemoteCMPCurrency
	 */
	public EJSRemoteCMPCurrency() throws java.rmi.RemoteException {
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
