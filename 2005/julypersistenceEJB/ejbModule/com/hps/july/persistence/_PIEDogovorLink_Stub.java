// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.util.Hashtable;
import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Stub;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.RemarshalException;
import org.omg.CORBA.portable.ServantObject;

public class _PIEDogovorLink_Stub extends Stub implements PIEDogovorLink {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.PIEDogovorLink:0000000000000000", 
        "RMI:com.ibm.ivj.ejb.runtime.CopyHelper:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000"
    };
    
    public String[] _ids() { 
        return _type_ids;
    }
    
    public Hashtable _copyFromEJB() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("J_copyFromEJB", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Hashtable) in.read_value(Hashtable.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return _copyFromEJB();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("J_copyFromEJB",com.ibm.ivj.ejb.runtime.CopyHelper.class);
            if (so == null) {
                return _copyFromEJB();
            }
            try {
                Hashtable result = ((com.ibm.ivj.ejb.runtime.CopyHelper)so.servant)._copyFromEJB();
                return (Hashtable)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public void _copyToEJB(Hashtable arg0) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("J_copyToEJB", true);
                    out.write_value(arg0,Hashtable.class);
                    _invoke(out);
                    return;
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    _copyToEJB(arg0);
                    return;
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("J_copyToEJB",com.ibm.ivj.ejb.runtime.CopyHelper.class);
            if (so == null) {
                _copyToEJB(arg0);
                return;
            }
            try {
                Hashtable arg0Copy = (Hashtable) Util.copyObject(arg0,_orb());
                ((com.ibm.ivj.ejb.runtime.CopyHelper)so.servant)._copyToEJB(arg0Copy);
                return;
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public EJBHome getEJBHome() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_EJBHome", true);
                    in = _invoke(out);
                    return (EJBHome) in.read_Object(EJBHome.class);
                } catch (ApplicationException ex) {
                    in = ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getEJBHome();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_EJBHome",javax.ejb.EJBObject.class);
            if (so == null) {
                return getEJBHome();
            }
            try {
                EJBHome result = ((javax.ejb.EJBObject)so.servant).getEJBHome();
                return (EJBHome)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public Handle getHandle() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_handle", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Handle) in.read_abstract_interface(Handle.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getHandle();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_handle",javax.ejb.EJBObject.class);
            if (so == null) {
                return getHandle();
            }
            try {
                Handle result = ((javax.ejb.EJBObject)so.servant).getHandle();
                return (Handle)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public Object getPrimaryKey() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_primaryKey", true);
                    in = _invoke(out);
                    return Util.readAny(in);
                } catch (ApplicationException ex) {
                    in = ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getPrimaryKey();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_primaryKey",javax.ejb.EJBObject.class);
            if (so == null) {
                return getPrimaryKey();
            }
            try {
                Object result = ((javax.ejb.EJBObject)so.servant).getPrimaryKey();
                return (Object)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public boolean isIdentical(EJBObject arg0) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("isIdentical", true);
                    Util.writeRemoteObject(out,arg0);
                    in = _invoke(out);
                    return in.read_boolean();
                } catch (ApplicationException ex) {
                    in = ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return isIdentical(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("isIdentical",javax.ejb.EJBObject.class);
            if (so == null) {
                return isIdentical(arg0);
            }
            try {
                EJBObject arg0Copy = (EJBObject) Util.copyObject(arg0,_orb());
                return ((javax.ejb.EJBObject)so.servant).isIdentical(arg0Copy);
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public void remove() throws RemoteException, RemoveException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("remove", true);
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
                    remove();
                    return;
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("remove",javax.ejb.EJBObject.class);
            if (so == null) {
                remove();
                return;
            }
            try {
                ((javax.ejb.EJBObject)so.servant).remove();
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
    
    public int getIddogovornri() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_iddogovornri", true);
                    in = _invoke(out);
                    return in.read_long();
                } catch (ApplicationException ex) {
                    in = ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getIddogovornri();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_iddogovornri",com.hps.july.persistence.PIEDogovorLink.class);
            if (so == null) {
                return getIddogovornri();
            }
            try {
                return ((com.hps.july.persistence.PIEDogovorLink)so.servant).getIddogovornri();
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public String getIddogovorplatinum() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_iddogovorplatinum", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (String) in.read_value(String.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getIddogovorplatinum();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_iddogovorplatinum",com.hps.july.persistence.PIEDogovorLink.class);
            if (so == null) {
                return getIddogovorplatinum();
            }
            try {
                return ((com.hps.july.persistence.PIEDogovorLink)so.servant).getIddogovorplatinum();
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public int getOwner() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_owner", true);
                    in = _invoke(out);
                    return in.read_long();
                } catch (ApplicationException ex) {
                    in = ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getOwner();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_owner",com.hps.july.persistence.PIEDogovorLink.class);
            if (so == null) {
                return getOwner();
            }
            try {
                return ((com.hps.july.persistence.PIEDogovorLink)so.servant).getOwner();
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public String getTypedogovornri() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_typedogovornri", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (String) in.read_value(String.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getTypedogovornri();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_typedogovornri",com.hps.july.persistence.PIEDogovorLink.class);
            if (so == null) {
                return getTypedogovornri();
            }
            try {
                return ((com.hps.july.persistence.PIEDogovorLink)so.servant).getTypedogovornri();
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public void setIddogovorplatinum(String arg0) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("_set_iddogovorplatinum", true);
                    out.write_value(arg0,String.class);
                    _invoke(out);
                    return;
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    setIddogovorplatinum(arg0);
                    return;
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_set_iddogovorplatinum",com.hps.july.persistence.PIEDogovorLink.class);
            if (so == null) {
                setIddogovorplatinum(arg0);
                return;
            }
            try {
                ((com.hps.july.persistence.PIEDogovorLink)so.servant).setIddogovorplatinum(arg0);
                return;
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public void setOwner(int arg0) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_set_owner", true);
                    out.write_long(arg0);
                    _invoke(out);
                    return;
                } catch (ApplicationException ex) {
                    in = ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    setOwner(arg0);
                    return;
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_set_owner",com.hps.july.persistence.PIEDogovorLink.class);
            if (so == null) {
                setOwner(arg0);
                return;
            }
            try {
                ((com.hps.july.persistence.PIEDogovorLink)so.servant).setOwner(arg0);
                return;
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
}
