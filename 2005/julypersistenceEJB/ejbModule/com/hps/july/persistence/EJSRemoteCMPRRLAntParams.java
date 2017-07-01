package com.hps.july.persistence;

/**
 * EJSRemoteCMPRRLAntParams
 */
public class EJSRemoteCMPRRLAntParams extends com.hps.july.persistence.EJSRemoteCMPRRLAntParams_f2fc01d9 implements RRLAntParams {
	/**
	 * EJSRemoteCMPRRLAntParams
	 */
	public EJSRemoteCMPRRLAntParams() throws java.rmi.RemoteException {
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
