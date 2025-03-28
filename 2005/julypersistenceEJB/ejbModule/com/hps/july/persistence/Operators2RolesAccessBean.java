/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class Operators2RolesAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements Operators2RolesAccessBeanData {

    transient private com.hps.july.persistence.Operators2Roles __ejbRef = null;
    private java.lang.Integer initKey_operator_operator;
    private java.lang.String initKey_role_role;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence.Operators2Roles com.hps.july.persistence.Operators2RolesHome.findByPrimaryKey(com.hps.july.persistence.Operators2RolesKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_operator_operator( java.lang.Integer )
    * setInitKey_role_role( java.lang.String )

    */

    public Operators2RolesAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public Operators2RolesAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public Operators2RolesAccessBean(java.lang.Integer arg0, java.lang.String arg1) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findOperators2RolesByOperator(com.hps.july.persistence.OperatorKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.Operators2RolesHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findOperators2RolesByOperator(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findOperators2RolesByRole(com.hps.july.persistence.RoleKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.Operators2RolesHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findOperators2RolesByRole(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_operator_operator( java.lang.Integer newValue ) {
        this.initKey_operator_operator = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_role_role( java.lang.String newValue ) {
        this.initKey_role_role = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence/Operators2Roles";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.Operators2RolesHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence.Operators2RolesHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.Operators2RolesHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.Operators2Roles ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence.Operators2Roles) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.Operators2Roles.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.persistence.Operators2RolesKey key = keyFromFields(initKey_operator_operator, initKey_role_role);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.Operators2RolesKey keyFromFields ( java.lang.Integer f0, java.lang.String f1 ) {
        com.hps.july.persistence.Operators2RolesKey keyClass = new com.hps.july.persistence.Operators2RolesKey();
        keyClass.operator_operator = f0;
        keyClass.role_role = f1;
        return keyClass;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected boolean instantiateEJBByPrimaryKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.naming.NamingException {
        boolean result = false;

        if ( ejbRef() != null )
            return true;

        try {
            com.hps.july.persistence.Operators2RolesKey pKey = (com.hps.july.persistence.Operators2RolesKey) this.__getKey();
            if ( pKey != null ) {
                ejbRef = ejbHome().findByPrimaryKey(pKey);
                result = true;
            }
        }
        catch ( javax.ejb.FinderException e ) {
        }
        return result;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void commitCopyHelper() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        commitCopyHelper(ejbRef());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void refreshCopyHelper() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        refreshCopyHelper(ejbRef());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OperatorKey getOperatorKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.OperatorKey) __getCache("operatorKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.RoleKey getRoleKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.RoleKey) __getCache("roleKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OperatorAccessBean getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Operator localEJBRef = ejbRef().getOperator();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.OperatorAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.RoleAccessBean getRole() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Role localEJBRef = ejbRef().getRole();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.RoleAccessBean(localEJBRef);
        else
            return null;
    }


}
