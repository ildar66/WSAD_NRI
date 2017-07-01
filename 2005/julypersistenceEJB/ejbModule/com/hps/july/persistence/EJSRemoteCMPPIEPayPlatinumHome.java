package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEPayPlatinumHome
 */
public class EJSRemoteCMPPIEPayPlatinumHome extends com.hps.july.persistence.EJSRemoteCMPPIEPayPlatinumHome_fb1fdc8d implements com.hps.july.persistence.PIEPayPlatinumHome {
	/**
	 * EJSRemoteCMPPIEPayPlatinumHome
	 */
	public EJSRemoteCMPPIEPayPlatinumHome() throws java.rmi.RemoteException {
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
