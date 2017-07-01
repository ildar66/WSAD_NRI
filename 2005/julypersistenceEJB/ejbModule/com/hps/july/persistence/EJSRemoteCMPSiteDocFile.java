package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDocFile
 */
public class EJSRemoteCMPSiteDocFile extends com.hps.july.persistence.EJSRemoteCMPSiteDocFile_3813d797 implements SiteDocFile {
	/**
	 * EJSRemoteCMPSiteDocFile
	 */
	public EJSRemoteCMPSiteDocFile() throws java.rmi.RemoteException {
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
