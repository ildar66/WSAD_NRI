package com.hps.july.persistence;

/**
 * EJSRemoteCMPContrAddInfo
 */
public class EJSRemoteCMPContrAddInfo extends com.hps.july.persistence.EJSRemoteCMPContrAddInfo_bfd683b7 implements ContrAddInfo {
	/**
	 * EJSRemoteCMPContrAddInfo
	 */
	public EJSRemoteCMPContrAddInfo() throws java.rmi.RemoteException {
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
