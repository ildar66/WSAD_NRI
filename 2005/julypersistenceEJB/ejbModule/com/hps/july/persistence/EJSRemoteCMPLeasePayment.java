package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeasePayment
 */
public class EJSRemoteCMPLeasePayment extends com.hps.july.persistence.EJSRemoteCMPLeasePayment_ca59e9e2 implements LeasePayment {
	/**
	 * EJSRemoteCMPLeasePayment
	 */
	public EJSRemoteCMPLeasePayment() throws java.rmi.RemoteException {
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
