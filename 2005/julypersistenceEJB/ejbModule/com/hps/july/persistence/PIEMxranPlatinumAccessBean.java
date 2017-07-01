/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class PIEMxranPlatinumAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements PIEMxranPlatinumAccessBeanData {

    transient private com.hps.july.persistence.PIEMxranPlatinum __ejbRef = null;
    private java.lang.String initKey_mxranplatinum;
    private java.lang.Integer initKey_owner_organization;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence.PIEMxranPlatinum com.hps.july.persistence.PIEMxranPlatinumHome.findByPrimaryKey(com.hps.july.persistence.PIEMxranPlatinumKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_mxranplatinum( java.lang.String )
    * setInitKey_owner_organization( java.lang.Integer )

    */

    public PIEMxranPlatinumAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public PIEMxranPlatinumAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public PIEMxranPlatinumAccessBean(java.lang.String arg0, int arg1, java.lang.String arg2, java.lang.String arg3) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1, arg2, arg3);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByMxranNameOwner(java.lang.Boolean arg0, java.lang.String arg1, java.lang.Boolean arg2, java.lang.String arg3, java.lang.Integer arg4, java.lang.Integer arg5) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.PIEMxranPlatinumHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByMxranNameOwner(arg0, arg1, arg2, arg3, arg4, arg5);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findPIEMxranPlatinumsByOwner(com.hps.july.persistence.OrganizationKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.PIEMxranPlatinumHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findPIEMxranPlatinumsByOwner(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_mxranplatinum( java.lang.String newValue ) {
        this.initKey_mxranplatinum = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_owner_organization( java.lang.Integer newValue ) {
        this.initKey_owner_organization = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence/PIEMxranPlatinum";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.PIEMxranPlatinumHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence.PIEMxranPlatinumHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.PIEMxranPlatinumHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.PIEMxranPlatinum ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence.PIEMxranPlatinum) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.PIEMxranPlatinum.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.persistence.PIEMxranPlatinumKey key = keyFromFields(initKey_mxranplatinum, initKey_owner_organization);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.PIEMxranPlatinumKey keyFromFields ( java.lang.String f0, java.lang.Integer f1 ) {
        com.hps.july.persistence.PIEMxranPlatinumKey keyClass = new com.hps.july.persistence.PIEMxranPlatinumKey();
        keyClass.mxranplatinum = f0;
        keyClass.owner_organization = f1;
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
            com.hps.july.persistence.PIEMxranPlatinumKey pKey = (com.hps.july.persistence.PIEMxranPlatinumKey) this.__getKey();
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

    public java.lang.String getMxranplatinum() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("mxranplatinum")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getP_status() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("p_status")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setP_status( java.lang.String newValue ) {
        __setCache("p_status", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OrganizationKey getOwnerKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.OrganizationKey) __getCache("ownerKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getName() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("name")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setName( java.lang.String newValue ) {
        __setCache("name", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OrganizationAccessBean getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Organization localEJBRef = ejbRef().getOwner();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.OrganizationAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getPIEMxranLinks() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getPIEMxranLinks();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddPIEMxranLinks(com.hps.july.persistence.PIEMxranLink arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddPIEMxranLinks(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemovePIEMxranLinks(com.hps.july.persistence.PIEMxranLink arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemovePIEMxranLinks(arg0);
    }


}
