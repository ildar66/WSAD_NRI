package com.hps.july.persistence;

/**
 * EJSRemoteCMPDepartmentHome
 */
public class EJSRemoteCMPDepartmentHome extends com.hps.july.persistence.EJSRemoteCMPDepartmentHome_f0bb03b3 implements com.hps.july.persistence.DepartmentHome {
	/**
	 * EJSRemoteCMPDepartmentHome
	 */
	public EJSRemoteCMPDepartmentHome() throws java.rmi.RemoteException {
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
