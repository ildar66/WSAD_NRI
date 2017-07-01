package com.hps.july.platinum.sessionbean;

/**
 * EJSRemoteStatelessArendaPlatinumProcessor
 */
public class EJSRemoteStatelessArendaPlatinumProcessor extends com.hps.july.platinum.sessionbean.EJSRemoteStatelessArendaPlatinumProcessor_6bcc1db9 implements ArendaPlatinumProcessor {
	/**
	 * EJSRemoteStatelessArendaPlatinumProcessor
	 */
	public EJSRemoteStatelessArendaPlatinumProcessor() throws java.rmi.RemoteException {
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
