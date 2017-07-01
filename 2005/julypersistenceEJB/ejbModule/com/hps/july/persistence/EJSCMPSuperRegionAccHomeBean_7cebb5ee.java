package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSuperRegionAccHomeBean_7cebb5ee
 */
public class EJSCMPSuperRegionAccHomeBean_7cebb5ee extends EJSHome {
	/**
	 * EJSCMPSuperRegionAccHomeBean_7cebb5ee
	 */
	public EJSCMPSuperRegionAccHomeBean_7cebb5ee() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SuperRegionAcc postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SuperRegionAcc) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findSuperRegionAccsBySuperregion
	 */
	public java.util.Enumeration findSuperRegionAccsBySuperregion(com.hps.july.persistence.SuperRegionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSuperRegionAccBean)persister).findSuperRegionAccsBySuperregion(inKey));	}
	/**
	 * findByOperatorAndId
	 */
	public java.util.Enumeration findByOperatorAndId(java.lang.Integer argOperator, java.lang.Integer argSregionID) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSuperRegionAccBean)persister).findByOperatorAndId(argOperator, argSregionID));	}
	/**
	 * findByOperator
	 */
	public java.util.Enumeration findByOperator(java.lang.Integer argOperator) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSuperRegionAccBean)persister).findByOperator(argOperator));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.SuperRegionAcc findByPrimaryKey(com.hps.july.persistence.SuperRegionAccKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSuperRegionAccBean_7cebb5ee) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SuperRegionAcc create(int argAccessid, int argOperatorId, int argSupregionId, boolean argViewPlan, boolean argViewFact, boolean argEditPlan, boolean argEditFact) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SuperRegionAcc _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SuperRegionAccBean bean = (com.hps.july.persistence.SuperRegionAccBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAccessid, argOperatorId, argSupregionId, argViewPlan, argViewFact, argEditPlan, argEditFact);
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
	 * findAllOrderByCodeAsc
	 */
	public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSuperRegionAccBean)persister).findAllOrderByCodeAsc());	}
	/**
	 * findSuperRegionAccsByOperator
	 */
	public java.util.Enumeration findSuperRegionAccsByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSuperRegionAccBean)persister).findSuperRegionAccsByOperator(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SuperRegionAccBean tmpEJB = (com.hps.july.persistence.SuperRegionAccBean) generalEJB;
		com.hps.july.persistence.SuperRegionAccKey keyClass = new com.hps.july.persistence.SuperRegionAccKey();
		keyClass.accessid = tmpEJB.accessid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SuperRegionAccKey keyFromFields(int f0) {
		com.hps.july.persistence.SuperRegionAccKey keyClass = new com.hps.july.persistence.SuperRegionAccKey();
		keyClass.accessid = f0;
		return keyClass;
	}
}
