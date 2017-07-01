package com.hps.july.persistence;

/**
 * EJSRemoteCMPOuterDocPosition
 */
public class EJSRemoteCMPOuterDocPosition extends com.hps.july.persistence.EJSRemoteCMPOuterDocPosition_b5a64898 implements OuterDocPosition {
	/**
	 * EJSRemoteCMPOuterDocPosition
	 */
	public EJSRemoteCMPOuterDocPosition() throws java.rmi.RemoteException {
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
