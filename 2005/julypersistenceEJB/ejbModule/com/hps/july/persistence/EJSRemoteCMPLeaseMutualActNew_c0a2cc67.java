package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPLeaseMutualActNew_c0a2cc67
 */
public class EJSRemoteCMPLeaseMutualActNew_c0a2cc67 extends EJSWrapper implements LeaseMutualActNew {
	/**
	 * EJSRemoteCMPLeaseMutualActNew_c0a2cc67
	 */
	public EJSRemoteCMPLeaseMutualActNew_c0a2cc67() throws java.rmi.RemoteException {
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
	 * getIstemp
	 */
	public boolean getIstemp() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getIstemp();
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
	 * getLeaseMutualReglamentKey
	 */
	public com.hps.july.persistence.LeaseDocumentKey getLeaseMutualReglamentKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseDocumentKey _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getLeaseMutualReglamentKey();
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
	 * getLeaseMutualReglament
	 */
	public com.hps.july.persistence.LeaseMutualReglament getLeaseMutualReglament() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.LeaseMutualReglament _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getLeaseMutualReglament();
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
	 * getLeaseDocument
	 */
	public int getLeaseDocument() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getLeaseDocument();
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
	 * getRegionid
	 */
	public int getRegionid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getRegionid();
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
	 * getIsSchetFakt
	 */
	public java.lang.Boolean getIsSchetFakt() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getIsSchetFakt();
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
	 * getMutualNDS
	 */
	public java.lang.Boolean getMutualNDS() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getMutualNDS();
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
	 * getCreatedby
	 */
	public java.lang.Integer getCreatedby() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getCreatedby();
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
	 * getModifiedby
	 */
	public java.lang.Integer getModifiedby() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getModifiedby();
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
	 * getOperator
	 */
	public java.lang.Integer getOperator() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getOperator();
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
	 * getDocumentNumber
	 */
	public java.lang.String getDocumentNumber() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getDocumentNumber();
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
	 * getActState
	 */
	public java.lang.String getActState() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.getActState();
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
	 * getActfilename
	 */
	public java.lang.String getActfilename() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getActfilename();
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
	 * getFooter
	 */
	public java.lang.String getFooter() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getFooter();
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
	 * getHeader
	 */
	public java.lang.String getHeader() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getHeader();
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
	 * getDocumentDate
	 */
	public java.sql.Date getDocumentDate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getDocumentDate();
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
	 * getActenddate
	 */
	public java.sql.Date getActenddate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getActenddate();
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
	 * getActstartdate
	 */
	public java.sql.Date getActstartdate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getActstartdate();
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
	/**
	 * getCreated
	 */
	public java.sql.Timestamp getCreated() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Timestamp _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getCreated();
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
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getModified
	 */
	public java.sql.Timestamp getModified() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Timestamp _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getModified();
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
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseRules
	 */
	public java.util.Enumeration getLeaseRules() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.getLeaseRules();
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
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseTaskStarts
	 */
	public java.util.Enumeration getLeaseTaskStarts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.getLeaseTaskStarts();
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
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseCalcRates
	 */
	public java.util.Enumeration getLeaseCalcRates() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.getLeaseCalcRates();
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
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseDNOPs
	 */
	public java.util.Enumeration getLeaseDNOPs() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.getLeaseDNOPs();
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseDocPositions
	 */
	public java.util.Enumeration getLeaseDocPositions() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.getLeaseDocPositions();
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
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseSaldos
	 */
	public java.util.Enumeration getLeaseSaldos() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.getLeaseSaldos();
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
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseSchetFakts
	 */
	public java.util.Enumeration getLeaseSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 26, _EJS_s);
			_EJS_result = beanRef.getLeaseSchetFakts();
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
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseVPayments
	 */
	public java.util.Enumeration getLeaseVPayments() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 27, _EJS_s);
			_EJS_result = beanRef.getLeaseVPayments();
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
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Hashtable _EJS_result = null;
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 28, _EJS_s);
			_EJS_result = beanRef._copyFromEJB();
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
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addLeaseRules
	 */
	public void addLeaseRules(com.hps.july.persistence.LeaseRule aLeaseRules) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 29, _EJS_s);
			beanRef.addLeaseRules(aLeaseRules);
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
				container.postInvoke(this, 29, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseTaskStarts
	 */
	public void addLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 30, _EJS_s);
			beanRef.addLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLeaseTaskStarts
	 */
	public void removeLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 31, _EJS_s);
			beanRef.removeLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseRules
	 */
	public void secondaryAddLeaseRules(com.hps.july.persistence.LeaseRule aLeaseRules) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 32, _EJS_s);
			beanRef.secondaryAddLeaseRules(aLeaseRules);
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
				container.postInvoke(this, 32, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseTaskStarts
	 */
	public void secondaryAddLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 33, _EJS_s);
			beanRef.secondaryAddLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 33, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseRules
	 */
	public void secondaryRemoveLeaseRules(com.hps.july.persistence.LeaseRule aLeaseRules) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 34, _EJS_s);
			beanRef.secondaryRemoveLeaseRules(aLeaseRules);
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
				container.postInvoke(this, 34, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseTaskStarts
	 */
	public void secondaryRemoveLeaseTaskStarts(com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 35, _EJS_s);
			beanRef.secondaryRemoveLeaseTaskStarts(aLeaseTaskStarts);
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
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCreated
	 */
	public void setCreated(java.sql.Timestamp newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 36, _EJS_s);
			beanRef.setCreated(newValue);
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
				container.postInvoke(this, 36, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCreatedby
	 */
	public void setCreatedby(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 37, _EJS_s);
			beanRef.setCreatedby(newValue);
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
				container.postInvoke(this, 37, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDocumentDate
	 */
	public void setDocumentDate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 38, _EJS_s);
			beanRef.setDocumentDate(newValue);
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
				container.postInvoke(this, 38, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDocumentNumber
	 */
	public void setDocumentNumber(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 39, _EJS_s);
			beanRef.setDocumentNumber(newValue);
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
				container.postInvoke(this, 39, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLeaseDocument
	 */
	public void setLeaseDocument(int newLeaseDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 40, _EJS_s);
			beanRef.setLeaseDocument(newLeaseDocument);
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
				container.postInvoke(this, 40, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setModified
	 */
	public void setModified(java.sql.Timestamp newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 41, _EJS_s);
			beanRef.setModified(newValue);
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
				container.postInvoke(this, 41, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setModifiedby
	 */
	public void setModifiedby(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 42, _EJS_s);
			beanRef.setModifiedby(newValue);
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
				container.postInvoke(this, 42, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOperator
	 */
	public void setOperator(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 43, _EJS_s);
			beanRef.setOperator(newValue);
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
				container.postInvoke(this, 43, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setRegionid
	 */
	public void setRegionid(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 44, _EJS_s);
			beanRef.setRegionid(newValue);
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
				container.postInvoke(this, 44, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseCalcRates
	 */
	public void addLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 45, _EJS_s);
			beanRef.addLeaseCalcRates(aLeaseCalcRates);
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
				container.postInvoke(this, 45, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseDNOPs
	 */
	public void addLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 46, _EJS_s);
			beanRef.addLeaseDNOPs(aLeaseDNOPs);
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
				container.postInvoke(this, 46, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseDocPositions
	 */
	public void addLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 47, _EJS_s);
			beanRef.addLeaseDocPositions(aLeaseDocPositions);
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
				container.postInvoke(this, 47, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseSaldos
	 */
	public void addLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 48, _EJS_s);
			beanRef.addLeaseSaldos(aLeaseSaldos);
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
				container.postInvoke(this, 48, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeaseSchetFakts
	 */
	public void addLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 49, _EJS_s);
			beanRef.addLeaseSchetFakts(aLeaseSchetFakts);
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
				container.postInvoke(this, 49, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * privateSetLeaseMutualReglamentKey
	 */
	public void privateSetLeaseMutualReglamentKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 50, _EJS_s);
			beanRef.privateSetLeaseMutualReglamentKey(inKey);
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
				container.postInvoke(this, 50, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLeaseCalcRates
	 */
	public void removeLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 51, _EJS_s);
			beanRef.removeLeaseCalcRates(aLeaseCalcRates);
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
				container.postInvoke(this, 51, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLeaseDNOPs
	 */
	public void removeLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 52, _EJS_s);
			beanRef.removeLeaseDNOPs(aLeaseDNOPs);
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
				container.postInvoke(this, 52, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLeaseDocPositions
	 */
	public void removeLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 53, _EJS_s);
			beanRef.removeLeaseDocPositions(aLeaseDocPositions);
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
				container.postInvoke(this, 53, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLeaseSaldos
	 */
	public void removeLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 54, _EJS_s);
			beanRef.removeLeaseSaldos(aLeaseSaldos);
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
				container.postInvoke(this, 54, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeLeaseSchetFakts
	 */
	public void removeLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 55, _EJS_s);
			beanRef.removeLeaseSchetFakts(aLeaseSchetFakts);
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
				container.postInvoke(this, 55, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseCalcRates
	 */
	public void secondaryAddLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 56, _EJS_s);
			beanRef.secondaryAddLeaseCalcRates(aLeaseCalcRates);
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
				container.postInvoke(this, 56, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseDNOPs
	 */
	public void secondaryAddLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 57, _EJS_s);
			beanRef.secondaryAddLeaseDNOPs(aLeaseDNOPs);
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
				container.postInvoke(this, 57, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseDocPositions
	 */
	public void secondaryAddLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 58, _EJS_s);
			beanRef.secondaryAddLeaseDocPositions(aLeaseDocPositions);
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
				container.postInvoke(this, 58, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseSaldos
	 */
	public void secondaryAddLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 59, _EJS_s);
			beanRef.secondaryAddLeaseSaldos(aLeaseSaldos);
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
				container.postInvoke(this, 59, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseSchetFakts
	 */
	public void secondaryAddLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 60, _EJS_s);
			beanRef.secondaryAddLeaseSchetFakts(aLeaseSchetFakts);
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
				container.postInvoke(this, 60, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseVPayments
	 */
	public void secondaryAddLeaseVPayments(com.hps.july.persistence.LeaseVPayment aLeaseVPayments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 61, _EJS_s);
			beanRef.secondaryAddLeaseVPayments(aLeaseVPayments);
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
				container.postInvoke(this, 61, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseCalcRates
	 */
	public void secondaryRemoveLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 62, _EJS_s);
			beanRef.secondaryRemoveLeaseCalcRates(aLeaseCalcRates);
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
				container.postInvoke(this, 62, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseDNOPs
	 */
	public void secondaryRemoveLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 63, _EJS_s);
			beanRef.secondaryRemoveLeaseDNOPs(aLeaseDNOPs);
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
				container.postInvoke(this, 63, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseDocPositions
	 */
	public void secondaryRemoveLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 64, _EJS_s);
			beanRef.secondaryRemoveLeaseDocPositions(aLeaseDocPositions);
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
				container.postInvoke(this, 64, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseSaldos
	 */
	public void secondaryRemoveLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 65, _EJS_s);
			beanRef.secondaryRemoveLeaseSaldos(aLeaseSaldos);
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
				container.postInvoke(this, 65, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseSchetFakts
	 */
	public void secondaryRemoveLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 66, _EJS_s);
			beanRef.secondaryRemoveLeaseSchetFakts(aLeaseSchetFakts);
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
				container.postInvoke(this, 66, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseVPayments
	 */
	public void secondaryRemoveLeaseVPayments(com.hps.july.persistence.LeaseVPayment aLeaseVPayments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 67, _EJS_s);
			beanRef.secondaryRemoveLeaseVPayments(aLeaseVPayments);
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
				container.postInvoke(this, 67, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetLeaseMutualReglament
	 */
	public void secondarySetLeaseMutualReglament(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglament) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 68, _EJS_s);
			beanRef.secondarySetLeaseMutualReglament(aLeaseMutualReglament);
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
				container.postInvoke(this, 68, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setActState
	 */
	public void setActState(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 69, _EJS_s);
			beanRef.setActState(newValue);
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
				container.postInvoke(this, 69, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setActenddate
	 */
	public void setActenddate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 70, _EJS_s);
			beanRef.setActenddate(newValue);
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
				container.postInvoke(this, 70, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setActstartdate
	 */
	public void setActstartdate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 71, _EJS_s);
			beanRef.setActstartdate(newValue);
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
				container.postInvoke(this, 71, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setFooter
	 */
	public void setFooter(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 72, _EJS_s);
			beanRef.setFooter(newValue);
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
				container.postInvoke(this, 72, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setHeader
	 */
	public void setHeader(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 73, _EJS_s);
			beanRef.setHeader(newValue);
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
				container.postInvoke(this, 73, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIsSchetFakt
	 */
	public void setIsSchetFakt(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 74, _EJS_s);
			beanRef.setIsSchetFakt(newValue);
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
				container.postInvoke(this, 74, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setIstemp
	 */
	public void setIstemp(boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 75, _EJS_s);
			beanRef.setIstemp(newValue);
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
				container.postInvoke(this, 75, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setLeaseMutualReglament
	 */
	public void setLeaseMutualReglament(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglament) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 76, _EJS_s);
			beanRef.setLeaseMutualReglament(aLeaseMutualReglament);
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
				container.postInvoke(this, 76, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setMutualNDS
	 */
	public void setMutualNDS(java.lang.Boolean newMutualNDS) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 77, _EJS_s);
			beanRef.setMutualNDS(newMutualNDS);
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
				container.postInvoke(this, 77, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.LeaseMutualActNewBean beanRef = (com.hps.july.persistence.LeaseMutualActNewBean)container.preInvoke(this, 78, _EJS_s);
			beanRef._copyToEJB(arg0);
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
				container.postInvoke(this, 78, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
