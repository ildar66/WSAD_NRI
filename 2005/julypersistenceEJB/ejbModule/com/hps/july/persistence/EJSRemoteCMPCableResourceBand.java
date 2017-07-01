package com.hps.july.persistence;

/**
 * EJSRemoteCMPCableResourceBand
 */
public class EJSRemoteCMPCableResourceBand extends com.hps.july.persistence.EJSRemoteCMPCableResourceBand_80c2af09 implements CableResourceBand {
	/**
	 * EJSRemoteCMPCableResourceBand
	 */
	public EJSRemoteCMPCableResourceBand() throws java.rmi.RemoteException {
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
