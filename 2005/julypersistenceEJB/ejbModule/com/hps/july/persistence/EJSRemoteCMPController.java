package com.hps.july.persistence;

/**
 * EJSRemoteCMPController
 */
public class EJSRemoteCMPController extends com.hps.july.persistence.EJSRemoteCMPController_7e6b4ceb implements Controller {
	/**
	 * EJSRemoteCMPController
	 */
	public EJSRemoteCMPController() throws java.rmi.RemoteException {
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
