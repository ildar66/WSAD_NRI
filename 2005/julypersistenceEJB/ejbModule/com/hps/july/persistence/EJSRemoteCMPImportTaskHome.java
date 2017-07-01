package com.hps.july.persistence;

/**
 * EJSRemoteCMPImportTaskHome
 */
public class EJSRemoteCMPImportTaskHome extends com.hps.july.persistence.EJSRemoteCMPImportTaskHome_d16625d7 implements com.hps.july.persistence.ImportTaskHome {
	/**
	 * EJSRemoteCMPImportTaskHome
	 */
	public EJSRemoteCMPImportTaskHome() throws java.rmi.RemoteException {
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
