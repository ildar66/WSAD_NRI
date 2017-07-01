package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseResBil2NRIHomeBean_395277e9
 */
public class EJSCMPLeaseResBil2NRIHomeBean_395277e9 extends EJSHome {
	/**
	 * EJSCMPLeaseResBil2NRIHomeBean_395277e9
	 */
	public EJSCMPLeaseResBil2NRIHomeBean_395277e9() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseResBil2NRI postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseResBil2NRI) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Boolean isSubtype, java.lang.Integer subtype, java.lang.Boolean isModel, java.lang.String model, java.lang.Boolean isName, java.lang.String name, java.lang.Boolean isManufacturer, java.lang.Integer manufacturer, java.lang.Boolean isManucode, java.lang.String manucode, java.lang.Integer connected, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseResBil2NRIBean)persister).findByQBE(isSubtype, subtype, isModel, model, isName, name, isManufacturer, manufacturer, isManucode, manucode, connected, order));	}
	/**
	 * findLeaseResBilsByLeaseResBil
	 */
	public java.util.Enumeration findLeaseResBilsByLeaseResBil(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseResBil2NRIBean)persister).findLeaseResBilsByLeaseResBil(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.LeaseResBil2NRI findByPrimaryKey(com.hps.july.persistence.LeaseResBil2NRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseResBil2NRIBean_395277e9) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.LeaseResBil2NRI create(int argIdrecord, java.lang.String argIdresbilling, java.lang.String argBillresname, java.lang.String argRecord_status) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseResBil2NRI _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseResBil2NRIBean bean = (com.hps.july.persistence.LeaseResBil2NRIBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdrecord, argIdresbilling, argBillresname, argRecord_status);
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
	 * findByQBE2
	 */
	public java.util.Enumeration findByQBE2(java.lang.Boolean isIdresbilling, java.lang.String idresbilling, java.lang.Boolean isBillresname, java.lang.String billresname, java.lang.Integer connected, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseResBil2NRIBean)persister).findByQBE2(isIdresbilling, idresbilling, isBillresname, billresname, connected, order));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseResBil2NRIBean tmpEJB = (com.hps.july.persistence.LeaseResBil2NRIBean) generalEJB;
		com.hps.july.persistence.LeaseResBil2NRIKey keyClass = new com.hps.july.persistence.LeaseResBil2NRIKey();
		keyClass.idrecord = tmpEJB.idrecord;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseResBil2NRIKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseResBil2NRIKey keyClass = new com.hps.july.persistence.LeaseResBil2NRIKey();
		keyClass.idrecord = f0;
		return keyClass;
	}
}
