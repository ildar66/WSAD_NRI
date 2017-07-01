package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Обобщенный ресурс
 */
public class ResourceBean implements EntityBean {
	public Boolean active;
	public int actualcode;
	public Boolean boxable;
	public Boolean complect;
	public Boolean complectpart;
	private javax.ejb.EntityContext entityContext = null;
	public String model;
	public String name;
	public String notes;
	public Boolean priceable;
	public int resource;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer unit_unit;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink unitLink = null;
	public java.lang.Integer subtype_resourcesubtype;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink subtypeLink = null;
	public String countpolicy;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink resourceTaxesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink resourceSetsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink resourceSetPartsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink complectsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink complectpartsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink documentPositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink storageCardLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink outerDocPositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink i13nActResourceSetLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leasePayRuleLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseChargeRuleLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseMutualRuleLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseSaldoLink = null;
	public String manucode;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink abonentBillPosesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseMutualContractsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseMutualRuleNewsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseDocPositionsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink changeActPositionsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leasePosSchetFaktLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink afsMountPosesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink grresAntennesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseResBilsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink switchesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink controllersLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink comEquipmentsLink = null;
	/**
	 * Implementation field for persistent attribute: resourceclass2
	 */
	public java.lang.Integer resourceclass2;
	/**
	 * Implementation field for persistent attribute: groupid
	 */
	public java.lang.Integer groupid;
	/**
	 * Implementation field for persistent attribute: manufid
	 */
	public java.lang.Integer manufid;
	/**
	 * Implementation field for persistent attribute: disablenfscodes
	 */
	public java.lang.Boolean disablenfscodes;
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = new java.util.Vector();
		links.add(getLeasePosSchetFaktLink());
		links.add(getLeaseResBilsLink());
		links.add(getResourceSetPartsLink());
		links.add(getI13nActResourceSetLink());
		links.add(getComplectpartsLink());
		links.add(getResourceSetsLink());
		links.add(getAbonentBillPosesLink());
		links.add(getResourceTaxesLink());
		links.add(getLeaseSaldoLink());
		links.add(getLeasePayRuleLink());
		links.add(getStorageCardLink());
		links.add(getComplectsLink());
		links.add(getOuterDocPositionLink());
		links.add(getLeaseMutualRuleNewsLink());
		links.add(getChangeActPositionsLink());
		links.add(getUnitLink());
		links.add(getSubtypeLink());
		links.add(getSwitchesLink());
		links.add(getGrresAntennesLink());
		links.add(getAfsMountPosesLink());
		links.add(getLeaseChargeRuleLink());
		links.add(getComEquipmentsLink());
		links.add(getLeaseDocPositionsLink());
		links.add(getLeaseMutualContractsLink());
		links.add(getDocumentPositionLink());
		links.add(getControllersLink());
		return links;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _initLinks() {
		leasePosSchetFaktLink = null;
		leaseResBilsLink = null;
		resourceSetPartsLink = null;
		i13nActResourceSetLink = null;
		complectpartsLink = null;
		resourceSetsLink = null;
		abonentBillPosesLink = null;
		resourceTaxesLink = null;
		leaseSaldoLink = null;
		leasePayRuleLink = null;
		storageCardLink = null;
		complectsLink = null;
		outerDocPositionLink = null;
		leaseMutualRuleNewsLink = null;
		changeActPositionsLink = null;
		unitLink = null;
		subtypeLink = null;
		switchesLink = null;
		grresAntennesLink = null;
		afsMountPosesLink = null;
		leaseChargeRuleLink = null;
		comEquipmentsLink = null;
		leaseDocPositionsLink = null;
		leaseMutualContractsLink = null;
		documentPositionLink = null;
		controllersLink = null;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _removeLinks()
		throws java.rmi.RemoteException, javax.ejb.RemoveException {
		java.util.List links = _getLinks();
		for (int i = 0; i < links.size(); i++) {
			try {
				((com.ibm.ivj.ejb.associations.interfaces.Link) links.get(i))
					.remove();
			} catch (javax.ejb.FinderException e) {
			} //Consume Finder error since I am going away
		}
	}
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException {
	this.getAbonentBillPosesLink().addElement(anAbonentBillPoses);
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException {
	this.getAfsMountPosesLink().addElement(anAfsMountPoses);
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) throws java.rmi.RemoteException {
	this.getChangeActPositionsLink().addElement(aChangeActPositions);
}
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException {
	this.getComEquipmentsLink().addElement(aComEquipments);
}
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException {
	this.getControllersLink().addElement(aControllers);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
	this.getDocumentPositionLink().addElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException {
	this.getGrresAntennesLink().addElement(aGrresAntennes);
}
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException {
	this.getLeaseChargeRuleLink().addElement(aLeaseChargeRule);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
	this.getLeaseDocPositionsLink().addElement(aLeaseDocPositions);
}
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException {
	this.getLeasePayRuleLink().addElement(aLeasePayRule);
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) throws java.rmi.RemoteException {
	this.getLeasePosSchetFaktLink().addElement(aLeasePosSchetFakt);
}
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException {
	this.getLeaseResBilsLink().addElement(aLeaseResBils);
}
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException {
	this.getOuterDocPositionLink().addElement(anOuterDocPosition);
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) throws java.rmi.RemoteException {
	this.getResourceSetsLink().addElement(aResourceSets);
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
	this.getStorageCardLink().addElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException {
	this.getSwitchesLink().addElement(aSwitches);
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argResource int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	resource = argResource;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argResource int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argResource, String argName, String argModel, String argNotes, Boolean argComplect, 
	String argCountpolicy, Boolean argBoxable, Boolean argPriceable, Boolean argComplectpart, 
	Boolean argActive, int argSubType, int argResourceClass2 ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	active = null;
	actualcode = 0;
	boxable = null;
	complect = null;
	complectpart = null;
	model = null;
	name = null;
	notes = null;
	priceable = null;
	resource = 0;
	unit_unit = null;
	subtype_resourcesubtype = null;
	countpolicy = null;
	manucode = null;

	resource = argResource;
	name = argName;
	model = argModel;
	notes = argNotes;
	complect = argComplect;
	countpolicy = argCountpolicy;
	boxable = argBoxable;
	priceable = argPriceable;
	complectpart = argComplectpart;
	active = argActive;
	subtype_resourcesubtype = new Integer (argSubType);
	resourceclass2 = new Integer(argResourceClass2);
	groupid = null;
	manufid = null;
	disablenfscodes = Boolean.FALSE;
}

/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argResource int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argResource) throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {}
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAbonentBillPoses() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAbonentBillPosesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAbonentBillPosesLink() {
	if (abonentBillPosesLink == null)
		abonentBillPosesLink = new ResourceToAbonentBillPosesLink(this);
	return abonentBillPosesLink;
}
/**
 * Getter method for active
 * @return java.lang.Boolean
 */
public java.lang.Boolean getActive() {
	return active;
}
/**
 * Getter method for actualcode
 * @return int
 */
public int getActualcode() {
	return actualcode;
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAfsMountPoses() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAfsMountPosesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAfsMountPosesLink() {
	if (afsMountPosesLink == null)
		afsMountPosesLink = new ResourceToAfsMountPosesLink(this);
	return afsMountPosesLink;
}
/**
 * Getter method for boxable
 * @return java.lang.Boolean
 */
public java.lang.Boolean getBoxable() {
	return boxable;
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getChangeActPositions() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getChangeActPositionsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getChangeActPositionsLink() {
	if (changeActPositionsLink == null)
		changeActPositionsLink = new ResourceToChangeActPositionsLink(this);
	return changeActPositionsLink;
}
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getComEquipments() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getComEquipmentsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getComEquipmentsLink() {
	if (comEquipmentsLink == null)
		comEquipmentsLink = new ResourceToComEquipmentsLink(this);
	return comEquipmentsLink;
}
/**
 * Getter method for complect
 * @return java.lang.Boolean
 */
public java.lang.Boolean getComplect() {
	return complect;
}
/**
 * Getter method for complectpart
 * @return java.lang.Boolean
 */
public java.lang.Boolean getComplectpart() {
	return complectpart;
}
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getComplectparts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getComplectpartsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getComplectpartsLink() {
	if (complectpartsLink == null)
		complectpartsLink = new ResourceToComplectpartsLink(this);
	return complectpartsLink;
}
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getComplects() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getComplectsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getComplectsLink() {
	if (complectsLink == null)
		complectsLink = new ResourceToComplectsLink(this);
	return complectsLink;
}
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getControllers() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getControllersLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getControllersLink() {
	if (controllersLink == null)
		controllersLink = new ResourceToControllersLink(this);
	return controllersLink;
}
/**
 * Getter method for countpolicy
 */
public java.lang.String getCountpolicy() {
	return countpolicy;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getDocumentPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getDocumentPositionLink() {
	if (documentPositionLink == null)
		documentPositionLink = new ResourceToDocumentPositionLink(this);
	return documentPositionLink;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getGrresAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getGrresAntennesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getGrresAntennesLink() {
	if (grresAntennesLink == null)
		grresAntennesLink = new ResourceToGrresAntennesLink(this);
	return grresAntennesLink;
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nActResourceSet() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getI13nActResourceSetLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getI13nActResourceSetLink() {
	if (i13nActResourceSetLink == null)
		i13nActResourceSetLink = new ResourceToI13nActResourceSetLink(this);
	return i13nActResourceSetLink;
}
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseChargeRule() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseChargeRuleLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseChargeRuleLink() {
	if (leaseChargeRuleLink == null)
		leaseChargeRuleLink = new ResourceToLeaseChargeRuleLink(this);
	return leaseChargeRuleLink;
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseDocPositions() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseDocPositionsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseDocPositionsLink() {
	if (leaseDocPositionsLink == null)
		leaseDocPositionsLink = new ResourceToLeaseDocPositionsLink(this);
	return leaseDocPositionsLink;
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualContracts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseMutualContractsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseMutualContractsLink() {
	if (leaseMutualContractsLink == null)
		leaseMutualContractsLink = new ResourceToLeaseMutualContractsLink(this);
	return leaseMutualContractsLink;
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualRuleNews() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseMutualRuleNewsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseMutualRuleNewsLink() {
	if (leaseMutualRuleNewsLink == null)
		leaseMutualRuleNewsLink = new ResourceToLeaseMutualRuleNewsLink(this);
	return leaseMutualRuleNewsLink;
}
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeasePayRule() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeasePayRuleLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeasePayRuleLink() {
	if (leasePayRuleLink == null)
		leasePayRuleLink = new ResourceToLeasePayRuleLink(this);
	return leasePayRuleLink;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeasePosSchetFakt() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeasePosSchetFaktLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeasePosSchetFaktLink() {
	if (leasePosSchetFaktLink == null)
		leasePosSchetFaktLink = new ResourceToLeasePosSchetFaktLink(this);
	return leasePosSchetFaktLink;
}
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseResBils() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseResBilsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseResBilsLink() {
	if (leaseResBilsLink == null)
		leaseResBilsLink = new ResourceToLeaseResBilsLink(this);
	return leaseResBilsLink;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseSaldo() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseSaldoLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseSaldoLink() {
	if (leaseSaldoLink == null)
		leaseSaldoLink = new ResourceToLeaseSaldoLink(this);
	return leaseSaldoLink;
}
/**
 * Getter method for manucode
 */
public java.lang.String getManucode() {
	return manucode;
}
/**
 * Getter method for model
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * Getter method for name
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Getter method for notes
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOuterDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getOuterDocPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getOuterDocPositionLink() {
	if (outerDocPositionLink == null)
		outerDocPositionLink = new ResourceToOuterDocPositionLink(this);
	return outerDocPositionLink;
}
/**
 * Getter method for priceable
 * @return java.lang.Boolean
 */
public java.lang.Boolean getPriceable() {
	return priceable;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2002 19:31:18)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getResourceSetParts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getResourceSetPartsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getResourceSetPartsLink() {
	if (resourceSetPartsLink == null)
		resourceSetPartsLink = new ResourceToResourceSetPartsLink(this);
	return resourceSetPartsLink;
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getResourceSets() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getResourceSetsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getResourceSetsLink() {
	if (resourceSetsLink == null)
		resourceSetsLink = new ResourceToResourceSetsLink(this);
	return resourceSetsLink;
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getResourceTaxes() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getResourceTaxesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getResourceTaxesLink() {
	if (resourceTaxesLink == null)
		resourceTaxesLink = new ResourceToResourceTaxesLink(this);
	return resourceTaxesLink;
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getStorageCardLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getStorageCardLink() {
	if (storageCardLink == null)
		storageCardLink = new ResourceToStorageCardLink(this);
	return storageCardLink;
}
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceSubType getSubtype() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.ResourceSubType)this.getSubtypeLink().value();
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:16:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getSubtype_resourcesubtype() {
	return subtype_resourcesubtype;
}
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceSubTypeKey getSubtypeKey() {
	com.hps.july.persistence.ResourceSubTypeKey temp = null;
	temp = new com.hps.july.persistence.ResourceSubTypeKey();
	boolean subtype_NULLTEST = true;
	subtype_NULLTEST &= (subtype_resourcesubtype == null);
	temp.resourcesubtype = ((subtype_resourcesubtype == null) ? 0 : subtype_resourcesubtype.intValue());
	if (subtype_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getSubtypeLink() {
	if (subtypeLink == null)
		subtypeLink = new ResourceToSubtypeLink(this);
	return subtypeLink;
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSwitches() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getSwitchesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getSwitchesLink() {
	if (switchesLink == null)
		switchesLink = new ResourceToSwitchesLink(this);
	return switchesLink;
}
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Unit getUnit() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Unit)this.getUnitLink().value();
}
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.UnitKey getUnitKey() {
	com.hps.july.persistence.UnitKey temp = null;
	temp = new com.hps.july.persistence.UnitKey();
	boolean unit_NULLTEST = true;
	unit_NULLTEST &= (unit_unit == null);
	temp.unit = ((unit_unit == null) ? 0 : unit_unit.intValue());
	if (unit_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getUnitLink() {
	if (unitLink == null)
		unitLink = new ResourceToUnitLink(this);
	return unitLink;
}
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSubtypeKey(com.hps.july.persistence.ResourceSubTypeKey inKey) {
	boolean subtype_NULLTEST = (inKey == null);
	if (subtype_NULLTEST) subtype_resourcesubtype = null; else subtype_resourcesubtype = (new Integer(inKey.resourcesubtype));
}
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetUnitKey(com.hps.july.persistence.UnitKey inKey) {
	boolean unit_NULLTEST = (inKey == null);
	if (unit_NULLTEST) unit_unit = null; else unit_unit = (new Integer(inKey.unit));
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException {
	this.getAfsMountPosesLink().removeElement(anAfsMountPoses);
}
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException {
	this.getComEquipmentsLink().removeElement(aComEquipments);
}
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException {
	this.getControllersLink().removeElement(aControllers);
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException {
	this.getGrresAntennesLink().removeElement(aGrresAntennes);
}
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException {
	this.getLeaseResBilsLink().removeElement(aLeaseResBils);
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException {
	this.getSwitchesLink().removeElement(aSwitches);
}
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) {
	this.getAbonentBillPosesLink().secondaryAddElement(anAbonentBillPoses);
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) {
	this.getAfsMountPosesLink().secondaryAddElement(anAfsMountPoses);
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) {
	this.getChangeActPositionsLink().secondaryAddElement(aChangeActPositions);
}
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) {
	this.getComEquipmentsLink().secondaryAddElement(aComEquipments);
}
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddComplectparts(com.hps.july.persistence.Complect aComplectparts) {
	this.getComplectpartsLink().secondaryAddElement(aComplectparts);
}
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddComplects(com.hps.july.persistence.Complect aComplects) {
	this.getComplectsLink().secondaryAddElement(aComplects);
}
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddControllers(com.hps.july.persistence.Controller aControllers) {
	this.getControllersLink().secondaryAddElement(aControllers);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) {
	this.getDocumentPositionLink().secondaryAddElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) {
	this.getGrresAntennesLink().secondaryAddElement(aGrresAntennes);
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) {
	this.getI13nActResourceSetLink().secondaryAddElement(anI13nActResourceSet);
}
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) {
	this.getLeaseChargeRuleLink().secondaryAddElement(aLeaseChargeRule);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) {
	this.getLeaseDocPositionsLink().secondaryAddElement(aLeaseDocPositions);
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) {
	this.getLeaseMutualContractsLink().secondaryAddElement(aLeaseMutualContracts);
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualRuleNews(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews) {
	this.getLeaseMutualRuleNewsLink().secondaryAddElement(aLeaseMutualRuleNews);
}
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) {
	this.getLeasePayRuleLink().secondaryAddElement(aLeasePayRule);
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) {
	this.getLeasePosSchetFaktLink().secondaryAddElement(aLeasePosSchetFakt);
}
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) {
	this.getLeaseResBilsLink().secondaryAddElement(aLeaseResBils);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseSaldo(com.hps.july.persistence.LeaseSaldo aLeaseSaldo) {
	this.getLeaseSaldoLink().secondaryAddElement(aLeaseSaldo);
}
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) {
	this.getOuterDocPositionLink().secondaryAddElement(anOuterDocPosition);
}
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddResourceSetParts(com.hps.july.persistence.ResourceSetPart aResourceSetParts) {
	this.getResourceSetPartsLink().secondaryAddElement(aResourceSetParts);
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) {
	this.getResourceSetsLink().secondaryAddElement(aResourceSets);
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddResourceTaxes(com.hps.july.persistence.ResourceTaxe aResourceTaxes) {
	this.getResourceTaxesLink().secondaryAddElement(aResourceTaxes);
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryAddElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSwitches(com.hps.july.persistence.Switch aSwitches) {
	this.getSwitchesLink().secondaryAddElement(aSwitches);
}
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) {
	this.getAbonentBillPosesLink().secondaryRemoveElement(anAbonentBillPoses);
}
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) {
	this.getAfsMountPosesLink().secondaryRemoveElement(anAfsMountPoses);
}
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) {
	this.getChangeActPositionsLink().secondaryRemoveElement(aChangeActPositions);
}
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) {
	this.getComEquipmentsLink().secondaryRemoveElement(aComEquipments);
}
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveComplectparts(com.hps.july.persistence.Complect aComplectparts) {
	this.getComplectpartsLink().secondaryRemoveElement(aComplectparts);
}
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveComplects(com.hps.july.persistence.Complect aComplects) {
	this.getComplectsLink().secondaryRemoveElement(aComplects);
}
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveControllers(com.hps.july.persistence.Controller aControllers) {
	this.getControllersLink().secondaryRemoveElement(aControllers);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) {
	this.getDocumentPositionLink().secondaryRemoveElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) {
	this.getGrresAntennesLink().secondaryRemoveElement(aGrresAntennes);
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) {
	this.getI13nActResourceSetLink().secondaryRemoveElement(anI13nActResourceSet);
}
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) {
	this.getLeaseChargeRuleLink().secondaryRemoveElement(aLeaseChargeRule);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) {
	this.getLeaseDocPositionsLink().secondaryRemoveElement(aLeaseDocPositions);
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) {
	this.getLeaseMutualContractsLink().secondaryRemoveElement(aLeaseMutualContracts);
}
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualRuleNews(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews) {
	this.getLeaseMutualRuleNewsLink().secondaryRemoveElement(aLeaseMutualRuleNews);
}
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) {
	this.getLeasePayRuleLink().secondaryRemoveElement(aLeasePayRule);
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) {
	this.getLeasePosSchetFaktLink().secondaryRemoveElement(aLeasePosSchetFakt);
}
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) {
	this.getLeaseResBilsLink().secondaryRemoveElement(aLeaseResBils);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseSaldo(com.hps.july.persistence.LeaseSaldo aLeaseSaldo) {
	this.getLeaseSaldoLink().secondaryRemoveElement(aLeaseSaldo);
}
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) {
	this.getOuterDocPositionLink().secondaryRemoveElement(anOuterDocPosition);
}
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveResourceSetParts(com.hps.july.persistence.ResourceSetPart aResourceSetParts) {
	this.getResourceSetPartsLink().secondaryRemoveElement(aResourceSetParts);
}
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) {
	this.getResourceSetsLink().secondaryRemoveElement(aResourceSets);
}
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveResourceTaxes(com.hps.july.persistence.ResourceTaxe aResourceTaxes) {
	this.getResourceTaxesLink().secondaryRemoveElement(aResourceTaxes);
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryRemoveElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSwitches(com.hps.july.persistence.Switch aSwitches) {
	this.getSwitchesLink().secondaryRemoveElement(aSwitches);
}
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSubtype(com.hps.july.persistence.ResourceSubType aSubtype) throws java.rmi.RemoteException {
	this.getSubtypeLink().secondarySet(aSubtype);
}
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetUnit(com.hps.july.persistence.Unit anUnit) throws java.rmi.RemoteException {
	this.getUnitLink().secondarySet(anUnit);
}
/**
 * Setter method for active
 * @param newValue java.lang.Boolean
 */
public void setActive(java.lang.Boolean newValue) {
	this.active = newValue;
}
/**
 * Setter method for actualcode
 * @param newValue int
 */
public void setActualcode(int newValue) {
	this.actualcode = newValue;
}
/**
 * Setter method for boxable
 * @param newValue java.lang.Boolean
 */
public void setBoxable(java.lang.Boolean newValue) {
	this.boxable = newValue;
}
/**
 * Setter method for complect
 * @param newValue java.lang.Boolean
 */
public void setComplect(java.lang.Boolean newValue) {
	this.complect = newValue;
}
/**
 * Setter method for complectpart
 * @param newValue java.lang.Boolean
 */
public void setComplectpart(java.lang.Boolean newValue) {
	this.complectpart = newValue;
}
/**
 * Setter method for countpolicy
 */
public void setCountpolicy(java.lang.String newValue) {
	this.countpolicy = newValue;
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * Setter method for manucode
 */
public void setManucode(java.lang.String newValue) {
	this.manucode = newValue;
}
/**
 * Setter method for model
 * @param newValue java.lang.String
 */
public void setModel(java.lang.String newValue) {
	this.model = newValue;
}
/**
 * Setter method for name
 * @param newValue java.lang.String
 */
public void setName(java.lang.String newValue) {
	this.name = newValue;
}
/**
 * Setter method for notes
 * @param newValue java.lang.String
 */
public void setNotes(java.lang.String newValue) {
	this.notes = newValue;
}
/**
 * Setter method for priceable
 * @param newValue java.lang.Boolean
 */
public void setPriceable(java.lang.Boolean newValue) {
	this.priceable = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2002 19:31:18)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSubtype(com.hps.july.persistence.ResourceSubType aSubtype) throws java.rmi.RemoteException {
	this.getSubtypeLink().set(aSubtype);
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:16:05)
 * @param newSubtype_resourcesubtype java.lang.Integer
 */
public void setSubtype_resourcesubtype(java.lang.Integer newSubtype_resourcesubtype) {
	subtype_resourcesubtype = newSubtype_resourcesubtype;
}
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setUnit(com.hps.july.persistence.Unit anUnit) throws java.rmi.RemoteException {
	this.getUnitLink().set(anUnit);
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: resourceclass2
	 */
	public java.lang.Integer getResourceclass2() {
		return resourceclass2;
	}
	/**
	 * Set accessor for persistent attribute: resourceclass2
	 */
	public void setResourceclass2(java.lang.Integer newResourceclass2) {
		resourceclass2 = newResourceclass2;
	}
	/**
	 * Get accessor for persistent attribute: groupid
	 */
	public java.lang.Integer getGroupid() {
		return groupid;
	}
	/**
	 * Set accessor for persistent attribute: groupid
	 */
	public void setGroupid(java.lang.Integer newGroupid) {
		groupid = newGroupid;
	}
	/**
	 * Get accessor for persistent attribute: manufid
	 */
	public java.lang.Integer getManufid() {
		return manufid;
	}
	/**
	 * Set accessor for persistent attribute: manufid
	 */
	public void setManufid(java.lang.Integer newManufid) {
		manufid = newManufid;
	}
	/**
	 * Get accessor for persistent attribute: disablenfscodes
	 */
	public java.lang.Boolean getDisablenfscodes() {
		return disablenfscodes;
	}
	/**
	 * Set accessor for persistent attribute: disablenfscodes
	 */
	public void setDisablenfscodes(java.lang.Boolean newDisablenfscodes) {
		disablenfscodes = newDisablenfscodes;
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence.ResourceKey ejbCreate(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException {
		_initLinks();
		this.resource = resource;
		try {
			setUnit(argUnit);
			setSubtype(argSubtype);
		} catch (java.rmi.RemoteException remoteEx) {
			throw new javax.ejb.CreateException(remoteEx.getMessage());
		}
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException {
		try {
			setUnit(argUnit);
			setSubtype(argSubtype);
		} catch (java.rmi.RemoteException remoteEx) {
			throw new javax.ejb.CreateException(remoteEx.getMessage());
		}
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("unitKey", getUnitKey());
		h.put("subtypeKey", getSubtypeKey());
		h.put("countpolicy", getCountpolicy());
		h.put("model", getModel());
		h.put("manufid", getManufid());
		h.put("resourceclass2", getResourceclass2());
		h.put("actualcode", new Integer(getActualcode()));
		h.put("name", getName());
		h.put("groupid", getGroupid());
		h.put("priceable", getPriceable());
		h.put("complectpart", getComplectpart());
		h.put("resource", new Integer(getResource()));
		h.put("manucode", getManucode());
		h.put("complect", getComplect());
		h.put("disablenfscodes", getDisablenfscodes());
		h.put("subtype_resourcesubtype", getSubtype_resourcesubtype());
		h.put("notes", getNotes());
		h.put("active", getActive());
		h.put("boxable", getBoxable());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localCountpolicy =
			(java.lang.String) h.get("countpolicy");
		java.lang.String localModel = (java.lang.String) h.get("model");
		java.lang.Integer localManufid = (java.lang.Integer) h.get("manufid");
		java.lang.Integer localResourceclass2 =
			(java.lang.Integer) h.get("resourceclass2");
		Integer localActualcode = (Integer) h.get("actualcode");
		java.lang.String localName = (java.lang.String) h.get("name");
		java.lang.Integer localGroupid = (java.lang.Integer) h.get("groupid");
		java.lang.Boolean localPriceable =
			(java.lang.Boolean) h.get("priceable");
		java.lang.Boolean localComplectpart =
			(java.lang.Boolean) h.get("complectpart");
		Integer localResource = (Integer) h.get("resource");
		java.lang.String localManucode = (java.lang.String) h.get("manucode");
		java.lang.Boolean localComplect = (java.lang.Boolean) h.get("complect");
		java.lang.Boolean localDisablenfscodes =
			(java.lang.Boolean) h.get("disablenfscodes");
		java.lang.Integer localSubtype_resourcesubtype =
			(java.lang.Integer) h.get("subtype_resourcesubtype");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.Boolean localActive = (java.lang.Boolean) h.get("active");
		java.lang.Boolean localBoxable = (java.lang.Boolean) h.get("boxable");

		if (h.containsKey("countpolicy"))
			setCountpolicy((localCountpolicy));
		if (h.containsKey("model"))
			setModel((localModel));
		if (h.containsKey("manufid"))
			setManufid((localManufid));
		if (h.containsKey("resourceclass2"))
			setResourceclass2((localResourceclass2));
		if (h.containsKey("actualcode"))
			setActualcode((localActualcode).intValue());
		if (h.containsKey("name"))
			setName((localName));
		if (h.containsKey("groupid"))
			setGroupid((localGroupid));
		if (h.containsKey("priceable"))
			setPriceable((localPriceable));
		if (h.containsKey("complectpart"))
			setComplectpart((localComplectpart));
		if (h.containsKey("resource"))
			setResource((localResource).intValue());
		if (h.containsKey("manucode"))
			setManucode((localManucode));
		if (h.containsKey("complect"))
			setComplect((localComplect));
		if (h.containsKey("disablenfscodes"))
			setDisablenfscodes((localDisablenfscodes));
		if (h.containsKey("subtype_resourcesubtype"))
			setSubtype_resourcesubtype((localSubtype_resourcesubtype));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("active"))
			setActive((localActive));
		if (h.containsKey("boxable"))
			setBoxable((localBoxable));
	}
}
