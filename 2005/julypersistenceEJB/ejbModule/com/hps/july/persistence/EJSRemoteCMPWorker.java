package com.hps.july.persistence;

/**
 * EJSRemoteCMPWorker
 */
public class EJSRemoteCMPWorker extends com.hps.july.persistence.EJSRemoteCMPWorker_b6d39ea8 implements Worker {
	/**
	 * EJSRemoteCMPWorker
	 */
	public EJSRemoteCMPWorker() throws java.rmi.RemoteException {
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
