package com.hps.july.persistence;

/**
 * EJSRemoteCMPPhotoBlob
 */
public class EJSRemoteCMPPhotoBlob extends com.hps.july.persistence.EJSRemoteCMPPhotoBlob_e4daa2aa implements PhotoBlob {
	/**
	 * EJSRemoteCMPPhotoBlob
	 */
	public EJSRemoteCMPPhotoBlob() throws java.rmi.RemoteException {
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
