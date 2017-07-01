package com.hps.july.commonbean;

/**
 * EJSRemoteStatelessOrganizer
 */
public class EJSRemoteStatelessOrganizer extends com.hps.july.commonbean.EJSRemoteStatelessOrganizer_f060e214 implements Organizer {
	/**
	 * EJSRemoteStatelessOrganizer
	 */
	public EJSRemoteStatelessOrganizer() throws java.rmi.RemoteException {
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
