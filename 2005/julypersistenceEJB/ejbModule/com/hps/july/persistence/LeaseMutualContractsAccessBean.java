/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class LeaseMutualContractsAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements LeaseMutualContractsAccessBeanData {

    transient private com.hps.july.persistence.LeaseMutualContracts __ejbRef = null;
    private java.lang.Integer initKey_reglament_leaseDocument;
    private java.lang.Integer initKey_contract_leaseDocument;
    private java.lang.Integer initKey_resource_resource;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence.LeaseMutualContracts com.hps.july.persistence.LeaseMutualContractsHome.findByPrimaryKey(com.hps.july.persistence.LeaseMutualContractsKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_reglament_leaseDocument( java.lang.Integer )
    * setInitKey_contract_leaseDocument( java.lang.Integer )
    * setInitKey_resource_resource( java.lang.Integer )

    */

    public LeaseMutualContractsAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseMutualContractsAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseMutualContractsAccessBean(java.lang.Integer arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findLeaseArendaAgreementsByReglament(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseMutualContractsHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findLeaseArendaAgreementsByReglament(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findLeaseMutualContractsByContract(com.hps.july.persistence.LeaseDocumentKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseMutualContractsHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findLeaseMutualContractsByContract(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findLeaseMutualContractsByReglament(com.hps.july.persistence.LeaseDocumentKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseMutualContractsHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findLeaseMutualContractsByReglament(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findLeaseMutualContractsByResource(com.hps.july.persistence.ResourceKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseMutualContractsHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findLeaseMutualContractsByResource(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_reglament_leaseDocument( java.lang.Integer newValue ) {
        this.initKey_reglament_leaseDocument = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_contract_leaseDocument( java.lang.Integer newValue ) {
        this.initKey_contract_leaseDocument = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_resource_resource( java.lang.Integer newValue ) {
        this.initKey_resource_resource = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence/LeaseMutualContracts";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseMutualContractsHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence.LeaseMutualContractsHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.LeaseMutualContractsHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseMutualContracts ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence.LeaseMutualContracts) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.LeaseMutualContracts.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.persistence.LeaseMutualContractsKey key = keyFromFields(initKey_reglament_leaseDocument, initKey_contract_leaseDocument, initKey_resource_resource);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseMutualContractsKey keyFromFields ( java.lang.Integer f0, java.lang.Integer f1, java.lang.Integer f2 ) {
        com.hps.july.persistence.LeaseMutualContractsKey keyClass = new com.hps.july.persistence.LeaseMutualContractsKey();
        keyClass.reglament_leaseDocument = f0;
        keyClass.contract_leaseDocument = f1;
        keyClass.resource_resource = f2;
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
            com.hps.july.persistence.LeaseMutualContractsKey pKey = (com.hps.july.persistence.LeaseMutualContractsKey) this.__getKey();
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

    public com.hps.july.persistence.LeaseDocumentKey getReglamentKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.LeaseDocumentKey) __getCache("reglamentKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseDocumentKey getContractKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.LeaseDocumentKey) __getCache("contractKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.ResourceKey) __getCache("resourceKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseContractAccessBean getContract() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.LeaseContract localEJBRef = ejbRef().getContract();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.LeaseContractAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseMutualReglamentAccessBean getReglament() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.LeaseMutualReglament localEJBRef = ejbRef().getReglament();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.LeaseMutualReglamentAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.ResourceAccessBean getResource() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Resource localEJBRef = ejbRef().getResource();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.ResourceAccessBean(localEJBRef);
        else
            return null;
    }


}
