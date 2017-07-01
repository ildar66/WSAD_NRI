package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEExpence
 */
public class EJSRemoteCMPPIEExpence extends com.hps.july.persistence.EJSRemoteCMPPIEExpence_74e71f50 implements PIEExpence {
	/**
	 * EJSRemoteCMPPIEExpence
	 */
	public EJSRemoteCMPPIEExpence() throws java.rmi.RemoteException {
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
