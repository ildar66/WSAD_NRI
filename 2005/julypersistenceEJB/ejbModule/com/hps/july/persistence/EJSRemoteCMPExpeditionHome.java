package com.hps.july.persistence;

/**
 * EJSRemoteCMPExpeditionHome
 */
public class EJSRemoteCMPExpeditionHome extends com.hps.july.persistence.EJSRemoteCMPExpeditionHome_ced5a42e implements com.hps.july.persistence.ExpeditionHome {
	/**
	 * EJSRemoteCMPExpeditionHome
	 */
	public EJSRemoteCMPExpeditionHome() throws java.rmi.RemoteException {
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
