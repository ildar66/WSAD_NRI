package com.hps.july.persistence;

/**
 * EJSRemoteCMPRate
 */
public class EJSRemoteCMPRate extends com.hps.july.persistence.EJSRemoteCMPRate_317b6ef3 implements Rate {
	/**
	 * EJSRemoteCMPRate
	 */
	public EJSRemoteCMPRate() throws java.rmi.RemoteException {
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
