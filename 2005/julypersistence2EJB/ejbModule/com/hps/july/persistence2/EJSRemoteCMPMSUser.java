package com.hps.july.persistence2;

/**
 * EJSRemoteCMPMSUser
 */
public class EJSRemoteCMPMSUser extends com.hps.july.persistence2.EJSRemoteCMPMSUser_0350cd42 implements MSUser {
	/**
	 * EJSRemoteCMPMSUser
	 */
	public EJSRemoteCMPMSUser() throws java.rmi.RemoteException {
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
