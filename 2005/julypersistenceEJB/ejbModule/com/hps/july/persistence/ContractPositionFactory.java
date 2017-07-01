package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ContractPositionFactory
 * @generated
 */
public class ContractPositionFactory extends AbstractEJBFactory {
	/**
	 * ContractPositionFactory
	 * @generated
	 */
	public ContractPositionFactory() {
		super();
	}
	/**
	 * _acquireContractPositionHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.ContractPositionHome _acquireContractPositionHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.ContractPositionHome) _acquireEJBHome();
	}
	/**
	 * acquireContractPositionHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.ContractPositionHome acquireContractPositionHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.ContractPositionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/ContractPosition";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.ContractPositionHome.class;
	}
	/**
	 * resetContractPositionHome
	 * @generated
	 */
	public void resetContractPositionHome() {
		resetEJBHome();
	}
	/**
	 * setContractPositionHome
	 * @generated
	 */
	public void setContractPositionHome(
		com.hps.july.persistence.ContractPositionHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.ContractPosition findByPrimaryKey(
		com.hps.july.persistence.DocumentPositionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome().findByPrimaryKey(key);
	}
	/**
	 * findMaxOrderPosition
	 * @generated
	 */
	public com.hps.july.persistence.ContractPosition findMaxOrderPosition(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome().findMaxOrderPosition(argDocument);
	}
	/**
	 * findByDocOrderByContractPositionOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findByDocOrderByContractPositionOrderAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome()
			.findByDocOrderByContractPositionOrderAsc(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.ContractPosition create(
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
		java.lang.Boolean argResultClosed,
		java.lang.String argContractPositionOrder)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireContractPositionHome().create(
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
			argResultClosed,
			argContractPositionOrder);
	}
	/**
	 * findByDocumentSerialnum
	 * @generated
	 */
	public com.hps.july.persistence.ContractPosition findByDocumentSerialnum(
		java.lang.Integer argDocument,
		java.lang.String argSerial)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome().findByDocumentSerialnum(
			argDocument,
			argSerial);
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
		return _acquireContractPositionHome()
			.findDocPositionsByDocAndPolicyOrderByOrderDesc(
			argDocument,
			argPolicy);
	}
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(
		java.lang.Integer argDocument,
		java.lang.String argPolicy)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome()
			.findDocPositionsByDocAndPolicyOrderByOrderAsc(
			argDocument,
			argPolicy);
	}
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderAsc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome()
			.findDocPositionsByDocOrderByOrderAsc(
			argDocument);
	}
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 * @generated
	 */
	public java.util.Enumeration findDocPositionsByDocOrderByOrderDesc(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome()
			.findDocPositionsByDocOrderByOrderDesc(
			argDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.ContractPosition create(int argDocposition)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireContractPositionHome().create(argDocposition);
	}
	/**
	 * findBadAgregatesByDocument
	 * @generated
	 */
	public java.util.Enumeration findBadAgregatesByDocument(
		java.lang.Integer argDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractPositionHome().findBadAgregatesByDocument(
			argDocument);
	}
}
