package com.hps.july.persistence;

/**
 * EJSRemoteCMPPeopleHome
 */
public class EJSRemoteCMPPeopleHome extends com.hps.july.persistence.EJSRemoteCMPPeopleHome_5bd41c74 implements com.hps.july.persistence.PeopleHome {
	/**
	 * EJSRemoteCMPPeopleHome
	 */
	public EJSRemoteCMPPeopleHome() throws java.rmi.RemoteException {
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
