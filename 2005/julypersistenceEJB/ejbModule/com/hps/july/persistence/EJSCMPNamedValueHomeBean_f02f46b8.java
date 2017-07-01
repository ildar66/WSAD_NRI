package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPNamedValueHomeBean_f02f46b8
 */
public class EJSCMPNamedValueHomeBean_f02f46b8 extends EJSHome {
	/**
	 * EJSCMPNamedValueHomeBean_f02f46b8
	 */
	public EJSCMPNamedValueHomeBean_f02f46b8() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.NamedValue postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.NamedValue) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findAll
	 */
	public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderNamedValueBean)persister).findAll());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.NamedValue create(java.lang.String argId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.NamedValue _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.NamedValueBean bean = (com.hps.july.persistence.NamedValueBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argId);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argId);
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
	public com.hps.july.persistence.NamedValue findByPrimaryKey(com.hps.july.persistence.NamedValueKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPNamedValueBean_f02f46b8) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.NamedValueBean tmpEJB = (com.hps.july.persistence.NamedValueBean) generalEJB;
		com.hps.july.persistence.NamedValueKey keyClass = new com.hps.july.persistence.NamedValueKey();
		keyClass.id = tmpEJB.id;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.NamedValueKey keyFromFields(java.lang.String f0) {
		com.hps.july.persistence.NamedValueKey keyClass = new com.hps.july.persistence.NamedValueKey();
		keyClass.id = f0;
		return keyClass;
	}
}
