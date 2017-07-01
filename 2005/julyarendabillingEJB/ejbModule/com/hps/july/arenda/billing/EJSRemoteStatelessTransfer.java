package com.hps.july.arenda.billing;

/**
 * EJSRemoteStatelessTransfer
 */
public class EJSRemoteStatelessTransfer extends com.hps.july.arenda.billing.EJSRemoteStatelessTransfer_401727ca implements Transfer {
	/**
	 * EJSRemoteStatelessTransfer
	 */
	public EJSRemoteStatelessTransfer() throws java.rmi.RemoteException {
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
