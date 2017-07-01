package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgBsstands
 */
public class EJSRemoteCMPCfgBsstands extends com.hps.july.config.beans.EJSRemoteCMPCfgBsstands_90a7017d implements CfgBsstands {
	/**
	 * EJSRemoteCMPCfgBsstands
	 */
	public EJSRemoteCMPCfgBsstands() throws java.rmi.RemoteException {
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
