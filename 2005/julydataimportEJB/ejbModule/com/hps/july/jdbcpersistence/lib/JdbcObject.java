package com.hps.july.jdbcpersistence.lib;

import javax.servlet.http.HttpServletRequest;
/**
 * Поддержка работы с данными JDBC.
 * Creation date: (16.02.2003 16:17:45)
 * @author: Alexander Shrago
 */
public abstract class JdbcObject implements QueryConstants {
	private DataUtil dataUtil;
	
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 18:03:14)
 */
public JdbcObject() throws Exception{
	super();
	
	}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:48:34)
 * @return java.lang.Object
 * @param query com.hps.july.jdbcpersistence.lib.Query
 */
public Object find(Query query) throws Exception {
     return getDataUtil().execute(query, getClass().getName());
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:48:34)
 * @return java.lang.Object
 * @param query com.hps.july.jdbcpersistence.lib.Query
 */
public java.util.Enumeration findEnumeration(Query query) throws Exception {
 query.setResultType(RESULT_JdbcObjectEnum);    
	return (java.util.Enumeration)getDataUtil().execute(query, getClass().getName());
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:48:34)
 * @return java.lang.Object
 * @param query com.hps.july.jdbcpersistence.lib.Query
 */
public java.util.Vector findVector(Query query) throws Exception {
	query.setResultType(RESULT_JdbcObjectVector);
     return (java.util.Vector)getDataUtil().execute(query, getClass().getName());
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public java.math.BigDecimal getBigDecimal(java.sql.ResultSet rs, String name)
    throws Exception {
    try {
        return rs.getObject(name) == null ? null : (java.math.BigDecimal) rs.getObject(name);
    } catch (Exception e) {
        //DebugSupport.printlnError(e);
        return null;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public Boolean getBoolean(java.sql.ResultSet rs, int num,String value) throws Exception {
	return rs.getString(num)==null?null:new Boolean(value.equals(rs.getString(num)));
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public Boolean getBoolean(java.sql.ResultSet rs, String name,String value) throws Exception {
	return rs.getString(name)==null?null:new Boolean(value.equals(rs.getString(name)));
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:46:16)
 * @return com.hps.july.jdbcpersistence.lib.DataUtil
 */
public DataUtil getDataUtil() throws Exception {
	return dataUtil==null?new DataUtil():dataUtil;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public java.sql.Date getDate(java.sql.ResultSet rs, String name)
    throws Exception {
    try {
        return rs.getObject(name) == null ? null : (java.sql.Date) rs.getObject(name);
    } catch (Exception e) {
        //DebugSupport.printlnError(e);
        return null;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public Integer getInteger(java.sql.ResultSet rs, int num) throws Exception {
    try {
        return rs.getObject(num) == null ? null : (Integer) rs.getObject(num);
    } catch (Exception e) {
        //DebugSupport.printlnError(e);
        return null;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public Integer getInteger(java.sql.ResultSet rs, String name)
    throws Exception {
    try {
        return rs.getObject(name) == null ? null : (Integer) rs.getObject(name);
    } catch (Exception e) {
        //DebugSupport.printlnError(e);
        return null;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public String getString(java.sql.ResultSet rs, int num) throws Exception {
    try {
        return rs.getString(num) == null ? "" : rs.getString(num).trim();
    } catch (Exception e) {
	    //DebugSupport.printlnError(e);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 14:30:16)
 * @return java.lang.String
 * @param rs java.sql.ResultSet
 * @param str java.lang.String
 */
public String getString(java.sql.ResultSet rs, String name) throws Exception {
    try {
        return rs.getString(name) == null ? "" : rs.getString(name).trim();
    } catch (Exception e) {
        //DebugSupport.printlnError(e);
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2003 21:32:10)
 * @return boolean
 */
public Boolean isAdmin(HttpServletRequest request) {
	return new Boolean(request.isUserInRole("administrator"));
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:46:16)
 * @param newDataUtil com.hps.july.jdbcpersistence.lib.DataUtil
 */
public void setDataUtil(DataUtil newDataUtil) {
	dataUtil = newDataUtil;
}
}
