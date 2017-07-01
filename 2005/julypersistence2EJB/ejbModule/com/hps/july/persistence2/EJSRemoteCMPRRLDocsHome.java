package com.hps.july.persistence2;

/**
 * EJSRemoteCMPRRLDocsHome
 */
public class EJSRemoteCMPRRLDocsHome extends com.hps.july.persistence2.EJSRemoteCMPRRLDocsHome_d716392c implements com.hps.july.persistence2.RRLDocsHome {
	/**
	 * EJSRemoteCMPRRLDocsHome
	 */
	public EJSRemoteCMPRRLDocsHome() throws java.rmi.RemoteException {
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
