package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessI13nActProcessor_811751b8
 */
public class EJSRemoteStatelessI13nActProcessor_811751b8 extends EJSWrapper implements I13nActProcessor {
	/**
	 * EJSRemoteStatelessI13nActProcessor_811751b8
	 */
	public EJSRemoteStatelessI13nActProcessor_811751b8() throws java.rmi.RemoteException {
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
	 * cancelI13nAct
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException cancelI13nAct(java.lang.Integer argAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.I13nActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.I13nActProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.cancelI13nAct(argAct);
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
	/**
	 * processI13nAct
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException processI13nAct(java.lang.Integer argAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.I13nActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.I13nActProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.processI13nAct(argAct);
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
