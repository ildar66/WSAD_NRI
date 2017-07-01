package com.hps.july.persistence;

/**
 * EJSRemoteCMPUserReportHome
 */
public class EJSRemoteCMPUserReportHome extends com.hps.july.persistence.EJSRemoteCMPUserReportHome_7abdfa48 implements com.hps.july.persistence.UserReportHome {
	/**
	 * EJSRemoteCMPUserReportHome
	 */
	public EJSRemoteCMPUserReportHome() throws java.rmi.RemoteException {
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
