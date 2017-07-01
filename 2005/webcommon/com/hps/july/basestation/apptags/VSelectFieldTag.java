package com.hps.july.basestation.apptags;

import java.util.*;
import java.util.Enumeration;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspException;
import org.apache.struts.util.*;

/**
 * “аг дл€ вывода комбобокса с зависимыми значени€ми.
 * ѕредставл€ет из себ€ комбобокс с набором значений, выбира€ которые,
 * в св€занном поле по€вл€ютс€ значени€ соответствуещие выбранному
 */
public class VSelectFieldTag
	extends org.apache.struts.taglib.html.BaseFieldTag
{
    private String collection;

    private String keyname;
    private String idname;
    private String valuename;
    private String target;
public int doStartTag()
	throws JspException
{
	StringBuffer res = new StringBuffer();

	ArrayList keys = new ArrayList();
	ArrayList vals = new ArrayList();
	String key;
	String id;
	String val;
		
	try {
		Object o = RequestUtils.lookup(pageContext, name, collection,  null);

		if(o instanceof Enumeration) {
			Enumeration en = (Enumeration)o;
			Object ob = null;
			if(en.hasMoreElements()) {
				// draw javascript function
				res.append("<script language=\"javascript\">\n");
				res.append("function onChangeSelect_"+collection+"() {\n");
				res.append("var sel = document.all['"+collection+"'];\n");
				res.append("var selfld = document.all['"+target+"'];\n");
				res.append("selfld.value = "+collection+"_arr[sel.options[sel.selectedIndex].value];\n");
				res.append("}\n");
				res.append("</script>\n");
				res.append("\n");
				// draw seelct
				res.append("<select name="+collection+" onChange=\"onChangeSelect_"+collection+"();\">\n");
				while(en.hasMoreElements()) {
					ob = en.nextElement();
					key = ""+PropertyUtils.getProperty(ob,keyname);
					id = ""+PropertyUtils.getProperty(ob,idname);
					val = ""+PropertyUtils.getProperty(ob,valuename);
					res.append("<option value=\""+ResponseUtils.filter(key)+"\">"+ResponseUtils.filter(id)+"</option>\n");
					keys.add(key);
					vals.add(val);
				}
				res.append("</select>\n");
			} else {
				res.append("<script language=\"javascript\">\n");
				res.append("function onChangeSelect_"+collection+"() {}\n");
				res.append("</script>\n");
				res.append("<select name="+collection+" onChange=\"onChangeSelect_"+collection+"();\">\n");
				res.append("<option value=\"\"></option>\n");
				res.append("</select>\n");
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	// draw array
	if(keys.size() > 0) {	
		res.append("<script language=\"javascript\">\n");
		res.append("var "+collection+"_arr = new Array();\n");
	
		Object[] keysa = keys.toArray();
		Object[] valsa = vals.toArray();
		for(int i = 0; i < keysa.length; i++) {
			res.append(""+collection+"_arr['"+keysa[i]+"'] = '"+valsa[i]+"';\n");
		}

//		res.append("onChangeSelect_"+collection+"();\n");
		res.append("</script>");
	}

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
 * @return java.lang.String
 */
public java.lang.String getIdname() {
	return idname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getKeyname() {
	return keyname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getTarget() {
	return target;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getValuename() {
	return valuename;
}
/**
 * 
 * @param newCollection java.lang.String
 */
public void setCollection(java.lang.String newCollection) {
	collection = newCollection;
}
/**
 * 
 * @param newIdname java.lang.String
 */
public void setIdname(java.lang.String newIdname) {
	idname = newIdname;
}
/**
 * 
 * @param newKeyname java.lang.String
 */
public void setKeyname(java.lang.String newKeyname) {
	keyname = newKeyname;
}
/**
 * 
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * 
 * @param newTarget java.lang.String
 */
public void setTarget(java.lang.String newTarget) {
	target = newTarget;
}
/**
 * 
 * @param newValuename java.lang.String
 */
public void setValuename(java.lang.String newValuename) {
	valuename = newValuename;
}
}
