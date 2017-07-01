package com.hps.july.persistence;

/**
 * EJSRemoteCMPComplect
 */
public class EJSRemoteCMPComplect extends com.hps.july.persistence.EJSRemoteCMPComplect_a8aaa080 implements Complect {
	/**
	 * EJSRemoteCMPComplect
	 */
	public EJSRemoteCMPComplect() throws java.rmi.RemoteException {
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
