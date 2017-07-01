// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
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

public class _EJSRemoteCMPContrAddInfo_bfd683b7_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPContrAddInfo_bfd683b7 target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.ContrAddInfo:0000000000000000", 
        "RMI:com.ibm.ivj.ejb.runtime.CopyHelper:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPContrAddInfo_bfd683b7) target;
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
                case -1990873659: 
                    if (method.equals("addContrParams")) {
                        return addContrParams(in, reply);
                    }
                case -1883759988: 
                    if (method.equals("_get_acc_load")) {
                        return _get_acc_load(in, reply);
                    }
                case -1714492668: 
                    if (method.equals("_set_load_max_day")) {
                        return _set_load_max_day(in, reply);
                    }
                case -1609532548: 
                    if (method.equals("_set_load_max_hour")) {
                        return _set_load_max_hour(in, reply);
                    }
                case -1550521068: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case -1489809319: 
                    if (method.equals("secondaryAddContrParams")) {
                        return secondaryAddContrParams(in, reply);
                    }
                case -1452275707: 
                    if (method.equals("_get_load_aint_percent")) {
                        return _get_load_aint_percent(in, reply);
                    }
                case -1436851393: 
                    if (method.equals("_get_bad_cunsr_percent")) {
                        return _get_bad_cunsr_percent(in, reply);
                    }
                case -1397315613: 
                    if (method.equals("_get_act_date")) {
                        return _get_act_date(in, reply);
                    }
                case -1181219266: 
                    if (method.equals("_set_koef_kk")) {
                        return _set_koef_kk(in, reply);
                    }
                case -1174269192: 
                    if (method.equals("_get_cap_use_percent")) {
                        return _get_cap_use_percent(in, reply);
                    }
                case -1092639438: 
                    if (method.equals("_get_koef_kk")) {
                        return _get_koef_kk(in, reply);
                    }
                case -1011244123: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case -934610812: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case -851298482: 
                    if (method.equals("_set_conn_lost_avg")) {
                        return _set_conn_lost_avg(in, reply);
                    }
                case -669379728: 
                    if (method.equals("_get_load_max_hour")) {
                        return _get_load_max_hour(in, reply);
                    }
                case -654548867: 
                    if (method.equals("_set_ss7_load_avg")) {
                        return _set_ss7_load_avg(in, reply);
                    }
                case -519923330: 
                    if (method.equals("_get_bad_cunssr_percent")) {
                        return _get_bad_cunssr_percent(in, reply);
                    }
                case -334767360: 
                    if (method.equals("_set_acc_load")) {
                        return _set_acc_load(in, reply);
                    }
                case 88854338: 
                    if (method.equals("_get_conn_lost_avg")) {
                        return _get_conn_lost_avg(in, reply);
                    }
                case 116950160: 
                    if (method.equals("_get_load_max_day")) {
                        return _get_load_max_day(in, reply);
                    }
                case 176000952: 
                    if (method.equals("J_copyToEJB")) {
                        return J_copyToEJB(in, reply);
                    }
                case 339680146: 
                    if (method.equals("getController")) {
                        return getController(in, reply);
                    }
                case 536419298: 
                    if (method.equals("_get_traf_aint")) {
                        return _get_traf_aint(in, reply);
                    }
                case 793204978: 
                    if (method.equals("_set_bad_cunssr_percent")) {
                        return _set_bad_cunssr_percent(in, reply);
                    }
                case 1042662384: 
                    if (method.equals("getContrParams")) {
                        return getContrParams(in, reply);
                    }
                case 1083935249: 
                    if (method.equals("_set_load_aint_percent")) {
                        return _set_load_aint_percent(in, reply);
                    }
                case 1099359563: 
                    if (method.equals("_set_bad_cunsr_percent")) {
                        return _set_bad_cunsr_percent(in, reply);
                    }
                case 1176893961: 
                    if (method.equals("_get_ss7_load_avg")) {
                        return _get_ss7_load_avg(in, reply);
                    }
                case 1264756395: 
                    if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 1280084347: 
                    if (method.equals("_get_controllerKey")) {
                        return _get_controllerKey(in, reply);
                    }
                case 1310550510: 
                    if (method.equals("_set_traf_aint")) {
                        return _set_traf_aint(in, reply);
                    }
                case 1576970244: 
                    if (method.equals("_set_cap_use_percent")) {
                        return _set_cap_use_percent(in, reply);
                    }
                case 1608963822: 
                    if (method.equals("secondaryRemoveContrParams")) {
                        return secondaryRemoveContrParams(in, reply);
                    }
                case 1944413392: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream addContrParams(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ContrParams arg0 = (ContrParams) in.read_Object(ContrParams.class);
        target.addContrParams(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_acc_load(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getAcc_load();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_act_date(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date result = target.getAct_date();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Date.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_bad_cunsr_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getBad_cunsr_percent();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_bad_cunssr_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getBad_cunssr_percent();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_cap_use_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getCap_use_percent();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_conn_lost_avg(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getConn_lost_avg();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getController(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Controller result;
        try {
            result = target.getController();
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
    
    private org.omg.CORBA.portable.OutputStream _get_controllerKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        StoragePlaceKey result = target.getControllerKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,StoragePlaceKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getContrParams(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.getContrParams();
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
    
    private org.omg.CORBA.portable.OutputStream _get_koef_kk(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getKoef_kk();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_load_aint_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getLoad_aint_percent();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_load_max_day(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getLoad_max_day();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_load_max_hour(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getLoad_max_hour();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_ss7_load_avg(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal result = target.getSs7_load_avg();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,BigDecimal.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_traf_aint(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getTraf_aint();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryAddContrParams(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ContrParams arg0 = (ContrParams) in.read_Object(ContrParams.class);
        target.secondaryAddContrParams(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryRemoveContrParams(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ContrParams arg0 = (ContrParams) in.read_Object(ContrParams.class);
        target.secondaryRemoveContrParams(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_acc_load(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setAcc_load(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_bad_cunsr_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setBad_cunsr_percent(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_bad_cunssr_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setBad_cunssr_percent(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_cap_use_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setCap_use_percent(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_conn_lost_avg(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setConn_lost_avg(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_koef_kk(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setKoef_kk(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_load_aint_percent(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setLoad_aint_percent(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_load_max_day(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setLoad_max_day(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_load_max_hour(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setLoad_max_hour(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_ss7_load_avg(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        BigDecimal arg0 = (BigDecimal) in.read_value(BigDecimal.class);
        target.setSs7_load_avg(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_traf_aint(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setTraf_aint(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
}
