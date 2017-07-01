package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessAssemblingActProcessorHome
 */
public class EJSRemoteStatelessAssemblingActProcessorHome extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessAssemblingActProcessorHome_590b631d implements com.hps.july.inventory.sessionbean.AssemblingActProcessorHome {
	/**
	 * EJSRemoteStatelessAssemblingActProcessorHome
	 */
	public EJSRemoteStatelessAssemblingActProcessorHome() throws java.rmi.RemoteException {
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
