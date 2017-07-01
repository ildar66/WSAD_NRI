package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseVPayment
 */
public class EJSRemoteCMPLeaseVPayment extends com.hps.july.persistence.EJSRemoteCMPLeaseVPayment_86f8b53d implements LeaseVPayment {
	/**
	 * EJSRemoteCMPLeaseVPayment
	 */
	public EJSRemoteCMPLeaseVPayment() throws java.rmi.RemoteException {
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
