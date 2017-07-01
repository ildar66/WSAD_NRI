package com.hps.july.siteinfo.locservlet;

import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.applets.Files;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * Сервлет обрабатывающий выгрузку фотографий
 * @author: Maxim Gerasimov
 */
public class AppletPhotoDownload
	extends javax.servlet.http.HttpServlet
{
/**
 * Insert the method's description here.
 * Creation date: (28.07.2003 17:49:36)
 * @return java.sql.Date
 * @param date java.lang.String
 */
private java.sql.Date createDate(String date) throws Exception{
	try{
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
		return new java.sql.Date(format.parse(date).getTime());
	}catch(Exception e){
		getServletContext().log("Error in AppletPhotoDownload.createDate", e);
		throw e;
	}
}
public void service(HttpServletRequest request, HttpServletResponse response)
    throws javax.servlet.ServletException, java.io.IOException {

    ServletInputStream in = null;
    PrintWriter pw = null;
    BufferedReader br = null;
    ObjectInputStream ois = null;

    Connection connection = null;
	PreparedStatement prepstatement = null;
	Statement setQuery = null;	
	PreparedStatement selectPeople = null;
	ResultSet rs = null;

    try {
	    System.out.println("Servlet AppletPhotoDownload start");
        in = request.getInputStream();
        ois = new ObjectInputStream(in);
        pw = response.getWriter();
        Files files = (Files) ois.readObject();
        Hashtable hash = files.getFiles();
        Enumeration fnames = hash.keys();

        KeyGeneratorAccessBean key = new KeyGeneratorAccessBean();
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		//System.out.println("SQLINSERT ["+com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_INSERT+"]");
		//String SQL_PHOTO_INSERT = (" INSERT INTO photos "
		//+ " (photo, storageplace, description, date, photofilename, "
		//+ " photoimage, smallimage, mime_type, exphotgrname, photographer) "
		//+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		selectPeople = connection.prepareStatement(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_SELECT_PEOPLE_BY_LOGIN);
		setQuery = connection.createStatement();
		selectPeople.setString(1, request.getRemoteUser());
		rs = selectPeople.executeQuery();
		Integer peopleId = null;
		if(rs.next()) {
			int peopleIdi = rs.getInt("man");
			if(!rs.wasNull()) peopleId = new Integer(peopleIdi);
		}
		prepstatement = connection.prepareStatement(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_INSERT);
		while(fnames.hasMoreElements()){
			int pk = key.getNextKey("tables.photos");
			String name = (String)fnames.nextElement();
			Worker worker = null;
			if(files.getPhotographer() != 0) {
				WorkerAccessBean wrk = new WorkerAccessBean();
				wrk.setInitKey_worker(files.getPhotographer());
				wrk.refreshCopyHelper();
				
				worker = (Worker)wrk.getEJBRef();
			}
			prepstatement.clearParameters();
			prepstatement.setInt(1, pk);
			prepstatement.setInt(2, files.getStorageplace());
			prepstatement.setObject(3, files.getComments());
			prepstatement.setObject(4, createDate(files.getDate()));
			prepstatement.setObject(5, name);
			prepstatement.setObject(6, (byte[])hash.get(name));
			String mimeType = com.hps.july.web.util.DataType.getID(name);
			byte [] smallImage = null;
/*			
			if(mimeType != null) {
				smallImage = com.hps.july.web.util.ImageUtil.shrinkImage((byte[])hash.get(name), name);
			}
*/			
/*			
			FileOutputStream f1 = new FileOutputStream("/opt/WebSphere/AppServer/Maps/1/" + name);
			FileOutputStream f2 = new FileOutputStream("/opt/WebSphere/AppServer/Maps/1/small" + name);
			f1.write((byte[])hash.get(name));
			if(smallImage != null) f2.write(smallImage);
			f1.flush();
			f2.flush();
			f1.close();
			f2.close();
*/			
			prepstatement.setObject(7, smallImage);
			prepstatement.setObject(8, mimeType);
			prepstatement.setObject(9, files.getExternalPhotograher());
			prepstatement.setObject(10, (worker != null)?new Integer(files.getPhotographer()):null);
			prepstatement.setObject(11, files.getGroupName());
			prepstatement.setObject(12, peopleId);
			prepstatement.setObject(13, peopleId);
			prepstatement.executeUpdate();

			StringBuffer sb = new StringBuffer();
			sb.append("execute procedure setPhotoShrinkProcessToQuery('photoId=");
			sb.append(pk);
			sb.append("')");
			setQuery.execute(sb.toString());
		}
		
        System.out.println("Servlet AppletPhotoDownload end");
		pw.print("OK");
		pw.flush();
    } catch (Exception e) {
        getServletContext().log("AppletPhotoDownload error msg=" + e.getMessage());
        StringBuffer errorString = new StringBuffer("Error while adding photo, cause : \n");
		if(e instanceof SQLException) {
			System.out.println("ERROR RPOCESS UPDATE SERVLET !!! " + ((SQLException)e).getErrorCode());
			errorString.append("dataBase problem : error code " + ((SQLException)e).getErrorCode() + "\n " );
			errorString.append("dataBase problem : error message" + ((SQLException)e).getMessage() + "\n " );
		}
		pw.print(errorString.toString());
		pw.flush();
        e.printStackTrace(System.out);
    } finally {
		try {if (in != null) in.close();} catch (Exception e) {e.printStackTrace();}
		try {if (pw != null) pw.close();} catch (Exception e) {e.printStackTrace();}
		try {if (br != null) br.close();} catch (Exception e) {e.printStackTrace();}
		try{if(ois != null) ois.close();}catch(Exception e){e.printStackTrace();}
		try { if(rs != null) rs.close(); } catch(Exception e) {}
		try { if(selectPeople != null) selectPeople.close(); } catch(Exception e) {}
		try { if(setQuery != null) setQuery.close(); } catch(Exception e) {}		
		try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {}
		try { if(connection != null) connection.close(); } catch(Exception e) {}
		
    }
}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.03.2005 18:56:08)
	 * @param pstmt java.sql.PreparedStatement
	 * @param obj java.lang.Object
	 * @param index int
	 */
	public void setObject(PreparedStatement pstmt, Object obj, int index) 
		throws SQLException {
		pstmt.setObject(index, obj);
	}
}
