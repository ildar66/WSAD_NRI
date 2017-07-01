package com.hps.july.commonbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessKeyGenerator_96ee1f72
 */
public class EJSRemoteStatelessKeyGenerator_96ee1f72 extends EJSWrapper implements KeyGenerator {
	/**
	 * EJSRemoteStatelessKeyGenerator_96ee1f72
	 */
	public EJSRemoteStatelessKeyGenerator_96ee1f72() throws java.rmi.RemoteException {
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
	 * getNextKey
	 */
	public int getNextKey(java.lang.String alias) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.commonbean.KeyGeneratorBean beanRef = (com.hps.july.commonbean.KeyGeneratorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getNextKey(alias);
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
