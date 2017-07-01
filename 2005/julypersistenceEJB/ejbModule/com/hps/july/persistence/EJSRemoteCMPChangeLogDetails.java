package com.hps.july.persistence;

/**
 * EJSRemoteCMPChangeLogDetails
 */
public class EJSRemoteCMPChangeLogDetails extends com.hps.july.persistence.EJSRemoteCMPChangeLogDetails_f1d1fd8b implements ChangeLogDetails {
	/**
	 * EJSRemoteCMPChangeLogDetails
	 */
	public EJSRemoteCMPChangeLogDetails() throws java.rmi.RemoteException {
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
