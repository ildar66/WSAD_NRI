package com.hps.july.persistence;

/**
 * EJSRemoteCMPInternalOutBill
 */
public class EJSRemoteCMPInternalOutBill extends com.hps.july.persistence.EJSRemoteCMPInternalOutBill_f359097d implements InternalOutBill {
	/**
	 * EJSRemoteCMPInternalOutBill
	 */
	public EJSRemoteCMPInternalOutBill() throws java.rmi.RemoteException {
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
