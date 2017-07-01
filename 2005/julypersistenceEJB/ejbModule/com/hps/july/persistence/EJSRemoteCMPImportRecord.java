package com.hps.july.persistence;

/**
 * EJSRemoteCMPImportRecord
 */
public class EJSRemoteCMPImportRecord extends com.hps.july.persistence.EJSRemoteCMPImportRecord_dac5a1dd implements ImportRecord {
	/**
	 * EJSRemoteCMPImportRecord
	 */
	public EJSRemoteCMPImportRecord() throws java.rmi.RemoteException {
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
