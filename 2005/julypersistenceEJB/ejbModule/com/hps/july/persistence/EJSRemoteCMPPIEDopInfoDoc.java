package com.hps.july.persistence;

/**
 * EJSRemoteCMPPIEDopInfoDoc
 */
public class EJSRemoteCMPPIEDopInfoDoc extends com.hps.july.persistence.EJSRemoteCMPPIEDopInfoDoc_fc0be349 implements PIEDopInfoDoc {
	/**
	 * EJSRemoteCMPPIEDopInfoDoc
	 */
	public EJSRemoteCMPPIEDopInfoDoc() throws java.rmi.RemoteException {
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
