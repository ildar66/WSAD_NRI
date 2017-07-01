// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
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

public class _EJSRemoteCMPLeaseDNOP_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPLeaseDNOP target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.LeaseDNOP:0000000000000000", 
        "RMI:com.ibm.ivj.ejb.runtime.CopyHelper:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPLeaseDNOP) target;
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
                case -2076203351: 
                    if (method.equals("J_copyFromEJB")) {
                        return J_copyFromEJB(in, reply);
                    }
                case -2051350228: 
                    if (method.equals("privateSetActKey")) {
                        return privateSetActKey(in, reply);
                    }
                case -2022482237: 
                    if (method.equals("_get_source")) {
                        return _get_source(in, reply);
                    }
                case -1550521068: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case -1249367716: 
                    if (method.equals("getAct")) {
                        return getAct(in, reply);
                    }
                case -1193536318: 
                    if (method.equals("getLeasePayment")) {
                        return getLeasePayment(in, reply);
                    }
                case -1011244123: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case -934610812: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case -905817904: 
                    if (method.equals("setAct")) {
                        return setAct(in, reply);
                    }
                case -345609763: 
                    if (method.equals("_set_byhandchangeraterur")) {
                        return _set_byhandchangeraterur(in, reply);
                    }
                case -320821240: 
                    if (method.equals("_get_usedinact")) {
                        return _get_usedinact(in, reply);
                    }
                case -218695989: 
                    if (method.equals("_get_leasePaymentKey")) {
                        return _get_leasePaymentKey(in, reply);
                    }
                case -197066660: 
                    if (method.equals("_get_payrursum")) {
                        return _get_payrursum(in, reply);
                    }
                case -85677001: 
                    if (method.equals("_set_source")) {
                        return _set_source(in, reply);
                    }
                case 176000952: 
                    if (method.equals("J_copyToEJB")) {
                        return J_copyToEJB(in, reply);
                    }
                case 314953772: 
                    if (method.equals("_set_chargerursum")) {
                        return _set_chargerursum(in, reply);
                    }
                case 453309972: 
                    if (method.equals("_set_usedinact")) {
                        return _set_usedinact(in, reply);
                    }
                case 577064552: 
                    if (method.equals("_set_payrursum")) {
                        return _set_payrursum(in, reply);
                    }
                case 817937529: 
                    if (method.equals("_get_leaseChargeKey")) {
                        return _get_leaseChargeKey(in, reply);
                    }
                case 980547704: 
                    if (method.equals("getLeaseCharge")) {
                        return getLeaseCharge(in, reply);
                    }
                case 1173583647: 
                    if (method.equals("_set_chargerurrate")) {
                        return _set_chargerurrate(in, reply);
                    }
                case 1264756395: 
                    if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 1301206895: 
                    if (method.equals("_get_chargesum")) {
                        return _get_chargesum(in, reply);
                    }
                case 1746010901: 
                    if (method.equals("_get_actKey")) {
                        return _get_actKey(in, reply);
                    }
                case 1897085649: 
                    if (method.equals("_get_byhandchangeraterur")) {
                        return _get_byhandchangeraterur(in, reply);
                    }
                case 1944413392: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    }
                case 2015741796: 
                    if (method.equals("secondarySetAct")) {
                        return secondarySetAct(in, reply);
                    }
                case 2075338107: 
                    if (method.equals("_set_chargesum")) {
                        return _set_chargesum(in, reply);
                    }
                case 2113736467: 
                    if (method.equals("_get_chargerurrate")) {
                        return _get_chargerurrate(in, reply);
                    }
                case 2146396600: 
                    if (method.equals("_get_chargerursum")) {
                        return _get_chargerursum(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream getAct(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseMutualActNew result;
        try {
            result = target.getAct();
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
    
    private org.omg.CORBA.portable.OutputStream _get_actKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseDocumentKey result = target.getActKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,LeaseDocumentKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_byhandchangeraterur(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean result = target.getByhandchangeraterur();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Boolean.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_chargerurrate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getChargerurrate();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_chargerursum(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getChargerursum();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_chargesum(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getChargesum();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getLeaseCharge(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseCharges result;
        try {
            result = target.getLeaseCharge();
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
    
    private org.omg.CORBA.portable.OutputStream _get_leaseChargeKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseDocPositionKey result = target.getLeaseChargeKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,LeaseDocPositionKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getLeasePayment(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeasePayment result;
        try {
            result = target.getLeasePayment();
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
    
    private org.omg.CORBA.portable.OutputStream _get_leasePaymentKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseDocPositionKey result = target.getLeasePaymentKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,LeaseDocPositionKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_payrursum(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getPayrursum();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_source(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getSource();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_usedinact(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getUsedinact();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream privateSetActKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseDocumentKey arg0 = (LeaseDocumentKey) in.read_value(LeaseDocumentKey.class);
        target.privateSetActKey(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetAct(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseMutualActNew arg0 = (LeaseMutualActNew) in.read_Object(LeaseMutualActNew.class);
        target.secondarySetAct(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setAct(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        LeaseMutualActNew arg0 = (LeaseMutualActNew) in.read_Object(LeaseMutualActNew.class);
        target.setAct(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_byhandchangeraterur(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Boolean arg0 = (Boolean) in.read_value(Boolean.class);
        target.setByhandchangeraterur(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_chargerurrate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setChargerurrate(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_chargerursum(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setChargerursum(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_chargesum(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setChargesum(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_payrursum(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setPayrursum(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_source(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setSource(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_usedinact(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setUsedinact(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
}
