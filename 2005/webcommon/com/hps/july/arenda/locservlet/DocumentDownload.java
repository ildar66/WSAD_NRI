package com.hps.july.arenda.locservlet;

import javax.servlet.*;
import com.hps.july.persistence.*;
/**
 * Сервлет загрузки документов "Аренда"
 */
public class DocumentDownload extends javax.servlet.http.HttpServlet {
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
    try {
        int id = 0;
        /*String param = (String) request.getParameter("param");
        if (param == null) {
            param = "";
        }*/
        
        try {
            id = Integer.parseInt((String) request.getParameter("leaseDocument"));
        } catch (Exception e) {
	        e.printStackTrace();
        }
        
        if (id != 0) {
            ServletOutputStream out = response.getOutputStream();

            LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
            bean.setInitKey_leaseDocument(id);
            bean.refreshCopyHelper();

            LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
            beanBLOB.setInitKey_leaseDocument(id);
            beanBLOB.refreshCopyHelper();

			byte[] documentText = beanBLOB.getDocumentText();
			String name = bean.getDocFileName();
			if (documentText != null && documentText.length > 0 && name != null && !name.equals("")) {
				response.setContentType("application/octet-stream; name=" + response.encodeURL(name));
				response.setHeader("Content-Disposition", "inline;filename=" + response.encodeURL(name));
				out.write(documentText);
				out.flush();
				out.close();
			}
        } else {
            System.out.println("DocumentDownload: performTask: id=" + id);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
