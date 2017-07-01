package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * DocumentPositionFactory
 * @generated
 */
public class DocumentPositionFactory extends AbstractEJBFactory {
	/**
	 * DocumentPositionFactory
	 * @generated
	 */
	public DocumentPositionFactory() {
		super();
	}
	/**
	 * _acquireDocumentPositionHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.DocumentPositionHome _acquireDocumentPositionHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.DocumentPositionHome) _acquireEJBHome();
	}
	/**
	 * acquireDocumentPositionHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.DocumentPositionHome acquireDocumentPositionHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.DocumentPositionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/DocumentPosition";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.DocumentPositionHome.class;
	}
	/**
	 * resetDocumentPositionHome
	 * @generated
	 */
	public void resetDocumentPositionHome() {
		resetEJBHome();
	}
	/**
	 * setDocumentPositionHome
	 * @generated
	 */
	public void setDocumentPositionHome(
		com.hps.july.persistence.DocumentPositionHome home) {
		setEJBHome(home);
	}
	/**
	 * findByStorageAfterDate
	 * @generated
	 */
	public com.hps.july.persistence.DocumentPosition findByStorageAfterDate(
		java.lang.Integer argStorage,
		java.sql.Date argDate)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findByStorageAfterDate(
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
		return _acquireDocumentPositionHome()
			.findDocPositionsByDocOrderByOrderAsc(
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
		.DocumentPosition findByResourceSetAndStorageAfterDate(
			java.lang.Integer argDocument,
			java.lang.Integer argStorage,
			java.sql.Date argDate)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome()
			.findByResourceSetAndStorageAfterDate(
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
		return _acquireDocumentPositionHome().findByDocumentQBE(
			argDocument,
			argPolicy,
			argNumber,
			isResource,
			argResource,
			order);
	}
	/**
	 * findDocumentPositionByResource
	 * @generated
	 */
	public java.util.Enumeration findDocumentPositionByResource(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findDocumentPositionByResource(
			inKey);
	}
	/**
	 * findDocumentPositionByDocument
	 * @generated
	 */
	public java.util.Enumeration findDocumentPositionByDocument(
		com.hps.july.persistence.DocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findDocumentPositionByDocument(
			inKey);
	}
	/**
	 * findMaxOrderPosition
	 * @generated
	 */
	public com.hps.july.persistence.DocumentPosition findMaxOrderPosition(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findMaxOrderPosition(argDocument);
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
		return _acquireDocumentPositionHome().findByQBE(
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
	public com.hps.july.persistence.DocumentPosition findByAgregateAfterDate(
		java.lang.String argAgregatSerial,
		java.sql.Date argDate)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findByAgregateAfterDate(
			argAgregatSerial,
			argDate);
	}
	/**
	 * findDocumentPositionByOwner
	 * @generated
	 */
	public java.util.Enumeration findDocumentPositionByOwner(
		com.hps.july.persistence.OrganizationKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findDocumentPositionByOwner(
			inKey);
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
		return _acquireDocumentPositionHome().findByDocumentQBE2(
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
	public com.hps.july.persistence.DocumentPosition findByPrimaryKey(
		com.hps.july.persistence.DocumentPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findByPrimaryKey(key);
	}
	/**
	 * findBadAgregatesByDocument
	 * @generated
	 */
	public java.util.Enumeration findBadAgregatesByDocument(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findBadAgregatesByDocument(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.DocumentPosition create(
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
		return _acquireDocumentPositionHome().create(
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
	 * findAgregatePartsByAgregate
	 * @generated
	 */
	public java.util.Enumeration findAgregatePartsByAgregate(
		com.hps.july.persistence.DocumentPositionKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findAgregatePartsByAgregate(
			inKey);
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(
		java.lang.Integer argDocument,
		java.lang.String argPolicy)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome()
			.findDocPositionsByDocAndPolicyOrderByOrderAsc(
			argDocument,
			argPolicy);
	}
	/**
	 * findByDocumentSerialnum
	 * @generated
	 */
	public com.hps.july.persistence.DocumentPosition findByDocumentSerialnum(
		java.lang.Integer argDocument,
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findByDocumentSerialnum(
			argDocument,
			argSerial);
	}
	/**
	 * findInDocumentPositionByCardTo
	 * @generated
	 */
	public java.util.Enumeration findInDocumentPositionByCardTo(
		com.hps.july.persistence.StorageCardKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findInDocumentPositionByCardTo(
			inKey);
	}
	/**
	 * findByDocOrderByAgregateAsc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findByDocOrderByAgregateAsc(
			argDocument);
	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome()
			.findDocPositionsByDocOrderByOrderDesc(
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
		return _acquireDocumentPositionHome()
			.findDocPositionsByDocAndPolicyOrderByOrderDesc(
			argDocument,
			argPolicy);
	}
	/**
	 * findOutDocumentPositionByCardFrom
	 * @generated
	 */
	public java.util.Enumeration findOutDocumentPositionByCardFrom(
		com.hps.july.persistence.StorageCardKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome()
			.findOutDocumentPositionByCardFrom(
			inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.DocumentPosition create(int argDocposition)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireDocumentPositionHome().create(argDocposition);
	}
	/**
	 * findByDocOrderByAgregateDesc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByAgregateDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentPositionHome().findByDocOrderByAgregateDesc(
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
		return _acquireDocumentPositionHome().findByRequestResource(
			requestId,
			resourceId);
	}
}
