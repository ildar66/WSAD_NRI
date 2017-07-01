package com.hps.july.dictionary.locservlet;

import javax.servlet.*;
import com.hps.july.persistence.*;

/**
 * Сервлет для получения комментария для указанного оборудования
 */
public class UpdateResourceCateg extends javax.servlet.http.HttpServlet {
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
 * Обновляет информацию в БД о привязке ресурсов к категориям ввода
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

	int resource = 0;
	int category = 0;
	boolean doCreate = false;
	
	try {
		category = Integer.parseInt((String)request.getParameter("categ"));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	try {
		resource = Integer.parseInt((String)request.getParameter("resource"));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	try {
		String reqCreate = (String)request.getParameter("create");
		//System.out.println("UPDATE CATEG: reqCreate = " + reqCreate);
		if ("true".equalsIgnoreCase(reqCreate))
			doCreate = true;
		else
			doCreate = false;
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	System.out.println("UPDATE CATEG: categ=" + category + ", resource=" + resource + ", create=" + doCreate);
		try {
			ServletOutputStream out=response.getOutputStream();
			response.setContentType("text/plain");

			if (doCreate) {
				if (com.hps.july.logic.InputCategoryObject.createCategoryResource(new Integer(category), new Integer(resource)))
					out.print("OK");
				else
					out.print("ER");
			} else {
				if (com.hps.july.logic.InputCategoryObject.deleteCategoryResource(new Integer(category), new Integer(resource)))
					out.print("OK");
				else
					out.print("ER");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
}
}
