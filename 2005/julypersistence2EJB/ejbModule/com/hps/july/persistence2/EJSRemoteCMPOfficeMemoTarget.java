package com.hps.july.persistence2;

/**
 * EJSRemoteCMPOfficeMemoTarget
 */
public class EJSRemoteCMPOfficeMemoTarget extends com.hps.july.persistence2.EJSRemoteCMPOfficeMemoTarget_d1f1d09e implements OfficeMemoTarget {
	/**
	 * EJSRemoteCMPOfficeMemoTarget
	 */
	public EJSRemoteCMPOfficeMemoTarget() throws java.rmi.RemoteException {
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
