// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.hps.july.inventory.sessionbean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.sql.Date;
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

public class _CurrencySumProcessor_Stub extends Stub implements CurrencySumProcessor {
    
    private static final String[] _type_ids = {
        "RMI:com.hps.july.inventory.sessionbean.CurrencySumProcessor:0000000000000000", 
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
    
    public CurrencySumProcessingError getBaseCurrency() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_baseCurrency", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (CurrencySumProcessingError) in.read_value(CurrencySumProcessingError.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getBaseCurrency();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_baseCurrency",com.hps.july.inventory.sessionbean.CurrencySumProcessor.class);
            if (so == null) {
                return getBaseCurrency();
            }
            try {
                CurrencySumProcessingError result = ((com.hps.july.inventory.sessionbean.CurrencySumProcessor)so.servant).getBaseCurrency();
                return (CurrencySumProcessingError)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public CurrencySumProcessingError getDefaultRateType() throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA.portable.OutputStream out = _request("_get_defaultRateType", true);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (CurrencySumProcessingError) in.read_value(CurrencySumProcessingError.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return getDefaultRateType();
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("_get_defaultRateType",com.hps.july.inventory.sessionbean.CurrencySumProcessor.class);
            if (so == null) {
                return getDefaultRateType();
            }
            try {
                CurrencySumProcessingError result = ((com.hps.july.inventory.sessionbean.CurrencySumProcessor)so.servant).getDefaultRateType();
                return (CurrencySumProcessingError)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
    
    public CurrencySumProcessingError recalcSumToCurrency(Integer arg0, BigDecimal arg1, Integer arg2, Date arg3, Integer arg4) throws RemoteException {
        if (!Util.isLocal(this)) {
            try {
                org.omg.CORBA_2_3.portable.InputStream in = null;
                try {
                    org.omg.CORBA_2_3.portable.OutputStream out = 
                        (org.omg.CORBA_2_3.portable.OutputStream)
                        _request("recalcSumToCurrency", true);
                    out.write_value(arg0,Integer.class);
                    out.write_value(arg1,BigDecimal.class);
                    out.write_value(arg2,Integer.class);
                    out.write_value(arg3,Date.class);
                    out.write_value(arg4,Integer.class);
                    in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                    return (CurrencySumProcessingError) in.read_value(CurrencySumProcessingError.class);
                } catch (ApplicationException ex) {
                    in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                    String id = in.read_string();
                    throw new UnexpectedException(id);
                } catch (RemarshalException ex) {
                    return recalcSumToCurrency(arg0,arg1,arg2,arg3,arg4);
                } finally {
                    _releaseReply(in);
                }
            } catch (SystemException ex) {
                throw Util.mapSystemException(ex);
            }
        } else {
            ServantObject so = _servant_preinvoke("recalcSumToCurrency",com.hps.july.inventory.sessionbean.CurrencySumProcessor.class);
            if (so == null) {
                return recalcSumToCurrency(arg0, arg1, arg2, arg3, arg4);
            }
            try {
                Object[] copies = Util.copyObjects(new Object[]{arg0,arg1,arg2,arg3,arg4},_orb());
                Integer arg0Copy = (Integer) copies[0];
                BigDecimal arg1Copy = (BigDecimal) copies[1];
                Integer arg2Copy = (Integer) copies[2];
                Date arg3Copy = (Date) copies[3];
                Integer arg4Copy = (Integer) copies[4];
                CurrencySumProcessingError result = ((com.hps.july.inventory.sessionbean.CurrencySumProcessor)so.servant).recalcSumToCurrency(arg0Copy, arg1Copy, arg2Copy, arg3Copy, arg4Copy);
                return (CurrencySumProcessingError)Util.copyObject(result,_orb());
            } catch (Throwable ex) {
                Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                throw Util.wrapException(exCopy);
            } finally {
                _servant_postinvoke(so);
            }
        }
    }
}