package com.hps.july.persistence;

/**
 * EJSRemoteCMPProjectType
 */
public class EJSRemoteCMPProjectType extends com.hps.july.persistence.EJSRemoteCMPProjectType_35a970e0 implements ProjectType {
	/**
	 * EJSRemoteCMPProjectType
	 */
	public EJSRemoteCMPProjectType() throws java.rmi.RemoteException {
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
