package com.hps.july.persistence;

/**
 * EJSRemoteCMPSiteDocFileBLOBHome
 */
public class EJSRemoteCMPSiteDocFileBLOBHome extends com.hps.july.persistence.EJSRemoteCMPSiteDocFileBLOBHome_29f7bad5 implements com.hps.july.persistence.SiteDocFileBLOBHome {
	/**
	 * EJSRemoteCMPSiteDocFileBLOBHome
	 */
	public EJSRemoteCMPSiteDocFileBLOBHome() throws java.rmi.RemoteException {
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
