package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceSet
 */
public class EJSRemoteCMPResourceSet extends com.hps.july.persistence.EJSRemoteCMPResourceSet_bc3c01ac implements ResourceSet {
	/**
	 * EJSRemoteCMPResourceSet
	 */
	public EJSRemoteCMPResourceSet() throws java.rmi.RemoteException {
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
