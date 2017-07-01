package com.hps.july.taglib;

import com.hps.july.web.util.BrowseForm;
import java.net.*;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import org.apache.struts.taglib.html.*;
import javax.servlet.jsp.PageContext;

/**
 * ������ "+" - �������� ������. ������������ �������� ����, ���� ���� ���-
 * �� ������������
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class AddButtonTag extends LinkTag {
    private boolean canAdd;
    private String image;
    
    /**
     * ��������� ������������ ����
    */
    public int doEndTag() throws javax.servlet.jsp.JspException {

        if (canAdd) {
            return super.doEndTag();
        }

        // Evaluate the body of this tag
        return EVAL_PAGE;

    }
    
    /**
     * ��������� ������������ ����
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

     	//��������� ���� ������ !	
	    setType(new String("Add"));
     	
	    canAdd = RolesValidation.canModify(pageContext);

        if (image == null || "".equals(image.trim())) {
            image = "plus.gif";
        }

        StringBuffer results = new StringBuffer("");
        if (canAdd) {
            if (getTitle() == null)
                if (getAlttext() == null)
                    setAlttext("button.add");
            super.doStartTag();
            // Generate the opening anchor element
            results.append(
                "<IMG SRC=\"/images/" + image + "\" BORDER='0' ALT='" + getTitle() + "'>");
            results.append("<IMG SRC=\"/images/empty.gif\" BORDER='0' ALT='' WIDTH='3'>");
        } else {
            //results.append("&nbsp;");
        }
        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);

    }
    
    /**
     * ������������� ����������� ������
     * @return java.lang.String
     */
    public java.lang.String getImage() {
        return image;
    }
    
    /**
     * ������������� ����������� ������
     * @param newImage java.lang.String
     */
    public void setImage(java.lang.String newImage) {
        image = newImage;
    }
}