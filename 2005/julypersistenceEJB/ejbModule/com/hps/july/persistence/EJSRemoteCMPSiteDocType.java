package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDocType
 */
public class EJSRemoteCMPSiteDocType extends com.hps.july.persistence.EJSRemoteCMPSiteDocType_e7563d77 implements SiteDocType {
	/**
	 * EJSRemoteCMPSiteDocType
	 */
	public EJSRemoteCMPSiteDocType() throws java.rmi.RemoteException {
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
