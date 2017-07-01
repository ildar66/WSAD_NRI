package com.hps.july.persistence;

/**
 * EJSRemoteCMPChangeActHome
 */
public class EJSRemoteCMPChangeActHome extends com.hps.july.persistence.EJSRemoteCMPChangeActHome_1004ca71 implements com.hps.july.persistence.ChangeActHome {
	/**
	 * EJSRemoteCMPChangeActHome
	 */
	public EJSRemoteCMPChangeActHome() throws java.rmi.RemoteException {
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
