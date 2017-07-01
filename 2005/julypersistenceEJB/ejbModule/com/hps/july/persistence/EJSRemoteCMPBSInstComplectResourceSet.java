package com.hps.july.persistence;

/**
 * EJSRemoteCMPBSInstComplectResourceSet
 */
public class EJSRemoteCMPBSInstComplectResourceSet extends com.hps.july.persistence.EJSRemoteCMPBSInstComplectResourceSet_c1bebc4d implements BSInstComplectResourceSet {
	/**
	 * EJSRemoteCMPBSInstComplectResourceSet
	 */
	public EJSRemoteCMPBSInstComplectResourceSet() throws java.rmi.RemoteException {
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
