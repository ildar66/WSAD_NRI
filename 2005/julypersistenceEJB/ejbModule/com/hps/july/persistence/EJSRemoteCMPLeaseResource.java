package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseResource
 */
public class EJSRemoteCMPLeaseResource extends com.hps.july.persistence.EJSRemoteCMPLeaseResource_37b5eaeb implements LeaseResource {
	/**
	 * EJSRemoteCMPLeaseResource
	 */
	public EJSRemoteCMPLeaseResource() throws java.rmi.RemoteException {
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
