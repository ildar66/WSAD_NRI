package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEPayNRI
 */
public class EJSRemoteCMPPIEPayNRI extends com.hps.july.persistence.EJSRemoteCMPPIEPayNRI_6b039a46 implements PIEPayNRI {
	/**
	 * EJSRemoteCMPPIEPayNRI
	 */
	public EJSRemoteCMPPIEPayNRI() throws java.rmi.RemoteException {
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
