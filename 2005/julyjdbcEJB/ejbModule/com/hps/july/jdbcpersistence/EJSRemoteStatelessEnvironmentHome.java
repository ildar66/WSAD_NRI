package com.hps.july.jdbcpersistence;

/**
 * EJSRemoteStatelessEnvironmentHome
 */
public class EJSRemoteStatelessEnvironmentHome extends com.hps.july.jdbcpersistence.EJSRemoteStatelessEnvironmentHome_8f8f4d52 implements com.hps.july.jdbcpersistence.EnvironmentHome {
	/**
	 * EJSRemoteStatelessEnvironmentHome
	 */
	public EJSRemoteStatelessEnvironmentHome() throws java.rmi.RemoteException {
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
