/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class LeaseSchetFaktAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements LeaseSchetFaktAccessBeanData {

    transient private com.hps.july.persistence.LeaseSchetFakt __ejbRef = null;
    private int initKey_idSchetFakt;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence.LeaseSchetFakt com.hps.july.persistence.LeaseSchetFaktHome.findByPrimaryKey(com.hps.july.persistence.LeaseSchetFaktKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_idSchetFakt( int )

    */

    public LeaseSchetFaktAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseSchetFaktAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseSchetFaktAccessBean(java.lang.Integer arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdActOrderByDateSchetFaktAsc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdActOrderByDateSchetFaktAsc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdActOrderByDateSchetFaktDesc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdActOrderByDateSchetFaktDesc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdActOrderByNumberSchetFaktAsc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdActOrderByNumberSchetFaktAsc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdActOrderByNumberSchetFaktDesc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdActOrderByNumberSchetFaktDesc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdContractOrderByDateSchetFaktAsc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdContractOrderByDateSchetFaktAsc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdContractOrderByDateSchetFaktDesc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdContractOrderByDateSchetFaktDesc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdContractOrderByNumberSchetFaktAsc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdContractOrderByNumberSchetFaktAsc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByIdContractOrderByNumberSchetFaktDesc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByIdContractOrderByNumberSchetFaktDesc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByQBE(java.lang.Integer arg0, java.lang.Boolean arg1, java.lang.String arg2, java.lang.Integer arg3) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByQBE(arg0, arg1, arg2, arg3);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findLeaseSchetFaktsByIdAct(com.hps.july.persistence.LeaseDocumentKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findLeaseSchetFaktsByIdAct(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findLeaseSchetFaktsByIdContract(com.hps.july.persistence.LeaseDocumentKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findLeaseSchetFaktsByIdContract(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findLeaseSchetFaktsByIdCurrency(com.hps.july.persistence.CurrencyKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseSchetFaktHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findLeaseSchetFaktsByIdCurrency(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_idSchetFakt( int newValue ) {
        this.initKey_idSchetFakt = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence/LeaseSchetFakt";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseSchetFaktHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence.LeaseSchetFaktHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.LeaseSchetFaktHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseSchetFakt ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence.LeaseSchetFakt) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.LeaseSchetFakt.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.persistence.LeaseSchetFaktKey key = keyFromFields(initKey_idSchetFakt);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseSchetFaktKey keyFromFields ( int f0 ) {
        com.hps.july.persistence.LeaseSchetFaktKey keyClass = new com.hps.july.persistence.LeaseSchetFaktKey();
        keyClass.idSchetFakt = f0;
        return keyClass;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected boolean instantiateEJBByPrimaryKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {
        boolean result = false;

        if ( ejbRef() != null )
            return true;

        try {
            com.hps.july.persistence.LeaseSchetFaktKey pKey = (com.hps.july.persistence.LeaseSchetFaktKey) this.__getKey();
            if ( pKey != null ) {
                ejbRef = ejbHome().findByPrimaryKey(pKey);
                result = true;
            }
        }
        catch ( javax.ejb.FinderException e ) {
        }
        return result;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void commitCopyHelper() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        commitCopyHelper(ejbRef());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void refreshCopyHelper() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        refreshCopyHelper(ejbRef());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public byte[] getDoctext() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((byte[]) __getCache("doctext")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setDoctext( byte[] newValue ) {
        __setCache("doctext", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.sql.Date getBaseDocDate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.sql.Date) __getCache("baseDocDate")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setBaseDocDate( java.sql.Date newValue ) {
        __setCache("baseDocDate", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getNumberSchetFakt() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("numberSchetFakt")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setNumberSchetFakt( java.lang.String newValue ) {
        __setCache("numberSchetFakt", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.CurrencyKey getIdCurrencyKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.CurrencyKey) __getCache("idCurrencyKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseDocumentKey getIdActKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.LeaseDocumentKey) __getCache("idActKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getDocfilename() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("docfilename")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setDocfilename( java.lang.String newValue ) {
        __setCache("docfilename", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getBaseDocNumber() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("baseDocNumber")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setBaseDocNumber( java.lang.String newValue ) {
        __setCache("baseDocNumber", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.sql.Date getDateSchetFakt() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.sql.Date) __getCache("dateSchetFakt")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setDateSchetFakt( java.sql.Date newValue ) {
        __setCache("dateSchetFakt", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseDocumentKey getIdContractKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.LeaseDocumentKey) __getCache("idContractKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int getIdSchetFakt() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Integer) __getCache("idSchetFakt")).intValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.CurrencyAccessBean getIdCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Currency localEJBRef = ejbRef().getIdCurrency();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.CurrencyAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseContractAccessBean getIdContract() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.LeaseContract localEJBRef = ejbRef().getIdContract();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.LeaseContractAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseMutualActNewAccessBean getIdAct() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.LeaseMutualActNew localEJBRef = ejbRef().getIdAct();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.LeaseMutualActNewAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getLeasePosSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getLeasePosSchetFakts();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void addLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().addLeasePosSchetFakts(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetIdActKey(com.hps.july.persistence.LeaseDocumentKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetIdActKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetIdContractKey(com.hps.july.persistence.LeaseDocumentKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetIdContractKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetIdCurrencyKey(com.hps.july.persistence.CurrencyKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetIdCurrencyKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddLeasePosSchetFakts(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemoveLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemoveLeasePosSchetFakts(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetIdAct(com.hps.july.persistence.LeaseMutualActNew arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetIdAct(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetIdContract(com.hps.july.persistence.LeaseContract arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetIdContract(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetIdCurrency(com.hps.july.persistence.Currency arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetIdCurrency(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setIdAct(com.hps.july.persistence.LeaseMutualActNew arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setIdAct(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setIdContract(com.hps.july.persistence.LeaseContract arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setIdContract(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setIdCurrency(com.hps.july.persistence.Currency arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setIdCurrency(arg0);
    }


	/**
	 * getIdRegistryDoc
	 * @generated
	 */
	public java.lang.Integer getIdRegistryDoc()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("idRegistryDoc")));
	}
	/**
	 * setIdRegistryDoc
	 * @generated
	 */
	public void setIdRegistryDoc(java.lang.Integer newValue) {
		__setCache("idRegistryDoc", newValue);
	}
	/**
	 * getState
	 * @generated
	 */
	public java.lang.String getState()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("state")));
	}
	/**
	 * setState
	 * @generated
	 */
	public void setState(java.lang.String newValue) {
		__setCache("state", newValue);
	}
	/**
	 * getDateEndSf
	 * @generated
	 */
	public java.sql.Date getDateEndSf()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("dateEndSf")));
	}
	/**
	 * setDateEndSf
	 * @generated
	 */
	public void setDateEndSf(java.sql.Date newValue) {
		__setCache("dateEndSf", newValue);
	}
	/**
	 * getCreated
	 * @generated
	 */
	public java.sql.Timestamp getCreated()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Timestamp) __getCache("created")));
	}
	/**
	 * setCreated
	 * @generated
	 */
	public void setCreated(java.sql.Timestamp newValue) {
		__setCache("created", newValue);
	}
	/**
	 * getModified
	 * @generated
	 */
	public java.sql.Timestamp getModified()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Timestamp) __getCache("modified")));
	}
	/**
	 * setModified
	 * @generated
	 */
	public void setModified(java.sql.Timestamp newValue) {
		__setCache("modified", newValue);
	}
	/**
	 * getModifiedBy
	 * @generated
	 */
	public java.lang.Integer getModifiedBy()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("modifiedBy")));
	}
	/**
	 * setModifiedBy
	 * @generated
	 */
	public void setModifiedBy(java.lang.Integer newValue) {
		__setCache("modifiedBy", newValue);
	}
	/**
	 * getCreatedBy
	 * @generated
	 */
	public java.lang.Integer getCreatedBy()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("createdBy")));
	}
	/**
	 * setCreatedBy
	 * @generated
	 */
	public void setCreatedBy(java.lang.Integer newValue) {
		__setCache("createdBy", newValue);
	}
	/**
	 * getDateStartSf
	 * @generated
	 */
	public java.sql.Date getDateStartSf()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("dateStartSf")));
	}
	/**
	 * setDateStartSf
	 * @generated
	 */
	public void setDateStartSf(java.sql.Date newValue) {
		__setCache("dateStartSf", newValue);
	}
}