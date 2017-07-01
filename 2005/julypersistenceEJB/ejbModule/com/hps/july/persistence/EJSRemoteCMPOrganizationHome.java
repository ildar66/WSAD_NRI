package com.hps.july.persistence;

/**
 * EJSRemoteCMPOrganizationHome
 */
public class EJSRemoteCMPOrganizationHome extends com.hps.july.persistence.EJSRemoteCMPOrganizationHome_afa7f9a6 implements com.hps.july.persistence.OrganizationHome {
	/**
	 * EJSRemoteCMPOrganizationHome
	 */
	public EJSRemoteCMPOrganizationHome() throws java.rmi.RemoteException {
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
