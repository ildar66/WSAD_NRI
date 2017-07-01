package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseCharges
 */
public class EJSRemoteCMPLeaseCharges extends com.hps.july.persistence.EJSRemoteCMPLeaseCharges_4bfbae00 implements LeaseCharges {
	/**
	 * EJSRemoteCMPLeaseCharges
	 */
	public EJSRemoteCMPLeaseCharges() throws java.rmi.RemoteException {
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
