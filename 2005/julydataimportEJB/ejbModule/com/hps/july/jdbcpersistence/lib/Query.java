package com.hps.july.jdbcpersistence.lib;

import java.util.*;

/**
 * Объект для облегчения построения JDBC запросов.
 * Creation date: (16.02.2003 21:56:26)
 * @author: Alexander Shrago
 */
public class Query {
    public StringBuffer buf = new StringBuffer();
    public Vector params = new Vector();
    public int resultType;
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 22:58:43)
 */
public Query() {
	super();
	
	}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 22:58:43)
 */
public Query(int resultType) {
	super();
	this.resultType=resultType;
	}
/**
 * Query constructor comment.
 */
public Query( String str) {
	super();
	appendString(str);
}
/**
 * Query constructor comment.
 */
public Query( String str,int resultType) {
	super();
	this.resultType=resultType;
	appendString(str);
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void addParameter(Object parameter) {
	params.add(parameter);
	}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void append(Query q1) {

    //DebugSupport.printlnTest("appendQuery started");

    append(q1.getQueryString());

    Object[] pars = q1.getParams().toArray();
    for (int i = 0; i < pars.length; i++) {
        appendParam(pars[i]);
    }
    //DebugSupport.printlnTest("appendQuery finished");
}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void append(String str) {
	buf.append(str+" ");
	//DebugSupport.printlnTest(str);
	
	}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void append(String str, Object[] params) {
    append(str);
    appendFromArray(params);

}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void append(String str,Object param) {
	buf.append(str+" ");
	
	appendParam(param);

	
	//DebugSupport.printlnTest("param="+param);
	}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void append(String str,Object param1,Object param2) {
	buf.append(str+" ");
	appendParam(param1);
	appendParam(param2);
	
	}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 22:26:48)
 * @return java.lang.String
 */
public void appendFromArray(Object[] params) {
    appendString("(");

    if (params.length == 0) {
        appendString("NULL");

    } else {
        for (int i = 0; i < params.length; i++) {
            appendString(i == 0 ? "?" : ",?");
            addParameter(params[i]);
            //DebugSupport.printlnTest("params[" + i + "]=" + params[i]);
        }
    }
    appendString(") ");

}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void appendParam(Object param) {
	
	params.add(param);

	
	//DebugSupport.printlnTest("param="+param);
	}
/**
 * Insert the method's description here.
 * Creation date: (16.02.2003 23:12:08)
 * @param parameter java.lang.Object
 */
public void appendString(String str) {
	append(str);
	}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 12:20:05)
 * @return java.util.Vector
 */
public Vector getParams() {
	return params;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 12:16:00)
 * @return java.lang.String
 */
public String getQueryString() {
	return buf.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:49:41)
 * @return int
 */
public int getResultType() {
	return resultType;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 12:16:00)
 * @return java.lang.String
 */
public void setQueryString(String str) {
	buf= new StringBuffer(str);
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2003 14:49:41)
 * @param newResultType int
 */
public void setResultType(int newResultType) {
	resultType = newResultType;
}
}
