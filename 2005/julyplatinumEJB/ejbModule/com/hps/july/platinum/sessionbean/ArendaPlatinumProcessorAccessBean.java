/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.platinum.sessionbean;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class ArendaPlatinumProcessorAccessBean extends com.ibm.ivj.ejb.runtime.AbstractSessionAccessBean {

    transient private com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor __ejbRef = null;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorHome.create() throws javax.ejb.CreateException,java.rmi.RemoteException
    *
    */

    public ArendaPlatinumProcessorAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public ArendaPlatinumProcessorAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/platinum/sessionbean/ArendaPlatinumProcessor";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorHome) PortableRemoteObject.narrow(getHome(), com.hps.july.platinum.sessionbean.ArendaPlatinumProcessorHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor) PortableRemoteObject.narrow(ejbRef, com.hps.july.platinum.sessionbean.ArendaPlatinumProcessor.class);

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

    public boolean isProcessingEnabled() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().isProcessingEnabled();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int makeQryGetBanks(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().makeQryGetBanks(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int makeQryGetPays(int arg0, java.lang.Integer arg1, java.lang.Integer arg2, java.sql.Date arg3, java.sql.Date arg4) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().makeQryGetPays(arg0, arg1, arg2, arg3, arg4);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int makeQryGetSprArenda(int arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().makeQryGetSprArenda(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void makeQueryGetBanks(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().makeQueryGetBanks(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void makeQueryGetPaymentsFromPlatinum(java.sql.Timestamp arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().makeQueryGetPaymentsFromPlatinum(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void makeQueryGetSimpleSprav(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().makeQueryGetSimpleSprav(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void makeQueryMoveAccountInPlatinum(java.lang.String arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().makeQueryMoveAccountInPlatinum(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void makeQueryMovePartnerInPlatinum(java.lang.String arg0, java.lang.Integer arg1, java.lang.Integer arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().makeQueryMovePartnerInPlatinum(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void moveAllPaymentsPlatinum2Nri(int arg0) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().moveAllPaymentsPlatinum2Nri(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void moveBanksPlatinumToNri(int arg0) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().moveBanksPlatinumToNri(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void moveDogovorNriToPlatinum(int arg0, java.lang.Integer arg1, java.lang.String arg2, java.lang.String arg3) throws javax.naming.NamingException, javax.ejb.CreateException, java.rmi.RemoteException, java.lang.Exception {

        instantiateEJB();
        ejbRef().moveDogovorNriToPlatinum(arg0, arg1, arg2, arg3);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void movePaymentNriToPlatinum(int arg0, java.lang.String arg1, java.lang.Integer arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException, java.lang.Exception, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().movePaymentNriToPlatinum(arg0, arg1, arg2, arg3, arg4);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void test(int arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().test(arg0);
    }


}
