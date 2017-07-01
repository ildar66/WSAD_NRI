package com.hps.july.persistence2;

/**
 * EJSRemoteCMPCounterInfo
 */
public class EJSRemoteCMPCounterInfo extends com.hps.july.persistence2.EJSRemoteCMPCounterInfo_422c08e7 implements CounterInfo {
	/**
	 * EJSRemoteCMPCounterInfo
	 */
	public EJSRemoteCMPCounterInfo() throws java.rmi.RemoteException {
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
