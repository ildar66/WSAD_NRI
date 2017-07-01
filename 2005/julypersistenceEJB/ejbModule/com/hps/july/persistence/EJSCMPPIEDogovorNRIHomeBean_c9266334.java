package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPPIEDogovorNRIHomeBean_c9266334
 */
public class EJSCMPPIEDogovorNRIHomeBean_c9266334 extends EJSHome {
	/**
	 * EJSCMPPIEDogovorNRIHomeBean_c9266334
	 */
	public EJSCMPPIEDogovorNRIHomeBean_c9266334() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.PIEDogovorNRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.PIEDogovorNRI) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findPIEDogovorNRIsByPiequery
	 */
	public java.util.Enumeration findPIEDogovorNRIsByPiequery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderPIEDogovorNRIBean)persister).findPIEDogovorNRIsByPiequery(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.PIEDogovorNRI create(int argIdrecdogovor, int argQuery, int argOrgOwner, int argPartnerNri, int argAccountNri, java.lang.String argDogovorPlatinum, int argIdBudjet, int argIdExperience, java.sql.Date argDogDate, java.sql.Date argDogStartDate, java.sql.Date argDogEndDate, java.lang.String argDogBlankCode, java.math.BigDecimal argSumDog, int argValute) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.PIEDogovorNRI _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.PIEDogovorNRIBean bean = (com.hps.july.persistence.PIEDogovorNRIBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdrecdogovor, argQuery, argOrgOwner, argPartnerNri, argAccountNri, argDogovorPlatinum, argIdBudjet, argIdExperience, argDogDate, argDogStartDate, argDogEndDate, argDogBlankCode, argSumDog, argValute);
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
	public com.hps.july.persistence.PIEDogovorNRI findByPrimaryKey(com.hps.july.persistence.PIEDogovorNRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPPIEDogovorNRIBean_c9266334) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.PIEDogovorNRIBean tmpEJB = (com.hps.july.persistence.PIEDogovorNRIBean) generalEJB;
		com.hps.july.persistence.PIEDogovorNRIKey keyClass = new com.hps.july.persistence.PIEDogovorNRIKey();
		keyClass.idrecdogovor = tmpEJB.idrecdogovor;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.PIEDogovorNRIKey keyFromFields(int f0) {
		com.hps.july.persistence.PIEDogovorNRIKey keyClass = new com.hps.july.persistence.PIEDogovorNRIKey();
		keyClass.idrecdogovor = f0;
		return keyClass;
	}
}
