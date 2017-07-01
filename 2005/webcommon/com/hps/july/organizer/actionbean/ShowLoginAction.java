package com.hps.july.organizer.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action; 
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.constants.Applications;
import com.hps.july.organizer.APPStates;
import com.hps.july.web.util.ParamsParser;

/**
 * Действие по показу экрана запроса имени пользователя / пароля.
 * Creation date: (15.01.2002 16:54:13)
 * @author: Administrator
 */
public class ShowLoginAction extends org.apache.struts.action.Action {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
	  	ParamsParser.setState( request, Applications.ORGANIZER, APPStates.LOGIN );
		return mapping.findForward( "main" );
	}
}
