package com.hps.july.config.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPCfgStoragecard_0467109e
 */
public class EJSRemoteCMPCfgStoragecard_0467109e extends EJSWrapper implements CfgStoragecard {
	/**
	 * EJSRemoteCMPCfgStoragecard_0467109e
	 */
	public EJSRemoteCMPCfgStoragecard_0467109e() throws java.rmi.RemoteException {
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
	 * isIsapproved
	 */
	public boolean isIsapproved() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.isIsapproved();
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
	 * isIsfictserial
	 */
	public boolean isIsfictserial() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		boolean _EJS_result = false;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.isIsfictserial();
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
	 * getOwner
	 */
	public int getOwner() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getOwner();
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
	 * getResource
	 */
	public int getResource() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getResource();
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
	 * getSavconfigid
	 */
	public int getSavconfigid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getSavconfigid();
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
	 * getStoragecard
	 */
	public int getStoragecard() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getStoragecard();
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
	 * getBoxed
	 */
	public java.lang.Boolean getBoxed() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getBoxed();
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
	 * getBroken
	 */
	public java.lang.Boolean getBroken() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getBroken();
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
	 * getContract
	 */
	public java.lang.Integer getContract() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getContract();
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
	 * getDocument
	 */
	public java.lang.Integer getDocument() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getDocument();
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
	 * getStorageplace
	 */
	public java.lang.Integer getStorageplace() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getStorageplace();
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
	 * getClosed
	 */
	public java.lang.String getClosed() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.getClosed();
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
	 * getComment
	 */
	public java.lang.String getComment() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getComment();
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
	 * getConfiguration
	 */
	public java.lang.String getConfiguration() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getConfiguration();
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
	 * getInventserial
	 */
	public java.lang.String getInventserial() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getInventserial();
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
	 * getLocalserial
	 */
	public java.lang.String getLocalserial() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getLocalserial();
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
	 * getNotes
	 */
	public java.lang.String getNotes() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getNotes();
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
	 * getObjectStatus
	 */
	public java.lang.String getObjectStatus() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getObjectStatus();
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
	 * getParty
	 */
	public java.lang.String getParty() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getParty();
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
	 * getPlace
	 */
	public java.lang.String getPlace() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getPlace();
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
	 * getPolicy
	 */
	public java.lang.String getPolicy() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.getPolicy();
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
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSerialnumber
	 */
	public java.lang.String getSerialnumber() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.getSerialnumber();
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
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPrice
	 */
	public java.math.BigDecimal getPrice() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.getPrice();
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
				container.postInvoke(this, 22, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getQty
	 */
	public java.math.BigDecimal getQty() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.getQty();
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getQty_broken
	 */
	public java.math.BigDecimal getQty_broken() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.getQty_broken();
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
				container.postInvoke(this, 24, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDateclosed
	 */
	public java.sql.Date getDateclosed() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.getDateclosed();
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
				container.postInvoke(this, 25, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDateopened
	 */
	public java.sql.Date getDateopened() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 26, _EJS_s);
			_EJS_result = beanRef.getDateopened();
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
				container.postInvoke(this, 26, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getI13ndate
	 */
	public java.sql.Date getI13ndate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 27, _EJS_s);
			_EJS_result = beanRef.getI13ndate();
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
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 28, _EJS_s);
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
	 * setBoxed
	 */
	public void setBoxed(java.lang.Boolean newBoxed) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 29, _EJS_s);
			beanRef.setBoxed(newBoxed);
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
	 * setBroken
	 */
	public void setBroken(java.lang.Boolean newBroken) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 30, _EJS_s);
			beanRef.setBroken(newBroken);
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
	 * setClosed
	 */
	public void setClosed(java.lang.String newClosed) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 31, _EJS_s);
			beanRef.setClosed(newClosed);
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
	 * setComment
	 */
	public void setComment(java.lang.String newComment) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 32, _EJS_s);
			beanRef.setComment(newComment);
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
	 * setConfiguration
	 */
	public void setConfiguration(java.lang.String newConfiguration) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 33, _EJS_s);
			beanRef.setConfiguration(newConfiguration);
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
	 * setContract
	 */
	public void setContract(java.lang.Integer newContract) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 34, _EJS_s);
			beanRef.setContract(newContract);
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
	 * setDateclosed
	 */
	public void setDateclosed(java.sql.Date newDateclosed) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 35, _EJS_s);
			beanRef.setDateclosed(newDateclosed);
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
	 * setDateopened
	 */
	public void setDateopened(java.sql.Date newDateopened) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 36, _EJS_s);
			beanRef.setDateopened(newDateopened);
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
	 * setDocument
	 */
	public void setDocument(java.lang.Integer newDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 37, _EJS_s);
			beanRef.setDocument(newDocument);
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
	 * setI13ndate
	 */
	public void setI13ndate(java.sql.Date newI13ndate) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 38, _EJS_s);
			beanRef.setI13ndate(newI13ndate);
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
	 * setInventserial
	 */
	public void setInventserial(java.lang.String newInventserial) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 39, _EJS_s);
			beanRef.setInventserial(newInventserial);
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
	 * setIsapproved
	 */
	public void setIsapproved(boolean newIsapproved) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 40, _EJS_s);
			beanRef.setIsapproved(newIsapproved);
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
	 * setIsfictserial
	 */
	public void setIsfictserial(boolean newIsfictserial) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 41, _EJS_s);
			beanRef.setIsfictserial(newIsfictserial);
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
	 * setLocalserial
	 */
	public void setLocalserial(java.lang.String newLocalserial) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 42, _EJS_s);
			beanRef.setLocalserial(newLocalserial);
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
	 * setNotes
	 */
	public void setNotes(java.lang.String newNotes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 43, _EJS_s);
			beanRef.setNotes(newNotes);
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
	 * setObjectStatus
	 */
	public void setObjectStatus(java.lang.String newObjectStatus) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 44, _EJS_s);
			beanRef.setObjectStatus(newObjectStatus);
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
	 * setOwner
	 */
	public void setOwner(int newOwner) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 45, _EJS_s);
			beanRef.setOwner(newOwner);
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
	 * setParty
	 */
	public void setParty(java.lang.String newParty) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 46, _EJS_s);
			beanRef.setParty(newParty);
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
	 * setPlace
	 */
	public void setPlace(java.lang.String newPlace) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 47, _EJS_s);
			beanRef.setPlace(newPlace);
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
	 * setPolicy
	 */
	public void setPolicy(java.lang.String newPolicy) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 48, _EJS_s);
			beanRef.setPolicy(newPolicy);
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
	 * setPrice
	 */
	public void setPrice(java.math.BigDecimal newPrice) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 49, _EJS_s);
			beanRef.setPrice(newPrice);
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
	 * setQty
	 */
	public void setQty(java.math.BigDecimal newQty) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 50, _EJS_s);
			beanRef.setQty(newQty);
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
	 * setQty_broken
	 */
	public void setQty_broken(java.math.BigDecimal newQty_broken) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 51, _EJS_s);
			beanRef.setQty_broken(newQty_broken);
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
	 * setResource
	 */
	public void setResource(int newResource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 52, _EJS_s);
			beanRef.setResource(newResource);
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
	 * setSerialnumber
	 */
	public void setSerialnumber(java.lang.String newSerialnumber) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 53, _EJS_s);
			beanRef.setSerialnumber(newSerialnumber);
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
	 * setStorageplace
	 */
	public void setStorageplace(java.lang.Integer newStorageplace) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 54, _EJS_s);
			beanRef.setStorageplace(newStorageplace);
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
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.config.beans.CfgStoragecardBean beanRef = (com.hps.july.config.beans.CfgStoragecardBean)container.preInvoke(this, 55, _EJS_s);
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
				container.postInvoke(this, 55, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
