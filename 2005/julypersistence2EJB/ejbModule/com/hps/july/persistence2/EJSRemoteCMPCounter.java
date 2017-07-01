package com.hps.july.persistence2;

/**
 * EJSRemoteCMPCounter
 */
public class EJSRemoteCMPCounter extends com.hps.july.persistence2.EJSRemoteCMPCounter_b1595563 implements Counter {
	/**
	 * EJSRemoteCMPCounter
	 */
	public EJSRemoteCMPCounter() throws java.rmi.RemoteException {
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
