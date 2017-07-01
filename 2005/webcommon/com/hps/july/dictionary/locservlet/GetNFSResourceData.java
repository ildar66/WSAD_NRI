package com.hps.july.dictionary.locservlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
// import java.nio.charset;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * —ервлет дл€ получени€ данных ресурсов NFS в виде XML
 */
public class GetNFSResourceData extends javax.servlet.http.HttpServlet {
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
	
		Boolean isNFSCode = new Boolean(false);
		Boolean isManucode = new Boolean(false);
		Boolean isModel = new Boolean(false);
		Boolean isName = new Boolean(false);
		Boolean isManuf = new Boolean(false);
		if ("A".equals(searchby))
			isNFSCode = new Boolean(true);
		if ("B".equals(searchby))
			isManucode = new Boolean(true);
		if ("C".equals(searchby))
			isModel = new Boolean(true);
		if ("D".equals(searchby))
			isName = new Boolean(true);
		if ("E".equals(searchby))
			isManuf = new Boolean(true);
		
		try {
			response.setContentType("application/xml; charset=WINDOWS-1251");
			java.io.PrintWriter out=response.getWriter();
			out.print("<?xml version=\"1.0\" encoding=\"WINDOWS-1251\" ?>");
			out.print("<ROOT>");
			CDBCResultSet rs = CDBCResourcesObject.findNFSResources(isNFSCode, searchparam,
					isManucode, searchparam,
					isModel, searchparam,
					isName, searchparam,
					isManuf, searchparam
				);
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
	
	public static String decodeString(HttpServletRequest req, String valueIn, boolean isHardIso) {
		String valueOutStr = null;
		try {
			String requestEnc = req.getCharacterEncoding();
			if(requestEnc==null) {
				requestEnc="ISO-8859-1"; }
			String clientEnc = req.getParameter("charset");
			if(clientEnc==null) { 
				clientEnc="Cp1251"; 
			} 
			if (valueIn!=null) {
				if (isHardIso) {
					valueOutStr = new String(valueIn.getBytes("ISO-8859-1"),clientEnc);
				} else {
					valueOutStr = new String(valueIn.getBytes(requestEnc),clientEnc);
				}
			}
			System.out.println("### DecodeString requestEnc=" + requestEnc + "charset=" + clientEnc + ": valueIn " + valueIn + " valueOutStr = " + valueOutStr + " isHardIso = " + isHardIso);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return valueOutStr;
	}	

	/**
	 * @param request
	 * @param valueIn
	 * @return
	 */
	protected String decode1251String(HttpServletRequest request, String valueIn) {
		String valueOutStr = null;
		try {
			if (valueIn!=null) { 
				valueOutStr = new String(valueIn.getBytes("Cp1251"), "Cp1251");
			}
			System.out.println("### decode1251String requestEnc=" + ": valueIn " + valueIn + " valueOutStr = " + valueOutStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return valueOutStr;
	}

	/*
	protected String decodeUTF8String(HttpServletRequest request, String valueIn) {
		String valueOutStr = null;
		try {
			if (valueIn!=null) { 
				valueOutStr = new String(valueIn.getBytes("UTF-8"), "UTF-8");
			}
			System.out.println("### decodeUTF8String requestEnc=" + ": valueIn " + valueIn + " valueOutStr = " + valueOutStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return valueOutStr;
	}
	*/
	
}
