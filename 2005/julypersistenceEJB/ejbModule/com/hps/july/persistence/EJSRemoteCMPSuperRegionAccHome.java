package com.hps.july.persistence;

/**
 * EJSRemoteCMPSuperRegionAccHome
 */
public class EJSRemoteCMPSuperRegionAccHome extends com.hps.july.persistence.EJSRemoteCMPSuperRegionAccHome_7cebb5ee implements com.hps.july.persistence.SuperRegionAccHome {
	/**
	 * EJSRemoteCMPSuperRegionAccHome
	 */
	public EJSRemoteCMPSuperRegionAccHome() throws java.rmi.RemoteException {
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
