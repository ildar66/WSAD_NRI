package com.hps.july.persistence;

import com.ibm.ejs.container.*;

/**
 * EJSCMPCardTrackHomeBean_f33ec78d
 */
public class EJSCMPCardTrackHomeBean_f33ec78d extends EJSHome {
	/**
	 * EJSCMPCardTrackHomeBean_f33ec78d
	 */
	public EJSCMPCardTrackHomeBean_f33ec78d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * postCreateWrapper
	 */
	public com.hps.july.persistence.CardTrack postCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return  (com.hps.july.persistence.CardTrack) super.postCreate(beanO, ejsKey, true);
	}
	/**
	 * afterPostCreateWrapper
	 */
	public void afterPostCreateWrapper(com.ibm.ejs.container.BeanO beanO, Object ejsKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		super.afterPostCreate(beanO, ejsKey);
	}
	/**
	 * findCardTrackByDocument
	 */
	public java.util.Enumeration findCardTrackByDocument(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCardTrackBean)persister).findCardTrackByDocument(inKey));	}
	/**
	 * findCardTrackFromByFrom
	 */
	public java.util.Enumeration findCardTrackFromByFrom(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCardTrackBean)persister).findCardTrackFromByFrom(inKey));	}
	/**
	 * findByPrimaryKey
	 */
	public com.hps.july.persistence.CardTrack findByPrimaryKey(com.hps.july.persistence.CardTrackKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return ((com.hps.july.persistence.EJSJDBCPersisterCMPCardTrackBean_f33ec78d) persister).findByPrimaryKey(key);
	}
	/**
	 * create
	 */
	public com.hps.july.persistence.CardTrack create(int argTrackId, java.lang.Integer argCard, java.lang.Integer argDocument, java.sql.Timestamp argWhen, java.lang.String argType) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.CardTrack _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CardTrackBean bean = (com.hps.july.persistence.CardTrackBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTrackId, argCard, argDocument, argWhen, argType);
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
	 * findBySerialAfterId
	 */
	public java.util.Enumeration findBySerialAfterId(java.lang.String argSerial, java.lang.Integer id) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCardTrackBean)persister).findBySerialAfterId(argSerial, id));	}
	/**
	 * findCardTrackByCard
	 */
	public java.util.Enumeration findCardTrackByCard(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCardTrackBean)persister).findCardTrackByCard(inKey));	}
	/**
	 * findLastDocumentTrack
	 */
	public com.hps.july.persistence.CardTrack findLastDocumentTrack(java.lang.Integer argCard, java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPCardTrackBean_f33ec78d)persister).findLastDocumentTrack(argCard, argDocument);	}
	/**
	 * findCardTrackToByTo
	 */
	public java.util.Enumeration findCardTrackToByTo(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
return super.getEnumeration(((com.hps.july.persistence.EJSFinderCardTrackBean)persister).findCardTrackToByTo(inKey));	}
	/**
	 * findBeforeDocument
	 */
	public com.hps.july.persistence.CardTrack findBeforeDocument(java.lang.Integer argCard, java.lang.Integer argDocument) throws java.rmi.RemoteException, javax.ejb.FinderException {
return ((com.hps.july.persistence.EJSJDBCPersisterCMPCardTrackBean_f33ec78d)persister).findBeforeDocument(argCard, argDocument);	}
	/**
	 * create
	 */
	public com.hps.july.persistence.CardTrack create(int argTrackId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.hps.july.persistence.CardTrack _EJS_result = null;
		boolean createFailed = false;
		try {
			beanO = super.createBeanO();
			com.hps.july.persistence.CardTrackBean bean = (com.hps.july.persistence.CardTrackBean) beanO.getEnterpriseBean();
			bean.ejbCreate(argTrackId);
			Object _primaryKey = keyFromBean(bean);
_EJS_result = postCreateWrapper(beanO, _primaryKey);
			bean.ejbPostCreate(argTrackId);
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
		com.hps.july.persistence.CardTrackBean tmpEJB = (com.hps.july.persistence.CardTrackBean) generalEJB;
		com.hps.july.persistence.CardTrackKey keyClass = new com.hps.july.persistence.CardTrackKey();
		keyClass.trackId = tmpEJB.trackId;
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.hps.july.persistence.CardTrackKey keyFromFields(int f0) {
		com.hps.july.persistence.CardTrackKey keyClass = new com.hps.july.persistence.CardTrackKey();
		keyClass.trackId = f0;
		return keyClass;
	}
}
