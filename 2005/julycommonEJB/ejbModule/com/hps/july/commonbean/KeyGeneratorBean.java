package com.hps.july.commonbean;

import java.util.*;
import java.sql.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Генератор последовательностей автонумерации
 */
public class KeyGeneratorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * Получение соединения с базой данных.
 * Creation date: (13.02.2002 19:10:28)
 * @return java.sql.Connection
 */
private Connection getConnection() throws Exception {
	Properties prp = getSessionContext().getEnvironment();
	for( Iterator i = prp.keySet().iterator(); i.hasNext(); ) {
		String key = (String)i.next();
		//System.out.println("key="+key+" value="+prp.get(key) );
	}
	String dsName = prp.getProperty("DATASOURCE_NAME");
	String factoryClass = prp.getProperty( "FACTORY_CLASS" );
	
	javax.naming.InitialContext ctx = null;
	/*
	Properties prop = new Properties();
	prop.put( javax.naming.Context.PROVIDER_URL, "iiop://" );
	prop.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass );
	//"com.ibm.ejs.ns.jndi.CNInitialContextFactory" );
	ctx = new javax.naming.InitialContext( prop );
	*/
	ctx = new javax.naming.InitialContext();
	javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup( dsName );
	
	return ds.getConnection();
}
/**
 * Возвращает очередной код в именованной последовательности автонумерации.
 * Creation date: (13.02.2002 18:24:00)
 * @return int
 * @param alias java.lang.String
 */
public int getNextKey(String alias) throws RemoteException {
	int ret = 0;
	Connection con = null;
	PreparedStatement getSeq = null;
	ResultSet rs = null;
	try {
		con = getConnection();
		
		getSeq = con.prepareStatement( "EXECUTE PROCEDURE getSequence(?)" );
		getSeq.setString( 1, alias );
		rs = getSeq.executeQuery();
		rs.next();
		ret = rs.getInt( 1 );
	} catch( Exception e ) {
		e.printStackTrace();
		throw new RemoteException( "While getting serial id for "+alias, e );
	} finally {
		try{ rs.close(); } catch( Throwable t )  {}
		try{ getSeq.close(); } catch( Throwable t ) {}
	}

	return ret;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
