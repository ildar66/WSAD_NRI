package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessContractFinder
 */
public class EJSRemoteStatelessContractFinder extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessContractFinder_f173df16 implements ContractFinder {
	/**
	 * EJSRemoteStatelessContractFinder
	 */
	public EJSRemoteStatelessContractFinder() throws java.rmi.RemoteException {
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
