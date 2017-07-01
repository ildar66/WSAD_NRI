package com.hps.july.persistence;

/**
 * EJSRemoteCMPLeaseAbonentPhone
 */
public class EJSRemoteCMPLeaseAbonentPhone extends com.hps.july.persistence.EJSRemoteCMPLeaseAbonentPhone_7612459a implements LeaseAbonentPhone {
	/**
	 * EJSRemoteCMPLeaseAbonentPhone
	 */
	public EJSRemoteCMPLeaseAbonentPhone() throws java.rmi.RemoteException {
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
