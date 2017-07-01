package com.hps.july.persistence;

/**
 * EJSRemoteCMPControllerHome
 */
public class EJSRemoteCMPControllerHome extends com.hps.july.persistence.EJSRemoteCMPControllerHome_7e6b4ceb implements com.hps.july.persistence.ControllerHome {
	/**
	 * EJSRemoteCMPControllerHome
	 */
	public EJSRemoteCMPControllerHome() throws java.rmi.RemoteException {
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
