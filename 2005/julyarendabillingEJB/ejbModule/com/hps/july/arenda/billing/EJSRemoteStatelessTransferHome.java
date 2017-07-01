package com.hps.july.arenda.billing;

/**
 * EJSRemoteStatelessTransferHome
 */
public class EJSRemoteStatelessTransferHome extends com.hps.july.arenda.billing.EJSRemoteStatelessTransferHome_401727ca implements com.hps.july.arenda.billing.TransferHome {
	/**
	 * EJSRemoteStatelessTransferHome
	 */
	public EJSRemoteStatelessTransferHome() throws java.rmi.RemoteException {
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
