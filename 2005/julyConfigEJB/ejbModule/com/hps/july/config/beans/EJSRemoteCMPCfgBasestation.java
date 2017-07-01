package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgBasestation
 */
public class EJSRemoteCMPCfgBasestation extends com.hps.july.config.beans.EJSRemoteCMPCfgBasestation_711824dd implements CfgBasestation {
	/**
	 * EJSRemoteCMPCfgBasestation
	 */
	public EJSRemoteCMPCfgBasestation() throws java.rmi.RemoteException {
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
