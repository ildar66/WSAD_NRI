package com.hps.july.trailcom.beans;

/**
 * EJSRemoteCMPHop
 */
public class EJSRemoteCMPHop extends com.hps.july.trailcom.beans.EJSRemoteCMPHop_260ef4c5 implements Hop {
	/**
	 * EJSRemoteCMPHop
	 */
	public EJSRemoteCMPHop() throws java.rmi.RemoteException {
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
