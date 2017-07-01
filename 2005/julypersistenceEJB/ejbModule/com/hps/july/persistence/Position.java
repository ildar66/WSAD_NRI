package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Position extends com.hps.july.persistence.StoragePlace, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addEquipmentSet(com.hps.july.persistence.EquipmentSet anEquipmentSet) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getAccesslistexp() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAntplaceid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getApplaceid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getApplacetypeid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAptypeid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getAvg_h_set() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getComment_doc() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getDampsid() throws java.rmi.RemoteException;
/**
 * Getter method for dampsname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDampsname() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDatasource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate_endbuild() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate_posclose() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDatebeginbuild() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getDcsid() throws java.rmi.RemoteException;
/**
 * Getter method for details
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDetails() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDocaddress() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDogdate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getDognumber() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getEquipmentSet() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getGrchaddress() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getGrchlat() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getGrchlong() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getGsmid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getHaveplan() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getInAction() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getInmetro() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInternalOutBill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInternalWayBill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for latitude
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLatitude() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseArendaAgreementNews() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseOnPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getLinktogosnetlat() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getLinktogosnetlon() throws java.rmi.RemoteException;
/**
 * Getter method for longitude
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLongitude() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.NetZone getNetZone() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.NetZoneKey getNetZoneKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getOporadate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getOporaheight() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getOporaour() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOporplaceid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOrderno() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getPaya() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPhoto() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPlanstate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPositionResponsibleWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPosstate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjects() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Region getRegion() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.RegionKey getRegionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Organization getRenter() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getRenterKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRentervolume() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRequest() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSqqty() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetNetZoneKey(com.hps.july.persistence.NetZoneKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetRegionKey(com.hps.july.persistence.RegionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetRenterKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddEquipmentSet(com.hps.july.persistence.EquipmentSet anEquipmentSet) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseOnPosition(com.hps.july.persistence.LeaseOnPosition aLeaseOnPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named EquipmentSet2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveEquipmentSet(com.hps.july.persistence.EquipmentSet anEquipmentSet) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInternalOutBill(com.hps.july.persistence.InternalOutBill anInternalOutBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInternalWayBill(com.hps.july.persistence.InternalWayBill anInternalWayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseArendaAgreementNews(com.hps.july.persistence.LeaseArendaAgreementNew aLeaseArendaAgreementNews) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseOnPosition2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseOnPosition(com.hps.july.persistence.LeaseOnPosition aLeaseOnPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Photo2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePhoto(com.hps.july.persistence.Photo aPhoto) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetNetZone(com.hps.july.persistence.NetZone aNetZone) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetRenter(com.hps.july.persistence.Organization aRenter) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setAccesslistexp(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAntplaceid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setApplaceid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setApplacetypeid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAptypeid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setAvg_h_set(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setComment_doc(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setDampsid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dampsname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDampsname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setDatasource(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate_endbuild(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate_posclose(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDatebeginbuild(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setDcsid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for details
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDetails(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDocaddress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDogdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setDognumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setGrchaddress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setGrchlat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setGrchlong(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setGsmid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setHaveplan(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setInAction(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setInmetro(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for latitude
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLatitude(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setLinktogosnetlat(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setLinktogosnetlon(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for longitude
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLongitude(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named NetZone2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setNetZone(com.hps.july.persistence.NetZone aNetZone) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setOporadate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setOporaheight(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setOporaour(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setOporplaceid(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setOrderno(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setPaya(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPlanstate(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPosstate(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2region.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setRegion(com.hps.july.persistence.Region aRegion) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Position2Rentee.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setRenter(com.hps.july.persistence.Organization aRenter) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setRentervolume(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setSqqty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: latitude_WGS84
	 */
	public java.math.BigDecimal getLatitude_WGS84()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: latitude_WGS84
	 */
	public void setLatitude_WGS84(java.math.BigDecimal newLatitude_WGS84)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: longitude_WGS84
	 */
	public java.math.BigDecimal getLongitude_WGS84()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: longitude_WGS84
	 */
	public void setLongitude_WGS84(java.math.BigDecimal newLongitude_WGS84)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: geosystem
	 */
	public int getGeosystem() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: geosystem
	 */
	public void setGeosystem(int newGeosystem) throws java.rmi.RemoteException;
}
