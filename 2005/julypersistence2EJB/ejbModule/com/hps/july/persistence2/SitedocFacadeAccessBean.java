/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence2;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class SitedocFacadeAccessBean extends com.ibm.ivj.ejb.runtime.AbstractSessionAccessBean {

    transient private com.hps.july.persistence2.SitedocFacade __ejbRef = null;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence2.SitedocFacade com.hps.july.persistence2.SitedocFacadeHome.create() throws javax.ejb.CreateException,java.rmi.RemoteException
    *
    */

    public SitedocFacadeAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public SitedocFacadeAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence2/SitedocFacade";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence2.SitedocFacadeHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence2.SitedocFacadeHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence2.SitedocFacadeHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence2.SitedocFacade ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence2.SitedocFacade) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence2.SitedocFacade.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        ejbRef = ejbHome().create();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence2.EtapDocValueObject findEtapDocByPrimaryKey(int arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().findEtapDocByPrimaryKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence2.GKRCHDocValueObject findGKRCHDocByPrimaryKey(int arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().findGKRCHDocByPrimaryKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence2.RRLDocValueObject findRRLDocByPrimaryKey(int arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().findRRLDocByPrimaryKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int getGKRCHSiteDocType() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getGKRCHSiteDocType();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int getRRLSiteDocType() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getRRLSiteDocType();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void createEtapDoc(com.hps.july.persistence2.EtapDocValueObject arg0, int[] arg1) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().createEtapDoc(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void createGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().createGKRCHDoc(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void createGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject arg0, com.hps.july.persistence2.DocResourceValueObject[] arg1, int[] arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().createGKRCHDoc(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void createRRLDoc(com.hps.july.persistence2.RRLDocValueObject arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().createRRLDoc(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void createRRLDoc(com.hps.july.persistence2.RRLDocValueObject arg0, com.hps.july.persistence2.DocResourceValueObject[] arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().createRRLDoc(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void deleteEtapDoc(int arg0) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().deleteEtapDoc(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void deleteGKRCHDoc(int arg0) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().deleteGKRCHDoc(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void deleteRRLDoc(int arg0) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().deleteRRLDoc(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void updateEtapDoc(com.hps.july.persistence2.EtapDocValueObject arg0, int[] arg1) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().updateEtapDoc(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void updateGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().updateGKRCHDoc(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void updateGKRCHDoc(com.hps.july.persistence2.GKRCHDocValueObject arg0, com.hps.july.persistence2.DocResourceValueObject[] arg1, int[] arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().updateGKRCHDoc(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void updateRRLDoc(com.hps.july.persistence2.RRLDocValueObject arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().updateRRLDoc(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void updateRRLDoc(com.hps.july.persistence2.RRLDocValueObject arg0, com.hps.july.persistence2.DocResourceValueObject[] arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().updateRRLDoc(arg0, arg1);
    }


}
