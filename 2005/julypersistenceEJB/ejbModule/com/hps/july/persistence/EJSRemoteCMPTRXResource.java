package com.hps.july.persistence;

/**
 * EJSRemoteCMPTRXResource
 */
public class EJSRemoteCMPTRXResource extends com.hps.july.persistence.EJSRemoteCMPTRXResource_92b2ea12 implements TRXResource {
	/**
	 * EJSRemoteCMPTRXResource
	 */
	public EJSRemoteCMPTRXResource() throws java.rmi.RemoteException {
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
