package com.hps.july.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.util.PropertyUtils;
import org.apache.struts.util.RequestUtils;
import org.apache.struts.util.ResponseUtils;

/**
 * Таг вывода суммы с форматированием.
 * Creation date: (26.04.2002 19:38:43)
 * @author: Dmitry Dneprov
 */
public class SumWriteTag extends org.apache.struts.taglib.bean.WriteTag {
/**
 * Constructor.
 * Creation date: (26.04.2002 20:10:31)
 */
public SumWriteTag() {
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
	        String output = com.hps.july.util.AppUtils.formatCurrency((java.math.BigDecimal)value);
			output = ResponseUtils.filter(output);
			output = com.hps.july.util.AppUtils.replaceSpaces2Nbsp(output);
	        ResponseUtils.write(pageContext, output);
        } else {
            return (SKIP_BODY);  // Nothing to output
        }

	// Continue processing this page
	return (SKIP_BODY);

    }
}
