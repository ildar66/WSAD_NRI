package com.hps.july.persistence;

/**
 * EJSRemoteCMPDocumentAction
 */
public class EJSRemoteCMPDocumentAction extends com.hps.july.persistence.EJSRemoteCMPDocumentAction_f5bd2b10 implements DocumentAction {
	/**
	 * EJSRemoteCMPDocumentAction
	 */
	public EJSRemoteCMPDocumentAction() throws java.rmi.RemoteException {
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
