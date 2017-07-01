<%@ page language = "java" %>
<%@ page import="com.hps.july.basestation.formbean.*"%>
<%@ page import="java.util.*,java.io.*"%>

<%	
	ExportFileForm form = (ExportFileForm)session.getAttribute("ExportFileForm");
	
	response.setHeader("Cache-Control","");
	response.setContentType ("text/plain; charset=windows-1251");
	response.setHeader ("Content-Disposition", "attachment;	filename=export.txt");
	
		
		
		Writer outs = response.getWriter();		

    		try {
				outs.write(form.getFile());						
				outs.flush();
				outs.close();
			}catch (IOException ioe) {
           		ioe.printStackTrace(System.out);
            }
%>