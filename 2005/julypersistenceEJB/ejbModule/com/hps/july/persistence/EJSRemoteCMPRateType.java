package com.hps.july.persistence;

/**
 * EJSRemoteCMPRateType
 */
public class EJSRemoteCMPRateType extends com.hps.july.persistence.EJSRemoteCMPRateType_d51efcee implements RateType {
	/**
	 * EJSRemoteCMPRateType
	 */
	public EJSRemoteCMPRateType() throws java.rmi.RemoteException {
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
