package com.hps.july.dataimport.lib;

import java.sql.*;

import com.hps.july.persistence.*;

/**
 * Обработка задачи импорта данных.
 * Creation date: (11.04.2003 13:20:10)
 * @author: Alexander Shrago
 */
public class TaskImport {

    public final static int ChanalPower_V = 1;
    public final static int ChanalPower_H = 2;
    public final static int BsImport = 3;

public static String xmlFile(int task)
	throws Exception
{

	try {
		ImportTaskAccessBean aBean = new ImportTaskAccessBean();
		ImportTaskHome home = (ImportTaskHome) aBean.getHome();
		ImportTask remote = home.findByPrimaryKey(new ImportTaskKey(task));
		return new String(remote.getXmlfile()).trim();
	} catch (Exception e) {
		com.hps.july.jdbcpersistence.lib.DebugSupport.printlnError(e);
		throw e;
		//return null;
    }


	
	/*byte[] bytes = null;
	
	//try {
		

	Connection con = null;
	PreparedStatement ps = null;
	try{
	Class drvClass = Class.forName("com.informix.jdbc.IfxDriver"); 
    String url = "jdbc:informix-sqli://172.21.9.138:1541:informixserver=beeinf;database=july;DB_LOCALE=ru_RU.1251;CLIENT_LOCALE=ru_RU.1251";
	con = DriverManager.getConnection(url, "esmivin", "mazda3");

	//com.hps.july.jdbcpersistence.lib.JdbcConnection jcon = new com.hps.july.jdbcpersistence.lib.JdbcConnection();
	//con = jcon.getConnection();
	
	System.err.println("Connected ok!!");
	ps = con.prepareStatement("SELECT xml_file FROM importtasks WHERE imptaskid=?");
	ps.setInt(1, 1);
	ResultSet rs = ps.executeQuery();
	if (rs != null) {
	    while(rs.next()) {
	        bytes = rs.getBytes(1);	        
	        String str = new String(bytes,"Cp1251").trim();
	        //System.err.println(str);
	        //parse(str);
	    }
	    rs.close();
	}
	ps.close();
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}

    */
		
}
public static String xmlFileMy(int task)
    throws java.io.FileNotFoundException, java.io.IOException {

    java.io.File file = null;

    if (task == ChanalPower_H)
        file = new java.io.File("d:/temp/LoadData/chanalPower_h.xml");

    else
        if (task == ChanalPower_V)
            file = new java.io.File("c:/test.xsl");
        else
            if (task == BsImport)
                file = new java.io.File("d:/temp/LoadData/convert.xml");

    java.io.FileInputStream inpStream = new java.io.FileInputStream(file);
    byte[] bt = new byte[22000];
    inpStream.read(bt);
    //String str = new String(bt);
    return new String(bt, "Cp1251").trim();

}
public static String xmlFileName(int task) {

    if (task == ChanalPower_H) {
        return "chanalPower_h.xml";
    } else
        if (task == ChanalPower_V) {
            return "chanalPower_v.xml";
        }
    return null;

}
}
