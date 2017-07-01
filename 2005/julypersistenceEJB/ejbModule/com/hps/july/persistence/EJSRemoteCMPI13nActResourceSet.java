package com.hps.july.persistence;

/**
 * EJSRemoteCMPI13nActResourceSet
 */
public class EJSRemoteCMPI13nActResourceSet extends com.hps.july.persistence.EJSRemoteCMPI13nActResourceSet_1b32abe9 implements I13nActResourceSet {
	/**
	 * EJSRemoteCMPI13nActResourceSet
	 */
	public EJSRemoteCMPI13nActResourceSet() throws java.rmi.RemoteException {
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
