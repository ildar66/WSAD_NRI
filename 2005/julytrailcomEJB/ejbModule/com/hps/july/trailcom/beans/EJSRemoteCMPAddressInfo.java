package com.hps.july.trailcom.beans;

/**
 * EJSRemoteCMPAddressInfo
 */
public class EJSRemoteCMPAddressInfo extends com.hps.july.trailcom.beans.EJSRemoteCMPAddressInfo_a0760d65 implements AddressInfo {
	/**
	 * EJSRemoteCMPAddressInfo
	 */
	public EJSRemoteCMPAddressInfo() throws java.rmi.RemoteException {
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
