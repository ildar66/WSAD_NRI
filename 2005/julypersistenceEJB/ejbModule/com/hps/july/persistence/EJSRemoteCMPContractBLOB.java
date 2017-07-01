package com.hps.july.persistence;

/**
 * EJSRemoteCMPContractBLOB
 */
public class EJSRemoteCMPContractBLOB extends com.hps.july.persistence.EJSRemoteCMPContractBLOB_a15f3a15 implements ContractBLOB {
	/**
	 * EJSRemoteCMPContractBLOB
	 */
	public EJSRemoteCMPContractBLOB() throws java.rmi.RemoteException {
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
