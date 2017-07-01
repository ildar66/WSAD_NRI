package com.hps.july.arenda.sessionbean;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessJournal_408185ce
 */
public class EJSRemoteStatelessJournal_408185ce extends EJSWrapper implements Journal {
	/**
	 * EJSRemoteStatelessJournal_408185ce
	 */
	public EJSRemoteStatelessJournal_408185ce() throws java.rmi.RemoteException {
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
	 * addMsgInJournal
	 */
	public boolean addMsgInJournal(int jrnAction, java.lang.String jrnType, int leaseRule, int leaseDocument, int leaseDocPosition, int leaseDocPosition2, java.util.Date date1, java.util.Date date2, java.math.BigDecimal summ1, java.math.BigDecimal summ2, int currency1, int currency2, int resource1, int resource2, int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.JournalBean beanRef = (com.hps.july.arenda.sessionbean.JournalBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.addMsgInJournal(jrnAction, jrnType, leaseRule, leaseDocument, leaseDocPosition, leaseDocPosition2, date1, date2, summ1, summ2, currency1, currency2, resource1, resource2, idtask);
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
	 * addMsgInJournal
	 */
	public boolean addMsgInJournal(int idtask, java.lang.String jrnType, java.lang.String jrnMsg) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.sessionbean.JournalBean beanRef = (com.hps.july.arenda.sessionbean.JournalBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.addMsgInJournal(idtask, jrnType, jrnMsg);
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
	 * taskStart
	 */
	public int taskStart(int operator, java.lang.String taskType) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.JournalBean beanRef = (com.hps.july.arenda.sessionbean.JournalBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.taskStart(operator, taskType);
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
	/**
	 * taskStart
	 */
	public int taskStart(int operator, java.lang.String taskType, java.util.Date date1, java.util.Date date2, java.lang.Integer economist, java.lang.Integer document) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.arenda.sessionbean.JournalBean beanRef = (com.hps.july.arenda.sessionbean.JournalBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.taskStart(operator, taskType, date1, date2, economist, document);
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * taskEnd
	 */
	public void taskEnd(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.sessionbean.JournalBean beanRef = (com.hps.july.arenda.sessionbean.JournalBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.taskEnd(idtask);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
