package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgSector
 */
public class EJSRemoteCMPCfgSector extends com.hps.july.config.beans.EJSRemoteCMPCfgSector_30c46d37 implements CfgSector {
	/**
	 * EJSRemoteCMPCfgSector
	 */
	public EJSRemoteCMPCfgSector() throws java.rmi.RemoteException {
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
