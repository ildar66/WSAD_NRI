package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeasePayOrder
 */
public class EJSRemoteCMPLeasePayOrder extends com.hps.july.persistence.EJSRemoteCMPLeasePayOrder_45cd0b0b implements LeasePayOrder {
	/**
	 * EJSRemoteCMPLeasePayOrder
	 */
	public EJSRemoteCMPLeasePayOrder() throws java.rmi.RemoteException {
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
