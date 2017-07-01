package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessContractSuppliesInfo
 */
public class EJSRemoteStatelessContractSuppliesInfo extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessContractSuppliesInfo_29bb2881 implements ContractSuppliesInfo {
	/**
	 * EJSRemoteStatelessContractSuppliesInfo
	 */
	public EJSRemoteStatelessContractSuppliesInfo() throws java.rmi.RemoteException {
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
