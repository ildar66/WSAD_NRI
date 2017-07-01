package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseContract
 */
public class EJSRemoteCMPLeaseContract extends com.hps.july.persistence.EJSRemoteCMPLeaseContract_62ebfc4f implements LeaseContract {
	/**
	 * EJSRemoteCMPLeaseContract
	 */
	public EJSRemoteCMPLeaseContract() throws java.rmi.RemoteException {
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
