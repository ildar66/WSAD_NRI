package com.hps.july.siteinfo.locservlet;

import java.io.InputStream;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.*;
import javax.servlet.*;
import com.hps.july.persistence.*;

/**
 * Сервлет для выгрузки фотографий
 */
public class PhotoDownload 
	extends javax.servlet.http.HttpServlet
{
/**
 * Process incoming HTTP GET requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

	performTask(request, response);

}
/**
 * Process incoming HTTP POST requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

	performTask(request, response);

}
/**
 * Returns the servlet info string.
 */
public String getServletInfo() {

	return super.getServletInfo();

}
/**
 * Initializes the servlet.
 */
public void init() {
	// insert code to initialize the servlet here

}
/**
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

	int photo = 0;
	try {
		photo = Integer.parseInt((String)request.getParameter("photo"));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	int small = 0;
	try {
		small = Integer.parseInt((String)request.getParameter("small"));
	} catch (Exception e) {
	}
	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet rs = null;
	InputStream is = null;	
	if (photo != 0) {

		try {
			ServletOutputStream out=response.getOutputStream();

			JdbcConnection jdbcCon = new JdbcConnection();
			connection = jdbcCon.getConnection();
			prepstatement = connection.prepareStatement(
				//(small == 0)?com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_BIGIMAGE:
				//	com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_SMALLIMAGE
					com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_IMAGE
				);
			prepstatement.setInt(1, photo);
			rs = prepstatement.executeQuery();
			byte[] smallImage = null;
			byte[] bigImage = null;
			String name = null;
			if(rs.next()) {
				//if(small == 0) photoBLOB = rs.getBytes("photoimage");
				//else photoBLOB = rs.getBytes("smallimage");
				bigImage = rs.getBytes("photoimage");
				smallImage = rs.getBytes("smallimage");
				name = rs.getString("photofilename");
			}


			// Output blob to stream
			if((name != null) && (name.length() > 0)) {
				response.setContentType("application/octet-stream; name=" + name);
				response.setHeader("Content-Disposition", "inline;filename=" + name);
			}
			if(small == 0) {
				if(bigImage != null) out.write(bigImage);
			} else {
				if(smallImage != null) out.write(smallImage);
				else {
					is = this.getClass().getClassLoader().getResourceAsStream("com/hps/july/siteinfo/locservlet/jpegB.png");
					if(is != null) {
						try {
							int b;
							while((b = is.read()) != -1) out.write(b);
							is.close();
						} catch(Exception ex) {
						}
					} else {
						if(bigImage != null) out.write(bigImage);
					}
					
				}
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			if(e instanceof SQLException) {
				System.out.println("Error  ["+((SQLException)e).getErrorCode()+"] !!!");
			}
			e.printStackTrace(System.out);
		} finally {
			try { if(is != null) is.close(); } catch(Exception e) {}
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {}
			try { if(connection != null) connection.close(); } catch(Exception e) {}
	    }

	}
		
}
}
