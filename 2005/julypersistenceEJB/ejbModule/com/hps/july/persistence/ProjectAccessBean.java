/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class ProjectAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements ProjectAccessBeanData {

    transient private com.hps.july.persistence.Project __ejbRef = null;
    private int initKey_project;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence.Project com.hps.july.persistence.ProjectHome.findByPrimaryKey(com.hps.july.persistence.ProjectKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_project( int )

    */

    public ProjectAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public ProjectAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public ProjectAccessBean(int arg0, int arg1, java.lang.String arg2, int arg3) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1, arg2, arg3);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByQBE1(java.lang.Integer arg0, java.lang.Boolean arg1, java.lang.String arg2, java.lang.Boolean arg3, java.lang.Integer arg4, java.lang.Boolean arg5, java.lang.Integer arg6, java.lang.Integer arg7) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.ProjectHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByQBE1(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByQBE2(java.lang.Integer arg0, java.lang.Integer arg1, java.lang.Boolean arg2, java.lang.Integer[] arg3, java.lang.Boolean arg4, java.lang.Integer[] arg5, java.lang.Boolean arg6, java.lang.Integer[] arg7, java.lang.Boolean arg8, java.lang.Integer arg9, java.lang.Boolean arg10, java.lang.Integer arg11, java.lang.Boolean arg12, java.lang.Short arg13, java.lang.Integer arg14, java.lang.Boolean arg15, java.lang.String arg16, java.lang.Integer arg17) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.ProjectHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByQBE2(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findProjectsByContructer(com.hps.july.persistence.OrganizationKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.ProjectHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findProjectsByContructer(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findProjectsByPosition(com.hps.july.persistence.StoragePlaceKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.ProjectHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findProjectsByPosition(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findProjectsByProjecttype(com.hps.july.persistence.ProjectTypeKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.ProjectHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findProjectsByProjecttype(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findVcprojectsByVccontructer(com.hps.july.persistence.OrganizationKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.ProjectHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findVcprojectsByVccontructer(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_project( int newValue ) {
        this.initKey_project = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence/Project";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.ProjectHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence.ProjectHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.ProjectHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.Project ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence.Project) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.Project.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.persistence.ProjectKey key = keyFromFields(initKey_project);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.ProjectKey keyFromFields ( int f0 ) {
        com.hps.july.persistence.ProjectKey keyClass = new com.hps.july.persistence.ProjectKey();
        keyClass.project = f0;
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
            com.hps.july.persistence.ProjectKey pKey = (com.hps.july.persistence.ProjectKey) this.__getKey();
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

    public com.hps.july.persistence.ProjectTypeKey getProjecttypeKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.ProjectTypeKey) __getCache("projecttypeKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getYearfinish() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("yearfinish")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setYearfinish( java.lang.Integer newValue ) {
        __setCache("yearfinish", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OrganizationKey getContructerKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.OrganizationKey) __getCache("contructerKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OrganizationKey getVccontructerKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.OrganizationKey) __getCache("vccontructerKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.StoragePlaceKey) __getCache("positionKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getVctext() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("vctext")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setVctext( java.lang.String newValue ) {
        __setCache("vctext", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.sql.Date getDatestart() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.sql.Date) __getCache("datestart")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setDatestart( java.sql.Date newValue ) {
        __setCache("datestart", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getNotes() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("notes")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setNotes( java.lang.String newValue ) {
        __setCache("notes", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int getProject() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Integer) __getCache("project")).intValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Short getMonthfinish() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Short) __getCache("monthfinish")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setMonthfinish( java.lang.Short newValue ) {
        __setCache("monthfinish", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getName() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("name")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setName( java.lang.String newValue ) {
        __setCache("name", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OrganizationAccessBean getContructer() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Organization localEJBRef = ejbRef().getContructer();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.OrganizationAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.OrganizationAccessBean getVccontructer() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Organization localEJBRef = ejbRef().getVccontructer();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.OrganizationAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.PositionAccessBean getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.Position localEJBRef = ejbRef().getPosition();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.PositionAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.ProjectTypeAccessBean getProjecttype() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.ProjectType localEJBRef = ejbRef().getProjecttype();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.ProjectTypeAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getProjectActions() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getProjectActions();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getProjectDivColVals() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getProjectDivColVals();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getProjectStates() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        return ejbRef().getProjectStates();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void addProjectActions(com.hps.july.persistence.ProjectAction arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().addProjectActions(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void addProjectStates(com.hps.july.persistence.ProjectState arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().addProjectStates(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetContructerKey(com.hps.july.persistence.OrganizationKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetContructerKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetPositionKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetProjecttypeKey(com.hps.july.persistence.ProjectTypeKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetProjecttypeKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetVccontructerKey(com.hps.july.persistence.OrganizationKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetVccontructerKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddProjectActions(com.hps.july.persistence.ProjectAction arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddProjectActions(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddProjectDivColVals(com.hps.july.persistence.ProjectDivColVal arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddProjectDivColVals(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryAddProjectStates(com.hps.july.persistence.ProjectState arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryAddProjectStates(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemoveProjectActions(com.hps.july.persistence.ProjectAction arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemoveProjectActions(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemoveProjectDivColVals(com.hps.july.persistence.ProjectDivColVal arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemoveProjectDivColVals(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondaryRemoveProjectStates(com.hps.july.persistence.ProjectState arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondaryRemoveProjectStates(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetContructer(com.hps.july.persistence.Organization arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetContructer(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetPosition(com.hps.july.persistence.Position arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetPosition(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetProjecttype(com.hps.july.persistence.ProjectType arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetProjecttype(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetVccontructer(com.hps.july.persistence.Organization arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetVccontructer(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setContructer(com.hps.july.persistence.Organization arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setContructer(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setPosition(com.hps.july.persistence.Position arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setPosition(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setProjecttype(com.hps.july.persistence.ProjectType arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setProjecttype(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setVccontructer(com.hps.july.persistence.Organization arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setVccontructer(arg0);
    }


}