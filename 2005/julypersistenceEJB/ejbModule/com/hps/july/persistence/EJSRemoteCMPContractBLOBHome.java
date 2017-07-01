package com.hps.july.persistence;

/**
 * EJSRemoteCMPContractBLOBHome
 */
public class EJSRemoteCMPContractBLOBHome extends com.hps.july.persistence.EJSRemoteCMPContractBLOBHome_a15f3a15 implements com.hps.july.persistence.ContractBLOBHome {
	/**
	 * EJSRemoteCMPContractBLOBHome
	 */
	public EJSRemoteCMPContractBLOBHome() throws java.rmi.RemoteException {
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
