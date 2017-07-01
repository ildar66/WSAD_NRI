package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocumentPosition
 */
public class EJSRemoteCMPDocumentPosition extends com.hps.july.persistence.EJSRemoteCMPDocumentPosition_d62861c8 implements DocumentPosition {
	/**
	 * EJSRemoteCMPDocumentPosition
	 */
	public EJSRemoteCMPDocumentPosition() throws java.rmi.RemoteException {
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
