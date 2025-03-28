/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.trailcom.beans;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class AddressInfoAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements AddressInfoAccessBeanData {

    transient private com.hps.july.trailcom.beans.AddressInfo __ejbRef = null;
    private int initKey_resource;
    private short initKey_typeport;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.trailcom.beans.AddressInfo com.hps.july.trailcom.beans.AddressInfoHome.findByPrimaryKey(com.hps.july.trailcom.beans.AddressInfoKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_resource( int )
    * setInitKey_typeport( short )

    */

    public AddressInfoAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public AddressInfoAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public AddressInfoAccessBean(int arg0, short arg1) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByResource(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.trailcom.beans.AddressInfoHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByResource(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_resource( int newValue ) {
        this.initKey_resource = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_typeport( short newValue ) {
        this.initKey_typeport = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/trailcom/beans/AddressInfo";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.trailcom.beans.AddressInfoHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.trailcom.beans.AddressInfoHome) PortableRemoteObject.narrow(getHome(), com.hps.july.trailcom.beans.AddressInfoHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.trailcom.beans.AddressInfo ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.trailcom.beans.AddressInfo) PortableRemoteObject.narrow(ejbRef, com.hps.july.trailcom.beans.AddressInfo.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.trailcom.beans.AddressInfoKey key = keyFromFields(initKey_resource, initKey_typeport);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.trailcom.beans.AddressInfoKey keyFromFields ( int f0, short f1 ) {
        com.hps.july.trailcom.beans.AddressInfoKey keyClass = new com.hps.july.trailcom.beans.AddressInfoKey();
        keyClass.resource = f0;
        keyClass.typeport = f1;
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
            com.hps.july.trailcom.beans.AddressInfoKey pKey = (com.hps.july.trailcom.beans.AddressInfoKey) this.__getKey();
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

    public java.lang.Short getAddresstype() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Short) __getCache("addresstype")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setAddresstype( java.lang.Short newValue ) {
        __setCache("addresstype", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public short getTypeport() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Short) __getCache("typeport")).shortValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setTypeport( short newValue ) {
        __setCache("typeport", new Short(newValue));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getLastaddress() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("lastaddress")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setLastaddress( java.lang.Integer newValue ) {
        __setCache("lastaddress", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getAddresshead() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("addresshead")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setAddresshead( java.lang.String newValue ) {
        __setCache("addresshead", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getMaxconnect() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("maxconnect")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setMaxconnect( java.lang.Integer newValue ) {
        __setCache("maxconnect", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int getResource() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Integer) __getCache("resource")).intValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setResource( int newValue ) {
        __setCache("resource", new Integer(newValue));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getAddressstep() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("addressstep")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setAddressstep( java.lang.Integer newValue ) {
        __setCache("addressstep", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getStartaddress() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("startaddress")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setStartaddress( java.lang.Integer newValue ) {
        __setCache("startaddress", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getE1count() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("e1count")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setE1count( java.lang.Integer newValue ) {
        __setCache("e1count", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getAddressInfo2s() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getAddressInfo2s();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getAddressSpaces() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getAddressSpaces();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void addAddressInfo2s(com.hps.july.trailcom.beans.AddressInfo2 arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().addAddressInfo2s(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void addAddressSpaces(com.hps.july.trailcom.beans.AddressSpace arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().addAddressSpaces(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddAddressInfo2s(com.hps.july.trailcom.beans.AddressInfo2 arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddAddressInfo2s(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddAddressSpaces(com.hps.july.trailcom.beans.AddressSpace arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddAddressSpaces(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemoveAddressInfo2s(com.hps.july.trailcom.beans.AddressInfo2 arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemoveAddressInfo2s(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemoveAddressSpaces(com.hps.july.trailcom.beans.AddressSpace arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemoveAddressSpaces(arg0);
    }


}
