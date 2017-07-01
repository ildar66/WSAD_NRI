package com.hps.july.persistence;

/**
 * EJSRemoteCMPNamedValue
 */
public class EJSRemoteCMPNamedValue extends com.hps.july.persistence.EJSRemoteCMPNamedValue_f02f46b8 implements NamedValue {
	/**
	 * EJSRemoteCMPNamedValue
	 */
	public EJSRemoteCMPNamedValue() throws java.rmi.RemoteException {
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
