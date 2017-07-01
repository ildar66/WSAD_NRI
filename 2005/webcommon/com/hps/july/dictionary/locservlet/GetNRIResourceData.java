package com.hps.july.dictionary.locservlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * @author irogachev
 */
public class GetNRIResourceData  extends GetNFSResourceData {

	public GetNRIResourceData() {
		super();
	}

/**
 * ѕерекрываем метод выполнени€ основного действи€
 */
public void performTask(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		//
		String searchparam = (String)request.getParameter("searchparam");
		System.out.println("#### searchparam = "+searchparam);
		String encodeSearchparamServCodePage = decodeString(request, searchparam, false);
		System.out.println("#### encodeSearchparamServCodePage = "+encodeSearchparamServCodePage);
		String encodeSearchparamIsoCodePage = decodeString(request, searchparam, true);
		System.out.println("#### encodeSearchparamIsoCodePage = "+encodeSearchparamIsoCodePage);
		String searchby = (String)request.getParameter("searchby");
		System.out.println("#### searchby = "+searchby);
		
		String encodeSearchparam1251 = decode1251String(request, searchparam);
		System.out.println("#### encodeSearchparam1251 = "+encodeSearchparam1251);
		searchparam = encodeSearchparam1251;
		System.out.println("#### last version searchparam = "+searchparam);
	
		Boolean isModel = new Boolean(false);
		Boolean isName = new Boolean(false);
		Boolean isNRICode = new Boolean(false);
		
		if ("A".equals(searchby))
			isModel = new Boolean(true);
		if ("B".equals(searchby))
			isName = new Boolean(true);
		if ("C".equals(searchby))
			isNRICode = new Boolean(true);
		
		try {
			response.setContentType("application/xml; charset=WINDOWS-1251");
			java.io.PrintWriter out=response.getWriter();
			out.print("<?xml version=\"1.0\" encoding=\"WINDOWS-1251\" ?>");
			out.print("<ROOT>");
			CDBCResultSet rs = CDBCResourcesObject.findNRIResources(isModel, isName,
					isNRICode, searchparam
				);
			System.out.println("### rs.getRowsCount() = "+rs.getRowsCount());	
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

	}

}

