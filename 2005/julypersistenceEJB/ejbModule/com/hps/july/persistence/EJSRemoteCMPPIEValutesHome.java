package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEValutesHome
 */
public class EJSRemoteCMPPIEValutesHome extends com.hps.july.persistence.EJSRemoteCMPPIEValutesHome_ef13060b implements com.hps.july.persistence.PIEValutesHome {
	/**
	 * EJSRemoteCMPPIEValutesHome
	 */
	public EJSRemoteCMPPIEValutesHome() throws java.rmi.RemoteException {
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
