package com.hps.july.persistence;

/**
 * EJSRemoteCMPResource
 */
public class EJSRemoteCMPResource extends com.hps.july.persistence.EJSRemoteCMPResource_5b81bc6d implements Resource {
	/**
	 * EJSRemoteCMPResource
	 */
	public EJSRemoteCMPResource() throws java.rmi.RemoteException {
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
