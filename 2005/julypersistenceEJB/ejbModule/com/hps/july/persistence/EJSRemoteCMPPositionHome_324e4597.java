package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteCMPPositionHome_324e4597
 */
public class EJSRemoteCMPPositionHome_324e4597 extends EJSWrapper implements com.hps.july.persistence.PositionHome {
	/**
	 * EJSRemoteCMPPositionHome_324e4597
	 */
	public EJSRemoteCMPPositionHome_324e4597() throws java.rmi.RemoteException {
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
	public com.hps.july.persistence.Position create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Position _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.create(argStorageplace);
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
	public com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Position _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.create(argStorageplace, argName, argAddress, argNetZone, argLatitude, argLongitude);
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
	 * create
	 */
	public com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, int argRegionId, java.lang.String argPlanState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Position _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.create(argStorageplace, argName, argAddress, argNetZone, argLatitude, argLongitude, argRegionId, argPlanState);
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
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, java.lang.String argPlanState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Position _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.create(argStorageplace, argName, argAddress, argNetZone, argLatitude, argLongitude, argPlanState);
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
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Position findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.hps.july.persistence.Position _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 4, _EJS_s);
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
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findByQBE(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, order);
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
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findByQBE2(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, isRenter, argRenter, isResponsableWorker, argResponsableWorker, order);
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
	 * findByQBE3
	 */
	public java.util.Enumeration findByQBE3(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Boolean isInAction, java.lang.String inAction, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.findByQBE3(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, isRenter, argRenter, isResponsableWorker, argResponsableWorker, isInAction, inAction, order);
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
	 * findByQBE4
	 */
	public java.util.Enumeration findByQBE4(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.findByQBE4(isNetZone, argNetZone, isAllType, isDAMPS, isGSM900, isDCS1800, isControllers, isWorker, argWorker);
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
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPositionByNetZone
	 */
	public java.util.Enumeration findPositionByNetZone(com.hps.july.persistence.NetZoneKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.findPositionByNetZone(inKey);
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
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPositionsByRegion
	 */
	public java.util.Enumeration findPositionsByRegion(com.hps.july.persistence.RegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.findPositionsByRegion(inKey);
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
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findRenteePositionByRenter
	 */
	public java.util.Enumeration findRenteePositionByRenter(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.Enumeration _EJS_result = null;
		try {
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.findRenteePositionByRenter(inKey);
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
				container.postInvoke(this, 11, _EJS_s);
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
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 12, _EJS_s);
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
				container.postInvoke(this, 12, _EJS_s);
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
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 13, _EJS_s);
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
				container.postInvoke(this, 13, _EJS_s);
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
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 14, _EJS_s);
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
				container.postInvoke(this, 14, _EJS_s);
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
			com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597 beanRef = (com.hps.july.persistence.EJSCMPPositionHomeBean_324e4597)container.preInvoke(this, 15, _EJS_s);
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
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}
