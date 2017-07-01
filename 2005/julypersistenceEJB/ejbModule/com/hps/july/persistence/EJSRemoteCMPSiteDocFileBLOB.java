package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDocFileBLOB
 */
public class EJSRemoteCMPSiteDocFileBLOB extends com.hps.july.persistence.EJSRemoteCMPSiteDocFileBLOB_29f7bad5 implements SiteDocFileBLOB {
	/**
	 * EJSRemoteCMPSiteDocFileBLOB
	 */
	public EJSRemoteCMPSiteDocFileBLOB() throws java.rmi.RemoteException {
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
