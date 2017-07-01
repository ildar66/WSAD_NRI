package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAddressInfo2HomeBean_4b0a02cd
 */
public class EJSCMPAddressInfo2HomeBean_4b0a02cd extends EJSHome {
	/**
	 * EJSCMPAddressInfo2HomeBean_4b0a02cd
	 */
	public EJSCMPAddressInfo2HomeBean_4b0a02cd() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.AddressInfo2 postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.AddressInfo2) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.trailcom.beans.AddressInfo2 findByPrimaryKey(com.hps.july.trailcom.beans.AddressInfo2Key key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPAddressInfo2Bean_4b0a02cd) persister).findByPrimaryKey(key);
	}
	/**
	 * findByResourceTypeport
	 */
	public java.util.Enumeration findByResourceTypeport(java.lang.Integer argResource, java.lang.Short argTypeport) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderAddressInfo2Bean)persister).findByResourceTypeport(argResource, argTypeport));	}
	/**
	 * create
	 */
	public com.hps.july.trailcom.beans.AddressInfo2 create(int argAddressportid, int argResource, short argTypeport) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.AddressInfo2 _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.AddressInfo2Bean bean = (com.hps.july.trailcom.beans.AddressInfo2Bean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAddressportid, argResource, argTypeport);
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
	 * findAddressInfo2sByAddressinfo
	 */
	public java.util.Enumeration findAddressInfo2sByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderAddressInfo2Bean)persister).findAddressInfo2sByAddressinfo(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.AddressInfo2Bean tmpEJB = (com.hps.july.trailcom.beans.AddressInfo2Bean) generalEJB;
		com.hps.july.trailcom.beans.AddressInfo2Key keyClass = new com.hps.july.trailcom.beans.AddressInfo2Key();
		keyClass.addressportid = tmpEJB.addressportid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.AddressInfo2Key keyFromFields(int f0) {
		com.hps.july.trailcom.beans.AddressInfo2Key keyClass = new com.hps.july.trailcom.beans.AddressInfo2Key();
		keyClass.addressportid = f0;
		return keyClass;
	}
}
