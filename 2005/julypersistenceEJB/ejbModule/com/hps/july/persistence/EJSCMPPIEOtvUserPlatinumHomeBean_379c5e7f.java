package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEOtvUserPlatinumHomeBean_379c5e7f
 */
public class EJSCMPPIEOtvUserPlatinumHomeBean_379c5e7f extends EJSHome {
	/**
	 * EJSCMPPIEOtvUserPlatinumHomeBean_379c5e7f
	 */
	public EJSCMPPIEOtvUserPlatinumHomeBean_379c5e7f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEOtvUserPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEOtvUserPlatinum) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByOtvuserPlatinumOrderByNameAsc
	 */
	public java.util.Enumeration findByOtvuserPlatinumOrderByNameAsc(java.lang.String argOtvuser) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEOtvUserPlatinumBean)persister).findByOtvuserPlatinumOrderByNameAsc(argOtvuser));	}
	/**
	 * findByNameOrderByNameAsc
	 */
	public java.util.Enumeration findByNameOrderByNameAsc(java.lang.String argName) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEOtvUserPlatinumBean)persister).findByNameOrderByNameAsc(argName));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEOtvUserPlatinum findByPrimaryKey(com.hps.july.persistence.PIEOtvUserPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEOtvUserPlatinumBean_379c5e7f) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEOtvUserPlatinum create(java.lang.String argOtvuserplatinum, java.lang.String argPStatus, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEOtvUserPlatinum _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEOtvUserPlatinumBean bean = (com.hps.july.persistence.PIEOtvUserPlatinumBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOtvuserplatinum, argPStatus, argName);
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
		com.hps.july.persistence.PIEOtvUserPlatinumBean tmpEJB = (com.hps.july.persistence.PIEOtvUserPlatinumBean) generalEJB;
		com.hps.july.persistence.PIEOtvUserPlatinumKey keyClass = new com.hps.july.persistence.PIEOtvUserPlatinumKey();
		keyClass.otvuserplatinum = tmpEJB.otvuserplatinum;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEOtvUserPlatinumKey keyFromFields(java.lang.String f0) {
		com.hps.july.persistence.PIEOtvUserPlatinumKey keyClass = new com.hps.july.persistence.PIEOtvUserPlatinumKey();
		keyClass.otvuserplatinum = f0;
		return keyClass;
	}
}
