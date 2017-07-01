package com.hps.july.config.beans;

/**
 * EJSRemoteCMPCfgAntennaWorkBand
 */
public class EJSRemoteCMPCfgAntennaWorkBand extends com.hps.july.config.beans.EJSRemoteCMPCfgAntennaWorkBand_60f3800a implements CfgAntennaWorkBand {
	/**
	 * EJSRemoteCMPCfgAntennaWorkBand
	 */
	public EJSRemoteCMPCfgAntennaWorkBand() throws java.rmi.RemoteException {
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
