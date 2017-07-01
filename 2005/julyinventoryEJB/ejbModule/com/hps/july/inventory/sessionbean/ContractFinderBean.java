package com.hps.july.inventory.sessionbean;

import com.hps.july.persistence.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import java.sql.*;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Поиск информации по контракту
 */
public class ContractFinderBean implements SessionBean {
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
 * Insert the method's description here.
 * Creation date: (04.09.2002 16:13:22)
 * @return java.lang.Integer
 * @param serial java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
public Integer findContractByParty(String party) throws java.rmi.RemoteException {
	Integer ret = null;
	Connection con = null; 
	PreparedStatement sel = null;
	PreparedStatement sel2 = null;
	PreparedStatement sel3 = null;
	ResultSet rs = null;
	try {
		con = getConnection();

		//prepare statements
		sel = con.prepareStatement( 
			"select first 1 d.* from documents d where d.type in (\"S\",\"W\") and exists "+
			"(select dd.docposition from docpositions dd where dd.document = d.document "+
			"and dd.storagecardto in "+
			"(select storagecard from storagecards where party=?) ) "+
			"order by blankdate "
			);
		sel2 = con.prepareStatement( 
			"select contract from i13actpos where docposition = "+
			"(select docposition from docpositions where document = ? and storagecardto in "+
			"(select storagecard from storagecards where party=? and "+
			"storagecard.storageplace=document.from)) "
			);
		sel3 = con.prepareStatement( "select documentfrom from docdependencies where documentto = ?" );

		//get document that create this card
		sel.setString( 1, party );
		rs = sel.executeQuery();
		if( !rs.next() ) {
			return null;
		}
		
		//getting doc type
		char docType = rs.getString( "type" ).charAt(1);
		int doc = rs.getInt( "document" );
		rs.close();
		
		switch( docType ) {
			case 'S':		//surplusact - get contruct from i13n act
				sel2.setInt( 1, doc );
				sel2.setString( 2, party );
				rs = sel2.executeQuery();
				if( !rs.next() )
					return null;
				int contract = rs.getInt("contract");
				if( rs.wasNull() )
					return null;
				ret = new Integer( contract );
				break;
			case 'W':
				sel3.setInt( 1, doc );
				rs = sel3.executeQuery();
				if( !rs.next() )
					return null;
				ret = new Integer( rs.getInt("documentfrom") );
				break;
			default:
				return null;
		}		
	} catch( Exception e ) {
		e.printStackTrace();
		throw new RemoteException( "While getting contact by party "+party, e );
	} finally {
		try{ rs.close(); } catch( Throwable t )  {}
		try{ sel.close(); } catch( Throwable t ) {}
		try{ sel2.close(); } catch( Throwable t ) {}
		try{ sel3.close(); } catch( Throwable t ) {}
		try{ con.close(); } catch( Throwable t ) {}
	}
	
	return ret;
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 16:13:22)
 * @return java.lang.Integer
 * @param serial java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
public Integer findContractBySerial(String serial) throws java.rmi.RemoteException {
	Integer ret = null;
	Connection con = null; 
	PreparedStatement sel = null;
	PreparedStatement sel1 = null;
	PreparedStatement sel2 = null;
	PreparedStatement sel3 = null;
	ResultSet rs = null;
	try {
		con = getConnection();

		//prepare statements
		sel = con.prepareStatement( 
			"select * from documents where document = "+
			"(select document from cardtracks where trackid = "+
			"(select min(trackid) from cardtracks where storagecard = "+
			"(select storagecard from "+
			"storagecards where closed=\"N\" and serialnumber=?))) "
			);
		sel1 = con.prepareStatement( "select oldserial from changeactpos where document = ? and newserial = ?" );
		sel2 = con.prepareStatement( 
			"select contract from i13actpos where docposition = "+
			"(select docposition from docpositions where document = ? and storagecardto = "+
			"(select storagecard from "+
			"storagecards where closed=\"N\" and serialnumber=?)) "
			);
		sel3 = con.prepareStatement( "select documentfrom from docdependencies where documentto = ?" );

		//get document that create this card
		sel.setString( 1, serial );
		rs = sel.executeQuery();
		if( !rs.next() ) {
			return null;
		}
		
		//getting doc type
		char docType = rs.getString( "type" ).charAt(1);
		int doc = rs.getInt( "document" );
		rs.close();
		
		switch( docType ) {
			case 'H':		//change act recursing
				sel1.setInt( 1, doc );
				sel1.setString( 2, serial );
				rs = sel1.executeQuery();
				if( !rs.next() ) {
					return null;
				}
				String oSerial = rs.getString( "oldserial" ).trim();
				rs.close();
				con.close();
				return findContractBySerial( oSerial );
			case 'S':		//surplusact - get contruct from i13n act
				sel2.setInt( 1, doc );
				sel2.setString( 2, serial );
				rs = sel2.executeQuery();
				if( !rs.next() )
					return null;
				int contract = rs.getInt("contract");
				if( rs.wasNull() )
					return null;
				ret = new Integer( contract );
				break;
			case 'W':	//внешний приход
				sel3.setInt( 1, doc );
				rs = sel3.executeQuery();
				if( !rs.next() )
					return null;
				ret = new Integer( rs.getInt("documentfrom") );
				break;
			default:
				return null;
		}		
	} catch( Exception e ) {
		e.printStackTrace();
		throw new RemoteException( "While getting contact by serial "+serial, e );
	} finally {
		try{ rs.close(); } catch( Throwable t )  {}
		try{ sel.close(); } catch( Throwable t ) {}
		try{ sel1.close(); } catch( Throwable t ) {}
		try{ sel2.close(); } catch( Throwable t ) {}
		try{ sel3.close(); } catch( Throwable t ) {}
		try{ con.close(); } catch( Throwable t ) {}
	}

	return ret;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 19:10:28)
 * @return java.sql.Connection
 */
private Connection getConnection() throws Exception {

	/*
	Properties prp = getSessionContext().getEnvironment();
	for( Iterator i = prp.keySet().iterator(); i.hasNext(); ) {
		String key = (String)i.next();
		System.out.println("key="+key+" value="+prp.get(key) );
	}
	*/
	Properties prp = new com.hps.july.jdbcpersistence.EnvironmentAccessBean().getEnvironmentProperties();
	String dsName = prp.getProperty("DATASOURCE_NAME");
	String factoryClass = prp.getProperty( "FACTORY_CLASS" );
	
	javax.naming.InitialContext ctx = null;
	Properties prop = new Properties();
	prop.put( javax.naming.Context.PROVIDER_URL, "iiop://" );
	prop.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass );
	//"com.ibm.ejs.ns.jndi.CNInitialContextFactory" );
	ctx = new javax.naming.InitialContext( prop );
	javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup( dsName );
	
	return ds.getConnection();
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
