// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.sql.Date;
import java.util.Enumeration;
import javax.ejb.CreateException;
import javax.ejb.EJBMetaData;
import javax.ejb.FinderException;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.RemoveException;
import javax.rmi.CORBA.Stub;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.RemarshalException;
import org.omg.CORBA.portable.ServantObject;

public class _RequestHome_Stub extends Stub implements RequestHome {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.RequestHome:0000000000000000", 
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
    
    public Request create(int arg0) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("create__long", true);
                    out.write_long(arg0);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Request) in.read_Object(Request.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create__long",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return create(arg0);
            }
            try {
                Request result = ((com.hps.july.persistence.RequestHome)so.servant).create(arg0);
                return (Request)Util.copyObject(result,_orb());
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
    
    public Request create(int arg0, Integer arg1, Integer arg2, Integer arg3, Date arg4, int arg5, String arg6, String arg7, Boolean arg8, Boolean arg9, Integer arg10) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("create__long__java_lang_Integer__java_lang_Integer__java_lang_Integer__java_sql_Date__long__CORBA_WStringValue__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Integer", true);
                    out.write_long(arg0);
                    out.write_value(arg1,Integer.class);
                    out.write_value(arg2,Integer.class);
                    out.write_value(arg3,Integer.class);
                    out.write_value(arg4,Date.class);
                    out.write_long(arg5);
                    out.write_value(arg6,String.class);
                    out.write_value(arg7,String.class);
                    out.write_value(arg8,Boolean.class);
                    out.write_value(arg9,Boolean.class);
                    out.write_value(arg10,Integer.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Request) in.read_Object(Request.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create__long__java_lang_Integer__java_lang_Integer__java_lang_Integer__java_sql_Date__long__CORBA_WStringValue__CORBA_WStringValue__java_lang_Boolean__java_lang_Boolean__java_lang_Integer",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg1,arg2,arg3,arg4,arg6,arg7,arg8,arg9,arg10},_orb());
                Integer arg1Copy = (Integer) copies[0];
                Integer arg2Copy = (Integer) copies[1];
                Integer arg3Copy = (Integer) copies[2];
                Date arg4Copy = (Date) copies[3];
                String arg6Copy = (String) copies[4];
                String arg7Copy = (String) copies[5];
                Boolean arg8Copy = (Boolean) copies[6];
                Boolean arg9Copy = (Boolean) copies[7];
                Integer arg10Copy = (Integer) copies[8];
                Request result = ((com.hps.july.persistence.RequestHome)so.servant).create(arg0, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10Copy);
                return (Request)Util.copyObject(result,_orb());
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
    
    public Request create(int arg0, Integer arg1, Date arg2, int arg3, String arg4) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("create__long__java_lang_Integer__java_sql_Date__long__CORBA_WStringValue", true);
                    out.write_long(arg0);
                    out.write_value(arg1,Integer.class);
                    out.write_value(arg2,Date.class);
                    out.write_long(arg3);
                    out.write_value(arg4,String.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Request) in.read_Object(Request.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create(arg0,arg1,arg2,arg3,arg4);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create__long__java_lang_Integer__java_sql_Date__long__CORBA_WStringValue",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return create(arg0, arg1, arg2, arg3, arg4);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg1,arg2,arg4},_orb());
                Integer arg1Copy = (Integer) copies[0];
                Date arg2Copy = (Date) copies[1];
                String arg4Copy = (String) copies[2];
                Request result = ((com.hps.july.persistence.RequestHome)so.servant).create(arg0, arg1Copy, arg2Copy, arg3, arg4Copy);
                return (Request)Util.copyObject(result,_orb());
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
    
    public Request findByPrimaryKey(DocumentKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByPrimaryKey", true);
                    out.write_value(arg0,DocumentKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Request) in.read_Object(Request.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findByPrimaryKey(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByPrimaryKey",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return findByPrimaryKey(arg0);
            }
            try {
                DocumentKey arg0Copy = (DocumentKey) Util.copyObject(arg0,_orb());
                Request result = ((com.hps.july.persistence.RequestHome)so.servant).findByPrimaryKey(arg0Copy);
                return (Request)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof FinderException) {
                    throw (FinderException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public Enumeration findByQBE(Boolean arg0, Date arg1, Date arg2, Boolean arg3, Integer arg4, Boolean arg5, Integer arg6, String arg7, Boolean arg8, Integer arg9, Boolean arg10, Integer arg11, Boolean arg12) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE", true);
                    out.write_value(arg0,Boolean.class);
                    out.write_value(arg1,Date.class);
                    out.write_value(arg2,Date.class);
                    out.write_value(arg3,Boolean.class);
                    out.write_value(arg4,Integer.class);
                    out.write_value(arg5,Boolean.class);
                    out.write_value(arg6,Integer.class);
                    out.write_value(arg7,String.class);
                    out.write_value(arg8,Boolean.class);
                    out.write_value(arg9,Integer.class);
                    out.write_value(arg10,Boolean.class);
                    out.write_value(arg11,Integer.class);
                    out.write_value(arg12,Boolean.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Enumeration) in.read_value(Enumeration.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findByQBE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return findByQBE(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12},_orb());
                Boolean arg0Copy = (Boolean) copies[0];
                Date arg1Copy = (Date) copies[1];
                Date arg2Copy = (Date) copies[2];
                Boolean arg3Copy = (Boolean) copies[3];
                Integer arg4Copy = (Integer) copies[4];
                Boolean arg5Copy = (Boolean) copies[5];
                Integer arg6Copy = (Integer) copies[6];
                String arg7Copy = (String) copies[7];
                Boolean arg8Copy = (Boolean) copies[8];
                Integer arg9Copy = (Integer) copies[9];
                Boolean arg10Copy = (Boolean) copies[10];
                Integer arg11Copy = (Integer) copies[11];
                Boolean arg12Copy = (Boolean) copies[12];
                Enumeration result = ((com.hps.july.persistence.RequestHome)so.servant).findByQBE(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10Copy, arg11Copy, arg12Copy);
                return (Enumeration)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof FinderException) {
                    throw (FinderException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public Enumeration findRequestByChecker(WorkerKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findRequestByChecker", true);
                    out.write_value(arg0,WorkerKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Enumeration) in.read_value(Enumeration.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findRequestByChecker(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findRequestByChecker",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return findRequestByChecker(arg0);
            }
            try {
                WorkerKey arg0Copy = (WorkerKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.RequestHome)so.servant).findRequestByChecker(arg0Copy);
                return (Enumeration)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof FinderException) {
                    throw (FinderException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public Enumeration findRequestByDivisionRequester(DivisionKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findRequestByDivisionRequester", true);
                    out.write_value(arg0,DivisionKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Enumeration) in.read_value(Enumeration.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findRequestByDivisionRequester(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findRequestByDivisionRequester",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return findRequestByDivisionRequester(arg0);
            }
            try {
                DivisionKey arg0Copy = (DivisionKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.RequestHome)so.servant).findRequestByDivisionRequester(arg0Copy);
                return (Enumeration)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof FinderException) {
                    throw (FinderException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public Enumeration findRequestByPosition(StoragePlaceKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findRequestByPosition", true);
                    out.write_value(arg0,StoragePlaceKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Enumeration) in.read_value(Enumeration.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findRequestByPosition(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findRequestByPosition",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return findRequestByPosition(arg0);
            }
            try {
                StoragePlaceKey arg0Copy = (StoragePlaceKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.RequestHome)so.servant).findRequestByPosition(arg0Copy);
                return (Enumeration)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof FinderException) {
                    throw (FinderException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public Enumeration findRequestSenderBySender(WorkerKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findRequestSenderBySender", true);
                    out.write_value(arg0,WorkerKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Enumeration) in.read_value(Enumeration.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findRequestSenderBySender(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findRequestSenderBySender",com.hps.july.persistence.RequestHome.class);
            if (so == null) {
                return findRequestSenderBySender(arg0);
            }
            try {
                WorkerKey arg0Copy = (WorkerKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.RequestHome)so.servant).findRequestSenderBySender(arg0Copy);
                return (Enumeration)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                if (exCopy instanceof FinderException) {
                    throw (FinderException)exCopy;
                }
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
}
