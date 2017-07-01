package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectActionTypeHome
 */
public class EJSRemoteCMPProjectActionTypeHome extends com.hps.july.persistence.EJSRemoteCMPProjectActionTypeHome_c8c0ae31 implements com.hps.july.persistence.ProjectActionTypeHome {
	/**
	 * EJSRemoteCMPProjectActionTypeHome
	 */
	public EJSRemoteCMPProjectActionTypeHome() throws java.rmi.RemoteException {
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
