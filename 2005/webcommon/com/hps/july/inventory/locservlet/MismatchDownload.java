package com.hps.july.inventory.locservlet;

import javax.servlet.*;
import com.hps.july.persistence.*;

/**
 * Сервлет осуществляющий выгрузку присоединяемого файла к документу "Акт рассогласования"
 */
public class MismatchDownload extends javax.servlet.http.HttpServlet {
public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
	performTask(request, response);
}
public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
	performTask(request, response);
}
public String getServletInfo() {
	return super.getServletInfo();
}
public void init() {
}
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
	int text = 0;
	try {
		text = Integer.parseInt((String)request.getParameter("document"));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}

	if (text != 0) {

		try {
			ServletOutputStream out=response.getOutputStream();

			// Get AccessBean
			InWayBillBLOBAccessBean bean = new InWayBillBLOBAccessBean();
			bean.setInitKey_document(text);
			bean.refreshCopyHelper();

			// Get BLOB field
			byte[] blob = bean.getDActText();
			String name = bean.getDActTextFileName();

			// Output blob to stream
			if ( (name != null) && (name.length() > 0) && (blob != null) ) {
				response.setContentType("application/octet-stream; name=" + java.net.URLEncoder.encode(name));
				response.setHeader("Content-Disposition", "inline;filename=" + java.net.URLEncoder.encode(name));
				out.write(blob);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
}
