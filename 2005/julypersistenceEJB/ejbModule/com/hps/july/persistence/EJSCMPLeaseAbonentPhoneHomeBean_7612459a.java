package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPLeaseAbonentPhoneHomeBean_7612459a
 */
public class EJSCMPLeaseAbonentPhoneHomeBean_7612459a extends EJSHome {
	/**
	 * EJSCMPLeaseAbonentPhoneHomeBean_7612459a
	 */
	public EJSCMPLeaseAbonentPhoneHomeBean_7612459a() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.LeaseAbonentPhone postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.LeaseAbonentPhone) super.postCreate(beanO, ejsKey, true);
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
	public com.hps.july.persistence.LeaseAbonentPhone create(int argLeasedocument, java.lang.String argPhonenumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.LeaseAbonentPhone _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.LeaseAbonentPhoneBean bean = (com.hps.july.persistence.LeaseAbonentPhoneBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argLeasedocument, argPhonenumber);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argLeasedocument, argPhonenumber);
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
	public com.hps.july.persistence.LeaseAbonentPhone findByPrimaryKey(com.hps.july.persistence.LeaseAbonentPhoneKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPLeaseAbonentPhoneBean_7612459a) persister).findByPrimaryKey(key);
	}
	/**
	 * findByLeaseDocumentOrderByPhoneNumberAsc
	 */
	public java.util.Enumeration findByLeaseDocumentOrderByPhoneNumberAsc(java.lang.Integer leaseDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentPhoneBean)persister).findByLeaseDocumentOrderByPhoneNumberAsc(leaseDocument));	}
	/**
	 * findLeaseAbonentPhonesByPhone2ban
	 */
	public java.util.Enumeration findLeaseAbonentPhonesByPhone2ban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderLeaseAbonentPhoneBean)persister).findLeaseAbonentPhonesByPhone2ban(inKey));	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.hps.july.persistence.LeaseAbonentPhoneBean tmpEJB = (com.hps.july.persistence.LeaseAbonentPhoneBean) generalEJB;
		com.hps.july.persistence.LeaseAbonentPhoneKey keyClass = new com.hps.july.persistence.LeaseAbonentPhoneKey();
		keyClass.phonenumber = tmpEJB.phonenumber;
		keyClass.phone2ban_leaseDocument = tmpEJB.phone2ban_leaseDocument;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.LeaseAbonentPhoneKey keyFromFields(java.lang.String f0, java.lang.Integer f1) {
		com.hps.july.persistence.LeaseAbonentPhoneKey keyClass = new com.hps.july.persistence.LeaseAbonentPhoneKey();
		keyClass.phonenumber = f0;
		keyClass.phone2ban_leaseDocument = f1;
		return keyClass;
	}
}
