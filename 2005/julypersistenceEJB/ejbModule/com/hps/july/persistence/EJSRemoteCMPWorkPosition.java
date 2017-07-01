package com.hps.july.persistence;

/**
 * EJSRemoteCMPWorkPosition
 */
public class EJSRemoteCMPWorkPosition extends com.hps.july.persistence.EJSRemoteCMPWorkPosition_4a9a1b46 implements WorkPosition {
	/**
	 * EJSRemoteCMPWorkPosition
	 */
	public EJSRemoteCMPWorkPosition() throws java.rmi.RemoteException {
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
