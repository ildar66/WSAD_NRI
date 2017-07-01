package com.hps.july.siteinfo.locservlet;

import javax.transaction.*;
import javax.naming.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.hps.july.persistence.*;

/**
 * Сервлет для просмотра карты прохода
 */
public class CardPassView
	extends javax.servlet.http.HttpServlet
{
public void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    ServletOutputStream out = null;
    PrintWriter pr = null;
    //PrintWriter debug = null;
    try {
	    //debug = new PrintWriter(new BufferedWriter(new FileWriter("/opt/WebSphere/AppServer/logs/debug/debug.log")));
        int position = Integer.parseInt(request.getParameter("position"));
        String namedVal = request.getParameter("namedValue");
//debug.println("position="+position);
//debug.println("namedVal="+namedVal);

        NamedValueAccessBean nvab = new NamedValueAccessBean();
        nvab.setInitKey_id(namedVal);
        nvab.refreshCopyHelper();
        int namedValue = nvab.getIntvalue();
//debug.println("namedValue="+namedValue);        

        int siteDoc = 0;
        Enumeration enum = new SiteDocAccessBean().findByPosition(new Integer(position), new Integer(2));
        while (enum.hasMoreElements()) {
            SiteDocAccessBean siteDocBean = (SiteDocAccessBean)enum.nextElement();
            if (namedValue == siteDocBean.getSiteDocTypeKey().sitedoctype) {
                siteDoc = siteDocBean.getSitedoc();
                break;
            }
        }

        /* 
        Context initial = new InitialContext();
        UserTransaction uTr = (UserTransaction) initial.lookup("java:comp/UserTransaction");
        uTr.setTransactionTimeout(60);
        uTr.begin();
        Sitedoc2SplaceAccessBean link = new Sitedoc2SplaceAccessBean();
        Enumeration enum = link.findSitedoc2SplacesByStoragePlace(new StoragePlaceKey(position));
        while (enum.hasMoreElements()) {
            Sitedoc2SplaceAccessBean temp = (Sitedoc2SplaceAccessBean)enum.nextElement();
            SiteDocAccessBean siteDocBean = temp.getSiteDoc();
//debug.println("\tsiteDocBean.getSiteDocTypeKey().sitedoctype="+siteDocBean.getSiteDocTypeKey().sitedoctype);
//debug.println("\tsiteDocBean.getSitedoc()"+siteDocBean.getSitedoc());
            if (namedValue == siteDocBean.getSiteDocTypeKey().sitedoctype) {
                siteDoc = siteDocBean.getSitedoc();
                break;
            }
        }
        uTr.commit();
//debug.println("siteDoc="+siteDoc);
		*/

        byte[] file = null;
        String name = null;
        if (siteDoc != 0) {
            SiteDocFileAccessBean ff = new SiteDocFileAccessBean();
            Enumeration en = ff.findBySitedocOrderBySitedocAsc(new Integer(siteDoc));
            while (en.hasMoreElements()) {
                SiteDocFileAccessBean temp = (SiteDocFileAccessBean) en.nextElement();
//debug.println("seteDocFileBean="+temp.getSitedocfile()); 
                
                SiteDocFileBLOBAccessBean blob = new SiteDocFileBLOBAccessBean();
                blob.setInitKey_sitedocfile(temp.getSitedocfile());
                blob.refreshCopyHelper();
                if ((name = temp.getSitedocfilename()) != null && 
	                (file = blob.getSitedocfilebody()) != null) {
                    break;
                }
            }
        }
//debug.println("name="+name+"; file="+file);
        if (file != null && name != null) {
            response.setContentType("application/msword; name=" + java.net.URLEncoder.encode(name));
            response.setHeader("Content-Disposition", "inline;filename=cardpass.doc");
            out = response.getOutputStream();
            out.write(file);
            out.flush();
        } else {
	        getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }

    } catch (Exception e) {
        getServletContext().log("Error in CardPassView.service", e);
    } finally {
        try {if (out != null)out.close();} catch (Exception e) {e.printStackTrace(System.out);}
        try {if (pr != null)pr.close();} catch (Exception e) {e.printStackTrace(System.out);}
        //try {if (debug != null)debug.close();} catch (Exception e) {e.printStackTrace(System.out);}
    }
}
}
