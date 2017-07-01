package com.hps.july.persistence;

/**
 * EJSRemoteCMPPhotoHome
 */
public class EJSRemoteCMPPhotoHome extends com.hps.july.persistence.EJSRemoteCMPPhotoHome_b9c81ce3 implements com.hps.july.persistence.PhotoHome {
	/**
	 * EJSRemoteCMPPhotoHome
	 */
	public EJSRemoteCMPPhotoHome() throws java.rmi.RemoteException {
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
