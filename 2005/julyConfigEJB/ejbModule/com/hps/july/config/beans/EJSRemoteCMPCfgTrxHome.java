package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgTrxHome
 */
public class EJSRemoteCMPCfgTrxHome extends com.hps.july.config.beans.EJSRemoteCMPCfgTrxHome_58b1f72e implements com.hps.july.config.beans.CfgTrxHome {
	/**
	 * EJSRemoteCMPCfgTrxHome
	 */
	public EJSRemoteCMPCfgTrxHome() throws java.rmi.RemoteException {
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
