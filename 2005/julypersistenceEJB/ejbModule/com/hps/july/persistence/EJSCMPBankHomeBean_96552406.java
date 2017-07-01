package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBankHomeBean_96552406
 */
public class EJSCMPBankHomeBean_96552406 extends EJSHome {
	/**
	 * EJSCMPBankHomeBean_96552406
	 */
	public EJSCMPBankHomeBean_96552406() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Bank postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Bank) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.Bank findByPrimaryKey(java.lang.Integer primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPBankBean_96552406) persister).findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Bank create(java.lang.Integer idBank) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Bank _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.BankBean bean = (com.hps.july.persistence.BankBean) beanO.getEnterpriseBean();
			bean.ejbCreate(idBank);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(idBank);
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
	 * findBankByBik
	 */
	public com.hps.july.persistence.Bank findBankByBik(java.lang.String argBik) throws javax.ejb.FinderException, java.rmi.RemoteException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPBankBean_96552406)persister).findBankByBik(argBik);	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.BankBean tmpEJB = (com.hps.july.persistence.BankBean) generalEJB;
		return tmpEJB.idBank;
	}
	/**
	 * keyFromFields
	 */
	public java.lang.Integer keyFromFields(java.lang.Integer f0) {
		return f0;
	}
}
