package com.hps.july.persistence;

/**
 * EJSRemoteCMPWorkerHome
 */
public class EJSRemoteCMPWorkerHome extends com.hps.july.persistence.EJSRemoteCMPWorkerHome_b6d39ea8 implements com.hps.july.persistence.WorkerHome {
	/**
	 * EJSRemoteCMPWorkerHome
	 */
	public EJSRemoteCMPWorkerHome() throws java.rmi.RemoteException {
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
