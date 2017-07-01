package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Currency extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInwayBill(com.hps.july.persistence.InwayBill anInwayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseContract(com.hps.july.persistence.LeaseContract aLeaseContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseContract2(com.hps.july.persistence.LeaseContract aLeaseContract2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseMutualReglamentsAdd(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglamentsAdd) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseMutualReglamentsMain(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglamentsMain) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseSaldoAdds(com.hps.july.persistence.LeaseSaldo aLeaseSaldoAdds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseSaldoMains(com.hps.july.persistence.LeaseSaldo aLeaseSaldoMains) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addOutWayBills(com.hps.july.persistence.OutWayBill anOutWayBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRateType(com.hps.july.persistence.RateType aRateType) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getAbonentBillPoses() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getCurrency() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInwayBill() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseCalcRates() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseChargeRule() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseContract2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseDocPositions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseMutualReglamentsAdd() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseMutualReglamentsMain() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeasePayRule() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseSaldoAdds() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseSaldoMains() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getLeaseSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getOutWayBills() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Rate2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRates() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRateType() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for shortname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getShortname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseContract(com.hps.july.persistence.LeaseContract aLeaseContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseContract2(com.hps.july.persistence.LeaseContract aLeaseContract2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseMutualReglamentsAdd(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglamentsAdd) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeLeaseSaldoAdds(com.hps.july.persistence.LeaseSaldo aLeaseSaldoAdds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInwayBill(com.hps.july.persistence.InwayBill anInwayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseContract(com.hps.july.persistence.LeaseContract aLeaseContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseContract2(com.hps.july.persistence.LeaseContract aLeaseContract2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseMutualReglamentsAdd(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglamentsAdd) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseMutualReglamentsMain(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglamentsMain) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseSaldoAdds(com.hps.july.persistence.LeaseSaldo aLeaseSaldoAdds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseSaldoMains(com.hps.july.persistence.LeaseSaldo aLeaseSaldoMains) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddOutWayBills(com.hps.july.persistence.OutWayBill anOutWayBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Rate2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRates(com.hps.july.persistence.Rate aRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRateType(com.hps.july.persistence.RateType aRateType) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveAbonentBillPoses(com.hps.july.persistence.AbonentBillPos anAbonentBillPoses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveInwayBill(com.hps.july.persistence.InwayBill anInwayBill) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseChargeRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseChargeRule(com.hps.july.persistence.LeaseChargeRule aLeaseChargeRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseContract(com.hps.july.persistence.LeaseContract aLeaseContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseContract2(com.hps.july.persistence.LeaseContract aLeaseContract2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseDocPosition2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseMutualReglamentsAdd(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglamentsAdd) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMutualReglament2currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseMutualReglamentsMain(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglamentsMain) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeasePayRule2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeasePayRule(com.hps.july.persistence.LeasePayRule aLeasePayRule) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2addcur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseSaldoAdds(com.hps.july.persistence.LeaseSaldo aLeaseSaldoAdds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSaldo2maincur.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseSaldoMains(com.hps.july.persistence.LeaseSaldo aLeaseSaldoMains) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveOutWayBills(com.hps.july.persistence.OutWayBill anOutWayBills) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Rate2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRates(com.hps.july.persistence.Rate aRates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRateType(com.hps.july.persistence.RateType aRateType) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newCurrency int
 * @exception String The exception description.
 */
void setCurrency(int newCurrency) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for shortname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setShortname(java.lang.String newValue) throws java.rmi.RemoteException;
}
