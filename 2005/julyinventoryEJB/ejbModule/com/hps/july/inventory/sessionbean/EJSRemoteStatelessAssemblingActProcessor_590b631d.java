package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessAssemblingActProcessor_590b631d
 */
public class EJSRemoteStatelessAssemblingActProcessor_590b631d extends EJSWrapper implements AssemblingActProcessor {
	/**
	 * EJSRemoteStatelessAssemblingActProcessor_590b631d
	 */
	public EJSRemoteStatelessAssemblingActProcessor_590b631d() throws java.rmi.RemoteException {
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
	 * applyAssemblingAct
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException applyAssemblingAct(java.lang.Integer actCode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.AssemblingActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.AssemblingActProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.applyAssemblingAct(actCode);
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
	 * cancelAssemblingAct
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException cancelAssemblingAct(java.lang.Integer argAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.AssemblingActProcessorBean beanRef = (com.hps.july.inventory.sessionbean.AssemblingActProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.cancelAssemblingAct(argAct);
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
