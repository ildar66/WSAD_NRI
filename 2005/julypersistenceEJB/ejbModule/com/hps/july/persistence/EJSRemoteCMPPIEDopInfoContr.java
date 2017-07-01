package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEDopInfoContr
 */
public class EJSRemoteCMPPIEDopInfoContr extends com.hps.july.persistence.EJSRemoteCMPPIEDopInfoContr_1d890592 implements PIEDopInfoContr {
	/**
	 * EJSRemoteCMPPIEDopInfoContr
	 */
	public EJSRemoteCMPPIEDopInfoContr() throws java.rmi.RemoteException {
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
