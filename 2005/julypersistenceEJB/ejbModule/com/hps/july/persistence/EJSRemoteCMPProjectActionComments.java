package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectActionComments
 */
public class EJSRemoteCMPProjectActionComments extends com.hps.july.persistence.EJSRemoteCMPProjectActionComments_0cd9cc41 implements ProjectActionComments {
	/**
	 * EJSRemoteCMPProjectActionComments
	 */
	public EJSRemoteCMPProjectActionComments() throws java.rmi.RemoteException {
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
