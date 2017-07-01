package com.hps.july.persistence;

/**
 * EJSRemoteCMPAntennaWorkBand
 */
public class EJSRemoteCMPAntennaWorkBand extends com.hps.july.persistence.EJSRemoteCMPAntennaWorkBand_8b2ccd86 implements AntennaWorkBand {
	/**
	 * EJSRemoteCMPAntennaWorkBand
	 */
	public EJSRemoteCMPAntennaWorkBand() throws java.rmi.RemoteException {
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
