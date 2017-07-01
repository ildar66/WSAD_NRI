package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSupplyTypeHomeBean_ef5af5dc
 */
public class EJSCMPSupplyTypeHomeBean_ef5af5dc extends EJSHome {
	/**
	 * EJSCMPSupplyTypeHomeBean_ef5af5dc
	 */
	public EJSCMPSupplyTypeHomeBean_ef5af5dc() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SupplyType postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SupplyType) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.SupplyType findByPrimaryKey(com.hps.july.persistence.SupplyTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSupplyTypeBean_ef5af5dc) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SupplyType create(int argSupplyType, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SupplyType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SupplyTypeBean bean = (com.hps.july.persistence.SupplyTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSupplyType, argName);
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
	 * findAllOrderByNameDesc
	 */
	public java.util.Enumeration findAllOrderByNameDesc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSupplyTypeBean)persister).findAllOrderByNameDesc());	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SupplyType create(int argSupplyType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SupplyType _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SupplyTypeBean bean = (com.hps.july.persistence.SupplyTypeBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argSupplyType);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argSupplyType);
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
	 * findAllOrderByNameAsc
	 */
	public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSupplyTypeBean)persister).findAllOrderByNameAsc());	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.SupplyTypeBean tmpEJB = (com.hps.july.persistence.SupplyTypeBean) generalEJB;
		com.hps.july.persistence.SupplyTypeKey keyClass = new com.hps.july.persistence.SupplyTypeKey();
		keyClass.supplyType = tmpEJB.supplyType;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SupplyTypeKey keyFromFields(int f0) {
		com.hps.july.persistence.SupplyTypeKey keyClass = new com.hps.july.persistence.SupplyTypeKey();
		keyClass.supplyType = f0;
		return keyClass;
	}
}
