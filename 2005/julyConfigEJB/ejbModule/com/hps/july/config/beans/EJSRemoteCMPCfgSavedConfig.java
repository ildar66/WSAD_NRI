package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgSavedConfig
 */
public class EJSRemoteCMPCfgSavedConfig extends com.hps.july.config.beans.EJSRemoteCMPCfgSavedConfig_6e49ac1d implements CfgSavedConfig {
	/**
	 * EJSRemoteCMPCfgSavedConfig
	 */
	public EJSRemoteCMPCfgSavedConfig() throws java.rmi.RemoteException {
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
