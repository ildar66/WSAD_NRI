package com.hps.july.siteinfo.actionbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.formbean.PhotoListForm;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик удаления фотографии
 * @author: Maxim Gerasimov
 */
public class DeletePhotoAction
	extends org.apache.struts.action.Action
{
public ActionForward perform(ActionMapping mapping, ActionForm form, 
	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	super.perform(mapping, form, request, response);

	Connection connection = null;
	PreparedStatement prepstatement = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_DELETE);
		PhotoListForm f = (PhotoListForm)form;
		int[] photos = f.getPhotoid();
		if(photos != null){
			for(int i = 0; i < photos.length; i++) {
				prepstatement.clearParameters();
				prepstatement.setInt(1, photos[i]);
				prepstatement.executeUpdate();
			}
			f.setPhotoid(new int[0]);
		}

		ActionForward forward = mapping.findForward("photolist");
		String path = forward.getPath();
		int mark = path.lastIndexOf("=");
		forward.setPath(path.substring(0, mark+1)+f.getStorageplace());

		return forward;
	} catch(Exception e) {
		System.out.println("Error in DeletePhotoAction.perform");
		e.printStackTrace(System.out);
		response.sendRedirect("error.jsp");
		return null;
	} finally {
		try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {} 
		try { if(connection != null) connection.close(); } catch(Exception e) {} 
	}
}
}
