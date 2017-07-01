package com.hps.july.persistence;

/**
 * EJSRemoteCMPService
 */
public class EJSRemoteCMPService extends com.hps.july.persistence.EJSRemoteCMPService_5badf6ae implements Service {
	/**
	 * EJSRemoteCMPService
	 */
	public EJSRemoteCMPService() throws java.rmi.RemoteException {
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
