package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEQueryLog
 */
public class EJSRemoteCMPPIEQueryLog extends com.hps.july.persistence.EJSRemoteCMPPIEQueryLog_a5116b49 implements PIEQueryLog {
	/**
	 * EJSRemoteCMPPIEQueryLog
	 */
	public EJSRemoteCMPPIEQueryLog() throws java.rmi.RemoteException {
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
