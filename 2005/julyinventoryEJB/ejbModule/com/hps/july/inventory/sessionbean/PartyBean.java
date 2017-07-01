package com.hps.july.inventory.sessionbean;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import java.sql.*;
import java.util.*;

/**
 * This is a Session Bean Class
 * –абота с партионным учетом
 */
public class PartyBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	private java.lang.Integer resource;
	private java.lang.String party;
	private java.lang.Integer owner;
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
	public java.util.ArrayList findPartyByQBE2(
	    Boolean isSubType, Integer resourceSubType,
	    Boolean isModel, String model, /* match строчка */
	    Boolean isName, String name, /* match строчка */
	    Boolean isManufacturer, Integer manufacturer,
	    Boolean isManucode, String manucode,
	    Integer connected, Integer owner,
	    Integer order
		) throws java.rmi.RemoteException, javax.ejb.FinderException {
			ArrayList res = new ArrayList();
			//get generic query string 
			int i;
		    StringBuffer sb = new StringBuffer("SELECT UNIQUE resource, owner, party FROM storagecards WHERE ");
		    String alias = "STORAGECARDS";
		    
		    //calculate where clause
			StringBuffer whereClause = new StringBuffer( alias + ".policy='P' " );
		
			if (isSubType.booleanValue())
		  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and resourcesubtype=?) ");
			if (isModel.booleanValue())
		  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and upper(model) matches upper(?)) ");
			if (isName.booleanValue())
		  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and upper(name) matches upper(?)) ");
			if (isManufacturer.booleanValue()) 
		  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and manufacturer=?) ");
			if (isManucode.booleanValue())
		  		whereClause.append(" and exists (select resource from resources where resource=" + alias + ".resource and upper(manucode) matches upper(?)) ");

		  	if (connected.intValue() == 2)	
				whereClause.append( " and EXISTS (SELECT ps.party FROM pie_partyreslink ps " +
					" WHERE ps.party = " + alias + ".party AND ps.owner = ? )" );
		  	if (connected.intValue() == 3)	
				whereClause.append( " and NOT EXISTS (SELECT ps.party FROM pie_partyreslink ps " +
					" WHERE ps.party = " + alias + ".party AND ps.owner = ? )" );
	    
		    //and fill it by where clause
		    sb = sb.append(whereClause);
	    
			//append order by clause
			String orderBy = null;
			switch( order.intValue() ) {
			case 1:
				orderBy = alias + ".party asc";
				break;
			case 2:
				orderBy = alias + ".party desc";
				break;
		}
		sb.append( " order by "+orderBy );
		
		System.out.println( "SQL clause="+sb );
			
		//fill prepared statement
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sb.toString());
			
			int j = 1;

			if (isSubType.booleanValue())
				ps.setInt( j++, resourceSubType.intValue() );
			if (isModel.booleanValue())
				ps.setString( j++, model );
			if (isName.booleanValue())
				ps.setString( j++, name );
			if (isManufacturer.booleanValue()) 
				ps.setInt( j++, manufacturer.intValue() );
			if (isManucode.booleanValue())
				ps.setString( j++, manucode );
		  	if (connected.intValue() == 2)	
				ps.setInt( j++, owner.intValue() );
		  	if (connected.intValue() == 3)	
				ps.setInt( j++, owner.intValue() );

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PartyBean bean = new PartyBean();
				bean.setResource(new Integer(rs.getInt("resource")));
				bean.setParty(rs.getString("party"));
				bean.setOwner(new Integer(rs.getInt("owner")));
				res.add(bean);
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return res;
	}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 19:10:28)
 * @return java.sql.Connection
 */
private java.sql.Connection getConnection() throws Exception {
	/*
	Properties prp = getSessionContext().getEnvironment();
	for( java.util.Iterator i = prp.keySet().iterator(); i.hasNext(); ) {
		String key = (String)i.next();
		System.out.println("key="+key+" value="+prp.get(key) );
	}
	*/
	Properties prp = new com.hps.july.jdbcpersistence.EnvironmentAccessBean().getEnvironmentProperties();
	String dsName = prp.getProperty("DATASOURCE_NAME");
	String factoryClass = prp.getProperty("FACTORY_CLASS");
	
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
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:12:41)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:12:18)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:11:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:12:41)
 * @param newOwner java.lang.Integer
 */
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:12:18)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:11:59)
 * @param newResource java.lang.Integer
 */
public void setResource(java.lang.Integer newResource) {
	resource = newResource;
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
