package com.hps.july.persistence;

/**
 * EJSRemoteCMPRegionAccHome
 */
public class EJSRemoteCMPRegionAccHome extends com.hps.july.persistence.EJSRemoteCMPRegionAccHome_7d950a32 implements com.hps.july.persistence.RegionAccHome {
	/**
	 * EJSRemoteCMPRegionAccHome
	 */
	public EJSRemoteCMPRegionAccHome() throws java.rmi.RemoteException {
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
