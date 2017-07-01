package com.hps.july.trailcom.beans;

/**
 * EJSRemoteStatelessTrailcomProcessor
 */
public class EJSRemoteStatelessTrailcomProcessor extends com.hps.july.trailcom.beans.EJSRemoteStatelessTrailcomProcessor_13c33bc9 implements TrailcomProcessor {
	/**
	 * EJSRemoteStatelessTrailcomProcessor
	 */
	public EJSRemoteStatelessTrailcomProcessor() throws java.rmi.RemoteException {
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
