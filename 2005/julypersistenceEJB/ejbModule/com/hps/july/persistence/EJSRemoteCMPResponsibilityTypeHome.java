package com.hps.july.persistence;

/**
 * EJSRemoteCMPResponsibilityTypeHome
 */
public class EJSRemoteCMPResponsibilityTypeHome extends com.hps.july.persistence.EJSRemoteCMPResponsibilityTypeHome_d47ca10c implements com.hps.july.persistence.ResponsibilityTypeHome {
	/**
	 * EJSRemoteCMPResponsibilityTypeHome
	 */
	public EJSRemoteCMPResponsibilityTypeHome() throws java.rmi.RemoteException {
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
