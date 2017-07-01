// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.FinderException;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.UnknownException;

public class _EJSRemoteCMPAccount_d70748de_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPAccount_d70748de target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.Account:0000000000000000", 
        "RMI:com.ibm.ivj.ejb.runtime.CopyHelper:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPAccount_d70748de) target;
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
            switch (method.hashCode()) {
                case -2113567025: 
                    if (method.equals("secondaryRemoveLeasePayRule4OrgAcc")) {
                        return secondaryRemoveLeasePayRule4OrgAcc(in, reply);
                    }
                case -2086250682: 
                    if (method.equals("_set_idVendorSite")) {
                        return _set_idVendorSite(in, reply);
                    }
                case -2076203351: 
                    if (method.equals("J_copyFromEJB")) {
                        return J_copyFromEJB(in, reply);
                    }
                case -1936485974: 
                    if (method.equals("secondarySetBank")) {
                        return secondarySetBank(in, reply);
                    }
                case -1868715910: 
                    if (method.equals("_get_account_")) {
                        return _get_account_(in, reply);
                    }
                case -1612559137: 
                    if (method.equals("addLeasePayOrder")) {
                        return addLeasePayOrder(in, reply);
                    }
                case -1550521068: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case -1528236580: 
                    if (method.equals("removeLeasePayOrder")) {
                        return removeLeasePayOrder(in, reply);
                    }
                case -1489535063: 
                    if (method.equals("getOrganization")) {
                        return getOrganization(in, reply);
                    }
                case -1126065549: 
                    if (method.equals("secondaryAddLeasePayOrder")) {
                        return secondaryAddLeasePayOrder(in, reply);
                    }
                case -1011244123: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case -980397615: 
                    if (method.equals("getLeasePayRule4OrgAcc")) {
                        return getLeasePayRule4OrgAcc(in, reply);
                    }
                case -934610812: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case -882604837: 
                    if (method.equals("_get_bankKey")) {
                        return _get_bankKey(in, reply);
                    }
                case -749449596: 
                    if (method.equals("_get_organizationKey")) {
                        return _get_organizationKey(in, reply);
                    }
                case -729212288: 
                    if (method.equals("_set_accountvalue")) {
                        return _set_accountvalue(in, reply);
                    }
                case -612121822: 
                    if (method.equals("_set_active")) {
                        return _set_active(in, reply);
                    }
                case -578782539: 
                    if (method.equals("setOrganization")) {
                        return setOrganization(in, reply);
                    }
                case -319723282: 
                    if (method.equals("_set_account_")) {
                        return _set_account_(in, reply);
                    }
                case -254807854: 
                    if (method.equals("_get_idVendorSite")) {
                        return _get_idVendorSite(in, reply);
                    }
                case -75665742: 
                    if (method.equals("getBank")) {
                        return getBank(in, reply);
                    }
                case 176000952: 
                    if (method.equals("J_copyToEJB")) {
                        return J_copyToEJB(in, reply);
                    }
                case 241395002: 
                    if (method.equals("secondaryAddLeasePayRule4OrgAcc")) {
                        return secondaryAddLeasePayRule4OrgAcc(in, reply);
                    }
                case 382586824: 
                    if (method.equals("secondaryRemoveLeasePayOrder")) {
                        return secondaryRemoveLeasePayOrder(in, reply);
                    }
                case 397907622: 
                    if (method.equals("addLeasePayRule4OrgAcc")) {
                        return addLeasePayRule4OrgAcc(in, reply);
                    }
                case 895375949: 
                    if (method.equals("privateSetOrganizationKey")) {
                        return privateSetOrganizationKey(in, reply);
                    }
                case 1102230540: 
                    if (method.equals("_get_accountvalue")) {
                        return _get_accountvalue(in, reply);
                    }
                case 1264756395: 
                    if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 1627751498: 
                    if (method.equals("getLeasePayOrder")) {
                        return getLeasePayOrder(in, reply);
                    }
                case 1658284452: 
                    if (method.equals("privateSetBankKey")) {
                        return privateSetBankKey(in, reply);
                    }
                case 1746040238: 
                    if (method.equals("_get_active")) {
                        return _get_active(in, reply);
                    }
                case 1944413392: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    }
                case 1984443838: 
                    if (method.equals("setBank")) {
                        return setBank(in, reply);
                    }
                case 2069310113: 
                    if (method.equals("secondarySetOrganization")) {
                        return secondarySetOrganization(in, reply);
                    }
            }
            throw new BAD_OPERATION();
        } catch (SystemException ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new UnknownException(ex);
        }
    }
    
    private org.omg.CORBA.portable.OutputStream J_copyFromEJB(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Hashtable result = target._copyFromEJB();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Hashtable.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream J_copyToEJB(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Hashtable arg0 = (Hashtable) in.read_value(Hashtable.class);
        target._copyToEJB(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
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
    
    private org.omg.CORBA.portable.OutputStream addLeasePayOrder(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayOrder arg0 = (LeasePayOrder) in.read_Object(LeasePayOrder.class);
        target.addLeasePayOrder(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream addLeasePayRule4OrgAcc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayRule arg0 = (LeasePayRule) in.read_Object(LeasePayRule.class);
        target.addLeasePayRule4OrgAcc(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_account_(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int result = target.getAccount();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_accountvalue(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getAccountvalue();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_active(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean result = target.getActive();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Boolean.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getLeasePayOrder(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.getLeasePayOrder();
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
    
    private org.omg.CORBA.portable.OutputStream getLeasePayRule4OrgAcc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.getLeasePayRule4OrgAcc();
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
    
    private org.omg.CORBA.portable.OutputStream getOrganization(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Organization result;
        try {
            result = target.getOrganization();
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
    
    private org.omg.CORBA.portable.OutputStream _get_organizationKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        OrganizationKey result = target.getOrganizationKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,OrganizationKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream privateSetOrganizationKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        OrganizationKey arg0 = (OrganizationKey) in.read_value(OrganizationKey.class);
        target.privateSetOrganizationKey(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream removeLeasePayOrder(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayOrder arg0 = (LeasePayOrder) in.read_Object(LeasePayOrder.class);
        target.removeLeasePayOrder(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryAddLeasePayOrder(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayOrder arg0 = (LeasePayOrder) in.read_Object(LeasePayOrder.class);
        target.secondaryAddLeasePayOrder(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryAddLeasePayRule4OrgAcc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayRule arg0 = (LeasePayRule) in.read_Object(LeasePayRule.class);
        target.secondaryAddLeasePayRule4OrgAcc(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryRemoveLeasePayOrder(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayOrder arg0 = (LeasePayOrder) in.read_Object(LeasePayOrder.class);
        target.secondaryRemoveLeasePayOrder(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryRemoveLeasePayRule4OrgAcc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayRule arg0 = (LeasePayRule) in.read_Object(LeasePayRule.class);
        target.secondaryRemoveLeasePayRule4OrgAcc(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetOrganization(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Organization arg0 = (Organization) in.read_Object(Organization.class);
        target.secondarySetOrganization(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_account_(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        target.setAccount(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_accountvalue(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setAccountvalue(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_active(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        target.setActive(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setOrganization(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Organization arg0 = (Organization) in.read_Object(Organization.class);
        target.setOrganization(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetBank(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Bank arg0 = (Bank) in.read_Object(Bank.class);
        target.secondarySetBank(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setBank(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Bank arg0 = (Bank) in.read_Object(Bank.class);
        target.setBank(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_bankKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getBankKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream privateSetBankKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.privateSetBankKey(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getBank(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Bank result;
        try {
            result = target.getBank();
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
    
    private org.omg.CORBA.portable.OutputStream _get_idVendorSite(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getIdVendorSite();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_idVendorSite(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setIdVendorSite(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
}
