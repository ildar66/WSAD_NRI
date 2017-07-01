package com.hps.july.persistence;

/**
 * EJSRemoteCMPContrAddInfoHome
 */
public class EJSRemoteCMPContrAddInfoHome extends com.hps.july.persistence.EJSRemoteCMPContrAddInfoHome_bfd683b7 implements com.hps.july.persistence.ContrAddInfoHome {
	/**
	 * EJSRemoteCMPContrAddInfoHome
	 */
	public EJSRemoteCMPContrAddInfoHome() throws java.rmi.RemoteException {
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
