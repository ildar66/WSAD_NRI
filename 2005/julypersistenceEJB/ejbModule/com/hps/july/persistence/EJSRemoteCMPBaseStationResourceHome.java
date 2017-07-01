package com.hps.july.persistence;

/**
 * EJSRemoteCMPBaseStationResourceHome
 */
public class EJSRemoteCMPBaseStationResourceHome extends com.hps.july.persistence.EJSRemoteCMPBaseStationResourceHome_cd778579 implements com.hps.july.persistence.BaseStationResourceHome {
	/**
	 * EJSRemoteCMPBaseStationResourceHome
	 */
	public EJSRemoteCMPBaseStationResourceHome() throws java.rmi.RemoteException {
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
