package com.hps.july.persistence;

/**
 * EJSRemoteCMPI13nActPosition
 */
public class EJSRemoteCMPI13nActPosition extends com.hps.july.persistence.EJSRemoteCMPI13nActPosition_b594314c implements I13nActPosition {
	/**
	 * EJSRemoteCMPI13nActPosition
	 */
	public EJSRemoteCMPI13nActPosition() throws java.rmi.RemoteException {
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
