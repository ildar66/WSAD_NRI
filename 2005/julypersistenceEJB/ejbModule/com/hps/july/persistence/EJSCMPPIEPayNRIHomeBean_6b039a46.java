package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEPayNRIHomeBean_6b039a46
 */
public class EJSCMPPIEPayNRIHomeBean_6b039a46 extends EJSHome {
	/**
	 * EJSCMPPIEPayNRIHomeBean_6b039a46
	 */
	public EJSCMPPIEPayNRIHomeBean_6b039a46() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEPayNRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEPayNRI) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.PIEPayNRI create(int argId, int argQuery, java.lang.String argTypeDogov, int argIdDogovNri, int argIdAccount, java.sql.Date argDateCreate, java.math.BigDecimal argSumPay, java.math.BigDecimal argNdsPay, int argValute) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEPayNRI _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEPayNRIBean bean = (com.hps.july.persistence.PIEPayNRIBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argId, argQuery, argTypeDogov, argIdDogovNri, argIdAccount, argDateCreate, argSumPay, argNdsPay, argValute);
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
	public com.hps.july.persistence.PIEPayNRI findByPrimaryKey(com.hps.july.persistence.PIEPayNRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEPayNRIBean_6b039a46) persister).findByPrimaryKey(key);
	}
	/**
	 * findPIEPayNRIsByQuery
	 */
	public java.util.Enumeration findPIEPayNRIsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEPayNRIBean)persister).findPIEPayNRIsByQuery(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEPayNRIBean tmpEJB = (com.hps.july.persistence.PIEPayNRIBean) generalEJB;
		com.hps.july.persistence.PIEPayNRIKey keyClass = new com.hps.july.persistence.PIEPayNRIKey();
		keyClass.id = tmpEJB.id;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEPayNRIKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEPayNRIKey keyClass = new com.hps.july.persistence.PIEPayNRIKey();
		keyClass.id = f0;
		return keyClass;
	}
}
