package com.hps.july.persistence;

/**
 * EJSRemoteCMPDepartment
 */
public class EJSRemoteCMPDepartment extends com.hps.july.persistence.EJSRemoteCMPDepartment_f0bb03b3 implements Department {
	/**
	 * EJSRemoteCMPDepartment
	 */
	public EJSRemoteCMPDepartment() throws java.rmi.RemoteException {
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
