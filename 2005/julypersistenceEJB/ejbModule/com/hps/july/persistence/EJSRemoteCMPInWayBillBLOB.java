package com.hps.july.persistence;

/**
 * EJSRemoteCMPInWayBillBLOB
 */
public class EJSRemoteCMPInWayBillBLOB extends com.hps.july.persistence.EJSRemoteCMPInWayBillBLOB_cfd95fed implements InWayBillBLOB {
	/**
	 * EJSRemoteCMPInWayBillBLOB
	 */
	public EJSRemoteCMPInWayBillBLOB() throws java.rmi.RemoteException {
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
