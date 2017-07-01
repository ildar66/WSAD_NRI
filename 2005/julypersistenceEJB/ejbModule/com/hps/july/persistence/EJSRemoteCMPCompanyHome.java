package com.hps.july.persistence;

/**
 * EJSRemoteCMPCompanyHome
 */
public class EJSRemoteCMPCompanyHome extends com.hps.july.persistence.EJSRemoteCMPCompanyHome_d6330f7d implements com.hps.july.persistence.CompanyHome {
	/**
	 * EJSRemoteCMPCompanyHome
	 */
	public EJSRemoteCMPCompanyHome() throws java.rmi.RemoteException {
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
