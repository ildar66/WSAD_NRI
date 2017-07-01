package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectActionHome
 */
public class EJSRemoteCMPProjectActionHome extends com.hps.july.persistence.EJSRemoteCMPProjectActionHome_8e9b9227 implements com.hps.july.persistence.ProjectActionHome {
	/**
	 * EJSRemoteCMPProjectActionHome
	 */
	public EJSRemoteCMPProjectActionHome() throws java.rmi.RemoteException {
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
