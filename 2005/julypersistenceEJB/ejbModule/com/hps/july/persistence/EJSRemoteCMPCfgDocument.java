package com.hps.july.persistence;

/**
 * EJSRemoteCMPCfgDocument
 */
public class EJSRemoteCMPCfgDocument extends com.hps.july.persistence.EJSRemoteCMPCfgDocument_e68167a5 implements CfgDocument {
	/**
	 * EJSRemoteCMPCfgDocument
	 */
	public EJSRemoteCMPCfgDocument() throws java.rmi.RemoteException {
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
