package com.hps.july.taglib;

import com.hps.july.web.util.*;
import org.apache.struts.taglib.*;
import org.apache.struts.taglib.bean.*;
import java.net.*;
import java.net.MalformedURLException;
import java.util.*;
import java.lang.reflect.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;
import org.apache.struts.util.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForwards;
import org.apache.struts.action.ActionMapping;


/**
 * Таг ссылка.
 * Creation date: (23.05.2002 12:27:23)
 * @author: Dmitry Dneprov
 */
public class LinkTag extends org.apache.struts.taglib.html.LinkTag {
    private java.lang.String alttext;
    
	private java.lang.String type = "Edit";
	private java.lang.String selectable = "0";
	private java.lang.String modelName = "list";
	private java.lang.String returnable = "0";
    /**
     * Вычисление сообщения, выдаваемого при наведении мыши на ссылку.
     * Creation date: (10.01.2003 9:46:21)
     */
    public void alterTitle() throws javax.servlet.jsp.JspException {
        if (getAlttext() != null) {
            // Construct the optional arguments array we will be using
            Object args[] = new Object[5];
            args[0] = null;
            args[1] = null;
            args[2] = null;
            args[3] = null;
            args[4] = null;

            // Retrieve the message string we are looking for
            // System.out.println("### alterTitle() in getAlttext() = "+getAlttext() + " pageContext = " + pageContext + 
			// 					" Action.MESSAGES_KEY = "+Action.MESSAGES_KEY+" Action.LOCALE_KEY = "+Action.LOCALE_KEY);
			paranoidAlttextClining();					
			// System.out.println("### alterTitle() in++ getAlttext() = "+getAlttext() + " pageContext = " + pageContext + 
			// 					" Action.MESSAGES_KEY = "+Action.MESSAGES_KEY+" Action.LOCALE_KEY = "+Action.LOCALE_KEY);
            String message =
                RequestUtils.message(
                    pageContext,
                    Action.MESSAGES_KEY,
                    Action.LOCALE_KEY,
                    getAlttext(),
                    args);
			// System.out.println("### alterTitle() out message = "+message);
            setTitle(message);
        }
    }
    /**
	 * 
	 */
	private void paranoidAlttextClining() {
		StringBuffer sb = new StringBuffer();
		String theAlttext = getAlttext();
		for (int i = 0; i < theAlttext.length(); i++) {
			char curChar = theAlttext.charAt(i);
			if (curChar != '"') {
				sb.append(curChar);
			}
		}
		setAlttext(sb.toString());
	}
	/**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

	    StringBuffer onClickStr = new StringBuffer();
	    onClickStr.append("document.body.style.cursor='wait'; ");

	    String checkAction = null;
	    try {
		    Method method = this.getClass().getMethod("getType", new Class[] {});
		    if(method != null) {
			    checkAction = (String)method.invoke(this, new Object[] {});
		    }
	    } catch(Exception e) {}
	    if(checkAction != null) checkAction = checkAction.toLowerCase();

	    boolean selectableB = false;
	    try {
			selectableB = (getSelectable() != null && "1".equals(getSelectable()))?true:false;
			modelName = getModelName();
			if(!selectableB || modelName == null) {
		    SelectableTableTag wrapper = (SelectableTableTag)findAncestorWithClass(this, SelectableTableTag.class);
			    if(wrapper != null) {
				    selectableB = (wrapper.getSelectable() != null && "1".equals(wrapper.getSelectable()))?true:false;
					modelName = wrapper.getModelName();
			    }
			}
	    } catch(Exception e) {}
	    if(modelName == null) modelName = "list";
	    if(selectableB) {
		    if("add".equalsIgnoreCase(this.getType())) {
			    onClickStr.append("try { ");
			    onClickStr.append("var href = this.getAttributeNode('href'); if(" + modelName + ") { href.value=" + modelName + ".getProfileString(href.value, '" + checkAction + "'); } } catch(e){} ");
		    } else {
			    onClickStr.append("try { var parentElement = this.parentNode; var c = 1; while((parentElement.nodeName != 'TR') || c > 5) { parentElement = parentElement.parentNode; c++; } if(" + modelName + ") { " + modelName + ".setRowSelected(parentElement); } ");
			    onClickStr.append("var href = this.getAttributeNode('href'); if(" + modelName + ") { href.value=" + modelName + ".getProfileString(href.value, '" + checkAction + "'); } } catch(e){} ");
		    }
	    }

        if (getOnclick() != null)
            setOnclick(onClickStr.toString() + getOnclick());
        else
            setOnclick(onClickStr.toString());

        alterTitle();

        // Copied from struts link tag & modified
        // Special case for name anchors
        if (linkName != null) {
            StringBuffer results = new StringBuffer("<a name=\"");
            results.append(linkName);
            results.append("\">");
            ResponseUtils.write(pageContext, results.toString());
            return (EVAL_BODY_TAG);
        }

        Map params = null;

        //System.out.println("JULY:LINK #1");
        // Look up the requested bean (if necessary)
        Object bean = null;
        if (getParamName() != null) {
	         bean = RequestUtils.lookup(pageContext, getParamName(), getParamScope());
	        //System.out.println("JULY:LINK #2");
	         if (bean == null)
	                return (SKIP_BODY);  // Nothing to output
        }
        //System.out.println("JULY:LINK #3");
		        
        // Look up the requested property value
        if ( (bean != null) && (bean instanceof com.hps.july.cdbc.lib.CDBCRowObject)) {
        	//System.out.println("JULY:LINK #4");
	        Object value = ((com.hps.july.cdbc.lib.CDBCRowObject)bean).getColumn(getParamProperty()).asString();
	        params = new HashMap();
	        params.put(getParamId(), value);
        	//System.out.println("JULY:LINK #5");
        } else {
		// Generate the hyperlink URL
        	//System.out.println("JULY:LINK #6");
	        params = RequestUtils.computeParameters
	            (pageContext, getParamId(), getParamName(), getParamProperty(), getParamScope(),
	             getName(), getProperty(), getScope(), getTransaction());
        }
	            
        //System.out.println("JULY:LINK #7");
        HttpServletRequest request =
            (HttpServletRequest) pageContext.getRequest();
		Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
		StringBuffer anchor = null;
		if(profile != null) {
			try {
		        StringBuffer url = new StringBuffer();
		        if (getForward() != null) {
		            ActionForwards forwards = (ActionForwards)
		                pageContext.getAttribute(Action.FORWARDS_KEY,
		                                         PageContext.APPLICATION_SCOPE);
		            if (forwards == null)
		                throw new MalformedURLException
		                    (messages.getMessage("computeURL.forwards"));
		            ActionForward af = forwards.findForward(getForward());
		            if (af == null)
		                throw new MalformedURLException
		                    (messages.getMessage("computeURL.forward", forward));
		            if (af.getPath().startsWith("/"))
		                url.append(request.getContextPath());
		            url.append(af.getPath());
		        } else if (getHref() != null) {
		            url.append(getHref());
		        } else {
		            url.append(request.getContextPath());
		            url.append(getPage());
		        }
		        //System.out.println("LINK ------ ["+url.toString()+"]");
		        String result = url.toString();
		        int c = url.toString().indexOf("?");
		        if(c != -1) {
			        result = result.substring(0, c);
		        }
		        c = result.indexOf(".do");
		        if(c != -1) {
			        result = result.substring(0, c);
		        }
		        //System.out.println("LINK RESULT -------- ["+result+"]");
				String anchorName = profile.getSelectableAnchor(result);
				if(anchorName != null) {
					String anchorValue = profile.getSelectableCurrentParameter(result, anchorName);
					if(anchorValue != null) {
						//System.out.println("ANCHOR -------------- ["+(anchorName + anchorValue)+"]");
						setAnchor(anchorName + anchorValue);
					}
					
				}
				
			} catch(Exception e) {
		        System.out.println("Error !!!!!!!!!!!!1 " + e.toString());
		        e.printStackTrace();
			}
		}
        
        String url = null;
        try {
            url = RequestUtils.computeURL(pageContext, getForward(), getHref(),
                                          getPage(), params, getAnchor(), false);
        } catch (MalformedURLException e) {
            RequestUtils.saveException(pageContext, e);
            throw new JspException
                (messages.getMessage("rewrite.url", e.toString()));
        }

        //System.out.println("JULY:LINK #8");
	        // Generate the opening anchor element
	        StringBuffer results = new StringBuffer("<a href=\"");
	        results.append(url);
	        results.append("\"");
		if (getTarget() != null) {
		    results.append(" target=\"");
		    results.append(getTarget());
		    results.append("\"");
		}
	        results.append(prepareStyles());
	        results.append(prepareEventHandlers());
		results.append(">");

        //System.out.println("JULY:LINK #9");
		// Print this element to our output writer
	        ResponseUtils.write(pageContext, results.toString());

		// Evaluate the body of this tag
	        this.text = null;
		return (EVAL_BODY_TAG);

    }
    /**
     * key сообщения, выдаваемого при наведении мыши.
     * Creation date: (26.06.2002 12:03:44)
     * @return java.lang.String
     */
    public java.lang.String getAlttext() {
        return alttext;
    }
/**
 * Insert the method's description here.
 * Creation date: (15.09.2004 15:52:40)
 * @return java.lang.String
 */
public java.lang.String getModelName() {
	return modelName;
}
/**
 * Insert the method's description here.
 * Creation date: (24.09.2004 18:11:37)
 * @return java.lang.String
 */
public java.lang.String getReturnable() {
	return returnable;
}
/**
 * Insert the method's description here.
 * Creation date: (15.09.2004 15:52:11)
 * @return java.lang.String
 */
public java.lang.String getSelectable() {
	return selectable;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 17:27:29)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
    /**
     * key сообщения, выдаваемого при наведении мыши.
     * Creation date: (26.06.2002 12:03:44)
     * @param newAlttext java.lang.String
     */
    public void setAlttext(java.lang.String newAlttext) {
        alttext = newAlttext;
    }
/**
 * Insert the method's description here.
 * Creation date: (15.09.2004 15:52:40)
 * @param newModelName java.lang.String
 */
public void setModelName(java.lang.String newModelName) {
	modelName = newModelName;
}
/**
 * Insert the method's description here.
 * Creation date: (24.09.2004 18:11:37)
 * @param newReturnable java.lang.String
 */
public void setReturnable(java.lang.String newReturnable) {
	if(newReturnable != null && ("1".equals(newReturnable) || "true".equals(newReturnable))) {
		returnable = "1";
	} else returnable = "0";
}
/**
 * Insert the method's description here.
 * Creation date: (15.09.2004 15:52:11)
 * @param newSelectable java.lang.String
 */
public void setSelectable(java.lang.String newSelectable) {
	if(newSelectable != null && ("1".equals(newSelectable) || "true".equals(newSelectable))) {
		selectable = "1";
	} else selectable = "0";
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 17:27:29)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
