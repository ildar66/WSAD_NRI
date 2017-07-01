package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseDocument
 */
public class EJSRemoteCMPLeaseDocument extends com.hps.july.persistence.EJSRemoteCMPLeaseDocument_a05aa12e implements LeaseDocument {
	/**
	 * EJSRemoteCMPLeaseDocument
	 */
	public EJSRemoteCMPLeaseDocument() throws java.rmi.RemoteException {
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
