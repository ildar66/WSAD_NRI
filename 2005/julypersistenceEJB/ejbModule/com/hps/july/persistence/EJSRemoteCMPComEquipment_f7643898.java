package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPComEquipment_f7643898
 */
public class EJSRemoteCMPComEquipment_f7643898 extends EJSWrapper implements ComEquipment {
	/**
	 * EJSRemoteCMPComEquipment_f7643898
	 */
	public EJSRemoteCMPComEquipment_f7643898() throws java.rmi.RemoteException {
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
	 * getDivision
	 */
	public com.hps.july.persistence.Division getDivision() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Division _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getDivision();
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
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDivisionKey
	 */
	public com.hps.july.persistence.DivisionKey getDivisionKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.DivisionKey _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getDivisionKey();
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
	 * getPosition
	 */
	public com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Position _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getPosition();
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
	 * getResource
	 */
	public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Resource _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getResource();
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
	 * getResourceKey
	 */
	public com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.ResourceKey _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getResourceKey();
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
	 * getPositionKey
	 */
	public com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.StoragePlaceKey _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getPositionKey();
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
	 * getDatasource
	 */
	public int getDatasource() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getDatasource();
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
	 * getStorageplace
	 */
	public int getStorageplace() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 7, _EJS_s);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPwrreserve
	 */
	public java.lang.Boolean getPwrreserve() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getPwrreserve();
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
	 * getCreatedby
	 */
	public java.lang.Integer getCreatedby() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 9, _EJS_s);
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
				container.postInvoke(this, 9, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 10, _EJS_s);
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
				container.postInvoke(this, 10, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 11, _EJS_s);
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
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getComEquipmentType
	 */
	public java.lang.String getComEquipmentType() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getComEquipmentType();
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
	 * getOsinvname
	 */
	public java.lang.String getOsinvname() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getOsinvname();
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
	 * getEquipcomment
	 */
	public java.lang.String getEquipcomment() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getEquipcomment();
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
	 * getEquipmentState
	 */
	public java.lang.String getEquipmentState() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getEquipmentState();
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
	 * getPwrcat
	 */
	public java.lang.String getPwrcat() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getPwrcat();
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
	 * getPwrrescat
	 */
	public java.lang.String getPwrrescat() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getPwrrescat();
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
	 * getAddress
	 */
	public java.lang.String getAddress() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getAddress();
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
	 * getName
	 */
	public java.lang.String getName() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getName();
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
	 * getPwrval
	 */
	public java.math.BigDecimal getPwrval() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.getPwrval();
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
	 * getDateassemb
	 */
	public java.sql.Date getDateassemb() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.getDateassemb();
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
	 * getDatebldbeg
	 */
	public java.sql.Date getDatebldbeg() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.getDatebldbeg();
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
	 * getDatepr
	 */
	public java.sql.Date getDatepr() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 23, _EJS_s);
			_EJS_result = beanRef.getDatepr();
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
	 * getDatetest
	 */
	public java.sql.Date getDatetest() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.getDatetest();
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
	 * getClosedate
	 */
	public java.sql.Date getClosedate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.getClosedate();
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
	 * getCreated
	 */
	public java.sql.Timestamp getCreated() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Timestamp _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 26, _EJS_s);
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
				container.postInvoke(this, 26, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 27, _EJS_s);
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
				container.postInvoke(this, 27, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getAntennes
	 */
	public java.util.Enumeration getAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 28, _EJS_s);
			_EJS_result = beanRef.getAntennes();
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
				container.postInvoke(this, 28, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFaultReport
	 */
	public java.util.Enumeration getFaultReport() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 29, _EJS_s);
			_EJS_result = beanRef.getFaultReport();
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
				container.postInvoke(this, 29, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getProjectActions
	 */
	public java.util.Enumeration getProjectActions() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 30, _EJS_s);
			_EJS_result = beanRef.getProjectActions();
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
				container.postInvoke(this, 30, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCardTrackFrom
	 */
	public java.util.Enumeration getCardTrackFrom() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 31, _EJS_s);
			_EJS_result = beanRef.getCardTrackFrom();
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
				container.postInvoke(this, 31, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getCardTrackTo
	 */
	public java.util.Enumeration getCardTrackTo() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 32, _EJS_s);
			_EJS_result = beanRef.getCardTrackTo();
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
				container.postInvoke(this, 32, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getInDocument
	 */
	public java.util.Enumeration getInDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 33, _EJS_s);
			_EJS_result = beanRef.getInDocument();
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
				container.postInvoke(this, 33, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOutDocument
	 */
	public java.util.Enumeration getOutDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 34, _EJS_s);
			_EJS_result = beanRef.getOutDocument();
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
				container.postInvoke(this, 34, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSitedoc2Splaces
	 */
	public java.util.Enumeration getSitedoc2Splaces() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 35, _EJS_s);
			_EJS_result = beanRef.getSitedoc2Splaces();
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
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getStorageCard
	 */
	public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 36, _EJS_s);
			_EJS_result = beanRef.getStorageCard();
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
				container.postInvoke(this, 36, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 37, _EJS_s);
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
				container.postInvoke(this, 37, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * privateSetResourceKey
	 */
	public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 38, _EJS_s);
			beanRef.privateSetResourceKey(inKey);
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
	 * secondarySetResource
	 */
	public void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 39, _EJS_s);
			beanRef.secondarySetResource(aResource);
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
	 * setComEquipmentType
	 */
	public void setComEquipmentType(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 40, _EJS_s);
			beanRef.setComEquipmentType(newValue);
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
	 * setOsinvname
	 */
	public void setOsinvname(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 41, _EJS_s);
			beanRef.setOsinvname(newValue);
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
	 * setResource
	 */
	public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 42, _EJS_s);
			beanRef.setResource(aResource);
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
	 * addAntennes
	 */
	public void addAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 43, _EJS_s);
			beanRef.addAntennes(anAntennes);
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
	 * addFaultReport
	 */
	public void addFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 44, _EJS_s);
			beanRef.addFaultReport(aFaultReport);
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
	 * addProjectActions
	 */
	public void addProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 45, _EJS_s);
			beanRef.addProjectActions(aProjectActions);
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
	 * privateSetPositionKey
	 */
	public void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 46, _EJS_s);
			beanRef.privateSetPositionKey(inKey);
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
	 * removeProjectActions
	 */
	public void removeProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 47, _EJS_s);
			beanRef.removeProjectActions(aProjectActions);
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
	 * secondaryAddAntennes
	 */
	public void secondaryAddAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 48, _EJS_s);
			beanRef.secondaryAddAntennes(anAntennes);
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
	 * secondaryAddFaultReport
	 */
	public void secondaryAddFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 49, _EJS_s);
			beanRef.secondaryAddFaultReport(aFaultReport);
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
	 * secondaryAddProjectActions
	 */
	public void secondaryAddProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 50, _EJS_s);
			beanRef.secondaryAddProjectActions(aProjectActions);
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
	 * secondaryRemoveAntennes
	 */
	public void secondaryRemoveAntennes(com.hps.july.persistence.Antenna anAntennes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 51, _EJS_s);
			beanRef.secondaryRemoveAntennes(anAntennes);
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
	 * secondaryRemoveFaultReport
	 */
	public void secondaryRemoveFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 52, _EJS_s);
			beanRef.secondaryRemoveFaultReport(aFaultReport);
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
	 * secondaryRemoveProjectActions
	 */
	public void secondaryRemoveProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 53, _EJS_s);
			beanRef.secondaryRemoveProjectActions(aProjectActions);
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
	 * secondarySetPosition
	 */
	public void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 54, _EJS_s);
			beanRef.secondarySetPosition(aPosition);
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
	 * setDatasource
	 */
	public void setDatasource(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 55, _EJS_s);
			beanRef.setDatasource(newValue);
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
	 * setDateassemb
	 */
	public void setDateassemb(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 56, _EJS_s);
			beanRef.setDateassemb(newValue);
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
	 * setDatebldbeg
	 */
	public void setDatebldbeg(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 57, _EJS_s);
			beanRef.setDatebldbeg(newValue);
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
	 * setDatepr
	 */
	public void setDatepr(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 58, _EJS_s);
			beanRef.setDatepr(newValue);
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
	 * setDatetest
	 */
	public void setDatetest(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 59, _EJS_s);
			beanRef.setDatetest(newValue);
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
	 * setEquipcomment
	 */
	public void setEquipcomment(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 60, _EJS_s);
			beanRef.setEquipcomment(newValue);
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
	 * setEquipmentState
	 */
	public void setEquipmentState(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 61, _EJS_s);
			beanRef.setEquipmentState(newValue);
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
	 * setPosition
	 */
	public void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 62, _EJS_s);
			beanRef.setPosition(aPosition);
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
	 * setPwrcat
	 */
	public void setPwrcat(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 63, _EJS_s);
			beanRef.setPwrcat(newValue);
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
	 * setPwrrescat
	 */
	public void setPwrrescat(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 64, _EJS_s);
			beanRef.setPwrrescat(newValue);
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
	 * setPwrreserve
	 */
	public void setPwrreserve(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 65, _EJS_s);
			beanRef.setPwrreserve(newValue);
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
	 * setPwrval
	 */
	public void setPwrval(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 66, _EJS_s);
			beanRef.setPwrval(newValue);
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
	 * addCardTrackFrom
	 */
	public void addCardTrackFrom(com.hps.july.persistence.CardTrack aCardTrackFrom) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 67, _EJS_s);
			beanRef.addCardTrackFrom(aCardTrackFrom);
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
	 * addCardTrackTo
	 */
	public void addCardTrackTo(com.hps.july.persistence.CardTrack aCardTrackTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 68, _EJS_s);
			beanRef.addCardTrackTo(aCardTrackTo);
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
	 * addInDocument
	 */
	public void addInDocument(com.hps.july.persistence.Document anInDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 69, _EJS_s);
			beanRef.addInDocument(anInDocument);
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
	 * addOutDocument
	 */
	public void addOutDocument(com.hps.july.persistence.Document anOutDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 70, _EJS_s);
			beanRef.addOutDocument(anOutDocument);
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
	 * addStorageCard
	 */
	public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 71, _EJS_s);
			beanRef.addStorageCard(aStorageCard);
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
	 * privateSetDivisionKey
	 */
	public void privateSetDivisionKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 72, _EJS_s);
			beanRef.privateSetDivisionKey(inKey);
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
	 * secondaryAddCardTrackFrom
	 */
	public void secondaryAddCardTrackFrom(com.hps.july.persistence.CardTrack aCardTrackFrom) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 73, _EJS_s);
			beanRef.secondaryAddCardTrackFrom(aCardTrackFrom);
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
	 * secondaryAddCardTrackTo
	 */
	public void secondaryAddCardTrackTo(com.hps.july.persistence.CardTrack aCardTrackTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 74, _EJS_s);
			beanRef.secondaryAddCardTrackTo(aCardTrackTo);
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
	 * secondaryAddInDocument
	 */
	public void secondaryAddInDocument(com.hps.july.persistence.Document anInDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 75, _EJS_s);
			beanRef.secondaryAddInDocument(anInDocument);
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
	 * secondaryAddOutDocument
	 */
	public void secondaryAddOutDocument(com.hps.july.persistence.Document anOutDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 76, _EJS_s);
			beanRef.secondaryAddOutDocument(anOutDocument);
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
	 * secondaryAddSitedoc2Splaces
	 */
	public void secondaryAddSitedoc2Splaces(com.hps.july.persistence.Sitedoc2Splace aSitedoc2Splaces) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 77, _EJS_s);
			beanRef.secondaryAddSitedoc2Splaces(aSitedoc2Splaces);
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
	 * secondaryAddStorageCard
	 */
	public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 78, _EJS_s);
			beanRef.secondaryAddStorageCard(aStorageCard);
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
	/**
	 * secondaryRemoveCardTrackFrom
	 */
	public void secondaryRemoveCardTrackFrom(com.hps.july.persistence.CardTrack aCardTrackFrom) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 79, _EJS_s);
			beanRef.secondaryRemoveCardTrackFrom(aCardTrackFrom);
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
				container.postInvoke(this, 79, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveCardTrackTo
	 */
	public void secondaryRemoveCardTrackTo(com.hps.july.persistence.CardTrack aCardTrackTo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 80, _EJS_s);
			beanRef.secondaryRemoveCardTrackTo(aCardTrackTo);
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
				container.postInvoke(this, 80, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveInDocument
	 */
	public void secondaryRemoveInDocument(com.hps.july.persistence.Document anInDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 81, _EJS_s);
			beanRef.secondaryRemoveInDocument(anInDocument);
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
				container.postInvoke(this, 81, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveOutDocument
	 */
	public void secondaryRemoveOutDocument(com.hps.july.persistence.Document anOutDocument) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 82, _EJS_s);
			beanRef.secondaryRemoveOutDocument(anOutDocument);
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
				container.postInvoke(this, 82, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveSitedoc2Splaces
	 */
	public void secondaryRemoveSitedoc2Splaces(com.hps.july.persistence.Sitedoc2Splace aSitedoc2Splaces) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 83, _EJS_s);
			beanRef.secondaryRemoveSitedoc2Splaces(aSitedoc2Splaces);
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
				container.postInvoke(this, 83, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveStorageCard
	 */
	public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 84, _EJS_s);
			beanRef.secondaryRemoveStorageCard(aStorageCard);
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
				container.postInvoke(this, 84, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetDivision
	 */
	public void secondarySetDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 85, _EJS_s);
			beanRef.secondarySetDivision(aDivision);
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
				container.postInvoke(this, 85, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAddress
	 */
	public void setAddress(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 86, _EJS_s);
			beanRef.setAddress(newValue);
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
				container.postInvoke(this, 86, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setClosedate
	 */
	public void setClosedate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 87, _EJS_s);
			beanRef.setClosedate(newValue);
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
				container.postInvoke(this, 87, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 88, _EJS_s);
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
				container.postInvoke(this, 88, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 89, _EJS_s);
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
				container.postInvoke(this, 89, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDivision
	 */
	public void setDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 90, _EJS_s);
			beanRef.setDivision(aDivision);
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
				container.postInvoke(this, 90, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 91, _EJS_s);
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
				container.postInvoke(this, 91, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 92, _EJS_s);
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
				container.postInvoke(this, 92, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setName
	 */
	public void setName(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 93, _EJS_s);
			beanRef.setName(newValue);
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
				container.postInvoke(this, 93, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setOperator
	 */
	public void setOperator(java.lang.Integer newOperator) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 94, _EJS_s);
			beanRef.setOperator(newOperator);
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
				container.postInvoke(this, 94, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setStorageplace
	 */
	public void setStorageplace(int newStorageplace) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 95, _EJS_s);
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
				container.postInvoke(this, 95, _EJS_s);
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
			com.hps.july.persistence.ComEquipmentBean beanRef = (com.hps.july.persistence.ComEquipmentBean)container.preInvoke(this, 96, _EJS_s);
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
				container.postInvoke(this, 96, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
