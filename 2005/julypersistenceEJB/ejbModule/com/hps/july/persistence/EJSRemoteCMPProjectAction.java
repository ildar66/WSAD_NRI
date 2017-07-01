package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectAction
 */
public class EJSRemoteCMPProjectAction extends com.hps.july.persistence.EJSRemoteCMPProjectAction_8e9b9227 implements ProjectAction {
	/**
	 * EJSRemoteCMPProjectAction
	 */
	public EJSRemoteCMPProjectAction() throws java.rmi.RemoteException {
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
