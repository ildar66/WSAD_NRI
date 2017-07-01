package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPResourceSetPartHomeBean_6281eecd
 */
public class EJSCMPResourceSetPartHomeBean_6281eecd extends EJSHome {
	/**
	 * EJSCMPResourceSetPartHomeBean_6281eecd
	 */
	public EJSCMPResourceSetPartHomeBean_6281eecd() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ResourceSetPart postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ResourceSetPart) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findSetPartsBySet
	 */
	public java.util.Enumeration findSetPartsBySet(com.hps.july.persistence.ResourceSetKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceSetPartBean)persister).findSetPartsBySet(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ResourceSetPart create(java.lang.Integer argSet, java.lang.Integer argPart, java.math.BigDecimal argQty) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceSetPart _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceSetPartBean bean = (com.hps.july.persistence.ResourceSetPartBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSet, argPart, argQty);
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
	public com.hps.july.persistence.ResourceSetPart findByPrimaryKey(com.hps.july.persistence.ResourceSetPartKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPResourceSetPartBean_6281eecd) persister).findByPrimaryKey(key);
	}
	/**
	 * findResourceSetPartsByPart
	 */
	public java.util.Enumeration findResourceSetPartsByPart(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderResourceSetPartBean)persister).findResourceSetPartsByPart(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ResourceSetPart create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ResourceSetPart _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ResourceSetPartBean bean = (com.hps.july.persistence.ResourceSetPartBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
		com.hps.july.persistence.ResourceSetPartBean tmpEJB = (com.hps.july.persistence.ResourceSetPartBean) generalEJB;
		com.hps.july.persistence.ResourceSetPartKey keyClass = new com.hps.july.persistence.ResourceSetPartKey();
		keyClass.part_resource = tmpEJB.part_resource;
		keyClass.set_resourceset = tmpEJB.set_resourceset;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceSetPartKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.ResourceSetPartKey keyClass = new com.hps.july.persistence.ResourceSetPartKey();
		keyClass.part_resource = f0;
		keyClass.set_resourceset = f1;
		return keyClass;
	}
}
