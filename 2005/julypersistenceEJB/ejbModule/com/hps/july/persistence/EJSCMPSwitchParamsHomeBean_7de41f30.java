package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPSwitchParamsHomeBean_7de41f30
 */
public class EJSCMPSwitchParamsHomeBean_7de41f30 extends EJSHome {
	/**
	 * EJSCMPSwitchParamsHomeBean_7de41f30
	 */
	public EJSCMPSwitchParamsHomeBean_7de41f30() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.SwitchParams postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.SwitchParams) super.postCreate(beanO, ejsKey, true);
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
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchParamsBean)persister).findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(equipment, actdate, param_type));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.SwitchParams findByPrimaryKey(com.hps.july.persistence.SwitchParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPSwitchParamsBean_7de41f30) persister).findByPrimaryKey(key);
	}
	/**
	 * findSwitchParamsBySwitchaddinfo
	 */
	public java.util.Enumeration findSwitchParamsBySwitchaddinfo(com.hps.july.persistence.SwitchAddInfoKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchParamsBean)persister).findSwitchParamsBySwitchaddinfo(inKey));	}
	/**
	 * findByEquipmentAndActdateOrderByParamlevelAsc
	 */
	public java.util.Enumeration findByEquipmentAndActdateOrderByParamlevelAsc(java.lang.Integer equipment, java.sql.Date actdate) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderSwitchParamsBean)persister).findByEquipmentAndActdateOrderByParamlevelAsc(equipment, actdate));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.SwitchParams create(int argParamid, int argEquipment, java.sql.Date argActDate, java.math.BigDecimal argParamLevel, java.math.BigDecimal argParamValue, int argParam_type) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.SwitchParams _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.SwitchParamsBean bean = (com.hps.july.persistence.SwitchParamsBean) beanO.getEnterpriseBean();
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
		com.hps.july.persistence.SwitchParamsBean tmpEJB = (com.hps.july.persistence.SwitchParamsBean) generalEJB;
		com.hps.july.persistence.SwitchParamsKey keyClass = new com.hps.july.persistence.SwitchParamsKey();
		keyClass.paramid = tmpEJB.paramid;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.SwitchParamsKey keyFromFields(int f0) {
		com.hps.july.persistence.SwitchParamsKey keyClass = new com.hps.july.persistence.SwitchParamsKey();
		keyClass.paramid = f0;
		return keyClass;
	}
}
