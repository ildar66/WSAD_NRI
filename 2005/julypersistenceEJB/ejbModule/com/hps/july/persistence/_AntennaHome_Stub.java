// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
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

public class _AntennaHome_Stub extends Stub implements AntennaHome {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.AntennaHome:0000000000000000", 
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
    
    public Antenna create(int arg0, int arg1, String arg2, String arg3, BigDecimal arg4, BigDecimal arg5, BigDecimal arg6, BigDecimal arg7, int arg8) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("create__long__long__CORBA_WStringValue__CORBA_WStringValue__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__long", true);
                    out.write_long(arg0);
                    out.write_long(arg1);
                    out.write_value(arg2,String.class);
                    out.write_value(arg3,String.class);
                    out.write_value(arg4,BigDecimal.class);
                    out.write_value(arg5,BigDecimal.class);
                    out.write_value(arg6,BigDecimal.class);
                    out.write_value(arg7,BigDecimal.class);
                    out.write_long(arg8);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Antenna) in.read_Object(Antenna.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create__long__long__CORBA_WStringValue__CORBA_WStringValue__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__long",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg2,arg3,arg4,arg5,arg6,arg7},_orb());
                String arg2Copy = (String) copies[0];
                String arg3Copy = (String) copies[1];
                BigDecimal arg4Copy = (BigDecimal) copies[2];
                BigDecimal arg5Copy = (BigDecimal) copies[3];
                BigDecimal arg6Copy = (BigDecimal) copies[4];
                BigDecimal arg7Copy = (BigDecimal) copies[5];
                Antenna result = ((com.hps.july.persistence.AntennaHome)so.servant).create(arg0, arg1, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8);
                return (Antenna)Util.copyObject(result,_orb());
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
    
    public Antenna create(int arg0, int arg1, String arg2, String arg3, BigDecimal arg4, BigDecimal arg5, BigDecimal arg6, BigDecimal arg7, int arg8, Boolean arg9) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("create__long__long__CORBA_WStringValue__CORBA_WStringValue__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__long__java_lang_Boolean", true);
                    out.write_long(arg0);
                    out.write_long(arg1);
                    out.write_value(arg2,String.class);
                    out.write_value(arg3,String.class);
                    out.write_value(arg4,BigDecimal.class);
                    out.write_value(arg5,BigDecimal.class);
                    out.write_value(arg6,BigDecimal.class);
                    out.write_value(arg7,BigDecimal.class);
                    out.write_long(arg8);
                    out.write_value(arg9,Boolean.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Antenna) in.read_Object(Antenna.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create__long__long__CORBA_WStringValue__CORBA_WStringValue__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__java_math_BigDecimal__long__java_lang_Boolean",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg2,arg3,arg4,arg5,arg6,arg7,arg9},_orb());
                String arg2Copy = (String) copies[0];
                String arg3Copy = (String) copies[1];
                BigDecimal arg4Copy = (BigDecimal) copies[2];
                BigDecimal arg5Copy = (BigDecimal) copies[3];
                BigDecimal arg6Copy = (BigDecimal) copies[4];
                BigDecimal arg7Copy = (BigDecimal) copies[5];
                Boolean arg9Copy = (Boolean) copies[6];
                Antenna result = ((com.hps.july.persistence.AntennaHome)so.servant).create(arg0, arg1, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy, arg7Copy, arg8, arg9Copy);
                return (Antenna)Util.copyObject(result,_orb());
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
    
    public Enumeration findAntennesByCableres(ResourceKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findAntennesByCableres", true);
                    out.write_value(arg0,ResourceKey.class);
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
                    return findAntennesByCableres(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findAntennesByCableres",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findAntennesByCableres(arg0);
            }
            try {
                ResourceKey arg0Copy = (ResourceKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.AntennaHome)so.servant).findAntennesByCableres(arg0Copy);
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
    
    public Enumeration findAntennesByEquipment(StoragePlaceKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findAntennesByEquipment", true);
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
                    return findAntennesByEquipment(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findAntennesByEquipment",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findAntennesByEquipment(arg0);
            }
            try {
                StoragePlaceKey arg0Copy = (StoragePlaceKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.AntennaHome)so.servant).findAntennesByEquipment(arg0Copy);
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
    
    public Enumeration findAntennesByOperator(OperatorKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findAntennesByOperator", true);
                    out.write_value(arg0,OperatorKey.class);
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
                    return findAntennesByOperator(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findAntennesByOperator",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findAntennesByOperator(arg0);
            }
            try {
                OperatorKey arg0Copy = (OperatorKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.AntennaHome)so.servant).findAntennesByOperator(arg0Copy);
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
    
    public Enumeration findAntennesByResource(ResourceKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findAntennesByResource", true);
                    out.write_value(arg0,ResourceKey.class);
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
                    return findAntennesByResource(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findAntennesByResource",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findAntennesByResource(arg0);
            }
            try {
                ResourceKey arg0Copy = (ResourceKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.AntennaHome)so.servant).findAntennesByResource(arg0Copy);
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
    
    public Enumeration findByEquipmentOrderByNumAsc(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByEquipmentOrderByNumAsc", true);
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
                    return findByEquipmentOrderByNumAsc(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByEquipmentOrderByNumAsc",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findByEquipmentOrderByNumAsc(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.AntennaHome)so.servant).findByEquipmentOrderByNumAsc(arg0Copy);
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
    
    public Antenna findByPrimaryKey(AntennaKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByPrimaryKey", true);
                    out.write_value(arg0,AntennaKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (Antenna) in.read_Object(Antenna.class);
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
            ServantObject so = _servant_preinvoke("findByPrimaryKey",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findByPrimaryKey(arg0);
            }
            try {
                AntennaKey arg0Copy = (AntennaKey) Util.copyObject(arg0,_orb());
                Antenna result = ((com.hps.july.persistence.AntennaHome)so.servant).findByPrimaryKey(arg0Copy);
                return (Antenna)Util.copyObject(result,_orb());
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
    
    public Enumeration findByQBE(Integer arg0, String arg1, Boolean arg2, String arg3, Boolean arg4, String arg5, Integer arg6) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByQBE", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,String.class);
                    out.write_value(arg2,Boolean.class);
                    out.write_value(arg3,String.class);
                    out.write_value(arg4,Boolean.class);
                    out.write_value(arg5,String.class);
                    out.write_value(arg6,Integer.class);
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
                    return findByQBE(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByQBE",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findByQBE(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4,arg5,arg6},_orb());
                Integer arg0Copy = (Integer) copies[0];
                String arg1Copy = (String) copies[1];
                Boolean arg2Copy = (Boolean) copies[2];
                String arg3Copy = (String) copies[3];
                Boolean arg4Copy = (Boolean) copies[4];
                String arg5Copy = (String) copies[5];
                Integer arg6Copy = (Integer) copies[6];
                Enumeration result = ((com.hps.july.persistence.AntennaHome)so.servant).findByQBE(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy, arg5Copy, arg6Copy);
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
    
    public Enumeration findGrresAntennesByGroundresource(ResourceKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findGrresAntennesByGroundresource", true);
                    out.write_value(arg0,ResourceKey.class);
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
                    return findGrresAntennesByGroundresource(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findGrresAntennesByGroundresource",com.hps.july.persistence.AntennaHome.class);
            if (so == null) {
                return findGrresAntennesByGroundresource(arg0);
            }
            try {
                ResourceKey arg0Copy = (ResourceKey) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.AntennaHome)so.servant).findGrresAntennesByGroundresource(arg0Copy);
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
