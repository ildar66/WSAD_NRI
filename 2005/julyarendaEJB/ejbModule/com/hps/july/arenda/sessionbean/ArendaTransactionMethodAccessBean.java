/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.arenda.sessionbean;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class ArendaTransactionMethodAccessBean extends com.ibm.ivj.ejb.runtime.AbstractSessionAccessBean {

    transient private com.hps.july.arenda.sessionbean.ArendaTransactionMethod __ejbRef = null;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.arenda.sessionbean.ArendaTransactionMethod com.hps.july.arenda.sessionbean.ArendaTransactionMethodHome.create() throws javax.ejb.CreateException,java.rmi.RemoteException
    *
    */

    public ArendaTransactionMethodAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public ArendaTransactionMethodAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/arenda/sessionbean/ArendaTransactionMethod";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.arenda.sessionbean.ArendaTransactionMethodHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.arenda.sessionbean.ArendaTransactionMethodHome) PortableRemoteObject.narrow(getHome(), com.hps.july.arenda.sessionbean.ArendaTransactionMethodHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.arenda.sessionbean.ArendaTransactionMethod ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.arenda.sessionbean.ArendaTransactionMethod) PortableRemoteObject.narrow(ejbRef, com.hps.july.arenda.sessionbean.ArendaTransactionMethod.class);

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

    public boolean _addMutuallyBetweenContract(java.lang.Integer arg0, java.lang.Integer arg1, java.math.BigDecimal arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._addMutuallyBetweenContract(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean _addToLeaseSaldo(java.lang.Integer arg0, java.lang.Integer arg1, java.math.BigDecimal arg2, java.math.BigDecimal arg3, java.math.BigDecimal arg4, java.math.BigDecimal arg5) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._addToLeaseSaldo(arg0, arg1, arg2, arg3, arg4, arg5);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean _linkCharge2Pay(javax.ejb.Handle arg0, javax.ejb.Handle arg1, java.math.BigDecimal arg2, java.lang.Integer arg3, java.lang.Boolean arg4, java.lang.String arg5, int arg6) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._linkCharge2Pay(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean _makeSaldoCharge(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._makeSaldoCharge(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean _makeSaldoPayment(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._makeSaldoPayment(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean _setLeaseChargesRemainderRate(javax.ejb.Handle arg0, java.math.BigDecimal arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._setLeaseChargesRemainderRate(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean _setLeaseDnopChargeRURSum(javax.ejb.Handle arg0, java.math.BigDecimal arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._setLeaseDnopChargeRURSum(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean clearCharge2Pay(javax.ejb.Handle arg0, int arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().clearCharge2Pay(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean clearCharge2PayOnAktLink(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().clearCharge2PayOnAktLink(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean clearLeasevpayment() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().clearLeasevpayment();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean createChargeOrPaymentOnSaldo(java.lang.Integer arg0, java.util.Date arg1, java.lang.Integer arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().createChargeOrPaymentOnSaldo(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean createSaldo(java.lang.Integer arg0, java.util.Date arg1, java.lang.Integer arg2, java.lang.Integer arg3, java.math.BigDecimal arg4, java.math.BigDecimal arg5, int arg6, java.math.BigDecimal arg7, java.math.BigDecimal arg8) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().createSaldo(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean deleteChargeOrPaymentOnSaldo(java.lang.Integer arg0, java.util.Date arg1, java.lang.Integer arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().deleteChargeOrPaymentOnSaldo(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean fillUsedInAct(boolean arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().fillUsedInAct(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean removeSaldo(java.lang.Integer arg0, java.util.Date arg1, java.lang.Integer arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().removeSaldo(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean rollbackCalcAct(java.lang.Integer arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().rollbackCalcAct(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean rollbackCalcAct(java.lang.Integer arg0, int arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().rollbackCalcAct(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean setRateRurForPayment() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().setRateRurForPayment();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public boolean updateSaldo(java.lang.Integer arg0, java.util.Date arg1, java.lang.Integer arg2, int arg3, java.math.BigDecimal arg4, java.math.BigDecimal arg5, int arg6, java.math.BigDecimal arg7, java.math.BigDecimal arg8) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().updateSaldo(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer _makeCompensationCharge(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._makeCompensationCharge(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer _makeCompensationPayment(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._makeCompensationPayment(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer _makeMutualCharge(javax.ejb.Handle arg0, java.math.BigDecimal arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._makeMutualCharge(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer _makeMutualPayment(javax.ejb.Handle arg0, java.math.BigDecimal arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef()._makeMutualPayment(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Object[] defineRatePaymentOnContract(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().defineRatePaymentOnContract(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Object[] defineRatePaymentOnContract(java.lang.Integer arg0, java.lang.Integer arg1, java.util.Date arg2, java.util.Date arg3, java.util.Date arg4, java.util.Date arg5, java.lang.Integer arg6) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().defineRatePaymentOnContract(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal calcNds(java.lang.Integer arg0, java.util.Date arg1, java.math.BigDecimal arg2, java.lang.String arg3, int arg4) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().calcNds(arg0, arg1, arg2, arg3, arg4);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal getChargeRate(javax.ejb.Handle arg0, int arg1, boolean arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getChargeRate(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal getChargeRateTemp(javax.ejb.Handle arg0, int arg1, boolean arg2, int arg3) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getChargeRateTemp(arg0, arg1, arg2, arg3);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal getPaymentRate(javax.ejb.Handle arg0, int arg1, boolean arg2, java.lang.Integer arg3, boolean arg4) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getPaymentRate(arg0, arg1, arg2, arg3, arg4);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal getPaymentRateTemp(javax.ejb.Handle arg0, int arg1, boolean arg2, int arg3) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getPaymentRateTemp(arg0, arg1, arg2, arg3);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal setChargeRemainderRate(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().setChargeRemainderRate(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void _newCalcRate(int arg0, int arg1, java.math.BigDecimal arg2) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef()._newCalcRate(arg0, arg1, arg2);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void createSaldoSergey(java.lang.Integer arg0, java.util.Date arg1, java.lang.Integer arg2, java.lang.Integer arg3, java.math.BigDecimal arg4, java.math.BigDecimal arg5, int arg6, java.math.BigDecimal arg7, java.math.BigDecimal arg8) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().createSaldoSergey(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void updateSaldoSergey(java.lang.Integer arg0, java.util.Date arg1, java.lang.Integer arg2, int arg3, java.math.BigDecimal arg4, java.math.BigDecimal arg5, int arg6, java.math.BigDecimal arg7, java.math.BigDecimal arg8) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().updateSaldoSergey(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }


}
