package com.hps.july.persistence;

/**
 * EJSRemoteCMPAntenna
 */
public class EJSRemoteCMPAntenna extends com.hps.july.persistence.EJSRemoteCMPAntenna_8f208dce implements Antenna {
	/**
	 * EJSRemoteCMPAntenna
	 */
	public EJSRemoteCMPAntenna() throws java.rmi.RemoteException {
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
