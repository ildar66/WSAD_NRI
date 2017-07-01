package com.hps.july.siteinfo.locservlet;

import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import com.hps.july.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.hps.july.siteinfo.applets.Files;

/**
 * Сервлет обрабатывающий загрузку фотографий в систему
 * @author: Maxim Gerasimov
 */
public class AppletPhotoUpload extends javax.servlet.http.HttpServlet {
private Files getImages(int photoId) throws Exception{
	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet rs = null;
	Hashtable images = new Hashtable();
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(
				com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_IMAGE
		);
		prepstatement.setInt(1, photoId);
		rs = prepstatement.executeQuery();
		byte[] bigImage = null;
		String name = null;
		while(rs.next()) {
			bigImage = rs.getBytes("photoimage");
			name = rs.getString("photofilename");
			if((name != null) && (name.length() > 0) && bigImage != null) {
				images.put(name, bigImage);
			}
			bigImage = null;
		}
		return new Files(null, null, images, 0, 0);
	} catch (Exception e) {
		System.out.println("Error in AppletPhotoUpload.getImages " + e.getMessage());
		if(e instanceof SQLException) {
			System.out.println("Error  ["+((SQLException)e).getErrorCode()+"] !!!");
		}
		e.printStackTrace(System.out);
		throw e;
	} finally {
		images = null;
		try { if(rs != null) rs.close(); } catch(Exception e) {}
		try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {}
		try { if(connection != null) connection.close(); } catch(Exception e) {}
    }
}
public void service(HttpServletRequest request, HttpServletResponse response)
    throws javax.servlet.ServletException, java.io.IOException {

	ServletInputStream sin = null;
	ServletOutputStream sout = null; 
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	int storageplace = 	-1;
	try {
		sin = request.getInputStream();
		sout = response.getOutputStream();
		ois = new ObjectInputStream(sin);
		oos = new ObjectOutputStream(sout);

		storageplace = Integer.parseInt((String)ois.readObject());
		Files files = getImages(storageplace);
		oos.writeObject(files);
		oos.flush();
		//oos.writeObject("OK");
		
	} catch (Exception e) {
		System.out.println("Error in AppletPhotoUpload");
		e.printStackTrace(System.out);
		oos.writeObject("Error in AppletPhotoUpload. "+e.getMessage());
		oos.flush();
	} finally {
		try {if(sin != null) sin.close();} catch (Exception e) {e.printStackTrace(System.out);}
		try {if(sout != null) sout.close();} catch (Exception e) {e.printStackTrace(System.out);}
		try {if(ois != null) ois.close();} catch (Exception e) {e.printStackTrace(System.out);}
		try {if(oos != null) oos.close();} catch (Exception e) {e.printStackTrace(System.out);}
	}
}
}
