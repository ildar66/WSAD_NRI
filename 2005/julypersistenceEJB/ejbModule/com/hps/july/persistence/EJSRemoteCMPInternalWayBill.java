package com.hps.july.persistence;

/**
 * EJSRemoteCMPInternalWayBill
 */
public class EJSRemoteCMPInternalWayBill extends com.hps.july.persistence.EJSRemoteCMPInternalWayBill_e225b591 implements InternalWayBill {
	/**
	 * EJSRemoteCMPInternalWayBill
	 */
	public EJSRemoteCMPInternalWayBill() throws java.rmi.RemoteException {
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
