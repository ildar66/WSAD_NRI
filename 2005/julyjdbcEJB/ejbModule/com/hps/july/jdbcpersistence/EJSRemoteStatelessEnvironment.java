package com.hps.july.jdbcpersistence;

/**
 * EJSRemoteStatelessEnvironment
 */
public class EJSRemoteStatelessEnvironment extends com.hps.july.jdbcpersistence.EJSRemoteStatelessEnvironment_8f8f4d52 implements Environment {
	/**
	 * EJSRemoteStatelessEnvironment
	 */
	public EJSRemoteStatelessEnvironment() throws java.rmi.RemoteException {
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
