package com.hps.july.persistence;

/**
 * EJSRemoteCMPContractHome
 */
public class EJSRemoteCMPContractHome extends com.hps.july.persistence.EJSRemoteCMPContractHome_f0f90933 implements com.hps.july.persistence.ContractHome {
	/**
	 * EJSRemoteCMPContractHome
	 */
	public EJSRemoteCMPContractHome() throws java.rmi.RemoteException {
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
