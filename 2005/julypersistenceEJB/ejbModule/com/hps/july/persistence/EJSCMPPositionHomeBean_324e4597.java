package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPositionHomeBean_324e4597
 */
public class EJSCMPPositionHomeBean_324e4597 extends EJSHome {
	/**
	 * EJSCMPPositionHomeBean_324e4597
	 */
	public EJSCMPPositionHomeBean_324e4597() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Position postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Position) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE4
	 */
	public java.util.Enumeration findByQBE4(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isAllType, java.lang.Boolean isDAMPS, java.lang.Boolean isGSM900, java.lang.Boolean isDCS1800, java.lang.Boolean isControllers, java.lang.Boolean isWorker, java.lang.Integer argWorker) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionBean)persister).findByQBE4(isNetZone, argNetZone, isAllType, isDAMPS, isGSM900, isDCS1800, isControllers, isWorker, argWorker));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionBean)persister).findByQBE(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, order));	}
	/**
	 * findPositionsByRegion
	 */
	public java.util.Enumeration findPositionsByRegion(com.hps.july.persistence.RegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionBean)persister).findPositionsByRegion(inKey));	}
	/**
	 * findRenteePositionByRenter
	 */
	public java.util.Enumeration findRenteePositionByRenter(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionBean)persister).findRenteePositionByRenter(inKey));	}
	/**
	 * findPositionByNetZone
	 */
	public java.util.Enumeration findPositionByNetZone(com.hps.july.persistence.NetZoneKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionBean)persister).findPositionByNetZone(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Position _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PositionBean bean = (com.hps.july.persistence.PositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argName, argAddress, argNetZone, argLatitude, argLongitude);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Position findByPrimaryKey(com.hps.july.persistence.StoragePlaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPositionBean_324e4597) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, java.lang.String argPlanState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Position _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PositionBean bean = (com.hps.july.persistence.PositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argName, argAddress, argNetZone, argLatitude, argLongitude, argPlanState);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionBean)persister).findByQBE2(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, isRenter, argRenter, isResponsableWorker, argResponsableWorker, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Position create(int argStorageplace, java.lang.String argName, java.lang.String argAddress, java.lang.Integer argNetZone, java.math.BigDecimal argLatitude, java.math.BigDecimal argLongitude, int argRegionId, java.lang.String argPlanState) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Position _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PositionBean bean = (com.hps.july.persistence.PositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace, argName, argAddress, argNetZone, argLatitude, argLongitude, argRegionId, argPlanState);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Position create(int argStorageplace) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Position _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PositionBean bean = (com.hps.july.persistence.PositionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argStorageplace);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argStorageplace);
			afterPostCreateWrapper(beanO, _primaryKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return _EJS_result;
	}
	/**
	 * findByQBE3
	 */
	public java.util.Enumeration findByQBE3(java.lang.Boolean isNetZone, java.lang.Integer argNetZone, java.lang.Boolean isGsmId, java.lang.String argGsmId, java.lang.Boolean isDampsId, java.lang.String argDampsId, java.lang.Boolean isName, java.lang.String argName, java.lang.Boolean isAddr, java.lang.String argAddr, java.lang.Boolean isRenter, java.lang.Integer argRenter, java.lang.Boolean isResponsableWorker, java.lang.Integer argResponsableWorker, java.lang.Boolean isInAction, java.lang.String inAction, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPositionBean)persister).findByQBE3(isNetZone, argNetZone, isGsmId, argGsmId, isDampsId, argDampsId, isName, argName, isAddr, argAddr, isRenter, argRenter, isResponsableWorker, argResponsableWorker, isInAction, inAction, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PositionBean tmpEJB = (com.hps.july.persistence.PositionBean) generalEJB;
		com.hps.july.persistence.StoragePlaceKey keyClass = new com.hps.july.persistence.StoragePlaceKey();
		keyClass.storageplace = tmpEJB.storageplace;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.StoragePlaceKey keyFromFields(int f0) {
		com.hps.july.persistence.StoragePlaceKey keyClass = new com.hps.july.persistence.StoragePlaceKey();
		keyClass.storageplace = f0;
		return keyClass;
	}
}
