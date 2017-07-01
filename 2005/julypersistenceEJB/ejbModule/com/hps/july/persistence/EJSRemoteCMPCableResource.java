package com.hps.july.persistence;

/**
 * EJSRemoteCMPCableResource
 */
public class EJSRemoteCMPCableResource extends com.hps.july.persistence.EJSRemoteCMPCableResource_df1d097a implements CableResource {
	/**
	 * EJSRemoteCMPCableResource
	 */
	public EJSRemoteCMPCableResource() throws java.rmi.RemoteException {
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
