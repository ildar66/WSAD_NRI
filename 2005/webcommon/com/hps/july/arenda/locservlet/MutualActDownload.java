package com.hps.july.arenda.locservlet;

import javax.servlet.http.*;
import javax.servlet.*;
import com.hps.july.persistence.*;
/**
 * Сервлет загрузки документов word "Аренда",
 * сохраненных в базе как "BLOB"
 */
public class MutualActDownload extends javax.servlet.http.HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	performTask(request, response);
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws javax.servlet.ServletException, java.io.IOException
{
	performTask(request, response);
}
public String getServletInfo() {
	return super.getServletInfo();
}
/**
 * Initializes the servlet.
 */
public void init() {
	// insert code to initialize the servlet here
}
public void performTask(HttpServletRequest request, HttpServletResponse response)
{
	int id = 0;

	try {
		id = Integer.parseInt((String) request.getParameter("actcode"));
	} catch (Exception e) {
		e.printStackTrace();
	}

	if (id != 0) {
		try {
			ServletOutputStream out = response.getOutputStream();
			response.setLocale(new java.util.Locale("ru","RU","Cp1251"));

//			LeaseMutualActNewAccessBean bean = new LeaseMutualActNewAccessBean();
//			bean.setInitKey_leaseDocument(id);
//			bean.refreshCopyHelper();

			try {
				LeaseMutualActBLOBAccessBean beanBLOB = new LeaseMutualActBLOBAccessBean();
				beanBLOB.setInitKey_leasedocument(id);
				beanBLOB.refreshCopyHelper();

				byte[] acttext = beanBLOB.getActtext();
				String name = beanBLOB.getActfilename();
				if (acttext != null && acttext.length > 0 && name != null && !name.equals("")) {
					response.setContentType("application/msword; charset=windows-1251; name=" + java.net.URLEncoder.encode(name));
					response.setHeader("Content-Disposition", "attachment;filename=attachment.doc" );
					out.write(acttext);
				} else {
					response.setContentType("text/html; name=nofile.html");
					response.setHeader("Content-Disposition", "attachment;filename=nofile.html");
					String s =
						"<html>"+
						"<head><title>Ведение договоров аренды</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/main.css\"></head>"+
						"<body><span color=\"#CC0033\">Нет присоединённого файла для указанного акта.</span></body>"+
						"</html>";
					out.write(s.getBytes());
				}
			} catch (Exception e) {
				System.err.println("MutualActDownload: Cannot find blob");
				e.printStackTrace();
				response.setContentType("text/html; name=noact.html");
				response.setHeader("Content-Disposition", "attachment;filename=noact.html");
				String s =
					"<html>"+
					"<head><title>Ведение договоров аренды</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/main.css\"></head>"+
					"<body><span color=\"#CC0033\">Не найден указанный акт.</span></body>"+
					"</html>";
				out.write(s.getBytes());
			} finally {
				out.flush();
				out.close();
			}
		} catch(java.io.IOException ioe) {
			System.err.println("MutualActDownload: Cannot get response output stream");
		}
	} else {
		System.out.println("MutualActDownload: performTask: id=" + id);
	}
}
}
