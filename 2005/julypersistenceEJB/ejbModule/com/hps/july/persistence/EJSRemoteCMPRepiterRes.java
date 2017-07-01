package com.hps.july.persistence;

/**
 * EJSRemoteCMPRepiterRes
 */
public class EJSRemoteCMPRepiterRes extends com.hps.july.persistence.EJSRemoteCMPRepiterRes_afbcb081 implements RepiterRes {
	/**
	 * EJSRemoteCMPRepiterRes
	 */
	public EJSRemoteCMPRepiterRes() throws java.rmi.RemoteException {
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
