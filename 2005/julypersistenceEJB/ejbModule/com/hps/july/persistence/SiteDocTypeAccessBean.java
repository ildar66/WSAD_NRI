/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class SiteDocTypeAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements SiteDocTypeAccessBeanData {

    transient private com.hps.july.persistence.SiteDocType __ejbRef = null;
    private int initKey_sitedoctype;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence.SiteDocType com.hps.july.persistence.SiteDocTypeHome.findByPrimaryKey(com.hps.july.persistence.SiteDocTypeKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_sitedoctype( int )

    */

    public SiteDocTypeAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public SiteDocTypeAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public SiteDocTypeAccessBean(int arg0, java.lang.String arg1) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.SiteDocTypeHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findAll();
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_sitedoctype( int newValue ) {
        this.initKey_sitedoctype = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence/SiteDocType";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.SiteDocTypeHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence.SiteDocTypeHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.SiteDocTypeHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.SiteDocType ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence.SiteDocType) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.SiteDocType.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.persistence.SiteDocTypeKey key = keyFromFields(initKey_sitedoctype);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.SiteDocTypeKey keyFromFields ( int f0 ) {
        com.hps.july.persistence.SiteDocTypeKey keyClass = new com.hps.july.persistence.SiteDocTypeKey();
        keyClass.sitedoctype = f0;
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
            com.hps.july.persistence.SiteDocTypeKey pKey = (com.hps.july.persistence.SiteDocTypeKey) this.__getKey();
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

    public int getSitedoctype() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Integer) __getCache("sitedoctype")).intValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getSitedoctypetxt() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("sitedoctypetxt")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setSitedoctypetxt( java.lang.String newValue ) {
        __setCache("sitedoctypetxt", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getSitedoctypename() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("sitedoctypename")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setSitedoctypename( java.lang.String newValue ) {
        __setCache("sitedoctypename", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getSiteDocs() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getSiteDocs();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void addSiteDocs(com.hps.july.persistence.SiteDoc arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().addSiteDocs(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddSiteDocs(com.hps.july.persistence.SiteDoc arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddSiteDocs(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemoveSiteDocs(com.hps.july.persistence.SiteDoc arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemoveSiteDocs(arg0);
    }


}
