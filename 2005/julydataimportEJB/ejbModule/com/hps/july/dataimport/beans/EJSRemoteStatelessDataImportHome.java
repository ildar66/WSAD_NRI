package com.hps.july.dataimport.beans;

/**
 * EJSRemoteStatelessDataImportHome
 */
public class EJSRemoteStatelessDataImportHome extends com.hps.july.dataimport.beans.EJSRemoteStatelessDataImportHome_bdddcc6f implements com.hps.july.dataimport.beans.DataImportHome {
	/**
	 * EJSRemoteStatelessDataImportHome
	 */
	public EJSRemoteStatelessDataImportHome() throws java.rmi.RemoteException {
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
