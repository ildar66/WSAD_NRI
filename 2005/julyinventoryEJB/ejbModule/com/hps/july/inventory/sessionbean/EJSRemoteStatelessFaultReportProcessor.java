package com.hps.july.inventory.sessionbean;

/**
 * EJSRemoteStatelessFaultReportProcessor
 */
public class EJSRemoteStatelessFaultReportProcessor extends com.hps.july.inventory.sessionbean.EJSRemoteStatelessFaultReportProcessor_974ad459 implements FaultReportProcessor {
	/**
	 * EJSRemoteStatelessFaultReportProcessor
	 */
	public EJSRemoteStatelessFaultReportProcessor() throws java.rmi.RemoteException {
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
