package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectStateHome
 */
public class EJSRemoteCMPProjectStateHome extends com.hps.july.persistence.EJSRemoteCMPProjectStateHome_bf7cc4df implements com.hps.july.persistence.ProjectStateHome {
	/**
	 * EJSRemoteCMPProjectStateHome
	 */
	public EJSRemoteCMPProjectStateHome() throws java.rmi.RemoteException {
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
