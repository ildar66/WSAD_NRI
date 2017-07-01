package com.hps.july.siteinfo.locservlet;

import javax.servlet.*;
import com.hps.july.persistence.*;

/**
 * Сервлет для получения комментария для указанного оборудования
 */
public class GetEquipmentComment extends javax.servlet.http.HttpServlet {
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
 * Process incoming requests for information
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

	int storagecard = 0;
	try {
		storagecard = Integer.parseInt((String)request.getParameter("storagecard"));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	if (storagecard != 0) {

		try {
			ServletOutputStream out=response.getOutputStream();

			// Get AccessBean
			StorageCardAccessBean bean=new StorageCardAccessBean();
			bean.setInitKey_storagecard(storagecard);
			bean.refreshCopyHelper();

			response.setContentType("text/plain");
			String comment = bean.getComment();
			if (comment != null)
				out.write(comment.getBytes("Cp1251"));
			else
				out.print("");

			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
}
}
