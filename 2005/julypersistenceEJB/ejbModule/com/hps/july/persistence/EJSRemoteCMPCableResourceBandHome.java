package com.hps.july.persistence;

/**
 * EJSRemoteCMPCableResourceBandHome
 */
public class EJSRemoteCMPCableResourceBandHome extends com.hps.july.persistence.EJSRemoteCMPCableResourceBandHome_80c2af09 implements com.hps.july.persistence.CableResourceBandHome {
	/**
	 * EJSRemoteCMPCableResourceBandHome
	 */
	public EJSRemoteCMPCableResourceBandHome() throws java.rmi.RemoteException {
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
