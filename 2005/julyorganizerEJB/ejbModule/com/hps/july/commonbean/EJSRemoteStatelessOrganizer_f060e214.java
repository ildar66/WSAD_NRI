package com.hps.july.commonbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessOrganizer_f060e214
 */
public class EJSRemoteStatelessOrganizer_f060e214 extends EJSWrapper implements Organizer {
	/**
	 * EJSRemoteStatelessOrganizer_f060e214
	 */
	public EJSRemoteStatelessOrganizer_f060e214() throws java.rmi.RemoteException {
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
	 * getOperatorTasks
	 */
	public com.hps.july.organizer.valueobject.OperatorTask[] getOperatorTasks(java.lang.String operator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.organizer.valueobject.OperatorTask[] _EJS_result = null;
		try {
			com.hps.july.commonbean.OrganizerBean beanRef = (com.hps.july.commonbean.OrganizerBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getOperatorTasks(operator);
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
