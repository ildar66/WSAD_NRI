package com.hps.july.persistence;

/**
 * EJSRemoteCMPSector
 */
public class EJSRemoteCMPSector extends com.hps.july.persistence.EJSRemoteCMPSector_905f53fa implements Sector {
	/**
	 * EJSRemoteCMPSector
	 */
	public EJSRemoteCMPSector() throws java.rmi.RemoteException {
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
