package com.hps.july.dataimport.beans;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

/**
 * ��� �������������� �������� Xls ������ � ����.
 */
public class DataImportAccessBean extends com.ibm.ivj.ejb.runtime.AbstractSessionAccessBean {

    transient private com.hps.july.dataimport.beans.DataImport __ejbRef = null;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.dataimport.beans.DataImport com.hps.july.dataimport.beans.DataImportHome.create() throws javax.ejb.CreateException,java.rmi.RemoteException
    *
    */

    public DataImportAccessBean () {
        super();
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public DataImportAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/dataimport/beans/DataImport";
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.dataimport.beans.DataImportHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.dataimport.beans.DataImportHome) PortableRemoteObject.narrow(getHome(), com.hps.july.dataimport.beans.DataImportHome.class);
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.dataimport.beans.DataImport ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.dataimport.beans.DataImport) PortableRemoteObject.narrow(ejbRef, com.hps.july.dataimport.beans.DataImport.class);

        return __ejbRef;
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        ejbRef = ejbHome().create();
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int process(java.lang.String arg0, byte[] arg1, int arg2, int arg3) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().process(arg0, arg1, arg2, arg3);
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int processBs(java.lang.String arg0, byte[] arg1, int arg2, int arg3, java.util.Map arg4) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().processBs(arg0, arg1, arg2, arg3, arg4);
    }
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int processTest() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().processTest();
    }
}