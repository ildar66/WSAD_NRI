package com.hps.july.jdbcpersistence.lib;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.jdbcpersistence.*;

/**
 * Утилитарный класс для работы с JDBC.
 * Creation date: (16.02.2003 19:10:35)
 * @author: Alexander Shrago
 */
public class DataUtil implements QueryConstants {
    private javax.sql.DataSource dataSource;
    
	/**
	 * Close result set, statement and connection methods.
	 * Creation date: (20.10.2001 15:45:51)
	 */
/*
	 public void releaseConnection(Statement st,Connection conn) {
	    
	    closeStatement(st);
	    closeConnection(conn);
	}
*/
	
/**
 * DataUtil constructor comment.
 * @param ds javax.sql.DataSource
 */
public DataUtil() throws Exception {
 super();   
	dataSource=receiveDataSource();
}
/**
 * DataUtil constructor comment.
 * @param ds javax.sql.DataSource
 */
public DataUtil(javax.sql.DataSource ds) {
this.dataSource=ds;
}
	 public void closeConnection(Connection connection) {
	    try {
	        if (connection != null && !connection.isClosed()) {
	            connection.close();
	            connection = null;
	            //System.out.println(getClass().getName()+"connection -");
	        new DebugSupport().println(" connection-");
	            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void closeResultSet(ResultSet rs) {
	    try {
	        if (rs != null) {
	            rs.close();
	            rs = null;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void closeStatement(Statement stmt) {
	    try {
	        if (stmt != null) {
	            stmt.close();
	            stmt = null;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
public Object execute(Query query, String className) throws Exception {
    return   execute(query, getConnection(), INPUT_QUERY, className);
}
public Object execute(
    Query query,
    Connection connection,
    int inputType,
    String className)
    throws Exception {

    Object obj = null;
    //Vector res = null;
    //Vector vres = null;
    //Hashtable hTable = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    //Connection connection = null;
    //Enumeration enum = vec.elements();
    //String query = (String) enum.nextElement();
    try {
        //boolean retry = true;
        DebugSupport.println("query: "+query.getQueryString());
        if (inputType == INPUT_PROCEDURE) {
            query.setQueryString("{? = call " + query.getQueryString() + "}");

            stmt = connection.prepareCall(query.getQueryString());
        } else {
            stmt = connection.prepareStatement(query.getQueryString());

        }

        for (int i = 0; i < query.getParams().size(); i++) {
            stmt.setObject(i + 1, query.getParams().elementAt(i));
            DebugSupport.println(
                "parameters N"+(i+1)+"= "+query.getParams().elementAt(i));
        }

        if (inputType == INPUT_QUERY) {
            if (stmt.execute()) {

                rs = stmt.getResultSet();
            }
        } else {
            rs = stmt.executeQuery();
        }

        //retry = false;

        if (query.getResultType() == RESULT_LastSerial) {
            obj = receiveLastSerial(connection);
        } else {

            if (rs == null & query.getResultType() != RESULT_NONE) {
                throw new ResultEmptyException("rs==null query: " + query);

            } else
                if (query.getResultType() == RESULT_JdbcObject
                    || query.getResultType() == RESULT_JdbcObjectEnum
                    || query.getResultType() == RESULT_JdbcObjectVector)
                    obj = handleResult(rs, className, query.getResultType());

        }
        return obj;
    } catch (SQLException e) {
        if (e.getErrorCode() == -79739) {
            throw new ResultEmptyException(
                "errorCode=-79739  No current row.    query: " + query);

        }
        DebugSupport.printlnError(e,"execute rs=" + rs);
        throw e;
    } catch (Exception e) {

        DebugSupport.printlnError(e,"execute rs=" + rs);
        throw e;
    } finally {
        releaseConnection(rs, stmt, connection);
        //closeResultSet(rs);
        //closeStatement(stmt);

    }

}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 13:14:31)
 * @return java.sql.Connection
 */
public Connection getConnection() {
	return getConnection(dataSource);
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2001 15:39:21)
 * @return java.sql.Connection
 */
public static Connection getConnection(DataSource ds) {

    //if (connection != null)
    //    return connection;
    Connection connection = null;
    int j = 0;
    boolean retry = true;
    while (retry && j++ < 40) {
        try {

            connection = ds.getConnection();
            new DebugSupport().println(" connection+");
            retry = false;
            //ds.setLogWriter(System.out);

        } catch (Exception e2) {
            // new DebugSupport().println(
              //  e2 + " " + getClass().getName() + " connection+ failed. j=" + j);
              new DebugSupport().println(
                e2 + " " + " connection+ failed. j=" + j);

        }
    }
    return connection;

}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 13:13:08)
 * @return javax.sql.DataSource
 */
public javax.sql.DataSource getDataSource() {
	return dataSource;
}
public Object handleResult(ResultSet rs, int mode) throws Exception {

    if (mode == RESULT_OBJECT)
        rs.next();
    return rs.getObject(1);

}
public Object handleResult(ResultSet rs, String className, int mode)
    throws Exception {

    Vector vres = new Vector();
    Class cl = Class.forName(className);
    java.lang.reflect.Constructor cons =
        cl.getConstructor(new Class[] { Class.forName("java.sql.ResultSet")});

    if (mode == RESULT_JdbcObjectEnum) {

        while (rs.next()) {
             vres.add(cons.newInstance(new Object[] { rs }));
        }
        return vres.elements();
    } else
        if (mode == RESULT_JdbcObjectVector) {

            while (rs.next()) {
                vres.add(cons.newInstance(new Object[] { rs }));
            }
            return vres;
        } else
            if (mode == RESULT_JdbcObject) {
                rs.next();
                return cons.newInstance(new Object[] { rs });

            }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 13:52:37)
 * @return java.lang.String
 */
public static DataSource receiveDataSource() throws Exception {

    try {
        return receiveDataSource(
            "julysec",
            "com.ibm.websphere.naming.WsnInitialContextFactory");
    } catch (Throwable e) {
        return receiveDataSource(
            "jdbc/JULY",
            "com.ibm.ejs.ns.jndi.CNInitialContextFactory");
    }

}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 13:52:37)
 * @return java.lang.String
 */
public static DataSource receiveDataSource(String dsName, String factoryClass) throws Exception {
	
	
	javax.naming.InitialContext ctx = null;
	Properties prop = new Properties();
	prop.put( javax.naming.Context.PROVIDER_URL, "iiop://" );
	prop.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass );
	//"com.ibm.ejs.ns.jndi.CNInitialContextFactory" );
	ctx = new javax.naming.InitialContext( prop );
	return (javax.sql.DataSource)ctx.lookup( dsName );
	
	
}
public Object receiveLastSerial(Connection connection) throws Exception {
    
	Object obj = null;

    Statement st = connection.createStatement();
    ResultSet rset = st.executeQuery(QUERY_SelectLastSerial);
    rset.next();
    obj = rset.getObject(1);
    closeResultSet(rset);
    closeStatement(st);

    return obj;

}
	/**
	 * Close result set, statement and connection methods.
	 * Creation date: (20.10.2001 15:45:51)
	 */
	public void releaseConnection(ResultSet rs,Statement st,Connection conn) {
	    closeResultSet(rs);
	    closeStatement(st);
	    closeConnection(conn);
	}
}
