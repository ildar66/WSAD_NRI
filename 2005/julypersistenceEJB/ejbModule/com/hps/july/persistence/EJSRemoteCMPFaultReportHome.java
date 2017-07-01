package com.hps.july.persistence;

/**
 * EJSRemoteCMPFaultReportHome
 */
public class EJSRemoteCMPFaultReportHome extends com.hps.july.persistence.EJSRemoteCMPFaultReportHome_f73eae9a implements com.hps.july.persistence.FaultReportHome {
	/**
	 * EJSRemoteCMPFaultReportHome
	 */
	public EJSRemoteCMPFaultReportHome() throws java.rmi.RemoteException {
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
