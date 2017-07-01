package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessProcessorFacadeHome
 */
public class EJSRemoteStatelessProcessorFacadeHome extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessProcessorFacadeHome_6c8f0b68 implements com.hps.july.inventory.sessionbean.ProcessorFacadeHome {
	/**
	 * EJSRemoteStatelessProcessorFacadeHome
	 */
	public EJSRemoteStatelessProcessorFacadeHome() throws java.rmi.RemoteException {
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
