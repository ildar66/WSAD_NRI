// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.inventory.sessionbean;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import javax.ejb.CreateException;
import javax.ejb.EJBMetaData;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Stub;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.RemarshalException;
import org.omg.CORBA.portable.ServantObject;

public class _RealDocumentProcessorHome_Stub extends Stub implements RealDocumentProcessorHome {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.inventory.sessionbean.RealDocumentProcessorHome:0000000000000000", 
        "RMI:javax.ejb.EJBHome:0000000000000000"
    };
    
    public String[] _ids() { 
        return _type_ids;
    }
    
    public EJBMetaData getEJBMetaData() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_EJBMetaData", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (EJBMetaData) in.read_value(EJBMetaData.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getEJBMetaData();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_EJBMetaData",javax.ejb.EJBHome.class);
            if (so == null) {
                return getEJBMetaData();
            }
            try {
                EJBMetaData result = ((javax.ejb.EJBHome)so.servant).getEJBMetaData();
                return (EJBMetaData)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public HomeHandle getHomeHandle() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_homeHandle", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (HomeHandle) in.read_abstract_interface(HomeHandle.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getHomeHandle();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_homeHandle",javax.ejb.EJBHome.class);
            if (so == null) {
                return getHomeHandle();
            }
            try {
                HomeHandle result = ((javax.ejb.EJBHome)so.servant).getHomeHandle();
                return (HomeHandle)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public void remove(Object arg0) throws RemoteException, RemoveException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("remove__java_lang_Object", true);
                    Util.writeAny(out,arg0);
                    _invoke(out);
                    return;
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/RemoveEx:1.0")) {
                        throw (RemoveException) in.read_value(RemoveException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    remove(arg0);
                    return;
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("remove__java_lang_Object",javax.ejb.EJBHome.class);
            if (so == null) {
                remove(arg0);
                return;
            }
            try {
                Object arg0Copy = (Object) Util.copyObject(arg0,_orb());
                ((javax.ejb.EJBHome)so.servant).remove(arg0Copy);
                return;
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof RemoveException) {
                    throw (RemoveException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public void remove(Handle arg0) throws RemoteException, RemoveException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("remove__javax_ejb_Handle", true);
                    Util.writeAbstractObject(out,arg0);
                    _invoke(out);
                    return;
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/RemoveEx:1.0")) {
                        throw (RemoveException) in.read_value(RemoveException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    remove(arg0);
                    return;
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("remove__javax_ejb_Handle",javax.ejb.EJBHome.class);
            if (so == null) {
                remove(arg0);
                return;
            }
            try {
                Handle arg0Copy = (Handle) Util.copyObject(arg0,_orb());
                ((javax.ejb.EJBHome)so.servant).remove(arg0Copy);
                return;
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof RemoveException) {
                    throw (RemoveException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public RealDocumentProcessor create() throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("create", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (RealDocumentProcessor) in.read_Object(RealDocumentProcessor.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create",com.hps.july.inventory.sessionbean.RealDocumentProcessorHome.class);
            if (so == null) {
                return create();
            }
            try {
                RealDocumentProcessor result = ((com.hps.july.inventory.sessionbean.RealDocumentProcessorHome)so.servant).create();
                return (RealDocumentProcessor)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof CreateException) {
                    throw (CreateException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
}
