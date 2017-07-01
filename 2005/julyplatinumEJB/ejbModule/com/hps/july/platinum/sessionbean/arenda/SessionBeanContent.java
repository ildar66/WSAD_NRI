package com.hps.july.platinum.sessionbean.arenda;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.platinum.sessionbean.*;
import com.hps.july.platinum.sessionbean.arenda.*;

/**
 * This is a Session Bean Class
 */
public class SessionBeanContent  {
    

    private SessionContext context;
    
/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 18:24:04)
 */
public SessionBeanContent() {}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2003 18:24:04)
 */
public SessionBeanContent(SessionContext context) {
    this.context = context;
}
public javax.transaction.UserTransaction receiveUserTransaction()
    throws javax.naming.NamingException {

    return context == null
        ? (javax.transaction.UserTransaction) new javax.naming.InitialContext().lookup(
            "jta/usertransaction")
        : context.getUserTransaction();
}
}
