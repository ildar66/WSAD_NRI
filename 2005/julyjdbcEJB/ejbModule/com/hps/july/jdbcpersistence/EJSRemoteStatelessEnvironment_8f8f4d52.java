package com.hps.july.jdbcpersistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessEnvironment_8f8f4d52
 */
public class EJSRemoteStatelessEnvironment_8f8f4d52 extends EJSWrapper implements Environment {
	/**
	 * EJSRemoteStatelessEnvironment_8f8f4d52
	 */
	public EJSRemoteStatelessEnvironment_8f8f4d52() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * getEnvironmentProperties
	 */
	public java.util.Properties getEnvironmentProperties() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Properties _EJS_result = null;
		try {
			com.hps.july.jdbcpersistence.EnvironmentBean beanRef = (com.hps.july.jdbcpersistence.EnvironmentBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getEnvironmentProperties();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
