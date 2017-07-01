package com.hps.july.persistence;

/**
 * EJSRemoteCMPPhotoBlobHome
 */
public class EJSRemoteCMPPhotoBlobHome extends com.hps.july.persistence.EJSRemoteCMPPhotoBlobHome_e4daa2aa implements com.hps.july.persistence.PhotoBlobHome {
	/**
	 * EJSRemoteCMPPhotoBlobHome
	 */
	public EJSRemoteCMPPhotoBlobHome() throws java.rmi.RemoteException {
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
