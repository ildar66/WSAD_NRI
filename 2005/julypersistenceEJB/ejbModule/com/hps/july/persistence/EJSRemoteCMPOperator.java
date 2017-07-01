package com.hps.july.persistence;

/**
 * EJSRemoteCMPOperator
 */
public class EJSRemoteCMPOperator extends com.hps.july.persistence.EJSRemoteCMPOperator_b06d3afd implements Operator {
	/**
	 * EJSRemoteCMPOperator
	 */
	public EJSRemoteCMPOperator() throws java.rmi.RemoteException {
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
