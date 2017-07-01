package com.hps.july.dataimport.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessDataImport_bdddcc6f
 */
public class EJSRemoteStatelessDataImport_bdddcc6f extends EJSWrapper implements DataImport {
	/**
	 * EJSRemoteStatelessDataImport_bdddcc6f
	 */
	public EJSRemoteStatelessDataImport_bdddcc6f() throws java.rmi.RemoteException {
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
	 * process
	 */
	public int process(java.lang.String xlsFileName, byte[] file, int taskId, int operId) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.dataimport.beans.DataImportBean beanRef = (com.hps.july.dataimport.beans.DataImportBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.process(xlsFileName, file, taskId, operId);
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
	 * processBs
	 */
	public int processBs(java.lang.String xlsFileName, byte[] file, int taskId, int operId, java.util.Map prop) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.dataimport.beans.DataImportBean beanRef = (com.hps.july.dataimport.beans.DataImportBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.processBs(xlsFileName, file, taskId, operId, prop);
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
	/**
	 * processTest
	 */
	public int processTest() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.dataimport.beans.DataImportBean beanRef = (com.hps.july.dataimport.beans.DataImportBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.processTest();
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
