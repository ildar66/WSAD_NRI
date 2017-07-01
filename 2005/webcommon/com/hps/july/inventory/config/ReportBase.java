package com.hps.july.inventory.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;

import com.hps.july.cdbc.objects.CDBCOperatorObject;
import com.hps.july.web.util.StringAndIntegerProperty;

/**
 * Базовые сервисы для подготовки отчетов по ФК БС
 * @author dima
 *
 */
public abstract class ReportBase extends Action {

	protected int getIntParam(HttpServletRequest request, String configParam) {
		StringAndIntegerProperty si = new StringAndIntegerProperty();
		si.setString(request.getParameter(configParam));
		int config = 0;
		if (si.isOk() && !si.isEmpty()) 
			config = si.getInteger().intValue();
		return config;
	}
	
	protected String getReportDate(HttpServletRequest request) {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		String result = df.format(new Date());
		return result;
	}

	protected String getUserName(HttpServletRequest request) {
		String result = "";
		result = CDBCOperatorObject.findFullNameByOperator(request.getRemoteUser());
		return result;
	}
	
}
