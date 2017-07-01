package com.hps.july.persistence;

/**
 * EJSRemoteCMPRequest
 */
public class EJSRemoteCMPRequest extends com.hps.july.persistence.EJSRemoteCMPRequest_0e6db469 implements Request {
	/**
	 * EJSRemoteCMPRequest
	 */
	public EJSRemoteCMPRequest() throws java.rmi.RemoteException {
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
