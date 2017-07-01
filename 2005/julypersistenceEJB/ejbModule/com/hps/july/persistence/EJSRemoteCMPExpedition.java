package com.hps.july.persistence;

/**
 * EJSRemoteCMPExpedition
 */
public class EJSRemoteCMPExpedition extends com.hps.july.persistence.EJSRemoteCMPExpedition_ced5a42e implements Expedition {
	/**
	 * EJSRemoteCMPExpedition
	 */
	public EJSRemoteCMPExpedition() throws java.rmi.RemoteException {
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
