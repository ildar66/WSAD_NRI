package com.hps.july.persistence;

/**
 * EJSRemoteCMPSuperRegionHome
 */
public class EJSRemoteCMPSuperRegionHome extends com.hps.july.persistence.EJSRemoteCMPSuperRegionHome_2c43a25d implements com.hps.july.persistence.SuperRegionHome {
	/**
	 * EJSRemoteCMPSuperRegionHome
	 */
	public EJSRemoteCMPSuperRegionHome() throws java.rmi.RemoteException {
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
