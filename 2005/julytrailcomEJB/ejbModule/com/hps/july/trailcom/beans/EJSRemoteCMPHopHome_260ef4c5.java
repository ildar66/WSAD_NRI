package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPHopHome_260ef4c5
 */
public class EJSRemoteCMPHopHome_260ef4c5 extends EJSWrapper implements com.hps.july.trailcom.beans.HopHome {
	/**
	 * EJSRemoteCMPHopHome_260ef4c5
	 */
	public EJSRemoteCMPHopHome_260ef4c5() throws java.rmi.RemoteException {
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
	public com.hps.july.trailcom.beans.Hop create(int argHopsid, int argEquipmentid_enda, int argEquipmentid_endb) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.trailcom.beans.Hop _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argHopsid, argEquipmentid_enda, argEquipmentid_endb);
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
	 * findByPrimaryKey
	 */
	public com.hps.july.trailcom.beans.Hop findByPrimaryKey(com.hps.july.trailcom.beans.HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.trailcom.beans.Hop _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 1, _EJS_s);
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
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPositionAndType
	 */
	public java.util.Enumeration findByPositionAndType(java.lang.String hopstype, java.lang.Integer siteid_enda, java.lang.Integer siteid_endb) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findByPositionAndType(hopstype, siteid_enda, siteid_endb);
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
	 * findByPositions
	 */
	public java.util.Enumeration findByPositions(java.lang.Boolean isTypeR, java.lang.Boolean isTypeO, java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.findByPositions(isTypeR, isTypeO, isNetZone, argNetZone, isAllType, isDAMPS, isGSM900, isDCS1800, isControllers, isWorker, argWorker);
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
	 * findBySiteid_endaOrderByHopsidAsc
	 */
	public java.util.Enumeration findBySiteid_endaOrderByHopsidAsc(java.lang.Integer siteid_enda) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.findBySiteid_endaOrderByHopsidAsc(siteid_enda);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findBySiteid_endbOrderByHopsidAsc
	 */
	public java.util.Enumeration findBySiteid_endbOrderByHopsidAsc(java.lang.Integer siteid_endb) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findBySiteid_endbOrderByHopsidAsc(siteid_endb);
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
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findHopsByPosition
	 */
	public java.util.Enumeration findHopsByPosition(java.lang.Integer position) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findHopsByPosition(position);
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
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findNestedLines
	 */
	public java.util.Enumeration findNestedLines(java.lang.Boolean useType, java.lang.String type, java.lang.Integer hop, java.lang.Integer position) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findNestedLines(useType, type, hop, position);
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
				container.postInvoke(this, 7, _EJS_s);
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
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 8, _EJS_s);
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
				container.postInvoke(this, 8, _EJS_s);
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
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 9, _EJS_s);
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
				container.postInvoke(this, 9, _EJS_s);
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
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 10, _EJS_s);
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
				container.postInvoke(this, 10, _EJS_s);
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
			com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5 beanRef = (com.hps.july.trailcom.beans.EJSCMPHopHomeBean_260ef4c5)container.preInvoke(this, 11, _EJS_s);
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
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
