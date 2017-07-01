package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessProcessorFacade
 */
public class EJSRemoteStatelessProcessorFacade extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessProcessorFacade_6c8f0b68 implements ProcessorFacade {
	/**
	 * EJSRemoteStatelessProcessorFacade
	 */
	public EJSRemoteStatelessProcessorFacade() throws java.rmi.RemoteException {
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
