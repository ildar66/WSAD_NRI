// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence2;

import java.io.Serializable;
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

public class _EJSRemoteStatelessSitedocFacade_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteStatelessSitedocFacade target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence2.SitedocFacade:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteStatelessSitedocFacade) target;
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
                    if (method.equals("deleteRRLDoc")) {
                        return deleteRRLDoc(in, reply);
                    } else if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case 13: 
                    if (method.equals("createEtapDoc")) {
                        return createEtapDoc(in, reply);
                    } else if (method.equals("deleteEtapDoc")) {
                        return deleteEtapDoc(in, reply);
                    } else if (method.equals("updateEtapDoc")) {
                        return updateEtapDoc(in, reply);
                    }
                case 14: 
                    if (method.equals("deleteGKRCHDoc")) {
                        return deleteGKRCHDoc(in, reply);
                    }
                case 15: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case 19: 
                    if (method.equals("_get_RRLSiteDocType")) {
                        return _get_RRLSiteDocType(in, reply);
                    }
                case 21: 
                    if (method.equals("_get_GKRCHSiteDocType")) {
                        return _get_GKRCHSiteDocType(in, reply);
                    }
                case 22: 
                    if (method.equals("findRRLDocByPrimaryKey")) {
                        return findRRLDocByPrimaryKey(in, reply);
                    }
                case 23: 
                    if (method.equals("findEtapDocByPrimaryKey")) {
                        return findEtapDocByPrimaryKey(in, reply);
                    }
                case 24: 
                    if (method.equals("findGKRCHDocByPrimaryKey")) {
                        return findGKRCHDocByPrimaryKey(in, reply);
                    }
                case 57: 
                    if (method.equals("createRRLDoc__com_hps_july_persistence2_RRLDocValueObject")) {
                        return createRRLDoc__com_hps_july_persistence2_RRLDocValueObject(in, reply);
                    } else if (method.equals("updateRRLDoc__com_hps_july_persistence2_RRLDocValueObject")) {
                        return updateRRLDoc__com_hps_july_persistence2_RRLDocValueObject(in, reply);
                    }
                case 61: 
                    if (method.equals("createGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject")) {
                        return createGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject(in, reply);
                    } else if (method.equals("updateGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject")) {
                        return updateGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject(in, reply);
                    }
                case 129: 
                    if (method.equals("createRRLDoc__com_hps_july_persistence2_RRLDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject")) {
                        return createRRLDoc__com_hps_july_persistence2_RRLDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject(in, reply);
                    } else if (method.equals("updateRRLDoc__com_hps_july_persistence2_RRLDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject")) {
                        return updateRRLDoc__com_hps_july_persistence2_RRLDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject(in, reply);
                    }
                case 161: 
                    if (method.equals("createGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject__org_omg_boxedRMI_seq1_long")) {
                        return createGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject__org_omg_boxedRMI_seq1_long(in, reply);
                    } else if (method.equals("updateGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject__org_omg_boxedRMI_seq1_long")) {
                        return updateGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject__org_omg_boxedRMI_seq1_long(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream createEtapDoc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        EtapDocValueObject arg0 = (EtapDocValueObject) in.read_value(EtapDocValueObject.class);
        int[] arg1 = (int[]) in.read_value(int[].class);
        try {
            target.createEtapDoc(arg0, arg1);
        } catch (Exception ex) {
            String id = "IDL:java/lang/Ex:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,Exception.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream createGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        GKRCHDocValueObject arg0 = (GKRCHDocValueObject) in.read_value(GKRCHDocValueObject.class);
        target.createGKRCHDoc(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream createGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject__org_omg_boxedRMI_seq1_long(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        GKRCHDocValueObject arg0 = (GKRCHDocValueObject) in.read_value(GKRCHDocValueObject.class);
        DocResourceValueObject[] arg1 = (DocResourceValueObject[]) in.read_value(DocResourceValueObject[].class);
        int[] arg2 = (int[]) in.read_value(int[].class);
        target.createGKRCHDoc(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream createRRLDoc__com_hps_july_persistence2_RRLDocValueObject(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        RRLDocValueObject arg0 = (RRLDocValueObject) in.read_value(RRLDocValueObject.class);
        target.createRRLDoc(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream createRRLDoc__com_hps_july_persistence2_RRLDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        RRLDocValueObject arg0 = (RRLDocValueObject) in.read_value(RRLDocValueObject.class);
        DocResourceValueObject[] arg1 = (DocResourceValueObject[]) in.read_value(DocResourceValueObject[].class);
        target.createRRLDoc(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream deleteEtapDoc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        try {
            target.deleteEtapDoc(arg0);
        } catch (Exception ex) {
            String id = "IDL:java/lang/Ex:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,Exception.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream deleteGKRCHDoc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        try {
            target.deleteGKRCHDoc(arg0);
        } catch (Exception ex) {
            String id = "IDL:java/lang/Ex:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,Exception.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream deleteRRLDoc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        try {
            target.deleteRRLDoc(arg0);
        } catch (Exception ex) {
            String id = "IDL:java/lang/Ex:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,Exception.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findEtapDocByPrimaryKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        EtapDocValueObject result = target.findEtapDocByPrimaryKey(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,EtapDocValueObject.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findGKRCHDocByPrimaryKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        GKRCHDocValueObject result = target.findGKRCHDocByPrimaryKey(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,GKRCHDocValueObject.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream findRRLDocByPrimaryKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int arg0 = in.read_long();
        RRLDocValueObject result = target.findRRLDocByPrimaryKey(arg0);
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,RRLDocValueObject.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_GKRCHSiteDocType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int result = target.getGKRCHSiteDocType();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_RRLSiteDocType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int result = target.getRRLSiteDocType();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream updateEtapDoc(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        EtapDocValueObject arg0 = (EtapDocValueObject) in.read_value(EtapDocValueObject.class);
        int[] arg1 = (int[]) in.read_value(int[].class);
        try {
            target.updateEtapDoc(arg0, arg1);
        } catch (Exception ex) {
            String id = "IDL:java/lang/Ex:1.0";
            org.omg.CORBA_2_3.portable.OutputStream out = 
                (org.omg.CORBA_2_3.portable.OutputStream) reply.createExceptionReply();
            out.write_string(id);
            out.write_value(ex,Exception.class);
            return out;
        }
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream updateGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        GKRCHDocValueObject arg0 = (GKRCHDocValueObject) in.read_value(GKRCHDocValueObject.class);
        target.updateGKRCHDoc(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream updateGKRCHDoc__com_hps_july_persistence2_GKRCHDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject__org_omg_boxedRMI_seq1_long(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        GKRCHDocValueObject arg0 = (GKRCHDocValueObject) in.read_value(GKRCHDocValueObject.class);
        DocResourceValueObject[] arg1 = (DocResourceValueObject[]) in.read_value(DocResourceValueObject[].class);
        int[] arg2 = (int[]) in.read_value(int[].class);
        target.updateGKRCHDoc(arg0, arg1, arg2);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream updateRRLDoc__com_hps_july_persistence2_RRLDocValueObject(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        RRLDocValueObject arg0 = (RRLDocValueObject) in.read_value(RRLDocValueObject.class);
        target.updateRRLDoc(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream updateRRLDoc__com_hps_july_persistence2_RRLDocValueObject__org_omg_boxedRMI_com_hps_july_persistence2_seq1_DocResourceValueObject(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        RRLDocValueObject arg0 = (RRLDocValueObject) in.read_value(RRLDocValueObject.class);
        DocResourceValueObject[] arg1 = (DocResourceValueObject[]) in.read_value(DocResourceValueObject[].class);
        target.updateRRLDoc(arg0, arg1);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
}
