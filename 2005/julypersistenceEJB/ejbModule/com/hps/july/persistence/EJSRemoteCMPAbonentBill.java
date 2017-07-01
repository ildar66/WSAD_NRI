package com.hps.july.persistence;

/**
 * EJSRemoteCMPAbonentBill
 */
public class EJSRemoteCMPAbonentBill extends com.hps.july.persistence.EJSRemoteCMPAbonentBill_75fa4e4f implements AbonentBill {
	/**
	 * EJSRemoteCMPAbonentBill
	 */
	public EJSRemoteCMPAbonentBill() throws java.rmi.RemoteException {
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
