package com.hps.july.jdbcpersistence.lib;

import com.hps.july.jdbcpersistence.*;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.math.*;
import java.util.*;

/**
 * JDBC connection to july datasource wrapper.
 * Creation date: (26.09.2003 13:29:13)
 * @author: Dmitry Dneprov
 */
public class JdbcConnection {
	private DataSource july;
/**
 * JdbcConnection constructor comment.
 */
public JdbcConnection() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2003 13:30:50)
 * @return java.sql.Connection
 */
public Connection getConnection() throws Exception {
    //if(july != null)
    //	return july.getConnection();
    //EnvironmentAccessBean env = new EnvironmentAccessBean();
	//Properties prp = env.getEnvironmentProperties();
	//String dsName = prp.getProperty("DATASOURCE_NAME");
	//String factoryClass = prp.getProperty("FACTORY_CLASS");
	String dsName = "julysec";
	
	//System.out.println("Loading datasource:" + dsName);

	javax.naming.InitialContext ctx = null;
	ctx = new javax.naming.InitialContext();
	july = (DataSource) ctx.lookup(dsName);

	return july.getConnection();  
}
/**
 * Returns Integer from ResultSet
 * Creation date: (01.11.2003 14:01:52)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param name java.lang.String
 */
public static Integer getInteger(ResultSet rs, String name) throws java.sql.SQLException {
	int result = rs.getInt(name);
	if (rs.wasNull())
		return null;
	return new Integer(result);
}
/**
 * Returns Integer from ResultSet
 * Creation date: (01.11.2003 14:01:52)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param name java.lang.String
 */
public static Short getShort(ResultSet rs, String name) throws java.sql.SQLException {
	short result = rs.getShort(name);
	if (rs.wasNull())
		return null;
	return new Short(result);
}
/**
 * Returns trimmed string from ResultSet
 * Creation date: (01.11.2003 14:01:52)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param name java.lang.String
 */
public static String getString(ResultSet rs, String name) throws java.sql.SQLException {
	String result = rs.getString(name);
	if (result != null)
		result = result.trim();
	return result;
}
}
