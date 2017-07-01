package com.hps.july.commonbean;

/**
 * EJSRemoteStatelessKeyGenerator
 */
public class EJSRemoteStatelessKeyGenerator extends com.hps.july.commonbean.EJSRemoteStatelessKeyGenerator_96ee1f72 implements KeyGenerator {
	/**
	 * EJSRemoteStatelessKeyGenerator
	 */
	public EJSRemoteStatelessKeyGenerator() throws java.rmi.RemoteException {
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
