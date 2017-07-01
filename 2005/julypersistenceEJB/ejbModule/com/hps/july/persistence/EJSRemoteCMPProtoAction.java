package com.hps.july.persistence;

/**
 * EJSRemoteCMPProtoAction
 */
public class EJSRemoteCMPProtoAction extends com.hps.july.persistence.EJSRemoteCMPProtoAction_80500ecc implements ProtoAction {
	/**
	 * EJSRemoteCMPProtoAction
	 */
	public EJSRemoteCMPProtoAction() throws java.rmi.RemoteException {
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
