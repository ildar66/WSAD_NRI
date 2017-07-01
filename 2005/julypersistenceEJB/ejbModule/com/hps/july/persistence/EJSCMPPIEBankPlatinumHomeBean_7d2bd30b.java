package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEBankPlatinumHomeBean_7d2bd30b
 */
public class EJSCMPPIEBankPlatinumHomeBean_7d2bd30b extends EJSHome {
	/**
	 * EJSCMPPIEBankPlatinumHomeBean_7d2bd30b
	 */
	public EJSCMPPIEBankPlatinumHomeBean_7d2bd30b() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEBankPlatinum postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEBankPlatinum) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findNotWorkedByOwner
	 */
	public java.util.Enumeration findNotWorkedByOwner(java.lang.Integer argOwner) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEBankPlatinumBean)persister).findNotWorkedByOwner(argOwner));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEBankPlatinum create(java.lang.String argIdbankplatinum, int argOwner, java.lang.String argPStatus, java.lang.String argName, java.lang.String argBik, java.lang.String argFlagWorkNri) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEBankPlatinum _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEBankPlatinumBean bean = (com.hps.july.persistence.PIEBankPlatinumBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdbankplatinum, argOwner, argPStatus, argName, argBik, argFlagWorkNri);
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
	public com.hps.july.persistence.PIEBankPlatinum findByPrimaryKey(com.hps.july.persistence.PIEBankPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEBankPlatinumBean_7d2bd30b) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEBankPlatinumBean tmpEJB = (com.hps.july.persistence.PIEBankPlatinumBean) generalEJB;
		com.hps.july.persistence.PIEBankPlatinumKey keyClass = new com.hps.july.persistence.PIEBankPlatinumKey();
		keyClass.owner = tmpEJB.owner;
		keyClass.idbankplatinum = tmpEJB.idbankplatinum;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEBankPlatinumKey keyFromFields(int f0, java.lang.String f1) {
		com.hps.july.persistence.PIEBankPlatinumKey keyClass = new com.hps.july.persistence.PIEBankPlatinumKey();
		keyClass.owner = f0;
		keyClass.idbankplatinum = f1;
		return keyClass;
	}
}
