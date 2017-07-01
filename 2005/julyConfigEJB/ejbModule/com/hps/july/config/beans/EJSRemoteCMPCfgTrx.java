package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgTrx
 */
public class EJSRemoteCMPCfgTrx extends com.hps.july.config.beans.EJSRemoteCMPCfgTrx_58b1f72e implements CfgTrx {
	/**
	 * EJSRemoteCMPCfgTrx
	 */
	public EJSRemoteCMPCfgTrx() throws java.rmi.RemoteException {
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
