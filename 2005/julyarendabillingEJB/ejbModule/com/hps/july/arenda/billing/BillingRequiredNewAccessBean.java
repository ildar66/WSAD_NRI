/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.arenda.billing;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class BillingRequiredNewAccessBean extends com.ibm.ivj.ejb.runtime.AbstractSessionAccessBean {

    transient private com.hps.july.arenda.billing.BillingRequiredNew __ejbRef = null;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.arenda.billing.BillingRequiredNew com.hps.july.arenda.billing.BillingRequiredNewHome.create() throws javax.ejb.CreateException,java.rmi.RemoteException
    *
    */

    public BillingRequiredNewAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public BillingRequiredNewAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/arenda/billing/BillingRequiredNew";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.arenda.billing.BillingRequiredNewHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.arenda.billing.BillingRequiredNewHome) PortableRemoteObject.narrow(getHome(), com.hps.july.arenda.billing.BillingRequiredNewHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.arenda.billing.BillingRequiredNew ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.arenda.billing.BillingRequiredNew) PortableRemoteObject.narrow(ejbRef, com.hps.july.arenda.billing.BillingRequiredNew.class);

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

    public boolean cancelMovePayOnAktNri2BufferNri(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().cancelMovePayOnAktNri2BufferNri(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean checkPossibleMoveBill2Nri(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().checkPossibleMoveBill2Nri(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean checkPossibleMovePayment2Nri(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().checkPossibleMovePayment2Nri(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean defineSumPayNeedForNri(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().defineSumPayNeedForNri(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean getAbonentPaymentByHand(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getAbonentPaymentByHand(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean moveOneDnopBufferNri2Nri(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().moveOneDnopBufferNri2Nri(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean movePayOnAktNri2BufferNri(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().movePayOnAktNri2BufferNri(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean removeBillPos2DocPos(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().removeBillPos2DocPos(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean removePayments2DocPos(int arg0, int arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().removePayments2DocPos(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean setParamBillForMoveBill2Nri(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().setParamBillForMoveBill2Nri(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean workAbonentBillPos(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().workAbonentBillPos(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean workAbonentPayment(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().workAbonentPayment(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Boolean getBillFlagNeed(int arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getBillFlagNeed(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Object[] getAllAbonentBillsByFlag(int arg0, java.lang.String arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getAllAbonentBillsByFlag(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Object[] getAllAbonentDnopByFlag(int arg0, java.lang.String arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getAllAbonentDnopByFlag(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Object[] getAllPaymentByFlag(int arg0, java.lang.String arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getAllPaymentByFlag(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Object[] getDeletingAbonentBill(int arg0, java.lang.Integer arg1, java.util.Date arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getDeletingAbonentBill(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Object[] getDeletingAbonentPayment(int arg0, java.lang.Integer arg1, java.util.Date arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getDeletingAbonentPayment(arg0, arg1, arg2);
    }


}
