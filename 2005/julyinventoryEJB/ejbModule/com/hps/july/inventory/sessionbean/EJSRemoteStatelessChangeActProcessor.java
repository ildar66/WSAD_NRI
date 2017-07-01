package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessChangeActProcessor
 */
public class EJSRemoteStatelessChangeActProcessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessChangeActProcessor_daccbe62 implements ChangeActProcessor {
	/**
	 * EJSRemoteStatelessChangeActProcessor
	 */
	public EJSRemoteStatelessChangeActProcessor() throws java.rmi.RemoteException {
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
