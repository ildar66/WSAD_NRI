package com.hps.july.persistence;

/**
 * EJSRemoteCMPPosition
 */
public class EJSRemoteCMPPosition extends com.hps.july.persistence.EJSRemoteCMPPosition_324e4597 implements Position {
	/**
	 * EJSRemoteCMPPosition
	 */
	public EJSRemoteCMPPosition() throws java.rmi.RemoteException {
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
