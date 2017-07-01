package com.hps.july.persistence;

/**
 * EJSRemoteCMPRateHome
 */
public class EJSRemoteCMPRateHome extends com.hps.july.persistence.EJSRemoteCMPRateHome_317b6ef3 implements com.hps.july.persistence.RateHome {
	/**
	 * EJSRemoteCMPRateHome
	 */
	public EJSRemoteCMPRateHome() throws java.rmi.RemoteException {
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
