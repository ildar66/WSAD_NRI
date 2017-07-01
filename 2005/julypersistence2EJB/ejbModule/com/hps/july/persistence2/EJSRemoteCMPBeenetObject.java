package com.hps.july.persistence2;

/**
 * EJSRemoteCMPBeenetObject
 */
public class EJSRemoteCMPBeenetObject extends com.hps.july.persistence2.EJSRemoteCMPBeenetObject_f8cb309f implements BeenetObject {
	/**
	 * EJSRemoteCMPBeenetObject
	 */
	public EJSRemoteCMPBeenetObject() throws java.rmi.RemoteException {
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
