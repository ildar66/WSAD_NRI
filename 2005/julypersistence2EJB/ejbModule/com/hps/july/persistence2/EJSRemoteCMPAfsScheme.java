package com.hps.july.persistence2;

/**
 * EJSRemoteCMPAfsScheme
 */
public class EJSRemoteCMPAfsScheme extends com.hps.july.persistence2.EJSRemoteCMPAfsScheme_3edc0e87 implements AfsScheme {
	/**
	 * EJSRemoteCMPAfsScheme
	 */
	public EJSRemoteCMPAfsScheme() throws java.rmi.RemoteException {
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
