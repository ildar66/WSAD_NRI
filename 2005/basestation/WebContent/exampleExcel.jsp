<%@ page language = "java" %>
<%@ page import="com.hps.july.inventory.formbean.*"%>
<%@ page import="java.util.*,java.io.*"%>

<%	
	response.setHeader("Cache-Control","");
	response.setContentType ("application/vnd.ms-excel");
	response.setHeader ("Content-Disposition", "attachment;	filename=\"example.xls\"");
	
	try{
		File file = new File("//opt//WebSphere//AppServer//logs", "example.xls");
		
		InputStream in = new FileInputStream(file);
		OutputStream outs = response.getOutputStream();		
		
		int bit = 256;
		int i = 0;
    		
        while ((bit) >= 0) {
        	bit = in.read();
        	outs.write(bit);
        }
        	
		outs.flush();
        outs.close();
        in.close();				

    }catch (IOException ioe) {
        ioe.printStackTrace(System.out);
    }   
            
%>