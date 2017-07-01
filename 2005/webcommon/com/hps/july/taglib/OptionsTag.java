package com.hps.july.taglib;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.util.IteratorAdapter;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.PropertyUtils;
import org.apache.struts.util.ResponseUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;


/**
 * Таг для отображения опций внутри тага <SELECT>.
 * Отличается от родителя поддержкой дополнительного атрибута
 * для каждой опции.
 * Tag for creating multiple &lt;select&gt; options from a collection.  The
 * associated values displayed to the user may optionally be specified by a
 * second collection, or will be the same as the values themselves.  Each
 * collection may be an array of objects, a Collection, an Enumeration,
 * an Iterator, or a Map.
 * <b>NOTE</b> - This tag requires a Java2 (JDK 1.2 or later) platform.
 * Добавлена поддержка CDBCResultSet
 *
 * @author Florent Carpentier
 * @author Craig McClanahan
 * @author Dmitry Dneprov
 */

public class OptionsTag extends org.apache.struts.taglib.html.OptionsTag {
	private java.lang.String addProperty;
	/**
	 * Обработка закрывающего тага
	*/	
    public int doEndTag() throws JspException {

	// Acquire the select tag we are associated with
	SelectTag selectTag =
	  (SelectTag) pageContext.getAttribute(org.apache.struts.taglib.html.Constants.SELECT_KEY);
	if (selectTag == null)
	    throw new JspException
	        (messages.getMessage("optionsTag.select"));
	        
	StringBuffer sbval = new StringBuffer();
	StringBuffer sb = new StringBuffer();

        // If a collection was specified, use that mode to render options
        if (collection != null) {
            Iterator collIterator = getIterator(collection, null);
            while (collIterator.hasNext()) {

                Object bean = collIterator.next();
                Object value = null;
                Object label = null;
                Object addValue = null;

                if (bean instanceof com.hps.july.cdbc.lib.CDBCRowObject) {
	                value = ((com.hps.july.cdbc.lib.CDBCRowObject)bean).getColumn(property).asString();
	                if (labelProperty != null)
	                	label = ((com.hps.july.cdbc.lib.CDBCRowObject)bean).getColumn(labelProperty).asString();
	                else
	                	label = value;
	                if (addProperty != null)
	                	addValue = ((com.hps.july.cdbc.lib.CDBCRowObject)bean).getColumn(addProperty).asString();
                } else {
	                try {
	                    value = PropertyUtils.getProperty(bean, property);
	                    if (value == null)
	                        value = "";
	                } catch (IllegalAccessException e) {
	                    throw new JspException
	                        (messages.getMessage("getter.access",
	                                             property, collection));
	                } catch (InvocationTargetException e) {
	                    Throwable t = e.getTargetException();
	                    throw new JspException
	                        (messages.getMessage("getter.result",
	                                             property, t.toString()));
	                } catch (NoSuchMethodException e) {
	                    throw new JspException
	                        (messages.getMessage("getter.method",
	                                             property, collection));
	                }

	                try {
	                    if (labelProperty != null)
	                        label =
	                            PropertyUtils.getProperty(bean, labelProperty);
	                    else
	                        label = value;
	                    if (label == null)
	                        label = "";
	                } catch (IllegalAccessException e) {
	                    throw new JspException
	                        (messages.getMessage("getter.access",
	                                             labelProperty, collection));
	                } catch (InvocationTargetException e) {
	                    Throwable t = e.getTargetException();
	                    throw new JspException
	                        (messages.getMessage("getter.result",
	                                             labelProperty, t.toString()));
	                } catch (NoSuchMethodException e) {
	                    throw new JspException
	                        (messages.getMessage("getter.method",
	                                             labelProperty, collection));
	                }

	                try {
	                    if (addProperty != null)
	                        addValue =
	                            PropertyUtils.getProperty(bean, addProperty);
	                } catch (IllegalAccessException e) {
	                    throw new JspException
	                        (messages.getMessage("getter.access",
	                                             labelProperty, collection));
	                } catch (InvocationTargetException e) {
	                    Throwable t = e.getTargetException();
	                    throw new JspException
	                        (messages.getMessage("getter.result",
	                                             labelProperty, t.toString()));
	                } catch (NoSuchMethodException e) {
	                    throw new JspException
	                        (messages.getMessage("getter.method",
	                                             labelProperty, collection));
	                }
	                
	           }

                String stringValue = value.toString();
                addOption(sb, stringValue, label.toString(),
                          selectTag.isMatched(stringValue));

                sbval.append(""+getCollection()+"_arr['"+stringValue+"'] = '"+addValue+"';\n");

            }

        }

        // Otherwise, use the separate iterators mode to render options
        else {

              // Construct iterators for the values and labels collections
              Iterator valuesIterator = getIterator(name, property);
              Iterator labelsIterator = null;
              if ((labelName == null) && (labelProperty == null))
                  labelsIterator = getIterator(name, property); // Same coll.
              else
                  labelsIterator = getIterator(labelName, labelProperty);

              // Render the options tags for each element of the values coll.
              while (valuesIterator.hasNext()) {
                  String value = valuesIterator.next().toString();
                  String label = value;
                  if (labelsIterator.hasNext())
                      label = labelsIterator.next().toString();
                  addOption(sb, value, label,
                            selectTag.isMatched(value));
         	  }
		}

        // Add additional array with properties
        if (addProperty != null) {
			sb.append("<script language=\"javascript\">\n");
			sb.append("var "+getCollection()+"_arr = new Array();\n");
		
			sb.append(sbval);
			sb.append("</script>");
        }
        
		// Render this element to our writer
        ResponseUtils.write(pageContext, sb.toString());

        // Evaluate the remainder of this page
	return EVAL_PAGE;

    }
/**
 * Имя дополнительного атрибута.
 * Creation date: (12.04.2004 15:25:58)
 * @return java.lang.String
 */
public java.lang.String getAddProperty() {
	return addProperty;
}
    /**
     * Return an iterator for the option labels or values, based on our
     * configured properties.
     *
     * @param name Name of the bean attribute (if any)
     * @param property Name of the bean property (if any)
     *
     * @exception JspException if an error occurs
     */
    protected Iterator getIterator(String name, String property)
        throws JspException {

	// Identify the bean containing our collection
	String beanName = name;
	if (beanName == null)
	    beanName = org.apache.struts.taglib.html.Constants.BEAN_KEY;
	Object bean = pageContext.findAttribute(beanName);
	if (bean == null)
	    throw new JspException
	        (messages.getMessage("getter.bean", beanName));

	// Identify the collection itself
	Object collection = bean;
	if (property != null) {
	    try {
		collection = PropertyUtils.getProperty(bean, property);
                if (collection == null)
                    throw new JspException
                        (messages.getMessage("getter.property", property));
	    } catch (IllegalAccessException e) {
		throw new JspException
		    (messages.getMessage("getter.access", property, name));
	    } catch (InvocationTargetException e) {
		Throwable t = e.getTargetException();
		throw new JspException
		    (messages.getMessage("getter.result",
					 property, t.toString()));
	    } catch (NoSuchMethodException e) {
		throw new JspException
		    (messages.getMessage("getter.method", property, name));
	    }
	}

	// Construct and return an appropriate iterator
	if (collection.getClass().isArray())
	    collection = Arrays.asList((Object[]) collection);
	if (collection instanceof Collection)
	    return (((Collection) collection).iterator());
	else if (collection instanceof Iterator)
	    return ((Iterator) collection);
	else if (collection instanceof Map)
	    return (((Map) collection).entrySet().iterator());
    else if (collection instanceof Enumeration)
	    return( new IteratorAdapter((Enumeration)collection));
	else if (collection instanceof com.hps.july.cdbc.lib.CDBCResultSet)
		return ((com.hps.july.cdbc.lib.CDBCResultSet)collection).listIterator();
	else
	    throw new JspException
	        (messages.getMessage("optionsTag.iterator",
	                             collection.toString()));

    }
/**
 * Имя дополнительного атрибута.
 * Creation date: (12.04.2004 15:25:58)
 * @param newAddProperty java.lang.String
 */
public void setAddProperty(java.lang.String newAddProperty) {
	addProperty = newAddProperty;
}
}
