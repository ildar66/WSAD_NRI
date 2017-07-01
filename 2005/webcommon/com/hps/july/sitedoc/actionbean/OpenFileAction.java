package com.hps.july.sitedoc.actionbean;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import java.io.IOException;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Выгружает файл присоединённый к документу
 */
public class OpenFileAction 
	extends org.apache.struts.action.Action
{
public ActionForward perform(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    super.perform(mapping, form, request, response);

    try {

        int sitedocfile =
            Integer.parseInt((String) request.getParameter("sitedocfile"));

        ServletOutputStream out = response.getOutputStream();

        // Get AccessBean
        SiteDocFileBLOBAccessBean beanBody = new SiteDocFileBLOBAccessBean();
        beanBody.setInitKey_sitedocfile(sitedocfile);
        beanBody.refreshCopyHelper();

         SiteDocFileAccessBean beanName = new SiteDocFileAccessBean();
        beanName.setInitKey_sitedocfile(sitedocfile);
        beanName.refreshCopyHelper();

        // Get BLOB field
        byte[] blob = beanBody.getSitedocfilebody();
        String name = beanName.getSitedocfilename();

        // Output blob to stream
        if ((name != null) && (name.length() > 0) && (blob != null)) {
	        String result = transliterate(name);
            response.setContentType("application/octet-stream; name=" + result + ";charset=windows-1251");
            response.setContentLength(blob.length);
            String disposition = "attachment;filename=\"" + result + "\";";
            //System.out.println(disposition);
            response.setHeader("Content-Disposition", disposition);
            //delete headers Pragma and Cache-Control set empty values for this parameters
            response.setHeader("Pragma", "");
            response.setHeader("Cache-Control", "");
            out.write(blob);
            out.flush();
            out.close();
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw new ServletException(e);
    } finally {
        return null;
    }
}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.02.2005 14:54:24)
	 * @return java.lang.String
	 * @param s java.lang.String
	 */
	private String transliterate(String s) {
		StringBuffer result = new StringBuffer();

		char [] rus = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н',
					'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'э', 'ю', 'я',
					'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н',
					'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я' };
 		String [] lat = {"a", "b", "v", "g", "d", "e", "zh", "z", "i", "iy", "k", "l", "m", "n",
	 				"o", "p", "r", "s", "t", "u", "f", "ch", "c", "ch", "sh", "sch", "e", "uy", "ya", 
					"A", "B", "V", "G", "D", "E", "ZH", "Z", "I", "IY", "K", "L", "M", "N",
					"O", "P", "R", "S", "T", "U", "F", "CH", "C", "CH", "SH", "SCH", "E", "UY", "YA" };

 		char []	ca = s.toCharArray();
 		for(int i = 0; i < ca.length; i++) {
	 		boolean aFlag = false;
	 		for(int j = 0; j < rus.length; j++) {
		 		if(ca[i] == rus[j]) {
					result.append(lat[j]);
					aFlag = true;
					break;
		 		}
	 		}
	 		if(!aFlag) result.append(ca[i]);
 		}
 		rus = null;
 		lat = null;
		return result.toString();
	}
}
