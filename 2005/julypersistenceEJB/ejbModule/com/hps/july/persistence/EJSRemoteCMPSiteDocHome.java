package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDocHome
 */
public class EJSRemoteCMPSiteDocHome extends com.hps.july.persistence.EJSRemoteCMPSiteDocHome_92b2e4e2 implements com.hps.july.persistence.SiteDocHome {
	/**
	 * EJSRemoteCMPSiteDocHome
	 */
	public EJSRemoteCMPSiteDocHome() throws java.rmi.RemoteException {
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
