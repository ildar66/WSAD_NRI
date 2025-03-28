/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.trailcom.beans;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class Sitedoc2HopsAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements Sitedoc2HopsAccessBeanData {

    transient private com.hps.july.trailcom.beans.Sitedoc2Hops __ejbRef = null;
    private int initKey_sitedoc;
    private java.lang.Integer initKey_hop_hopsid;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.trailcom.beans.Sitedoc2Hops com.hps.july.trailcom.beans.Sitedoc2HopsHome.findByPrimaryKey(com.hps.july.trailcom.beans.Sitedoc2HopsKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_sitedoc( int )
    * setInitKey_hop_hopsid( java.lang.Integer )

    */

    public Sitedoc2HopsAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public Sitedoc2HopsAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public Sitedoc2HopsAccessBean(int arg0, int arg1) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findSitedoc2HopsByHop(com.hps.july.trailcom.beans.HopKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.trailcom.beans.Sitedoc2HopsHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findSitedoc2HopsByHop(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findSitedoc2HopsBySitedoc(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.trailcom.beans.Sitedoc2HopsHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findSitedoc2HopsBySitedoc(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_sitedoc( int newValue ) {
        this.initKey_sitedoc = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_hop_hopsid( java.lang.Integer newValue ) {
        this.initKey_hop_hopsid = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/trailcom/beans/Sitedoc2Hops";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.trailcom.beans.Sitedoc2HopsHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.trailcom.beans.Sitedoc2HopsHome) PortableRemoteObject.narrow(getHome(), com.hps.july.trailcom.beans.Sitedoc2HopsHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.trailcom.beans.Sitedoc2Hops ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.trailcom.beans.Sitedoc2Hops) PortableRemoteObject.narrow(ejbRef, com.hps.july.trailcom.beans.Sitedoc2Hops.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.trailcom.beans.Sitedoc2HopsKey key = keyFromFields(initKey_sitedoc, initKey_hop_hopsid);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.trailcom.beans.Sitedoc2HopsKey keyFromFields ( int f0, java.lang.Integer f1 ) {
        com.hps.july.trailcom.beans.Sitedoc2HopsKey keyClass = new com.hps.july.trailcom.beans.Sitedoc2HopsKey();
        keyClass.sitedoc = f0;
        keyClass.hop_hopsid = f1;
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
            com.hps.july.trailcom.beans.Sitedoc2HopsKey pKey = (com.hps.july.trailcom.beans.Sitedoc2HopsKey) this.__getKey();
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

    public int getSitedoc() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Integer) __getCache("sitedoc")).intValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.trailcom.beans.HopKey getHopKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.trailcom.beans.HopKey) __getCache("hopKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.trailcom.beans.HopAccessBean getHop() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.trailcom.beans.Hop localEJBRef = ejbRef().getHop();
        if ( localEJBRef != null )
            return new com.hps.july.trailcom.beans.HopAccessBean(localEJBRef);
        else
            return null;
    }


}
