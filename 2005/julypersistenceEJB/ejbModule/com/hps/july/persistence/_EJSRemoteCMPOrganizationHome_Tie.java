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

public class _EJSRemoteCMPOrganizationHome_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPOrganizationHome target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.OrganizationHome:0000000000000000", 
        "RMI:javax.ejb.EJBHome:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPOrganizationHome) target;
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
                case 14: 
                    if (method.equals("findBanksByQBE")) {
                        return findBanksByQBE(in, reply);
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
                case 20: 
                    if (method.equals("findOurOrganizations")) {
                        return findOurOrganizations(in, reply);
                    }
                case 22: 
                    if (method.equals("findByInnOrderByInnAsc")) {
                        return findByInnOrderByInnAsc(in, reply);
                    } else if (method.equals("findOrganizationsByQBE")) {
                        return findOrganizationsByQBE(in, reply);
                    }
                case 23: 
                    if (method.equals("findOrganizationsByQBE2")) {
                        return findOrganizationsByQBE2(in, reply);
                    }
                case 24: 
                    if (method.equals("remove__java_lang_Object")) {
                        return remove__java_lang_Object(in, reply);
                    } else if (method.equals("remove__javax_ejb_Handle")) {
                        return remove__javax_ejb_Handle(in, reply);
                    } else if (method.equals("findByNameOrderByNameAsc")) {
                        return findByNameOrderByNameAsc(in, reply);
                    }
                case 25: 
                    if (method.equals("findOrganizationByCompany")) {
                        return findOrganizationByCompany(in, reply);
                    }
                case 28: 
                    if (method.equals("findOrganizationsByReglament")) {
                        return findOrganizationsByReglament(in, reply);
                    }
                case 29: 
                    if (method.equals("findBanksByNameOrderByNameAsc")) {
                        return findBanksByNameOrderByNameAsc(in, reply);
                    }
                case 30: 
                    if (method.equals("findOrganizationsByQBEAndGroup")) {
                        return findOrganizationsByQBEAndGroup(in, reply);
                    }
                case 34: 
                    if (method.equals("findOrganizationsButBanksByCompany")) {
                        return findOrganizationsButBanksByCompany(in, reply);
                    }
                case 37: 
                    if (method.equals("findOrganizationsByNameOrderByNameAsc")) {
                        return findOrganizationsByNameOrderByNameAsc(in, reply);
                    }
                case 42: 
                    if (method.equals("findOrganizationsButBanksByCompanyAndGroup")) {
                        return findOrganizationsButBanksByCompanyAndGroup(in, reply);
                    }
                case 46: 
                    if (method.equals("create__long__com_hps_july_persistence_Company")) {
                        return create__long__com_hps_july_persistence_Company(in, reply);
                    }
                case 108: 
                    if (method.equals("create__long__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean")) {
                        return create__long__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean(in, reply);
                    }
                case 127: 
                    if (method.equals("create__long__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean")) {
                        return create__long__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean(in, reply);
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
        Organization result;
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
    
    private org.omg.CORBA.portable.OutputStream create__long__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        Boolean arg3 = (Boolean) in.read_value(Boolean.class);
        Boolean arg4 = (Boolean) in.read_value(Boolean.class);
        Boolean arg5 = (Boolean) in.read_value(Boolean.class);
        Organization result;
        try {
            result = target.create(arg0, arg1, arg2, arg3, arg4, arg5);
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
    
    private org.omg.CORBA.portable.OutputStream findBanksByNameOrderByNameAsc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Enumeration result;
        try {
            result = target.findBanksByNameOrderByNameAsc(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findBanksByQBE(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        String arg1 = (String) in.read_value(String.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        String arg3 = (String) in.read_value(String.class);
        Integer arg4 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findBanksByQBE(arg0, arg1, arg2, arg3, arg4);
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
    
    private org.omg.CORBA.portable.OutputStream findByInnOrderByInnAsc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Enumeration result;
        try {
            result = target.findByInnOrderByInnAsc(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findByNameOrderByNameAsc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Enumeration result;
        try {
            result = target.findByNameOrderByNameAsc(arg0);
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
        OrganizationKey arg0 = (OrganizationKey) in.read_value(OrganizationKey.class);
        Organization result;
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationByCompany(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        CompanyKey arg0 = (CompanyKey) in.read_value(CompanyKey.class);
        Enumeration result;
        try {
            result = target.findOrganizationByCompany(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationsButBanksByCompany(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findOrganizationsButBanksByCompany(arg0);
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationsButBanksByCompanyAndGroup(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Boolean arg1 = (Boolean) in.read_value(Boolean.class);
        Integer arg2 = (Integer) in.read_value(Integer.class);
        Integer arg3 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findOrganizationsButBanksByCompanyAndGroup(arg0, arg1, arg2, arg3);
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationsByNameOrderByNameAsc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        Boolean arg1 = (Boolean) in.read_value(Boolean.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        Boolean arg3 = (Boolean) in.read_value(Boolean.class);
        Enumeration result;
        try {
            result = target.findOrganizationsByNameOrderByNameAsc(arg0, arg1, arg2, arg3);
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationsByQBE(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        String arg1 = (String) in.read_value(String.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        Boolean arg3 = (Boolean) in.read_value(Boolean.class);
        Boolean arg4 = (Boolean) in.read_value(Boolean.class);
        Boolean arg5 = (Boolean) in.read_value(Boolean.class);
        String arg6 = (String) in.read_value(String.class);
        Integer arg7 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findOrganizationsByQBE(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationsByQBE2(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        Boolean arg1 = (Boolean) in.read_value(Boolean.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        String arg3 = (String) in.read_value(String.class);
        Boolean arg4 = (Boolean) in.read_value(Boolean.class);
        String arg5 = (String) in.read_value(String.class);
        Boolean arg6 = (Boolean) in.read_value(Boolean.class);
        Integer arg7 = (Integer) in.read_value(Integer.class);
        Integer arg8 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findOrganizationsByQBE2(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationsByQBEAndGroup(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        String arg1 = (String) in.read_value(String.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        Boolean arg3 = (Boolean) in.read_value(Boolean.class);
        Boolean arg4 = (Boolean) in.read_value(Boolean.class);
        Boolean arg5 = (Boolean) in.read_value(Boolean.class);
        String arg6 = (String) in.read_value(String.class);
        Integer arg7 = (Integer) in.read_value(Integer.class);
        Boolean arg8 = (Boolean) in.read_value(Boolean.class);
        Integer arg9 = (Integer) in.read_value(Integer.class);
        Integer arg10 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findOrganizationsByQBEAndGroup(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
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
    
    private org.omg.CORBA.portable.OutputStream findOrganizationsByReglament(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        Integer arg1 = (Integer) in.read_value(Integer.class);
        Enumeration result;
        try {
            result = target.findOrganizationsByReglament(arg0, arg1);
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
    
    private org.omg.CORBA.portable.OutputStream findOurOrganizations(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.findOurOrganizations();
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
    
    private org.omg.CORBA.portable.OutputStream create__long__com_hps_july_persistence_Company(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        Company arg1 = (Company) in.read_Object(Company.class);
        Organization result;
        try {
            result = target.create(arg0, arg1);
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
    
    private org.omg.CORBA.portable.OutputStream create__long__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        String arg1 = (String) in.read_value(String.class);
        Boolean arg2 = (Boolean) in.read_value(Boolean.class);
        Boolean arg3 = (Boolean) in.read_value(Boolean.class);
        Boolean arg4 = (Boolean) in.read_value(Boolean.class);
        Boolean arg5 = (Boolean) in.read_value(Boolean.class);
        Boolean arg6 = (Boolean) in.read_value(Boolean.class);
        Organization result;
        try {
            result = target.create(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
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
}
