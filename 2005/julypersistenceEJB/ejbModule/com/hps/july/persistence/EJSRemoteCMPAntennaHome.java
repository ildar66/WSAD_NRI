package com.hps.july.persistence;

/**
 * EJSRemoteCMPAntennaHome
 */
public class EJSRemoteCMPAntennaHome extends com.hps.july.persistence.EJSRemoteCMPAntennaHome_8f208dce implements com.hps.july.persistence.AntennaHome {
	/**
	 * EJSRemoteCMPAntennaHome
	 */
	public EJSRemoteCMPAntennaHome() throws java.rmi.RemoteException {
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
