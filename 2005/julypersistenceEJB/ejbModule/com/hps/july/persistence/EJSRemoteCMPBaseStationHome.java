package com.hps.july.persistence;

/**
 * EJSRemoteCMPBaseStationHome
 */
public class EJSRemoteCMPBaseStationHome extends com.hps.july.persistence.EJSRemoteCMPBaseStationHome_5156cef4 implements com.hps.july.persistence.BaseStationHome {
	/**
	 * EJSRemoteCMPBaseStationHome
	 */
	public EJSRemoteCMPBaseStationHome() throws java.rmi.RemoteException {
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
