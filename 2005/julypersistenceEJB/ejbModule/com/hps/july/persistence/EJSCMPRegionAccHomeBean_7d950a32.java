package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRegionAccHomeBean_7d950a32
 */
public class EJSCMPRegionAccHomeBean_7d950a32 extends EJSHome {
	/**
	 * EJSCMPRegionAccHomeBean_7d950a32
	 */
	public EJSCMPRegionAccHomeBean_7d950a32() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RegionAcc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RegionAcc) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByOperatorAndId
	 */
	public java.util.Enumeration findByOperatorAndId(java.lang.Integer argOperator, java.lang.Integer argRegionID) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRegionAccBean)persister).findByOperatorAndId(argOperator, argRegionID));	}
	/**
	 * findRegionAccsByOperator
	 */
	public java.util.Enumeration findRegionAccsByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRegionAccBean)persister).findRegionAccsByOperator(inKey));	}
	/**
	 * findRegionAccsByRegion
	 */
	public java.util.Enumeration findRegionAccsByRegion(com.hps.july.persistence.RegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRegionAccBean)persister).findRegionAccsByRegion(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer argOperator, java.lang.Boolean isSuperregion, java.lang.Integer argSupregion, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRegionAccBean)persister).findByQBE(argOperator, isSuperregion, argSupregion, order));	}
	/**
	 * findBySuperregionOrderByCodeAsc
	 */
	public java.util.Enumeration findBySuperregionOrderByCodeAsc(java.lang.Integer argSupregion) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRegionAccBean)persister).findBySuperregionOrderByCodeAsc(argSupregion));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.RegionAcc findByPrimaryKey(com.hps.july.persistence.RegionAccKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRegionAccBean_7d950a32) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.RegionAcc create(int argAccessid, int argOperatorId, int argRegionId, boolean argViewPlan, boolean argViewFact, boolean argEditPlan, boolean argEditFact) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RegionAcc _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RegionAccBean bean = (com.hps.july.persistence.RegionAccBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAccessid, argOperatorId, argRegionId, argViewPlan, argViewFact, argEditPlan, argEditFact);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.RegionAccBean tmpEJB = (com.hps.july.persistence.RegionAccBean) generalEJB;
		com.hps.july.persistence.RegionAccKey keyClass = new com.hps.july.persistence.RegionAccKey();
		keyClass.accessid = tmpEJB.accessid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.RegionAccKey keyFromFields(int f0) {
		com.hps.july.persistence.RegionAccKey keyClass = new com.hps.july.persistence.RegionAccKey();
		keyClass.accessid = f0;
		return keyClass;
	}
}
