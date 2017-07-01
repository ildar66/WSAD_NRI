package com.hps.july.persistence;

/**
 * EJSRemoteCMPStoragePlaceHome
 */
public class EJSRemoteCMPStoragePlaceHome extends com.hps.july.persistence.EJSRemoteCMPStoragePlaceHome_f3647562 implements com.hps.july.persistence.StoragePlaceHome {
	/**
	 * EJSRemoteCMPStoragePlaceHome
	 */
	public EJSRemoteCMPStoragePlaceHome() throws java.rmi.RemoteException {
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
