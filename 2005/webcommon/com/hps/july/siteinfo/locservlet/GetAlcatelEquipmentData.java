package com.hps.july.siteinfo.locservlet;

import javax.servlet.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * —ервлет дл€ получени€ данных от оборудовани€ в виде XML
 */
public class GetAlcatelEquipmentData extends javax.servlet.http.HttpServlet {
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

	CDBCOSSEquipmentObject ossobj = new CDBCOSSEquipmentObject();
	java.sql.Connection con = null;
	Integer gsmid = null;
	try {
		gsmid = new Integer(Integer.parseInt((String)request.getParameter("gsmid")));
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	gsmid = ossobj.convertGSMID(gsmid);
	
	if (request.getParameter("datainfo")  != null) {
			try {
				response.setContentType("application/xml; charset=WINDOWS-1251");
				java.io.PrintWriter out=response.getWriter();
				out.print("<?xml version=\"1.0\" encoding=\"WINDOWS-1251\" ?>");
				out.print("<ROOT>");
				CDBCResultSet rs = ossobj.findDataLoadHeader(gsmid);
				java.util.ListIterator it = rs.listIterator();
				while (it.hasNext()) {
					CDBCRowObject ro = (CDBCRowObject)it.next();
					out.print("<dataload>");
					out.print(CDBCXMLSerializer.serializeRecord(ro));
					out.print("</dataload>");
				}
				out.print("</ROOT>");

				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
	} else {

		if (gsmid != null) {

			try {
				ServletOutputStream out=response.getOutputStream();

				response.setContentType("text/xml");
				out.print("<?xml version=\"1.0\" ?>");
				out.print("<ROOT>");
				CDBCResultSet rs = ossobj.getAlcatelDataHeaders(gsmid);
				java.util.ListIterator it = rs.listIterator();
				while (it.hasNext()) {
					CDBCRowObject ro = (CDBCRowObject)it.next();
					out.print("<equipmentdataheader>");
					out.print(CDBCXMLSerializer.serializeRecord(ro));
					Integer headID = (Integer)ro.getColumn("dataheadid").asObject();
					if (headID != null) {
						CDBCResultSet rs2 = ossobj.getAlcatelData(headID);
						java.util.ListIterator it2 = rs2.listIterator();
						while (it2.hasNext()) {
							CDBCRowObject ro2 = (CDBCRowObject)it2.next();
							out.print("<equipmentdata>");
							out.print(CDBCXMLSerializer.serializeRecord(ro2));
							out.print("</equipmentdata>");
						}
					}
					out.print("</equipmentdataheader>");
				}
				out.print("</ROOT>");

				out.flush();
				out.close();
				System.out.println("GetData END");
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}
}
}
