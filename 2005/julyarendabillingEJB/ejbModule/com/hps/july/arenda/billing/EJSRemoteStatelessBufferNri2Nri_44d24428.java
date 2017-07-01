package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessBufferNri2Nri_44d24428
 */
public class EJSRemoteStatelessBufferNri2Nri_44d24428 extends EJSWrapper implements BufferNri2Nri {
	/**
	 * EJSRemoteStatelessBufferNri2Nri_44d24428
	 */
	public EJSRemoteStatelessBufferNri2Nri_44d24428() throws java.rmi.RemoteException {
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
	 * dismissAbonentContract
	 */
	public boolean dismissAbonentContract(int idtask, java.lang.Integer ban, java.util.Date dateStart) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.dismissAbonentContract(idtask, ban, dateStart);
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
	 * moveAllBillBufferNri2Nri
	 */
	public boolean moveAllBillBufferNri2Nri(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.moveAllBillBufferNri2Nri(idtask);
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
	 * moveAllDnopBufferNri2Nri
	 */
	public boolean moveAllDnopBufferNri2Nri(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.moveAllDnopBufferNri2Nri(idtask);
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
	 * moveAllPaymentBufferNri2Nri
	 */
	public boolean moveAllPaymentBufferNri2Nri(int idtask, boolean autoLinkPaymentBen) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.moveAllPaymentBufferNri2Nri(idtask, autoLinkPaymentBen);
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
	 * moveOneBillBufferNri2Nri
	 */
	public boolean moveOneBillBufferNri2Nri(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.moveOneBillBufferNri2Nri(idtask, idBill);
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
		return _EJS_result;
	}
	/**
	 * moveOnePaymentBufferNri2Nri
	 */
	public boolean moveOnePaymentBufferNri2Nri(int idtask, java.lang.Integer idPay, boolean autoLinkPaymentBen) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.moveOnePaymentBufferNri2Nri(idtask, idPay, autoLinkPaymentBen);
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
				container.postInvoke(this, 5, _EJS_s);
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
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 6, _EJS_s);
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
				container.postInvoke(this, 6, _EJS_s);
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
			com.hps.july.arenda.billing.BufferNri2NriBean beanRef = (com.hps.july.arenda.billing.BufferNri2NriBean)container.preInvoke(this, 7, _EJS_s);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
