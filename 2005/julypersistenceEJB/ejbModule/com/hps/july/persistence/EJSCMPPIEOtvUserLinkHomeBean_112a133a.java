package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEOtvUserLinkHomeBean_112a133a
 */
public class EJSCMPPIEOtvUserLinkHomeBean_112a133a extends EJSHome {
	/**
	 * EJSCMPPIEOtvUserLinkHomeBean_112a133a
	 */
	public EJSCMPPIEOtvUserLinkHomeBean_112a133a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEOtvUserLink postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEOtvUserLink) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEOtvUserLink create(int argOtvusernri, java.lang.String argOtvUserPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEOtvUserLink _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEOtvUserLinkBean bean = (com.hps.july.persistence.PIEOtvUserLinkBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argOtvusernri, argOtvUserPlatinum);
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
	 * findPIEOtvUserLinksByOtvuserplatinum
	 */
	public java.util.Enumeration findPIEOtvUserLinksByOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEOtvUserLinkBean)persister).findPIEOtvUserLinksByOtvuserplatinum(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.PIEOtvUserLink findByPrimaryKey(com.hps.july.persistence.PIEOtvUserLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEOtvUserLinkBean_112a133a) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEOtvUserLinkBean tmpEJB = (com.hps.july.persistence.PIEOtvUserLinkBean) generalEJB;
		com.hps.july.persistence.PIEOtvUserLinkKey keyClass = new com.hps.july.persistence.PIEOtvUserLinkKey();
		keyClass.otvusernri = tmpEJB.otvusernri;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEOtvUserLinkKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEOtvUserLinkKey keyClass = new com.hps.july.persistence.PIEOtvUserLinkKey();
		keyClass.otvusernri = f0;
		return keyClass;
	}
}
