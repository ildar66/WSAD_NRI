package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * RepiterResAccessBean
 * @generated
 */
public class RepiterResAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.RepiterResAccessBeanData {
	/**
	 * @generated
	 */
	private RepiterRes __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_resource;
	/**
	 * getVoltageid
	 * @generated
	 */
	public java.lang.Integer getVoltageid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("voltageid")));
	}
	/**
	 * setVoltageid
	 * @generated
	 */
	public void setVoltageid(java.lang.Integer newValue) {
		__setCache("voltageid", newValue);
	}
	/**
	 * getDimensions
	 * @generated
	 */
	public java.lang.String getDimensions()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("dimensions")));
	}
	/**
	 * setDimensions
	 * @generated
	 */
	public void setDimensions(java.lang.String newValue) {
		__setCache("dimensions", newValue);
	}
	/**
	 * getRepitertype
	 * @generated
	 */
	public java.lang.Integer getRepitertype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("repitertype")));
	}
	/**
	 * setRepitertype
	 * @generated
	 */
	public void setRepitertype(java.lang.Integer newValue) {
		__setCache("repitertype", newValue);
	}
	/**
	 * getWeight
	 * @generated
	 */
	public java.math.BigDecimal getWeight()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("weight")));
	}
	/**
	 * setWeight
	 * @generated
	 */
	public void setWeight(java.math.BigDecimal newValue) {
		__setCache("weight", newValue);
	}
	/**
	 * getNoisefactor
	 * @generated
	 */
	public java.math.BigDecimal getNoisefactor()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("noisefactor")));
	}
	/**
	 * setNoisefactor
	 * @generated
	 */
	public void setNoisefactor(java.math.BigDecimal newValue) {
		__setCache("noisefactor", newValue);
	}
	/**
	 * getDownlinkbandup
	 * @generated
	 */
	public java.lang.Integer getDownlinkbandup()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("downlinkbandup")));
	}
	/**
	 * setDownlinkbandup
	 * @generated
	 */
	public void setDownlinkbandup(java.lang.Integer newValue) {
		__setCache("downlinkbandup", newValue);
	}
	/**
	 * getAntentriescount
	 * @generated
	 */
	public java.lang.Integer getAntentriescount()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("antentriescount")));
	}
	/**
	 * setAntentriescount
	 * @generated
	 */
	public void setAntentriescount(java.lang.Integer newValue) {
		__setCache("antentriescount", newValue);
	}
	/**
	 * getReppower
	 * @generated
	 */
	public java.math.BigDecimal getReppower()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("reppower")));
	}
	/**
	 * setReppower
	 * @generated
	 */
	public void setReppower(java.math.BigDecimal newValue) {
		__setCache("reppower", newValue);
	}
	/**
	 * getRemotecontrol
	 * @generated
	 */
	public java.lang.Boolean getRemotecontrol()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("remotecontrol")));
	}
	/**
	 * setRemotecontrol
	 * @generated
	 */
	public void setRemotecontrol(java.lang.Boolean newValue) {
		__setCache("remotecontrol", newValue);
	}
	/**
	 * getGainfactor
	 * @generated
	 */
	public java.lang.Integer getGainfactor()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("gainfactor")));
	}
	/**
	 * setGainfactor
	 * @generated
	 */
	public void setGainfactor(java.lang.Integer newValue) {
		__setCache("gainfactor", newValue);
	}
	/**
	 * getLinkband
	 * @generated
	 */
	public java.lang.Integer getLinkband()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("linkband")));
	}
	/**
	 * setLinkband
	 * @generated
	 */
	public void setLinkband(java.lang.Integer newValue) {
		__setCache("linkband", newValue);
	}
	/**
	 * getNumchanals
	 * @generated
	 */
	public java.lang.Integer getNumchanals()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("numchanals")));
	}
	/**
	 * setNumchanals
	 * @generated
	 */
	public void setNumchanals(java.lang.Integer newValue) {
		__setCache("numchanals", newValue);
	}
	/**
	 * getEndbandwidth
	 * @generated
	 */
	public java.math.BigDecimal getEndbandwidth()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("endbandwidth")));
	}
	/**
	 * setEndbandwidth
	 * @generated
	 */
	public void setEndbandwidth(java.math.BigDecimal newValue) {
		__setCache("endbandwidth", newValue);
	}
	/**
	 * getDownlinkband
	 * @generated
	 */
	public java.lang.Integer getDownlinkband()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("downlinkband")));
	}
	/**
	 * setDownlinkband
	 * @generated
	 */
	public void setDownlinkband(java.lang.Integer newValue) {
		__setCache("downlinkband", newValue);
	}
	/**
	 * getBandwidth
	 * @generated
	 */
	public java.math.BigDecimal getBandwidth()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("bandwidth")));
	}
	/**
	 * setBandwidth
	 * @generated
	 */
	public void setBandwidth(java.math.BigDecimal newValue) {
		__setCache("bandwidth", newValue);
	}
	/**
	 * getWorkband
	 * @generated
	 */
	public java.lang.Integer getWorkband()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("workband")));
	}
	/**
	 * setWorkband
	 * @generated
	 */
	public void setWorkband(java.lang.Integer newValue) {
		__setCache("workband", newValue);
	}
	/**
	 * getUsedpower
	 * @generated
	 */
	public java.math.BigDecimal getUsedpower()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("usedpower")));
	}
	/**
	 * setUsedpower
	 * @generated
	 */
	public void setUsedpower(java.math.BigDecimal newValue) {
		__setCache("usedpower", newValue);
	}
	/**
	 * getSignaldelay
	 * @generated
	 */
	public java.math.BigDecimal getSignaldelay()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("signaldelay")));
	}
	/**
	 * setSignaldelay
	 * @generated
	 */
	public void setSignaldelay(java.math.BigDecimal newValue) {
		__setCache("signaldelay", newValue);
	}
	/**
	 * getIslinear
	 * @generated
	 */
	public java.lang.Boolean getIslinear()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("islinear")));
	}
	/**
	 * setIslinear
	 * @generated
	 */
	public void setIslinear(java.lang.Boolean newValue) {
		__setCache("islinear", newValue);
	}
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
	 * RepiterResAccessBean
	 * @generated
	 */
	public RepiterResAccessBean() {
		super();
	}
	/**
	 * RepiterResAccessBean
	 * @generated
	 */
	public RepiterResAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence/RepiterRes";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.RepiterResHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence
				.RepiterResHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence.RepiterResHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.RepiterRes ejbRef()
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
						.RepiterRes) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.RepiterRes.class);

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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesByLeasePayRules(listContracts);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * RepiterResAccessBean
	 * @generated
	 */
	public RepiterResAccessBean(
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
		java.lang.Boolean argIslinear)
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
				argIslinear);
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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
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
	 * findResourcesByQBE4
	 * @generated
	 */
	public java.util.Enumeration findResourcesByQBE4(
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
		java.lang.Boolean IsIslinear,
		java.lang.Boolean islinear,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourcesByQBE4(
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
				IsIslinear,
				islinear,
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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findActiveResourceBySubtype(argSubtype, argActive);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findResourceByBrowse1
	 * @generated
	 */
	public java.util.Enumeration findResourceByBrowse1(
		java.lang.Boolean isType,
		java.lang.Integer type,
		java.lang.Boolean isSubtype,
		java.lang.Integer subtype,
		java.lang.Boolean isModel,
		java.lang.String model,
		java.lang.Boolean isManu,
		java.lang.String manu,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourceByBrowse1(
				isType,
				type,
				isSubtype,
				subtype,
				isModel,
				model,
				isManu,
				manu,
				order);
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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
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
		com.hps.july.persistence.RepiterResHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findResourceByReglamentOrderByCodeAsc(argReglament);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * RepiterResAccessBean
	 * @generated
	 */
	public RepiterResAccessBean(
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
	 * RepiterResAccessBean
	 * @generated
	 */
	public RepiterResAccessBean(int argResource)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argResource);
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
	 * addRepiters
	 * @generated
	 */
	public void addRepiters(com.hps.july.persistence.Repiter aRepiters)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addRepiters(aRepiters);
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
	 * removeRepiters
	 * @generated
	 */
	public void removeRepiters(com.hps.july.persistence.Repiter aRepiters)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeRepiters(aRepiters);
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
	 * secondaryRemoveRepiters
	 * @generated
	 */
	public void secondaryRemoveRepiters(
		com.hps.july.persistence.Repiter aRepiters)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveRepiters(aRepiters);
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
	 * secondaryAddRepiters
	 * @generated
	 */
	public void secondaryAddRepiters(
		com.hps.july.persistence.Repiter aRepiters)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddRepiters(aRepiters);
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
	 * getRepiters
	 * @generated
	 */
	public java.util.Enumeration getRepiters()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getRepiters();
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
}
