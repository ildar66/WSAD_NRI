// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.arenda.sessionbean;

import com.hps.july.persistence.OrganizationAccessBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.UnknownException;

public class _EJSRemoteStatelessCalculateArendaAct_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteStatelessCalculateArendaAct target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.arenda.sessionbean.CalculateArendaAct:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteStatelessCalculateArendaAct) target;
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
                    } else if (method.equals("clearCharge2Pay")) {
                        return clearCharge2Pay(in, reply);
                    }
                case 16: 
                    if (method.equals("compareContracts")) {
                        return compareContracts(in, reply);
                    }
                case 17: 
                    if (method.equals("getChargeRateTemp")) {
                        return getChargeRateTemp(in, reply);
                    }
                case 18: 
                    if (method.equals("getPaymentRateTemp")) {
                        return getPaymentRateTemp(in, reply);
                    } else if (method.equals("linkCharge2PayTemp")) {
                        return linkCharge2PayTemp(in, reply);
                    }
                case 19: 
                    if (method.equals("checkOplChargesTemp")) {
                        return checkOplChargesTemp(in, reply);
                    } else if (method.equals("clearCharge2PayTemp")) {
                        return clearCharge2PayTemp(in, reply);
                    } else if (method.equals("isMemberBeelineTemp")) {
                        return isMemberBeelineTemp(in, reply);
                    }
                case 20: 
                    if (method.equals("createPayChargeSaldo")) {
                        return createPayChargeSaldo(in, reply);
                    } else if (method.equals("getPreviousSaldoTemp")) {
                        return getPreviousSaldoTemp(in, reply);
                    } else if (method.equals("getSaldoContractTemp")) {
                        return getSaldoContractTemp(in, reply);
                    }
                case 21: 
                    if (method.equals("setChargesRURRateTemp")) {
                        return setChargesRURRateTemp(in, reply);
                    }
                case 22: 
                    if (method.equals("calculateContractSaldo")) {
                        return calculateContractSaldo(in, reply);
                    }
                case 23: 
                    if (method.equals("closeChargesInPeriodAct")) {
                        return closeChargesInPeriodAct(in, reply);
                    }
                case 28: 
                    if (method.equals("getSaldoContractResourceTemp")) {
                        return getSaldoContractResourceTemp(in, reply);
                    }
                case 31: 
                    if (method.equals("checkAllResourcesInPaymentsTemp")) {
                        return checkAllResourcesInPaymentsTemp(in, reply);
                    } else if (method.equals("getComplementaryChargeByPayTemp")) {
                        return getComplementaryChargeByPayTemp(in, reply);
                    }
                case 33: 
                    if (method.equals("findAndCalcComplementaryContracts")) {
                        return findAndCalcComplementaryContracts(in, reply);
                    }
                case 37: 
                    if (method.equals("findAndCalcComplementaryContractsTemp")) {
                        return findAndCalcComplementaryContractsTemp(in, reply);
                    }
                case 51: 
                    if (method.equals("calcAct__java_lang_Integer__long__java_lang_Integer")) {
                        return calcAct__java_lang_Integer__long__java_lang_Integer(in, reply);
                    }
                case 57: 
                    if (method.equals("calcAct__java_lang_Integer__long__java_lang_Integer__long")) {
                        return calcAct__java_lang_Integer__long__java_lang_Integer__long(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream calcAct__java_lang_Integer__long__java_lang_Integer(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        int arg1 = in.read_long();
        Integer arg2 = (Integer) in.read_value(Integer.class);
        boolean result = target.calcAct(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream calcAct__java_lang_Integer__long__java_lang_Integer__long(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        int arg1 = in.read_long();
        Integer arg2 = (Integer) in.read_value(Integer.class);
        int arg3 = in.read_long();
        boolean result = target.calcAct(arg0, arg1, arg2, arg3);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream calculateContractSaldo(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        boolean result = target.calculateContractSaldo(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream checkAllResourcesInPaymentsTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        boolean result = target.checkAllResourcesInPaymentsTemp(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream checkOplChargesTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        boolean result = target.checkOplChargesTemp(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream clearCharge2Pay(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        boolean result = target.clearCharge2Pay(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream clearCharge2PayTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Integer arg2 = (Integer) in.read_value(Integer.class);
        boolean result = target.clearCharge2PayTemp(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream closeChargesInPeriodAct(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        boolean result = target.closeChargesInPeriodAct();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream compareContracts(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        int arg1 = in.read_long();
        int arg2 = in.read_long();
        boolean result = target.compareContracts(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream createPayChargeSaldo(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        boolean result = target.createPayChargeSaldo(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findAndCalcComplementaryContracts(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        boolean result = target.findAndCalcComplementaryContracts();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findAndCalcComplementaryContractsTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        boolean result = target.findAndCalcComplementaryContractsTemp(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getChargeRateTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        int arg1 = in.read_long();
        int arg2 = in.read_long();
        boolean arg3 = in.read_boolean();
        BigDecimal result = target.getChargeRateTemp(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getComplementaryChargeByPayTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        int arg1 = in.read_long();
        Integer arg2 = (Integer) in.read_value(Integer.class);
        int result = target.getComplementaryChargeByPayTemp(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getPaymentRateTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        int arg1 = in.read_long();
        int arg2 = in.read_long();
        boolean arg3 = in.read_boolean();
        BigDecimal result = target.getPaymentRateTemp(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getPreviousSaldoTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        boolean result = target.getPreviousSaldoTemp(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getSaldoContractResourceTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Integer arg2 = (Integer) in.read_value(Integer.class);
        int arg3 = in.read_long();
        BigDecimal[] result = target.getSaldoContractResourceTemp(arg0, arg1, arg2, arg3);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(cast_array(result),BigDecimal[].class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getSaldoContractTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        BigDecimal result = target.getSaldoContractTemp(arg0, arg1);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream isMemberBeelineTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        OrganizationAccessBean arg1 = (OrganizationAccessBean) in.read_value(OrganizationAccessBean.class);
        boolean result = target.isMemberBeelineTemp(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream linkCharge2PayTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Integer arg2 = (Integer) in.read_value(Integer.class);
        boolean result = target.linkCharge2PayTemp(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setChargesRURRateTemp(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        int arg1 = in.read_long();
        boolean result = target.setChargesRURRateTemp(arg0, arg1);
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
