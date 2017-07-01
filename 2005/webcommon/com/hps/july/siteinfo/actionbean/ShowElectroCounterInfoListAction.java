package com.hps.july.siteinfo.actionbean;

import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.EnvironmentAccessBean;
import com.hps.july.siteinfo.formbean.ElectroCounterListForm;
import com.hps.july.siteinfo.valueobject.ElectroCounter;
import com.hps.july.siteinfo.APPStates;
import com.hps.july.constants.Applications;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.naming.Context;
import java.io.IOException;

/**
 * Обработчик списка моделей электросчётчиков.
 * Основная функция создание списка электросчётчиков с сохранением сессии.
 * Creation date: (18.08.2004 14:36:23)
 * @author: Vadim Glushkov
 */
public class ShowElectroCounterInfoListAction extends com.hps.july.web.util.BrowseAction {
	/**
	 * Возвращает имя bean для броуза - устарело, надо использовать такой же метод в BrowseForm.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCElectroCounterObject";
	}
	/**
	 * Определяет кол-во строк на странице.
	 * Creation date: (22.01.2002 17:12:04)
	 * @return int
	 */
	public int getRowsOnPage() {
		return -1;
	}
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
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		ParamsParser.setState( request, Applications.SITEINFO, APPStates.ELECTRO_COUNTER_INFO_LIST);
	    super.perform(mapping, form, request, response);

	    return mapping.findForward( "main" );
	}
}
