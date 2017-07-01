package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceTaxe
 */
public class EJSRemoteCMPResourceTaxe extends com.hps.july.persistence.EJSRemoteCMPResourceTaxe_b32c2e5e implements ResourceTaxe {
	/**
	 * EJSRemoteCMPResourceTaxe
	 */
	public EJSRemoteCMPResourceTaxe() throws java.rmi.RemoteException {
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
