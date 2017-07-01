package com.hps.july.arenda.locservlet;

import javax.servlet.http.*;
import javax.servlet.*;
import com.hps.july.cdbc.lib.*;
/**
 * Сервлет загрузки документов word "Аренда",
 * сохраненных в базе как "BLOB"
 */
public class MemoWordDownload extends javax.servlet.http.HttpServlet {
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
		id = Integer.parseInt((String) request.getParameter("idHeader"));
	} catch (Exception e) {
		e.printStackTrace();
	}

	if (id != 0) {
		try {
			ServletOutputStream out = response.getOutputStream();
			response.setLocale(new java.util.Locale("ru","RU","Cp1251"));

			try {
				CDBCRowObject ro = com.hps.july.cdbc.objects.CDBC_Memo_Object .findMemo(id);

				byte[] text = (byte[])ro.getColumn("filetext").asObject();
				String name = ro.getColumn("filename").asString();
				if (text != null && text.length > 0 && name != null && !name.equals("")) {
					response.setContentType("application/msword; charset=windows-1251; name=" + java.net.URLEncoder.encode(name));
					response.setHeader("Content-Disposition", "attachment;filename=attachment.doc" );
					out.write(text);
				} else {
					response.setContentType("text/html; name=nofile.html");
					response.setHeader("Content-Disposition", "attachment;filename=nofile.html");
					String s =
						"<html>"+
						"<head><title>Служебная записка</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/main.css\"></head>"+
						"<body><span color=\"#CC0033\">Нет присоединённого файла для указанного документа.</span></body>"+
						"</html>";
					out.write(s.getBytes());
				}
			} catch (Exception e) {
				System.err.println("MemoWordDownload: Cannot find");
				e.printStackTrace();
				response.setContentType("text/html; name=noact.html");
				response.setHeader("Content-Disposition", "attachment;filename=noact.html");
				String s =
					"<html>"+
					"<head><title>Служебная записка</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/main.css\"></head>"+
					"<body><span color=\"#CC0033\">Не найден указанный акт.</span></body>"+
					"</html>";
				out.write(s.getBytes());
			} finally {
				out.flush();
				out.close();
			}
		} catch(java.io.IOException ioe) {
			System.err.println("MemoWordDownload: Cannot get response output stream");
		}
	} else {
		System.out.println("MemoWordDownload.performTask(): idcwacode=" + id);
	}
}
}
