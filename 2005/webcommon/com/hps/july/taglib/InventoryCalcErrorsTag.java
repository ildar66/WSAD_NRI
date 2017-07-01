package com.hps.july.taglib;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import com.hps.july.cdbc.objects.CDBCInventoryDocumentError;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.util.ResponseUtils;

/**
 * ¬ывод сообщений об ошибках обсчета с красивым форматированием.
 * Creation date: (19.04.2002 10:59:47)
 * @author: Dmitry Dneprov
 */
public class InventoryCalcErrorsTag extends javax.servlet.jsp.tagext.TagSupport {
	private Integer document;
    /**
     * ќбработка открывающего тага
     */
    public int doStartTag() throws JspException {
	    CDBCInventoryDocumentError de = new CDBCInventoryDocumentError();
	    CDBCResultSet errors = de.listDocumentErrors(getDocument());
	    java.util.ListIterator it = errors.listIterator();
	    boolean haveErrors = false;
        StringBuffer results = new StringBuffer();
        StringBuffer resultsB = new StringBuffer();
        String dstate = de.getDocumentState(getDocument());
        while (it.hasNext()) {
			haveErrors = true;
			CDBCRowObject ro = (CDBCRowObject)it.next();
        	resultsB.append("<TR style='height:10'><TD valign='top'><FONT class='attention'><UL>");
			resultsB.append("<LI");
			try {
				Number n = (Number)ro.getColumn("errorlevel").asObject();
				switch(n.intValue()) {
				case 1:
					resultsB.append(" style=\"list-style-image:url(/images/edot.gif);\"");
					break;
				case 2:
					resultsB.append(" style=\"list-style-image:url(/images/wdot.gif);\"");
					break;
				}
			} catch(Exception e) {
			}
			resultsB.append(">");
        	resultsB.append(ro.getColumn("errortext").asString());
        	resultsB.append("</LI></UL></FONT></TD></TR>");
        }

        if (haveErrors) {
	        results.append("<TABLE class='main' width='100%' valign='top' style='height:20'>\r\n");
	        results.append("<TR style='height:10'><TD valign='top'><FONT class='red'><B>");
	        if(dstate != null && "2".equals(dstate)) {
		        results.append("ѕри сн€тии обсчета возникли следующие расхождени€:");
	        } else {
				results.append("ѕри обсчете документа возникли следующие расхождени€:");
	        }
	        results.append("</B></FONT></TD></TR>\r\n");
	        results.append(resultsB);
            results.append("</TABLE>\r\n");
	        // Print the results to our output writer
	        ResponseUtils.write(pageContext, results.toString());
        }
        // Continue processing this page
        return (EVAL_BODY_INCLUDE);
    }
/**
 * Insert the method's description here.
 * Creation date: (24.09.2004 20:38:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (24.09.2004 20:38:10)
 * @param newDocument java.lang.Integer
 */
public void setDocument(java.lang.Integer newDocument) {
	document = newDocument;
}
}
