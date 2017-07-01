package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: Resource
 */
public interface Resource extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {












/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAbonentBillPoses() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for active
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getActive() throws java.rmi.RemoteException;
/**
 * Getter method for actualcode
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getActualcode() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAfsMountPoses() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for boxable
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getBoxable() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getChangeActPositions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getComEquipments() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for complect
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getComplect() throws java.rmi.RemoteException;
/**
 * Getter method for complectpart
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getComplectpart() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getComplectparts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getComplects() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getControllers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getCountpolicy() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getGrresAntennes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nActResourceSet() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseChargeRule() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseDocPositions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualContracts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualRuleNews() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeasePayRule() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeasePosSchetFakt() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseResBils() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseSaldo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getManucode() throws java.rmi.RemoteException;
/**
 * Getter method for model
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getModel() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * Getter method for notes
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNotes() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getOuterDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for priceable
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getPriceable() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getResource() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getResourceSetParts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getResourceSets() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getResourceTaxes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceSubType getSubtype() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceSubTypeKey getSubtypeKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSwitches() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Unit getUnit() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.UnitKey getUnitKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSubtypeKey(com.hps.july.persistence.ResourceSubTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetUnitKey(com.hps.july.persistence.UnitKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddComplectparts(com.hps.july.persistence.Complect aComplectparts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddComplects(com.hps.july.persistence.Complect aComplects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualRuleNews(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseSaldo(com.hps.july.persistence.LeaseSaldo aLeaseSaldo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddResourceSetParts(com.hps.july.persistence.ResourceSetPart aResourceSetParts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddResourceTaxes(com.hps.july.persistence.ResourceTaxe aResourceTaxes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AfsMountPos2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAfsMountPoses(com.hps.july.persistence.AfsMountPos anAfsMountPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveChangeActPositions(com.hps.july.persistence.ChangeActPosition aChangeActPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveComEquipments(com.hps.july.persistence.ComEquipment aComEquipments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveComplectparts(com.hps.july.persistence.Complect aComplectparts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveComplects(com.hps.july.persistence.Complect aComplects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Controller2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveControllers(com.hps.july.persistence.Controller aControllers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AntennaGroundresource2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveGrresAntennes(com.hps.july.persistence.Antenna aGrresAntennes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualContracts2resources.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualRuleNew2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualRuleNews(com.hps.july.persistence.LeaseMutualRuleNew aLeaseMutualRuleNews) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeasePosSchetFakt(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakt) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseResBils(com.hps.july.persistence.LeaseResBil2NRI aLeaseResBils) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseSaldo(com.hps.july.persistence.LeaseSaldo aLeaseSaldo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OuterDocPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSetPart2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveResourceSetParts(com.hps.july.persistence.ResourceSetPart aResourceSetParts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSets2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveResourceSets(com.hps.july.persistence.ResourceSet aResourceSets) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveResourceTaxes(com.hps.july.persistence.ResourceTaxe aResourceTaxes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Switch2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSwitches(com.hps.july.persistence.Switch aSwitches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSubtype(com.hps.july.persistence.ResourceSubType aSubtype) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetUnit(com.hps.july.persistence.Unit anUnit) throws java.rmi.RemoteException;
/**
 * Setter method for active
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setActive(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for actualcode
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setActualcode(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for boxable
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setBoxable(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for complect
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setComplect(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for complectpart
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setComplectpart(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setCountpolicy(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setManucode(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for model
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setModel(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for notes
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNotes(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for priceable
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setPriceable(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newResource int
 * @exception String The exception description.
 */
void setResource(int newResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSubtype(com.hps.july.persistence.ResourceSubType aSubtype) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setUnit(com.hps.july.persistence.Unit anUnit) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: resourceclass2
	 */
	public java.lang.Integer getResourceclass2()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: resourceclass2
	 */
	public void setResourceclass2(java.lang.Integer newResourceclass2)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: groupid
	 */
	public java.lang.Integer getGroupid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: groupid
	 */
	public void setGroupid(java.lang.Integer newGroupid)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: manufid
	 */
	public java.lang.Integer getManufid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: manufid
	 */
	public void setManufid(java.lang.Integer newManufid)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: disablenfscodes
	 */
	public java.lang.Boolean getDisablenfscodes()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: disablenfscodes
	 */
	public void setDisablenfscodes(java.lang.Boolean newDisablenfscodes)
		throws java.rmi.RemoteException;
}
