package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgAntennaHome
 */
public class EJSRemoteCMPCfgAntennaHome extends com.hps.july.config.beans.EJSRemoteCMPCfgAntennaHome_245fb73a implements com.hps.july.config.beans.CfgAntennaHome {
	/**
	 * EJSRemoteCMPCfgAntennaHome
	 */
	public EJSRemoteCMPCfgAntennaHome() throws java.rmi.RemoteException {
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
