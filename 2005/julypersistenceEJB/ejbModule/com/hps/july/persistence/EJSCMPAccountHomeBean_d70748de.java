package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAccountHomeBean_d70748de
 */
public class EJSCMPAccountHomeBean_d70748de extends EJSHome {
	/**
	 * EJSCMPAccountHomeBean_d70748de
	 */
	public EJSCMPAccountHomeBean_d70748de() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Account postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Account) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findAccountinbankByBank
	 */
	public java.util.Enumeration findAccountinbankByBank(java.lang.Integer inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAccountBean)persister).findAccountinbankByBank(inKey));	}
	/**
	 * findAccountByOrganization
	 */
	public java.util.Enumeration findAccountByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAccountBean)persister).findAccountByOrganization(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Account findByPrimaryKey(com.hps.july.persistence.AccountKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAccountBean_d70748de) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Account create(int account, com.hps.july.persistence.Organization argOrganization, com.hps.july.persistence.Bank argBank) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Account _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AccountBean bean = (com.hps.july.persistence.AccountBean) beanO.getEnterpriseBean();
			bean.ejbCreate(account, argOrganization, argBank);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(account, argOrganization, argBank);
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
	public com.hps.july.persistence.Account create(int argAccount, java.lang.Integer argBank, java.lang.Integer argOrganization, java.lang.String argName, java.lang.Boolean argActive) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Account _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AccountBean bean = (com.hps.july.persistence.AccountBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAccount, argBank, argOrganization, argName, argActive);
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
	public com.hps.july.persistence.Account create(int argAccount, java.lang.Integer argBank, java.lang.Integer argOrganization, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Account _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AccountBean bean = (com.hps.july.persistence.AccountBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAccount, argBank, argOrganization, argName);
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
	public com.hps.july.persistence.Account create(int argAccount) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Account _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AccountBean bean = (com.hps.july.persistence.AccountBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argAccount);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argAccount);
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
		com.hps.july.persistence.AccountBean tmpEJB = (com.hps.july.persistence.AccountBean) generalEJB;
		com.hps.july.persistence.AccountKey keyClass = new com.hps.july.persistence.AccountKey();
		keyClass.account = tmpEJB.account;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AccountKey keyFromFields(int f0) {
		com.hps.july.persistence.AccountKey keyClass = new com.hps.july.persistence.AccountKey();
		keyClass.account = f0;
		return keyClass;
	}
}
