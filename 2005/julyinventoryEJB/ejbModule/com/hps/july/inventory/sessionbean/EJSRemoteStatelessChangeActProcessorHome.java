package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessChangeActProcessorHome
 */
public class EJSRemoteStatelessChangeActProcessorHome extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessChangeActProcessorHome_daccbe62 implements com.hps.july.inventory.sessionbean.ChangeActProcessorHome {
	/**
	 * EJSRemoteStatelessChangeActProcessorHome
	 */
	public EJSRemoteStatelessChangeActProcessorHome() throws java.rmi.RemoteException {
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
