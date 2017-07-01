package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRegionHomeBean_e2bb4e3f
 */
public class EJSCMPRegionHomeBean_e2bb4e3f extends EJSHome {
	/**
	 * EJSCMPRegionHomeBean_e2bb4e3f
	 */
	public EJSCMPRegionHomeBean_e2bb4e3f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Region postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Region) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findRegionBySuperregion
	 */
	public java.util.Enumeration findRegionBySuperregion(com.hps.july.persistence.SuperRegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRegionBean)persister).findRegionBySuperregion(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Region findByPrimaryKey(com.hps.july.persistence.RegionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRegionBean_e2bb4e3f) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Region create(int argRegionid, int argSupregid, java.lang.String argRegName, java.math.BigDecimal argSectorPrefix) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Region _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RegionBean bean = (com.hps.july.persistence.RegionBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argRegionid, argSupregid, argRegName, argSectorPrefix);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isSuperRegion, java.lang.Integer superRegion, java.lang.Boolean isRegionName, java.lang.String regionName, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRegionBean)persister).findByQBE(isSuperRegion, superRegion, isRegionName, regionName, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.RegionBean tmpEJB = (com.hps.july.persistence.RegionBean) generalEJB;
		com.hps.july.persistence.RegionKey keyClass = new com.hps.july.persistence.RegionKey();
		keyClass.regionid = tmpEJB.regionid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.RegionKey keyFromFields(int f0) {
		com.hps.july.persistence.RegionKey keyClass = new com.hps.july.persistence.RegionKey();
		keyClass.regionid = f0;
		return keyClass;
	}
}
