package com.hps.july.persistence;

/**
 * EJSRemoteCMPNetZoneHome
 */
public class EJSRemoteCMPNetZoneHome extends com.hps.july.persistence.EJSRemoteCMPNetZoneHome_6ae04792 implements com.hps.july.persistence.NetZoneHome {
	/**
	 * EJSRemoteCMPNetZoneHome
	 */
	public EJSRemoteCMPNetZoneHome() throws java.rmi.RemoteException {
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
