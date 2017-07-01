package com.hps.july.persistence;

/**
 * EJSRemoteCMPRateTypeHome
 */
public class EJSRemoteCMPRateTypeHome extends com.hps.july.persistence.EJSRemoteCMPRateTypeHome_d51efcee implements com.hps.july.persistence.RateTypeHome {
	/**
	 * EJSRemoteCMPRateTypeHome
	 */
	public EJSRemoteCMPRateTypeHome() throws java.rmi.RemoteException {
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
