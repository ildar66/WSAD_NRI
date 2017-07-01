package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgSectorHome
 */
public class EJSRemoteCMPCfgSectorHome extends com.hps.july.config.beans.EJSRemoteCMPCfgSectorHome_30c46d37 implements com.hps.july.config.beans.CfgSectorHome {
	/**
	 * EJSRemoteCMPCfgSectorHome
	 */
	public EJSRemoteCMPCfgSectorHome() throws java.rmi.RemoteException {
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
