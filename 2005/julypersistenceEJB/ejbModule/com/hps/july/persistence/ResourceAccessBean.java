package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * ResourceAccessBean
 * @generated
 */
public class ResourceAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.ResourceAccessBeanData {
	/**
	 * @generated
	 */
	private Resource __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_resource;
	/**
	 * getUnitKey
	 * @generated
	 */
	public com.hps.july.persistence.UnitKey getUnitKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((com.hps.july.persistence.UnitKey) __getCache("unitKey")));
	}
	/**
	 * getSubtypeKey
	 * @generated
	 */
	public com.hps.july.persistence.ResourceSubTypeKey getSubtypeKey()
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
				.ResourceSubTypeKey) __getCache("subtypeKey")));
	}
	/**
	 * getCountpolicy
	 * @generated
	 */
	public java.lang.String getCountpolicy()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("countpolicy")));
	}
	/**
	 * setCountpolicy
	 * @generated
	 */
	public void setCountpolicy(java.lang.String newValue) {
		__setCache("countpolicy", newValue);
	}
	/**
	 * getModel
	 * @generated
	 */
	public java.lang.String getModel()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("model")));
	}
	/**
	 * setModel
	 * @generated
	 */
	public void setModel(java.lang.String newValue) {
		__setCache("model", newValue);
	}
	/**
	 * getManufid
	 * @generated
	 */
	public java.lang.Integer getManufid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("manufid")));
	}
	/**
	 * setManufid
	 * @generated
	 */
	public void setManufid(java.lang.Integer newValue) {
		__setCache("manufid", newValue);
	}
	/**
	 * getResourceclass2
	 * @generated
	 */
	public java.lang.Integer getResourceclass2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("resourceclass2")));
	}
	/**
	 * setResourceclass2
	 * @generated
	 */
	public void setResourceclass2(java.lang.Integer newValue) {
		__setCache("resourceclass2", newValue);
	}
	/**
	 * getActualcode
	 * @generated
	 */
	public int getActualcode()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("actualcode")).intValue());
	}
	/**
	 * setActualcode
	 * @generated
	 */
	public void setActualcode(int newValue) {
		__setCache("actualcode", new Integer(newValue));
	}
	/**
	 * getName
	 * @generated
	 */
	public java.lang.String getName()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("name")));
	}
	/**
	 * setName
	 * @generated
	 */
	public void setName(java.lang.String newValue) {
		__setCache("name", newValue);
	}
	/**
	 * getGroupid
	 * @generated
	 */
	public java.lang.Integer getGroupid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("groupid")));
	}
	/**
	 * setGroupid
	 * @generated
	 */
	public void setGroupid(java.lang.Integer newValue) {
		__setCache("groupid", newValue);
	}
	/**
	 * getPriceable
	 * @generated
	 */
	public java.lang.Boolean getPriceable()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("priceable")));
	}
	/**
	 * setPriceable
	 * @generated
	 */
	public void setPriceable(java.lang.Boolean newValue) {
		__setCache("priceable", newValue);
	}
	/**
	 * getComplectpart
	 * @generated
	 */
	public java.lang.Boolean getComplectpart()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("complectpart")));
	}
	/**
	 * setComplectpart
	 * @generated
	 */
	public void setComplectpart(java.lang.Boolean newValue) {
		__setCache("complectpart", newValue);
	}
	/**
	 * getResource
	 * @generated
	 */
	public int getResource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("resource")).intValue());
	}
	/**
	 * setResource
	 * @generated
	 */
	public void setResource(int newValue) {
		__setCache("resource", new Integer(newValue));
	}
	/**
	 * getManucode
	 * @generated
	 */
	public java.lang.String getManucode()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("manucode")));
	}
	/**
	 * setManucode
	 * @generated
	 */
	public void setManucode(java.lang.String newValue) {
		__setCache("manucode", newValue);
	}
	/**
	 * getComplect
	 * @generated
	 */
	public java.lang.Boolean getComplect()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("complect")));
	}
	/**
	 * setComplect
	 * @generated
	 */
	public void setComplect(java.lang.Boolean newValue) {
		__setCache("complect", newValue);
	}
	/**
	 * getDisablenfscodes
	 * @generated
	 */
	public java.lang.Boolean getDisablenfscodes()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("disablenfscodes")));
	}
	/**
	 * setDisablenfscodes
	 * @generated
	 */
	public void setDisablenfscodes(java.lang.Boolean newValue) {
		__setCache("disablenfscodes", newValue);
	}
	/**
	 * getSubtype_resourcesubtype
	 * @generated
	 */
	public java.lang.Integer getSubtype_resourcesubtype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("subtype_resourcesubtype")));
	}
	/**
	 * setSubtype_resourcesubtype
	 * @generated
	 */
	public void setSubtype_resourcesubtype(java.lang.Integer newValue) {
		__setCache("subtype_resourcesubtype", newValue);
	}
	/**
	 * getNotes
	 * @generated
	 */
	public java.lang.String getNotes()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("notes")));
	}
	/**
	 * setNotes
	 * @generated
	 */
	public void setNotes(java.lang.String newValue) {
		__setCache("notes", newValue);
	}
	/**
	 * getActive
	 * @generated
	 */
	public java.lang.Boolean getActive()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("active")));
	}
	/**
	 * setActive
	 * @generated
	 */
	public void setActive(java.lang.Boolean newValue) {
		__setCache("active", newValue);
	}
	/**
	 * getBoxable
	 * @generated
	 */
	public java.lang.Boolean getBoxable()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("boxable")));
	}
	/**
	 * setBoxable
	 * @generated
	 */
	public void setBoxable(java.lang.Boolean newValue) {
		__setCache("boxable", newValue);
	}
	/**
	 * setInitKey_resource
	 * @generated
	 */
	public void setInitKey_resource(int newValue) {
		this.initKey_resource = (newValue);
	}
	/**
	 * ResourceAccessBean
	 * @generated
	 */
	public ResourceAccessBean() {
		super();
	}
	/**
	 * ResourceAccessBean
	 * @generated
	 */
	public ResourceAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence/Resource";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.ResourceHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com.hps.july.persistence.ResourceHome) PortableRemoteObject.narrow(
			getHome(),
			com.hps.july.persistence.ResourceHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.Resource ejbRef()
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
						.Resource) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.Resource.class);

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

		com.hps.july.persistence.ResourceKey key =
			keyFromFields(initKey_resource);
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
			com.hps.july.persistence.ResourceKey pKey =
				(com.hps.july.persistence.ResourceKey) this.__getKey();
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
	private com.hps.july.persistence.ResourceKey keyFromFields(int f0) {
		com.hps.july.persistence.ResourceKey keyClass =
			new com.hps.july.persistence.ResourceKey();
		keyClass.resource = f0;
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
	 * findResourcesByLeasePayRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeasePayRules(
		java.util.Vector listContracts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesByLeasePayRules(listContracts);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * ResourceAccessBean
	 * @generated
	 */
	public ResourceAccessBean(
		int argResource,
		java.lang.String argName,
		java.lang.String argModel,
		java.lang.String argNotes,
		java.lang.Boolean argComplect,
		java.lang.String argCountpolicy,
		java.lang.Boolean argBoxable,
		java.lang.Boolean argPriceable,
		java.lang.Boolean argComplectpart,
		java.lang.Boolean argActive,
		int argSubType,
		int argResourceClass2)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argResource,
				argName,
				argModel,
				argNotes,
				argComplect,
				argCountpolicy,
				argBoxable,
				argPriceable,
				argComplectpart,
				argActive,
				argSubType,
				argResourceClass2);
	}
	/**
	 * findResourcesByQBE2
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE2(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesByQBE2(
				isSubtypekey,
				subtypeKey,
				isModel,
				model,
				isName,
				name,
				isManufacturer,
				manufacturer,
				isManucode,
				manucode,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourcesByQBE
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesByQBE(
				isSubtypekey,
				subtypeKey,
				isModel,
				model,
				isName,
				name,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourceBySubtype
	 * @generated
	 */
	public java.util.Enumeration findResourceBySubtype(
		com.hps.july.persistence.ResourceSubTypeKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs = localHome.findResourceBySubtype(inKey);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourcesByQBE3
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE3(
		java.lang.Boolean isSubtypekey,
		com.hps.july.persistence.ResourceSubTypeKey subtypeKey,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.Integer connected,
		java.lang.Integer owner,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesByQBE3(
				isSubtypekey,
				subtypeKey,
				isModel,
				model,
				isName,
				name,
				isManufacturer,
				manufacturer,
				isManucode,
				manucode,
				connected,
				owner,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourcesForBrowse
	 * @generated
	 */
	public java.util.Enumeration findResourcesForBrowse(
		java.lang.Boolean isResourcetype,
		java.lang.Integer resourcetype,
		java.lang.Boolean isResourcesubtype,
		java.lang.Integer resourcesubtype,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isName,
		java.lang.String name,
		java.lang.Boolean isManufacturer,
		java.lang.Integer manufacturer,
		java.lang.Boolean isManucode,
		java.lang.String manucode,
		java.lang.String active,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesForBrowse(
				isResourcetype,
				resourcetype,
				isResourcesubtype,
				resourcesubtype,
				isModel,
				model,
				isName,
				name,
				isManufacturer,
				manufacturer,
				isManucode,
				manucode,
				active,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findActiveResourceBySubtype
	 * @generated
	 */
	public java.util.Enumeration findActiveResourceBySubtype(
		java.lang.Integer argSubtype,
		java.lang.String argActive)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findActiveResourceBySubtype(argSubtype, argActive);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourcesByUnit
	 * @generated
	 */
	public java.util.Enumeration findResourcesByUnit(
		com.hps.july.persistence.UnitKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs = localHome.findResourcesByUnit(inKey);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourcesByLeaseChargeRules
	 * @generated
	 */
	public java.util.Enumeration findResourcesByLeaseChargeRules(
		java.util.Vector listContracts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesByLeaseChargeRules(listContracts);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourceByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findResourceByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.ResourceHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourceByReglamentOrderByCodeAsc(argReglament);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * ResourceAccessBean
	 * @generated
	 */
	public ResourceAccessBean(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(resource, argUnit, argSubtype);
	}
	/**
	 * ResourceAccessBean
	 * @generated
	 */
	public ResourceAccessBean(int argResource)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argResource);
	}
	/**
	 * secondaryRemoveOuterDocPosition
	 * @generated
	 */
	public void secondaryRemoveOuterDocPosition(
		com.hps.july.persistence.OuterDocPosition anOuterDocPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveOuterDocPosition(anOuterDocPosition);
	}
	/**
	 * getComEquipments
	 * @generated
	 */
	public java.util.Enumeration getComEquipments()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getComEquipments();
	}
	/**
	 * addOuterDocPosition
	 * @generated
	 */
	public void addOuterDocPosition(
		com.hps.july.persistence.OuterDocPosition anOuterDocPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addOuterDocPosition(anOuterDocPosition);
	}
	/**
	 * secondaryRemoveLeaseChargeRule
	 * @generated
	 */
	public void secondaryRemoveLeaseChargeRule(
		com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseChargeRule(aLeaseChargeRule);
	}
	/**
	 * secondaryAddLeasePayRule
	 * @generated
	 */
	public void secondaryAddLeasePayRule(
		com.hps.july.persistence.LeasePayRule aLeasePayRule)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeasePayRule(aLeasePayRule);
	}
	/**
	 * addChangeActPositions
	 * @generated
	 */
	public void addChangeActPositions(
		com.hps.july.persistence.ChangeActPosition aChangeActPositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addChangeActPositions(aChangeActPositions);
	}
	/**
	 * getLeaseMutualContracts
	 * @generated
	 */
	public java.util.Enumeration getLeaseMutualContracts()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseMutualContracts();
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
	 * secondaryAddI13nActResourceSet
	 * @generated
	 */
	public void secondaryAddI13nActResourceSet(
		com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddI13nActResourceSet(anI13nActResourceSet);
	}
	/**
	 * getLeasePosSchetFakt
	 * @generated
	 */
	public java.util.Enumeration getLeasePosSchetFakt()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeasePosSchetFakt();
	}
	/**
	 * secondaryAddResourceSets
	 * @generated
	 */
	public void secondaryAddResourceSets(
		com.hps.july.persistence.ResourceSet aResourceSets)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddResourceSets(aResourceSets);
	}
	/**
	 * getResourceSets
	 * @generated
	 */
	public java.util.Enumeration getResourceSets()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getResourceSets();
	}
	/**
	 * removeGrresAntennes
	 * @generated
	 */
	public void removeGrresAntennes(
		com.hps.july.persistence.Antenna aGrresAntennes)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeGrresAntennes(aGrresAntennes);
	}
	/**
	 * addLeaseChargeRule
	 * @generated
	 */
	public void addLeaseChargeRule(
		com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseChargeRule(aLeaseChargeRule);
	}
	/**
	 * getComplectparts
	 * @generated
	 */
	public java.util.Enumeration getComplectparts()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getComplectparts();
	}
	/**
	 * removeControllers
	 * @generated
	 */
	public void removeControllers(
		com.hps.july.persistence.Controller aControllers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeControllers(aControllers);
	}
	/**
	 * secondaryAddGrresAntennes
	 * @generated
	 */
	public void secondaryAddGrresAntennes(
		com.hps.july.persistence.Antenna aGrresAntennes)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddGrresAntennes(aGrresAntennes);
	}
	/**
	 * secondaryAddComplectparts
	 * @generated
	 */
	public void secondaryAddComplectparts(
		com.hps.july.persistence.Complect aComplectparts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddComplectparts(aComplectparts);
	}
	/**
	 * secondaryRemoveChangeActPositions
	 * @generated
	 */
	public void secondaryRemoveChangeActPositions(
		com.hps.july.persistence.ChangeActPosition aChangeActPositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveChangeActPositions(aChangeActPositions);
	}
	/**
	 * secondaryAddResourceTaxes
	 * @generated
	 */
	public void secondaryAddResourceTaxes(
		com.hps.july.persistence.ResourceTaxe aResourceTaxes)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddResourceTaxes(aResourceTaxes);
	}
	/**
	 * secondaryRemoveResourceSetParts
	 * @generated
	 */
	public void secondaryRemoveResourceSetParts(
		com.hps.july.persistence.ResourceSetPart aResourceSetParts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveResourceSetParts(aResourceSetParts);
	}
	/**
	 * getSubtype
	 * @generated
	 */
	public com.hps.july.persistence.ResourceSubTypeAccessBean getSubtype()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.ResourceSubType localEJBRef =
			ejbRef().getSubtype();
		if (localEJBRef != null)
			return new com.hps.july.persistence.ResourceSubTypeAccessBean(
				localEJBRef);
		else
			return null;
	}
	/**
	 * addLeaseDocPositions
	 * @generated
	 */
	public void addLeaseDocPositions(
		com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseDocPositions(aLeaseDocPositions);
	}
	/**
	 * addControllers
	 * @generated
	 */
	public void addControllers(
		com.hps.july.persistence.Controller aControllers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addControllers(aControllers);
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
	 * addGrresAntennes
	 * @generated
	 */
	public void addGrresAntennes(
		com.hps.july.persistence.Antenna aGrresAntennes)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addGrresAntennes(aGrresAntennes);
	}
	/**
	 * getGrresAntennes
	 * @generated
	 */
	public java.util.Enumeration getGrresAntennes()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getGrresAntennes();
	}
	/**
	 * addLeasePayRule
	 * @generated
	 */
	public void addLeasePayRule(
		com.hps.july.persistence.LeasePayRule aLeasePayRule)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeasePayRule(aLeasePayRule);
	}
	/**
	 * secondaryRemoveResourceSets
	 * @generated
	 */
	public void secondaryRemoveResourceSets(
		com.hps.july.persistence.ResourceSet aResourceSets)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveResourceSets(aResourceSets);
	}
	/**
	 * removeSwitches
	 * @generated
	 */
	public void removeSwitches(com.hps.july.persistence.Switch aSwitches)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeSwitches(aSwitches);
	}
	/**
	 * setUnit
	 * @generated
	 */
	public void setUnit(com.hps.july.persistence.Unit anUnit)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setUnit(anUnit);
	}
	/**
	 * secondaryAddLeaseChargeRule
	 * @generated
	 */
	public void secondaryAddLeaseChargeRule(
		com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseChargeRule(aLeaseChargeRule);
	}
	/**
	 * privateSetUnitKey
	 * @generated
	 */
	public void privateSetUnitKey(com.hps.july.persistence.UnitKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetUnitKey(inKey);
	}
	/**
	 * secondaryRemoveLeaseMutualRuleNews
	 * @generated
	 */
	public void secondaryRemoveLeaseMutualRuleNews(
		com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseMutualRuleNews(aLeaseMutualRuleNews);
	}
	/**
	 * secondaryAddLeaseResBils
	 * @generated
	 */
	public void secondaryAddLeaseResBils(
		com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseResBils(aLeaseResBils);
	}
	/**
	 * secondaryAddComEquipments
	 * @generated
	 */
	public void secondaryAddComEquipments(
		com.hps.july.persistence.ComEquipment aComEquipments)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddComEquipments(aComEquipments);
	}
	/**
	 * secondaryAddLeaseMutualContracts
	 * @generated
	 */
	public void secondaryAddLeaseMutualContracts(
		com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseMutualContracts(aLeaseMutualContracts);
	}
	/**
	 * getControllers
	 * @generated
	 */
	public java.util.Enumeration getControllers()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getControllers();
	}
	/**
	 * removeLeaseResBils
	 * @generated
	 */
	public void removeLeaseResBils(
		com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeLeaseResBils(aLeaseResBils);
	}
	/**
	 * setSubtype
	 * @generated
	 */
	public void setSubtype(com.hps.july.persistence.ResourceSubType aSubtype)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setSubtype(aSubtype);
	}
	/**
	 * addResourceSets
	 * @generated
	 */
	public void addResourceSets(
		com.hps.july.persistence.ResourceSet aResourceSets)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addResourceSets(aResourceSets);
	}
	/**
	 * getComplects
	 * @generated
	 */
	public java.util.Enumeration getComplects()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getComplects();
	}
	/**
	 * secondaryAddLeaseSaldo
	 * @generated
	 */
	public void secondaryAddLeaseSaldo(
		com.hps.july.persistence.LeaseSaldo aLeaseSaldo)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseSaldo(aLeaseSaldo);
	}
	/**
	 * secondaryAddChangeActPositions
	 * @generated
	 */
	public void secondaryAddChangeActPositions(
		com.hps.july.persistence.ChangeActPosition aChangeActPositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddChangeActPositions(aChangeActPositions);
	}
	/**
	 * secondaryRemoveSwitches
	 * @generated
	 */
	public void secondaryRemoveSwitches(
		com.hps.july.persistence.Switch aSwitches)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveSwitches(aSwitches);
	}
	/**
	 * getLeaseDocPositions
	 * @generated
	 */
	public java.util.Enumeration getLeaseDocPositions()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseDocPositions();
	}
	/**
	 * secondaryRemoveAfsMountPoses
	 * @generated
	 */
	public void secondaryRemoveAfsMountPoses(
		com.hps.july.persistence.AfsMountPos anAfsMountPoses)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveAfsMountPoses(anAfsMountPoses);
	}
	/**
	 * secondaryRemoveResourceTaxes
	 * @generated
	 */
	public void secondaryRemoveResourceTaxes(
		com.hps.july.persistence.ResourceTaxe aResourceTaxes)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveResourceTaxes(aResourceTaxes);
	}
	/**
	 * secondaryRemoveLeasePosSchetFakt
	 * @generated
	 */
	public void secondaryRemoveLeasePosSchetFakt(
		com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeasePosSchetFakt(aLeasePosSchetFakt);
	}
	/**
	 * secondarySetSubtype
	 * @generated
	 */
	public void secondarySetSubtype(
		com.hps.july.persistence.ResourceSubType aSubtype)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetSubtype(aSubtype);
	}
	/**
	 * getLeaseSaldo
	 * @generated
	 */
	public java.util.Enumeration getLeaseSaldo()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseSaldo();
	}
	/**
	 * secondaryAddControllers
	 * @generated
	 */
	public void secondaryAddControllers(
		com.hps.july.persistence.Controller aControllers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddControllers(aControllers);
	}
	/**
	 * getLeaseChargeRule
	 * @generated
	 */
	public java.util.Enumeration getLeaseChargeRule()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseChargeRule();
	}
	/**
	 * getLeasePayRule
	 * @generated
	 */
	public java.util.Enumeration getLeasePayRule()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeasePayRule();
	}
	/**
	 * secondaryRemoveLeaseResBils
	 * @generated
	 */
	public void secondaryRemoveLeaseResBils(
		com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseResBils(aLeaseResBils);
	}
	/**
	 * getResourceSetParts
	 * @generated
	 */
	public java.util.Enumeration getResourceSetParts()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getResourceSetParts();
	}
	/**
	 * getLeaseMutualRuleNews
	 * @generated
	 */
	public java.util.Enumeration getLeaseMutualRuleNews()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseMutualRuleNews();
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
	 * getChangeActPositions
	 * @generated
	 */
	public java.util.Enumeration getChangeActPositions()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getChangeActPositions();
	}
	/**
	 * getUnit
	 * @generated
	 */
	public com.hps.july.persistence.UnitAccessBean getUnit()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Unit localEJBRef = ejbRef().getUnit();
		if (localEJBRef != null)
			return new com.hps.july.persistence.UnitAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * getResourceTaxes
	 * @generated
	 */
	public java.util.Enumeration getResourceTaxes()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getResourceTaxes();
	}
	/**
	 * secondaryAddAfsMountPoses
	 * @generated
	 */
	public void secondaryAddAfsMountPoses(
		com.hps.july.persistence.AfsMountPos anAfsMountPoses)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddAfsMountPoses(anAfsMountPoses);
	}
	/**
	 * secondaryAddLeaseMutualRuleNews
	 * @generated
	 */
	public void secondaryAddLeaseMutualRuleNews(
		com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseMutualRuleNews(aLeaseMutualRuleNews);
	}
	/**
	 * secondaryRemoveComplectparts
	 * @generated
	 */
	public void secondaryRemoveComplectparts(
		com.hps.july.persistence.Complect aComplectparts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveComplectparts(aComplectparts);
	}
	/**
	 * secondaryRemoveAbonentBillPoses
	 * @generated
	 */
	public void secondaryRemoveAbonentBillPoses(
		com.hps.july.persistence.AbonentBillPos anAbonentBillPoses)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveAbonentBillPoses(anAbonentBillPoses);
	}
	/**
	 * addLeasePosSchetFakt
	 * @generated
	 */
	public void addLeasePosSchetFakt(
		com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeasePosSchetFakt(aLeasePosSchetFakt);
	}
	/**
	 * secondaryAddSwitches
	 * @generated
	 */
	public void secondaryAddSwitches(com.hps.july.persistence.Switch aSwitches)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddSwitches(aSwitches);
	}
	/**
	 * removeComEquipments
	 * @generated
	 */
	public void removeComEquipments(
		com.hps.july.persistence.ComEquipment aComEquipments)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeComEquipments(aComEquipments);
	}
	/**
	 * getSwitches
	 * @generated
	 */
	public java.util.Enumeration getSwitches()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getSwitches();
	}
	/**
	 * getLeaseResBils
	 * @generated
	 */
	public java.util.Enumeration getLeaseResBils()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseResBils();
	}
	/**
	 * addAbonentBillPoses
	 * @generated
	 */
	public void addAbonentBillPoses(
		com.hps.july.persistence.AbonentBillPos anAbonentBillPoses)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addAbonentBillPoses(anAbonentBillPoses);
	}
	/**
	 * secondaryRemoveComplects
	 * @generated
	 */
	public void secondaryRemoveComplects(
		com.hps.july.persistence.Complect aComplects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveComplects(aComplects);
	}
	/**
	 * addAfsMountPoses
	 * @generated
	 */
	public void addAfsMountPoses(
		com.hps.july.persistence.AfsMountPos anAfsMountPoses)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addAfsMountPoses(anAfsMountPoses);
	}
	/**
	 * secondaryRemoveComEquipments
	 * @generated
	 */
	public void secondaryRemoveComEquipments(
		com.hps.july.persistence.ComEquipment aComEquipments)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveComEquipments(aComEquipments);
	}
	/**
	 * secondaryAddComplects
	 * @generated
	 */
	public void secondaryAddComplects(
		com.hps.july.persistence.Complect aComplects)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddComplects(aComplects);
	}
	/**
	 * addLeaseResBils
	 * @generated
	 */
	public void addLeaseResBils(
		com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseResBils(aLeaseResBils);
	}
	/**
	 * getAbonentBillPoses
	 * @generated
	 */
	public java.util.Enumeration getAbonentBillPoses()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getAbonentBillPoses();
	}
	/**
	 * getI13nActResourceSet
	 * @generated
	 */
	public java.util.Enumeration getI13nActResourceSet()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getI13nActResourceSet();
	}
	/**
	 * getOuterDocPosition
	 * @generated
	 */
	public java.util.Enumeration getOuterDocPosition()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getOuterDocPosition();
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
	 * secondaryAddOuterDocPosition
	 * @generated
	 */
	public void secondaryAddOuterDocPosition(
		com.hps.july.persistence.OuterDocPosition anOuterDocPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddOuterDocPosition(anOuterDocPosition);
	}
	/**
	 * secondaryAddLeaseDocPositions
	 * @generated
	 */
	public void secondaryAddLeaseDocPositions(
		com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseDocPositions(aLeaseDocPositions);
	}
	/**
	 * secondaryRemoveGrresAntennes
	 * @generated
	 */
	public void secondaryRemoveGrresAntennes(
		com.hps.july.persistence.Antenna aGrresAntennes)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveGrresAntennes(aGrresAntennes);
	}
	/**
	 * secondaryRemoveLeasePayRule
	 * @generated
	 */
	public void secondaryRemoveLeasePayRule(
		com.hps.july.persistence.LeasePayRule aLeasePayRule)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeasePayRule(aLeasePayRule);
	}
	/**
	 * privateSetSubtypeKey
	 * @generated
	 */
	public void privateSetSubtypeKey(
		com.hps.july.persistence.ResourceSubTypeKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetSubtypeKey(inKey);
	}
	/**
	 * secondaryAddResourceSetParts
	 * @generated
	 */
	public void secondaryAddResourceSetParts(
		com.hps.july.persistence.ResourceSetPart aResourceSetParts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddResourceSetParts(aResourceSetParts);
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
	 * getAfsMountPoses
	 * @generated
	 */
	public java.util.Enumeration getAfsMountPoses()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getAfsMountPoses();
	}
	/**
	 * addSwitches
	 * @generated
	 */
	public void addSwitches(com.hps.july.persistence.Switch aSwitches)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addSwitches(aSwitches);
	}
	/**
	 * removeAfsMountPoses
	 * @generated
	 */
	public void removeAfsMountPoses(
		com.hps.july.persistence.AfsMountPos anAfsMountPoses)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeAfsMountPoses(anAfsMountPoses);
	}
	/**
	 * secondarySetUnit
	 * @generated
	 */
	public void secondarySetUnit(com.hps.july.persistence.Unit anUnit)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetUnit(anUnit);
	}
	/**
	 * addComEquipments
	 * @generated
	 */
	public void addComEquipments(
		com.hps.july.persistence.ComEquipment aComEquipments)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addComEquipments(aComEquipments);
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
	 * secondaryRemoveControllers
	 * @generated
	 */
	public void secondaryRemoveControllers(
		com.hps.july.persistence.Controller aControllers)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveControllers(aControllers);
	}
	/**
	 * secondaryRemoveLeaseSaldo
	 * @generated
	 */
	public void secondaryRemoveLeaseSaldo(
		com.hps.july.persistence.LeaseSaldo aLeaseSaldo)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseSaldo(aLeaseSaldo);
	}
	/**
	 * secondaryRemoveLeaseMutualContracts
	 * @generated
	 */
	public void secondaryRemoveLeaseMutualContracts(
		com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseMutualContracts(aLeaseMutualContracts);
	}
	/**
	 * secondaryRemoveI13nActResourceSet
	 * @generated
	 */
	public void secondaryRemoveI13nActResourceSet(
		com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveI13nActResourceSet(anI13nActResourceSet);
	}
	/**
	 * secondaryAddAbonentBillPoses
	 * @generated
	 */
	public void secondaryAddAbonentBillPoses(
		com.hps.july.persistence.AbonentBillPos anAbonentBillPoses)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddAbonentBillPoses(anAbonentBillPoses);
	}
	/**
	 * secondaryRemoveLeaseDocPositions
	 * @generated
	 */
	public void secondaryRemoveLeaseDocPositions(
		com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseDocPositions(aLeaseDocPositions);
	}
	/**
	 * secondaryAddLeasePosSchetFakt
	 * @generated
	 */
	public void secondaryAddLeasePosSchetFakt(
		com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeasePosSchetFakt(aLeasePosSchetFakt);
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
}
