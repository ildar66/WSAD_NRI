package com.hps.july.persistence;

/**
 * EJSRemoteCMPI13nAct
 */
public class EJSRemoteCMPI13nAct extends com.hps.july.persistence.EJSRemoteCMPI13nAct_90887391 implements I13nAct {
	/**
	 * EJSRemoteCMPI13nAct
	 */
	public EJSRemoteCMPI13nAct() throws java.rmi.RemoteException {
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
