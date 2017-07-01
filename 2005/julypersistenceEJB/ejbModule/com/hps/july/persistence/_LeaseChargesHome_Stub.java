// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
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

public class _LeaseChargesHome_Stub extends Stub implements LeaseChargesHome {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.LeaseChargesHome:0000000000000000", 
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
    
    public LeaseCharges create(int arg0, Date arg1, Integer arg2, String arg3, String arg4, Date arg5, Date arg6, Integer arg7, BigDecimal arg8, Integer arg9, BigDecimal arg10, BigDecimal arg11, Boolean arg12) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("create", true);
                    out.write_long(arg0);
                    out.write_value(arg1,Date.class);
                    out.write_value(arg2,Integer.class);
                    out.write_value(arg3,String.class);
                    out.write_value(arg4,String.class);
                    out.write_value(arg5,Date.class);
                    out.write_value(arg6,Date.class);
                    out.write_value(arg7,Integer.class);
                    out.write_value(arg8,BigDecimal.class);
                    out.write_value(arg9,Integer.class);
                    out.write_value(arg10,BigDecimal.class);
                    out.write_value(arg11,BigDecimal.class);
                    out.write_value(arg12,Boolean.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (LeaseCharges) in.read_Object(LeaseCharges.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12},_orb());
                Date arg1Copy = (Date) copies[0];
                Integer arg2Copy = (Integer) copies[1];
                String arg3Copy = (String) copies[2];
                String arg4Copy = (String) copies[3];
                Date arg5Copy = (Date) copies[4];
                Date arg6Copy = (Date) copies[5];
                Integer arg7Copy = (Integer) copies[6];
                BigDecimal arg8Copy = (BigDecimal) copies[7];
                Integer arg9Copy = (Integer) copies[8];
                BigDecimal arg10Copy = (BigDecimal) copies[9];
                BigDecimal arg11Copy = (BigDecimal) copies[10];
                Boolean arg12Copy = (Boolean) copies[11];
                LeaseCharges result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).create(arg0, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10Copy, arg11Copy, arg12Copy);
                return (LeaseCharges)Util.copyObject(result,_orb());
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
    
    public Enumeration findByLeaseContract(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByLeaseContract", true);
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
                    return findByLeaseContract(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByLeaseContract",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findByLeaseContract(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findByLeaseContract(arg0Copy);
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
    
    public LeaseCharges findByPrimaryKey(LeaseDocPositionKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByPrimaryKey", true);
                    out.write_value(arg0,LeaseDocPositionKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (LeaseCharges) in.read_Object(LeaseCharges.class);
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
            ServantObject so = _servant_preinvoke("findByPrimaryKey",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findByPrimaryKey(arg0);
            }
            try {
                LeaseDocPositionKey arg0Copy = (LeaseDocPositionKey) Util.copyObject(arg0,_orb());
                LeaseCharges result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findByPrimaryKey(arg0Copy);
                return (LeaseCharges)Util.copyObject(result,_orb());
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
    
    public Enumeration findByQBE(Boolean arg0, Integer arg1, Boolean arg2, Date arg3, Date arg4, Boolean arg5, Integer arg6, Integer arg7) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE", true);
                    out.write_value(arg0,Boolean.class);
                    out.write_value(arg1,Integer.class);
                    out.write_value(arg2,Boolean.class);
                    out.write_value(arg3,Date.class);
                    out.write_value(arg4,Date.class);
                    out.write_value(arg5,Boolean.class);
                    out.write_value(arg6,Integer.class);
                    out.write_value(arg7,Integer.class);
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
                    return findByQBE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findByQBE(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7},_orb());
                Boolean arg0Copy = (Boolean) copies[0];
                Integer arg1Copy = (Integer) copies[1];
                Boolean arg2Copy = (Boolean) copies[2];
                Date arg3Copy = (Date) copies[3];
                Date arg4Copy = (Date) copies[4];
                Boolean arg5Copy = (Boolean) copies[5];
                Integer arg6Copy = (Integer) copies[6];
                Integer arg7Copy = (Integer) copies[7];
                Enumeration result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findByQBE(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy);
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
    
    public Enumeration findByQBE2(Integer arg0, Date arg1, Date arg2, Boolean arg3, String arg4) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE2", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,Date.class);
                    out.write_value(arg2,Date.class);
                    out.write_value(arg3,Boolean.class);
                    out.write_value(arg4,String.class);
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
                    return findByQBE2(arg0,arg1,arg2,arg3,arg4);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE2",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findByQBE2(arg0, arg1, arg2, arg3, arg4);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4},_orb());
                Integer arg0Copy = (Integer) copies[0];
                Date arg1Copy = (Date) copies[1];
                Date arg2Copy = (Date) copies[2];
                Boolean arg3Copy = (Boolean) copies[3];
                String arg4Copy = (String) copies[4];
                Enumeration result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findByQBE2(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy);
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
    
    public Enumeration findByQBE3(Integer arg0, Integer arg1, Date arg2, Date arg3) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE3", true);
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
                    return findByQBE3(arg0,arg1,arg2,arg3);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE3",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findByQBE3(arg0, arg1, arg2, arg3);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3},_orb());
                Integer arg0Copy = (Integer) copies[0];
                Integer arg1Copy = (Integer) copies[1];
                Date arg2Copy = (Date) copies[2];
                Date arg3Copy = (Date) copies[3];
                Enumeration result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findByQBE3(arg0Copy, arg1Copy, arg2Copy, arg3Copy);
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
    
    public Enumeration findByQBE4(Integer arg0, Boolean arg1, Date arg2, Boolean arg3, Date arg4, Boolean arg5, BigDecimal arg6, Boolean arg7, Integer arg8, Boolean arg9, Integer arg10) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE4", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,Boolean.class);
                    out.write_value(arg2,Date.class);
                    out.write_value(arg3,Boolean.class);
                    out.write_value(arg4,Date.class);
                    out.write_value(arg5,Boolean.class);
                    out.write_value(arg6,BigDecimal.class);
                    out.write_value(arg7,Boolean.class);
                    out.write_value(arg8,Integer.class);
                    out.write_value(arg9,Boolean.class);
                    out.write_value(arg10,Integer.class);
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
                    return findByQBE4(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE4",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findByQBE4(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10},_orb());
                Integer arg0Copy = (Integer) copies[0];
                Boolean arg1Copy = (Boolean) copies[1];
                Date arg2Copy = (Date) copies[2];
                Boolean arg3Copy = (Boolean) copies[3];
                Date arg4Copy = (Date) copies[4];
                Boolean arg5Copy = (Boolean) copies[5];
                BigDecimal arg6Copy = (BigDecimal) copies[6];
                Boolean arg7Copy = (Boolean) copies[7];
                Integer arg8Copy = (Integer) copies[8];
                Boolean arg9Copy = (Boolean) copies[9];
                Integer arg10Copy = (Integer) copies[10];
                Enumeration result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findByQBE4(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10Copy);
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
    
    public Enumeration findByQBE5(Boolean arg0, Integer arg1, Boolean arg2, Date arg3, Date arg4, Boolean arg5, Integer arg6, Boolean arg7, String[] arg8, Integer arg9) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE5", true);
                    out.write_value(arg0,Boolean.class);
                    out.write_value(arg1,Integer.class);
                    out.write_value(arg2,Boolean.class);
                    out.write_value(arg3,Date.class);
                    out.write_value(arg4,Date.class);
                    out.write_value(arg5,Boolean.class);
                    out.write_value(arg6,Integer.class);
                    out.write_value(arg7,Boolean.class);
                    out.write_value(cast_array(arg8),String[].class);
                    out.write_value(arg9,Integer.class);
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
                    return findByQBE5(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE5",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findByQBE5(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9},_orb());
                Boolean arg0Copy = (Boolean) copies[0];
                Integer arg1Copy = (Integer) copies[1];
                Boolean arg2Copy = (Boolean) copies[2];
                Date arg3Copy = (Date) copies[3];
                Date arg4Copy = (Date) copies[4];
                Boolean arg5Copy = (Boolean) copies[5];
                Integer arg6Copy = (Integer) copies[6];
                Boolean arg7Copy = (Boolean) copies[7];
                String[] arg8Copy = (String[]) copies[8];
                Integer arg9Copy = (Integer) copies[9];
                Enumeration result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findByQBE5(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8Copy, arg9Copy);
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
    
    public Enumeration findLeaseChargesByLeaseRule(LeaseRuleKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findLeaseChargesByLeaseRule", true);
                    out.write_value(arg0,LeaseRuleKey.class);
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
                    return findLeaseChargesByLeaseRule(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findLeaseChargesByLeaseRule",com.hps.july.persistence.LeaseChargesHome.class);
            if (so == null) {
                return findLeaseChargesByLeaseRule(arg0);
            }
            try {
                LeaseRuleKey arg0Copy = (LeaseRuleKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.LeaseChargesHome)so.servant).findLeaseChargesByLeaseRule(arg0Copy);
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
    
    // This method is required as a work-around for
    // a bug in the JDK 1.1.6 verifier.
    
    private Serializable cast_array(Object obj) {
        return (Serializable)obj;
    }
}
