package com.hps.july.arenda.billing;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessBillingRequiredNew_5f114f3d
 */
public class EJSRemoteStatelessBillingRequiredNew_5f114f3d extends EJSWrapper implements BillingRequiredNew {
	/**
	 * EJSRemoteStatelessBillingRequiredNew_5f114f3d
	 */
	public EJSRemoteStatelessBillingRequiredNew_5f114f3d() throws java.rmi.RemoteException {
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
	 * cancelMovePayOnAktNri2BufferNri
	 */
	public boolean cancelMovePayOnAktNri2BufferNri(int idtask, java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.cancelMovePayOnAktNri2BufferNri(idtask, idAct);
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
	 * checkPossibleMoveBill2Nri
	 */
	public boolean checkPossibleMoveBill2Nri(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.checkPossibleMoveBill2Nri(idtask, idBill);
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
	 * checkPossibleMovePayment2Nri
	 */
	public boolean checkPossibleMovePayment2Nri(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.checkPossibleMovePayment2Nri(idtask, idPay);
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
	 * defineSumPayNeedForNri
	 */
	public boolean defineSumPayNeedForNri(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.defineSumPayNeedForNri(idtask, idPay);
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
	 * getAbonentPaymentByHand
	 */
	public boolean getAbonentPaymentByHand(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getAbonentPaymentByHand(idtask, idPay);
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
	 * moveOneDnopBufferNri2Nri
	 */
	public boolean moveOneDnopBufferNri2Nri(int idtask, java.lang.Integer idDnop) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.moveOneDnopBufferNri2Nri(idtask, idDnop);
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
	 * movePayOnAktNri2BufferNri
	 */
	public boolean movePayOnAktNri2BufferNri(int idtask, java.lang.Integer idAct) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.movePayOnAktNri2BufferNri(idtask, idAct);
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
	 * removeBillPos2DocPos
	 */
	public boolean removeBillPos2DocPos(int idtask, java.lang.Integer idBillPos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.removeBillPos2DocPos(idtask, idBillPos);
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
		return _EJS_result;
	}
	/**
	 * removePayments2DocPos
	 */
	public boolean removePayments2DocPos(int idtask, int idPay) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.removePayments2DocPos(idtask, idPay);
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
		return _EJS_result;
	}
	/**
	 * setParamBillForMoveBill2Nri
	 */
	public boolean setParamBillForMoveBill2Nri(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.setParamBillForMoveBill2Nri(idtask, idBill);
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
		return _EJS_result;
	}
	/**
	 * workAbonentBillPos
	 */
	public boolean workAbonentBillPos(int idtask, java.lang.Integer leaseBill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.workAbonentBillPos(idtask, leaseBill);
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
		return _EJS_result;
	}
	/**
	 * workAbonentPayment
	 */
	public boolean workAbonentPayment(int idtask, java.lang.Integer idPay) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.workAbonentPayment(idtask, idPay);
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
		return _EJS_result;
	}
	/**
	 * getBillFlagNeed
	 */
	public java.lang.Boolean getBillFlagNeed(int idtask, java.lang.Integer idBill) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getBillFlagNeed(idtask, idBill);
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
		return _EJS_result;
	}
	/**
	 * getAllAbonentBillsByFlag
	 */
	public java.lang.Object[] getAllAbonentBillsByFlag(int idtask, java.lang.String flag) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getAllAbonentBillsByFlag(idtask, flag);
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
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAllAbonentDnopByFlag
	 */
	public java.lang.Object[] getAllAbonentDnopByFlag(int idtask, java.lang.String flag) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getAllAbonentDnopByFlag(idtask, flag);
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
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAllPaymentByFlag
	 */
	public java.lang.Object[] getAllPaymentByFlag(int idtask, java.lang.String flag) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getAllPaymentByFlag(idtask, flag);
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
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDeletingAbonentBill
	 */
	public java.lang.Object[] getDeletingAbonentBill(int idtask, java.lang.Integer ban, java.util.Date dateStart) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getDeletingAbonentBill(idtask, ban, dateStart);
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
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDeletingAbonentPayment
	 */
	public java.lang.Object[] getDeletingAbonentPayment(int idtask, java.lang.Integer ban, java.util.Date dateStart) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Object[] _EJS_result = null;
		try {
			com.hps.july.arenda.billing.BillingRequiredNewBean beanRef = (com.hps.july.arenda.billing.BillingRequiredNewBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getDeletingAbonentPayment(idtask, ban, dateStart);
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
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}
