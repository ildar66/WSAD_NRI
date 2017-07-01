package com.hps.july.persistence2;

/**
 * EJSRemoteCMPCableWorkParams
 */
public class EJSRemoteCMPCableWorkParams extends com.hps.july.persistence2.EJSRemoteCMPCableWorkParams_80ac4c0f implements CableWorkParams {
	/**
	 * EJSRemoteCMPCableWorkParams
	 */
	public EJSRemoteCMPCableWorkParams() throws java.rmi.RemoteException {
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
