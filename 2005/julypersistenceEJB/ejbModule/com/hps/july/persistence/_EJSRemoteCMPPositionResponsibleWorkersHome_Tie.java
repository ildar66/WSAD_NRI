// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
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

public class _EJSRemoteCMPPositionResponsibleWorkersHome_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPPositionResponsibleWorkersHome target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.PositionResponsibleWorkersHome:0000000000000000", 
        "RMI:javax.ejb.EJBHome:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPPositionResponsibleWorkersHome) target;
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
                case 8: 
                    if (method.equals("create__")) {
                        return create__(in, reply);
                    }
                case 9: 
                    if (method.equals("findByQBE")) {
                        return findByQBE(in, reply);
                    }
                case 14: 
                    if (method.equals("findByPosition")) {
                        return findByPosition(in, reply);
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
                case 21: 
                    if (method.equals("findAllOrderByCodeAsc")) {
                        return findAllOrderByCodeAsc(in, reply);
                    }
                case 22: 
                    if (method.equals("findByPositionResptype")) {
                        return findByPositionResptype(in, reply);
                    }
                case 24: 
                    if (method.equals("remove__java_lang_Object")) {
                        return remove__java_lang_Object(in, reply);
                    } else if (method.equals("remove__javax_ejb_Handle")) {
                        return remove__javax_ejb_Handle(in, reply);
                    }
                case 26: 
                    if (method.equals("findByPositionResponseType")) {
                        return findByPositionResponseType(in, reply);
                    }
                case 36: 
                    if (method.equals("findPositionResponsibleWorkersByType")) {
                        return findPositionResponsibleWorkersByType(in, reply);
                    }
                case 38: 
                    if (method.equals("findPositionResponsibleWorkersByWorker")) {
                        return findPositionResponsibleWorkersByWorker(in, reply);
                    }
                case 40: 
                    if (method.equals("findPositionResponsibleWorkersByPosition")) {
                        return findPositionResponsibleWorkersByPosition(in, reply);
                    }
                case 43: 
                    if (method.equals("findPositionResponsibleWorkerByOrganization")) {
                        return findPositionResponsibleWorkerByOrganization(in, reply);
                    }
                case 63: 
                    if (method.equals("create__java_lang_Integer__java_lang_Integer__java_lang_Integer")) {
                        return create__java_lang_Integer__java_lang_Integer__java_lang_Integer(in, reply);
                    }
                case 64: 
                    if (method.equals("create__java_lang_Integer__java_lang_Integer__CORBA_WStringValue")) {
                        return create__java_lang_Integer__java_lang_Integer__CORBA_WStringValue(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream create__(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        PositionResponsibleWorkers result;
        try {
            result = target.create();
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
    
    private org.omg.CORBA.portable.OutputStream create__java_lang_Integer__java_lang_Integer__java_lang_Integer(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Integer arg2 = (Integer) in.read_value(Integer.class);
        PositionResponsibleWorkers result;
        try {
            result = target.create(arg0, arg1, arg2);
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
    
    private org.omg.CORBA.portable.OutputStream create__java_lang_Integer__java_lang_Integer__CORBA_WStringValue(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        String arg2 = (String) in.read_value(String.class);
        PositionResponsibleWorkers result;
        try {
            result = target.create(arg0, arg1, arg2);
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
    
    private org.omg.CORBA.portable.OutputStream findAllOrderByCodeAsc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.findAllOrderByCodeAsc();
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
    
    private org.omg.CORBA.portable.OutputStream findByPosition(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findByPosition(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findByPositionResponseType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findByPositionResponseType(arg0, arg1);
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
    
    private org.omg.CORBA.portable.OutputStream findByPositionResptype(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        String arg1 = (String) in.read_value(String.class);
        Enumeration result;
        try {
            result = target.findByPositionResptype(arg0, arg1);
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
    
    private org.omg.CORBA.portable.OutputStream findByPrimaryKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        PositionResponsibleWorkersKey arg0 = (PositionResponsibleWorkersKey) in.read_value(PositionResponsibleWorkersKey.class);
        PositionResponsibleWorkers result;
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
    
    private org.omg.CORBA.portable.OutputStream findByQBE(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        Integer arg3 = (Integer) in.read_value(Integer.class);
        Integer arg4 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findByQBE(arg0, arg1, arg2, arg3, arg4);
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
    
    private org.omg.CORBA.portable.OutputStream findPositionResponsibleWorkerByOrganization(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        OrganizationKey arg0 = (OrganizationKey) in.read_value(OrganizationKey.class);
        Enumeration result;
        try {
            result = target.findPositionResponsibleWorkerByOrganization(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findPositionResponsibleWorkersByPosition(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        StoragePlaceKey arg0 = (StoragePlaceKey) in.read_value(StoragePlaceKey.class);
        Enumeration result;
        try {
            result = target.findPositionResponsibleWorkersByPosition(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findPositionResponsibleWorkersByType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ResponsibilityTypeKey arg0 = (ResponsibilityTypeKey) in.read_value(ResponsibilityTypeKey.class);
        Enumeration result;
        try {
            result = target.findPositionResponsibleWorkersByType(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findPositionResponsibleWorkersByWorker(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        WorkerKey arg0 = (WorkerKey) in.read_value(WorkerKey.class);
        Enumeration result;
        try {
            result = target.findPositionResponsibleWorkersByWorker(arg0);
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
