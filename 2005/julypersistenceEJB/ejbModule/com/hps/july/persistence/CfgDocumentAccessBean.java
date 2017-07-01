package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * CfgDocumentAccessBean
 * @generated
 */
public class CfgDocumentAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.CfgDocumentAccessBeanData {
	/**
	 * @generated
	 */
	private CfgDocument __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_document;
	/**
	 * getSavconfigidold
	 * @generated
	 */
	public int getSavconfigidold()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("savconfigidold")).intValue());
	}
	/**
	 * setSavconfigidold
	 * @generated
	 */
	public void setSavconfigidold(int newValue) {
		__setCache("savconfigidold", new Integer(newValue));
	}
	/**
	 * getSavconfigidnew
	 * @generated
	 */
	public int getSavconfigidnew()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("savconfigidnew")).intValue());
	}
	/**
	 * setSavconfigidnew
	 * @generated
	 */
	public void setSavconfigidnew(int newValue) {
		__setCache("savconfigidnew", new Integer(newValue));
	}
	/**
	 * getVisualtype
	 * @generated
	 */
	public java.lang.Integer getVisualtype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("visualtype")));
	}
	/**
	 * setVisualtype
	 * @generated
	 */
	public void setVisualtype(java.lang.Integer newValue) {
		__setCache("visualtype", newValue);
	}
	/**
	 * getBlankindex
	 * @generated
	 */
	public int getBlankindex()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("blankindex")).intValue());
	}
	/**
	 * setBlankindex
	 * @generated
	 */
	public void setBlankindex(int newValue) {
		__setCache("blankindex", new Integer(newValue));
	}
	/**
	 * getDocument
	 * @generated
	 */
	public int getDocument()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("document")).intValue());
	}
	/**
	 * setDocument
	 * @generated
	 */
	public void setDocument(int newValue) {
		__setCache("document", new Integer(newValue));
	}
	/**
	 * getInsurancedate
	 * @generated
	 */
	public java.sql.Date getInsurancedate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("insurancedate")));
	}
	/**
	 * setInsurancedate
	 * @generated
	 */
	public void setInsurancedate(java.sql.Date newValue) {
		__setCache("insurancedate", newValue);
	}
	/**
	 * getProcessSource
	 * @generated
	 */
	public java.lang.Boolean getProcessSource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("processSource")));
	}
	/**
	 * setProcessSource
	 * @generated
	 */
	public void setProcessSource(java.lang.Boolean newValue) {
		__setCache("processSource", newValue);
	}
	/**
	 * getShowtouser
	 * @generated
	 */
	public boolean getShowtouser()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("showtouser")).booleanValue());
	}
	/**
	 * setShowtouser
	 * @generated
	 */
	public void setShowtouser(boolean newValue) {
		__setCache("showtouser", new Boolean(newValue));
	}
	/**
	 * getStorageManagerKey
	 * @generated
	 */
	public com.hps.july.persistence.WorkerKey getStorageManagerKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.WorkerKey) __getCache("storageManagerKey")));
	}
	/**
	 * getIsautodoc
	 * @generated
	 */
	public boolean getIsautodoc()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("isautodoc")).booleanValue());
	}
	/**
	 * setIsautodoc
	 * @generated
	 */
	public void setIsautodoc(boolean newValue) {
		__setCache("isautodoc", new Boolean(newValue));
	}
	/**
	 * getBlanknumber
	 * @generated
	 */
	public java.lang.String getBlanknumber()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("blanknumber")));
	}
	/**
	 * setBlanknumber
	 * @generated
	 */
	public void setBlanknumber(java.lang.String newValue) {
		__setCache("blanknumber", newValue);
	}
	/**
	 * getContragentKey
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationKey getContragentKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.OrganizationKey) __getCache("contragentKey")));
	}
	/**
	 * getPrjstatus
	 * @generated
	 */
	public java.lang.String getPrjstatus()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("prjstatus")));
	}
	/**
	 * setPrjstatus
	 * @generated
	 */
	public void setPrjstatus(java.lang.String newValue) {
		__setCache("prjstatus", newValue);
	}
	/**
	 * getInsuranseMan
	 * @generated
	 */
	public java.lang.String getInsuranseMan()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("insuranseMan")));
	}
	/**
	 * setInsuranseMan
	 * @generated
	 */
	public void setInsuranseMan(java.lang.String newValue) {
		__setCache("insuranseMan", newValue);
	}
	/**
	 * getFromKey
	 * @generated
	 */
	public com.hps.july.persistence.StoragePlaceKey getFromKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com.hps.july.persistence.StoragePlaceKey) __getCache("fromKey")));
	}
	/**
	 * getParentdocument
	 * @generated
	 */
	public java.lang.Integer getParentdocument()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("parentdocument")));
	}
	/**
	 * setParentdocument
	 * @generated
	 */
	public void setParentdocument(java.lang.Integer newValue) {
		__setCache("parentdocument", newValue);
	}
	/**
	 * getNeedapprove
	 * @generated
	 */
	public boolean getNeedapprove()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("needapprove")).booleanValue());
	}
	/**
	 * setNeedapprove
	 * @generated
	 */
	public void setNeedapprove(boolean newValue) {
		__setCache("needapprove", new Boolean(newValue));
	}
	/**
	 * getDocumentState
	 * @generated
	 */
	public java.lang.String getDocumentState()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("documentState")));
	}
	/**
	 * setDocumentState
	 * @generated
	 */
	public void setDocumentState(java.lang.String newValue) {
		__setCache("documentState", newValue);
	}
	/**
	 * getProcessDestination
	 * @generated
	 */
	public java.lang.Boolean getProcessDestination()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("processDestination")));
	}
	/**
	 * setProcessDestination
	 * @generated
	 */
	public void setProcessDestination(java.lang.Boolean newValue) {
		__setCache("processDestination", newValue);
	}
	/**
	 * getTo2
	 * @generated
	 */
	public java.lang.Integer getTo2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("to2")));
	}
	/**
	 * setTo2
	 * @generated
	 */
	public void setTo2(java.lang.Integer newValue) {
		__setCache("to2", newValue);
	}
	/**
	 * getBlankdate
	 * @generated
	 */
	public java.sql.Date getBlankdate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("blankdate")));
	}
	/**
	 * setBlankdate
	 * @generated
	 */
	public void setBlankdate(java.sql.Date newValue) {
		__setCache("blankdate", newValue);
	}
	/**
	 * getOperator
	 * @generated
	 */
	public java.lang.Integer getOperator()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("operator")));
	}
	/**
	 * setOperator
	 * @generated
	 */
	public void setOperator(java.lang.Integer newValue) {
		__setCache("operator", newValue);
	}
	/**
	 * getProjectid
	 * @generated
	 */
	public java.lang.Integer getProjectid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("projectid")));
	}
	/**
	 * setProjectid
	 * @generated
	 */
	public void setProjectid(java.lang.Integer newValue) {
		__setCache("projectid", newValue);
	}
	/**
	 * getInsuranceact
	 * @generated
	 */
	public java.lang.String getInsuranceact()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("insuranceact")));
	}
	/**
	 * setInsuranceact
	 * @generated
	 */
	public void setInsuranceact(java.lang.String newValue) {
		__setCache("insuranceact", newValue);
	}
	/**
	 * getToKey
	 * @generated
	 */
	public com.hps.july.persistence.StoragePlaceKey getToKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com.hps.july.persistence.StoragePlaceKey) __getCache("toKey")));
	}
	/**
	 * getOwnerKey
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationKey getOwnerKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.OrganizationKey) __getCache("ownerKey")));
	}
	/**
	 * setInitKey_document
	 * @generated
	 */
	public void setInitKey_document(int newValue) {
		this.initKey_document = (newValue);
	}
	/**
	 * CfgDocumentAccessBean
	 * @generated
	 */
	public CfgDocumentAccessBean() {
		super();
	}
	/**
	 * CfgDocumentAccessBean
	 * @generated
	 */
	public CfgDocumentAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "ejb/com/hps/july/persistence/CfgDocumentHome";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.CfgDocumentHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence
				.CfgDocumentHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence.CfgDocumentHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.CfgDocument ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.persistence
						.CfgDocument) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.CfgDocument.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		com.hps.july.persistence.DocumentKey key =
			keyFromFields(initKey_document);
		ejbRef = ejbHome().findByPrimaryKey(key);
	}
	/**
	 * instantiateEJBByPrimaryKey
	 * @generated
	 */
	protected boolean instantiateEJBByPrimaryKey()
		throws
			javax.ejb.CreateException,
			java.rmi.RemoteException,
			javax.naming.NamingException {
		boolean result = false;

		if (ejbRef() != null)
			return true;

		try {
			com.hps.july.persistence.DocumentKey pKey =
				(com.hps.july.persistence.DocumentKey) this.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * keyFromFields
	 * @generated
	 */
	private com.hps.july.persistence.DocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.DocumentKey keyClass =
			new com.hps.july.persistence.DocumentKey();
		keyClass.document = f0;
		return keyClass;
	}
	/**
	 * refreshCopyHelper
	 * @generated
	 */
	public void refreshCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		refreshCopyHelper(ejbRef());
	}
	/**
	 * commitCopyHelper
	 * @generated
	 */
	public void commitCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		commitCopyHelper(ejbRef());
	}
	/**
	 * CfgDocumentAccessBean
	 * @generated
	 */
	public CfgDocumentAccessBean(
		int argDocument,
		java.lang.Integer argOwner,
		java.lang.Integer argFrom,
		java.lang.Integer argTo,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argBlankNumber,
		java.lang.String argState,
		java.lang.Boolean argProcessSource,
		java.lang.Boolean argProcessDestination,
		int SavconfigIdOld,
		int SavconfigIdNew)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argDocument,
				argOwner,
				argFrom,
				argTo,
				argBlankDate,
				argBlankindex,
				argBlankNumber,
				argState,
				argProcessSource,
				argProcessDestination,
				SavconfigIdOld,
				SavconfigIdNew);
	}
	/**
	 * setFrom
	 * @generated
	 */
	public void setFrom(com.hps.july.persistence.StoragePlace aFrom)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setFrom(aFrom);
	}
	/**
	 * getDocumentPosition
	 * @generated
	 */
	public java.util.Enumeration getDocumentPosition()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getDocumentPosition();
	}
	/**
	 * getDocumentsLinkTo
	 * @generated
	 */
	public java.util.Enumeration getDocumentsLinkTo()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getDocumentsLinkTo();
	}
	/**
	 * getOwner
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationAccessBean getOwner()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Organization localEJBRef = ejbRef().getOwner();
		if (localEJBRef != null)
			return new com.hps.july.persistence.OrganizationAccessBean(
				localEJBRef);
		else
			return null;
	}
	/**
	 * secondarySetStorageManager
	 * @generated
	 */
	public void secondarySetStorageManager(
		com.hps.july.persistence.Worker aStorageManager)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetStorageManager(aStorageManager);
	}
	/**
	 * getCardTrack
	 * @generated
	 */
	public java.util.Enumeration getCardTrack()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getCardTrack();
	}
	/**
	 * secondarySetContragent
	 * @generated
	 */
	public void secondarySetContragent(
		com.hps.july.persistence.Organization aContragent)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetContragent(aContragent);
	}
	/**
	 * setStorageManager
	 * @generated
	 */
	public void setStorageManager(
		com.hps.july.persistence.Worker aStorageManager)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setStorageManager(aStorageManager);
	}
	/**
	 * privateSetFromKey
	 * @generated
	 */
	public void privateSetFromKey(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetFromKey(inKey);
	}
	/**
	 * secondaryRemoveDocumentPosition
	 * @generated
	 */
	public void secondaryRemoveDocumentPosition(
		com.hps.july.persistence.DocumentPosition aDocumentPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveDocumentPosition(aDocumentPosition);
	}
	/**
	 * addDocumentPosition
	 * @generated
	 */
	public void addDocumentPosition(
		com.hps.july.persistence.DocumentPosition aDocumentPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addDocumentPosition(aDocumentPosition);
	}
	/**
	 * secondarySetFrom
	 * @generated
	 */
	public void secondarySetFrom(com.hps.july.persistence.StoragePlace aFrom)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetFrom(aFrom);
	}
	/**
	 * privateSetToKey
	 * @generated
	 */
	public void privateSetToKey(com.hps.july.persistence.StoragePlaceKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetToKey(inKey);
	}
	/**
	 * privateSetContragentKey
	 * @generated
	 */
	public void privateSetContragentKey(
		com.hps.july.persistence.OrganizationKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetContragentKey(inKey);
	}
	/**
	 * secondaryRemoveCurrentStorageCard
	 * @generated
	 */
	public void secondaryRemoveCurrentStorageCard(
		com.hps.july.persistence.StorageCard aCurrentStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveCurrentStorageCard(aCurrentStorageCard);
	}
	/**
	 * secondaryRemoveDocumentsLinkTo
	 * @generated
	 */
	public void secondaryRemoveDocumentsLinkTo(
		com.hps.july.persistence.DocumentsLink aDocumentsLinkTo)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveDocumentsLinkTo(aDocumentsLinkTo);
	}
	/**
	 * setOwner
	 * @generated
	 */
	public void setOwner(com.hps.july.persistence.Organization anOwner)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setOwner(anOwner);
	}
	/**
	 * secondaryRemoveCardTrack
	 * @generated
	 */
	public void secondaryRemoveCardTrack(
		com.hps.july.persistence.CardTrack aCardTrack)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveCardTrack(aCardTrack);
	}
	/**
	 * getContragent
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationAccessBean getContragent()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Organization localEJBRef =
			ejbRef().getContragent();
		if (localEJBRef != null)
			return new com.hps.july.persistence.OrganizationAccessBean(
				localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryRemoveDocumentsLinkFrom
	 * @generated
	 */
	public void secondaryRemoveDocumentsLinkFrom(
		com.hps.july.persistence.DocumentsLink aDocumentsLinkFrom)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveDocumentsLinkFrom(aDocumentsLinkFrom);
	}
	/**
	 * getTo
	 * @generated
	 */
	public com.hps.july.persistence.StoragePlaceAccessBean getTo()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.StoragePlace localEJBRef = ejbRef().getTo();
		if (localEJBRef != null)
			return new com.hps.july.persistence.StoragePlaceAccessBean(
				localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryAddCardTrack
	 * @generated
	 */
	public void secondaryAddCardTrack(
		com.hps.july.persistence.CardTrack aCardTrack)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddCardTrack(aCardTrack);
	}
	/**
	 * addStorageCard
	 * @generated
	 */
	public void addStorageCard(
		com.hps.july.persistence.StorageCard aStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addStorageCard(aStorageCard);
	}
	/**
	 * addCardTrack
	 * @generated
	 */
	public void addCardTrack(com.hps.july.persistence.CardTrack aCardTrack)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addCardTrack(aCardTrack);
	}
	/**
	 * secondarySetOwner
	 * @generated
	 */
	public void secondarySetOwner(
		com.hps.july.persistence.Organization anOwner)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetOwner(anOwner);
	}
	/**
	 * privateSetStorageManagerKey
	 * @generated
	 */
	public void privateSetStorageManagerKey(
		com.hps.july.persistence.WorkerKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetStorageManagerKey(inKey);
	}
	/**
	 * secondaryAddCurrentStorageCard
	 * @generated
	 */
	public void secondaryAddCurrentStorageCard(
		com.hps.july.persistence.StorageCard aCurrentStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddCurrentStorageCard(aCurrentStorageCard);
	}
	/**
	 * secondarySetTo
	 * @generated
	 */
	public void secondarySetTo(com.hps.july.persistence.StoragePlace aTo)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetTo(aTo);
	}
	/**
	 * getStorageManager
	 * @generated
	 */
	public com.hps.july.persistence.WorkerAccessBean getStorageManager()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Worker localEJBRef =
			ejbRef().getStorageManager();
		if (localEJBRef != null)
			return new com.hps.july.persistence.WorkerAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryRemoveStorageCard
	 * @generated
	 */
	public void secondaryRemoveStorageCard(
		com.hps.july.persistence.StorageCard aStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveStorageCard(aStorageCard);
	}
	/**
	 * secondaryAddDocumentsLinkFrom
	 * @generated
	 */
	public void secondaryAddDocumentsLinkFrom(
		com.hps.july.persistence.DocumentsLink aDocumentsLinkFrom)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddDocumentsLinkFrom(aDocumentsLinkFrom);
	}
	/**
	 * secondaryAddStorageCard
	 * @generated
	 */
	public void secondaryAddStorageCard(
		com.hps.july.persistence.StorageCard aStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddStorageCard(aStorageCard);
	}
	/**
	 * getStorageCard
	 * @generated
	 */
	public java.util.Enumeration getStorageCard()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getStorageCard();
	}
	/**
	 * getFrom
	 * @generated
	 */
	public com.hps.july.persistence.StoragePlaceAccessBean getFrom()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.StoragePlace localEJBRef = ejbRef().getFrom();
		if (localEJBRef != null)
			return new com.hps.july.persistence.StoragePlaceAccessBean(
				localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryAddDocumentsLinkTo
	 * @generated
	 */
	public void secondaryAddDocumentsLinkTo(
		com.hps.july.persistence.DocumentsLink aDocumentsLinkTo)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddDocumentsLinkTo(aDocumentsLinkTo);
	}
	/**
	 * setTo
	 * @generated
	 */
	public void setTo(com.hps.july.persistence.StoragePlace aTo)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setTo(aTo);
	}
	/**
	 * privateSetOwnerKey
	 * @generated
	 */
	public void privateSetOwnerKey(
		com.hps.july.persistence.OrganizationKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetOwnerKey(inKey);
	}
	/**
	 * addCurrentStorageCard
	 * @generated
	 */
	public void addCurrentStorageCard(
		com.hps.july.persistence.StorageCard aCurrentStorageCard)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addCurrentStorageCard(aCurrentStorageCard);
	}
	/**
	 * setContragent
	 * @generated
	 */
	public void setContragent(
		com.hps.july.persistence.Organization aContragent)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setContragent(aContragent);
	}
	/**
	 * getCurrentStorageCard
	 * @generated
	 */
	public java.util.Enumeration getCurrentStorageCard()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getCurrentStorageCard();
	}
	/**
	 * getDocumentsLinkFrom
	 * @generated
	 */
	public java.util.Enumeration getDocumentsLinkFrom()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getDocumentsLinkFrom();
	}
	/**
	 * secondaryAddDocumentPosition
	 * @generated
	 */
	public void secondaryAddDocumentPosition(
		com.hps.july.persistence.DocumentPosition aDocumentPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddDocumentPosition(aDocumentPosition);
	}
	/**
	 * getStorebad
	 * @generated
	 */
	public java.lang.Integer getStorebad()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("storebad")));
	}
	/**
	 * setStorebad
	 * @generated
	 */
	public void setStorebad(java.lang.Integer newValue) {
		__setCache("storebad", newValue);
	}
	/**
	 * getStoredem
	 * @generated
	 */
	public java.lang.Integer getStoredem()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("storedem")));
	}
	/**
	 * setStoredem
	 * @generated
	 */
	public void setStoredem(java.lang.Integer newValue) {
		__setCache("storedem", newValue);
	}
}
