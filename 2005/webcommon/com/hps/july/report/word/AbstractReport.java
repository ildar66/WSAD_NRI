package com.hps.july.report.word;

import java.sql.*;
import javax.sql.*;

/**
 * Класс, от которого наследуются все отчеты word.
 * Creation date: (29.08.2002 10:52:10)
 * @author: ildar
 */
abstract public class AbstractReport {
	/**
	 * constructor.
	 */
	public AbstractReport() {
		super();
	}
	public Connection getConnection() throws Exception {
		String dsName = "julysec";
		String factoryClass = "com.ibm.websphere.naming.WsnInitialContextFactory";
		
		javax.naming.InitialContext ctx = null;
		java.util.Properties prop = new java.util.Properties();
		prop.put( javax.naming.Context.PROVIDER_URL, "iiop://" );
		prop.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass );
		ctx = new javax.naming.InitialContext( );
		javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup( dsName );
		
		return ds.getConnection();
	}
    abstract public void getReportData( Engine engine, String configs );
/**
 * Извлечение строки из входных параметров.
 * Creation date: (04.07.2005 12:38:13)
 */
public static String getString(Engine e, int i) {
	Object o;
	try {
		o = e.getPrompt(i);
	} catch(ReportException re) {
		o = new Object();
	}
	if(o instanceof String) {
		return (String)o;
	} else {
		return null;
	}
}
}
