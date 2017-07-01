package com.hps.july.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.util.PropertyUtils;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

/**
 * Таг для вывода строки с указанием максимальной длинны и точек переноса.
 * Creation date: (26.04.2002 19:38:43)
 * @author: Dmitry Dneprov
 */
public class StringWriteTag extends org.apache.struts.taglib.bean.WriteTag {
	private java.lang.String maxlength;
	private java.lang.String wrapat;
	private java.lang.String terminator;
/**
 * Constructor.
 * Creation date: (26.04.2002 20:10:31)
 */
public StringWriteTag() {
	setTerminator("...");
	setName(org.apache.struts.taglib.html.Constants.BEAN_KEY);
}
	/**
	 * Обработка открывающего тага
	*/	
    public int doStartTag() throws JspException {

        // Look up the requested bean (if necessary)
        Object bean = null;
        //if (getIgnore()) {
	        bean = RequestUtils.lookup(pageContext, name, scope);
            if (bean == null)
                return (SKIP_BODY);  // Nothing to output
        //}

        // Look up the requested property value
        Object value = null;
        if (bean instanceof com.hps.july.cdbc.lib.CDBCRowObject) {
	        value = ((com.hps.july.cdbc.lib.CDBCRowObject)bean).getColumn(property).asString();
        } else {
        	value = RequestUtils.lookup(pageContext, name, property, scope);
        }

        boolean needTermin = false;

        if (value != null) {
	        String strValue = value.toString();
			//System.out.println("STRINGWRITE Start: string=" + strValue);
	        if (maxlength != null) {
		        int len = strValue.length();
		        int origlen = len;
		        if (len > 0) {
			        try {
			        	len = Integer.parseInt(maxlength);
			        } catch (NumberFormatException e) {
				        e.printStackTrace(System.out);
			        }
			        if (len > strValue.length())
			        	len = strValue.length();
			        strValue = strValue.substring(0, len);
			        //System.out.println("After maxlength string=" + strValue);
			        if (len < origlen)
			        	needTermin = true;
		        }
	        }
	        if (wrapat != null) {
		        int len = wrapat.length();
		        try {
		        	len = Integer.parseInt(wrapat);
		        } catch (NumberFormatException e) {
			        e.printStackTrace(System.out);
		        }
		        if(strValue.length() > len) {
			        String srcStr = strValue;
			        strValue = "";
			        int i = 0;
			        //System.out.println("Before cycle strlen=" + srcStr.length() + ", len=" + len);
			        for (i=0; i < (srcStr.length()/len); i++) {
				        strValue = strValue + ResponseUtils.filter(srcStr.substring(i*len, (i+1)*len)) + "<WBR>";
					}
			        if((srcStr.length() % len) > 0) {
				        strValue = strValue + ResponseUtils.filter(srcStr.substring(i*len,srcStr.length()));
			        }
				}
		        else 
					strValue = ResponseUtils.filter(strValue);
	        }
	        else 
				strValue = ResponseUtils.filter(strValue);

			// Add terminator if needed	
		    if (needTermin)
			   strValue = strValue + getTerminator();
		    
		    // Print this property value to our output writer, suitably filtered
			ResponseUtils.write(pageContext, strValue);
        } else {
            return (SKIP_BODY);  // Nothing to output
        }

	// Continue processing this page
	return (SKIP_BODY);

    }
/**
 * Максимальное число символов строки, выводимое на экран.
 * Creation date: (08.07.2002 18:05:49)
 * @return java.lang.String
 */
public java.lang.String getMaxlength() {
	return maxlength;
}
/**
 * Символ(ы) отображаемые в конце обрезанной строки (по умолчанию - ...).
 * Creation date: (03.09.2003 19:09:14)
 * @return java.lang.String
 */
public java.lang.String getTerminator() {
	return terminator;
}
/**
 * Номер символа, после которого вставляется признак "мягкого" переноса строки <WBR>.
 * Creation date: (08.07.2002 18:06:22)
 * @return java.lang.String
 */
public java.lang.String getWrapat() {
	return wrapat;
}
/**
 * Максимальное число символов строки, выводимое на экран.
 * Creation date: (08.07.2002 18:05:49)
 * @param newMaxlength java.lang.String
 */
public void setMaxlength(java.lang.String newMaxlength) {
	maxlength = newMaxlength;
}
/**
 * Символ(ы) отображаемые в конце обрезанной строки (по умолчанию - ...).
 * Creation date: (03.09.2003 19:09:14)
 * @param newTerminator java.lang.String
 */
public void setTerminator(java.lang.String newTerminator) {
	terminator = newTerminator;
}
/**
 * Номер символа, после которого вставляется признак "мягкого" переноса строки <WBR>.
 * Creation date: (08.07.2002 18:06:22)
 * @param newWrapat java.lang.String
 */
public void setWrapat(java.lang.String newWrapat) {
	wrapat = newWrapat;
}
}
