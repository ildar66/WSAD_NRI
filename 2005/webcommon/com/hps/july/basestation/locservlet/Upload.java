package com.hps.july.basestation.locservlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Сервлет обрабатывающий загрузку данных из файла Excel 
 */
public class Upload extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                                throws ServletException, IOException {

    String redirectUrl = "";
    String redirectBase = "";
    String parameter = "";
    int fileCount = 0;
		

    System.out.println("Upload Start");
    try {
      File uploadDir = new File( AppConstants.uploadDir ); 		

      //uploadDir.mkdir();      
      //uploadDir.deleteOnExit();      
      com.oreilly.servlet.MultipartRequest multi =
        new com.oreilly.servlet.MultipartRequest(req, uploadDir.toString());


      Enumeration params = multi.getParameterNames();

      while (params.hasMoreElements()) {
	    parameter =	(String)params.nextElement();	
            if (parameter.compareToIgnoreCase("RETPATH") == 0)
            {
              redirectBase =  multi.getParameter(parameter) + "?";
            } else
            {

              if (multi.getParameter(parameter) != null) 
                   redirectUrl+= "&" + parameter + "=" +  multi.getParameter(parameter);
              else
                   redirectUrl+= "&" + parameter + "=";
            }
      }
      Enumeration files = multi.getFileNames();
      while (files.hasMoreElements()) {
        String name = (String)files.nextElement();
        String filename = multi.getFilesystemName(name);
        redirectUrl+=  "&" + name + "=";
        if (filename != null)
        {
          File file = new File(uploadDir,filename);
          //file.deleteOnExit();
          fileCount++;   
          redirectUrl+= filename; 
        }
      }
      //if (fileCount == 0)
      //   uploadDir.delete();
      res.sendRedirect(redirectBase  + req.getQueryString() +  redirectUrl );
    }
    catch (Exception e) {
	    e.printStackTrace(System.out);
    }
  }
}
