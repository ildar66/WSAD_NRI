package com.hps.july.persistence;

/**
 * EJSRemoteCMPResourceSetPart
 */
public class EJSRemoteCMPResourceSetPart extends com.hps.july.persistence.EJSRemoteCMPResourceSetPart_6281eecd implements ResourceSetPart {
	/**
	 * EJSRemoteCMPResourceSetPart
	 */
	public EJSRemoteCMPResourceSetPart() throws java.rmi.RemoteException {
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
