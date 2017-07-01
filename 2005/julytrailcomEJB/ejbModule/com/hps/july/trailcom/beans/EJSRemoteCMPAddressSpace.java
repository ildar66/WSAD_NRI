package com.hps.july.trailcom.beans;

/**
 * EJSRemoteCMPAddressSpace
 */
public class EJSRemoteCMPAddressSpace extends com.hps.july.trailcom.beans.EJSRemoteCMPAddressSpace_4288f116 implements AddressSpace {
	/**
	 * EJSRemoteCMPAddressSpace
	 */
	public EJSRemoteCMPAddressSpace() throws java.rmi.RemoteException {
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
