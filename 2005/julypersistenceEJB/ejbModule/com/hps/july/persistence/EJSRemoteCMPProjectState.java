package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectState
 */
public class EJSRemoteCMPProjectState extends com.hps.july.persistence.EJSRemoteCMPProjectState_bf7cc4df implements ProjectState {
	/**
	 * EJSRemoteCMPProjectState
	 */
	public EJSRemoteCMPProjectState() throws java.rmi.RemoteException {
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
