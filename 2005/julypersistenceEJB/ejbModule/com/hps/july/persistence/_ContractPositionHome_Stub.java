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

public class _ContractPositionHome_Stub extends Stub implements ContractPositionHome {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.persistence.ContractPositionHome:0000000000000000", 
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
    
    public ContractPosition create(int arg0) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("create__long", true);
                    out.write_long(arg0);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (ContractPosition) in.read_Object(ContractPosition.class);
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
            ServantObject so = _servant_preinvoke("create__long",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return create(arg0);
            }
            try {
                ContractPosition result = ((com.hps.july.persistence.ContractPositionHome)so.servant).create(arg0);
                return (ContractPosition)Util.copyObject(result,_orb());
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
    
    public ContractPosition create(int arg0, Integer arg1, Integer arg2, Integer arg3, int arg4, BigDecimal arg5, BigDecimal arg6, Boolean arg7, Boolean arg8, Boolean arg9, Boolean arg10, Boolean arg11, Boolean arg12, String arg13) throws CreateException, RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("create__long__java_lang_Integer__java_lang_Integer__java_lang_Integer__long__java_math_BigDecimal__java_math_BigDecimal__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__CORBA_WStringValue", true);
                    out.write_long(arg0);
                    out.write_value(arg1,Integer.class);
                    out.write_value(arg2,Integer.class);
                    out.write_value(arg3,Integer.class);
                    out.write_long(arg4);
                    out.write_value(arg5,BigDecimal.class);
                    out.write_value(arg6,BigDecimal.class);
                    out.write_value(arg7,Boolean.class);
                    out.write_value(arg8,Boolean.class);
                    out.write_value(arg9,Boolean.class);
                    out.write_value(arg10,Boolean.class);
                    out.write_value(arg11,Boolean.class);
                    out.write_value(arg12,Boolean.class);
                    out.write_value(arg13,String.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (ContractPosition) in.read_Object(ContractPosition.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/CreateEx:1.0")) {
                        throw (CreateException) in.read_value(CreateException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return create(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("create__long__java_lang_Integer__java_lang_Integer__java_lang_Integer__long__java_math_BigDecimal__java_math_BigDecimal__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__java_lang_Boolean__CORBA_WStringValue",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return create(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg1,arg2,arg3,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13},_orb());
                Integer arg1Copy = (Integer) copies[0];
                Integer arg2Copy = (Integer) copies[1];
                Integer arg3Copy = (Integer) copies[2];
                BigDecimal arg5Copy = (BigDecimal) copies[3];
                BigDecimal arg6Copy = (BigDecimal) copies[4];
                Boolean arg7Copy = (Boolean) copies[5];
                Boolean arg8Copy = (Boolean) copies[6];
                Boolean arg9Copy = (Boolean) copies[7];
                Boolean arg10Copy = (Boolean) copies[8];
                Boolean arg11Copy = (Boolean) copies[9];
                Boolean arg12Copy = (Boolean) copies[10];
                String arg13Copy = (String) copies[11];
                ContractPosition result = ((com.hps.july.persistence.ContractPositionHome)so.servant).create(arg0, arg1Copy, arg2Copy, arg3Copy, arg4, arg5Copy, arg6Copy, arg7Copy, arg8Copy, arg9Copy, arg10Copy, arg11Copy, arg12Copy, arg13Copy);
                return (ContractPosition)Util.copyObject(result,_orb());
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
    
    public Enumeration findBadAgregatesByDocument(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findBadAgregatesByDocument", true);
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
                    return findBadAgregatesByDocument(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findBadAgregatesByDocument",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findBadAgregatesByDocument(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findBadAgregatesByDocument(arg0Copy);
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
    
    public Enumeration findByDocOrderByContractPositionOrderAsc(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByDocOrderByContractPositionOrderAsc", true);
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
                    return findByDocOrderByContractPositionOrderAsc(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByDocOrderByContractPositionOrderAsc",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findByDocOrderByContractPositionOrderAsc(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findByDocOrderByContractPositionOrderAsc(arg0Copy);
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
    
    public ContractPosition findByDocumentSerialnum(Integer arg0, String arg1) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByDocumentSerialnum", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,String.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (ContractPosition) in.read_Object(ContractPosition.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findByDocumentSerialnum(arg0,arg1);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findByDocumentSerialnum",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findByDocumentSerialnum(arg0, arg1);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1},_orb());
                Integer arg0Copy = (Integer) copies[0];
                String arg1Copy = (String) copies[1];
                ContractPosition result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findByDocumentSerialnum(arg0Copy, arg1Copy);
                return (ContractPosition)Util.copyObject(result,_orb());
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
    
    public ContractPosition findByPrimaryKey(DocumentPositionKey arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findByPrimaryKey", true);
                    out.write_value(arg0,DocumentPositionKey.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (ContractPosition) in.read_Object(ContractPosition.class);
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
            ServantObject so = _servant_preinvoke("findByPrimaryKey",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findByPrimaryKey(arg0);
            }
            try {
                DocumentPositionKey arg0Copy = (DocumentPositionKey) Util.copyObject(arg0,_orb());
                ContractPosition result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findByPrimaryKey(arg0Copy);
                return (ContractPosition)Util.copyObject(result,_orb());
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
    
    public Enumeration findDocPositionsByDocAndPolicyOrderByOrderAsc(Integer arg0, String arg1) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findDocPositionsByDocAndPolicyOrderByOrderAsc", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,String.class);
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
                    return findDocPositionsByDocAndPolicyOrderByOrderAsc(arg0,arg1);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findDocPositionsByDocAndPolicyOrderByOrderAsc",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findDocPositionsByDocAndPolicyOrderByOrderAsc(arg0, arg1);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1},_orb());
                Integer arg0Copy = (Integer) copies[0];
                String arg1Copy = (String) copies[1];
                Enumeration result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findDocPositionsByDocAndPolicyOrderByOrderAsc(arg0Copy, arg1Copy);
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
    
    public Enumeration findDocPositionsByDocAndPolicyOrderByOrderDesc(Integer arg0, String arg1) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findDocPositionsByDocAndPolicyOrderByOrderDesc", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,String.class);
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
                    return findDocPositionsByDocAndPolicyOrderByOrderDesc(arg0,arg1);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findDocPositionsByDocAndPolicyOrderByOrderDesc",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findDocPositionsByDocAndPolicyOrderByOrderDesc(arg0, arg1);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1},_orb());
                Integer arg0Copy = (Integer) copies[0];
                String arg1Copy = (String) copies[1];
                Enumeration result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findDocPositionsByDocAndPolicyOrderByOrderDesc(arg0Copy, arg1Copy);
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
    
    public Enumeration findDocPositionsByDocOrderByOrderAsc(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findDocPositionsByDocOrderByOrderAsc", true);
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
                    return findDocPositionsByDocOrderByOrderAsc(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findDocPositionsByDocOrderByOrderAsc",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findDocPositionsByDocOrderByOrderAsc(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findDocPositionsByDocOrderByOrderAsc(arg0Copy);
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
    
    public Enumeration findDocPositionsByDocOrderByOrderDesc(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findDocPositionsByDocOrderByOrderDesc", true);
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
                    return findDocPositionsByDocOrderByOrderDesc(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findDocPositionsByDocOrderByOrderDesc",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findDocPositionsByDocOrderByOrderDesc(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                Enumeration result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findDocPositionsByDocOrderByOrderDesc(arg0Copy);
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
    
    public ContractPosition findMaxOrderPosition(Integer arg0) throws RemoteException, FinderException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("findMaxOrderPosition", true);
                    out.write_value(arg0,Integer.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (ContractPosition) in.read_Object(ContractPosition.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    if (id.equals("IDL:javax/ejb/FinderEx:1.0")) {
                        throw (FinderException) in.read_value(FinderException.class);
                    }
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return findMaxOrderPosition(arg0);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("findMaxOrderPosition",com.hps.july.persistence.ContractPositionHome.class);
            if (so == null) {
                return findMaxOrderPosition(arg0);
            }
            try {
                Integer arg0Copy = (Integer) Util.copyObject(arg0,_orb());
                ContractPosition result = ((com.hps.july.persistence.ContractPositionHome)so.servant).findMaxOrderPosition(arg0Copy);
                return (ContractPosition)Util.copyObject(result,_orb());
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
