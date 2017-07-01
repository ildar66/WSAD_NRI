package com.hps.july.persistence;

/**
 * EJSRemoteCMPResponsibilityType
 */
public class EJSRemoteCMPResponsibilityType extends com.hps.july.persistence.EJSRemoteCMPResponsibilityType_d47ca10c implements ResponsibilityType {
	/**
	 * EJSRemoteCMPResponsibilityType
	 */
	public EJSRemoteCMPResponsibilityType() throws java.rmi.RemoteException {
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
