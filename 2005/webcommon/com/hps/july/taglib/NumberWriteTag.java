package com.hps.july.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.util.PropertyUtils;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

/**
 * Таг форматированного вывода числового значения.
 * Creation date: (26.04.2002 19:38:43)
 * @author: Dmitry Dneprov
 */
public class NumberWriteTag extends org.apache.struts.taglib.bean.WriteTag {
	private java.lang.String fractdigits;
/**
 * Constructor.
 * Creation date: (26.04.2002 20:10:31)
 */
public NumberWriteTag() {
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

        if (value != null && value instanceof java.math.BigDecimal) {
		    // Print this property value to our output writer, suitably filtered
		    String output = "";
			if ( (getFractdigits() != null) && (getFractdigits().length() > 0) ) {
				int iDigits = 0;
				try {
					iDigits = Integer.parseInt(getFractdigits());
				} catch (Exception e) {
					iDigits = 4;
				}
				output = com.hps.july.util.AppUtils.formatBigDecimal((java.math.BigDecimal)value,iDigits);
			} else {
				output = com.hps.july.util.AppUtils.formatBigDecimal((java.math.BigDecimal)value);
			}
			output = ResponseUtils.filter(output);
			output = com.hps.july.util.AppUtils.replaceSpaces2Nbsp(output);
	        ResponseUtils.write(pageContext, output);
        } else {
            return (SKIP_BODY);  // Nothing to output
        }

	// Continue processing this page
	return (SKIP_BODY);

    }
/**
 * Количество знаков после запятой.
 * Creation date: (06.06.2003 11:15:15)
 * @return java.lang.String
 */
public java.lang.String getFractdigits() {
	return fractdigits;
}
/**
 * Количество знаков после запятой.
 * Creation date: (06.06.2003 11:15:15)
 * @param newFractdigits java.lang.String
 */
public void setFractdigits(java.lang.String newFractdigits) {
	fractdigits = newFractdigits;
}
}
