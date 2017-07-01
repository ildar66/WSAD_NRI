package com.hps.july.persistence2;

/**
 * EJSRemoteCMPResourceSetClass
 */
public class EJSRemoteCMPResourceSetClass extends com.hps.july.persistence2.EJSRemoteCMPResourceSetClass_ec9cb440 implements ResourceSetClass {
	/**
	 * EJSRemoteCMPResourceSetClass
	 */
	public EJSRemoteCMPResourceSetClass() throws java.rmi.RemoteException {
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
