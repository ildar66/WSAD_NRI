package com.hps.july.persistence2;

/**
 * EJSRemoteCMPAntennaCable
 */
public class EJSRemoteCMPAntennaCable extends com.hps.july.persistence2.EJSRemoteCMPAntennaCable_0c548ccb implements AntennaCable {
	/**
	 * EJSRemoteCMPAntennaCable
	 */
	public EJSRemoteCMPAntennaCable() throws java.rmi.RemoteException {
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
