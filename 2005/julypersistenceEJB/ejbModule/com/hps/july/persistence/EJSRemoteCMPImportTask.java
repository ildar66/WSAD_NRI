package com.hps.july.persistence;

/**
 * EJSRemoteCMPImportTask
 */
public class EJSRemoteCMPImportTask extends com.hps.july.persistence.EJSRemoteCMPImportTask_d16625d7 implements ImportTask {
	/**
	 * EJSRemoteCMPImportTask
	 */
	public EJSRemoteCMPImportTask() throws java.rmi.RemoteException {
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
