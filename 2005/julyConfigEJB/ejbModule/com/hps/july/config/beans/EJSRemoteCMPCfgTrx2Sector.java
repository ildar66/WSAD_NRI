package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgTrx2Sector
 */
public class EJSRemoteCMPCfgTrx2Sector extends com.hps.july.config.beans.EJSRemoteCMPCfgTrx2Sector_d03b763f implements CfgTrx2Sector {
	/**
	 * EJSRemoteCMPCfgTrx2Sector
	 */
	public EJSRemoteCMPCfgTrx2Sector() throws java.rmi.RemoteException {
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
