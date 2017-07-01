package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAgregateContentHomeBean_d4664c44
 */
public class EJSCMPAgregateContentHomeBean_d4664c44 extends EJSHome {
	/**
	 * EJSCMPAgregateContentHomeBean_d4664c44
	 */
	public EJSCMPAgregateContentHomeBean_d4664c44() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.AgregateContent postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.AgregateContent) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.AgregateContent create(java.lang.Integer argAgregate, java.lang.Integer argPart, java.math.BigDecimal argQty) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AgregateContent _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AgregateContentBean bean = (com.hps.july.persistence.AgregateContentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAgregate, argPart, argQty);
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
	 * findAgregateAndPart
	 */
	public com.hps.july.persistence.AgregateContent findAgregateAndPart(java.lang.Integer argAgregate, java.lang.Integer argPart) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPAgregateContentBean_d4664c44)persister).findAgregateAndPart(argAgregate, argPart);	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.AgregateContent findByPrimaryKey(com.hps.july.persistence.AgregateContentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAgregateContentBean_d4664c44) persister).findByPrimaryKey(key);
	}
	/**
	 * findAgregateByParts
	 */
	public java.util.Enumeration findAgregateByParts(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAgregateContentBean)persister).findAgregateByParts(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.AgregateContent create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.AgregateContent _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AgregateContentBean bean = (com.hps.july.persistence.AgregateContentBean) beanO.getEnterpriseBean();
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
	 * findAgregateContentByAgregate
	 */
	public java.util.Enumeration findAgregateContentByAgregate(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAgregateContentBean)persister).findAgregateContentByAgregate(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AgregateContentBean tmpEJB = (com.hps.july.persistence.AgregateContentBean) generalEJB;
		com.hps.july.persistence.AgregateContentKey keyClass = new com.hps.july.persistence.AgregateContentKey();
		keyClass.parts_storagecard = tmpEJB.parts_storagecard;
		keyClass.agregate_storagecard = tmpEJB.agregate_storagecard;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AgregateContentKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.AgregateContentKey keyClass = new com.hps.july.persistence.AgregateContentKey();
		keyClass.parts_storagecard = f0;
		keyClass.agregate_storagecard = f1;
		return keyClass;
	}
}
