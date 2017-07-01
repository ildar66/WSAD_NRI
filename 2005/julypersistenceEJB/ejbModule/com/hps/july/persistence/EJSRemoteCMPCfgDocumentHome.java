package com.hps.july.persistence;

/**
 * EJSRemoteCMPCfgDocumentHome
 */
public class EJSRemoteCMPCfgDocumentHome extends com.hps.july.persistence.EJSRemoteCMPCfgDocumentHome_e68167a5 implements com.hps.july.persistence.CfgDocumentHome {
	/**
	 * EJSRemoteCMPCfgDocumentHome
	 */
	public EJSRemoteCMPCfgDocumentHome() throws java.rmi.RemoteException {
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
