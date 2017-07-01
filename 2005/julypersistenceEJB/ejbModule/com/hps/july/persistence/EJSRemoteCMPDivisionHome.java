package com.hps.july.persistence;

/**
 * EJSRemoteCMPDivisionHome
 */
public class EJSRemoteCMPDivisionHome extends com.hps.july.persistence.EJSRemoteCMPDivisionHome_8ba14c1f implements com.hps.july.persistence.DivisionHome {
	/**
	 * EJSRemoteCMPDivisionHome
	 */
	public EJSRemoteCMPDivisionHome() throws java.rmi.RemoteException {
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
