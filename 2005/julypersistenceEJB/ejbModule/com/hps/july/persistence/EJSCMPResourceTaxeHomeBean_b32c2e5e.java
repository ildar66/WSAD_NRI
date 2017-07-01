package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceTaxeHomeBean_b32c2e5e
 */
public class EJSCMPResourceTaxeHomeBean_b32c2e5e extends EJSHome {
	/**
	 * EJSCMPResourceTaxeHomeBean_b32c2e5e
	 */
	public EJSCMPResourceTaxeHomeBean_b32c2e5e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceTaxe postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceTaxe) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ResourceTaxe create(java.sql.Date argDate, java.lang.Integer argResource, java.math.BigDecimal argNds, java.math.BigDecimal argNsp) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceTaxe _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceTaxeBean bean = (com.hps.july.persistence.ResourceTaxeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDate, argResource, argNds, argNsp);
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
	public com.hps.july.persistence.ResourceTaxe create(java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceTaxe _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceTaxeBean bean = (com.hps.july.persistence.ResourceTaxeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argDate);
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
	 * findResourceTaxesByResource
	 */
	public java.util.Enumeration findResourceTaxesByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceTaxeBean)persister).findResourceTaxesByResource(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ResourceTaxe create(com.hps.july.persistence.ResourceKey argResource, java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceTaxe _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceTaxeBean bean = (com.hps.july.persistence.ResourceTaxeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource, argDate);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResource, argDate);
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
	 * findBySubtypeDateOrderByResourceAsc
	 */
	public java.util.Enumeration findBySubtypeDateOrderByResourceAsc(java.lang.Integer ressubtype, java.sql.Date date) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceTaxeBean)persister).findBySubtypeDateOrderByResourceAsc(ressubtype, date));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ResourceTaxe findByPrimaryKey(com.hps.july.persistence.ResourceTaxeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPResourceTaxeBean_b32c2e5e) persister).findByPrimaryKey(key);
	}
	/**
	 * findByResourceOrderByDateDesc
	 */
	public java.util.Enumeration findByResourceOrderByDateDesc(java.lang.Integer resource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceTaxeBean)persister).findByResourceOrderByDateDesc(resource));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.ResourceTaxeBean tmpEJB = (com.hps.july.persistence.ResourceTaxeBean) generalEJB;
		com.hps.july.persistence.ResourceTaxeKey keyClass = new com.hps.july.persistence.ResourceTaxeKey();
		keyClass.date = tmpEJB.date;
		keyClass.resource_resource = tmpEJB.resource_resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceTaxeKey keyFromFields(java.sql.Date f0, java.lang.Integer f1) {
		com.hps.july.persistence.ResourceTaxeKey keyClass = new com.hps.july.persistence.ResourceTaxeKey();
		keyClass.date = f0;
		keyClass.resource_resource = f1;
		return keyClass;
	}
}
