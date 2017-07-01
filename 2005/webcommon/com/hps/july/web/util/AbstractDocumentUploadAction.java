package com.hps.july.web.util;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Action, который обрабатывает загрузку документа (Document UPLOAD).
 * Creation date: (20.01.2004 18:38:14)
 * @author: Dmitry Dneprov
 */
public abstract class AbstractDocumentUploadAction extends org.apache.struts.action.Action {
 
    /**
     * Основной метод обработки запроса.
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet exception occurs
     */
    public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

		String result = storeInDatabase(mapping, (DocumentUploadForm)form, request, response);
		if (result != null)
			response.sendError(response.SC_INTERNAL_SERVER_ERROR, result);
        return (null);  
    }
	/**
		Этот метод необъодимо перекрыть и записать полученный blob в базу данных.
		Возвращаемое значение: null - все хорошо,
			String - расшифровка сообщения об ошибке для показа пользователю
	*/	

	public abstract String storeInDatabase(ActionMapping mapping,
				 DocumentUploadForm form,
				 HttpServletRequest request,
				 HttpServletResponse response);
}
