package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIELinkPrihRashHomeBean_8fc12af7
 */
public class EJSCMPPIELinkPrihRashHomeBean_8fc12af7 extends EJSHome {
	/**
	 * EJSCMPPIELinkPrihRashHomeBean_8fc12af7
	 */
	public EJSCMPPIELinkPrihRashHomeBean_8fc12af7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIELinkPrihRash postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIELinkPrihRash) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByDocposPrihod
	 */
	public java.util.Enumeration findByDocposPrihod(java.lang.Integer argDocpos) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIELinkPrihRashBean)persister).findByDocposPrihod(argDocpos));	}
	/**
	 * findByDocposRashod
	 */
	public java.util.Enumeration findByDocposRashod(java.lang.Integer argDocpos) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIELinkPrihRashBean)persister).findByDocposRashod(argDocpos));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIELinkPrihRash create(int argIdlinkprihodrashod, int argDocposPrihod, int argFromStoragePrihod, int argDocposRashod, java.math.BigDecimal argQty) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIELinkPrihRash _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIELinkPrihRashBean bean = (com.hps.july.persistence.PIELinkPrihRashBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdlinkprihodrashod, argDocposPrihod, argFromStoragePrihod, argDocposRashod, argQty);
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
	public com.hps.july.persistence.PIELinkPrihRash findByPrimaryKey(com.hps.july.persistence.PIELinkPrihRashKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIELinkPrihRashBean_8fc12af7) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIELinkPrihRashBean tmpEJB = (com.hps.july.persistence.PIELinkPrihRashBean) generalEJB;
		com.hps.july.persistence.PIELinkPrihRashKey keyClass = new com.hps.july.persistence.PIELinkPrihRashKey();
		keyClass.idlinkprihodrashod = tmpEJB.idlinkprihodrashod;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIELinkPrihRashKey keyFromFields(int f0) {
		com.hps.july.persistence.PIELinkPrihRashKey keyClass = new com.hps.july.persistence.PIELinkPrihRashKey();
		keyClass.idlinkprihodrashod = f0;
		return keyClass;
	}
}
