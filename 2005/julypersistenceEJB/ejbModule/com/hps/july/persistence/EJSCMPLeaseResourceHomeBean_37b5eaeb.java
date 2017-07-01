package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseResourceHomeBean_37b5eaeb
 */
public class EJSCMPLeaseResourceHomeBean_37b5eaeb extends EJSHome {
	/**
	 * EJSCMPLeaseResourceHomeBean_37b5eaeb
	 */
	public EJSCMPLeaseResourceHomeBean_37b5eaeb() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseResource) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseResource create(int argResource, java.lang.String argName, java.lang.String argModel, java.lang.String argNotes, java.lang.Boolean argComplect, java.lang.String argCountpolicy, java.lang.Boolean argBoxable, java.lang.Boolean argPriceable, java.lang.Boolean argComplectpart, java.lang.Boolean argActive, int argSubType, boolean argNeedCwAct, boolean argUseInArendaContract, boolean argUseInAbonentContract) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseResource _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseResourceBean bean = (com.hps.july.persistence.LeaseResourceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource, argName, argModel, argNotes, argComplect, argCountpolicy, argBoxable, argPriceable, argComplectpart, argActive, argSubType, argNeedCwAct, argUseInArendaContract, argUseInAbonentContract);
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
	public com.hps.july.persistence.LeaseResource create(int resource, com.hps.july.persistence.Unit argUnit, com.hps.july.persistence.ResourceSubType argSubtype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseResource _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseResourceBean bean = (com.hps.july.persistence.LeaseResourceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(resource, argUnit, argSubtype);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(resource, argUnit, argSubtype);
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
	public com.hps.july.persistence.LeaseResource findByPrimaryKey(com.hps.july.persistence.ResourceKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseResourceBean_37b5eaeb) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseResourceBean tmpEJB = (com.hps.july.persistence.LeaseResourceBean) generalEJB;
		com.hps.july.persistence.ResourceKey keyClass = new com.hps.july.persistence.ResourceKey();
		keyClass.resource = tmpEJB.resource;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ResourceKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceKey keyClass = new com.hps.july.persistence.ResourceKey();
		keyClass.resource = f0;
		return keyClass;
	}
}
