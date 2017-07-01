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
 * Кнопка "Печать". Предназначена для печати отчетов.
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class PrintButtonTag extends LinkTag {
    private java.lang.String newWindowName;
    private String alt;
    private String image;
    
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        if ((getNewWindowName() == null) || (getNewWindowName().length() == 0))
            setNewWindowName("pWindow");
        setOnclick(
            "window.open(this.href, '"
                + getNewWindowName()
                + "', 'top=100, left=100, width=700, height=500, scrollbars=yes, resizable=yes'); return false;");

        super.doStartTag();

        StringBuffer results = new StringBuffer("");

        if (image == null || "".equals(image)) {
            image = "print.gif";
        }
        if (alt == null || "".equals(alt)) {
            alt = "Напечатать";
        }
        // Generate the opening anchor element
        results.append("<IMG SRC=\"/images/empty.gif\" BORDER='0' ALT='' WIDTH='3'>");
        results.append(
            "<IMG SRC=\"/images/" + image + "\" BORDER='0' ALT='" + alt + "'>");

        // Print this element to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Evaluate the body of this tag
        return (EVAL_BODY_TAG);
    }
    /**
     * Текст подсказки для кнопки
     * @return java.lang.String
     */
    public java.lang.String getAlt() {
        return alt;
    }
    /**
     * Алтернативная картинка для кнопки
     * @return java.lang.String
     */
    public java.lang.String getImage() {
        return image;
    }
    /**
     * Имя окна, в котром будет печататься отчет.
     * Creation date: (18.07.2002 17:15:57)
     * @return java.lang.String
     */
    public java.lang.String getNewWindowName() {
        return newWindowName;
    }
    /**
     * Текст подсказки для кнопки
     * @param newAlt java.lang.String
     */
    public void setAlt(java.lang.String newAlt) {
        alt = newAlt;
    }
    /**
     * Алтернативная картинка для кнопки
     * @param newImage java.lang.String
     */
    public void setImage(java.lang.String newImage) {
        image = newImage;
    }
    /**
     * Имя окна, в котром будет печататься отчет.
     * Creation date: (18.07.2002 17:15:57)
     * @param newNewWindowName java.lang.String
     */
    public void setNewWindowName(java.lang.String newNewWindowName) {
        newWindowName = newNewWindowName;
    }
}
