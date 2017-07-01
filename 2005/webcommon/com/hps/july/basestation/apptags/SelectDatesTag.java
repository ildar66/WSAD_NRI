package com.hps.july.basestation.apptags;

import java.util.*;
import java.util.Enumeration;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import org.apache.struts.util.*;
import com.hps.july.web.util.*;

/**
 * Таг для выбора дат из списка.
 * Атрибут collection должен указывать на свойство формы которое выдаёт список дат
 */
public class SelectDatesTag
	extends org.apache.struts.taglib.html.BaseFieldTag
{
    private String collection;
public int doStartTag()
	throws JspException
{
	StringBuffer res = new StringBuffer();

	res.append("<select name=\""+property+"\"");
	if(getSize() != null) {
		res.append(" size=\""+getSize()+"\"");
	}
	if(getStyleClass() != null) {
		res.append(" class=\""+getStyleClass()+"\"");
	}
	if(getStyle() != null) {
		res.append(" style=\""+getStyle()+"\"");
	}
	if(getOnchange() != null) {
		res.append(" onchange=\"");
		res.append(getOnchange());
		res.append("\"");
	}
	if(getOnclick() != null) {
		res.append(" onclick=\"");
		res.append(getOnclick());
		res.append("\"");
	}	
	res.append(">\n");

	StringAndSqlDateProperty val = new StringAndSqlDateProperty();
	Object ov = RequestUtils.lookup(pageContext, name, property, null);
	try {
		Object o = RequestUtils.lookup(pageContext, name, collection, null);
		if(o instanceof Enumeration) {
			Enumeration en = (Enumeration)o;
			Object ob = null;
			if(en.hasMoreElements()) {
				while(en.hasMoreElements()) {
					ob = en.nextElement(); 
					if(ob instanceof java.sql.Date) {
						val.setSqlDate((java.sql.Date)ob);
							res.append("<option value=\""+ResponseUtils.filter(val.getString())+"\"");
						if(ov != null && ov.equals(val.getString())) {
							res.append(" selected");
						}
						res.append(">"+ResponseUtils.filter(val.getString())+"</option>\n");
					}
				}
			} else {
				res.append("<option value=\"\"></option>\n");
			}
		} else {
			System.out.println("Collection of class:"+o.getClass().getName());
		}
	} catch(Exception e) {
		System.out.println("Exception from SelectDatesTag.");
		e.printStackTrace(System.out);
	}

	res.append("</select>\n");

	// Print this field to our output writer
	ResponseUtils.write(pageContext, res.toString());

	return SKIP_BODY;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCollection() {
	return collection;
}
/**
 * 
 * @param newCollection java.lang.String
 */
public void setCollection(java.lang.String newCollection) {
	collection = newCollection;
}
}
