package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPHop_260ef4c5
 */
public class EJSRemoteCMPHop_260ef4c5 extends EJSWrapper implements Hop {
	/**
	 * EJSRemoteCMPHop_260ef4c5
	 */
	public EJSRemoteCMPHop_260ef4c5() throws java.rmi.RemoteException {
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
	 * getOpticalHop
	 */
	public com.hps.july.trailcom.beans.OpticalHop getOpticalHop() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.trailcom.beans.OpticalHop _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getOpticalHop();
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
	 * getRrlHops2
	 */
	public com.hps.july.trailcom.beans.RRLHops2 getRrlHops2() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.trailcom.beans.RRLHops2 _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getRrlHops2();
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEquipmentid_enda
	 */
	public int getEquipmentid_enda() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getEquipmentid_enda();
		}
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
	 * getEquipmentid_endb
	 */
	public int getEquipmentid_endb() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getEquipmentid_endb();
		}
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
	 * getHopsid
	 */
	public int getHopsid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getHopsid();
		}
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
	 * getCreatedby
	 */
	public java.lang.Integer getCreatedby() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 5, _EJS_s);
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
				container.postInvoke(this, 5, _EJS_s);
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
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 6, _EJS_s);
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
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSiteid_enda
	 */
	public java.lang.Integer getSiteid_enda() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getSiteid_enda();
		}
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
	 * getSiteid_endb
	 */
	public java.lang.Integer getSiteid_endb() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getSiteid_endb();
		}
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
	 * getAbis_number
	 */
	public java.lang.String getAbis_number() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getAbis_number();
		}
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
	 * getBeenetid
	 */
	public java.lang.String getBeenetid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getBeenetid();
		}
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
	 * getHopstate
	 */
	public java.lang.String getHopstate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.getHopstate();
		}
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
	 * getHopstype
	 */
	public java.lang.String getHopstype() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getHopstype();
		}
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
	 * getLease_info
	 */
	public java.lang.String getLease_info() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getLease_info();
		}
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
	 * getPermstatus
	 */
	public java.lang.String getPermstatus() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getPermstatus();
		}
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
	 * getRezerv
	 */
	public java.lang.String getRezerv() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getRezerv();
		}
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
	 * getSpeed
	 */
	public java.lang.String getSpeed() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getSpeed();
		}
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
	 * getExpindate
	 */
	public java.sql.Date getExpindate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getExpindate();
		}
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
	 * getExpoutdate
	 */
	public java.sql.Date getExpoutdate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getExpoutdate();
		}
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
	 * getCreated
	 */
	public java.sql.Timestamp getCreated() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Timestamp _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 19, _EJS_s);
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
				container.postInvoke(this, 19, _EJS_s);
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
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 20, _EJS_s);
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
				container.postInvoke(this, 20, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getHopLabels
	 */
	public java.util.Enumeration getHopLabels() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.getHopLabels();
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
	 * getSitedoc2Hops
	 */
	public java.util.Enumeration getSitedoc2Hops() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 22, _EJS_s);
			_EJS_result = beanRef.getSitedoc2Hops();
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
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Hashtable _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 23, _EJS_s);
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addHopLabels
	 */
	public void addHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 24, _EJS_s);
			beanRef.addHopLabels(aHopLabels);
		}
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
		return ;
	}
	/**
	 * removeHopLabels
	 */
	public void removeHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 25, _EJS_s);
			beanRef.removeHopLabels(aHopLabels);
		}
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
		return ;
	}
	/**
	 * secondaryAddHopLabels
	 */
	public void secondaryAddHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 26, _EJS_s);
			beanRef.secondaryAddHopLabels(aHopLabels);
		}
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
		return ;
	}
	/**
	 * secondaryAddSitedoc2Hops
	 */
	public void secondaryAddSitedoc2Hops(com.hps.july.trailcom.beans.Sitedoc2Hops aSitedoc2Hops) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 27, _EJS_s);
			beanRef.secondaryAddSitedoc2Hops(aSitedoc2Hops);
		}
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
		return ;
	}
	/**
	 * secondaryRemoveHopLabels
	 */
	public void secondaryRemoveHopLabels(com.hps.july.trailcom.beans.HopLabel aHopLabels) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 28, _EJS_s);
			beanRef.secondaryRemoveHopLabels(aHopLabels);
		}
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
		return ;
	}
	/**
	 * secondaryRemoveSitedoc2Hops
	 */
	public void secondaryRemoveSitedoc2Hops(com.hps.july.trailcom.beans.Sitedoc2Hops aSitedoc2Hops) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 29, _EJS_s);
			beanRef.secondaryRemoveSitedoc2Hops(aSitedoc2Hops);
		}
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
	 * secondarySetOpticalHop
	 */
	public void secondarySetOpticalHop(com.hps.july.trailcom.beans.OpticalHop anOpticalHop) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 30, _EJS_s);
			beanRef.secondarySetOpticalHop(anOpticalHop);
		}
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
	 * secondarySetRrlHops2
	 */
	public void secondarySetRrlHops2(com.hps.july.trailcom.beans.RRLHops2 aRrlHops2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 31, _EJS_s);
			beanRef.secondarySetRrlHops2(aRrlHops2);
		}
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
	 * setAbis_number
	 */
	public void setAbis_number(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 32, _EJS_s);
			beanRef.setAbis_number(newValue);
		}
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
	 * setBeenetid
	 */
	public void setBeenetid(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 33, _EJS_s);
			beanRef.setBeenetid(newValue);
		}
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
	 * setCreated
	 */
	public void setCreated(java.sql.Timestamp newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 34, _EJS_s);
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
				container.postInvoke(this, 34, _EJS_s);
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
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 35, _EJS_s);
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
				container.postInvoke(this, 35, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setEquipmentid_enda
	 */
	public void setEquipmentid_enda(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 36, _EJS_s);
			beanRef.setEquipmentid_enda(newValue);
		}
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
	 * setEquipmentid_endb
	 */
	public void setEquipmentid_endb(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 37, _EJS_s);
			beanRef.setEquipmentid_endb(newValue);
		}
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
	 * setExpindate
	 */
	public void setExpindate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 38, _EJS_s);
			beanRef.setExpindate(newValue);
		}
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
	 * setExpoutdate
	 */
	public void setExpoutdate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 39, _EJS_s);
			beanRef.setExpoutdate(newValue);
		}
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
	 * setHopstate
	 */
	public void setHopstate(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 40, _EJS_s);
			beanRef.setHopstate(newValue);
		}
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
	 * setHopstype
	 */
	public void setHopstype(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 41, _EJS_s);
			beanRef.setHopstype(newValue);
		}
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
	 * setLease_info
	 */
	public void setLease_info(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 42, _EJS_s);
			beanRef.setLease_info(newValue);
		}
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
	 * setModified
	 */
	public void setModified(java.sql.Timestamp newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 43, _EJS_s);
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
				container.postInvoke(this, 43, _EJS_s);
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
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 44, _EJS_s);
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
				container.postInvoke(this, 44, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPermstatus
	 */
	public void setPermstatus(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 45, _EJS_s);
			beanRef.setPermstatus(newValue);
		}
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
	 * setRezerv
	 */
	public void setRezerv(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 46, _EJS_s);
			beanRef.setRezerv(newValue);
		}
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
	 * setSiteid_enda
	 */
	public void setSiteid_enda(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 47, _EJS_s);
			beanRef.setSiteid_enda(newValue);
		}
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
	 * setSiteid_endb
	 */
	public void setSiteid_endb(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 48, _EJS_s);
			beanRef.setSiteid_endb(newValue);
		}
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
	 * setSpeed
	 */
	public void setSpeed(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 49, _EJS_s);
			beanRef.setSpeed(newValue);
		}
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
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.HopBean beanRef = (com.hps.july.trailcom.beans.HopBean)container.preInvoke(this, 50, _EJS_s);
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
				container.postInvoke(this, 50, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
