package com.hps.july.persistence;

/**
 * EJSRemoteCMPImportSessionHome
 */
public class EJSRemoteCMPImportSessionHome extends com.hps.july.persistence.EJSRemoteCMPImportSessionHome_b9c67c10 implements com.hps.july.persistence.ImportSessionHome {
	/**
	 * EJSRemoteCMPImportSessionHome
	 */
	public EJSRemoteCMPImportSessionHome() throws java.rmi.RemoteException {
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
