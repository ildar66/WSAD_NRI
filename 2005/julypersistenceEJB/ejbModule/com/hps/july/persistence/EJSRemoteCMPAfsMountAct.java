package com.hps.july.persistence;

/**
 * EJSRemoteCMPAfsMountAct
 */
public class EJSRemoteCMPAfsMountAct extends com.hps.july.persistence.EJSRemoteCMPAfsMountAct_cf191c99 implements AfsMountAct {
	/**
	 * EJSRemoteCMPAfsMountAct
	 */
	public EJSRemoteCMPAfsMountAct() throws java.rmi.RemoteException {
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
