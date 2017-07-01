package com.hps.july.persistence;

/**
 * EJSRemoteCMPIBPMountPos
 */
public class EJSRemoteCMPIBPMountPos extends com.hps.july.persistence.EJSRemoteCMPIBPMountPos_8792ede8 implements IBPMountPos {
	/**
	 * EJSRemoteCMPIBPMountPos
	 */
	public EJSRemoteCMPIBPMountPos() throws java.rmi.RemoteException {
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
