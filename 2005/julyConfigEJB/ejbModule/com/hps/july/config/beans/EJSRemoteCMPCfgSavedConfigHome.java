package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgSavedConfigHome
 */
public class EJSRemoteCMPCfgSavedConfigHome extends com.hps.july.config.beans.EJSRemoteCMPCfgSavedConfigHome_6e49ac1d implements com.hps.july.config.beans.CfgSavedConfigHome {
	/**
	 * EJSRemoteCMPCfgSavedConfigHome
	 */
	public EJSRemoteCMPCfgSavedConfigHome() throws java.rmi.RemoteException {
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
