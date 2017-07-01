package com.hps.july.persistence2;

/**
 * EJSRemoteCMPGroup2Resource
 */
public class EJSRemoteCMPGroup2Resource extends com.hps.july.persistence2.EJSRemoteCMPGroup2Resource_ebda9379 implements Group2Resource {
	/**
	 * EJSRemoteCMPGroup2Resource
	 */
	public EJSRemoteCMPGroup2Resource() throws java.rmi.RemoteException {
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
