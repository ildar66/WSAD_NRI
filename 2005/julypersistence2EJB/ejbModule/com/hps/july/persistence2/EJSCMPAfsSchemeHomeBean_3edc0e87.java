package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAfsSchemeHomeBean_3edc0e87
 */
public class EJSCMPAfsSchemeHomeBean_3edc0e87 extends EJSHome {
	/**
	 * EJSCMPAfsSchemeHomeBean_3edc0e87
	 */
	public EJSCMPAfsSchemeHomeBean_3edc0e87() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.AfsScheme postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.AfsScheme) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.AfsScheme create(java.lang.Integer schemeid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.AfsScheme _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.AfsSchemeBean bean = (com.hps.july.persistence2.AfsSchemeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(schemeid);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(schemeid);
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
	public com.hps.july.persistence2.AfsScheme findByPrimaryKey(com.hps.july.persistence2.AfsSchemeKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPAfsSchemeBean_3edc0e87) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence2.AfsSchemeBean tmpEJB = (com.hps.july.persistence2.AfsSchemeBean) generalEJB;
		com.hps.july.persistence2.AfsSchemeKey keyClass = new com.hps.july.persistence2.AfsSchemeKey();
		keyClass.schemeid = tmpEJB.schemeid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.AfsSchemeKey keyFromFields(java.lang.Integer f0) {
		com.hps.july.persistence2.AfsSchemeKey keyClass = new com.hps.july.persistence2.AfsSchemeKey();
		keyClass.schemeid = f0;
		return keyClass;
	}
}
