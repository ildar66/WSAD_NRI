package com.hps.july.persistence;

/**
 * EJSRemoteCMPAntennaResourceHome
 */
public class EJSRemoteCMPAntennaResourceHome extends com.hps.july.persistence.EJSRemoteCMPAntennaResourceHome_8763e04a implements com.hps.july.persistence.AntennaResourceHome {
	/**
	 * EJSRemoteCMPAntennaResourceHome
	 */
	public EJSRemoteCMPAntennaResourceHome() throws java.rmi.RemoteException {
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
