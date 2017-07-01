package com.hps.july.persistence2;

/**
 * EJSRemoteCMPCountry
 */
public class EJSRemoteCMPCountry extends com.hps.july.persistence2.EJSRemoteCMPCountry_26349d7e implements Country {
	/**
	 * EJSRemoteCMPCountry
	 */
	public EJSRemoteCMPCountry() throws java.rmi.RemoteException {
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
