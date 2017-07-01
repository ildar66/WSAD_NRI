package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessPie2Nri_eb8a8557
 */
public class EJSRemoteStatelessPie2Nri_eb8a8557 extends EJSWrapper implements Pie2Nri {
	/**
	 * EJSRemoteStatelessPie2Nri_eb8a8557
	 */
	public EJSRemoteStatelessPie2Nri_eb8a8557() throws java.rmi.RemoteException {
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
	 * checkWorkBanInPie
	 */
	public boolean checkWorkBanInPie(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.checkWorkBanInPie(idtask);
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
	 * moveAllDnopPie2BufferNri
	 */
	public boolean moveAllDnopPie2BufferNri(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.moveAllDnopPie2BufferNri(idtask);
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
	 * moveAllNri2PIE
	 */
	public boolean moveAllNri2PIE(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.moveAllNri2PIE(idtask);
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
	 * moveBilFromBilling
	 */
	public boolean moveBilFromBilling(java.lang.String bil, int billid, int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.moveBilFromBilling(bil, billid, idtask);
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
	 * movePayFromBilling
	 */
	public boolean movePayFromBilling(int payid, int idtask, java.lang.String autolink) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.movePayFromBilling(payid, idtask, autolink);
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
	 * movePayOnAktBufferNri2Pie
	 */
	public boolean movePayOnAktBufferNri2Pie(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.movePayOnAktBufferNri2Pie(idtask);
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
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 6, _EJS_s);
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
	 * moveAbonentDogovorsPie2BufferNri
	 */
	public void moveAbonentDogovorsPie2BufferNri(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.moveAbonentDogovorsPie2BufferNri(idtask);
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
	/**
	 * moveAllBillPie2BufferNri
	 */
	public void moveAllBillPie2BufferNri(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 8, _EJS_s);
			beanRef.moveAllBillPie2BufferNri(idtask);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * moveAllPaymentPie2BufferNri
	 */
	public void moveAllPaymentPie2BufferNri(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 9, _EJS_s);
			beanRef.moveAllPaymentPie2BufferNri(idtask);
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
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * moveListBanFromNri2Pie
	 */
	public void moveListBanFromNri2Pie(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 10, _EJS_s);
			beanRef.moveListBanFromNri2Pie(idtask);
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
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * moveOneDnop
	 */
	public void moveOneDnop(int idtask, java.sql.ResultSet rsP, int leasebill, int idPaymentNri, int ent_seq_no, int ban, java.sql.PreparedStatement insert, java.sql.PreparedStatement update, java.sql.Statement stateP2, com.hps.july.commonbean.KeyGeneratorAccessBean keygen) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 11, _EJS_s);
			beanRef.moveOneDnop(idtask, rsP, leasebill, idPaymentNri, ent_seq_no, ban, insert, update, stateP2, keygen);
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
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * taskEnd
	 */
	public void taskEnd(int idtask) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.arenda.billing.Pie2NriBean beanRef = (com.hps.july.arenda.billing.Pie2NriBean)container.preInvoke(this, 12, _EJS_s);
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
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
