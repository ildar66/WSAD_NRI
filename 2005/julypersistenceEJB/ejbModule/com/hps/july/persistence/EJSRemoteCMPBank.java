package com.hps.july.persistence;

/**
 * EJSRemoteCMPBank
 */
public class EJSRemoteCMPBank extends com.hps.july.persistence.EJSRemoteCMPBank_96552406 implements Bank {
	/**
	 * EJSRemoteCMPBank
	 */
	public EJSRemoteCMPBank() throws java.rmi.RemoteException {
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
