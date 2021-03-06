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

public class _LeaseMutualReglamentHome_Stub extends Stub implements LeaseMutualReglamentHome {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.LeaseMutualReglamentHome:0000000000000000", 
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
    
    public LeaseMutualReglament create(int arg0) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("create__long", true);
                    out.write_long(arg0);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (LeaseMutualReglament) in.read_Object(LeaseMutualReglament.class);
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
            ServantObject so = _servant_preinvoke("create__long",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return create(arg0);
            }
            try {
                LeaseMutualReglament result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).create(arg0);
                return (LeaseMutualReglament)Util.copyObject(result,_orb());
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
    
    public LeaseMutualReglament create(int arg0, Date arg1, String arg2, String arg3, Integer arg4, Boolean arg5, String arg6, String arg7, String arg8, Date arg9, Date arg10) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("create__long__java_sql_Date__CORBA_WStringValue__CORBA_WStringValue__java_lang_Integer__java_lang_Boolean__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__java_sql_Date__java_sql_Date", true);
                    out.write_long(arg0);
                    out.write_value(arg1,Date.class);
                    out.write_value(arg2,String.class);
                    out.write_value(arg3,String.class);
                    out.write_value(arg4,Integer.class);
                    out.write_value(arg5,Boolean.class);
                    out.write_value(arg6,String.class);
                    out.write_value(arg7,String.class);
                    out.write_value(arg8,String.class);
                    out.write_value(arg9,Date.class);
                    out.write_value(arg10,Date.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (LeaseMutualReglament) in.read_Object(LeaseMutualReglament.class);
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
            ServantObject so = _servant_preinvoke("create__long__java_sql_Date__CORBA_WStringValue__CORBA_WStringValue__java_lang_Integer__java_lang_Boolean__CORBA_WStringValue__CORBA_WStringValue__CORBA_WStringValue__java_sql_Date__java_sql_Date",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10},_orb());
                Date arg1Copy = (Date) copies[0];
                String arg2Copy = (String) copies[1];
                String arg3Copy = (String) copies[2];
                Integer arg4Copy = (Integer) copies[3];
                Boolean arg5Copy = (Boolean) copies[4];
                String arg6Copy = (String) copies[5];
                String arg7Copy = (String) copies[6];
                String arg8Copy = (String) copies[7];
                Date arg9Copy = (Date) copies[8];
                Date arg10Copy = (Date) copies[9];
                LeaseMutualReglament result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).create(arg0, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10Copy);
                return (LeaseMutualReglament)Util.copyObject(result,_orb());
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
    
    public Enumeration findByLeaseDocumentOrderByDocumentNumberAsc(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByLeaseDocumentOrderByDocumentNumberAsc", true);
                    out.write_value(arg0,Integer.class);
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
                    return findByLeaseDocumentOrderByDocumentNumberAsc(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByLeaseDocumentOrderByDocumentNumberAsc",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findByLeaseDocumentOrderByDocumentNumberAsc(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findByLeaseDocumentOrderByDocumentNumberAsc(arg0Copy);
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
    
    public LeaseMutualReglament findByPrimaryKey(LeaseDocumentKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByPrimaryKey", true);
                    out.write_value(arg0,LeaseDocumentKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (LeaseMutualReglament) in.read_Object(LeaseMutualReglament.class);
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
            ServantObject so = _servant_preinvoke("findByPrimaryKey",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findByPrimaryKey(arg0);
            }
            try {
                LeaseDocumentKey arg0Copy = (LeaseDocumentKey) Util.copyObject(arg0,_orb());
                LeaseMutualReglament result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findByPrimaryKey(arg0Copy);
                return (LeaseMutualReglament)Util.copyObject(result,_orb());
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
    
    public Enumeration findByQBE(Boolean arg0, Date arg1, Boolean arg2, String arg3, Boolean arg4, Integer arg5, Boolean arg6, Boolean arg7, Boolean arg8, Boolean arg9, String arg10, Integer arg11) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE", true);
                    out.write_value(arg0,Boolean.class);
                    out.write_value(arg1,Date.class);
                    out.write_value(arg2,Boolean.class);
                    out.write_value(arg3,String.class);
                    out.write_value(arg4,Boolean.class);
                    out.write_value(arg5,Integer.class);
                    out.write_value(arg6,Boolean.class);
                    out.write_value(arg7,Boolean.class);
                    out.write_value(arg8,Boolean.class);
                    out.write_value(arg9,Boolean.class);
                    out.write_value(arg10,String.class);
                    out.write_value(arg11,Integer.class);
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
                    return findByQBE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findByQBE(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11},_orb());
                Boolean arg0Copy = (Boolean) copies[0];
                Date arg1Copy = (Date) copies[1];
                Boolean arg2Copy = (Boolean) copies[2];
                String arg3Copy = (String) copies[3];
                Boolean arg4Copy = (Boolean) copies[4];
                Integer arg5Copy = (Integer) copies[5];
                Boolean arg6Copy = (Boolean) copies[6];
                Boolean arg7Copy = (Boolean) copies[7];
                Boolean arg8Copy = (Boolean) copies[8];
                Boolean arg9Copy = (Boolean) copies[9];
                String arg10Copy = (String) copies[10];
                Integer arg11Copy = (Integer) copies[11];
                Enumeration result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findByQBE(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10Copy, arg11Copy);
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
    
    public Enumeration findByResourceContractDates(Integer arg0, Integer arg1, Date arg2, Date arg3) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByResourceContractDates", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,Integer.class);
                    out.write_value(arg2,Date.class);
                    out.write_value(arg3,Date.class);
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
                    return findByResourceContractDates(arg0,arg1,arg2,arg3);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByResourceContractDates",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findByResourceContractDates(arg0, arg1, arg2, arg3);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3},_orb());
                Integer arg0Copy = (Integer) copies[0];
                Integer arg1Copy = (Integer) copies[1];
                Date arg2Copy = (Date) copies[2];
                Date arg3Copy = (Date) copies[3];
                Enumeration result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findByResourceContractDates(arg0Copy, arg1Copy, arg2Copy, arg3Copy);
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
    
    public Enumeration findByResourceContractMaxDateStart(Integer arg0, Integer arg1) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByResourceContractMaxDateStart", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,Integer.class);
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
                    return findByResourceContractMaxDateStart(arg0,arg1);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByResourceContractMaxDateStart",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findByResourceContractMaxDateStart(arg0, arg1);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1},_orb());
                Integer arg0Copy = (Integer) copies[0];
                Integer arg1Copy = (Integer) copies[1];
                Enumeration result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findByResourceContractMaxDateStart(arg0Copy, arg1Copy);
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
    
    public Enumeration findConcurentReglamentsByReglament(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findConcurentReglamentsByReglament", true);
                    out.write_value(arg0,Integer.class);
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
                    return findConcurentReglamentsByReglament(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findConcurentReglamentsByReglament",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findConcurentReglamentsByReglament(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findConcurentReglamentsByReglament(arg0Copy);
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
    
    public Enumeration findLeaseMutualReglamentsAddByAdditionalCurrency(CurrencyKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findLeaseMutualReglamentsAddByAdditionalCurrency", true);
                    out.write_value(arg0,CurrencyKey.class);
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
                    return findLeaseMutualReglamentsAddByAdditionalCurrency(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findLeaseMutualReglamentsAddByAdditionalCurrency",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findLeaseMutualReglamentsAddByAdditionalCurrency(arg0);
            }
            try {
                CurrencyKey arg0Copy = (CurrencyKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findLeaseMutualReglamentsAddByAdditionalCurrency(arg0Copy);
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
    
    public Enumeration findLeaseMutualReglamentsMainByMaincurrency(CurrencyKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findLeaseMutualReglamentsMainByMaincurrency", true);
                    out.write_value(arg0,CurrencyKey.class);
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
                    return findLeaseMutualReglamentsMainByMaincurrency(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findLeaseMutualReglamentsMainByMaincurrency",com.hps.july.persistence.LeaseMutualReglamentHome.class);
            if (so == null) {
                return findLeaseMutualReglamentsMainByMaincurrency(arg0);
            }
            try {
                CurrencyKey arg0Copy = (CurrencyKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.LeaseMutualReglamentHome)so.servant).findLeaseMutualReglamentsMainByMaincurrency(arg0Copy);
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
