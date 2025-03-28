/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;

public class LeaseTaskJournalAccessBean extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean implements LeaseTaskJournalAccessBeanData {

    transient private com.hps.july.persistence.LeaseTaskJournal __ejbRef = null;
    private int initKey_taskjournal;
 
    static final long serialVersionUID = 3206093459760846163L;

   /**
    * Zero argument constructor used to initialize the access bean.
    *
    * This constructor corresponds to the following home interface method:
    *
    * public abstract com.hps.july.persistence.LeaseTaskJournal com.hps.july.persistence.LeaseTaskJournalHome.findByPrimaryKey(com.hps.july.persistence.LeaseTaskJournalKey) throws java.rmi.RemoteException,javax.ejb.FinderException
    *
    * The home interface method properties need to be set by calling
    * the following setter methods before calling any business methods:
    * setInitKey_taskjournal( int )

    */

    public LeaseTaskJournalAccessBean () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseTaskJournalAccessBean ( javax.ejb.EJBObject o ) throws java.rmi.RemoteException {
        super(o);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseTaskJournalAccessBean(int arg0) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseTaskJournalAccessBean(int arg0, int arg1, java.sql.Timestamp arg2, int arg3, java.lang.String arg4) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
        ejbRef = ejbHome().create(arg0, arg1, arg2, arg3, arg4);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByQBE(java.lang.Integer arg0, java.lang.Boolean arg1, java.lang.Boolean arg2, java.lang.Boolean arg3, java.lang.Integer arg4) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseTaskJournalHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByQBE(arg0, arg1, arg2, arg3, arg4);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByTaskStartOrderByJrnDate(java.lang.Integer arg0, java.lang.Integer arg1) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseTaskJournalHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByTaskStartOrderByJrnDate(arg0, arg1);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByTaskStartOrderByJrndateAscAndTaskjournalAsc(java.lang.Integer arg0, java.lang.Boolean arg1, java.lang.Boolean arg2, java.lang.Boolean arg3) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseTaskJournalHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByTaskStartOrderByJrndateAscAndTaskjournalAsc(arg0, arg1, arg2, arg3);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findByTaskStartType(java.lang.Integer arg0, java.lang.Boolean arg1, java.lang.String arg2, java.lang.Integer arg3) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseTaskJournalHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findByTaskStartType(arg0, arg1, arg2, arg3);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration findStart2journalByJournal2start(com.hps.july.persistence.LeaseTaskStartKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        com.hps.july.persistence.LeaseTaskJournalHome localHome = ejbHome();
        java.util.Enumeration ejbs = localHome.findStart2journalByJournal2start(arg0);
        return (java.util.Enumeration) createAccessBeans(ejbs);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setInitKey_taskjournal( int newValue ) {
        this.initKey_taskjournal = (newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected String defaultJNDIName() {
        return "com/hps/july/persistence/LeaseTaskJournal";
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseTaskJournalHome ejbHome() throws java.rmi.RemoteException, javax.naming.NamingException {
        return (com.hps.july.persistence.LeaseTaskJournalHome) PortableRemoteObject.narrow(getHome(), com.hps.july.persistence.LeaseTaskJournalHome.class);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseTaskJournal ejbRef() throws java.rmi.RemoteException {
        if ( ejbRef == null )
            return null;
        if ( __ejbRef == null )
            __ejbRef = (com.hps.july.persistence.LeaseTaskJournal) PortableRemoteObject.narrow(ejbRef, com.hps.july.persistence.LeaseTaskJournal.class);

        return __ejbRef;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    protected void instantiateEJB() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        if ( ejbRef() != null )
            return;

        com.hps.july.persistence.LeaseTaskJournalKey key = keyFromFields(initKey_taskjournal);
        ejbRef = ejbHome().findByPrimaryKey(key);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    private com.hps.july.persistence.LeaseTaskJournalKey keyFromFields ( int f0 ) {
        com.hps.july.persistence.LeaseTaskJournalKey keyClass = new com.hps.july.persistence.LeaseTaskJournalKey();
        keyClass.taskjournal = f0;
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
            com.hps.july.persistence.LeaseTaskJournalKey pKey = (com.hps.july.persistence.LeaseTaskJournalKey) this.__getKey();
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

    public java.lang.String getJrntype() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("jrntype")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setJrntype( java.lang.String newValue ) {
        __setCache("jrntype", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.String getJrnmessage() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.String) __getCache("jrnmessage")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setJrnmessage( java.lang.String newValue ) {
        __setCache("jrnmessage", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getLeasedocument() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("leasedocument")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setLeasedocument( java.lang.Integer newValue ) {
        __setCache("leasedocument", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getLeasedocposition() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("leasedocposition")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setLeasedocposition( java.lang.Integer newValue ) {
        __setCache("leasedocposition", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getCurrency2() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("currency2")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setCurrency2( java.lang.Integer newValue ) {
        __setCache("currency2", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getCurrency1() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("currency1")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setCurrency1( java.lang.Integer newValue ) {
        __setCache("currency1", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.sql.Date getDate2() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.sql.Date) __getCache("date2")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setDate2( java.sql.Date newValue ) {
        __setCache("date2", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.sql.Date getDate1() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.sql.Date) __getCache("date1")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setDate1( java.sql.Date newValue ) {
        __setCache("date1", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int getJrnaction() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Integer) __getCache("jrnaction")).intValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setJrnaction( int newValue ) {
        __setCache("jrnaction", new Integer(newValue));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getResource2() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("resource2")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setResource2( java.lang.Integer newValue ) {
        __setCache("resource2", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getResource1() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("resource1")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setResource1( java.lang.Integer newValue ) {
        __setCache("resource1", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getLeaserule() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("leaserule")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setLeaserule( java.lang.Integer newValue ) {
        __setCache("leaserule", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.sql.Timestamp getJrndate() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.sql.Timestamp) __getCache("jrndate")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setJrndate( java.sql.Timestamp newValue ) {
        __setCache("jrndate", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.lang.Integer getLeasedocposition2() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.lang.Integer) __getCache("leasedocposition2")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setLeasedocposition2( java.lang.Integer newValue ) {
        __setCache("leasedocposition2", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseTaskStartKey getJournal2startKey() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((com.hps.july.persistence.LeaseTaskStartKey) __getCache("journal2startKey")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal getSumm2() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.math.BigDecimal) __getCache("summ2")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setSumm2( java.math.BigDecimal newValue ) {
        __setCache("summ2", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.math.BigDecimal getSumm1() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((java.math.BigDecimal) __getCache("summ1")));
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setSumm1( java.math.BigDecimal newValue ) {
        __setCache("summ1", newValue);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public int getTaskjournal() throws java.rmi.RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, javax.naming.NamingException {
        return (((Integer) __getCache("taskjournal")).intValue());
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public com.hps.july.persistence.LeaseTaskStartAccessBean getJournal2start() throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {
        instantiateEJB();
        com.hps.july.persistence.LeaseTaskStart localEJBRef = ejbRef().getJournal2start();
        if ( localEJBRef != null )
            return new com.hps.july.persistence.LeaseTaskStartAccessBean(localEJBRef);
        else
            return null;
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void privateSetJournal2startKey(com.hps.july.persistence.LeaseTaskStartKey arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().privateSetJournal2startKey(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void secondarySetJournal2start(com.hps.july.persistence.LeaseTaskStart arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().secondarySetJournal2start(arg0);
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setJournal2start(com.hps.july.persistence.LeaseTaskStart arg0) throws java.rmi.RemoteException, javax.ejb.FinderException, javax.naming.NamingException {

        instantiateEJB();
        ejbRef().setJournal2start(arg0);
    }


}
