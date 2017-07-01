package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * IBPMountPosFactory
 * @generated
 */
public class IBPMountPosFactory extends AbstractEJBFactory {
	/**
	 * IBPMountPosFactory
	 * @generated
	 */
	public IBPMountPosFactory() {
		super();
	}
	/**
	 * _acquireIBPMountPosHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.IBPMountPosHome _acquireIBPMountPosHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.IBPMountPosHome) _acquireEJBHome();
	}
	/**
	 * acquireIBPMountPosHome
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPosHome acquireIBPMountPosHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.IBPMountPosHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/IBPMountPos";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.IBPMountPosHome.class;
	}
	/**
	 * resetIBPMountPosHome
	 * @generated
	 */
	public void resetIBPMountPosHome() {
		resetEJBHome();
	}
	/**
	 * setIBPMountPosHome
	 * @generated
	 */
	public void setIBPMountPosHome(
		com.hps.july.persistence.IBPMountPosHome home) {
		setEJBHome(home);
	}
	/**
	 * findByStorageAfterDate
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPos findByStorageAfterDate(
		java.lang.Integer argStorage,
		java.sql.Date argDate)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByStorageAfterDate(
			argStorage,
			argDate);
	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findDocPositionsByDocOrderByOrderAsc(
			argDocument);
	}
	/**
	 * findByResourceSetAndStorageAfterDate
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.IBPMountPos findByResourceSetAndStorageAfterDate(
			java.lang.Integer argDocument,
			java.lang.Integer argStorage,
			java.sql.Date argDate)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByResourceSetAndStorageAfterDate(
			argDocument,
			argStorage,
			argDate);
	}
	/**
	 * findByDocumentQBE
	 * @generated
	 */
	public java.util.Enumeration findByDocumentQBE(
		java.lang.Integer argDocument,
		java.lang.String argPolicy,
		java.lang.String argNumber,
		java.lang.Boolean isResource,
		java.lang.Integer argResource,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByDocumentQBE(
			argDocument,
			argPolicy,
			argNumber,
			isResource,
			argResource,
			order);
	}
	/**
	 * findMaxOrderPosition
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPos findMaxOrderPosition(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findMaxOrderPosition(argDocument);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Integer argResource,
		java.lang.Integer argOwner,
		java.lang.Boolean isSerial,
		java.lang.String argSerial,
		java.lang.Boolean isParty,
		java.lang.String argParty,
		java.lang.Boolean isTo,
		java.lang.Integer argTo,
		java.lang.Boolean isFrom,
		java.lang.Integer argFrom,
		java.lang.String argDocType,
		java.lang.Boolean isAddDoc,
		java.lang.Integer argAddDoc)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByQBE(
			argResource,
			argOwner,
			isSerial,
			argSerial,
			isParty,
			argParty,
			isTo,
			argTo,
			isFrom,
			argFrom,
			argDocType,
			isAddDoc,
			argAddDoc);
	}
	/**
	 * findByAgregateAfterDate
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPos findByAgregateAfterDate(
		java.lang.String argAgregatSerial,
		java.sql.Date argDate)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByAgregateAfterDate(
			argAgregatSerial,
			argDate);
	}
	/**
	 * findByDocumentQBE2
	 * @generated
	 */
	public java.util.Enumeration findByDocumentQBE2(
		java.lang.Integer argDocument,
		java.lang.String argPolicy,
		java.lang.String argNumber,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isResource,
		java.lang.Integer argResource,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByDocumentQBE2(
			argDocument,
			argPolicy,
			argNumber,
			isOwner,
			owner,
			isResource,
			argResource,
			order);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPos findByPrimaryKey(
		com.hps.july.persistence.DocumentPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByPrimaryKey(key);
	}
	/**
	 * findBadAgregatesByDocument
	 * @generated
	 */
	public java.util.Enumeration findBadAgregatesByDocument(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findBadAgregatesByDocument(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPos create(
		int argDocposition,
		java.lang.Integer argResource,
		java.lang.Integer argOwner,
		java.lang.Integer argDocument,
		int argOrder,
		java.math.BigDecimal argQty,
		java.math.BigDecimal argPrice,
		java.lang.Boolean argSourceBoxed,
		java.lang.Boolean argResultBoxed,
		java.lang.Boolean argSourceBroken,
		java.lang.Boolean argResultBroken,
		java.lang.Boolean argSourceClosed,
		java.lang.Boolean argResultClosed)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireIBPMountPosHome().create(
			argDocposition,
			argResource,
			argOwner,
			argDocument,
			argOrder,
			argQty,
			argPrice,
			argSourceBoxed,
			argResultBoxed,
			argSourceBroken,
			argResultBroken,
			argSourceClosed,
			argResultClosed);
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(
		java.lang.Integer argDocument,
		java.lang.String argPolicy)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome()
			.findDocPositionsByDocAndPolicyOrderByOrderAsc(
			argDocument,
			argPolicy);
	}
	/**
	 * findByDocumentSerialnum
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPos findByDocumentSerialnum(
		java.lang.Integer argDocument,
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByDocumentSerialnum(
			argDocument,
			argSerial);
	}
	/**
	 * findByDocOrderByAgregateAsc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByDocOrderByAgregateAsc(
			argDocument);
	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findDocPositionsByDocOrderByOrderDesc(
			argDocument);
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 * @generated
	 */
	public java
		.util
		.Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(
		java.lang.Integer argDocument,
		java.lang.String argPolicy)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome()
			.findDocPositionsByDocAndPolicyOrderByOrderDesc(
			argDocument,
			argPolicy);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.IBPMountPos create(int argDocposition)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireIBPMountPosHome().create(argDocposition);
	}
	/**
	 * findByDocOrderByAgregateDesc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByDocOrderByAgregateDesc(
			argDocument);
	}
	/**
	 * findByRequestResource
	 * @generated
	 */
	public java.util.Enumeration findByRequestResource(
		java.lang.Integer requestId,
		java.lang.Integer resourceId)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireIBPMountPosHome().findByRequestResource(
			requestId,
			resourceId);
	}
}
