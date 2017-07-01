package com.hps.july.persistence;

/**
 * EJSRemoteCMPChangeLogDetailsHome
 */
public class EJSRemoteCMPChangeLogDetailsHome extends com.hps.july.persistence.EJSRemoteCMPChangeLogDetailsHome_f1d1fd8b implements com.hps.july.persistence.ChangeLogDetailsHome {
	/**
	 * EJSRemoteCMPChangeLogDetailsHome
	 */
	public EJSRemoteCMPChangeLogDetailsHome() throws java.rmi.RemoteException {
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
