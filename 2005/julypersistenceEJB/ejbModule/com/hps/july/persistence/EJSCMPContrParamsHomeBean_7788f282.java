package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPContrParamsHomeBean_7788f282
 */
public class EJSCMPContrParamsHomeBean_7788f282 extends EJSHome {
	/**
	 * EJSCMPContrParamsHomeBean_7788f282
	 */
	public EJSCMPContrParamsHomeBean_7788f282() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.ContrParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.ContrParams) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc
	 */
	public java.util.Enumeration findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate, java.lang.Integer param_type) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContrParamsBean)persister).findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(equipment, actdate, param_type));	}
	/**
	 * findContrParamsByContraddinfo
	 */
	public java.util.Enumeration findContrParamsByContraddinfo(com.hps.july.persistence.ContrAddInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContrParamsBean)persister).findContrParamsByContraddinfo(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.ContrParams findByPrimaryKey(com.hps.july.persistence.ContrParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPContrParamsBean_7788f282) persister).findByPrimaryKey(key);
	}
	/**
	 * findByEquipmentAndActdateOrderByParamlevelAsc
	 */
	public java.util.Enumeration findByEquipmentAndActdateOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderContrParamsBean)persister).findByEquipmentAndActdateOrderByParamlevelAsc(equipment, actdate));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.ContrParams create(int argParamid, int argEquipment, java.sql.Date argActDate, java.math.BigDecimal argParamLevel, java.math.BigDecimal argParamValue, int argParam_type) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.ContrParams _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.ContrParamsBean bean = (com.hps.july.persistence.ContrParamsBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argParamid, argEquipment, argActDate, argParamLevel, argParamValue, argParam_type);
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
		com.hps.july.persistence.ContrParamsBean tmpEJB = (com.hps.july.persistence.ContrParamsBean) generalEJB;
		com.hps.july.persistence.ContrParamsKey keyClass = new com.hps.july.persistence.ContrParamsKey();
		keyClass.paramid = tmpEJB.paramid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.ContrParamsKey keyFromFields(int f0) {
		com.hps.july.persistence.ContrParamsKey keyClass = new com.hps.july.persistence.ContrParamsKey();
		keyClass.paramid = f0;
		return keyClass;
	}
}
