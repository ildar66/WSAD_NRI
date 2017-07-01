package com.hps.july.siteinfo.locservlet;

import javax.servlet.*;
import com.hps.july.persistence.*;

/**
 * Сервлет для выгрузки списка прохода пользователю
 */
public class AccessListDownload extends javax.servlet.http.HttpServlet {
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

	int storageplace = 0;
	try {
		storageplace = Integer.parseInt((String)request.getParameter("storageplace"));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	if (storageplace != 0) {

		try {
			ServletOutputStream out=response.getOutputStream();

			/*
			// Get AccessBean
			PositionBLOBAccessBean bean=new PositionBLOBAccessBean();
			bean.setInitKey_storagePlace(storageplace);
			bean.refreshCopyHelper();

			// Get BLOB field
			byte[] accessListBLOB = bean.getAccessList();
			String name = bean.getAccessListFileName();

			// Output blob to stream
			if ( (name != null) && (name.length() > 0) && (accessListBLOB != null) ) {
				response.setContentType("application/octet-stream; name=" + name);
				response.setHeader("Content-Disposition", "inline;filename=" + name);
				out.write(accessListBLOB);
				out.flush();
				out.close();
			}
			*/
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
}
}
