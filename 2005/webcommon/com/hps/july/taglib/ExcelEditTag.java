package com.hps.july.taglib;

import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.http.*;
import org.apache.struts.util.*;
/**
 * “аг дл€ редактировани€ файла в формате MS-Word - использует ActiveX.
 * Creation date: (29.04.2002 13:43:45)
 * @author: Dmitry Dneprov
 */
public class ExcelEditTag extends javax.servlet.jsp.tagext.TagSupport {
	private java.lang.String styleId;
	private java.lang.String url;
	private java.lang.String uploadurl;
	private java.lang.String documentid;
	private java.lang.String addurl;
	private java.lang.String updatable;
	private java.lang.String beforeclick;
/**
 * ExcelEditTag constructor.
 */
public ExcelEditTag() {
	super();
}
	/**
	 * ќбработка закрывающего тага
	*/	
    public int doEndTag() throws JspException {

		StringBuffer results = new StringBuffer("");
		results.append("</A>");

		// Print this field to our output writer
		ResponseUtils.write(pageContext, results.toString());
		
	 	// Continue processing this page
		return (EVAL_PAGE);

    }
		/**
		 * ќбработка открывающего тага
		*/	
		public int doStartTag() throws javax.servlet.jsp.JspException {

			HttpServletResponse response =
			  (HttpServletResponse) pageContext.getResponse();
			HttpServletRequest request =
			  (HttpServletRequest) pageContext.getRequest();
			  
			StringBuffer results = new StringBuffer("");
			String serverUrl = "http://" + request.getServerName() + request.getContextPath() + "/";

			String jsessionid = getCookie(request, "JSESSIONID");
			String ltpatoken = getCookie(request, "LtpaToken");
			if ((getUpdatable() == null) || (getUpdatable().trim().length() == 0))
				setUpdatable("true");

			results.append("<SPAN style='display:none; visibility: hidden;'><OBJECT  ID=\"" + getStyleId() + "\" WIDTH=1 HEIGHT=1 ");
        	results.append(" CODEBASE=\"/nriexcel.cab\" \r\n");
			results.append("CLASSID=\"CLSID:7653B4F8-415E-4108-98C1-A7E92851E750\">\r\n");
			results.append("</OBJECT></SPAN>\r\n");
			results.append("<SCRIPT language='JavaScript'>\r\n");
			
			results.append("function " + getStyleId() + "_bclck() { \r\n");
			if (getBeforeclick() != null)
				results.append(getBeforeclick());
			results.append("return true; \r\n");
			results.append("} \r\n");
			
			results.append("function " + getStyleId() + "_call() { \r\n");
			results.append("   if (document.all." + getStyleId() + ") if (document.all." + getStyleId() + ".oversion == \"1\") {document.all." +
				getStyleId() + ".callexcelauth(\"" + serverUrl + getUrl() + "\", \"" + serverUrl + getUploadurl() + "\", \"" + 
				getDocumentid() + "\", \"" + jsessionid + "\", \"" + ltpatoken + "\", \"");
			if ( (getAddurl() == null) || (getAddurl().trim().length() == 0) )
				results.append("");
			else
				results.append(getAddurl());
			results.append("\", \"" + getUpdatable() + "\"); return false; } \r\n return true; }\r\n");
			results.append("</SCRIPT>\r\n");
			
			results.append("<A HREF=\"" + serverUrl + getUrl() + "\" ");

			results.append(" onclick='if (!"+ getStyleId() + "_bclck()) return false; document.body.style.cursor=\"wait\"; var res = " + getStyleId() + "_call(); ");
			results.append(" document.body.style.cursor=\"normal\"; return res;'>");

			// Print this field to our output writer
		    ResponseUtils.write(pageContext, results.toString());

			// Continue processing this page
			return (EVAL_BODY_INCLUDE);

		}
/**
 * URL дл€ подгрузки дополнительных файлов.
 * Creation date: (02.02.2004 15:31:22)
 * @return java.lang.String
 */
public java.lang.String getAddurl() {
	return addurl;
}
/**
 * JavaScript to execute before calling word. Return false from javascript to prevent calling word.
 * Creation date: (06.02.2004 15:26:14)
 * @return java.lang.String
 */
public java.lang.String getBeforeclick() {
	return beforeclick;
}
/**
 * Returns cookie from request.
 * Creation date: (26.01.2004 18:06:04)
 * @return java.lang.String
 */
private String getCookie(HttpServletRequest request, String name) {
    javax.servlet.http.Cookie[] cookies = request.getCookies();
     for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals(name))
            return cookies[i].getValue();
    }
     return "";
}
/**
 * ”никальный идентификатор документа, который будет передаватьс€ на сервер при сохранении.
 * Creation date: (23.01.2004 14:55:20)
 * @return java.lang.String
 */
public java.lang.String getDocumentid() {
	return documentid;
}
/**
 * јтрибут ID дл€ обращени€ к тагу из JavaScript.
 * Creation date: (23.01.2004 14:50:36)
 * @return java.lang.String
 */
public java.lang.String getStyleId() {
	return styleId;
}
/**
 * ѕризнак "доступно при изменении".
 * Creation date: (04.02.2004 13:23:38)
 * @return java.lang.String
 */
public java.lang.String getUpdatable() {
	return updatable;
}
/**
 * URL дл€ обратной загрузки документа после редактировани€ пользователем.
 * ƒокумент передаетс€ на этот URL после нажати€ пользователем кнопки
 * "—охранить в NRI".
 * Creation date: (23.01.2004 14:55:04)
 * @return java.lang.String
 */
public java.lang.String getUploadurl() {
	return uploadurl;
}
/**
 * URL дл€ получени€ документа и последующего отображени€ в Microsoft Word.
 * Creation date: (23.01.2004 14:54:38)
 * @return java.lang.String
 */
public java.lang.String getUrl() {
	return url;
}
/**
 * URL дл€ подгрузки дополнительных файлов.
 * Creation date: (02.02.2004 15:31:22)
 * @param newAddurl java.lang.String
 */
public void setAddurl(java.lang.String newAddurl) {
	addurl = newAddurl;
}
/**
 * JavaScript to execute before calling word. Return false from javascript to prevent calling word.
 * Creation date: (06.02.2004 15:26:14)
 * @param newBeforeclick java.lang.String
 */
public void setBeforeclick(java.lang.String newBeforeclick) {
	beforeclick = newBeforeclick;
}
/**
 * ”никальный идентификатор документа, который будет передаватьс€ на сервер при сохранении.
 * Creation date: (23.01.2004 14:55:20)
 * @param newDocumentid java.lang.String
 */
public void setDocumentid(java.lang.String newDocumentid) {
	documentid = newDocumentid;
}
/**
 * јтрибут ID дл€ обращени€ к тагу из JavaScript.
 * Creation date: (23.01.2004 14:50:36)
 * @param newStyleId java.lang.String
 */
public void setStyleId(java.lang.String newStyleId) {
	styleId = newStyleId;
}
/**
 * ”станавливает признак "доступно при изменении".
 * Creation date: (04.02.2004 13:23:38)
 * @param newUpdatable java.lang.String
 */
public void setUpdatable(java.lang.String newUpdatable) {
	updatable = newUpdatable;
}
/**
 * URL дл€ обратной загрузки документа после редактировани€ пользователем.
 * ƒокумент передаетс€ на этот URL после нажати€ пользователем кнопки
 * "—охранить в NRI".
 * Creation date: (23.01.2004 14:55:04)
 * @param newUploadurl java.lang.String
 */
public void setUploadurl(java.lang.String newUploadurl) {
	uploadurl = newUploadurl;
}
/**
 * URL дл€ получени€ документа и последующего отображени€ в Microsoft Word.
 * Creation date: (23.01.2004 14:54:38)
 * @param newUrl java.lang.String
 */
public void setUrl(java.lang.String newUrl) {
	url = newUrl;
}
}
