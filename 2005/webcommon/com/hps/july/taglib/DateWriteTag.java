package com.hps.july.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.util.PropertyUtils;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

/**
 * Таг вывода даты в заданном формате.
 * Creation date: (26.04.2002 19:38:43)
 * @author: Dmitry Dneprov
 */
public class DateWriteTag extends org.apache.struts.taglib.bean.WriteTag {
	private boolean showtime;
	private boolean showyear;
	private boolean shortformat;
/**
 * Constructor.
 * Creation date: (26.04.2002 20:10:31)
 */
public DateWriteTag() {
	setShowtime(false);
	setShortformat(false);
	setShowyear(true);
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
	        value = ((com.hps.july.cdbc.lib.CDBCRowObject)bean).getColumn(property).asObject();
        } else {
            value = RequestUtils.lookup(pageContext, name, property, scope);
        }

        if (value != null && value instanceof java.util.Date) {
		    // Print this property value to our output writer, suitably filtered
		    java.text.SimpleDateFormat format = null;
		    String yearFormat = "yyyy";
		    if (isShortformat())
		    	yearFormat = "yy";

		    if (isShowyear()) {
			    if (isShowtime())
			    	format = new java.text.SimpleDateFormat("dd.MM." + yearFormat + " HH:mm:ss");
			    else
			    	format = new java.text.SimpleDateFormat("dd.MM." + yearFormat);
		    } else {
			    format = new java.text.SimpleDateFormat("dd.MMM", new java.util.Locale("ru", "RU"));
		    }
	        String output = format.format((java.util.Date)value);
	        ResponseUtils.write(pageContext, ResponseUtils.filter(output));
        } else {
            return (SKIP_BODY);  // Nothing to output
        }

	// Continue processing this page
	return (SKIP_BODY);

    }
/**
 * Признак вывода даты в коротком формате (2 цифры года).
 * Creation date: (21.05.2003 16:19:29)
 * @return boolean
 */
public boolean isShortformat() {
	return shortformat;
}
/**
 * Признак вывода времени после даты.
 * Creation date: (26.04.2002 20:08:40)
 * @return boolean
 */
public boolean isShowtime() {
	return showtime;
}
/**
 * Признак вывода цифр года.
 * Creation date: (21.05.2003 16:19:29)
 * @return boolean
 */
public boolean isShowyear() {
	return showyear;
}
/**
 * Признак вывода даты в коротком формате (2 цифры года).
 * Creation date: (21.05.2003 16:19:29)
 * @param newShortformat boolean
 */
public void setShortformat(boolean newShortformat) {
	shortformat = newShortformat;
}
/**
 * Признак вывода времени после даты.
 * Creation date: (26.04.2002 20:08:40)
 * @param newShowtime boolean
 */
public void setShowtime(boolean newShowtime) {
	showtime = newShowtime;
}
/**
 * Признак вывода цифр года.
 * Creation date: (26.04.2002 20:08:40)
 * @param newShowtime boolean
 */
public void setShowyear(boolean newShowyear) {
	showyear = newShowyear;
}
}
