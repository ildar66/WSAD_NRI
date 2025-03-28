// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.arenda.sessionbean;

import java.io.Serializable;
import java.math.BigDecimal;
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

public class _EJSRemoteStatelessJournal_408185ce_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteStatelessJournal_408185ce target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.arenda.sessionbean.Journal:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteStatelessJournal_408185ce) target;
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
                case 7: 
                    if (method.equals("taskEnd")) {
                        return taskEnd(in, reply);
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
                    }
                case 35: 
                    if (method.equals("taskStart__long__CORBA_WStringValue")) {
                        return taskStart__long__CORBA_WStringValue(in, reply);
                    }
                case 61: 
                    if (method.equals("addMsgInJournal__long__CORBA_WStringValue__CORBA_WStringValue")) {
                        return addMsgInJournal__long__CORBA_WStringValue__CORBA_WStringValue(in, reply);
                    }
                case 105: 
                    if (method.equals("taskStart__long__CORBA_WStringValue__java_util_Date__java_util_Date__java_lang_Integer__java_lang_Integer")) {
                        return taskStart__long__CORBA_WStringValue__java_util_Date__java_util_Date__java_lang_Integer__java_lang_Integer(in, reply);
                    }
                case 171: 
                    if (method.equals("addMsgInJournal__long__CORBA_WStringValue__long__long__long__long__java_util_Date__java_util_Date__java_math_BigDecimal__java_math_BigDecimal__long__long__long__long__long")) {
                        return addMsgInJournal__long__CORBA_WStringValue__long__long__long__long__java_util_Date__java_util_Date__java_math_BigDecimal__java_math_BigDecimal__long__long__long__long__long(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream addMsgInJournal__long__CORBA_WStringValue__long__long__long__long__java_util_Date__java_util_Date__java_math_BigDecimal__java_math_BigDecimal__long__long__long__long__long(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        int arg2 = in.read_long();
        int arg3 = in.read_long();
        int arg4 = in.read_long();
        int arg5 = in.read_long();
        Date arg6 = (Date) in.read_value(Date.class);
        Date arg7 = (Date) in.read_value(Date.class);
        BigDecimal arg8 = (BigDecimal) in.read_value(BigDecimal.class);
        BigDecimal arg9 = (BigDecimal) in.read_value(BigDecimal.class);
        int arg10 = in.read_long();
        int arg11 = in.read_long();
        int arg12 = in.read_long();
        int arg13 = in.read_long();
        int arg14 = in.read_long();
        boolean result = target.addMsgInJournal(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream addMsgInJournal__long__CORBA_WStringValue__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        String arg2 = (String) in.read_value(String.class);
        boolean result = target.addMsgInJournal(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_boolean(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream taskEnd(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        target.taskEnd(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream taskStart__long__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        int result = target.taskStart(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream taskStart__long__CORBA_WStringValue__java_util_Date__java_util_Date__java_lang_Integer__java_lang_Integer(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        Date arg2 = (Date) in.read_value(Date.class);
        Date arg3 = (Date) in.read_value(Date.class);
        Integer arg4 = (Integer) in.read_value(Integer.class);
        Integer arg5 = (Integer) in.read_value(Integer.class);
        int result = target.taskStart(arg0, arg1, arg2, arg3, arg4, arg5);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
}
