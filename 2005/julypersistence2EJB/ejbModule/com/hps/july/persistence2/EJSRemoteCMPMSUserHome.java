package com.hps.july.persistence2;

/**
 * EJSRemoteCMPMSUserHome
 */
public class EJSRemoteCMPMSUserHome extends com.hps.july.persistence2.EJSRemoteCMPMSUserHome_0350cd42 implements com.hps.july.persistence2.MSUserHome {
	/**
	 * EJSRemoteCMPMSUserHome
	 */
	public EJSRemoteCMPMSUserHome() throws java.rmi.RemoteException {
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
