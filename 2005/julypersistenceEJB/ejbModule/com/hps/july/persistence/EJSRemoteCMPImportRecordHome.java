package com.hps.july.persistence;

/**
 * EJSRemoteCMPImportRecordHome
 */
public class EJSRemoteCMPImportRecordHome extends com.hps.july.persistence.EJSRemoteCMPImportRecordHome_dac5a1dd implements com.hps.july.persistence.ImportRecordHome {
	/**
	 * EJSRemoteCMPImportRecordHome
	 */
	public EJSRemoteCMPImportRecordHome() throws java.rmi.RemoteException {
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
