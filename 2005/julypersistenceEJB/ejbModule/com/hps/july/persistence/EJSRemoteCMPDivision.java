package com.hps.july.persistence;

/**
 * EJSRemoteCMPDivision
 */
public class EJSRemoteCMPDivision extends com.hps.july.persistence.EJSRemoteCMPDivision_8ba14c1f implements Division {
	/**
	 * EJSRemoteCMPDivision
	 */
	public EJSRemoteCMPDivision() throws java.rmi.RemoteException {
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
