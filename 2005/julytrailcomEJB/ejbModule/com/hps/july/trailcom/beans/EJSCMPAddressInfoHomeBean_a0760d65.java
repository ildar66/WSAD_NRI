package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAddressInfoHomeBean_a0760d65
 */
public class EJSCMPAddressInfoHomeBean_a0760d65 extends EJSHome {
	/**
	 * EJSCMPAddressInfoHomeBean_a0760d65
	 */
	public EJSCMPAddressInfoHomeBean_a0760d65() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.AddressInfo postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.AddressInfo) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.trailcom.beans.AddressInfo create(int argResource, short argTypeport) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.AddressInfo _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.AddressInfoBean bean = (com.hps.july.trailcom.beans.AddressInfoBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource, argTypeport);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResource, argTypeport);
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
	public com.hps.july.trailcom.beans.AddressInfo findByPrimaryKey(com.hps.july.trailcom.beans.AddressInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPAddressInfoBean_a0760d65) persister).findByPrimaryKey(key);
	}
	/**
	 * findByResource
	 */
	public java.util.Enumeration findByResource(java.lang.Integer argResource) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderAddressInfoBean)persister).findByResource(argResource));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.AddressInfoBean tmpEJB = (com.hps.july.trailcom.beans.AddressInfoBean) generalEJB;
		com.hps.july.trailcom.beans.AddressInfoKey keyClass = new com.hps.july.trailcom.beans.AddressInfoKey();
		keyClass.typeport = tmpEJB.typeport;
		keyClass.resource = tmpEJB.resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.AddressInfoKey keyFromFields(short f0, int f1) {
		com.hps.july.trailcom.beans.AddressInfoKey keyClass = new com.hps.july.trailcom.beans.AddressInfoKey();
		keyClass.typeport = f0;
		keyClass.resource = f1;
		return keyClass;
	}
}
