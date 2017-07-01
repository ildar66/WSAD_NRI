// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.arenda.sessionbean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.util.Date;
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

public class _Journal_Stub extends Stub implements Journal {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.arenda.sessionbean.Journal:0000000000000000", 
        "RMI:javax.ejb.EJBObject:0000000000000000"
    };
    
    public String[] _ids() { 
        return _type_ids;
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
    
    public boolean addMsgInJournal(int arg0, String arg1, int arg2, int arg3, int arg4, int arg5, Date arg6, Date arg7, BigDecimal arg8, BigDecimal arg9, int arg10, int arg11, int arg12, int arg13, int arg14) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("addMsgInJournal__long__CORBA_WStringValue__long__long__long__long__java_util_Date__java_util_Date__java_math_BigDecimal__java_math_BigDecimal__long__long__long__long__long", true);
                    out.write_long(arg0);
                    out.write_value(arg1,String.class);
                    out.write_long(arg2);
                    out.write_long(arg3);
                    out.write_long(arg4);
                    out.write_long(arg5);
                    out.write_value(arg6,Date.class);
                    out.write_value(arg7,Date.class);
                    out.write_value(arg8,BigDecimal.class);
                    out.write_value(arg9,BigDecimal.class);
                    out.write_long(arg10);
                    out.write_long(arg11);
                    out.write_long(arg12);
                    out.write_long(arg13);
                    out.write_long(arg14);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return in.read_boolean();
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return addMsgInJournal(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13,arg14);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("addMsgInJournal__long__CORBA_WStringValue__long__long__long__long__java_util_Date__java_util_Date__java_math_BigDecimal__java_math_BigDecimal__long__long__long__long__long",com.hps.july.arenda.sessionbean.Journal.class);
            if (so == null) {
                return addMsgInJournal(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg1,arg6,arg7,arg8,arg9},_orb());
                String arg1Copy = (String) copies[0];
                Date arg6Copy = (Date) copies[1];
                Date arg7Copy = (Date) copies[2];
                BigDecimal arg8Copy = (BigDecimal) copies[3];
                BigDecimal arg9Copy = (BigDecimal) copies[4];
                return ((com.hps.july.arenda.sessionbean.Journal)so.servant).addMsgInJournal(arg0, arg1Copy, arg2, arg3, arg4, arg5, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10, arg11, arg12, arg13, arg14);
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public boolean addMsgInJournal(int arg0, String arg1, String arg2) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("addMsgInJournal__long__CORBA_WStringValue__CORBA_WStringValue", true);
                    out.write_long(arg0);
                    out.write_value(arg1,String.class);
                    out.write_value(arg2,String.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return in.read_boolean();
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return addMsgInJournal(arg0,arg1,arg2);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("addMsgInJournal__long__CORBA_WStringValue__CORBA_WStringValue",com.hps.july.arenda.sessionbean.Journal.class);
            if (so == null) {
                return addMsgInJournal(arg0, arg1, arg2);
            }
            try {
                return ((com.hps.july.arenda.sessionbean.Journal)so.servant).addMsgInJournal(arg0, arg1, arg2);
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public void taskEnd(int arg0) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("taskEnd", true);
                    out.write_long(arg0);
                    _invoke(out);
                    return;
                } catch (ApplicationException ex) {
                    in = ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    taskEnd(arg0);
                    return;
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("taskEnd",com.hps.july.arenda.sessionbean.Journal.class);
            if (so == null) {
                taskEnd(arg0);
                return;
            }
            try {
                ((com.hps.july.arenda.sessionbean.Journal)so.servant).taskEnd(arg0);
                return;
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public int taskStart(int arg0, String arg1) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("taskStart__long__CORBA_WStringValue", true);
                    out.write_long(arg0);
                    out.write_value(arg1,String.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return in.read_long();
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return taskStart(arg0,arg1);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("taskStart__long__CORBA_WStringValue",com.hps.july.arenda.sessionbean.Journal.class);
            if (so == null) {
                return taskStart(arg0, arg1);
            }
            try {
                return ((com.hps.july.arenda.sessionbean.Journal)so.servant).taskStart(arg0, arg1);
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public int taskStart(int arg0, String arg1, Date arg2, Date arg3, Integer arg4, Integer arg5) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("taskStart__long__CORBA_WStringValue__java_util_Date__java_util_Date__java_lang_Integer__java_lang_Integer", true);
                    out.write_long(arg0);
                    out.write_value(arg1,String.class);
                    out.write_value(arg2,Date.class);
                    out.write_value(arg3,Date.class);
                    out.write_value(arg4,Integer.class);
                    out.write_value(arg5,Integer.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return in.read_long();
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return taskStart(arg0,arg1,arg2,arg3,arg4,arg5);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("taskStart__long__CORBA_WStringValue__java_util_Date__java_util_Date__java_lang_Integer__java_lang_Integer",com.hps.july.arenda.sessionbean.Journal.class);
            if (so == null) {
                return taskStart(arg0, arg1, arg2, arg3, arg4, arg5);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg1,arg2,arg3,arg4,arg5},_orb());
                String arg1Copy = (String) copies[0];
                Date arg2Copy = (Date) copies[1];
                Date arg3Copy = (Date) copies[2];
                Integer arg4Copy = (Integer) copies[3];
                Integer arg5Copy = (Integer) copies[4];
                return ((com.hps.july.arenda.sessionbean.Journal)so.servant).taskStart(arg0, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy);
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
}
