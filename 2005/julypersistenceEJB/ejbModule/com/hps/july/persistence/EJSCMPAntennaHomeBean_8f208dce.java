package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAntennaHomeBean_8f208dce
 */
public class EJSCMPAntennaHomeBean_8f208dce extends EJSHome {
	/**
	 * EJSCMPAntennaHomeBean_8f208dce
	 */
	public EJSCMPAntennaHomeBean_8f208dce() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.Antenna postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.Antenna) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findAntennesByOperator
	 */
	public java.util.Enumeration findAntennesByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaBean)persister).findAntennesByOperator(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Antenna create(int argIdanten, int argResource, java.lang.String argNumant, java.lang.String argKindant, java.math.BigDecimal argNakl, java.math.BigDecimal argAzant, java.math.BigDecimal argHset1, java.math.BigDecimal argLencable, int argEquipment, java.lang.Boolean argByhand) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Antenna _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AntennaBean bean = (com.hps.july.persistence.AntennaBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdanten, argResource, argNumant, argKindant, argNakl, argAzant, argHset1, argLencable, argEquipment, argByhand);
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
	 * findByQBE
	 */
	public java.util.Enumeration findByQBE(java.lang.Integer argBSNum, java.lang.String bsType, java.lang.Boolean isPlanstate, java.lang.String argPlanstate, java.lang.Boolean isState, java.lang.String argState, java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaBean)persister).findByQBE(argBSNum, bsType, isPlanstate, argPlanstate, isState, argState, order));	}
	/**
	 * findAntennesByResource
	 */
	public java.util.Enumeration findAntennesByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaBean)persister).findAntennesByResource(inKey));	}
	/**
	 * findGrresAntennesByGroundresource
	 */
	public java.util.Enumeration findGrresAntennesByGroundresource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaBean)persister).findGrresAntennesByGroundresource(inKey));	}
	/**
	 * findAntennesByEquipment
	 */
	public java.util.Enumeration findAntennesByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaBean)persister).findAntennesByEquipment(inKey));	}
	/**
	 * create
	 */
	public com.hps.july.persistence.Antenna create(int argIdanten, int argResource, java.lang.String argNumant, java.lang.String argKindant, java.math.BigDecimal argNakl, java.math.BigDecimal argAzant, java.math.BigDecimal argHset1, java.math.BigDecimal argLencable, int argEquipment) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.Antenna _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.AntennaBean bean = (com.hps.july.persistence.AntennaBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argIdanten, argResource, argNumant, argKindant, argNakl, argAzant, argHset1, argLencable, argEquipment);
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
	 * findAntennesByCableres
	 */
	public java.util.Enumeration findAntennesByCableres(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaBean)persister).findAntennesByCableres(inKey));	}
	/**
	 * findByEquipmentOrderByNumAsc
	 */
	public java.util.Enumeration findByEquipmentOrderByNumAsc(java.lang.Integer argEquipment) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderAntennaBean)persister).findByEquipmentOrderByNumAsc(argEquipment));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.Antenna findByPrimaryKey(com.hps.july.persistence.AntennaKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPAntennaBean_8f208dce) persister).findByPrimaryKey(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.AntennaBean tmpEJB = (com.hps.july.persistence.AntennaBean) generalEJB;
		com.hps.july.persistence.AntennaKey keyClass = new com.hps.july.persistence.AntennaKey();
		keyClass.idanten = tmpEJB.idanten;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.AntennaKey keyFromFields(int f0) {
		com.hps.july.persistence.AntennaKey keyClass = new com.hps.july.persistence.AntennaKey();
		keyClass.idanten = f0;
		return keyClass;
	}
}
