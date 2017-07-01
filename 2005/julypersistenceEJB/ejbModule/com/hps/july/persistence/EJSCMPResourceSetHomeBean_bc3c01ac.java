package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceSetHomeBean_bc3c01ac
 */
public class EJSCMPResourceSetHomeBean_bc3c01ac extends EJSHome {
	/**
	 * EJSCMPResourceSetHomeBean_bc3c01ac
	 */
	public EJSCMPResourceSetHomeBean_bc3c01ac() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceSet postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceSet) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.ResourceSet create(int argResourceset, java.lang.String argName, java.lang.Integer argMainPart, java.math.BigDecimal argMainPartQty, java.lang.String argType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceSet _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceSetBean bean = (com.hps.july.persistence.ResourceSetBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResourceset, argName, argMainPart, argMainPartQty, argType);
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
	 * findResourceSetsBySubtype
	 */
	public java.util.Enumeration findResourceSetsBySubtype(java.lang.Integer argSubtype) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceSetBean)persister).findResourceSetsBySubtype(argSubtype));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ResourceSet findByPrimaryKey(com.hps.july.persistence.ResourceSetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPResourceSetBean_bc3c01ac) persister).findByPrimaryKey(key);
	}
	/**
	 * findResourceSetsByMainpart
	 */
	public java.util.Enumeration findResourceSetsByMainpart(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceSetBean)persister).findResourceSetsByMainpart(inKey));	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceSetBean)persister).findByQBE(isSubtypekey, subtypeKey, isModel, model, isName, name, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ResourceSet create(int argResourceset) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceSet _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceSetBean bean = (com.hps.july.persistence.ResourceSetBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResourceset);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResourceset);
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
		com.hps.july.persistence.ResourceSetBean tmpEJB = (com.hps.july.persistence.ResourceSetBean) generalEJB;
		com.hps.july.persistence.ResourceSetKey keyClass = new com.hps.july.persistence.ResourceSetKey();
		keyClass.resourceset = tmpEJB.resourceset;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceSetKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceSetKey keyClass = new com.hps.july.persistence.ResourceSetKey();
		keyClass.resourceset = f0;
		return keyClass;
	}
}
