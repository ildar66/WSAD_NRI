package com.hps.july.persistence;

/**
 * EJSRemoteCMPOrganization
 */
public class EJSRemoteCMPOrganization extends com.hps.july.persistence.EJSRemoteCMPOrganization_afa7f9a6 implements Organization {
	/**
	 * EJSRemoteCMPOrganization
	 */
	public EJSRemoteCMPOrganization() throws java.rmi.RemoteException {
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
