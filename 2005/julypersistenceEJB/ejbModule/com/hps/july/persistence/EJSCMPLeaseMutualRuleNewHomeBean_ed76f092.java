package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseMutualRuleNewHomeBean_ed76f092
 */
public class EJSCMPLeaseMutualRuleNewHomeBean_ed76f092 extends EJSHome {
	/**
	 * EJSCMPLeaseMutualRuleNewHomeBean_ed76f092
	 */
	public EJSCMPLeaseMutualRuleNewHomeBean_ed76f092() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseMutualRuleNew) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findLeaseMutualRuleNewsByReglamentOrderByResourceAsc
	 */
	public java.util.Enumeration findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(java.lang.Integer argreglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualRuleNewBean)persister).findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(argreglament));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew create() throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualRuleNew _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualRuleNewBean bean = (com.hps.july.persistence.LeaseMutualRuleNewBean) beanO.getEnterpriseBean();
			bean.ejbCreate();
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate();
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
	public com.hps.july.persistence.LeaseMutualRuleNew findByPrimaryKey(com.hps.july.persistence.LeaseMutualRuleNewKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseMutualRuleNewBean_ed76f092) persister).findByPrimaryKey(key);
	}
	/**
	 * findLeaseMutualRuleNewsByResource
	 */
	public java.util.Enumeration findLeaseMutualRuleNewsByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualRuleNewBean)persister).findLeaseMutualRuleNewsByResource(inKey));	}
	/**
	 * findLeaseMutualRulesByReglament
	 */
	public java.util.Enumeration findLeaseMutualRulesByReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseMutualRuleNewBean)persister).findLeaseMutualRulesByReglament(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew create(java.lang.Integer argReglament, java.lang.Integer argResource, java.lang.String argChargeDateRule, java.lang.String argPayDateRule, boolean argDopChargeDateRule, int argRateType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseMutualRuleNew _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseMutualRuleNewBean bean = (com.hps.july.persistence.LeaseMutualRuleNewBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argReglament, argResource, argChargeDateRule, argPayDateRule, argDopChargeDateRule, argRateType);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseMutualRuleNewBean tmpEJB = (com.hps.july.persistence.LeaseMutualRuleNewBean) generalEJB;
		com.hps.july.persistence.LeaseMutualRuleNewKey keyClass = new com.hps.july.persistence.LeaseMutualRuleNewKey();
		keyClass.resource_resource = tmpEJB.resource_resource;
		keyClass.reglament_leaseDocument = tmpEJB.reglament_leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseMutualRuleNewKey keyFromFields(java.lang.Integer f0, java.lang.Integer f1) {
		com.hps.july.persistence.LeaseMutualRuleNewKey keyClass = new com.hps.july.persistence.LeaseMutualRuleNewKey();
		keyClass.resource_resource = f0;
		keyClass.reglament_leaseDocument = f1;
		return keyClass;
	}
}
