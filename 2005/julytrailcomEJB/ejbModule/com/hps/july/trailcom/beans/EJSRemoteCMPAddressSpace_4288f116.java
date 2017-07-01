package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPAddressSpace_4288f116
 */
public class EJSRemoteCMPAddressSpace_4288f116 extends EJSWrapper implements AddressSpace {
	/**
	 * EJSRemoteCMPAddressSpace_4288f116
	 */
	public EJSRemoteCMPAddressSpace_4288f116() throws java.rmi.RemoteException {
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
	 * getAddressinfo
	 */
	public com.hps.july.trailcom.beans.AddressInfo getAddressinfo() throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.trailcom.beans.AddressInfo _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getAddressinfo();
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
	 * getAddressinfoKey
	 */
	public com.hps.july.trailcom.beans.AddressInfoKey getAddressinfoKey() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.trailcom.beans.AddressInfoKey _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getAddressinfoKey();
		}
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
	 * getPortid
	 */
	public int getPortid() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		int _EJS_result = 0;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getPortid();
		}
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
	 * getRealconnect
	 */
	public java.lang.Integer getRealconnect() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getRealconnect();
		}
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
	 * getStoragecard
	 */
	public java.lang.Integer getStoragecard() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Integer _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 4, _EJS_s);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getActivestate
	 */
	public java.lang.Short getActivestate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Short _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.getActivestate();
		}
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
	 * getExiststate
	 */
	public java.lang.Short getExiststate() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Short _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.getExiststate();
		}
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
	 * getInsegment
	 */
	public java.lang.Short getInsegment() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.Short _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.getInsegment();
		}
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
	 * getAddress
	 */
	public java.lang.String getAddress() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.lang.String _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 8, _EJS_s);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getDisabletime
	 */
	public java.sql.Timestamp getDisabletime() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.sql.Timestamp _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getDisabletime();
		}
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
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Hashtable _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 10, _EJS_s);
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
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * privateSetAddressinfoKey
	 */
	public void privateSetAddressinfoKey(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 11, _EJS_s);
			beanRef.privateSetAddressinfoKey(inKey);
		}
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
	 * secondarySetAddressinfo
	 */
	public void secondarySetAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 12, _EJS_s);
			beanRef.secondarySetAddressinfo(anAddressinfo);
		}
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
	/**
	 * setActivestate
	 */
	public void setActivestate(java.lang.Short newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 13, _EJS_s);
			beanRef.setActivestate(newValue);
		}
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
		return ;
	}
	/**
	 * setAddress
	 */
	public void setAddress(java.lang.String newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 14, _EJS_s);
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
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setAddressinfo
	 */
	public void setAddressinfo(com.hps.july.trailcom.beans.AddressInfo anAddressinfo) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 15, _EJS_s);
			beanRef.setAddressinfo(anAddressinfo);
		}
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
		return ;
	}
	/**
	 * setDisabletime
	 */
	public void setDisabletime(java.sql.Timestamp newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 16, _EJS_s);
			beanRef.setDisabletime(newValue);
		}
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
		return ;
	}
	/**
	 * setExiststate
	 */
	public void setExiststate(java.lang.Short newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 17, _EJS_s);
			beanRef.setExiststate(newValue);
		}
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
		return ;
	}
	/**
	 * setInsegment
	 */
	public void setInsegment(java.lang.Short newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 18, _EJS_s);
			beanRef.setInsegment(newValue);
		}
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
		return ;
	}
	/**
	 * setRealconnect
	 */
	public void setRealconnect(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 19, _EJS_s);
			beanRef.setRealconnect(newValue);
		}
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
		return ;
	}
	/**
	 * setStoragecard
	 */
	public void setStoragecard(java.lang.Integer newValue) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 20, _EJS_s);
			beanRef.setStoragecard(newValue);
		}
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
		return ;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable arg0) throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.hps.july.trailcom.beans.AddressSpaceBean beanRef = (com.hps.july.trailcom.beans.AddressSpaceBean)container.preInvoke(this, 21, _EJS_s);
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
				container.postInvoke(this, 21, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
