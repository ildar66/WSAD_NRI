/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.inventory.sessionbean;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class DocumentPreprocessorAccessBean extends com.ibm.ivj.ejb.runtime.AbstractSessionAccessBean {

    transient private com.hps.july.inventory.sessionbean.DocumentPreprocessor __ejbRef = null;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.inventory.sessionbean.DocumentPreprocessor com.hps.july.inventory.sessionbean.DocumentPreprocessorHome.create() throws javax.ejb.CreateException,java.rmi.RemoteException
    *
    */

    public DocumentPreprocessorAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public DocumentPreprocessorAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/inventory/sessionbean/DocumentPreprocessor";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.inventory.sessionbean.DocumentPreprocessorHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.inventory.sessionbean.DocumentPreprocessorHome) PortableRemoteObject.narrow(getHome(), com.hps.july.inventory.sessionbean.DocumentPreprocessorHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.inventory.sessionbean.DocumentPreprocessor ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.inventory.sessionbean.DocumentPreprocessor) PortableRemoteObject.narrow(ejbRef, com.hps.july.inventory.sessionbean.DocumentPreprocessor.class);

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

    public com.hps.july.inventory.sessionbean.DocumentProcessingException preprocessDocument(int arg0) throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().preprocessDocument(arg0);
    }


}
