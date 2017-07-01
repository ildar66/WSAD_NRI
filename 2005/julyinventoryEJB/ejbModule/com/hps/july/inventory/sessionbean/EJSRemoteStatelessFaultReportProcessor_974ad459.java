package com.hps.july.inventory.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessFaultReportProcessor_974ad459
 */
public class EJSRemoteStatelessFaultReportProcessor_974ad459 extends EJSWrapper implements FaultReportProcessor {
	/**
	 * EJSRemoteStatelessFaultReportProcessor_974ad459
	 */
	public EJSRemoteStatelessFaultReportProcessor_974ad459() throws java.rmi.RemoteException {
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
	 * applyFaultReport
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException applyFaultReport(java.lang.Integer docCode) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.FaultReportProcessorBean beanRef = (com.hps.july.inventory.sessionbean.FaultReportProcessorBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.applyFaultReport(docCode);
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
	 * cancelFaultReport
	 */
	public com.hps.july.inventory.sessionbean.DocumentProcessingException cancelFaultReport(java.lang.Integer argDoc) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.inventory.sessionbean.DocumentProcessingException _EJS_result = null;
		try {
			com.hps.july.inventory.sessionbean.FaultReportProcessorBean beanRef = (com.hps.july.inventory.sessionbean.FaultReportProcessorBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.cancelFaultReport(argDoc);
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
