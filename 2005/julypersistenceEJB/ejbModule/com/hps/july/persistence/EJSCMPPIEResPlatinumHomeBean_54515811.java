package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEResPlatinumHomeBean_54515811
 */
public class EJSCMPPIEResPlatinumHomeBean_54515811 extends EJSHome {
	/**
	 * EJSCMPPIEResPlatinumHomeBean_54515811
	 */
	public EJSCMPPIEResPlatinumHomeBean_54515811() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEResPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEResPlatinum) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByIdresplatinNameOwner
	 */
	public java.util.Enumeration findByIdresplatinNameOwner(java.lang.Boolean isIdresplatin, java.lang.String idresplatin, java.lang.Boolean isNameRes, java.lang.String nameRes, java.lang.Integer owner, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEResPlatinumBean)persister).findByIdresplatinNameOwner(isIdresplatin, idresplatin, isNameRes, nameRes, owner, order));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEResPlatinum create(java.lang.String argIdresplatinum, int argOwner, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEResPlatinum _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEResPlatinumBean bean = (com.hps.july.persistence.PIEResPlatinumBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdresplatinum, argOwner, argName);
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
	public com.hps.july.persistence.PIEResPlatinum findByPrimaryKey(com.hps.july.persistence.PIEResPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEResPlatinumBean_54515811) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEResPlatinumBean tmpEJB = (com.hps.july.persistence.PIEResPlatinumBean) generalEJB;
		com.hps.july.persistence.PIEResPlatinumKey keyClass = new com.hps.july.persistence.PIEResPlatinumKey();
		keyClass.owner = tmpEJB.owner;
		keyClass.idresplatinum = tmpEJB.idresplatinum;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEResPlatinumKey keyFromFields(int f0, java.lang.String f1) {
		com.hps.july.persistence.PIEResPlatinumKey keyClass = new com.hps.july.persistence.PIEResPlatinumKey();
		keyClass.owner = f0;
		keyClass.idresplatinum = f1;
		return keyClass;
	}
}
