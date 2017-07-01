package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectHome
 */
public class EJSRemoteCMPProjectHome extends com.hps.july.persistence.EJSRemoteCMPProjectHome_9b5157cc implements com.hps.july.persistence.ProjectHome {
	/**
	 * EJSRemoteCMPProjectHome
	 */
	public EJSRemoteCMPProjectHome() throws java.rmi.RemoteException {
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
