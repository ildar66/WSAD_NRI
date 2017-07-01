package com.hps.july.persistence;

/**
 * EJSRemoteCMPRegionHome
 */
public class EJSRemoteCMPRegionHome extends com.hps.july.persistence.EJSRemoteCMPRegionHome_e2bb4e3f implements com.hps.july.persistence.RegionHome {
	/**
	 * EJSRemoteCMPRegionHome
	 */
	public EJSRemoteCMPRegionHome() throws java.rmi.RemoteException {
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
