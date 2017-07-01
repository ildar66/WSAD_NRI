package com.hps.july.persistence;

/**
 * EJSRemoteCMPAntennaResourceBand
 */
public class EJSRemoteCMPAntennaResourceBand extends com.hps.july.persistence.EJSRemoteCMPAntennaResourceBand_b73af947 implements AntennaResourceBand {
	/**
	 * EJSRemoteCMPAntennaResourceBand
	 */
	public EJSRemoteCMPAntennaResourceBand() throws java.rmi.RemoteException {
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
