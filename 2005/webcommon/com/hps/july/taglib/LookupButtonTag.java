package com.hps.july.taglib;

import org.apache.struts.taglib.html.*;
import org.apache.struts.action.ActionFormBean;
import java.net.MalformedURLException;
import java.util.StringTokenizer;
import javax.servlet.http.*;
import org.apache.struts.util.*;
import javax.servlet.jsp.JspException;

/**
 * Кнопка вызова lookup-окна.
 * Creation date: (29.01.2002 11:54:33)
 * @author: Administrator
 */
public class LookupButtonTag
	extends org.apache.struts.taglib.html.BaseFieldTag
{
    private String width;
    private String height;
    private java.lang.String action;
    private java.lang.String fieldNames;
    private java.lang.String newWindowName;
    private java.lang.String insertable;
    private java.lang.String updatable;
    private java.lang.String onselect;
    private java.lang.String formname;
    private java.lang.String href;

    private java.lang.String image;
    private java.lang.String title;
	private java.lang.String top;
	private java.lang.String left;
    /**
     * Обработка открывающего тага
    */
    public int doStartTag() throws javax.servlet.jsp.JspException {

        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

        StringBuffer results = new StringBuffer("");

        // Look up the requested property value
        Object valueAction = null;
        try {
            valueAction = RequestUtils.lookup(pageContext, name, "action", "request");
        } catch (Exception e) {
            // Supress error
            valueAction = "Add";
        }

        if (width == null || "".equals(width)) {
            width = "830";
        }
        if (height == null || "".equals(height)) {
            height = "630";
        }
        if (top == null || "".equals(top)) {
            top = "40";
        }
        if (left == null || "".equals(left)) {
            left = "100";
        }

        if ("Add".equals(valueAction)) {
            if ("true".equals(insertable))
                results.append(prepareEditTag());
            else
                results.append(prepareViewTag());
        } else
            if ("Edit".equals(valueAction)) {
                if ("true".equals(updatable))
                    results.append(prepareEditTag());
                else
                    results.append(prepareViewTag());
            } else
                if ("Delete".equals(valueAction)) {
                    results.append(prepareViewTag());
                } else
                    if ("View".equals(valueAction)) {
                        results.append(prepareViewTag());
                    } else
                        results.append(prepareEditTag());

        // Print this field to our output writer
        ResponseUtils.write(pageContext, results.toString());

        // Continue processing this page
        return (EVAL_BODY_TAG);

    }
    /**
     * Получить параметр "Действие".
     * Creation date: (05.02.2002 10:45:19)
     * @return java.lang.String
     */
    public java.lang.String getAction() {
        return action;
    }
    /**
     * Имена полей, куда помещать результат.
     * Creation date: (05.02.2002 10:59:05)
     * @return java.lang.String
     */
    public java.lang.String getFieldNames() {
        return fieldNames;
    }
    /**
     * Имя формы, в которой искать поля.
     * Creation date: (26.08.2003 18:04:35)
     * @return java.lang.String
     */
    public java.lang.String getFormname() {
        return formname;
    }
    /**
     * Высота в пикселах
     * @return java.lang.String
     */
    public java.lang.String getHeight() {
        return height;
    }
    /**
     * URL, который вызывать.
     * Creation date: (01.10.2003 14:42:40)
     * @return java.lang.String
     */
    public java.lang.String getHref() {
        return href;
    }
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getImage() {
	return image;
}
    /**
     * Возвращает признак "доступно при добавлении".
     * Creation date: (24.05.2002 12:12:22)
     * @return java.lang.String
     */
    public java.lang.String getInsertable() {
        return insertable;
    }
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 16:01:57)
 * @return java.lang.String
 */
public java.lang.String getLeft() {
	return left;
}
    /**
     * Создавать lookup-окно с указанным именем.
     * Creation date: (25.04.2002 17:14:15)
     * @return java.lang.String
     */
    public java.lang.String getNewWindowName() {
        return newWindowName;
    }
    /**
     * Обработчик события "После выбора значения пользователем".
     * Creation date: (08.08.2003 14:48:30)
     * @return java.lang.String
     */
    public java.lang.String getOnselect() {
        return onselect;
    }
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getTitle() {
	return title;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 16:01:06)
 * @return java.lang.String
 */
public java.lang.String getTop() {
	return top;
}
    /**
     * Возвращает признак "доступно при изменении".
     * Creation date: (24.05.2002 12:12:49)
     * @return java.lang.String
     */
    public java.lang.String getUpdatable() {
        return updatable;
    }
    /**
     * Ширина в пикселах
     * @return java.lang.String
     */
    public java.lang.String getWidth() {
        return width;
    }
    /**
     * Подготовка тага к редактированию значения.
     * Creation date: (30.01.2002 10:44:20)
     */
    public String prepareEditTag() throws javax.servlet.jsp.JspException {

        StringBuffer results = new StringBuffer("<SCRIPT language=\"JScript\">");

        results.append(" var opt_params_" + getStyleId() + " = \"\"; ");

        results.append("function set_opt_params_" + getStyleId() + "(paramStr) {");
        results.append("  opt_params_" + getStyleId() + " = paramStr;");
        results.append("}");

        results.append("function onselect_" + getStyleId() + "() {");
        if (getOnselect() != null)
            results.append(getOnselect());
        results.append("}");

        results.append("function lookup_params_" + getStyleId() + "() {");
        String locformName = "thefirstform";
        if (getFormname() != null) {
            locformName = getFormname();
        } else {
            FormTag wrapper = (FormTag) findAncestorWithClass(this, EditFormTag.class);
            if (wrapper != null) {
                locformName = wrapper.getStyleId();
            } else {
                wrapper = (FormTag) findAncestorWithClass(this, BrowseFormTag.class);
                if (wrapper != null)
                    locformName = wrapper.getStyleId();
            }
        }
        results.append("  myWindow.execScript(\"setParams('" + locformName + "'");
        StringTokenizer st = new StringTokenizer(fieldNames, ";");
        while (st.hasMoreTokens())
            results.append(", '" + st.nextToken() + "'");
        results.append(")\");");
        results.append("  myWindow.execScript(\"setCallerId('" + getStyleId() + "'");
        results.append(")\");");
        results.append("  return 0;");
        results.append("}");

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        //String url = request.getContextPath() + getAction();
        String url = null;
        if (getAction() != null) {
            url = request.getContextPath() + getAction();
        } else
            if (getHref() != null) {
                url = getHref();
            } else {
                throw new JspException("action or href attributes must be defined!!");
            }

        if (getNewWindowName() == null)
            setNewWindowName("myWindow");

        results.append("function lookup_" + getStyleId() + "() {\n");
        results.append(
            "  if(document.all['lookupimg_"
                + getStyleId()
                + "'].src.substr(document.all['lookupimg_"
                + getStyleId()
                + "'].src.length-12,12) == 'disabled.gif') { return; } ");
        results.append(
            "  String.prototype.lookup = lookup_params_" + getStyleId() + ";");
        results.append(
            "  myWindow = window.open(\""
                + url
                + "\" + opt_params_"
                + getStyleId()
                + ", \""
                + getNewWindowName()
                + "\", \"top=" 
                + getTop()
                + ", left="
                + getLeft()
                + ", width="
                + getWidth()
                + ", height="
                + getHeight()
                + ", scrollbars=yes, resizable=yes\");");
        results.append("  myWindow.focus();");
        results.append("}");
        results.append("</SCRIPT>");

        if (getOnclick() != null) {
            results.append(
                "<A HREF=\"#\" name=\"lookupbtn_"
                    + getStyleId()
                    + "\" onclick=\""
                    + getOnclick()
                    + ";"
                    + "lookup_"
                    + getStyleId()
                    + "(); return false;\"><img name=\"lookupimg_"
                    + getStyleId()
                    + "\" src=\"/images/");
        } else {
            results.append(
                "<A HREF=\"#\" name=\"lookupbtn_"
                    + getStyleId()
                    + "\" onclick=\"lookup_"
                    + getStyleId()
                    + "(); return false;\"><img name=\"lookupimg_"
                    + getStyleId()
                    + "\" src=\"/images/");
        }
		if(getImage() != null && !"".equals(getImage())) {
			results.append(getImage()+".gif\" border=\"0\"");
		} else {
			results.append("lookup.gif\" border=\"0\"");
		}
		if(getTitle() != null && !"".equals(getTitle())) {
			results.append(" alt=\"");
			results.append(getTitle());
			results.append("\"></A>");
		} else {
			results.append(" alt=\"Справочник\"></A>");
		}

        return results.toString();
    }
    /**
     * Подготовка тага к просмотру значения
    */
    public String prepareViewTag() throws javax.servlet.jsp.JspException {
	    StringBuffer results = new StringBuffer();
	    if(getImage() != null && !"".equals(getImage())) {
			results.append("<img src=\"/images/");
			results.append(getImage());
			results.append("_disabled.gif");
			results.append("\" border=\"0\"");
	    } else {
			results.append("<img src=\"/images/lookup_disabled.gif\" border=\"0\"");
	    }
		if(getTitle() != null && !"".equals(getTitle())) {
			results.append(" alt=\"");
			results.append(getTitle());
			results.append("\"></A>");
		} else {
			results.append(" alt=\"Справочник\">");
		}

        return results.toString();
    }
    /**
     * Параметр "Действие".
     * Creation date: (05.02.2002 10:45:19)
     * @param newAction java.lang.String
     */
    public void setAction(java.lang.String newAction) {
        action = newAction;
    }
    /**
     * Имена полей, куда помещать результат.
     * Creation date: (05.02.2002 10:59:05)
     * @param newFieldNames java.lang.String
     */
    public void setFieldNames(java.lang.String newFieldNames) {
        fieldNames = newFieldNames;
    }
    /**
     * Имя формы, в которой искать поля.
     * Creation date: (26.08.2003 18:04:35)
     * @param newFormname java.lang.String
     */
    public void setFormname(java.lang.String newFormname) {
        formname = newFormname;
    }
    /**
     * Высота в пикселах
     * @param newHeight java.lang.String
     */
    public void setHeight(java.lang.String newHeight) {
        height = newHeight;
    }
    /**
     * URL, который вызывать.
     * Creation date: (01.10.2003 14:42:40)
     * @param newHref java.lang.String
     */
    public void setHref(java.lang.String newHref) {
        href = newHref;
    }
/**
 * 
 * @param newImage java.lang.String
 */
public void setImage(java.lang.String newImage) {
	image = newImage;
}
    /**
     * Устанавливает признак "доступно при добавлении".
     * Creation date: (24.05.2002 12:12:22)
     * @param newInsertable java.lang.String
     */
    public void setInsertable(java.lang.String newInsertable) {
        insertable = newInsertable;
    }
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 16:01:57)
 * @param newLeft java.lang.String
 */
public void setLeft(java.lang.String newLeft) {
	left = newLeft;
}
    /**
     * Создавать lookup-окно с указанным именем.
     * Creation date: (25.04.2002 17:14:15)
     * @param newNewWindowName java.lang.String
     */
    public void setNewWindowName(java.lang.String newNewWindowName) {
        newWindowName = newNewWindowName;
    }
    /**
     * Обработчик события "После выбора значения пользователем".
     * Creation date: (08.08.2003 14:48:30)
     * @param newOnselect java.lang.String
     */
    public void setOnselect(java.lang.String newOnselect) {
        onselect = newOnselect;
    }
/**
 * 
 * @param newTitle java.lang.String
 */
public void setTitle(java.lang.String newTitle) {
	title = newTitle;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 16:01:06)
 * @param newTop java.lang.String
 */
public void setTop(java.lang.String newTop) {
	top = newTop;
}
    /**
     * Устанавливает признак "доступно при изменении".
     * Creation date: (24.05.2002 12:12:49)
     * @param newUpdatable java.lang.String
     */
    public void setUpdatable(java.lang.String newUpdatable) {
        updatable = newUpdatable;
    }
    /**
     * Ширина в пикселах
     * @param newWidth java.lang.String
     */
    public void setWidth(java.lang.String newWidth) {
        width = newWidth;
    }
}
