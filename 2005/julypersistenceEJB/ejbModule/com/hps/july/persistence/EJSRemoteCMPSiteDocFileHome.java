package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDocFileHome
 */
public class EJSRemoteCMPSiteDocFileHome extends com.hps.july.persistence.EJSRemoteCMPSiteDocFileHome_3813d797 implements com.hps.july.persistence.SiteDocFileHome {
	/**
	 * EJSRemoteCMPSiteDocFileHome
	 */
	public EJSRemoteCMPSiteDocFileHome() throws java.rmi.RemoteException {
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
