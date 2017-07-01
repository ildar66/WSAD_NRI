package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectActionType
 */
public class EJSRemoteCMPProjectActionType extends com.hps.july.persistence.EJSRemoteCMPProjectActionType_c8c0ae31 implements ProjectActionType {
	/**
	 * EJSRemoteCMPProjectActionType
	 */
	public EJSRemoteCMPProjectActionType() throws java.rmi.RemoteException {
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
