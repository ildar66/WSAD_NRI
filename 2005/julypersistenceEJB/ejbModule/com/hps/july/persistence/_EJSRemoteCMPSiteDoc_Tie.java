// Tie class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
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

public class _EJSRemoteCMPSiteDoc_Tie extends org.omg.CORBA_2_3.portable.ObjectImpl implements javax.rmi.CORBA.Tie {
    
    private EJSRemoteCMPSiteDoc target = null;
    private org.omg.CORBA.ORB orb = null;
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.SiteDoc:0000000000000000", 
        "RMI:com.ibm.ivj.ejb.runtime.CopyHelper:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000", 
        "RMI:com.ibm.websphere.csi.CSIServant:0000000000000000", 
        "RMI:com.ibm.websphere.csi.TransactionalObject:0000000000000000"
    };
    
    public void setTarget(java.rmi.Remote target) {
        this.target = (EJSRemoteCMPSiteDoc) target;
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
                case -2145570423: 
                    if (method.equals("setSiteDocType")) {
                        return setSiteDocType(in, reply);
                    }
                case -2141737626: 
                    if (method.equals("_set_blankdate")) {
                        return _set_blankdate(in, reply);
                    }
                case -2076203351: 
                    if (method.equals("J_copyFromEJB")) {
                        return J_copyFromEJB(in, reply);
                    }
                case -1709826204: 
                    if (method.equals("privateSetManKey")) {
                        return privateSetManKey(in, reply);
                    }
                case -1644506083: 
                    if (method.equals("secondarySetSiteDocType")) {
                        return secondarySetSiteDocType(in, reply);
                    }
                case -1550521068: 
                    if (method.equals("_get_EJBHome")) {
                        return _get_EJBHome(in, reply);
                    }
                case -1545437368: 
                    if (method.equals("getSitedoc2Splaces")) {
                        return getSitedoc2Splaces(in, reply);
                    }
                case -1526722571: 
                    if (method.equals("_get_blanknumber")) {
                        return _get_blanknumber(in, reply);
                    }
                case -1249356252: 
                    if (method.equals("getMan")) {
                        return getMan(in, reply);
                    }
                case -1011244123: 
                    if (method.equals("_get_primaryKey")) {
                        return _get_primaryKey(in, reply);
                    }
                case -934610812: 
                    if (method.equals("remove")) {
                        return remove(in, reply);
                    }
                case -905806440: 
                    if (method.equals("setMan")) {
                        return setMan(in, reply);
                    }
                case -651151940: 
                    if (method.equals("_get_siteDocTypeKey")) {
                        return _get_siteDocTypeKey(in, reply);
                    }
                case -615970047: 
                    if (method.equals("_set_blanknumber")) {
                        return _set_blanknumber(in, reply);
                    }
                case -570578955: 
                    if (method.equals("_get_expiredate")) {
                        return _get_expiredate(in, reply);
                    }
                case -466460307: 
                    if (method.equals("setProjectAction")) {
                        return setProjectAction(in, reply);
                    }
                case -373834219: 
                    if (method.equals("getSiteDocType")) {
                        return getSiteDocType(in, reply);
                    }
                case 20033281: 
                    if (method.equals("secondarySetProjectAction")) {
                        return secondarySetProjectAction(in, reply);
                    }
                case 85419955: 
                    if (method.equals("secondaryAddSiteDocFiles")) {
                        return secondaryAddSiteDocFiles(in, reply);
                    }
                case 147186502: 
                    if (method.equals("secondaryRemoveSitedoc2Splaces")) {
                        return secondaryRemoveSitedoc2Splaces(in, reply);
                    }
                case 176000952: 
                    if (method.equals("J_copyToEJB")) {
                        return J_copyToEJB(in, reply);
                    }
                case 316288451: 
                    if (method.equals("_set_comment")) {
                        return _set_comment(in, reply);
                    }
                case 404868279: 
                    if (method.equals("_get_comment")) {
                        return _get_comment(in, reply);
                    }
                case 444065583: 
                    if (method.equals("privateSetProjectActionKey")) {
                        return privateSetProjectActionKey(in, reply);
                    }
                case 944108182: 
                    if (method.equals("_get_sitedoc_")) {
                        return _get_sitedoc_(in, reply);
                    }
                case 994081240: 
                    if (method.equals("_get_projectActionKey")) {
                        return _get_projectActionKey(in, reply);
                    }
                case 1264756395: 
                    if (method.equals("isIdentical")) {
                        return isIdentical(in, reply);
                    }
                case 1282631420: 
                    if (method.equals("getSiteDocFiles")) {
                        return getSiteDocFiles(in, reply);
                    }
                case 1364982521: 
                    if (method.equals("getProjectAction")) {
                        return getProjectAction(in, reply);
                    }
                case 1379098458: 
                    if (method.equals("_get_blankdate")) {
                        return _get_blankdate(in, reply);
                    }
                case 1658106814: 
                    if (method.equals("secondaryRemoveSiteDocFiles")) {
                        return secondaryRemoveSiteDocFiles(in, reply);
                    }
                case 1732294599: 
                    if (method.equals("addSiteDocFiles")) {
                        return addSiteDocFiles(in, reply);
                    }
                case 1944413392: 
                    if (method.equals("_get_handle")) {
                        return _get_handle(in, reply);
                    }
                case 1952652137: 
                    if (method.equals("_set_expiredate")) {
                        return _set_expiredate(in, reply);
                    }
                case 2015753260: 
                    if (method.equals("secondarySetMan")) {
                        return secondarySetMan(in, reply);
                    }
                case 2031202097: 
                    if (method.equals("secondaryAddSitedoc2Splaces")) {
                        return secondaryAddSitedoc2Splaces(in, reply);
                    }
                case 2034306259: 
                    if (method.equals("privateSetSiteDocTypeKey")) {
                        return privateSetSiteDocTypeKey(in, reply);
                    }
                case 2087534925: 
                    if (method.equals("_get_manKey")) {
                        return _get_manKey(in, reply);
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
    
    private org.omg.CORBA.portable.OutputStream addSiteDocFiles(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocFile arg0 = (SiteDocFile) in.read_Object(SiteDocFile.class);
        target.addSiteDocFiles(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_blankdate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date result = target.getBlankdate();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Date.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_blanknumber(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getBlanknumber();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_comment(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String result = target.getComment();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,String.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_expiredate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date result = target.getExpiredate();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,Date.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getMan(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        People result;
        try {
            result = target.getMan();
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
    
    private org.omg.CORBA.portable.OutputStream _get_manKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        PeopleKey result = target.getManKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,PeopleKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getProjectAction(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ProjectAction result;
        try {
            result = target.getProjectAction();
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
    
    private org.omg.CORBA.portable.OutputStream _get_projectActionKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ProjectActionKey result = target.getProjectActionKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,ProjectActionKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _get_sitedoc_(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        int result = target.getSitedoc();
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        out.write_long(result);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream getSitedoc2Splaces(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.getSitedoc2Splaces();
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
    
    private org.omg.CORBA.portable.OutputStream getSiteDocFiles(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Enumeration result;
        try {
            result = target.getSiteDocFiles();
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
    
    private org.omg.CORBA.portable.OutputStream getSiteDocType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocType result;
        try {
            result = target.getSiteDocType();
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
    
    private org.omg.CORBA.portable.OutputStream _get_siteDocTypeKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocTypeKey result = target.getSiteDocTypeKey();
        org.omg.CORBA_2_3.portable.OutputStream out = 
            (org.omg.CORBA_2_3.portable.OutputStream) reply.createReply();
        out.write_value(result,SiteDocTypeKey.class);
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream privateSetManKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        PeopleKey arg0 = (PeopleKey) in.read_value(PeopleKey.class);
        target.privateSetManKey(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream privateSetProjectActionKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ProjectActionKey arg0 = (ProjectActionKey) in.read_value(ProjectActionKey.class);
        target.privateSetProjectActionKey(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream privateSetSiteDocTypeKey(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocTypeKey arg0 = (SiteDocTypeKey) in.read_value(SiteDocTypeKey.class);
        target.privateSetSiteDocTypeKey(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryAddSitedoc2Splaces(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Sitedoc2Splace arg0 = (Sitedoc2Splace) in.read_Object(Sitedoc2Splace.class);
        target.secondaryAddSitedoc2Splaces(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryAddSiteDocFiles(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocFile arg0 = (SiteDocFile) in.read_Object(SiteDocFile.class);
        target.secondaryAddSiteDocFiles(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryRemoveSitedoc2Splaces(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Sitedoc2Splace arg0 = (Sitedoc2Splace) in.read_Object(Sitedoc2Splace.class);
        target.secondaryRemoveSitedoc2Splaces(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondaryRemoveSiteDocFiles(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocFile arg0 = (SiteDocFile) in.read_Object(SiteDocFile.class);
        target.secondaryRemoveSiteDocFiles(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetMan(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        People arg0 = (People) in.read_Object(People.class);
        target.secondarySetMan(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetProjectAction(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ProjectAction arg0 = (ProjectAction) in.read_Object(ProjectAction.class);
        target.secondarySetProjectAction(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream secondarySetSiteDocType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocType arg0 = (SiteDocType) in.read_Object(SiteDocType.class);
        target.secondarySetSiteDocType(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_blankdate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date arg0 = (Date) in.read_value(Date.class);
        target.setBlankdate(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_blanknumber(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setBlanknumber(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_comment(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        String arg0 = (String) in.read_value(String.class);
        target.setComment(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream _set_expiredate(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        Date arg0 = (Date) in.read_value(Date.class);
        target.setExpiredate(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setMan(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        People arg0 = (People) in.read_Object(People.class);
        target.setMan(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setProjectAction(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        ProjectAction arg0 = (ProjectAction) in.read_Object(ProjectAction.class);
        target.setProjectAction(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
    
    private org.omg.CORBA.portable.OutputStream setSiteDocType(org.omg.CORBA_2_3.portable.InputStream in , org.omg.CORBA.portable.ResponseHandler reply) throws Throwable {
        SiteDocType arg0 = (SiteDocType) in.read_Object(SiteDocType.class);
        target.setSiteDocType(arg0);
        org.omg.CORBA.portable.OutputStream out = reply.createReply();
        return out;
    }
}
