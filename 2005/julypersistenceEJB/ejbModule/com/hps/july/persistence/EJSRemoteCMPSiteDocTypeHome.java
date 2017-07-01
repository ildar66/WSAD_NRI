package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDocTypeHome
 */
public class EJSRemoteCMPSiteDocTypeHome extends com.hps.july.persistence.EJSRemoteCMPSiteDocTypeHome_e7563d77 implements com.hps.july.persistence.SiteDocTypeHome {
	/**
	 * EJSRemoteCMPSiteDocTypeHome
	 */
	public EJSRemoteCMPSiteDocTypeHome() throws java.rmi.RemoteException {
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
