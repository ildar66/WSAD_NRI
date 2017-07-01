package com.hps.july.platinum.sessionbean;

/**
 * EJSRemoteStatelessPlatinumProcessor
 */
public class EJSRemoteStatelessPlatinumProcessor extends com.hps.july.platinum.sessionbean.EJSRemoteStatelessPlatinumProcessor_4fefeba3 implements PlatinumProcessor {
	/**
	 * EJSRemoteStatelessPlatinumProcessor
	 */
	public EJSRemoteStatelessPlatinumProcessor() throws java.rmi.RemoteException {
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
