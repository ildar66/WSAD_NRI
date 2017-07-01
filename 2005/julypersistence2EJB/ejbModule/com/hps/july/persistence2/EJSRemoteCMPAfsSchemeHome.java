package com.hps.july.persistence2;

/**
 * EJSRemoteCMPAfsSchemeHome
 */
public class EJSRemoteCMPAfsSchemeHome extends com.hps.july.persistence2.EJSRemoteCMPAfsSchemeHome_3edc0e87 implements com.hps.july.persistence2.AfsSchemeHome {
	/**
	 * EJSRemoteCMPAfsSchemeHome
	 */
	public EJSRemoteCMPAfsSchemeHome() throws java.rmi.RemoteException {
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
