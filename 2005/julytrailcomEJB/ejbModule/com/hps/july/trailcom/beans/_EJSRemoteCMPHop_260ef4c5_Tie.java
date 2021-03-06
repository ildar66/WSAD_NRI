// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.trailcom.beans;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
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

public class _EJSRemoteCMPHop_260ef4c5_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPHop_260ef4c5 target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.trailcom.beans.Hop:0000000000000000", 
        "RMI:com.ibm.ivj.ejb.runtime.CopyHelper:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPHop_260ef4c5) target;
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
                case -2060209654: 
                    if (method.equals("_get_rezerv")) {
                        return _get_rezerv(in, reply);
                    }
                case -1989747525: 
                    if (method.equals("_get_siteid_enda")) {
                        return _get_siteid_enda(in, reply);
                    }
                case -1989747524: 
                    if (method.equals("_get_siteid_endb")) {
                        return _get_siteid_endb(in, reply);
                    }
                case -1738988290: 
                    if (method.equals("_set_permstatus")) {
                        return _set_permstatus(in, reply);
                    }
                case -1550521068: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case -1275362475: 
                    if (method.equals("_get_abis_number")) {
                        return _get_abis_number(in, reply);
                    }
                case -1212520101: 
                    if (method.equals("_set_expoutdate")) {
                        return _set_expoutdate(in, reply);
                    }
                case -1078995001: 
                    if (method.equals("_set_siteid_enda")) {
                        return _set_siteid_enda(in, reply);
                    }
                case -1078995000: 
                    if (method.equals("_set_siteid_endb")) {
                        return _set_siteid_endb(in, reply);
                    }
                case -1041009326: 
                    if (method.equals("_set_beenetid")) {
                        return _set_beenetid(in, reply);
                    }
                case -1011244123: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case -934610812: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case -556939093: 
                    if (method.equals("_set_speed")) {
                        return _set_speed(in, reply);
                    }
                case -464296104: 
                    if (method.equals("_set_equipmentid_enda")) {
                        return _set_equipmentid_enda(in, reply);
                    }
                case -464296103: 
                    if (method.equals("_set_equipmentid_endb")) {
                        return _set_equipmentid_endb(in, reply);
                    }
                case -428619365: 
                    if (method.equals("secondaryAddHopLabels")) {
                        return secondaryAddHopLabels(in, reply);
                    }
                case -428416481: 
                    if (method.equals("secondarySetOpticalHop")) {
                        return secondarySetOpticalHop(in, reply);
                    }
                case -366571001: 
                    if (method.equals("addHopLabels")) {
                        return addHopLabels(in, reply);
                    }
                case -364609951: 
                    if (method.equals("_set_abis_number")) {
                        return _set_abis_number(in, reply);
                    }
                case -347082895: 
                    if (method.equals("_get_modified")) {
                        return _get_modified(in, reply);
                    }
                case -342322017: 
                    if (method.equals("_get_speed")) {
                        return _get_speed(in, reply);
                    }
                case -310946052: 
                    if (method.equals("_set_modifiedby")) {
                        return _set_modifiedby(in, reply);
                    }
                case -238274830: 
                    if (method.equals("getHopLabels")) {
                        return getHopLabels(in, reply);
                    }
                case -123404418: 
                    if (method.equals("_set_rezerv")) {
                        return _set_rezerv(in, reply);
                    }
                case -118005104: 
                    if (method.equals("_get_hopstate")) {
                        return _get_hopstate(in, reply);
                    }
                case -117982164: 
                    if (method.equals("_get_hopstype")) {
                        return _get_hopstype(in, reply);
                    }
                case -22131960: 
                    if (method.equals("_get_expindate")) {
                        return _get_expindate(in, reply);
                    }
                case 1325528: 
                    if (method.equals("secondaryAddSitedoc2Hops")) {
                        return secondaryAddSitedoc2Hops(in, reply);
                    }
                case 32747914: 
                    if (method.equals("_get_permstatus")) {
                        return _get_permstatus(in, reply);
                    }
                case 94145935: 
                    if (method.equals("_set_lease_info")) {
                        return _set_lease_info(in, reply);
                    }
                case 146627300: 
                    if (method.equals("_get_equipmentid_enda")) {
                        return _get_equipmentid_enda(in, reply);
                    }
                case 146627301: 
                    if (method.equals("_get_equipmentid_endb")) {
                        return _get_equipmentid_endb(in, reply);
                    }
                case 152879826: 
                    if (method.equals("getRrlHops2")) {
                        return getRrlHops2(in, reply);
                    }
                case 176000952: 
                    if (method.equals("J_copyToEJB")) {
                        return J_copyToEJB(in, reply);
                    }
                case 200845770: 
                    if (method.equals("secondarySetRrlHops2")) {
                        return secondarySetRrlHops2(in, reply);
                    }
                case 236056944: 
                    if (method.equals("secondaryRemoveHopLabels")) {
                        return secondaryRemoveHopLabels(in, reply);
                    }
                case 329783703: 
                    if (method.equals("_get_createdby")) {
                        return _get_createdby(in, reply);
                    }
                case 394444364: 
                    if (method.equals("_set_created")) {
                        return _set_created(in, reply);
                    }
                case 483024192: 
                    if (method.equals("_get_created")) {
                        return _get_created(in, reply);
                    }
                case 559216103: 
                    if (method.equals("_get_expoutdate")) {
                        return _get_expoutdate(in, reply);
                    }
                case 720951591: 
                    if (method.equals("getOpticalHop")) {
                        return getOpticalHop(in, reply);
                    }
                case 751999252: 
                    if (method.equals("_set_expindate")) {
                        return _set_expindate(in, reply);
                    }
                case 1103914915: 
                    if (method.equals("_set_createdby")) {
                        return _set_createdby(in, reply);
                    }
                case 1198536993: 
                    if (method.equals("getSitedoc2Hops")) {
                        return getSitedoc2Hops(in, reply);
                    }
                case 1201909733: 
                    if (method.equals("_set_modified")) {
                        return _set_modified(in, reply);
                    }
                case 1264756395: 
                    if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 1430987524: 
                    if (method.equals("_set_hopstate")) {
                        return _set_hopstate(in, reply);
                    }
                case 1431010464: 
                    if (method.equals("_set_hopstype")) {
                        return _set_hopstype(in, reply);
                    }
                case 1460790152: 
                    if (method.equals("_get_modifiedby")) {
                        return _get_modifiedby(in, reply);
                    }
                case 1574012387: 
                    if (method.equals("secondaryRemoveSitedoc2Hops")) {
                        return secondaryRemoveSitedoc2Hops(in, reply);
                    }
                case 1704965342: 
                    if (method.equals("_get_beenetid")) {
                        return _get_beenetid(in, reply);
                    }
                case 1865882139: 
                    if (method.equals("_get_lease_info")) {
                        return _get_lease_info(in, reply);
                    }
                case 1882931588: 
                    if (method.equals("removeHopLabels")) {
                        return removeHopLabels(in, reply);
                    }
                case 1944413392: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    }
                case 1957416589: 
                    if (method.equals("_get_hopsid")) {
                        return _get_hopsid(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream addHopLabels(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        HopLabel arg0 = (HopLabel) in.read_Object(HopLabel.class);
        target.addHopLabels(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_abis_number(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getAbis_number();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_beenetid(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getBeenetid();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_created(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Timestamp result = target.getCreated();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Timestamp.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_createdby(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getCreatedby();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_equipmentid_enda(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int result = target.getEquipmentid_enda();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_equipmentid_endb(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int result = target.getEquipmentid_endb();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_expindate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date result = target.getExpindate();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Date.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_expoutdate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date result = target.getExpoutdate();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Date.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getHopLabels(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.getHopLabels();
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
    
    private org.omg.CORBA.portable.OutputStream _get_hopsid(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int result = target.getHopsid();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_hopstate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getHopstate();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_hopstype(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getHopstype();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_lease_info(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getLease_info();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_modified(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Timestamp result = target.getModified();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Timestamp.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_modifiedby(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getModifiedby();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getOpticalHop(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        OpticalHop result;
        try {
            result = target.getOpticalHop();
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
    
    private org.omg.CORBA.portable.OutputStream _get_permstatus(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getPermstatus();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_rezerv(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getRezerv();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getRrlHops2(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        RRLHops2 result;
        try {
            result = target.getRrlHops2();
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
    
    private org.omg.CORBA.portable.OutputStream getSitedoc2Hops(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.getSitedoc2Hops();
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
    
    private org.omg.CORBA.portable.OutputStream _get_siteid_enda(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getSiteid_enda();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_siteid_endb(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer result = target.getSiteid_endb();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Integer.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_speed(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getSpeed();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream removeHopLabels(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        HopLabel arg0 = (HopLabel) in.read_Object(HopLabel.class);
        target.removeHopLabels(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryAddHopLabels(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        HopLabel arg0 = (HopLabel) in.read_Object(HopLabel.class);
        target.secondaryAddHopLabels(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryAddSitedoc2Hops(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Sitedoc2Hops arg0 = (Sitedoc2Hops) in.read_Object(Sitedoc2Hops.class);
        target.secondaryAddSitedoc2Hops(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryRemoveHopLabels(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        HopLabel arg0 = (HopLabel) in.read_Object(HopLabel.class);
        target.secondaryRemoveHopLabels(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryRemoveSitedoc2Hops(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Sitedoc2Hops arg0 = (Sitedoc2Hops) in.read_Object(Sitedoc2Hops.class);
        target.secondaryRemoveSitedoc2Hops(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetOpticalHop(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        OpticalHop arg0 = (OpticalHop) in.read_Object(OpticalHop.class);
        target.secondarySetOpticalHop(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetRrlHops2(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        RRLHops2 arg0 = (RRLHops2) in.read_Object(RRLHops2.class);
        target.secondarySetRrlHops2(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_abis_number(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setAbis_number(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_beenetid(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setBeenetid(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_created(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Timestamp arg0 = (Timestamp) in.read_value(Timestamp.class);
        target.setCreated(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_createdby(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setCreatedby(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_equipmentid_enda(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        target.setEquipmentid_enda(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_equipmentid_endb(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        target.setEquipmentid_endb(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_expindate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date arg0 = (Date) in.read_value(Date.class);
        target.setExpindate(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_expoutdate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date arg0 = (Date) in.read_value(Date.class);
        target.setExpoutdate(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_hopstate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setHopstate(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_hopstype(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setHopstype(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_lease_info(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setLease_info(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_modified(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Timestamp arg0 = (Timestamp) in.read_value(Timestamp.class);
        target.setModified(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_modifiedby(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setModifiedby(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_permstatus(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setPermstatus(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_rezerv(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setRezerv(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_siteid_enda(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setSiteid_enda(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_siteid_endb(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Integer arg0 = (Integer) in.read_value(Integer.class);
        target.setSiteid_endb(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_speed(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setSpeed(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
}
