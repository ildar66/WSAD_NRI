package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessAssemblingActProcessor
 */
public class EJSRemoteStatelessAssemblingActProcessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessAssemblingActProcessor_590b631d implements AssemblingActProcessor {
	/**
	 * EJSRemoteStatelessAssemblingActProcessor
	 */
	public EJSRemoteStatelessAssemblingActProcessor() throws java.rmi.RemoteException {
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
