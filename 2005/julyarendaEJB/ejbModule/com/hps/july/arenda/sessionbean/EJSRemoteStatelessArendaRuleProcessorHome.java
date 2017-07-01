package com.hps.july.arenda.sessionbean;

/**
 * EJSRemoteStatelessArendaRuleProcessorHome
 */
public class EJSRemoteStatelessArendaRuleProcessorHome extends com.hps.july.arenda.sessionbean.EJSRemoteStatelessArendaRuleProcessorHome_c7649925 implements com.hps.july.arenda.sessionbean.ArendaRuleProcessorHome {
	/**
	 * EJSRemoteStatelessArendaRuleProcessorHome
	 */
	public EJSRemoteStatelessArendaRuleProcessorHome() throws java.rmi.RemoteException {
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
