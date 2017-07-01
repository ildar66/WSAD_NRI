package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDoc
 */
public class EJSRemoteCMPSiteDoc extends com.hps.july.persistence.EJSRemoteCMPSiteDoc_92b2e4e2 implements SiteDoc {
	/**
	 * EJSRemoteCMPSiteDoc
	 */
	public EJSRemoteCMPSiteDoc() throws java.rmi.RemoteException {
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
