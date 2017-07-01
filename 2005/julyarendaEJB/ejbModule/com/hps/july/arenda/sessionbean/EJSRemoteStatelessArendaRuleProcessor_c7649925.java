package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessArendaRuleProcessor_c7649925
 */
public class EJSRemoteStatelessArendaRuleProcessor_c7649925 extends EJSWrapper implements ArendaRuleProcessor {
	/**
	 * EJSRemoteStatelessArendaRuleProcessor_c7649925
	 */
	public EJSRemoteStatelessArendaRuleProcessor_c7649925() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
}
