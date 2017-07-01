package com.hps.july.arenda.locservlet;

import javax.servlet.*;

import com.hps.july.arenda.cdbcobjects.*;
import com.hps.july.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (17.11.2005 10:08:47)
 * @author: Shafigullin Ildar
 */
public class RegistryBuchDocsWordDownload extends javax.servlet.http.HttpServlet {
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
    Integer id = null;

    try {
        id = new Integer((String) request.getParameter("code"));
        //System.out.println("id="+id);
    } catch (Exception e) {
        e.printStackTrace();
    }

    if (id != null) {
        try {
            ServletOutputStream out = response.getOutputStream();
            response.setLocale(new java.util.Locale("ru", "RU", "Cp1251"));

            try {
                 WordDocument doc = CDBC_LeaseRegistryBuchDocs_Object.loadWordExternal(id, request.getRemoteUser());

                byte[] text = doc.getText();
                String name = doc.getFilename();
                //System.out.println("name="+name);
                if (text != null && text.length > 0 && name != null && !name.equals("")) {
                    response.setContentType("application/msword; charset=windows-1251; name=" + java.net.URLEncoder.encode(name));
                    response.setHeader("Content-Disposition", "attachment;filename=attachment.doc");
                    out.write(text);
                } else {
                    response.setContentType("text/html; name=nofile.html");
                    response.setHeader("Content-Disposition", "attachment;filename=nofile.html");
                    String s =
                        "<html>"
                            + "<head><title>Опись документов</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/main.css\"></head>"
                            + "<body><span color=\"#CC0033\">Нет присоединённого файла для указанного документа.</span></body>"
                            + "</html>";
                    out.write(s.getBytes());
                }
            } catch (Exception e) {
                System.err.println("WordDownload: Cannot find");
                e.printStackTrace();
                response.setContentType("text/html; name=noDOC.html");
                response.setHeader("Content-Disposition", "attachment;filename=noDOC.html");
                String s =
                    "<html>"
                        + "<head><title>Опись документов</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/main.css\"></head>"
                        + "<body><span color=\"#CC0033\">Не найден указанный документ.</span></body>"
                        + "</html>";
                out.write(s.getBytes());
            } finally {
                out.flush();
                out.close();
            }
        } catch (java.io.IOException ioe) {
            System.err.println("WordDownload: Cannot get response output stream");
        }
    } else {
        System.out.println("WordDownload.performTask(): id=" + id);
    }
}
}
