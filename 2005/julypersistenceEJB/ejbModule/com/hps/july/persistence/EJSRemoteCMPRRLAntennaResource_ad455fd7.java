package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPRRLAntennaResource_ad455fd7
 */
public class EJSRemoteCMPRRLAntennaResource_ad455fd7 extends EJSWrapper implements RRLAntennaResource {
	/**
	 * EJSRemoteCMPRRLAntennaResource_ad455fd7
	 */
	public EJSRemoteCMPRRLAntennaResource_ad455fd7() throws java.rmi.RemoteException {
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
	 * getSubtype
	 */
	public com.hps.july.persistence.ResourceSubType getSubtype() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.ResourceSubType _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getSubtype();
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
	 * getSubtypeKey
	 */
	public com.hps.july.persistence.ResourceSubTypeKey getSubtypeKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.ResourceSubTypeKey _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getSubtypeKey();
		}
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
	 * getUnit
	 */
	public com.hps.july.persistence.Unit getUnit() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Unit _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getUnit();
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
	 * getUnitKey
	 */
	public com.hps.july.persistence.UnitKey getUnitKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.UnitKey _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getUnitKey();
		}
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
	 * getFreqdevhighlog10
	 */
	public int getFreqdevhighlog10() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getFreqdevhighlog10();
		}
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
	 * getFreqdevlowlog10
	 */
	public int getFreqdevlowlog10() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getFreqdevlowlog10();
		}
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
	 * getActualcode
	 */
	public int getActualcode() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getActualcode();
		}
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
	 * getResource
	 */
	public int getResource() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 7, _EJS_s);
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
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getActive
	 */
	public java.lang.Boolean getActive() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getActive();
		}
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
	 * getBoxable
	 */
	public java.lang.Boolean getBoxable() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getBoxable();
		}
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
	 * getComplect
	 */
	public java.lang.Boolean getComplect() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getComplect();
		}
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
	 * getComplectpart
	 */
	public java.lang.Boolean getComplectpart() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.getComplectpart();
		}
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
	 * getDisablenfscodes
	 */
	public java.lang.Boolean getDisablenfscodes() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.getDisablenfscodes();
		}
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
	 * getPriceable
	 */
	public java.lang.Boolean getPriceable() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Boolean _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.getPriceable();
		}
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
	 * getGroupid
	 */
	public java.lang.Integer getGroupid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.getGroupid();
		}
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
	 * getManufid
	 */
	public java.lang.Integer getManufid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 15, _EJS_s);
			_EJS_result = beanRef.getManufid();
		}
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
	 * getResourceclass2
	 */
	public java.lang.Integer getResourceclass2() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 16, _EJS_s);
			_EJS_result = beanRef.getResourceclass2();
		}
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
	 * getMkkrrecomm
	 */
	public java.lang.String getMkkrrecomm() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 17, _EJS_s);
			_EJS_result = beanRef.getMkkrrecomm();
		}
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
	 * getProtocolnum
	 */
	public java.lang.String getProtocolnum() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 18, _EJS_s);
			_EJS_result = beanRef.getProtocolnum();
		}
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
	 * getCountpolicy
	 */
	public java.lang.String getCountpolicy() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 19, _EJS_s);
			_EJS_result = beanRef.getCountpolicy();
		}
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
	 * getManucode
	 */
	public java.lang.String getManucode() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 20, _EJS_s);
			_EJS_result = beanRef.getManucode();
		}
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
	 * getModel
	 */
	public java.lang.String getModel() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 21, _EJS_s);
			_EJS_result = beanRef.getModel();
		}
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
	 * getName
	 */
	public java.lang.String getName() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 22, _EJS_s);
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
				container.postInvoke(this, 22, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 23, _EJS_s);
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
				container.postInvoke(this, 23, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getFreqdevhighk
	 */
	public java.math.BigDecimal getFreqdevhighk() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 24, _EJS_s);
			_EJS_result = beanRef.getFreqdevhighk();
		}
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
	 * getFreqdevlowk
	 */
	public java.math.BigDecimal getFreqdevlowk() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.math.BigDecimal _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 25, _EJS_s);
			_EJS_result = beanRef.getFreqdevlowk();
		}
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
	 * getProtocoldate
	 */
	public java.sql.Date getProtocoldate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Date _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 26, _EJS_s);
			_EJS_result = beanRef.getProtocoldate();
		}
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
	 * getAbonentBillPoses
	 */
	public java.util.Enumeration getAbonentBillPoses() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 27, _EJS_s);
			_EJS_result = beanRef.getAbonentBillPoses();
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
	 * getAfsMountPoses
	 */
	public java.util.Enumeration getAfsMountPoses() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 28, _EJS_s);
			_EJS_result = beanRef.getAfsMountPoses();
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
	 * getChangeActPositions
	 */
	public java.util.Enumeration getChangeActPositions() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 29, _EJS_s);
			_EJS_result = beanRef.getChangeActPositions();
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
	 * getComEquipments
	 */
	public java.util.Enumeration getComEquipments() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 30, _EJS_s);
			_EJS_result = beanRef.getComEquipments();
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
	 * getComplectparts
	 */
	public java.util.Enumeration getComplectparts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 31, _EJS_s);
			_EJS_result = beanRef.getComplectparts();
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
	 * getComplects
	 */
	public java.util.Enumeration getComplects() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 32, _EJS_s);
			_EJS_result = beanRef.getComplects();
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
	 * getControllers
	 */
	public java.util.Enumeration getControllers() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 33, _EJS_s);
			_EJS_result = beanRef.getControllers();
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
	 * getDocumentPosition
	 */
	public java.util.Enumeration getDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 34, _EJS_s);
			_EJS_result = beanRef.getDocumentPosition();
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
	 * getGrresAntennes
	 */
	public java.util.Enumeration getGrresAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 35, _EJS_s);
			_EJS_result = beanRef.getGrresAntennes();
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
	 * getI13nActResourceSet
	 */
	public java.util.Enumeration getI13nActResourceSet() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 36, _EJS_s);
			_EJS_result = beanRef.getI13nActResourceSet();
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
	 * getLeaseChargeRule
	 */
	public java.util.Enumeration getLeaseChargeRule() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 37, _EJS_s);
			_EJS_result = beanRef.getLeaseChargeRule();
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
				container.postInvoke(this, 37, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 38, _EJS_s);
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
				container.postInvoke(this, 38, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseMutualContracts
	 */
	public java.util.Enumeration getLeaseMutualContracts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 39, _EJS_s);
			_EJS_result = beanRef.getLeaseMutualContracts();
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
				container.postInvoke(this, 39, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseMutualRuleNews
	 */
	public java.util.Enumeration getLeaseMutualRuleNews() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 40, _EJS_s);
			_EJS_result = beanRef.getLeaseMutualRuleNews();
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
				container.postInvoke(this, 40, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeasePayRule
	 */
	public java.util.Enumeration getLeasePayRule() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 41, _EJS_s);
			_EJS_result = beanRef.getLeasePayRule();
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
				container.postInvoke(this, 41, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeasePosSchetFakt
	 */
	public java.util.Enumeration getLeasePosSchetFakt() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 42, _EJS_s);
			_EJS_result = beanRef.getLeasePosSchetFakt();
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
				container.postInvoke(this, 42, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseResBils
	 */
	public java.util.Enumeration getLeaseResBils() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 43, _EJS_s);
			_EJS_result = beanRef.getLeaseResBils();
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
				container.postInvoke(this, 43, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getLeaseSaldo
	 */
	public java.util.Enumeration getLeaseSaldo() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 44, _EJS_s);
			_EJS_result = beanRef.getLeaseSaldo();
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
				container.postInvoke(this, 44, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getOuterDocPosition
	 */
	public java.util.Enumeration getOuterDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 45, _EJS_s);
			_EJS_result = beanRef.getOuterDocPosition();
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
				container.postInvoke(this, 45, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getResourceSetParts
	 */
	public java.util.Enumeration getResourceSetParts() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 46, _EJS_s);
			_EJS_result = beanRef.getResourceSetParts();
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
				container.postInvoke(this, 46, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getResourceSets
	 */
	public java.util.Enumeration getResourceSets() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 47, _EJS_s);
			_EJS_result = beanRef.getResourceSets();
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
				container.postInvoke(this, 47, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getResourceTaxes
	 */
	public java.util.Enumeration getResourceTaxes() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 48, _EJS_s);
			_EJS_result = beanRef.getResourceTaxes();
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
				container.postInvoke(this, 48, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 49, _EJS_s);
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
				container.postInvoke(this, 49, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSwitches
	 */
	public java.util.Enumeration getSwitches() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 50, _EJS_s);
			_EJS_result = beanRef.getSwitches();
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
				container.postInvoke(this, 50, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 51, _EJS_s);
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
				container.postInvoke(this, 51, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setFreqdevhighk
	 */
	public void setFreqdevhighk(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 52, _EJS_s);
			beanRef.setFreqdevhighk(newValue);
		}
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
	 * setFreqdevhighlog10
	 */
	public void setFreqdevhighlog10(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 53, _EJS_s);
			beanRef.setFreqdevhighlog10(newValue);
		}
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
	 * setFreqdevlowk
	 */
	public void setFreqdevlowk(java.math.BigDecimal newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 54, _EJS_s);
			beanRef.setFreqdevlowk(newValue);
		}
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
	 * setFreqdevlowlog10
	 */
	public void setFreqdevlowlog10(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 55, _EJS_s);
			beanRef.setFreqdevlowlog10(newValue);
		}
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
	 * setMkkrrecomm
	 */
	public void setMkkrrecomm(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 56, _EJS_s);
			beanRef.setMkkrrecomm(newValue);
		}
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
	 * setProtocoldate
	 */
	public void setProtocoldate(java.sql.Date newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 57, _EJS_s);
			beanRef.setProtocoldate(newValue);
		}
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
	 * setProtocolnum
	 */
	public void setProtocolnum(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 58, _EJS_s);
			beanRef.setProtocolnum(newValue);
		}
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
	 * addAbonentBillPoses
	 */
	public void addAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 59, _EJS_s);
			beanRef.addAbonentBillPoses(anAbonentBillPoses);
		}
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
	 * addAfsMountPoses
	 */
	public void addAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 60, _EJS_s);
			beanRef.addAfsMountPoses(anAfsMountPoses);
		}
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
	 * addChangeActPositions
	 */
	public void addChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 61, _EJS_s);
			beanRef.addChangeActPositions(aChangeActPositions);
		}
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
	 * addComEquipments
	 */
	public void addComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 62, _EJS_s);
			beanRef.addComEquipments(aComEquipments);
		}
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
	 * addControllers
	 */
	public void addControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 63, _EJS_s);
			beanRef.addControllers(aControllers);
		}
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
	 * addDocumentPosition
	 */
	public void addDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 64, _EJS_s);
			beanRef.addDocumentPosition(aDocumentPosition);
		}
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
	 * addGrresAntennes
	 */
	public void addGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 65, _EJS_s);
			beanRef.addGrresAntennes(aGrresAntennes);
		}
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
	 * addLeaseChargeRule
	 */
	public void addLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 66, _EJS_s);
			beanRef.addLeaseChargeRule(aLeaseChargeRule);
		}
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
	 * addLeaseDocPositions
	 */
	public void addLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 67, _EJS_s);
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
				container.postInvoke(this, 67, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addLeasePayRule
	 */
	public void addLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 68, _EJS_s);
			beanRef.addLeasePayRule(aLeasePayRule);
		}
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
	 * addLeasePosSchetFakt
	 */
	public void addLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 69, _EJS_s);
			beanRef.addLeasePosSchetFakt(aLeasePosSchetFakt);
		}
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
	 * addLeaseResBils
	 */
	public void addLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 70, _EJS_s);
			beanRef.addLeaseResBils(aLeaseResBils);
		}
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
	 * addOuterDocPosition
	 */
	public void addOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 71, _EJS_s);
			beanRef.addOuterDocPosition(anOuterDocPosition);
		}
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
	 * addResourceSets
	 */
	public void addResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 72, _EJS_s);
			beanRef.addResourceSets(aResourceSets);
		}
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
	 * addStorageCard
	 */
	public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 73, _EJS_s);
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
				container.postInvoke(this, 73, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addSwitches
	 */
	public void addSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 74, _EJS_s);
			beanRef.addSwitches(aSwitches);
		}
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
	 * privateSetSubtypeKey
	 */
	public void privateSetSubtypeKey(com.hps.july.persistence.ResourceSubTypeKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 75, _EJS_s);
			beanRef.privateSetSubtypeKey(inKey);
		}
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
	 * privateSetUnitKey
	 */
	public void privateSetUnitKey(com.hps.july.persistence.UnitKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 76, _EJS_s);
			beanRef.privateSetUnitKey(inKey);
		}
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
	 * removeAfsMountPoses
	 */
	public void removeAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 77, _EJS_s);
			beanRef.removeAfsMountPoses(anAfsMountPoses);
		}
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
	 * removeComEquipments
	 */
	public void removeComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 78, _EJS_s);
			beanRef.removeComEquipments(aComEquipments);
		}
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
	 * removeControllers
	 */
	public void removeControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 79, _EJS_s);
			beanRef.removeControllers(aControllers);
		}
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
	 * removeGrresAntennes
	 */
	public void removeGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 80, _EJS_s);
			beanRef.removeGrresAntennes(aGrresAntennes);
		}
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
	 * removeLeaseResBils
	 */
	public void removeLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 81, _EJS_s);
			beanRef.removeLeaseResBils(aLeaseResBils);
		}
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
	 * removeSwitches
	 */
	public void removeSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 82, _EJS_s);
			beanRef.removeSwitches(aSwitches);
		}
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
	 * secondaryAddAbonentBillPoses
	 */
	public void secondaryAddAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 83, _EJS_s);
			beanRef.secondaryAddAbonentBillPoses(anAbonentBillPoses);
		}
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
	 * secondaryAddAfsMountPoses
	 */
	public void secondaryAddAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 84, _EJS_s);
			beanRef.secondaryAddAfsMountPoses(anAfsMountPoses);
		}
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
	 * secondaryAddChangeActPositions
	 */
	public void secondaryAddChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 85, _EJS_s);
			beanRef.secondaryAddChangeActPositions(aChangeActPositions);
		}
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
	 * secondaryAddComEquipments
	 */
	public void secondaryAddComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 86, _EJS_s);
			beanRef.secondaryAddComEquipments(aComEquipments);
		}
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
	 * secondaryAddComplectparts
	 */
	public void secondaryAddComplectparts(com.hps.july.persistence.Complect aComplectparts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 87, _EJS_s);
			beanRef.secondaryAddComplectparts(aComplectparts);
		}
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
	 * secondaryAddComplects
	 */
	public void secondaryAddComplects(com.hps.july.persistence.Complect aComplects) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 88, _EJS_s);
			beanRef.secondaryAddComplects(aComplects);
		}
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
	 * secondaryAddControllers
	 */
	public void secondaryAddControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 89, _EJS_s);
			beanRef.secondaryAddControllers(aControllers);
		}
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
	 * secondaryAddDocumentPosition
	 */
	public void secondaryAddDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 90, _EJS_s);
			beanRef.secondaryAddDocumentPosition(aDocumentPosition);
		}
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
	 * secondaryAddGrresAntennes
	 */
	public void secondaryAddGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 91, _EJS_s);
			beanRef.secondaryAddGrresAntennes(aGrresAntennes);
		}
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
	 * secondaryAddI13nActResourceSet
	 */
	public void secondaryAddI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 92, _EJS_s);
			beanRef.secondaryAddI13nActResourceSet(anI13nActResourceSet);
		}
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
	 * secondaryAddLeaseChargeRule
	 */
	public void secondaryAddLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 93, _EJS_s);
			beanRef.secondaryAddLeaseChargeRule(aLeaseChargeRule);
		}
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
	 * secondaryAddLeaseDocPositions
	 */
	public void secondaryAddLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 94, _EJS_s);
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
				container.postInvoke(this, 94, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseMutualContracts
	 */
	public void secondaryAddLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 95, _EJS_s);
			beanRef.secondaryAddLeaseMutualContracts(aLeaseMutualContracts);
		}
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
	 * secondaryAddLeaseMutualRuleNews
	 */
	public void secondaryAddLeaseMutualRuleNews(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 96, _EJS_s);
			beanRef.secondaryAddLeaseMutualRuleNews(aLeaseMutualRuleNews);
		}
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
	/**
	 * secondaryAddLeasePayRule
	 */
	public void secondaryAddLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 97, _EJS_s);
			beanRef.secondaryAddLeasePayRule(aLeasePayRule);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 97, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeasePosSchetFakt
	 */
	public void secondaryAddLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 98, _EJS_s);
			beanRef.secondaryAddLeasePosSchetFakt(aLeasePosSchetFakt);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 98, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseResBils
	 */
	public void secondaryAddLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 99, _EJS_s);
			beanRef.secondaryAddLeaseResBils(aLeaseResBils);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 99, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddLeaseSaldo
	 */
	public void secondaryAddLeaseSaldo(com.hps.july.persistence.LeaseSaldo aLeaseSaldo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 100, _EJS_s);
			beanRef.secondaryAddLeaseSaldo(aLeaseSaldo);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 100, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddOuterDocPosition
	 */
	public void secondaryAddOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 101, _EJS_s);
			beanRef.secondaryAddOuterDocPosition(anOuterDocPosition);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 101, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddResourceSetParts
	 */
	public void secondaryAddResourceSetParts(com.hps.july.persistence.ResourceSetPart aResourceSetParts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 102, _EJS_s);
			beanRef.secondaryAddResourceSetParts(aResourceSetParts);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 102, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddResourceSets
	 */
	public void secondaryAddResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 103, _EJS_s);
			beanRef.secondaryAddResourceSets(aResourceSets);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 103, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddResourceTaxes
	 */
	public void secondaryAddResourceTaxes(com.hps.july.persistence.ResourceTaxe aResourceTaxes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 104, _EJS_s);
			beanRef.secondaryAddResourceTaxes(aResourceTaxes);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 104, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 105, _EJS_s);
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
				container.postInvoke(this, 105, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryAddSwitches
	 */
	public void secondaryAddSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 106, _EJS_s);
			beanRef.secondaryAddSwitches(aSwitches);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 106, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveAbonentBillPoses
	 */
	public void secondaryRemoveAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 107, _EJS_s);
			beanRef.secondaryRemoveAbonentBillPoses(anAbonentBillPoses);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 107, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveAfsMountPoses
	 */
	public void secondaryRemoveAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 108, _EJS_s);
			beanRef.secondaryRemoveAfsMountPoses(anAfsMountPoses);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 108, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveChangeActPositions
	 */
	public void secondaryRemoveChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 109, _EJS_s);
			beanRef.secondaryRemoveChangeActPositions(aChangeActPositions);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 109, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveComEquipments
	 */
	public void secondaryRemoveComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 110, _EJS_s);
			beanRef.secondaryRemoveComEquipments(aComEquipments);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 110, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveComplectparts
	 */
	public void secondaryRemoveComplectparts(com.hps.july.persistence.Complect aComplectparts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 111, _EJS_s);
			beanRef.secondaryRemoveComplectparts(aComplectparts);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 111, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveComplects
	 */
	public void secondaryRemoveComplects(com.hps.july.persistence.Complect aComplects) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 112, _EJS_s);
			beanRef.secondaryRemoveComplects(aComplects);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 112, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveControllers
	 */
	public void secondaryRemoveControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 113, _EJS_s);
			beanRef.secondaryRemoveControllers(aControllers);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 113, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveDocumentPosition
	 */
	public void secondaryRemoveDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 114, _EJS_s);
			beanRef.secondaryRemoveDocumentPosition(aDocumentPosition);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 114, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveGrresAntennes
	 */
	public void secondaryRemoveGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 115, _EJS_s);
			beanRef.secondaryRemoveGrresAntennes(aGrresAntennes);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 115, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveI13nActResourceSet
	 */
	public void secondaryRemoveI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 116, _EJS_s);
			beanRef.secondaryRemoveI13nActResourceSet(anI13nActResourceSet);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 116, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseChargeRule
	 */
	public void secondaryRemoveLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 117, _EJS_s);
			beanRef.secondaryRemoveLeaseChargeRule(aLeaseChargeRule);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 117, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 118, _EJS_s);
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
				container.postInvoke(this, 118, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseMutualContracts
	 */
	public void secondaryRemoveLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 119, _EJS_s);
			beanRef.secondaryRemoveLeaseMutualContracts(aLeaseMutualContracts);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 119, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseMutualRuleNews
	 */
	public void secondaryRemoveLeaseMutualRuleNews(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 120, _EJS_s);
			beanRef.secondaryRemoveLeaseMutualRuleNews(aLeaseMutualRuleNews);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 120, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeasePayRule
	 */
	public void secondaryRemoveLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 121, _EJS_s);
			beanRef.secondaryRemoveLeasePayRule(aLeasePayRule);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 121, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeasePosSchetFakt
	 */
	public void secondaryRemoveLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 122, _EJS_s);
			beanRef.secondaryRemoveLeasePosSchetFakt(aLeasePosSchetFakt);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 122, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseResBils
	 */
	public void secondaryRemoveLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 123, _EJS_s);
			beanRef.secondaryRemoveLeaseResBils(aLeaseResBils);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 123, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveLeaseSaldo
	 */
	public void secondaryRemoveLeaseSaldo(com.hps.july.persistence.LeaseSaldo aLeaseSaldo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 124, _EJS_s);
			beanRef.secondaryRemoveLeaseSaldo(aLeaseSaldo);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 124, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveOuterDocPosition
	 */
	public void secondaryRemoveOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 125, _EJS_s);
			beanRef.secondaryRemoveOuterDocPosition(anOuterDocPosition);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 125, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveResourceSetParts
	 */
	public void secondaryRemoveResourceSetParts(com.hps.july.persistence.ResourceSetPart aResourceSetParts) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 126, _EJS_s);
			beanRef.secondaryRemoveResourceSetParts(aResourceSetParts);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 126, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveResourceSets
	 */
	public void secondaryRemoveResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 127, _EJS_s);
			beanRef.secondaryRemoveResourceSets(aResourceSets);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 127, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveResourceTaxes
	 */
	public void secondaryRemoveResourceTaxes(com.hps.july.persistence.ResourceTaxe aResourceTaxes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 128, _EJS_s);
			beanRef.secondaryRemoveResourceTaxes(aResourceTaxes);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 128, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 129, _EJS_s);
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
				container.postInvoke(this, 129, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondaryRemoveSwitches
	 */
	public void secondaryRemoveSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 130, _EJS_s);
			beanRef.secondaryRemoveSwitches(aSwitches);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 130, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetSubtype
	 */
	public void secondarySetSubtype(com.hps.july.persistence.ResourceSubType aSubtype) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 131, _EJS_s);
			beanRef.secondarySetSubtype(aSubtype);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 131, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * secondarySetUnit
	 */
	public void secondarySetUnit(com.hps.july.persistence.Unit anUnit) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 132, _EJS_s);
			beanRef.secondarySetUnit(anUnit);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 132, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setActive
	 */
	public void setActive(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 133, _EJS_s);
			beanRef.setActive(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 133, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setActualcode
	 */
	public void setActualcode(int newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 134, _EJS_s);
			beanRef.setActualcode(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 134, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setBoxable
	 */
	public void setBoxable(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 135, _EJS_s);
			beanRef.setBoxable(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 135, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setComplect
	 */
	public void setComplect(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 136, _EJS_s);
			beanRef.setComplect(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 136, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setComplectpart
	 */
	public void setComplectpart(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 137, _EJS_s);
			beanRef.setComplectpart(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 137, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setCountpolicy
	 */
	public void setCountpolicy(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 138, _EJS_s);
			beanRef.setCountpolicy(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 138, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setDisablenfscodes
	 */
	public void setDisablenfscodes(java.lang.Boolean newDisablenfscodes) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 139, _EJS_s);
			beanRef.setDisablenfscodes(newDisablenfscodes);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 139, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setGroupid
	 */
	public void setGroupid(java.lang.Integer newGroupid) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 140, _EJS_s);
			beanRef.setGroupid(newGroupid);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 140, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setManucode
	 */
	public void setManucode(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 141, _EJS_s);
			beanRef.setManucode(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 141, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setManufid
	 */
	public void setManufid(java.lang.Integer newManufid) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 142, _EJS_s);
			beanRef.setManufid(newManufid);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 142, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setModel
	 */
	public void setModel(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 143, _EJS_s);
			beanRef.setModel(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 143, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 144, _EJS_s);
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
				container.postInvoke(this, 144, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setNotes
	 */
	public void setNotes(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 145, _EJS_s);
			beanRef.setNotes(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 145, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setPriceable
	 */
	public void setPriceable(java.lang.Boolean newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 146, _EJS_s);
			beanRef.setPriceable(newValue);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 146, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 147, _EJS_s);
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
				container.postInvoke(this, 147, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setResourceclass2
	 */
	public void setResourceclass2(java.lang.Integer newResourceclass2) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 148, _EJS_s);
			beanRef.setResourceclass2(newResourceclass2);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 148, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSubtype
	 */
	public void setSubtype(com.hps.july.persistence.ResourceSubType aSubtype) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 149, _EJS_s);
			beanRef.setSubtype(aSubtype);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 149, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setUnit
	 */
	public void setUnit(com.hps.july.persistence.Unit anUnit) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 150, _EJS_s);
			beanRef.setUnit(anUnit);
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 150, _EJS_s);
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
			com.hps.july.persistence.RRLAntennaResourceBean beanRef = (com.hps.july.persistence.RRLAntennaResourceBean)container.preInvoke(this, 151, _EJS_s);
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
				container.postInvoke(this, 151, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
