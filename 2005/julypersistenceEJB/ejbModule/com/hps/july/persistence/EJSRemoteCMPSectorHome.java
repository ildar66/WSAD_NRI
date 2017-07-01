package com.hps.july.persistence;

/**
 * EJSRemoteCMPSectorHome
 */
public class EJSRemoteCMPSectorHome extends com.hps.july.persistence.EJSRemoteCMPSectorHome_905f53fa implements com.hps.july.persistence.SectorHome {
	/**
	 * EJSRemoteCMPSectorHome
	 */
	public EJSRemoteCMPSectorHome() throws java.rmi.RemoteException {
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
