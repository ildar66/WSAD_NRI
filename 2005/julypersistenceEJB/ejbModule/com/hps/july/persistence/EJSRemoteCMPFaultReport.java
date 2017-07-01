package com.hps.july.persistence;

/**
 * EJSRemoteCMPFaultReport
 */
public class EJSRemoteCMPFaultReport extends com.hps.july.persistence.EJSRemoteCMPFaultReport_f73eae9a implements FaultReport {
	/**
	 * EJSRemoteCMPFaultReport
	 */
	public EJSRemoteCMPFaultReport() throws java.rmi.RemoteException {
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
