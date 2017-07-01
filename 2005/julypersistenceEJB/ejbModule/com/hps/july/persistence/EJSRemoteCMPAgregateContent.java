package com.hps.july.persistence;

/**
 * EJSRemoteCMPAgregateContent
 */
public class EJSRemoteCMPAgregateContent extends com.hps.july.persistence.EJSRemoteCMPAgregateContent_d4664c44 implements AgregateContent {
	/**
	 * EJSRemoteCMPAgregateContent
	 */
	public EJSRemoteCMPAgregateContent() throws java.rmi.RemoteException {
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
