package com.hps.july.apptags;

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.apache.xerces.parsers.SAXParser;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Класс для разбора web.xml, используется при проверке прав доступа.
 * Creation date: (09.02.2003 19:49:45)
 * @author: Alexander Shrago
 */
public class HasAccessBean extends DefaultHandler {
	private HttpServletRequest request;
	private String url;
	private boolean isInSecurityConstr = false;
	private boolean isFoundURL = false;
	private boolean isCheckURL = false;
	private boolean hasAccess = false;
	private boolean isCheckRole = false;
	private final String AllAuthenticated = "AllAuthenticated";
public void characters(char[] chars, int start, int length) {
    if (!hasAccess) {
 
        String elementText = new String(chars, start, length);
 
        if (isCheckURL) {
            if (elementText.trim().equals(url))
                isFoundURL = true;
 
        } else
            if (isCheckRole) {
                if (isUserInRole(request, elementText)|| elementText.equals(AllAuthenticated))
                    hasAccess = true;
            }
 
        isCheckURL = false;
        isCheckRole = false;
    }
 
}
public void endElement(String uri, String localName, String qName) {
    if (!hasAccess) {
        if (localName.trim().equals("security-constraint")) {
            isInSecurityConstr = false;
            isFoundURL = false;
        }
    }
}
public boolean hasAccess(
    HttpServletRequest request,
    String url,
    String fileName)
    throws SAXException, IOException {

    this.request = request;
    this.url = url;
    try {
        parse(fileName);
    } catch (Exception e) {
        DebugSupport.printlnError(e);
	    //for VA
	    hasAccess = true;
    } finally {
	    this.request = null;
    }
    return hasAccess;
}
/**
 * Insert the method's description here.
 * Creation date: (09.02.2003 21:31:32)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 * @param role java.lang.String
 */
private boolean isUserInRole(HttpServletRequest request, String role) {
	if(request != null) {
		return request.isUserInRole(role);
	} else {
		return false;
	}
	//return url.equals("typeprojectList.do");
}
public void parse(String filename) throws SAXException, IOException {

    XMLReader xmlReader = new SAXParser();
    xmlReader.setContentHandler(this);

    String featureURI =
        "http://apache.org/xml/features/nonvalidating/load-external-dtd";
    xmlReader.setFeature(featureURI, false);

    try {
//DebugSupport.printlnTest("HasAccessBean parse name="+filename);
	    xmlReader.parse(new InputSource(filename));
    } catch (Exception ex) {
	    DebugSupport.printlnError(ex);
        System.out.println(ex);
        throw new IOException(ex.getMessage());
    }

}
public void startElement(
    String uri,
    String localName,
    String qName,
    Attributes attrs) {

    if (!hasAccess) {

        if (isInSecurityConstr) {
            if (isFoundURL) {
                if (localName.trim().equals("role-name"))
                    isCheckRole = true;
            } else
                if (localName.trim().equals("url-pattern"))
                    isCheckURL = true;
        } else
            if (localName.trim().equals("security-constraint"))
                isInSecurityConstr = true;
    }

}
}
