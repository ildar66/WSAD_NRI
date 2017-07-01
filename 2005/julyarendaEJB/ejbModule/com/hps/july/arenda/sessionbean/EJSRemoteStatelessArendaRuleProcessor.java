package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatelessArendaRuleProcessor
 */
public class EJSRemoteStatelessArendaRuleProcessor extends com.hps.july.arenda.sessionbean.EJSRemoteStatelessArendaRuleProcessor_c7649925 implements ArendaRuleProcessor {
	/**
	 * EJSRemoteStatelessArendaRuleProcessor
	 */
	public EJSRemoteStatelessArendaRuleProcessor() throws java.rmi.RemoteException {
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
