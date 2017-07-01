package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPPIEPayPlatinumHome_fb1fdc8d
 */
public class EJSRemoteCMPPIEPayPlatinumHome_fb1fdc8d extends EJSWrapper implements com.hps.july.persistence.PIEPayPlatinumHome {
	/**
	 * EJSRemoteCMPPIEPayPlatinumHome_fb1fdc8d
	 */
	public EJSRemoteCMPPIEPayPlatinumHome_fb1fdc8d() throws java.rmi.RemoteException {
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
	 * create
	 */
	public com.hps.july.persistence.PIEPayPlatinum create(java.lang.String argIdpayplatinum, int argOwner, int argIdDogovorNri, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, java.lang.String argFlagWorkNri, java.lang.String argPurpose, int argPayStatePlatinum, java.lang.String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.PIEPayPlatinum _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argIdpayplatinum, argOwner, argIdDogovorNri, argSumm, argSummNds, argValute, argSummRub, argSummNdsRub, argDate, argFlagWorkNri, argPurpose, argPayStatePlatinum, argDocNumber);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * create
	 */
	public com.hps.july.persistence.PIEPayPlatinum create(java.lang.String argIdpayplatinum, int argIdDogovorNri, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, java.lang.String argFlagWorkNri, java.lang.String argPurpose, int argPayStatePlatinum, java.lang.String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.PIEPayPlatinum _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argIdpayplatinum, argIdDogovorNri, argSumm, argSummNds, argValute, argSummRub, argSummNdsRub, argDate, argFlagWorkNri, argPurpose, argPayStatePlatinum, argDocNumber);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEPayPlatinum findByPrimaryKey(com.hps.july.persistence.PIEPayPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.PIEPayPlatinum _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findByPrimaryKey(key);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isDateStart, java.sql.Date argDateStart, java.lang.Boolean isDateEnd, java.sql.Date argDateEnd, java.lang.Boolean isIdDogovNri, java.lang.Integer argIdDogovNri, java.lang.Boolean isFlagWorkNri, java.lang.String argFlagWorkNri, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findByQBE(isDateStart, argDateStart, isDateEnd, argDateEnd, isIdDogovNri, argIdDogovNri, isFlagWorkNri, argFlagWorkNri, order);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * getEJBMetaData
	 */
	public javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.EJBMetaData _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getEJBMetaData();
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
	 * getHomeHandle
	 */
	public javax.ejb.HomeHandle getHomeHandle() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		javax.ejb.HomeHandle _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getHomeHandle();
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
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 6, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
		return ;
	}
	/**
	 * remove
	 */
	public void remove(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d beanRef = (com.hps.july.persistence.EJSCMPPIEPayPlatinumHomeBean_fb1fdc8d)container.preInvoke(this, 7, _EJS_s);
			beanRef.remove(arg0);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
