package com.hps.july.trailcom.beans;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAddressSpaceHomeBean_4288f116
 */
public class EJSCMPAddressSpaceHomeBean_4288f116 extends EJSHome {
	/**
	 * EJSCMPAddressSpaceHomeBean_4288f116
	 */
	public EJSCMPAddressSpaceHomeBean_4288f116() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.trailcom.beans.AddressSpace postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.trailcom.beans.AddressSpace) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.trailcom.beans.AddressSpace findByPrimaryKey(com.hps.july.trailcom.beans.AddressSpaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.trailcom.beans.EJSJDBCPersisterCMPAddressSpaceBean_4288f116) persister).findByPrimaryKey(key);
	}
	/**
	 * findAddressSpacesByAddressinfo
	 */
	public java.util.Enumeration findAddressSpacesByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderAddressSpaceBean)persister).findAddressSpacesByAddressinfo(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.trailcom.beans.AddressSpace create(int argPortid) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.trailcom.beans.AddressSpace _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.trailcom.beans.AddressSpaceBean bean = (com.hps.july.trailcom.beans.AddressSpaceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argPortid);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argPortid);
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
	 * findByStoragecard
	 */
	public java.util.Enumeration findByStoragecard(java.lang.Integer argStoragecard) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.trailcom.beans.EJSFinderAddressSpaceBean)persister).findByStoragecard(argStoragecard));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.trailcom.beans.AddressSpaceBean tmpEJB = (com.hps.july.trailcom.beans.AddressSpaceBean) generalEJB;
		com.hps.july.trailcom.beans.AddressSpaceKey keyClass = new com.hps.july.trailcom.beans.AddressSpaceKey();
		keyClass.portid = tmpEJB.portid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.trailcom.beans.AddressSpaceKey keyFromFields(int f0) {
		com.hps.july.trailcom.beans.AddressSpaceKey keyClass = new com.hps.july.trailcom.beans.AddressSpaceKey();
		keyClass.portid = f0;
		return keyClass;
	}
}
