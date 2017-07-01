package com.hps.july.persistence;

/**
 * EJSRemoteCMPProject
 */
public class EJSRemoteCMPProject extends com.hps.july.persistence.EJSRemoteCMPProject_9b5157cc implements Project {
	/**
	 * EJSRemoteCMPProject
	 */
	public EJSRemoteCMPProject() throws java.rmi.RemoteException {
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
