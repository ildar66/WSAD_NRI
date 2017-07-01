package com.hps.july.persistence2;

import com.ibm.ejs.container.*;

/**
 * EJSCMPBeenet2EquipmentHomeBean_1c9d5b1d
 */
public class EJSCMPBeenet2EquipmentHomeBean_1c9d5b1d extends EJSHome {
	/**
	 * EJSCMPBeenet2EquipmentHomeBean_1c9d5b1d
	 */
	public EJSCMPBeenet2EquipmentHomeBean_1c9d5b1d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence2.Beenet2Equipment postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence2.Beenet2Equipment) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence2.Beenet2Equipment findByPrimaryKey(com.hps.july.persistence2.Beenet2EquipmentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence2.EJSJDBCPersisterCMPBeenet2EquipmentBean_1c9d5b1d) persister).findByPrimaryKey(key);
	}
	/**
	 * findByBeenetid
	 */
	public java.util.Enumeration findByBeenetid(java.lang.String beenetid) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence2.EJSFinderBeenet2EquipmentBean)persister).findByBeenetid(beenetid));	}
	/**
	 * create
	 */
	public com.hps.july.persistence2.Beenet2Equipment create(java.lang.String argBeenetid, int argEquipment) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence2.Beenet2Equipment _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence2.Beenet2EquipmentBean bean = (com.hps.july.persistence2.Beenet2EquipmentBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argBeenetid, argEquipment);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argBeenetid, argEquipment);
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
		com.hps.july.persistence2.Beenet2EquipmentBean tmpEJB = (com.hps.july.persistence2.Beenet2EquipmentBean) generalEJB;
		com.hps.july.persistence2.Beenet2EquipmentKey keyClass = new com.hps.july.persistence2.Beenet2EquipmentKey();
		keyClass.beenetid = tmpEJB.beenetid;
		keyClass.equipment = tmpEJB.equipment;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence2.Beenet2EquipmentKey keyFromFields(java.lang.String f0, int f1) {
		com.hps.july.persistence2.Beenet2EquipmentKey keyClass = new com.hps.july.persistence2.Beenet2EquipmentKey();
		keyClass.beenetid = f0;
		keyClass.equipment = f1;
		return keyClass;
	}
}
