package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessAfsActProcessor
 */
public class EJSRemoteStatelessAfsActProcessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessAfsActProcessor_ca1bbce9 implements AfsActProcessor {
	/**
	 * EJSRemoteStatelessAfsActProcessor
	 */
	public EJSRemoteStatelessAfsActProcessor() throws java.rmi.RemoteException {
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
