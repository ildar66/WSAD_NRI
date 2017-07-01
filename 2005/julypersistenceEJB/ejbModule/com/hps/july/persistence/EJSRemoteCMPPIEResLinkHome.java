package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEResLinkHome
 */
public class EJSRemoteCMPPIEResLinkHome extends com.hps.july.persistence.EJSRemoteCMPPIEResLinkHome_3d13a75a implements com.hps.july.persistence.PIEResLinkHome {
	/**
	 * EJSRemoteCMPPIEResLinkHome
	 */
	public EJSRemoteCMPPIEResLinkHome() throws java.rmi.RemoteException {
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
