package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectTypeHome
 */
public class EJSRemoteCMPProjectTypeHome extends com.hps.july.persistence.EJSRemoteCMPProjectTypeHome_35a970e0 implements com.hps.july.persistence.ProjectTypeHome {
	/**
	 * EJSRemoteCMPProjectTypeHome
	 */
	public EJSRemoteCMPProjectTypeHome() throws java.rmi.RemoteException {
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
