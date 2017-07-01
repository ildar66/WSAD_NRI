package com.hps.july.dataimport.beans;

/**
 * EJSRemoteStatelessDataImport
 */
public class EJSRemoteStatelessDataImport extends com.hps.july.dataimport.beans.EJSRemoteStatelessDataImport_bdddcc6f implements DataImport {
	/**
	 * EJSRemoteStatelessDataImport
	 */
	public EJSRemoteStatelessDataImport() throws java.rmi.RemoteException {
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
