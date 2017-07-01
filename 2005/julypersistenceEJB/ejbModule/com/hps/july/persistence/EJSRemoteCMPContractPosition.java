package com.hps.july.persistence;

/**
 * EJSRemoteCMPContractPosition
 */
public class EJSRemoteCMPContractPosition extends com.hps.july.persistence.EJSRemoteCMPContractPosition_d1d2b2d1 implements ContractPosition {
	/**
	 * EJSRemoteCMPContractPosition
	 */
	public EJSRemoteCMPContractPosition() throws java.rmi.RemoteException {
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
