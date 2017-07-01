package com.hps.july.commonbean;

/**
 * EJSRemoteStatelessKeyGeneratorHome
 */
public class EJSRemoteStatelessKeyGeneratorHome extends com.hps.july.commonbean.EJSRemoteStatelessKeyGeneratorHome_96ee1f72 implements com.hps.july.commonbean.KeyGeneratorHome {
	/**
	 * EJSRemoteStatelessKeyGeneratorHome
	 */
	public EJSRemoteStatelessKeyGeneratorHome() throws java.rmi.RemoteException {
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
