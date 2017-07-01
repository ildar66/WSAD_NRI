package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseContractHome
 */
public class EJSRemoteCMPLeaseContractHome extends com.hps.july.persistence.EJSRemoteCMPLeaseContractHome_62ebfc4f implements com.hps.july.persistence.LeaseContractHome {
	/**
	 * EJSRemoteCMPLeaseContractHome
	 */
	public EJSRemoteCMPLeaseContractHome() throws java.rmi.RemoteException {
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
