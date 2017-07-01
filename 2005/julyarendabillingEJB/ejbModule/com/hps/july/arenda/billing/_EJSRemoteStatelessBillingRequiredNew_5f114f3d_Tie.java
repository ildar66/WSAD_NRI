// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.arenda.billing;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.UnknownException;

public class _EJSRemoteStatelessBillingRequiredNew_5f114f3d_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteStatelessBillingRequiredNew_5f114f3d target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.arenda.billing.BillingRequiredNew:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteStatelessBillingRequiredNew_5f114f3d) target;
    }
    
    public java.rmi.Remote getTarget() {
        return target;
    }
    
    public org.omg.CORBA.Object thisObject() {
        return this;
    }
    
    public void deactivate() {
        if (orb != null) {
            orb.disconnect(this);
            _set_delegate(null);
        }
    }
    
    public org.omg.CORBA.ORB orb() {
        return _orb();
    }
    
    public void orb(org.omg.CORBA.ORB orb) {
        orb.connect(this);
    }
    
    public void _set_delegate(org.omg.CORBA.portable.Delegate del) {
        super._set_delegate(del);
        if (del != null)
            orb = _orb();
        else
            orb = null;
    }
    
    public String[] _ids() { 
        return _type_ids;
    }
    
    public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _in, org.omg.CORBA.portable.ResponseHandler reply) throws org.omg.CORBA.SystemException {
        try {
            org.omg.CORBA_2_3.portable.InputStream in = 
                (org.omg.CORBA_2_3.portable.InputStream) _in;
            switch (method.length()) {
                case 6: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case 11: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    } else if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 12: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case 15: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    } else if (method.equals("getBillFlagNeed")) {
                        return getBillFlagNeed(in, reply);
                    }
                case 18: 
                    if (method.equals("workAbonentBillPos")) {
                        return workAbonentBillPos(in, reply);
                    } else if (method.equals("workAbonentPayment")) {
                        return workAbonentPayment(in, reply);
                    }
                case 19: 
                    if (method.equals("getAllPaymentByFlag")) {
                        return getAllPaymentByFlag(in, reply);
                    }
                case 20: 
                    if (method.equals("removeBillPos2DocPos")) {
                        return removeBillPos2DocPos(in, reply);
                    }
                case 21: 
                    if (method.equals("removePayments2DocPos")) {
                        return removePayments2DocPos(in, reply);
                    }
                case 22: 
                    if (method.equals("defineSumPayNeedForNri")) {
                        return defineSumPayNeedForNri(in, reply);
                    } else if (method.equals("getDeletingAbonentBill")) {
                        return getDeletingAbonentBill(in, reply);
                    }
                case 23: 
                    if (method.equals("getAbonentPaymentByHand")) {
                        return getAbonentPaymentByHand(in, reply);
                    } else if (method.equals("getAllAbonentDnopByFlag")) {
                        return getAllAbonentDnopByFlag(in, reply);
                    }
                case 24: 
                    if (method.equals("getAllAbonentBillsByFlag")) {
                        return getAllAbonentBillsByFlag(in, reply);
                    } else if (method.equals("moveOneDnopBufferNri2Nri")) {
                        return moveOneDnopBufferNri2Nri(in, reply);
                    }
                case 25: 
                    if (method.equals("checkPossibleMoveBill2Nri")) {
                        return checkPossibleMoveBill2Nri(in, reply);
                    } else if (method.equals("getDeletingAbonentPayment")) {
                        return getDeletingAbonentPayment(in, reply);
                    } else if (method.equals("movePayOnAktNri2BufferNri")) {
                        return movePayOnAktNri2BufferNri(in, reply);
                    }
                case 27: 
                    if (method.equals("setParamBillForMoveBill2Nri")) {
                        return setParamBillForMoveBill2Nri(in, reply);
                    }
                case 28: 
                    if (method.equals("checkPossibleMovePayment2Nri")) {
                        return checkPossibleMovePayment2Nri(in, reply);
                    }
                case 31: 
                    if (method.equals("cancelMovePayOnAktNri2BufferNri")) {
                        return cancelMovePayOnAktNri2BufferNri(in, reply);
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
    
    private org.omg.CORBA.portable.OutputStream _get_EJBHome(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        EJBHome result = target.getEJBHome();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        Util.writeRemoteObject(out,result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_handle(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Handle result = target.getHandle();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        Util.writeAbstractObject(out,result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_primaryKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Object result = target.getPrimaryKey();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        Util.writeAny(out,result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream isIdentical(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        EJBObject arg0 = (EJBObject) in.read_Object(EJBObject.class);
        boolean result = target.isIdentical(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream remove(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        try {
            target.remove();
        } catch (RemoveException ex) {
            String id = "IDL:javax/ejb/RemoveEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,RemoveException.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream cancelMovePayOnAktNri2BufferNri(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.cancelMovePayOnAktNri2BufferNri(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream checkPossibleMoveBill2Nri(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.checkPossibleMoveBill2Nri(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream checkPossibleMovePayment2Nri(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.checkPossibleMovePayment2Nri(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream defineSumPayNeedForNri(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.defineSumPayNeedForNri(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getAbonentPaymentByHand(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.getAbonentPaymentByHand(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getAllAbonentBillsByFlag(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        Object[] result = target.getAllAbonentBillsByFlag(arg0, arg1);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(cast_array(result),Object[].class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getAllAbonentDnopByFlag(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        Object[] result = target.getAllAbonentDnopByFlag(arg0, arg1);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(cast_array(result),Object[].class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getAllPaymentByFlag(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        Object[] result = target.getAllPaymentByFlag(arg0, arg1);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(cast_array(result),Object[].class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getBillFlagNeed(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Boolean result = target.getBillFlagNeed(arg0, arg1);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Boolean.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getDeletingAbonentBill(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Date arg2 = (Date) in.read_value(Date.class);
        Object[] result = target.getDeletingAbonentBill(arg0, arg1, arg2);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(cast_array(result),Object[].class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getDeletingAbonentPayment(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Date arg2 = (Date) in.read_value(Date.class);
        Object[] result = target.getDeletingAbonentPayment(arg0, arg1, arg2);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(cast_array(result),Object[].class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream moveOneDnopBufferNri2Nri(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.moveOneDnopBufferNri2Nri(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream movePayOnAktNri2BufferNri(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.movePayOnAktNri2BufferNri(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream removeBillPos2DocPos(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.removeBillPos2DocPos(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream removePayments2DocPos(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        int arg1 = in.read_long();
        boolean result = target.removePayments2DocPos(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setParamBillForMoveBill2Nri(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.setParamBillForMoveBill2Nri(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream workAbonentBillPos(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.workAbonentBillPos(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream workAbonentPayment(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.workAbonentPayment(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    // This method is required as a work-around for
    // a bug in the JDK 1.1.6 verifier.
    
    private Serializable cast_array(Object obj) {
        return (Serializable)obj;
    }
}
