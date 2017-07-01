package com.hps.july.persistence2;

/**
 * EJSRemoteCMPResourceClass
 */
public class EJSRemoteCMPResourceClass extends com.hps.july.persistence2.EJSRemoteCMPResourceClass_1f74a117 implements ResourceClass {
	/**
	 * EJSRemoteCMPResourceClass
	 */
	public EJSRemoteCMPResourceClass() throws java.rmi.RemoteException {
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
