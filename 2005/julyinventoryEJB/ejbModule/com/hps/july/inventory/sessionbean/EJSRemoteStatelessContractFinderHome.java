package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessContractFinderHome
 */
public class EJSRemoteStatelessContractFinderHome extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessContractFinderHome_f173df16 implements com.hps.july.inventory.sessionbean.ContractFinderHome {
	/**
	 * EJSRemoteStatelessContractFinderHome
	 */
	public EJSRemoteStatelessContractFinderHome() throws java.rmi.RemoteException {
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
