package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessInWayBillProcessor
 */
public class EJSRemoteStatelessInWayBillProcessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessInWayBillProcessor_25d43716 implements InWayBillProcessor {
	/**
	 * EJSRemoteStatelessInWayBillProcessor
	 */
	public EJSRemoteStatelessInWayBillProcessor() throws java.rmi.RemoteException {
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
