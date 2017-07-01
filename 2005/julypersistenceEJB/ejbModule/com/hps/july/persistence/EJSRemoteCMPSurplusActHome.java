package com.hps.july.persistence;

/**
 * EJSRemoteCMPSurplusActHome
 */
public class EJSRemoteCMPSurplusActHome extends com.hps.july.persistence.EJSRemoteCMPSurplusActHome_ae43edd4 implements com.hps.july.persistence.SurplusActHome {
	/**
	 * EJSRemoteCMPSurplusActHome
	 */
	public EJSRemoteCMPSurplusActHome() throws java.rmi.RemoteException {
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
