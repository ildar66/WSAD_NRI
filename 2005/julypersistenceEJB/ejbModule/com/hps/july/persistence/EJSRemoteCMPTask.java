package com.hps.july.persistence;

/**
 * EJSRemoteCMPTask
 */
public class EJSRemoteCMPTask extends com.hps.july.persistence.EJSRemoteCMPTask_316560a8 implements Task {
	/**
	 * EJSRemoteCMPTask
	 */
	public EJSRemoteCMPTask() throws java.rmi.RemoteException {
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
