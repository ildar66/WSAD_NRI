// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Enumeration;
import javax.ejb.CreateException;
import javax.ejb.EJBMetaData;
import javax.ejb.FinderException;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.UnknownException;

public class _EJSRemoteCMPContractHome_f0f90933_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPContractHome_f0f90933 target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.ContractHome:0000000000000000", 
        "RMI:javax.ejb.EJBHome:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPContractHome_f0f90933) target;
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
                case 12: 
                    if (method.equals("create__long")) {
                        return create__long(in, reply);
                    }
                case 15: 
                    if (method.equals("_get_homeHandle")) {
                        return _get_homeHandle(in, reply);
                    }
                case 16: 
                    if (method.equals("findByPrimaryKey")) {
                        return findByPrimaryKey(in, reply);
                    } else if (method.equals("_get_EJBMetaData")) {
                        return _get_EJBMetaData(in, reply);
                    }
                case 17: 
                    if (method.equals("findContractByQBE")) {
                        return findContractByQBE(in, reply);
                    }
                case 18: 
                    if (method.equals("findContractByQBE2")) {
                        return findContractByQBE2(in, reply);
                    } else if (method.equals("findContractByQBE3")) {
                        return findContractByQBE3(in, reply);
                    }
                case 22: 
                    if (method.equals("findContractByCurrency")) {
                        return findContractByCurrency(in, reply);
                    }
                case 24: 
                    if (method.equals("remove__java_lang_Object")) {
                        return remove__java_lang_Object(in, reply);
                    } else if (method.equals("remove__javax_ejb_Handle")) {
                        return remove__javax_ejb_Handle(in, reply);
                    } else if (method.equals("findContractBySupplyType")) {
                        return findContractBySupplyType(in, reply);
                    }
                case 26: 
                    if (method.equals("findWorkedContractByWorker")) {
                        return findWorkedContractByWorker(in, reply);
                    }
                case 27: 
                    if (method.equals("findContractByBaseAgreement")) {
                        return findContractByBaseAgreement(in, reply);
                    }
                case 34: 
                    if (method.equals("findControlledContractByController")) {
                        return findControlledContractByController(in, reply);
                    }
                case 259: 
                    if (method.equals("create__long__java_lang_Integer__java_sql_Date__long__CORBA_WStringValue__CORBA_WStringValue__java_lang_Integer__CORBA_WStringValue__java_lang_Integer__java_lang_Integer__java_sql_Date__java_sql_Date__java_math_BigDecimal__java_lang_Integer__java_lang_Integer")) {
                        return create__long__java_lang_Integer__java_sql_Date__long__CORBA_WStringValue__CORBA_WStringValue__java_lang_Integer__CORBA_WStringValue__java_lang_Integer__java_lang_Integer__java_sql_Date__java_sql_Date__java_math_BigDecimal__java_lang_Integer__java_lang_Integer(in, reply);
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
    
    private org.omg.CORBA.portable.OutputStream _get_EJBMetaData(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        EJBMetaData result = target.getEJBMetaData();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,EJBMetaData.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_homeHandle(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        HomeHandle result = target.getHomeHandle();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        Util.writeAbstractObject(out,result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream remove__java_lang_Object(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Object arg0 = Util.readAny(in);
        try {
            target.remove(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream remove__javax_ejb_Handle(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Handle arg0 = (Handle) in.read_abstract_interface(Handle.class);
        try {
            target.remove(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream create__long(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Contract result;
        try {
            result = target.create(arg0);
        } catch (CreateException ex) {
            String id = "IDL:javax/ejb/CreateEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,CreateException.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        Util.writeRemoteObject(out,result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream create__long__java_lang_Integer__java_sql_Date__long__CORBA_WStringValue__CORBA_WStringValue__java_lang_Integer__CORBA_WStringValue__java_lang_Integer__java_lang_Integer__java_sql_Date__java_sql_Date__java_math_BigDecimal__java_lang_Integer__java_lang_Integer(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Date arg2 = (Date) in.read_value(Date.class);
        int arg3 = in.read_long();
        String arg4 = (String) in.read_value(String.class);
        String arg5 = (String) in.read_value(String.class);
        Integer arg6 = (Integer) in.read_value(Integer.class);
        String arg7 = (String) in.read_value(String.class);
        Integer arg8 = (Integer) in.read_value(Integer.class);
        Integer arg9 = (Integer) in.read_value(Integer.class);
        Date arg10 = (Date) in.read_value(Date.class);
        Date arg11 = (Date) in.read_value(Date.class);
        BigDecimal arg12 = (BigDecimal) in.read_value(BigDecimal.class);
        Integer arg13 = (Integer) in.read_value(Integer.class);
        Integer arg14 = (Integer) in.read_value(Integer.class);
        Contract result;
        try {
            result = target.create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
        } catch (CreateException ex) {
            String id = "IDL:javax/ejb/CreateEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,CreateException.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        Util.writeRemoteObject(out,result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findByPrimaryKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        DocumentKey arg0 = (DocumentKey) in.read_value(DocumentKey.class);
        Contract result;
        try {
            result = target.findByPrimaryKey(arg0);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        Util.writeRemoteObject(out,result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findContractByBaseAgreement(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BaseAgreementKey arg0 = (BaseAgreementKey) in.read_value(BaseAgreementKey.class);
        Enumeration result;
        try {
            result = target.findContractByBaseAgreement(arg0);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findContractByCurrency(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        CurrencyKey arg0 = (CurrencyKey) in.read_value(CurrencyKey.class);
        Enumeration result;
        try {
            result = target.findContractByCurrency(arg0);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findContractByQBE(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Boolean arg1 = (Boolean) in.read_value(Boolean.class);
        Integer arg2 = (Integer) in.read_value(Integer.class);
        Boolean arg3 = (Boolean) in.read_value(Boolean.class);
        Integer arg4 = (Integer) in.read_value(Integer.class);
        Boolean arg5 = (Boolean) in.read_value(Boolean.class);
        Integer arg6 = (Integer) in.read_value(Integer.class);
        Date arg7 = (Date) in.read_value(Date.class);
        Date arg8 = (Date) in.read_value(Date.class);
        Boolean arg9 = (Boolean) in.read_value(Boolean.class);
        String arg10 = (String) in.read_value(String.class);
        Integer arg11 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findContractByQBE(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findContractByQBE2(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        Integer arg3 = (Integer) in.read_value(Integer.class);
        Boolean arg4 = (Boolean) in.read_value(Boolean.class);
        Integer arg5 = (Integer) in.read_value(Integer.class);
        String arg6 = (String) in.read_value(String.class);
        Integer arg7 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findContractByQBE2(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findContractByQBE3(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Boolean arg1 = (Boolean) in.read_value(Boolean.class);
        Integer arg2 = (Integer) in.read_value(Integer.class);
        Boolean arg3 = (Boolean) in.read_value(Boolean.class);
        Integer arg4 = (Integer) in.read_value(Integer.class);
        Boolean arg5 = (Boolean) in.read_value(Boolean.class);
        Integer arg6 = (Integer) in.read_value(Integer.class);
        Date arg7 = (Date) in.read_value(Date.class);
        Date arg8 = (Date) in.read_value(Date.class);
        Boolean arg9 = (Boolean) in.read_value(Boolean.class);
        String arg10 = (String) in.read_value(String.class);
        Integer arg11 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findContractByQBE3(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findContractBySupplyType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SupplyTypeKey arg0 = (SupplyTypeKey) in.read_value(SupplyTypeKey.class);
        Enumeration result;
        try {
            result = target.findContractBySupplyType(arg0);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findControlledContractByController(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        WorkerKey arg0 = (WorkerKey) in.read_value(WorkerKey.class);
        Enumeration result;
        try {
            result = target.findControlledContractByController(arg0);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findWorkedContractByWorker(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        WorkerKey arg0 = (WorkerKey) in.read_value(WorkerKey.class);
        Enumeration result;
        try {
            result = target.findWorkedContractByWorker(arg0);
        } catch (FinderException ex) {
            String id = "IDL:javax/ejb/FinderEx:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,FinderException.class);
            return out;
        }
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value((Serializable)result,Enumeration.class);
        return out;
    }
}
