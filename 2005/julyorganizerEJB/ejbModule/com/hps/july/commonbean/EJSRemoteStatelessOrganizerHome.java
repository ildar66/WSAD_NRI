package com.hps.july.commonbean;

/**
 * EJSRemoteStatelessOrganizerHome
 */
public class EJSRemoteStatelessOrganizerHome extends com.hps.july.commonbean.EJSRemoteStatelessOrganizerHome_f060e214 implements com.hps.july.commonbean.OrganizerHome {
	/**
	 * EJSRemoteStatelessOrganizerHome
	 */
	public EJSRemoteStatelessOrganizerHome() throws java.rmi.RemoteException {
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
