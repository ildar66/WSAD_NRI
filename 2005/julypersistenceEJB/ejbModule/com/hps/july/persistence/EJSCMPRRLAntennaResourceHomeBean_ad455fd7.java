package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPRRLAntennaResourceHomeBean_ad455fd7
 */
public class EJSCMPRRLAntennaResourceHomeBean_ad455fd7 extends EJSHome {
	/**
	 * EJSCMPRRLAntennaResourceHomeBean_ad455fd7
	 */
	public EJSCMPRRLAntennaResourceHomeBean_ad455fd7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.RRLAntennaResource postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.RRLAntennaResource) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findResourcesByQBE3
	 */
	public java.util.Enumeration findResourcesByQBE3(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer owner, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findResourcesByQBE3(isSubtypekey, subtypeKey, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, owner, order));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.RRLAntennaResource findByPrimaryKey(com.hps.july.persistence.ResourceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPRRLAntennaResourceBean_ad455fd7) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.RRLAntennaResource create(int resource, com.hps.july.persistence.Unit argUnit, com.hps.july.persistence.ResourceSubType argSubtype) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RRLAntennaResource _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RRLAntennaResourceBean bean = (com.hps.july.persistence.RRLAntennaResourceBean) beanO.getEnterpriseBean();
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
	 * findResourcesByLeasePayRules
	 */
	public java.util.Enumeration findResourcesByLeasePayRules(java.util.Vector listContracts) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findResourcesByLeasePayRules(listContracts));	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(java.lang.Integer argReglament) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findResourceByReglamentOrderByCodeAsc(argReglament));	}
	/**
	 * findResourcesByQBE2
	 */
	public java.util.Enumeration findResourcesByQBE2(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findResourcesByQBE2(isSubtypekey, subtypeKey, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, order));	}
	/**
	 * findResourcesForBrowse
	 */
	public java.util.Enumeration findResourcesForBrowse(java.lang.Boolean isResourcetype, java.lang.Integer resourcetype, java.lang.Boolean isResourcesubtype, java.lang.Integer resourcesubtype, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.String active, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findResourcesForBrowse(isResourcetype, resourcetype, isResourcesubtype, resourcesubtype, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, active, order));	}
	/**
	 * findActiveResourceBySubtype
	 */
	public java.util.Enumeration findActiveResourceBySubtype(java.lang.Integer argSubtype, java.lang.String argActive) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findActiveResourceBySubtype(argSubtype, argActive));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.RRLAntennaResource create(int argResource, java.lang.String argName, java.lang.String argModel, java.lang.String argNotes, java.lang.Boolean argComplect, java.lang.String argCountpolicy, java.lang.Boolean argBoxable, java.lang.Boolean argPriceable, java.lang.Boolean argComplectpart, java.lang.Boolean argActive, int argSubType, java.math.BigDecimal argFreqDevLowK, int argFreqDevLowLog10, java.math.BigDecimal argFreqDevHighK, int argFreqDevHighLog10, java.lang.String argMkkrRecomm, java.lang.String argProtocolNum, java.sql.Date argProtocolDate) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RRLAntennaResource _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RRLAntennaResourceBean bean = (com.hps.july.persistence.RRLAntennaResourceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource, argName, argModel, argNotes, argComplect, argCountpolicy, argBoxable, argPriceable, argComplectpart, argActive, argSubType, argFreqDevLowK, argFreqDevLowLog10, argFreqDevHighK, argFreqDevHighLog10, argMkkrRecomm, argProtocolNum, argProtocolDate);
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
	 * findResourcesByQBE
	 */
	public java.util.Enumeration findResourcesByQBE(java.lang.Boolean isSubtypekey, com.hps.july.persistence.ResourceSubTypeKey subtypeKey, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findResourcesByQBE(isSubtypekey, subtypeKey, isModel, model, isName, name, order));	}
	/**
	 * findResourcesByLeaseChargeRules
	 */
	public java.util.Enumeration findResourcesByLeaseChargeRules(java.util.Vector listContracts) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderRRLAntennaResourceBean)persister).findResourcesByLeaseChargeRules(listContracts));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.RRLAntennaResource create(int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.RRLAntennaResource _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.RRLAntennaResourceBean bean = (com.hps.july.persistence.RRLAntennaResourceBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argResource);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argResource);
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
		com.hps.july.persistence.RRLAntennaResourceBean tmpEJB = (com.hps.july.persistence.RRLAntennaResourceBean) generalEJB;
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
